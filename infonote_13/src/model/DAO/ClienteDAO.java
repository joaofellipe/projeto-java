package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Cliente;
import util.Conexao;
import util.Configurador;

public class ClienteDAO {
	Configurador config = new Configurador();
	String url;
	String driver;
	String login;
	String senha;

	public ClienteDAO() {
		url = config.getUrl();
		driver = config.getDriver();
		login = config.getLogin();
		senha = config.getSenha();
	}

	public static Cliente inserir(String login, String senha, int tipo, String codigoCliente, String nome, String email,
			String telefone) {
		Cliente cliente = null;
		ClienteDAO cliDAO = new ClienteDAO();
		try {
			// Criação do insert
			String sql = "insert into cliente " + "(codigocliente, nome, email, telefone, fklogin) "
					+ "values (?,?,?,?,?)";
			// Obter a conexão com o banco de dados
			Conexao conex = new Conexao(cliDAO.url, cliDAO.driver, cliDAO.login, cliDAO.senha);
			// Abrir a conexão
			Connection con = conex.obterConexao();
			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, codigoCliente);
			comando.setString(2, nome);
			comando.setString(3, email);
			comando.setString(4, telefone);
			comando.setString(5, login);
			// não é fklogin, porque aqui a referência é da Classe
			// Comando executado
			comando.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		cliente = new Cliente(login, senha, tipo, codigoCliente, nome, email, telefone);
		return cliente;
	}

	public static Cliente buscarPorLoginSenha(String login, String senha) {
		Cliente cliente = null;
		ClienteDAO cliDAO = new ClienteDAO();
		try {
			String sql = "Select * from usuario u, cliente c " + "where u.login=c.fklogin and u.login = ? "
					+ "and u.senha = ?";
			Conexao conex = new Conexao(cliDAO.url, cliDAO.driver, cliDAO.login, cliDAO.senha);
			Connection con = conex.obterConexao();
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, login);
			comando.setString(2, senha);
			ResultSet rs = comando.executeQuery();
			if (rs.next()) {
				cliente = new Cliente(rs.getString("login"), rs.getString("senha"), rs.getInt("tipo"),
						rs.getString("codigocliente"), rs.getString("nome"), rs.getString("email"),
						rs.getString("telefone"));
			}
			rs.close();
			comando.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cliente;
	}
}
