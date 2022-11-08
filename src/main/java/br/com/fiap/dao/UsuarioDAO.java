package br.com.fiap.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.to.UsuarioTO;

public class UsuarioDAO {

	public static List<UsuarioTO> listaUsuario;

	public UsuarioDAO() {
		if (listaUsuario == null) {
			listaUsuario = new ArrayList<UsuarioTO>();

			UsuarioTO usuario = new UsuarioTO();
			usuario.setNome("Vinicius de Oliveira");
			usuario.setCPF("526.764.518-47");
			usuario.setTelefone("(11) 96630-9946");
			usuario.setDataNascimento("15/05/2003");
			usuario.setEmail("vini@gmail.com");
			usuario.setLogin("ViniOlr");
			usuario.setRG("57.533.164-1");
			usuario.setSenha("1234");
			usuario.setSetor("Administrativo");
			usuario.setRM(1);
			listaUsuario.add(usuario);

			usuario = new UsuarioTO();
			usuario.setNome("Ricardo Silva");
			usuario.setCPF("347.934.578-30");
			usuario.setTelefone("(11) 93489-1438");
			usuario.setDataNascimento("31/07/2000");
			usuario.setEmail("ricardocontato@gmail.com");
			usuario.setLogin("Ricardo");
			usuario.setRG("31.647.177-1");
			usuario.setSenha("1234");
			usuario.setSetor("Administrativo");
			usuario.setRM(2);
			listaUsuario.add(usuario);
		}
	}

	public List<UsuarioTO> select() {
		return listaUsuario;
	}

	public UsuarioTO select(int rm) {
		for (int i = 0; i < listaUsuario.size(); i++) {
			if (listaUsuario.get(i).getRM() == rm) {
				return listaUsuario.get(i);
			}
		}
		return null;
	}

	public boolean insert(UsuarioTO uto) {
		uto.setRM(listaUsuario.size() + 1);
		return listaUsuario.add(uto);
	}

	public void update(UsuarioTO uto) {
		UsuarioTO usuario = select(uto.getRM());

		usuario.setNome(uto.getNome());
		usuario.setCPF(uto.getCPF());
		usuario.setTelefone(uto.getTelefone());
		usuario.setDataNascimento(uto.getDataNascimento());
		usuario.setEmail(uto.getEmail());
		usuario.setLogin(uto.getLogin());
		usuario.setRG(uto.getRG());
		usuario.setSenha(uto.getSenha());
		usuario.setSetor(uto.getSetor());

		for (int i = 0; i < listaUsuario.size(); i++) {
			if (listaUsuario.get(i) == usuario) {
				listaUsuario.set(i, usuario);
			}
		}
	}

	public void delete(int rm) {
		listaUsuario.remove(select(rm));
	}

	public UsuarioTO loginDAO(UsuarioTO u) {
		for (int i = 0; i < listaUsuario.size(); i++) {
			if (listaUsuario.get(i).getLogin().equals(u.getLogin())
					&& listaUsuario.get(i).getSenha().equals(u.getSenha())) {
				return listaUsuario.get(i);
			}
		}
		return null;
	}
}
