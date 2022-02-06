package com.javacrud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javacrud.bd.ConnectionJava;
import com.javacrud.model.Destino;


public class DestinoDao implements Crud {
	
	private static Connection connection = ConnectionJava.createConnection();
	private static String sql;
	

	public static void create(Destino destino) {
		
		sql = "INSERT INTO destinos VALUES (null,?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, destino.getNomeDestino());
			preparedStatement.setString(2, destino.getDescricao());
			preparedStatement.setInt(3, destino.getDias());
			preparedStatement.setInt(4, destino.getPreco());
			
			preparedStatement.executeUpdate();
			
			System.out.println("Inserção correta no banco de dados");
			
		} catch(SQLException e) {
			
			System.out.println("Inserção incorreta no banco de dados");
		}
		
	}
	
	public static void deleteId(int destinoId) {
		sql = "DELETE FROM destinos WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt (1,destinoId);
			preparedStatement.executeUpdate();
			
			System.out.println("-- correct delete on destinos --");
			
		} catch(SQLException e) {
			System.out.println("-- incorrect delete on destinos --. " + e.getMessage());
		}
		
	}
	
	
	public static List<Destino> findAll(String buscar){
		sql = String.format("SELECT * FROM destinos WHERE nomeDestino LIKE '%s%%' OR '%s%%' ", buscar,buscar);
		List<Destino> destinos = new ArrayList<Destino> ();
		
		try {
			
			Statement statement = connection.createStatement();
			ResultSet resultSet =  statement.executeQuery(sql);
			
			while(resultSet.next()) {
				Destino destino = new Destino();
				
				destino.setId(resultSet.getInt("id"));
				destino.setNomeDestino(resultSet.getString("nomeDestino"));
				destino.setDescricao(resultSet.getString("descricao"));
				destino.setDias(resultSet.getInt("dias"));
				destino.setPreco(resultSet.getInt("preco"));
				
				destinos.add(destino);
			}
			
			System.out.println("-- correct find destinos --");
			return destinos;
			
		}catch(SQLException e) {
			System.out.println("-- incorrect find destinos --." + e.getMessage());
			return null;
		}
		
		}
	
	
	public static Destino findDestById(int destinoId) {
		sql = String.format("SELECT * FROM destinos WHERE id = %d", destinoId);
		
		try {
			
			Statement statement = connection.createStatement();
			ResultSet resultSet =  statement.executeQuery(sql);
			Destino destino = new Destino();
			
			while(resultSet.next()) {
				
				destino.setId(resultSet.getInt("id"));
				destino.setNomeDestino(resultSet.getString("nomeDestino"));
				destino.setDescricao(resultSet.getString("descricao"));
				destino.setDias(resultSet.getInt("dias"));
				destino.setPreco(resultSet.getInt("preco"));
				}
			
			System.out.println("-- correct find destinos --");
			return destino;
			
	}catch(SQLException e) {
		System.out.println("Incorrect find usuarios." + e.getMessage());
		}
		return null;
		}
	
	
	public static void update(Destino destino) {
		
		sql = "UPDATE destinos SET nomeDestino=?,descricao=?,dias=?,preco=? WHERE id=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, destino.getNomeDestino());
			preparedStatement.setString(2, destino.getDescricao());
			preparedStatement.setInt(3, destino.getDias());
			preparedStatement.setInt(4, destino.getPreco());
			preparedStatement.setInt(5,destino.getId());
			
			preparedStatement.executeUpdate();
			
			System.out.println("Update correto no banco de dados");
			
		} catch(SQLException e) {
			
			System.out.println("Update incorreto no banco de dados");
		}
		
	}
}
