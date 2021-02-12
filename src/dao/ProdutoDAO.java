package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Produto;
import beans.Usuario;
import connection.SingleConnection;

public class ProdutoDAO {

	private Connection connection = SingleConnection.getConnection();
	
	public List<Produto> listar() {
		
		List<Produto> produtos = new ArrayList<Produto>();
		try {
			String sql = "SELECT * FROM produto";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				Produto produto = new Produto();
				produto.setCodigo(result.getLong("codigo"));
				produto.setNome(result.getString("nome"));
				produto.setQuantidade(result.getInt("quantidade"));
				produto.setValor(result.getDouble("valor"));
				
				produtos.add(produto);
			}
			
			return produtos;
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return produtos;
		
	}
	
	public void cadastraProduto(Produto produto) {
		try {
			String sql = "INSERT INTO produto (nome, quantidade, valor) VALUES ( ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, produto.getNome());
			statement.setInt(2, produto.getQuantidade());
			statement.setDouble(3, produto.getValor());
			statement.execute();
			connection.commit();
		}catch(SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public void excluirProduto(Long id) {
		try {
			String sql = "DELETE FROM produto WHERE codigo = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			statement.execute();
			
		}catch(SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public void editarProduto(Produto produto) {
		try {
			String sql = "UPDATE produto SET nome = ?, quantidade = ?, valor = ? WHERE codigo = ?";
			PreparedStatement statement  = connection.prepareStatement(sql);
			statement.setString(1, produto.getNome());
			statement.setInt(2, produto.getQuantidade());
			statement.setDouble(3, produto.getValor());
			statement.setLong(4, produto.getCodigo());
			statement.executeUpdate();
		}catch(SQLException e){
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public Produto buscarProduto(Long codigo) {
		
		try {
			String sql = "SELECT * FROM produto WHERE codigo = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, codigo);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				Produto produto = new Produto();
				produto.setCodigo(result.getLong("codigo"));
				produto.setNome(result.getString("nome"));
				produto.setQuantidade(result.getInt("quantidade"));
				produto.setValor(result.getDouble("valor"));
				
				return produto;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
