package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Usuario;
import connection.SingleConnection;

public class UsuarioDAO {
	
	private Connection connection;
	
	public UsuarioDAO() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(Usuario usuario) {
		
		try {
			String sql = "insert into usuario (login,nome, senha) values (?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, usuario.getLogin());
			insert.setString(2, usuario.getNome());
			insert.setString(3, usuario.getSenha());
			insert.execute();
			connection.commit();
		}catch(Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}

	public List<Usuario> listar() throws Exception{
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		String sql = "select * from usuario";
		
		PreparedStatement select = connection.prepareStatement(sql);
		ResultSet result = select.executeQuery();
		
		while(result.next()) {
			Usuario usuario =  new Usuario();
			usuario.setLogin(result.getString("login"));
			usuario.setNome(result.getString("nome"));
			usuario.setSenha(result.getString("senha"));
			usuario.setId(Long.valueOf(result.getLong("id")));
			usuarios.add(usuario);
		}
		
		return usuarios;
	}
	
	public void deletar(Long id) {
		String sql = "delete from usuario where id = '"+id+"'";
		try {
			PreparedStatement delete = connection.prepareStatement(sql);
			delete.execute();
			connection.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	public Usuario consultar(Long id) throws Exception{
		
		String sql = "select * from usuario where id= '"+id+"'";
		PreparedStatement consultar = connection.prepareStatement(sql);
		ResultSet set = consultar.executeQuery();
		if(set.next()) {
			Usuario usuario = new Usuario();
			usuario.setId(set.getLong("id"));
			usuario.setLogin(set.getString("login"));
			usuario.setNome(set.getString("nome"));
			usuario.setSenha(set.getString("senha"));
			return usuario;
		}
		
		return null;
	}
	
	public void atualizar(Usuario usuario) {
		
		
		try {
			String sql = "UPDATE usuario SET login= ?, nome= ?, senha= ? where id= '"+ usuario.getId()+"'"; 
			PreparedStatement atualizar = connection.prepareStatement(sql);
			atualizar.setString(1, usuario.getLogin());
			atualizar.setString(2, usuario.getNome());
			atualizar.setString(3, usuario.getSenha());
			atualizar.executeUpdate();
			connection.commit();
		}catch(Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
}
