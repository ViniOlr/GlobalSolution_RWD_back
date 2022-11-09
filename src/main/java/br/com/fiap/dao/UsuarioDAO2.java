package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.to.UsuarioTO;

public class UsuarioDAO2 {

	private Connection con;
	private UsuarioTO usuario;
	public static List<UsuarioTO> listaUsuario;
	
	

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public UsuarioTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioTO usuario) {
		this.usuario = usuario;
	}

	public UsuarioDAO2() {
		setCon(con);
	}

	public List<UsuarioTO> select() {
		String sql = "SELECT * FROM USUARIO";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			listaUsuario = new ArrayList<UsuarioTO>();
			if (rs != null) {
				while (rs.next()) {
					UsuarioTO usuario = new UsuarioTO();
					usuario.setRM(rs.getInt(1));
					usuario.setNome(rs.getString(2));
					usuario.setRG(rs.getString(3));
					usuario.setCPF(rs.getString(4));
					usuario.setTelefone(rs.getString(5));
					usuario.setEmail(rs.getString(6));
					usuario.setDataNascimento(rs.getString(7));
					usuario.setSetor(rs.getString(8));
					usuario.setLogin(rs.getString(9));
					usuario.setSenha(rs.getString(10));
					listaUsuario.add(usuario);
				}
			} else {
				System.out.println("Nenhum usuário cadastrado!");
			}
			return listaUsuario;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
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
