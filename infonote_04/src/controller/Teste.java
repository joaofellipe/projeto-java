package controller;

import model.*;

public class Teste {
	public static void main(String[] args) {

		Usuario user = new Usuario(1, "joseph", "climber", "joseph climber", "joscphclimbcr@gamil.com", "2222-3344");
		user.mostrar();

		Usuario user1 = new Usuario(1, "joseph1", "climber1", "joseph climber1", "joscphcli1mbcr@gamil.com",
				"2222-33441");
		user1.mostrar();

		Endereco ggizi1 = new Endereco(13, "jogo", "caro", 15, 0.75, "card", "memory");
		ggizi1.mostrar();

		Endereco ggizi = new Endereco(133, "joogo", "caroo", 115, 01.75, "ccard", "semory");
		ggizi.mostrar();

		Pedido ak47 = new Pedido("jeremisas", "Rodolfo", "JOJO", "canario", "kaka", "lerolero", null);
		ak47.mostrar();

		Pedido ak471 = new Pedido("jeremisaas", "Rodaolfo", "JOaJO", "canaario", "kakaa", "leroalero", null);
		ak471.mostrar();

		Notebook alcatel = new Notebook(29, "janeiro", "cartao", 29.5, "carro");
        alcatel.mostrar();

		Notebook alcate2 = new Notebook(294, "janeiroo", "cartaao", 209.5, "caarro");
        alcate2.mostrar();

		Notebook alcatel3 = new Notebook(2905, "jaaaneiro", "caaartao", 6629.5, "cccarro");
        alcatel3.mostrar();


		Notebook alcatel4 = new Notebook(241549, "janeeeiro", "cartaooo", 2925125.5, "carrrro");
        alcatel4.mostrar();
		
        ItemDePedido irineu = new ItemDePedido(25, 15.5);
		irineu.mostrar();

		ItemDePedido irineu1 = new ItemDePedido(27, 12.5);
		irineu1.mostrar();

		ItemDePedido irineu2 = new ItemDePedido(26, 1.5);
		irineu2.mostrar();
	}

}
