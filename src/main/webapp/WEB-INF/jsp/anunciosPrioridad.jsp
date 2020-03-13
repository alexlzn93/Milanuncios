<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Insert title here</title>
</head>
<body>
<div class="container">
<br>
<br>
<a href="anunciosByprioridad?prioridad=1"class="btn btn-primary btn-sm" role="button" aria-pressed="true">PREMIUM</a>
<a href="anunciosByprioridad?prioridad=2" class="btn btn-primary btn-sm" role="button" aria-pressed="true">BASICO</a>
<br>
<BR>

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


			<c:forEach var="anuncio" items="${lista_anuncio_prioridad }" varStatus="loop">

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