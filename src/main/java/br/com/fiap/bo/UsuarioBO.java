package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.to.UsuarioTO;

public class UsuarioBO {

	UsuarioDAO ud;

	public UsuarioTO validacao(UsuarioTO u) {
		ud = new UsuarioDAO();
		return ud.loginDAO(u);
	}

	public List<UsuarioTO> listar() {
		ud = new UsuarioDAO();
		return ud.select();
	}

	public UsuarioTO listar(int rm) {
		ud = new UsuarioDAO();
		return ud.select(rm);
	}

	public boolean cadastrar(UsuarioTO u) {
		ud = new UsuarioDAO();
		return ud.insert(u);
	}

	public void atualiza(UsuarioTO u) {
		ud = new UsuarioDAO();
		ud.update(u);
	}

	public void remover(int rm) {
		ud = new UsuarioDAO();
		ud.delete(rm);
	}

}
