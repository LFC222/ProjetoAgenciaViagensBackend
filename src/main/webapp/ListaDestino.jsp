<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>Lista de Destinos</title>
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
    
    <form action="DestinoCreateFind" method="get" class="form-inline my-2 my-lg-0">
      <input name="buscar" class="form-control mr-sm-2" type="search" placeholder="buscar" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
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
						<th>Nome Destinos</th>
						<th>Descrição</th>
						<th>Dias</th>
						<th>Preço</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${destinos}" var="destino">
					 <tr>
						<td>${destino.id}</td>
						<td>${destino.nomeDestino}</td>
						<td>${destino.descricao }</td>
						<td>${destino.dias }</td>
						<td>${destino.preco}</td>
						<td>
							<a href="DestinoDelete?destinoId=${destino.id}">deletar</a> |
							<a href="DestinoUpdate?destinoId=${destino.id}">atualizar</a>
						</td>
					 </tr>
					</c:forEach>
				</tbody>
			</table>
			<h5><a href="CadDestino.html">Voltar</a></h5>
		</div>
	</div>
</div>


</body>
</html>