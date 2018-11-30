package model;

public class Pedido {

	public int numero;
	public String dataEmissao;
	public String formaDePagamento;
	public double valorTotal;
	public String situacao;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	@Override
	public String toString() {
		return "Pedido [numero=" + numero + ", dataEmissao=" + dataEmissao + ", formaDePagamento=" + formaDePagamento
				+ ", valorTotal=" + valorTotal + ", situacao=" + situacao + ", getNumero()=" + getNumero()
				+ ", getDataEmissao()=" + getDataEmissao() + ", getFormaDePagamento()=" + getFormaDePagamento()
				+ ", getValorTotal()=" + getValorTotal() + ", getSituacao()=" + getSituacao() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
