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
			// Criação do insert
			String sql = "insert into usuario (serialNote, modelo, descricao, estoque, precoUnitario,figura, dataCadastro ) values (?,?,?)";
			// Obter a conexão com o banco de dados
			Conexao conex = new Conexao(notDAO.url, notDAO.driver, notDAO.login, notDAO.senha);
			// Abrir a conexão
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

	public static Notebook excluir(int estoque) {
		Notebook notebook = null;
		try {
			// Criação do insert
			String sql = "delete from notebook where serialNote, modelo, descricao, estoque, precoUnitario,figura, dataCadastro = ?";
			// Obter a conexão com o banco de dados
			Conexao conex = new Conexao("jdbc:mysql://localhost:3306/infonote?useTimezone=true&serverTimezone=UTC",
					"com.mysql.cj.jdbc.Driver", "jeffrey", "password");
			// Abrir a conexão
			Connection con = conex.obterConexao();
			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setInt(1, estoque);
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
		NotebookDAO noteDAO = new NotebookDAO();
		try {
			// Crição do select
			String sql = "Select * from notebook";
			// Obter a conexão com o banco de dados
			Conexao conex = new Conexao(noteDAO.url, noteDAO.driver, noteDAO.login, noteDAO.senha);
			Connection con = conex.obterConexao();
			/*
			 * Executa a confirmação direta de acesso ao banco pois não são necessárias
			 * informações para a Query (caracter curinga)
			 */
			Statement comando = con.createStatement();
			/*
			 * ResultSet - Classe java que monta em memória uma matriz com a resposta das
			 * linhas do banco de dados
			 */
			ResultSet rs = comando.executeQuery(sql);
			// vetor de objetos
			notebook = new Notebook[10];
			/*
			 * Passagem de linha de dados do ResultSet para o vetor de objetos (uma linha de
			 * dados da matriz do ResultSet é copiada para um objeto no vetor contatos)
			 */
			int i = 0;
			while (rs.next()) {
				notebook[i++] = new Notebook(rs.getString("serialnote"), rs.getString("modelo"),
						rs.getString("descricao"), rs.getInt("estoque"), rs.getDouble("precoUnitario"),
						rs.getString("figura"), rs.getString("dataCadastro"));
			}
			// É necessário encerrar o acesso ao banco para liberar a conexão
			rs.close();
			comando.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return notebook;
	}

	public static Notebook atualizar(String serialNote, String modelo, String descricao, int estoque,
			double precoUnitario, String figura, String dataCadastro) {
		Notebook notebook = null;
		try {
			// Criação do insert
			String sql = "update notebook set = ? where  = ? serialNote, modelo, descricao, estoque, precoUnitario,figura, dataCadastro = ? where id = ? ";
			// Obter a conexão com o banco de dados
			Conexao conex = new Conexao("jdbc:mysql://localhost:3306/infonote?useTimezone=true&serverTimezone=UTC",
					"com.mysql.cj.jdbc.Driver", "jeffrey", "password");
			// Abrir a conexão
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
		return notebook;
	}

	public static Notebook excluir(String id) {
		Notebook notebook = null;
		NotebookDAO noteDAO = new NotebookDAO();
		try {
			// Criação do insert
			String sql = "delete from notebook where serialnote = ?";
			// Obter a conexão com o banco de dados
			Conexao conex = new Conexao(noteDAO.url, noteDAO.driver, noteDAO.login, noteDAO.senha);
			// Abrir a conexão
			Connection con = conex.obterConexao();
			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, id);
			comando.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return notebook;
	}
}
