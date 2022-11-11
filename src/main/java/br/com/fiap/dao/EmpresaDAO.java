package br.com.fiap.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.to.EmpresaTO;

public class EmpresaDAO {
	
	public static List<EmpresaTO> listaEmpresa;
	
	public EmpresaDAO() {
		if (listaEmpresa == null) {
			listaEmpresa = new ArrayList<EmpresaTO>();

			EmpresaTO empresa = new EmpresaTO();
			empresa.setCnpj("123456789");
			empresa.setEndereco("Avenida Paulista");
			empresa.setNome("Empresa do Vinicius");
			empresa.setQuantidadeFuncionarios(125);
			empresa.setTelefone("(11) 96630-9946");
			empresa.setId(1);
			listaEmpresa.add(empresa);

			empresa = new EmpresaTO();
			empresa.setCnpj("987654321");
			empresa.setEndereco("Rua Lira Cearense, 190");
			empresa.setNome("Empresa do TI");
			empresa.setQuantidadeFuncionarios(50);
			empresa.setTelefone("(11) 96630-9946");
			empresa.setId(2);
			listaEmpresa.add(empresa);
		}
	}
	
	public List<EmpresaTO> select() {
		return listaEmpresa;
	}
	
	public EmpresaTO select(int id) {
		for (int i = 0; i < listaEmpresa.size(); i++) {
			if (listaEmpresa.get(i).getId() == id) {
				return listaEmpresa.get(i);
			}
		}
		return null;
	}
	
	public boolean insert(EmpresaTO eto) {
		eto.setId(listaEmpresa.size() + 1);
		return listaEmpresa.add(eto);
	}
	
	public void update(EmpresaTO eto) {
		EmpresaTO empresa = select(eto.getId());

		empresa.setCnpj(eto.getCnpj());
		empresa.setEndereco(eto.getEndereco());
		empresa.setNome(eto.getNome());
		empresa.setQuantidadeFuncionarios(eto.getQuantidadeFuncionarios());
		empresa.setTelefone(eto.getTelefone());
		
		for (int i = 0; i < listaEmpresa.size(); i++) {
			if (listaEmpresa.get(i) == empresa) {
				listaEmpresa.set(i, empresa);
			}
		}
	}
	
	public void delete(int id) {
		listaEmpresa.remove(select(id));
	}

}
