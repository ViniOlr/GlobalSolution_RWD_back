package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.dao.MotoristaDAO;
import br.com.fiap.to.MotoristaTO;

public class MotoristaBO {
	
	MotoristaDAO md;

	public List<MotoristaTO> listar() {
		md = new MotoristaDAO();
		return md.select();
	}

	public MotoristaTO listar(int id) {
		md = new MotoristaDAO();
		return md.select(id);
	}

	public boolean cadastrar(MotoristaTO m) {
		md = new MotoristaDAO();
		return md.insert(m);
	}

	public void atualiza(MotoristaTO m) {
		md = new MotoristaDAO();
		md.update(m);
	}

	public void remover(int id) {
		md = new MotoristaDAO();
		md.delete(id);
	}

}
