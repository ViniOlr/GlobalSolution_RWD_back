package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.dao.CarroDAO;
import br.com.fiap.to.CarroTO;

public class CarroBO {
	
	CarroDAO cd;

	public List<CarroTO> listar() {
		cd = new CarroDAO();
		return cd.select();
	}

	public CarroTO listar(int id) {
		cd = new CarroDAO();
		return cd.select(id);
	}

	public boolean cadastrar(CarroTO c) {
		cd = new CarroDAO();
		return cd.insert(c);
	}

	public void atualiza(CarroTO c) {
		cd = new CarroDAO();
		cd.update(c);
	}

	public void remover(int id) {
		cd = new CarroDAO();
		cd.delete(id);
	}

}
