package model;

import model.DAO.FuncionarioDAO;

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
	public boolean validarLogin(String login, String senha) {
		Funcionario funcionario = FuncionarioDAO.buscarPorLoginSenha(login, senha);
		if (funcionario != null) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Funcionario [matricula=" + matricula + ", getMatricula()=" + getMatricula() + ", getLogin()="
				+ getLogin() + ", getSenha()=" + getSenha() + ", getTipo()=" + getTipo() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
