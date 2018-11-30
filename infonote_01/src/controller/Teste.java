package controller;

import model.*;

public class Teste {
	 
	public static void main(String[] args) {
		
		Usuario Usu = new Usuario();
		Usu.setMatricula(1069);
		Usu.setLogin("Limam2");
		Usu.setSenha("1069");
		Usu.setNome("Marcos lima");
		Usu.setEmail("marcos_lima@hotmail");
		Usu.setTelefone("23257777");
		System.out.println(Usu.toString());
		
		Endereco End = new Endereco();
		End.setLogradouro(" R. Santos Rodrigues");
		End.setNumero("94");		
		End.setComplemento("Apto 407");
		End.setBairro("Etacio");
		End.setCidade("Rio de Janeiro");
		End.setEstado("RJ");
		End.setCep("20250430");
		System.out.println(End.toString());
		
				
		Pedido Ped = new Pedido();
		Ped.setDataEmissao("15102018");
		Ped.setFormaDePagamento("A vista");
		Ped.setValorTotal(5000.00);
		Ped.setSituacao("Ativo");
		System.out.println(Ped.toString());
		
		ItemDePedido Idp1 = new ItemDePedido();
		Idp1.setQtde (2);
		Idp1.setSubtotal(22.98);
		System.out.println(Idp1.toString());
		
		ItemDePedido Idp2 = new ItemDePedido();
		Idp1.setQtde (1);
		Idp1.setSubtotal(98.75);
		System.out.println(Idp2.toString());
		
		
		Notebook Note1 = new Notebook();
		Note1.setNumeroNote(20250122);
		Note1.setModelo("Rs200");
		Note1.setDescricao("Modelo Completo");
		Note1.setEstoque(10);
		Note1.setPrecoUnitario(4200.00);
		Note1.setFigura("figura");
		Note1.setDataCadastro("01012018");
		System.out.println(Note1.toString());
		
		Notebook Note2 = new Notebook();
		Note2.setNumeroNote(20250123);
		Note2.setModelo("Rs200");
		Note2.setDescricao("Modelo Completo");
		Note2.setEstoque(9);
		Note2.setPrecoUnitario(4200.00);
		Note2.setFigura("figura");
		Note2.setDataCadastro("01012018");
		System.out.println(Note2.toString());
		
		Notebook Note3 = new Notebook();
		Note3.setNumeroNote(20250124);
		Note3.setModelo("Rs200");
		Note3.setDescricao("Modelo Completo");
		Note3.setEstoque(8);
		Note3.setPrecoUnitario(4200.00);
		Note3.setFigura("figura");
		Note3.setDataCadastro("01012018");
		System.out.println(Note3.toString());
		
					
	}
}