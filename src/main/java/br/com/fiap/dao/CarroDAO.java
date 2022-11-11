package br.com.fiap.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.to.CarroTO;

public class CarroDAO {
	
	public static List<CarroTO> listaCarro;
	
	public CarroDAO() {
		if (listaCarro == null) {
			listaCarro = new ArrayList<CarroTO>();

			CarroTO carro = new CarroTO();
			carro.setMarca("Chevrolet");
			carro.setModelo("Tracker");
			carro.setAno(2018);
			carro.setKmPorLitro(17);
			carro.setPlaca("GSD3214");
			carro.setId(1);
			listaCarro.add(carro);

			carro = new CarroTO();
			carro.setMarca("FIAT");
			carro.setModelo("Uno");
			carro.setAno(2004);
			carro.setKmPorLitro(9);
			carro.setPlaca("HDS4367");
			carro.setId(2);
			listaCarro.add(carro);
		}
	}
	
	public List<CarroTO> select() {
		return listaCarro;
	}
	
	public CarroTO select(int id) {
		for (int i = 0; i < listaCarro.size(); i++) {
			if (listaCarro.get(i).getId() == id) {
				return listaCarro.get(i);
			}
		}
		return null;
	}
	
	public boolean insert(CarroTO cto) {
		cto.setId(listaCarro.size() + 1);
		return listaCarro.add(cto);
	}
	
	public void update(CarroTO cto) {
		CarroTO carro = select(cto.getId());

		carro.setMarca(cto.getMarca());
		carro.setModelo(cto.getModelo());
		carro.setAno(cto.getAno());
		carro.setKmPorLitro(cto.getKmPorLitro());
		carro.setPlaca(cto.getPlaca());

		for (int i = 0; i < listaCarro.size(); i++) {
			if (listaCarro.get(i) == carro) {
				listaCarro.set(i, carro);
			}
		}
	}
	
	public void delete(int id) {
		listaCarro.remove(select(id));
	}

}
