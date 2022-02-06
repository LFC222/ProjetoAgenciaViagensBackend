package com.javacrud.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javacrud.dao.DestinoDao;
import com.javacrud.model.Destino;


@WebServlet("/DestinoUpdate")
public class DestinoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DestinoUpdate() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int destinoId = Integer.parseInt(request.getParameter("destinoId"));
		Destino destino = DestinoDao.findDestById(destinoId);
		
		request.setAttribute("destino", destino);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("FormDestinoUpdate.jsp");
		requestDispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Destino destino = new Destino();
		
		destino.setId(Integer.parseInt(request.getParameter("id")));
		destino.setNomeDestino(request.getParameter("nomeDestino"));
		destino.setDescricao(request.getParameter("descricao"));
		destino.setDias(Integer.parseInt(request.getParameter("dias")));
		destino.setPreco(Integer.parseInt(request.getParameter("preco")));
		
		DestinoDao.update(destino);
		
		DestinoCreateFind destinoCreateFind = new DestinoCreateFind();
		destinoCreateFind.doGet(request, response);

	}

}
