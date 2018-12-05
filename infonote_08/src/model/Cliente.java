package model;

import java.util.Arrays;

public class Cliente extends Usuario implements IUsuario {
	private String codigoCliente;
	private String nome;
	private String email;
	private String telefone;
	private Endereco enderecos[] = new Endereco[10];
	private Pedido pedidos[] = new Pedido[10];

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco[] getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Endereco[] enderecos) {
		this.enderecos = enderecos;
	}

	public Pedido[] getPedidos() {
		return pedidos;
	}

	public void setPedidos(Pedido[] pedidos) {
		this.pedidos = pedidos;
	}

	public Cliente() {
		super();
	}

	public Cliente(String login, String senha, int tipo, String codigoCliente, String nome, String email,
			String telefone, Endereco endereco) {
		super();
		this.codigoCliente = codigoCliente;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
//insere na posição zero do vetor o endereço residencial
		inserirEndereco(endereco);
	}

//inserir o pedido no vetor
	public boolean inserirPedido(Pedido pedido) {
		for (int i = 0; i < pedidos.length; i++) {
			if (pedidos[i] == null) {
				pedidos[i] = pedido;
				return true;
			}
		}
		return false;
	}

//inserir o endereço no vetor
	public boolean inserirEndereco(Endereco end) {
		for (int i = 0; i < enderecos.length; i++) {
			if (enderecos[i] == null) {
				enderecos[i] = end;
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Cliente [codigoCliente=" + codigoCliente + ", nome=" + nome + ", email=" + email + ", telefone="
				+ telefone + ", enderecos=" + Arrays.toString(enderecos) + ", pedidos=" + Arrays.toString(pedidos)
				+ ", getCodigoCliente()=" + getCodigoCliente() + ", getNome()=" + getNome() + ", getEmail()="
				+ getEmail() + ", getTelefone()=" + getTelefone() + ", getEnderecos()="
				+ Arrays.toString(getEnderecos()) + ", getPedidos()=" + Arrays.toString(getPedidos()) + ", getLogin()="
				+ getLogin() + ", getSenha()=" + getSenha() + ", getTipo()=" + getTipo() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public boolean validarLogin (String login, String senha){
	if(getLogin().equals(login) && getSenha().equals(senha)){
	return true;
	}
	return false;
	}

}
