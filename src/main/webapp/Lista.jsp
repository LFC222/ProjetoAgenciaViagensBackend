<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>Lista de Usuários</title>
</head>
<body>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="index.html">DreamTour</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.html">Cadastrar Usuários <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="UsuarioCreateFind">Lista de Usuários</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="CadDestino.html">Cadastrar Destinos<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="DestinoCreateFind">Lista de Destinos</a>
      </li>
      

    </ul>
    
    <form action="UsuarioCreateFind" method="get" class="form-inline my-2 my-lg-0">
      <input name="pesquisa" class="form-control mr-sm-2" type="search" placeholder="buscar" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">buscar</button>
    </form>

  </div>
</nav>

<br/>

<div class="container">
	<div class="row">
		<div class="col-md-7">
			<hr/>
			<h3>Cadastros</h3>
			<hr/>
			<table class="table">
				<thead>
					<tr>
						<th>#</th>
						<th>Nome</th>
						<th>CPF</th>
						<th>Email</th>
						<th>Celular</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${usuarios}" var="usuario">
					 <tr>
						<td>${usuario.id}</td>
						<td>${usuario.nome }</td>
						<td>${usuario.cpf }</td>
						<td>${usuario.email }</td>
						<td>${usuario.celular}</td>
						<td>
							<a href="UsuarioDelete?usuarioId=${usuario.id}">deletar</a> |
							<a href="UsuarioUpdate?usuarioId=${usuario.id}">atualizar</a>
						</td>
					 </tr>
					</c:forEach>
				</tbody>
			</table>
			<h5><a href="index.html">Voltar</a></h5>
		</div>
	</div>
</div>


</body>
</html>