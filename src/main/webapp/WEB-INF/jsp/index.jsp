<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="ISO-8859-1">
<title>BIENVENDIO A MILANUNCIOS</title>
</head>
<body>
<center>
<div class="alert alert-info" role="alert">
 <h2> BIENVENIDO A MILANUNCIOS </h2>
</div>
</center>
	
  
	
	<div class="container">	
	<form role="form" method="get" action="busqueda_anuncio">
	<div class="form-group">
    <label for="user">¿QUE ARTICULO DESEA BUSCAR?</label>
    <input type="text" class="form-control" id="palabra" name="palabra"  placeholder="Introduzca palabra clave">
  	</div>
  
  	<button type="submit" class="btn btn-success" value="buscar" name="buscar" >BUSCAR </button>
 </form>
  </div><br>

  
 
 
  
<div class="container">				

  <ul class="nav justify-content-center">
  <li class="nav-item mx-2">
    <a class="btn btn-primary btn-sm" role="button" href="/lista_categoria">VER CATEGORIAS</a>
  </li>
  <li class="nav-item mx-2">
    <a class="btn btn-primary btn-sm" role="button" href="/user/logueate">LOGUEATE</a>
  </li>
   <li class="nav-item mx-2">
    <a class="btn btn-primary btn-sm" role="button" href="user/alta_user">REGISTRATE</a>
  </li>
  </ul>
  
   
</div>
<br>
<div class="container-fluid">
<p  class="alert alert-dark" >ANUNCIOS PUBLICADOS</p>
	
	<table class="table">
	
		<thead>
		
			<tr>
				
				<th scope="col">NOMBRE</th>
				<th scope="col">CATEGORIA</th>
				<th scope="col">TITULO</th>
				<th scope="col">DESCRIPCION</th>
				<th scope="col">PRECIO</th>
				<th scope="col">PRIORIDAD</th>
				<th scope="col">FECHA</th>
				

			</tr>
		</thead>
		<tbody>


			<c:forEach var="anuncio" items="${anuncios }" varStatus="loop">

				<tr>
					
					<td>${anuncio.user}</td>
					<td>${anuncio.id_categoria}</td>
					<td>${anuncio.titulo}</td>
					<td>${anuncio.descripcion}</td>
					<td>${anuncio.precio}</td>
					<td>${anuncio.prioridad}</td>
					<td>${anuncio.fecha}</td>
					




				</tr>

			</c:forEach>
		</tbody>

	</table>
	
	</div>

</body>
</html>