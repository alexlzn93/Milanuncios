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
<title>TUS ANUNCIOS</title>
</head>
<body>
	
<form role="form" method="get" action="ver_mis_anuncios">
<div class="form-group">
    <label for="user">INTRODUZCA SU NOMBRE PARA VER TUS ANUNCIOS</label>
    <input type="text" class="form-control" id="user" name="user"  placeholder="Introduzca su nombre para ver sus anuncios">
  </div>


  
  <button type="submit" class="btn btn-success" value="alta" name="alta" >VER MIS ANUNCIOS</button>
 
  
</form>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">ID_ANUNCIO</th>
				<th scope="col">NOMBRE</th>
				<th scope="col">IDCATEGORIA</th>
				<th scope="col">TITULO</th>
				<th scope="col">DESCRIPCION</th>
				<th scope="col">PRECIO</th>
				<th scope="col">PRIORIDAD</th>
				<th scope="col">FECHA</th>
				<th scope="col"></th>


			</tr>
		</thead>
		<tbody>


			<c:forEach var="anuncio" items="${listado_anuncios }" varStatus="loop">

				<tr>
			<td>${anuncio.id_anuncio}</td>
			<td>${anuncio.user}</td> 
			<td>${anuncio.id_categoria}</td>
			<td>${anuncio.titulo}</td>
			<td>${anuncio.descripcion}</td> 
			<td>${anuncio.precio}</td>
			<td>${anuncio.prioridad}</td>
			<td>${anuncio.fecha}</td>
			<td><a href="/anuncios/eliminarAnuncio?id_anuncio=${anuncio.id_anuncio}&user=${anuncio.user}" class="btn btn-primary btn-sm" role="button" aria-pressed="true">ELIMINAR </a></td>
			<td><a href="/anuncios/editarAnuncio?id_anuncio=${anuncio.id_anuncio}" class="btn btn-primary btn-sm" role="button" aria-pressed="true">EDITAR </a></td>
				</tr>

			</c:forEach>

		</tbody>

	</table>
	
	<h1>${mensaje }</h1>
	
		
	
  	<ul class="nav">
  <li class="nav-item mx-2">
    <a href="lista_categoria" class="btn btn-primary btn-sm" role="button" aria-pressed="true">IR A CATEGORIAS</a>
  </li>

    	<ul class="nav">
  <li class="nav-item">
    <a href="index" class="btn btn-primary btn-sm" role="button" aria-pressed="true">IR AL MENU</a>
  </li>
  
	

</body>
</html>