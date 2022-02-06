package com.javacrud.dao;

import java.util.List;

import com.javacrud.model.Destino;
import com.javacrud.model.Usuario;

public interface Crud{
	
	public static void create(Usuario usuario) {}
	public static void delete(int usuarioId) {}
	public static List<Usuario> find(String pesquisa){return null;}
	public static Usuario findById(int usuarioId) {return null;}
	public static void update(Usuario usuario) {}
	
	public static void create(Destino destino) {}
	public static void deleteId(int destinoId) {}
	public static List<Destino> findAll(String buscar){return null;}
	public static Destino findDestById(int destinoId) {return null;}
	public static void update(Destino destino) {}
}