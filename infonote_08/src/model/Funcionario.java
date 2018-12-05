package model;

public class Funcionario extends Usuario implements IUsuario {
	private String matricula;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Funcionario() {
		super();
	}

	public Funcionario(String login, String senha, int tipo, String matricula) {
		super();
		this.matricula = matricula;
	}

	@Override
	public boolean validarLogin (String login, String senha){
	if(getLogin().equals(login) && getSenha().equals(senha)){
	return true;
	}
	return false;
	}
}
