package controlle;

import model.*;
import util.*;

public class InfoNote {
	public static void main(String[] args) {
		
		InfoNote info = new InfoNote();
		int opcao = 8;
		info.mostrarMenu();
		opcao = Teclado.LerInt("Digite sua opção: ");
		
		do {
		switch (opcao) {
		case 1:
			info.efetuarLogin();
			break;
		case 2:
			info.cadastrarUsuario();
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
			System.out.println("Saída do Sistema.");
			break;
		default:
			System.out.println("Opção inválida!");
		}
		Teclado.LerTexto("Pressione uma tecla para continuar...");
		
		} while (opcao != 8);
	}

	Usuario user;
	boolean logado = false;
	int opcao = 8;

	public void mostrarMenu() {
		System.out.println("=================================================");
		System.out.println(" InfoNote - Se não é Info não vendemos. ");
		System.out.println("=================================================");
		System.out.println("1 - Login");
		System.out.println("2 - Cadastrar Cliente");
		System.out.println("3 - Buscar Notebook");
		System.out.println("4 - Inserir Notebook no carrinho");
		System.out.println("5 - Remover Notebook no carrinho");
		System.out.println("6 - Ver Carrinho");
		System.out.println("7 - Efetuar Compra");
		System.out.println("8 - Sair");

	}

	public void efetuarLogin() {
		String login, senha;
		login = Teclado.LerTexto("Digite o login: ");
		senha = Teclado.LerTexto("Digite a senha: ");
		if (login.equals("admin") && senha.equals("1234")) {
			System.out.println("Login efetuado com sucesso.");
			logado = true;
		} else {
			System.out.println("Login ou Senha inválido.");
			efetuarLogin();
		}
	}

	public void cadastrarUsuario() {
		System.out.println("=================================================");
		System.out.println(" InfoNote - Cadastro de Usuários. ");
		System.out.println("=================================================");
		int matricula = Teclado.LerInt("Matrícula: ");
		String login = Teclado.LerTexto("Login: ");
		String senha = Teclado.LerTexto("Senha: ");
		String nome = Teclado.LerTexto("Nome: ");
		String email = Teclado.LerTexto("E-mail: ");
		String telefone = Teclado.LerTexto("Telefone: ");
		user = new Usuario(matricula, login, senha, nome, email, telefone);
		System.out.println("=================================================");
		System.out.println(" Usuário Cadastrado Com Sucesso. ");
		System.out.println("=================================================");
		System.out.println(user);
	}

	public void buscarNotebook() {
		System.out.println("buscarNotebook - Em Construção");
	}

	public void manterCarrinho() {
		System.out.println("manterCarrinho - Em Construção");
	}

	public void efetuarCompra() {
		System.out.println("efetuarCompra - Em Construção");
		InfoNote info = new InfoNote();

	}

}
