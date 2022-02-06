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
  <a class="navbar-brand" href="#">Navbar</a>
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
        <a class="nav-link" href="index.html">Cadastro Destinos<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="UsuarioCreateFind">Lista de Destinos</a>
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
			<form action="UsuarioUpdate" method="POST">
			<input value="${usuario.id}" name="id" style="visibility:hidden">
			
				<div class="form-floating mb-3">
					<input value="${usuario.nome}" name="nome"  type="text" class="form-control">
					<label>Nome Completo</label>
				</div>
				
				<div class="form-floating mb-3">
					<input value="${usuario.cpf}" name="cpf" maxlength="11" type="text" class="form-control">
					<label>CPF</label>
				</div>
				
				<div class="form-floating mb-3">
					<input value="${usuario.email}" name="email"  type="text" class="form-control">
					<label>E-Mail</label>
				</div>
				<div class="form-floating mb-3">
					<input value="${usuario.celular}" name="celular" maxlength="15" type="text" class="form-control">
					<label>Celular</label>
				</div>
				
				<button class="btn btn-success" type="submit"> Alterar</button>
				<button class="btn btn-secondary" type="reset">Limpar Formulário</button>
			</form>
			<h5><a href="index.html">Voltar</a></h5>
			<br/>
			
		</div>
	</div>
</div>




</body>
</html>