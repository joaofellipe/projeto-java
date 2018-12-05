package model;

public class ItemDePedido {
	@Override
	public String toString() {
		return "ItemDePedido [qtde=" + qtde + ", subtotal=" + subtotal + ", getQtde()=" + getQtde() + ", getSubtotal()="
				+ getSubtotal() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	private int qtde;
	private double subtotal;
	private Notebook notebook;

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

	public ItemDePedido() {
		super();
	}

	public ItemDePedido(int qtde, double subtotal) {
		super();
		this.qtde = qtde;
		this.subtotal = subtotal;
	}

	public ItemDePedido(int qtde, double subtotal, Notebook notebook) {
		super();
		this.qtde = qtde;
		this.subtotal = subtotal;
		this.notebook = notebook;
	}

	public Notebook getNotebook() {
		return notebook;
	}

	public void mostrar() {
		System.out.println("\n\nItemDePedido:\n");
		System.out.println("Quantidade: " + this.qtde);
		System.out.println("Subtotal: " + this.subtotal);
	}

	public ItemDePedido(Notebook notebook) {
		super();
		this.notebook = notebook;
	}
}