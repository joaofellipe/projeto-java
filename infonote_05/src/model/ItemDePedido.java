package model;

public class ItemDePedido {

	private int qtde;
	private double subtotal;
	private Notebook notebook;

		public Notebook getNotebook() {
		return notebook;
	}

	public void setNotebook(Notebook notebook) {
		this.notebook = notebook;
	}

		public void mostrar() {

		// Mostrar usuário
		System.out.println("\n\nItemDePedido: ");
		System.out.println("qtde" + this.qtde);
		System.out.println("subtotal" + this.subtotal + "\n");

	}
	
	public ItemDePedido(int qtde, double subtotal) {
		super();
		this.qtde = qtde;
		this.subtotal = subtotal;
	}

	public ItemDePedido() {
		super();
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
		return "ItenDePedido [qtde=" + qtde + ", subtotal=" + subtotal + ", getQtde()=" + getQtde() + ", getSubtotal()="
				+ getSubtotal() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public ItemDePedido(Notebook notebook) {
		super();
		this.notebook = notebook;
	}

	public ItemDePedido(int i, double precoUnitario, Notebook aux) {
		
	}
	
	

}
