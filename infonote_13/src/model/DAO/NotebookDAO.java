package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Notebook;
import util.Conexao;
import util.Configurador;

public class NotebookDAO {
	Configurador config = new Configurador();
	String url;
	String driver;
	String login;
	String senha;

	public NotebookDAO() {
		url = config.getUrl();
		driver = config.getDriver();
		login = config.getLogin();
		senha = config.getSenha();
	}

	public static Notebook inserir(String serialNote, String modelo, String descricao, int estoque,
			double precoUnitario, String figura, String dataCadastro) {
		Notebook notebook = null;
		NotebookDAO notDAO = new NotebookDAO();
		try {
			// Cria��o do insert
			String sql = "insert into usuario (login, senha, tipo) values (?,?,?)";
			// Obter a conex�o com o banco de dados
			Conexao conex = new Conexao(notDAO.url, notDAO.driver, notDAO.login, notDAO.senha);
			// Abrir a conex�o
			Connection con = conex.obterConexao();
			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, serialNote);
			comando.setString(2, modelo);
			comando.setString(3, descricao);
			comando.setInt(4, estoque);
			comando.setDouble(5, precoUnitario);
			comando.setString(6, figura);
			comando.setString(7, dataCadastro);
			// Comando executado
			comando.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		notebook = new Notebook(serialNote, modelo, descricao, estoque, precoUnitario, figura, dataCadastro);

		return notebook;

	}

	public static Notebook excluir(int id) {
		Notebook notebook = null;
		try {
			// Cria��o do insert
			String sql = "delete from contato where id = ?";
			// Obter a conex�o com o banco de dados
			Conexao conex = new Conexao("jdbc:mysql://localhost:3306/infonote_13?useTimezone=true&serverTimezone=UTC",
					"com.mysql.cj.jdbc.Driver", "jeffrey", "password");
			// Abrir a conex�o
			Connection con = conex.obterConexao();
			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setInt(1, id);
			comando.executeUpdate();

			// Comando executado
			comando.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return notebook;
	}

	public static Notebook[] buscarTodos() {
		Notebook[] notebook = null;
		try {
			// Cri��o do select
			String sql = "Select * from contato";
			// Obter a conex�o com o banco de dados
			Conexao conex = new Conexao("jdbc:mysql://localhost:3306/18_conexaobd?useTimezone=true&serverTimezone=UTC",
					"com.mysql.cj.jdbc.Driver", "jeffrey", "password");
			Connection con = conex.obterConexao();
			/*
			 * Executa a confirma��o direta de acesso ao banco pois n�o s�o necess�rias
			 * informa��es para a Query (caracter curinga)
			 */
			Statement comando = con.createStatement();
			/*
			 * ResultSet - Classe java que monta em mem�ria uma matriz com a resposta das
			 * linhas do banco de dados
			 */
			ResultSet rs = comando.executeQuery(sql);
			// vetor de objetos
			notebook = new Notebook[10];
			/*
			 * Passagem de linha de dados do ResultSet para o vetor de objetos (uma linha de
			 * dados da matriz do ResultSet � copiada para um objeto no vetor contatos)
			 */
			int i = 0;
			while (rs.next()) {
				notebook[i++] = new Notebook(rs.getString("serialNote"), rs.getString("modelo"),
						rs.getString("descricao"), rs.getInt("estoque"), rs.getDouble("precoUnitario"),
						rs.getString("figura"), rs.getString("dataCadastro"));
			}
			// � necess�rio encerrar o acesso ao banco para liberar a conex�o
			rs.close();
			comando.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return notebook;
	}

	public static Notebook atualizar(String mensagem, int id) {
		Notebook contato = null;
		try {
			// Cria��o do insert
			String sql = "update contato set mensagem = ? where id = ? ";
			// Obter a conex�o com o banco de dados
			Conexao conex = new Conexao("jdbc:mysql://localhost:3306/infonote_13?useTimezone=true&serverTimezone=UTC",
					"com.mysql.cj.jdbc.Driver", "jeffrey", "password");
			// Abrir a conex�o
			Connection con = conex.obterConexao();
			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, mensagem);
			comando.setInt(2, id);
			comando.setString(3, mensagem);
			// Comando executado
			comando.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return contato;
	}
}
