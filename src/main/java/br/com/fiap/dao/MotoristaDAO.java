package br.com.fiap.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.to.MotoristaTO;

public class MotoristaDAO {
	
	public static List<MotoristaTO> listaMotorista;
	
	public MotoristaDAO() {
		if (listaMotorista == null) {
			listaMotorista = new ArrayList<MotoristaTO>();
			
			MotoristaTO motorista = new MotoristaTO();
			motorista.setNome("Vinicius de Oliveira");
			motorista.setCPF("526.764.518-47");
			motorista.setTelefone("(11) 96630-9946");
			motorista.setDataNascimento("15/05/2003");
			motorista.setEmail("vini@gmail.com");
			motorista.setRG("57.533.164-1");
			motorista.setNumeroHabilitacao("123456");
			motorista.setCategoriaHabilitacao("AB");
			motorista.setDataExpedicao("21/06/2003");
			motorista.setId(1);
			listaMotorista.add(motorista);
			
			motorista = new MotoristaTO();
			motorista.setNome("Ricardo Silva");
			motorista.setCPF("347.934.578-30");
			motorista.setTelefone("(11) 93489-1438");
			motorista.setDataNascimento("31/07/2000");
			motorista.setEmail("ricardocontato@gmail.com");
			motorista.setRG("57.533.164-1");
			motorista.setNumeroHabilitacao("123456");
			motorista.setCategoriaHabilitacao("AB");
			motorista.setDataExpedicao("21/06/2003");
			motorista.setId(2);
			listaMotorista.add(motorista);
			
			System.out.println(listaMotorista);
		}
	}
	
	public List<MotoristaTO> select() {
		return listaMotorista;
	}
	
	public MotoristaTO select(int id) {
		for (int i = 0; i < listaMotorista.size(); i++) {
			if (listaMotorista.get(i).getId() == id) {
				return listaMotorista.get(i);
			}
		}
		return null;
	}
	
	public boolean insert(MotoristaTO mto) {
		mto.setId(listaMotorista.size() + 1);
		return listaMotorista.add(mto);
	}
	
	public void update(MotoristaTO mto) {
		MotoristaTO motorista = select(mto.getId());

		motorista.setNome(mto.getNome());
		motorista.setCPF(mto.getCPF());
		motorista.setTelefone(mto.getTelefone());
		motorista.setDataNascimento(mto.getDataNascimento());
		motorista.setEmail(mto.getEmail());
		motorista.setRG(mto.getRG());
		motorista.setNumeroHabilitacao(mto.getNumeroHabilitacao());
		motorista.setCategoriaHabilitacao(mto.getCategoriaHabilitacao());
		motorista.setDataExpedicao(mto.getDataExpedicao());

		for (int i = 0; i < listaMotorista.size(); i++) {
			if (listaMotorista.get(i) == motorista) {
				listaMotorista.set(i, motorista);
			}
		}
	}

	public void delete(int id) {
		listaMotorista.remove(select(id));
	}

}
