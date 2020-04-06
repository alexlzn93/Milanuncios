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
<title>Categorias</title>
</head>
<body>
<div class="container">
<center><h1><p class="font-italic"> CATEGORIAS </p></h1></center>
<c:forEach var="categoria" items="${categorias }" varStatus="loop">

<nav class="navbar navbar-expand-lg navbar-light bg-light">
 <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="lista_anuncios_por_categoria?id_categoria=${categoria.id_categoria }">${categoria.descripcion } <span class="sr-only">(current)</span></a>
      </li>
       </ul>
       </div>
       </nav>
   
      
      
    </c:forEach><br>
    </div>
    <div class="container">
   <center> <a href="/app" class="btn btn-primary btn-sm" role="button" aria-pressed="true">IR AL MENU</a></center>
    </div>
    
     
    
  


	

		
	
	
		
	
	


</body>
</html>