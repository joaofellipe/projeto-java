package controller;

import util.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import model.*;

public class InfoNote {

	Cliente clienteGlobal; // não esquecer de dar o import neste objeto.
	Funcionario funcionarioGlobal;
	Notebook notebooks[] = new Notebook[10];
	Pedido pedido;
	Configurador config;
	Ajuda ajuda;
	boolean logado = false; // indica se o usuário está logado.
	private static final int LOGIN = 1;
	private static final int CADASTRAR_USUARIO = 2;
	private static final int BUSCAR_NOTEBOOK = 3;
	private static final int INSERIR_NOTEBOOK = 4;
	private static final int REMOVER_NOTEBOOK = 5;
	private static final int VER_CARRINHO = 6;
	private static final int EFETUAR_COMPRA = 7;
	private static final int AJUDA = 8;
	private static final int SAIR = 9;

	public void mostrarMenu() {
		System.out.println("=========================================================");
		System.out.println("          InfoNote - Se não é info não vendemos."
				+ DateFormat.getDateInstance(DateFormat.SHORT).format(new Date()) + " "
				+ DateFormat.getTimeInstance().format(new Date()));
		if (logado == true) {
			System.out.println("Seja bem vindo, " + clienteGlobal.getNomeInvertido());
		}
		System.out.println("=========================================================");

		System.out.println("=========================================================");
		System.out.println("1 - Login");
		System.out.println("2 - Cadastrar Cliente");
		System.out.println("3 - Buscar notebook");
		System.out.println("4 - Inserir Notebook no carrinho");
		System.out.println("5 - Remover Notebook no carrinho");
		System.out.println("6 - ver Carrinho");
		System.out.println("7 - Efetuar Compra");
		System.out.println("8 - Ajuda");
		System.out.println("9 - Sair");

	}

	public void efetuarLogin() {
		String login, senha;
		login = Teclado.lerTexto("Digite o login: ");
		senha = Teclado.lerTexto("Digite a senha: ");

		if (clienteGlobal != null) {

			logado = clienteGlobal.validarLogin(login, senha);

			if (logado) {

				System.out.println("Login efetuado com sucesso!");

			} else {
				System.out.println("Usuário ou senha inválido.");
			}
		} else {
			logado = funcionarioGlobal.validarLogin(login, senha);

			if (logado) {

				System.out.println("Login efetuado com sucesso!");

			} else {
				System.out.println("Usuário ou senha inválido.");

			}
		}
	}

	public void CadastrarUsuario() {
		System.out.println("=========================================================");
		System.out.println("              InfoNote - Cadastro de Usuário             ");
		System.out.println("=========================================================");
		String login = Teclado.lerTexto("Login: ");
		String senha = Teclado.lerTexto("Senha: ");
		if (senha.equals("") || senha == null) {
			senha = GerarSenha.gerarSenha();
			System.out.println("Senha gerada: " + senha);
		}
		String codigoCliente = Teclado.lerTexto("codigo Cliente:");
		String nome = Teclado.lerTexto("Nome: ");
		String email = Teclado.lerTexto("E-mail:");
		String telefone = Teclado.lerTexto("telefone: ");

		// Usuario user = new Usuario("login:joao", "senha:1234",1);

		int tipo = 1;
		String logradouro = Teclado.lerTexto("Logradouro:");
		String numero = Teclado.lerTexto("Nomero: ");
		String complemento = Teclado.lerTexto("Complemento:");
		String bairro = Teclado.lerTexto("bairro: ");
		String cidade = Teclado.lerTexto("Cidade: ");
		String estado = Teclado.lerTexto("Estado:");
		String cep = Teclado.lerTexto("Cep: ");
		Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, estado, cep);
		Cliente cliente = new Cliente(login, senha, tipo, codigoCliente, nome, email, telefone, endereco);
		clienteGlobal = cliente;
		System.out.println("=========================================================");
		System.out.println("              Usuário cadastrado com sucesso             ");
		System.out.println("=========================================================");
		System.out.println(cliente);
		System.out.println(endereco);

	}

	public void buscarNotebook() {
		for (int i = 0; i < notebooks.length; i++) {
			if (notebooks[i] != null) {
				System.out.println(notebooks[i].getSerialNote() + "-----" + notebooks[i].getModelo());
			}
		}
	}

	public void manterCarrinho() {
		System.out.println("manterCarrinho - Em Construção");
	}

	public void inserirNotebook() {
		String serialNote = Teclado.lerTexto("Informe o número do notebook" + "para compra: ");
		if (pedido == null) {
			pedido = new Pedido();
		}

		Notebook aux = null;
		for (int i = 0; i < notebooks.length; i++) {
			if (notebooks[i] != null && serialNote.equals(notebooks[i].getSerialNote())) {
				aux = notebooks[i];
			}
			if (aux == null) {
				return;
			}
			ItemDePedido item = new ItemDePedido(1, aux.getPrecoUnitario(), aux);
			pedido.inserirItem(item);
		}
	}

	public void efetuarCompra() {
		System.out.println("efetuarCompra - Em Construção");
	}

	public void ajuda() {
		System.out.println(ajuda.getTexto());
	}

	public static void main(String[] args) {
		InfoNote info = new InfoNote();
		int opcao = SAIR;
		do {
			info.mostrarMenu();
			opcao = Teclado.lerInt("Digite sua opção: ");
			switch (opcao) {
			case LOGIN:
				info.efetuarLogin();
				break;
			case CADASTRAR_USUARIO:
				info.CadastrarUsuario();
				break;
			case BUSCAR_NOTEBOOK:
				info.buscarNotebook();
				break;
			case INSERIR_NOTEBOOK:
				info.manterCarrinho();
				break;
			case REMOVER_NOTEBOOK:
				info.manterCarrinho();
				break;
			case VER_CARRINHO:
				info.manterCarrinho();
				break;
			case EFETUAR_COMPRA:
				if (!info.logado) {
					System.out.println("Efetue login para efetuar compra.");
					break;

				} else {
					info.efetuarCompra();
					break;
				}
			case AJUDA:
				info.ajuda();
				break;
			case SAIR:
				System.out.println("Saída do Sistema");
				break;
			default:
				System.out.println("Opção inválida!");
			}
			Teclado.lerTexto("Pressione uma tecla para continuar...");
		} while (opcao != SAIR);
	}

	public InfoNote() {
		// Cria objeto de configurações
		config = new Configurador();
		Locale.setDefault(new Locale(config.getIdioma(), config.getRegiao()));
		// Cria o objeto Ajuda
		ajuda = new Ajuda(config.getArquivoAjuda());
	}

	public static boolean isNumeric(String str)
	{try
	{
		int i = Integer.parseInt(str);
	}
	catch(NumberFormatException nfe)
	{
		return false;
	}
	return true;
	}

}
