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
<title>ANUNCIOS PUBLICADOS CON SU BUSQUEDA</title>
</head>
<body>
<br>
<div class="container-fluid">
	<table class="table">
		<thead>
			<tr>
				
				<th scope="col">NOMBRE</th>
				<th scope="col">IDCATEGORIA</th>
				<th scope="col">TITULO</th>
				<th scope="col">DESCRIPCION</th>
				<th scope="col">PRECIO</th>
				<th scope="col">PRIORIDAD</th>
				<th scope="col">FECHA</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="anuncio" items="${lista_anuncios }"
				varStatus="loop">

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


<center><h1>${mensaje }</h1></center>
</body>
</html>