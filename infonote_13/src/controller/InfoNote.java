package controller;

import util.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import model.*;
import model.DAO.ClienteDAO;
import model.DAO.EnderecoDAO;
import model.DAO.FuncionarioDAO;
import model.DAO.NotebookDAO;
import model.DAO.UsuarioDAO;

public class InfoNote {

	Cliente clienteGlobal; // não esquecer de dar o import neste objeto.
	Funcionario funcionarioGlobal;
	Notebook notebooks[] = new Notebook[10];
	Pedido pedido;
	Usuario usuario;
	Cliente cliente;
	Configurador config;
	Ajuda ajuda;
	boolean logado = false; // indica se o usuário está logado.
	private static final int AREA_ADMINISTRATIVA = 9;
	private static final int SAIR = 10;
	private static final int LOGIN = 1;
	private static final int CADASTRAR_USUARIO = 2;
	private static final int BUSCAR_NOTEBOOK = 3;
	private static final int INSERIR_NOTEBOOK = 4;
	private static final int REMOVER_NOTEBOOK = 5;
	private static final int VER_CARRINHO = 6;
	private static final int EFETUAR_COMPRA = 7;
	private static final int AJUDA = 8;

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
		System.out.println("9 - Área Administrativa");
		System.out.println("10 - Sair");

	}

	public void efetuarLogin() {
		String login, senha;
		login = Teclado.lerTexto("Digite o login: ");
		senha = Teclado.lerTexto("Digite a senha: ");
		cliente = ClienteDAO.buscarPorLoginSenha(login, senha);
		if (cliente != null) {
			logado = cliente.validarLogin(login, senha);
		} else {
			if (logado) {
				System.out.println("Login efetuado com sucesso!");
			} else {
				System.out.println("Usuário ou senha inválido.");
				int opcao2 = 3;
				do {
					System.out.println("Digite:");
					System.out.println("1 - Para efetuar Login");
					System.out.println("2 - Para cadastrar-se");
					System.out.println("3 - Para sair do sistema");
					opcao2 = Teclado.lerInt("");
					switch (opcao2) {
					case 1:
						efetuarLogin();
						break;
					case 2:
						CadastrarUsuario();
						break;
					case 3:
						System.out.println("Obrigado e volte sempre!");
						break;
					default:
						System.out.println("Opção inválida");
					}
				} while (!logado);
			}
		}
	}

	public void CadastrarUsuario() {
		System.out.println("=========================================================");
		System.out.println("              InfoNote - Cadastro de Usuário             ");
		System.out.println("=========================================================");

		String serialNote = Teclado.lerTexto("SerialNote:");
		String modelo = Teclado.lerTexto("modelo: ");
		String descricao = Teclado.lerTexto("descricao:");
		int estoque = Teclado.lerInt("estoque: ");
		double precoUnitario = Teclado.lerDouble("precoUnitario: ");
		String dataCadastro = Teclado.lerTexto("dataCadastro:");
		String figura = Teclado.lerTexto("figura: ");

		Notebook notebook = NotebookDAO.inserir(serialNote, modelo, descricao, estoque, precoUnitario, figura,
				dataCadastro);
		// inserir(String serialNote, String modelo, String descricao, int
		// estoque,double precoUnitario, String figura, String dataCadastro) {
		System.out.println("=========================================================");
		System.out.println("              Usuário cadastrado com sucesso             ");
		System.out.println("=========================================================");
		System.out.println(notebook);

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
			case AREA_ADMINISTRATIVA:
				info.areaAdministrativa();
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

	public static boolean isNumeric(String str) {
		try {
			@SuppressWarnings("unused")
			int i = Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public void efetuarLoginAdm() {
		String login, senha;
		login = Teclado.lerTexto("Digite o login: ");
		senha = Teclado.lerTexto("Digite a senha: ");
		Funcionario funcionario = FuncionarioDAO.buscarPorLoginSenha(login, senha);
		if (funcionario != null) {
			logado = funcionario.validarLogin(login, senha);
		} else {
			if (logado) {
				System.out.println("Login efetuado com sucesso!");
			} else {
				System.out.println("Usuário ou senha inválido.");
			}
		}
	}

	public void areaAdministrativa() {
		InfoNote info = new InfoNote();
		efetuarLoginAdm();
		System.out.println("Opções Administrativas\n");
		System.out.println("1 - Cadastrar Notebook");
		System.out.println("2 - Mostrar Notebooks");
		System.out.println("3 - Editar Notebook");
		System.out.println("4 - Excluir Notebook");
		System.out.println("5 - Sair");
		int opcao = 5;
		do {
			opcao = Teclado.lerInt("Digite sua opção: ");
			switch (opcao) {
			case 1:
				info.cadastrarNotebook();
				break;
			case 2:
				info.mostrarNotebooks();
				break;
			case 3:
				info.editarNotebook();
				break;
			case 4:
				info.excluirNotebook();
				break;
			case 5:
				System.out.println("Saída do Sistema");
				break;
			default:
				System.out.println("Opção inválida!");
			}
			Teclado.lerTexto("Pressione uma tecla para continuar...");
		} while (opcao != 5);
	}

}
