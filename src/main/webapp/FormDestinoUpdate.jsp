<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Atualizar Cadastro</title>
</head>
<body>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">DreamTour</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.html">Cadastro <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="UsuarioCreateFind">Lista de Usuarios</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="CadDestino.html">Cadastro Destinos<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="DestinoCreateFind">Lista de Destinos</a>
      </li>
      

    </ul>

  </div>
</nav>


<div class="container">
	<div class="row">
		<div class="col-md-7">
			<hr/>
			<h3>Atualizar Dados</h3>
			<hr/>
			<form action="DestinoUpdate" method="POST">
			<input value="${destino.id}" name="id" style="visibility:hidden">
			
				<div class="form-floating mb-3">
					<input value="${destino.nomeDestino}" name="nomeDestino"  type="text" class="form-control">
					<label>Nome do Destino</label>
				</div>
				
				<div class="form-floating mb-3">
					<input value="${destino.descricao}" name="descricao" maxlength="255" type="text" class="form-control">
					<label>Descrição</label>
				</div>
				
				<div class="form-floating mb-3">
					<input value="${destino.dias}" name="dias"  type="number" class="form-control">
					<label>Dias</label>
				</div>
				<div class="form-floating mb-3">
					<input value="${destino.preco}" name="preco" maxlength="15" type="number" class="form-control">
					<label>Preço</label>
				</div>
				
				<button class="btn btn-success" type="submit"> Alterar</button>
				<button class="btn btn-secondary" type="reset">Limpar Formulário</button>
			</form>
			<h5><a href="CadDestino.html">Voltar</a></h5>
			<br/>
			
		</div>
	</div>
</div>




</body>
</html>