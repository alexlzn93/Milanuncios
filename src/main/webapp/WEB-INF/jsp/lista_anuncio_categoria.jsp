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
<title>ANUNCIOS POR CATEGORIAS</title>
</head>
<body>
	<h1>
		<center>${descripcion_categoria }</center>
	</h1>

	<table class="table">
		<thead>
			<tr>
				
				<th scope="col">NOMBRE</th>
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
					<td>${anuncio.titulo}</td>
					<td>${anuncio.descripcion}</td> 
					<td>${anuncio.precio}</td>
					<td>${anuncio.prioridad}</td>
					<td>${anuncio.fecha}</td>
					

					





				</tr>

			</c:forEach>

		</tbody>

	</table>
	
		
		<ul class="nav">
  <li class="nav-item mx-2">
    <a href="lista_categoria" class="btn btn-primary btn-sm" role="button" aria-pressed="true">IR A CATEGORIAS</a>
  </li>

    	
  <li class="nav-item">
    <a href="index" class="btn btn-primary btn-sm" role="button" aria-pressed="true">IR AL MENU</a>
  </li>

    </ul>
   



	
	
		
		

</body>
</html>