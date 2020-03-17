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
	<div class="container-fluid">
 <div class="alert alert-success" role="alert">
 ${mensajeBienvenido }
</div> 
  </div>
<div class="container">				


<ul class="nav justify-content-center">
  <li class="nav-item">
    <a class="nav-link active" href="/mis_anuncios">MIS ANUNCIOS</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="/publicar_anuncio">PUBLICA TU ANUNCIO</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="totalAnunciosByCategoria">TOTAL ANUNCIOS DE CATEGORIA</a>
  </li>
   <li class="nav-item">
    <a class="nav-link" href="/nuevaCategoria">AÑADIR CATEGORIA</a>
  </li>
   <li class="nav-item">
    <a class="nav-link" href="/anunciosPrioridad">BUSCAR POR PRIORIDAD</a>
 
</ul>

	</div>
	

</body>
</html>