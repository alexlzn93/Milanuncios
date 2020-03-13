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
<title>NUMERO ANUNCIOS DE CATEGORIA</title>
</head>
<body>
<div class="container theme-showcase" role="main">
			<hr class="featurette-divider">
			
			<form class="form-signin" action="anunciosTotales_deCategoria" method="post">        
		<h3 class="form-signin-heading">SELECCIONA CATEGORIA PARA VER CUANTOS ANUNCIOS TIENE</h3>        
		<label><input type="checkbox" id="id_categoria" name="id_categoria" value="1"> Informatica</label><br>
      	<label><input type="checkbox" id="id_categoria" name="id_categoria" value="2"> Electronica</label><br>
      	<label><input type="checkbox" id="id_categoria" name="id_categoria" value="3"> Moviles</label><br>
     	<label><input type="checkbox" id="id_categoria" name="id_categoria" value="4"> Coches</label><br>
      	<label><input type="checkbox" id="id_categoria" name="id_categoria" value="5"> Belleza</label><br>
      	<label><input type="checkbox" id="id_categoria" name="id_categoria" value="6"> Hogar</label><br>
				<button class="btn btn-lg btn-primary btn-block" type="submit">BUSCAR</button>
				
			</form>

		
			
  <center><h2>${numero }</h2></center>
  <a class="nav-link" href="lista_anuncios_por_categoria?id_categoria=${categoria.id_categoria }">${numero }<span class="sr-only">(current)</span></a>
  
</body>
</html>