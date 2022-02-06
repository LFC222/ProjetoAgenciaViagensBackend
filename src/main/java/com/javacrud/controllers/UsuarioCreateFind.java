package com.javacrud.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javacrud.dao.UsuarioDao;
import com.javacrud.model.Usuario;


@WebServlet("/UsuarioCreateFind")
public class UsuarioCreateFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UsuarioCreateFind() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pesquisa = request.getParameter("pesquisa");
		
		if(pesquisa == null) {
			 pesquisa = "";
		}
		
		List<Usuario> usuarios = UsuarioDao.find(pesquisa);
		request.setAttribute("usuarios", usuarios);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Lista.jsp");
		requestDispatcher.forward(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		
		usuario.setNome(request.getParameter("nome"));
		usuario.setCpf(request.getParameter("cpf"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setCelular(request.getParameter("celular"));
		
		UsuarioDao.create(usuario);
		
		doGet(request, response);
	}

}
