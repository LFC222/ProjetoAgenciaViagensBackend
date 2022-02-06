package com.javacrud.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJava {
	
	private static final String url = "jdbc:mysql://localhost:3306/demo_backend";
	private static final String user = "root";
	private static final String password = "2009@Tamoai";
	
	public static Connection createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver encontrado");
			
		} catch(ClassNotFoundException e) {
			System.out.println("Driver não encontrado. "+e.getMessage());
		}
		
		try {
			Connection connection = DriverManager.getConnection(url,user,password);
			System.out.println("Conectado com a base de dados");
			return connection;
			
		} catch(SQLException e) {
			System.out.println("Não conectado ao database. "+e.getMessage());
			return null;
		}
	}

}
