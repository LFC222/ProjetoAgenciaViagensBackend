package com.javacrud.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javacrud.dao.DestinoDao;
import com.javacrud.model.Destino;


@WebServlet("/DestinoCreateFind")
public class DestinoCreateFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public DestinoCreateFind() {
        super();
        }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String buscar = request.getParameter("buscar");
		
			if(buscar == null) {
				 buscar = "";
			}
			
			List<Destino> destinos = DestinoDao.findAll(buscar);
			request.setAttribute("destinos", destinos);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListaDestino.jsp");
			requestDispatcher.forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Destino destino = new Destino();
		
		destino.setNomeDestino(request.getParameter("nomeDestino"));
		destino.setDescricao(request.getParameter("descricao"));
		destino.setDias(Integer.parseInt(request.getParameter("dias")));
		destino.setPreco(Integer.parseInt(request.getParameter("preco")));
		
		DestinoDao.create(destino);
		
		doGet(request, response);
	}

}
