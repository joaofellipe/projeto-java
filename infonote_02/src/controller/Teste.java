package controller;

import model.*;

public class Teste {
	public static void main(String[] args) {

		Usuario user = new Usuario();
		user.setMatricula(17);
		user.setLogin("BolsoMito");
		user.setSenha("Brasil");
		user.setNome("General");
		user.setEmail("Mourao");
		user.setTelefone("AssuncaoCheiradao");
		System.out.println(user.toString());

		Usuario user1 = new Usuario();
		user1.setMatricula(17);
		user1.setLogin("BolsoMito");
		user1.setSenha("Brasil");
		user1.setNome("General");
		user1.setEmail("Mourao");
		user1.setTelefone("AssuncaoCheiradao");
		System.out.println(user1.toString());

		Endereco ggizi1 = new Endereco();
		ggizi1.setNumeroNote(69);
		ggizi1.setModelo("joaoFellipe");
		ggizi1.setDescricao("Graudo");
		ggizi1.setEstoque(18);
		ggizi1.setPrecoUnitario(1.0);
		ggizi1.setFigura("masterYI");
		ggizi1.setDataCadastro("jeremias");
		System.out.println(ggizi1.toString());

		Endereco ggizi = new Endereco();
		ggizi.setNumeroNote(699);
		ggizi.setModelo("joaoFellipev");
		ggizi.setDescricao("Graudoo");
		ggizi.setEstoque(318);
		ggizi.setPrecoUnitario(1.10);
		ggizi.setFigura("masterrYI");
		ggizi.setDataCadastro("jeeremias");
		System.out.println(ggizi.toString());

		Pedido ak47 = new Pedido();
		ak47.setLogradouro("Robert");
		ak47.setNumero("DANONE");
		ak47.setComplemento("CARBONO");
		ak47.setBairro("BORO");
		ak47.setCidade("CLEBER");
		ak47.setEstado("GORGONOID");
		ak47.setCep("TENIS");
		System.out.println(ak47.toString());

		Pedido ak471 = new Pedido();
		ak471.setLogradouro("Roobert");
		ak471.setNumero("DAaNONE");
		ak471.setComplemento("CAaRBONO");
		ak471.setBairro("BOoRO");
		ak471.setCidade("CLEeBER");
		ak471.setEstado("GORGONOiID");
		ak471.setCep("TENIiS");
		System.out.println(ak471.toString());

		Notebook alcatel = new Notebook();
		alcatel.setNumero(28889);
		alcatel.setDataEmissao("glubglub");
		alcatel.setFormaDePagamento("cartao");
		alcatel.setValorTotal(1.65);
		alcatel.setSituacao("garen");
		System.out.println(alcatel.toString());

		Notebook alcatel1 = new Notebook();
		alcatel1.setNumero(218889);
		alcatel1.setDataEmissao("gluubglub");
		alcatel1.setFormaDePagamento("ccartao");
		alcatel1.setValorTotal(11.65);
		alcatel1.setSituacao("ggaren");
		System.out.println(alcatel1.toString());

		Notebook alcatel2 = new Notebook();
		alcatel2.setNumero(228889);
		alcatel2.setDataEmissao("ggglubglub");
		alcatel2.setFormaDePagamento("cccartao");
		alcatel2.setValorTotal(1.265);
		alcatel2.setSituacao("gggaren");
		System.out.println(alcatel2.toString());

		Notebook alcatel3 = new Notebook();
		alcatel3.setNumero(2258889);
		alcatel3.setDataEmissao("gluuubglub");
		alcatel3.setFormaDePagamento("caaaartao");
		alcatel3.setValorTotal(1258.65);
		alcatel3.setSituacao("gareeeen");
		System.out.println(alcatel3.toString());

		ItemDePedido irineu = new ItemDePedido();
		irineu.setQtde(55);
		irineu.setSubtotal(25.999);
		System.out.println(irineu.toString());

		ItemDePedido irineu1 = new ItemDePedido();
		irineu1.setQtde(555);
		irineu1.setSubtotal(2255.999);
		System.out.println(irineu1.toString());

		ItemDePedido irineu2 = new ItemDePedido();
		irineu2.setQtde(55586);
		irineu2.setSubtotal(25.99999);
		System.out.println(irineu2.toString());

	}

}
