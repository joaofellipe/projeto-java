package model;

public abstract class Usuario {
	private String login;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(String login, String senha, int tipo) {
		super();
		this.login = login;
		this.senha = senha;
		this.tipo = tipo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	private String senha;
	private int tipo;

	@Override
	public String toString() {
		final String ENTER = "\n";
		String retValue = "";
		retValue= "Usuario [login=" + login + ", senha=" + senha + ", tipo=" + tipo + ", getLogin()=" + getLogin()
				+ ", getSenha()=" + getSenha() + ", getTipo()=" + getTipo() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		
    return retValue;	
	}

}
