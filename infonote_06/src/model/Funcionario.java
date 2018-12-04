package model;

public class Funcionario extends Usuario {
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

}
