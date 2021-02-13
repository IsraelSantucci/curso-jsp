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
			String sql = "insert into usuario (login,nome, senha,telefone) values (?,?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, usuario.getLogin());
			insert.setString(2, usuario.getNome());
			insert.setString(3, usuario.getSenha());
			insert.setString(4, usuario.getTelefone());
			insert.execute();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

	public List<Usuario> listar() throws Exception {

		List<Usuario> usuarios = new ArrayList<Usuario>();

		String sql = "select * from usuario";

		PreparedStatement select = connection.prepareStatement(sql);
		ResultSet result = select.executeQuery();

		while (result.next()) {
			Usuario usuario = new Usuario();
			usuario.setLogin(result.getString("login"));
			usuario.setNome(result.getString("nome"));
			usuario.setSenha(result.getString("senha"));
			usuario.setId(Long.valueOf(result.getLong("id")));
			usuario.setTelefone(result.getString("telefone"));
			usuarios.add(usuario);
		}

		return usuarios;
	}

	public void deletar(Long id) {
		String sql = "delete from usuario where id = '" + id + "'";
		try {
			PreparedStatement delete = connection.prepareStatement(sql);
			delete.execute();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

	public Usuario consultar(Long id) throws Exception {

		String sql = "select * from usuario where id= '" + id + "'";
		PreparedStatement consultar = connection.prepareStatement(sql);
		ResultSet result = consultar.executeQuery();
		if (result.next()) {
			Usuario usuario = new Usuario();
			usuario.setId(result.getLong("id"));
			usuario.setLogin(result.getString("login"));
			usuario.setNome(result.getString("nome"));
			usuario.setSenha(result.getString("senha"));
			usuario.setTelefone(result.getString("telefone"));
			return usuario;
		}

		return null;
	}

	public void atualizar(Usuario usuario) {

		try {
			String sql = "UPDATE usuario SET login= ?, nome= ?, senha= ?, telefone= ? where id= '" + usuario.getId()
					+ "'";
			PreparedStatement atualizar = connection.prepareStatement(sql);
			atualizar.setString(1, usuario.getLogin());
			atualizar.setString(2, usuario.getNome());
			atualizar.setString(3, usuario.getSenha());
			atualizar.setString(4, usuario.getTelefone());
			atualizar.executeUpdate();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

	public boolean validarLogin(String login) throws SQLException {

		String sql = "SELECT count(1) as qtd FROM usuario where login=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, login);
		ResultSet result = statement.executeQuery();
		if (result.next()) {
			return result.getInt("qtd") <= 0; // retorna true se nao tiver uma ocorrencia do login buscada
		}

		return false;
	}

	public boolean validarSenhaRepetida(String senha) throws SQLException {

		String sql = "SELECT count(1) as qtd  fROM usuario where senha = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, senha);
		ResultSet result = statement.executeQuery();
		if (result.next()) {
			return result.getInt("qtd") > 0; // retorna true se  tem senha repetida
		}

		return false;
	}

	public boolean validarLoginUpdate(String login, Long id) throws Exception {

		String sql = "SELECT COUNT(1) AS qtd FROM usuario WHERE login=? AND id <> ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, login);
		statement.setLong(2, id);

		ResultSet result = statement.executeQuery();
		if (result.next()) {
			return result.getInt("qtd") > 0; // returna true se ja existir o login
		}

		return false;
	}

	public boolean validarSenhaRepetidaUpdate(String senha, Long id) throws SQLException {

		String sql = "SELECT count(1) as qtd  fROM usuario where id <> ? and senha = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, id);
		statement.setString(2, senha);
		ResultSet result = statement.executeQuery();
		if (result.next()) {
			return result.getInt("qtd") > 0; // retorna true se tem senha repetida
		}

		return false;
	}
}
