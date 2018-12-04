package controller;

import util.Teclado;

import model.*;

public class InfoNote {

	Usuario ddd;
	Notebook notebooks[] = new Notebook[10];
	Pedido pedido;
	boolean logado = false;

	public InfoNote() {
		notebooks[0] = new Notebook("1", "Negativo N22BR", "CPU Intel Core 2 Duo, Memória 2 GB, HD 205 GB", 6, 1200.00,
				"img\\n22br.jpg", "19/05/2011");

		notebooks[1] = new Notebook("2", "Bell B55BR", "CPU Intel I3, Memória 4 GB, HD 500 GB", 3, 1800.00,
				"img\\b55br.jpg", "20/05/2011");

		notebooks[2] = new Notebook("3", "Pompaq P41BR", "CPU Intel I3, Memória 3 GB, HD 320 GB", 1, 1600.00,
				"img\\p41br.jpg", "21/05/2011");

		notebooks[3] = new Notebook("4", "CCF CR71CH", "CPU Intel Dual Core, Memória 2 GB, HD 160 GB", 5, 1100.00,
				"img\\bd22br.jpg", "10/06/2011");

	}

	public void mostrarMenu() {
		System.out.println("=========================================================");
		System.out.println("          InfoNote - Se não é info não vendemos          ");
		System.out.println("=========================================================");
		System.out.println("1 - Login");
		System.out.println("2 - Cadastrar Cliente");
		System.out.println("3 - Buscar Notebook");
		System.out.println("4 - Inserir Notebook no carrinho");
		System.out.println("5 - Remover Notebook do carrinho");
		System.out.println("6 - Ver carrinho");
		System.out.println("7 - Efetuar compra");
		System.out.println("8 - Sair");
	}

	public void efetuarLogin() {
		String login, senha;
		login = Teclado.lerTexto("Digite o login: ");
		senha = Teclado.lerTexto("Digite a senha: ");

		if (login.equals("joao") && senha.equals("1234")) {
			System.out.println("Login efetuado com sucesso.");
			logado = true;
		} else {
			System.out.println("Login ou senha inválido.");
			efetuarLogin();
		}
	}

	public void CadastrarUsuario() {
		System.out.println("=========================================================");
		System.out.println("              InfoNote - Cadastro de Usuário             ");
		System.out.println("=========================================================");
		String login = Teclado.lerTexto("Login: ");
		String senha = Teclado.lerTexto("Senha: ");
		int tipo = Teclado.lerInt("Tipo: ");
		String codigoCliente = Teclado.lerTexto("codigo Cliente:");
		String nome = Teclado.lerTexto("Nome: ");
		String email = Teclado.lerTexto("E-mail:");
		String telefone = Teclado.lerTexto("telefone: ");

		//Usuario user = new Usuario("login:joao", "senha:1234",1);

		String logradouro = Teclado.lerTexto("Logradouro:");
		String numero = Teclado.lerTexto("Nomero: ");
		String complemento = Teclado.lerTexto("Complemento:");
		String bairro = Teclado.lerTexto("bairro: ");
		String cidade = Teclado.lerTexto("Cidade: ");
		String estado = Teclado.lerTexto("Estado:");
		String cep = Teclado.lerTexto("Cep: ");

		Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, estado, cep);
		Cliente cli = new Cliente(login, senha, tipo, codigoCliente, nome, email, telefone, endereco);
		System.out.println("=========================================================");
		System.out.println("              Usuário cadastrado com sucesso             ");
		System.out.println("=========================================================");
		System.out.println(cli);
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

	public static void main(String[] args) {
		InfoNote info = new InfoNote();
		int opcao = 8;
		do {
			info.mostrarMenu();
			opcao = Teclado.lerInt("Digite sua opção: ");
			switch (opcao) {

			case 1:
				info.efetuarLogin();
				break;

			case 2:
				info.CadastrarUsuario();
				break;

			case 3:
				info.buscarNotebook();
				break;

			case 4:
				info.manterCarrinho();
				break;

			case 5:
				info.manterCarrinho();
				break;

			case 6:
				info.manterCarrinho();
				break;

			case 7:
				if (!info.logado) {
					System.out.println("Efetue login para efetuar compra.");
					break;
				} else {
					info.efetuarCompra();
					break;
				}

			case 8:
				System.out.println("Saída do sistema.");
				break;

			default:
				System.out.println("Opção inválida!");
			}
		} while (opcao != 8);
		Teclado.lerTexto("pressione  uma tecla para continuar...");

	}

}
