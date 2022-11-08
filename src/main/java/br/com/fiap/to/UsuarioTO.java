package br.com.fiap.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UsuarioTO extends Pessoa {

	private String setor, login, senha;
	private int RM;

	public UsuarioTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioTO(String setor, String login, String senha, int rM) {
		super();
		this.setor = setor;
		this.login = login;
		this.senha = senha;
		this.RM = rM;
	}	

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
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

	public int getRM() {
		return RM;
	}

	public void setRM(int rM) {
		RM = rM;
	}

}
