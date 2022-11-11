package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.to.EmpresaTO;

public class EmpresaBO {
	
	EmpresaDAO ed;

	public List<EmpresaTO> listar() {
		ed = new EmpresaDAO();
		return ed.select();
	}

	public EmpresaTO listar(int id) {
		ed = new EmpresaDAO();
		return ed.select(id);
	}

	public boolean cadastrar(EmpresaTO e) {
		ed = new EmpresaDAO();
		return ed.insert(e);
	}

	public void atualiza(EmpresaTO e) {
		ed = new EmpresaDAO();
		ed.update(e);
	}

	public void remover(int id) {
		ed = new EmpresaDAO();
		ed.delete(id);
	}
	
}
