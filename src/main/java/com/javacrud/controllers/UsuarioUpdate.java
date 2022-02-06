package com.javacrud.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javacrud.dao.UsuarioDao;
import com.javacrud.model.Usuario;


@WebServlet("/UsuarioUpdate")
public class UsuarioUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UsuarioUpdate() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int usuarioId = Integer.parseInt(request.getParameter("usuarioId"));
		Usuario usuario = UsuarioDao.findById(usuarioId);
		
		request.setAttribute("usuario", usuario);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("formUpdate.jsp");
		requestDispatcher.forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario usuario = new Usuario();
		
		usuario.setId(Integer.parseInt(request.getParameter("id")));
		usuario.setNome(request.getParameter("nome"));
		usuario.setCpf(request.getParameter("cpf"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setCelular(request.getParameter("celular"));
		
		UsuarioDao.update(usuario);
		
		UsuarioCreateFind usuarioCreateFind = new UsuarioCreateFind();
		usuarioCreateFind.doGet(request, response);

	}

}
