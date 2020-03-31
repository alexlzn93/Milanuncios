<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta charset="ISO-8859-1">
<title>PUBLICAR ANUNCIO</title>
</head>
<body>
<center><h1 style="color:Tomato;">${mensaje }</h1></center>
<center><h1 style="color:DodgerBlue;">${bienvenido }</h1></center><br>
<div class="container">
<form:form action="/anuncios/añadir_anuncio" role="form" method="post" modelAttribute="anuncio" > <!-- modelAttribute="anuncio" -->

	<!--<form:hidden path="id_anuncio"/>-->
    <div class="form-group"> <!-- Full Name -->
        <label for="full_name_id" class="font-weight-bold">NOMBRE</label>
        <form:input  class="form-control" id="user" path="user" value="${user}" placeholder="Introduzca tu nombre"/>
    </div>    

    <!-- cuando cambie el id_categoria a string podre hacerlo de manera dinamica desplegando una lista -->
     <div class="form-group">
     <label for="full_name_id" class="font-weight-bold">CATEGORIA</label><br>
     <form:select path="id_categoria" class="form-control form-control-md"><!-- items="categorias"  -->
	     	<form:option  value="1"> Informatica </form:option><br>
	      	<form:option  value="2"> Electronica</form:option><br>
	      	<form:option  value="3"> Moviles</form:option><br>
	      	<form:option  value="4"> Coches</form:option><br>
	      	<form:option  value="5"> Belleza</form:option><br>
	      	<form:option  value="6"> Hogar</form:option><br>
	   </form:select>
	  </div>
                            
    <div class="form-group">
        <label for="street2_id" class="font-weight-bold">TITULO</label>
        <form:input class="form-control" id="titulo" path="titulo" placeholder="Introduzca titulo"/>
    </div>    

    <div class="form-group"> 
        <label for="city_id" class="font-weight-bold">DESCRIPCION DEL PRODUCTO</label>
        <form:input class="form-control" id="descripcion" path="descripcion" placeholder="Introduzca descripcion del producto"/>
    </div>     
      <div class="form-group"> 
        <label for="zip_id" class="font-weight-bold">PRECIO</label>
        <form:input  class="form-control" id="precio" path="precio" placeholder="Introduzca precio"/>
    </div>
    <div class="form-group">
     <label for="full_name_id" class="font-weight-bold">PRIORIDAD</label><br>
    <form:select path="prioridad" class="form-control form-control-md">
	      <form:option  value="1"> Premium</form:option><br>
	      <form:option  value="2"> Basico </form:option><br> 
      </form:select>
     </div> 
                                
       <div class="form-group"> 
        <label for="zip_id" class="font-weight-bold">FECHA</label>
        <form:input type="date" min="2018-01-01" max="2025-12-31" class="form-control" id="fecha" path="fecha" />
    </div> 
    
    <div class="form-group"> 
        <button type="submit" class="btn btn-primary">PUBLICAR ANUNCIO</button>
    </div>   
     
    
</form:form>
<center>
		<a href="index" class="btn btn-primary btn-sm" role="button" aria-pressed="true">SALIR</a>
	</center>
</div>


</body>
</html>