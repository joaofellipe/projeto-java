package controlle;

import model.*;

public class Teste {

	public static void main(String[] args) {

		Usuario user = new Usuario(1, "joseph", "climbe r", "Joseph Climber", "josephclimber@gmail.com", "2222-3344");
		user.mostrar();

		Endereco end = new Endereco(" R. Fidel Castro", "98", " Apto 407", " Tijuca", " RJ", " RJ", " 20250650");
		end.mostrar();

		System.out.println("---------------------------------");
		
		Pedido ped = new Pedido(15000, "15102018", "A vista", 5000.00, "Ativo");
		ped.mostrar();
		
		Pedido ped1 = new Pedido(215000, "15102020", "A vista", 1000.00, "Inativo");
		ped1.mostrar();

		System.out.println("---------------------------------");
		
		ItemDePedido Idp1 = new ItemDePedido( 9, 5000.00);
		Idp1.mostrar();
 
		ItemDePedido Idp2 = new ItemDePedido( 12, 5800.00);

		System.out.println("---------------------------------");
		
		Notebook Note1 = new Notebook( 20250122, "Rs200", "Modelo Completo", 10, 4200.00, "figura", "01012018");
		Idp2.mostrar();
		Note1.mostrar();

		Notebook Note2 = new Notebook( 20250122, "Rs200", "Modelo Completo", 10, 4200.00, "figura", "01012018");
		Note2.mostrar();

		Notebook Note3 = new Notebook( 20250122, "Rs200", "Modelo Completo", 10, 4200.00, "figura", "01012018");
		Note3.mostrar();

	}
}