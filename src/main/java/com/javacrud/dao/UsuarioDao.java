package com.javacrud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javacrud.bd.ConnectionJava;
import com.javacrud.model.Usuario;

public class UsuarioDao implements Crud {
	
	private static Connection connection = ConnectionJava.createConnection();
	private static String sql;
	

public static void create(Usuario usuario) {
	
	sql = "INSERT INTO usuarios VALUES (null,?,?,?,?)";
	
	try {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, usuario.getNome());
		preparedStatement.setString(2, usuario.getCpf());
		preparedStatement.setString(3, usuario.getEmail());
		preparedStatement.setString(4, usuario.getCelular());
		
		preparedStatement.executeUpdate();
		
		System.out.println("Inserção correta no banco de dados");
		
	} catch(SQLException e) {
		
		System.out.println("Inserção incorreta no banco de dados");
	}
		
	}
	
	public static void delete(int id) {
		sql = "DELETE FROM usuarios WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt (1,id);
			preparedStatement.executeUpdate();
			
			System.out.println("-- correct delete on cliente --");
			
		} catch(SQLException e) {
			System.out.println("-- incorrect delete on cliente --. " + e.getMessage());
		}
		
	}
	
	public static List<Usuario> find(String pesquisa){
		
		sql = String.format("SELECT * FROM usuarios WHERE nome LIKE '%s%%' OR '%s%%' ", pesquisa,pesquisa);
		List<Usuario> usuarios = new ArrayList<Usuario> ();
		
		try {
			
			Statement statement = connection.createStatement();
			ResultSet resultSet =  statement.executeQuery(sql);
			
			while(resultSet.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setId(resultSet.getInt("id"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setCpf(resultSet.getString("cpf"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setCelular(resultSet.getString("celular"));
				
				usuarios.add(usuario);
			}
			
			System.out.println("-- correct find usuarios --");
			return usuarios;
			
		}catch(SQLException e) {
			System.out.println("-- incorrect find usuarios --." + e.getMessage());
			return null;
		}		
		
	}
	
	public static Usuario findById(int usuarioId ) {
		sql = String.format("SELECT * FROM usuarios WHERE id = %d", usuarioId);
		
		try {
			
			Statement statement = connection.createStatement();
			ResultSet resultSet =  statement.executeQuery(sql);
			Usuario usuario = new Usuario();
			
			while(resultSet.next()) {
				
				usuario.setId(resultSet.getInt("id"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setCpf(resultSet.getString("cpf"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setCelular(resultSet.getString("celular"));
				}
			
			System.out.println("-- correct find usuarios --");
			return usuario;
			
	}catch(SQLException e) {
		System.out.println("Incorrect find usuarios." + e.getMessage());
		}
		return null;
	}
	
	public static void update(Usuario usuario) {
		

		sql = "UPDATE usuarios SET nome=?,cpf=?,email=?,celular=? WHERE id=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, usuario.getNome());
			preparedStatement.setString(2, usuario.getCpf());
			preparedStatement.setString(3, usuario.getEmail());
			preparedStatement.setString(4, usuario.getCelular());
			preparedStatement.setInt(5,usuario.getId());
			
			preparedStatement.executeUpdate();
			
			System.out.println("Update correto no banco de dados");
			
		} catch(SQLException e) {
			
			System.out.println("Update incorreta no banco de dados");
		}

	}
	
	
}
