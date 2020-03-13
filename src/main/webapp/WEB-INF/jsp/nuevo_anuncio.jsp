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
<title>PUBLICAR ANUNCIO</title>
</head>
<body>
<center><h1 style="color:Tomato;">${mensaje }</h1></center>
<center><h1 style="color:DodgerBlue;">${bienvenido }</h1></center><br>
<div class="container">
<form action="añadir_anuncio" role="form" method="get" >

    <div class="form-group"> <!-- Full Name -->
        <label for="full_name_id" class="font-weight-bold">NOMBRE</label>
        <input type="text" class="form-control" id="user" name="user" value="${user}" placeholder="Introduzca tu nombre">
    </div>    

    
     <div class="form-group">
     <label for="full_name_id" class="font-weight-bold">CATEGORIA</label><br>
      <label><input type="checkbox" id="id_categoria" name="id_categoria" value="1"> Informatica</label><br>
      <label><input type="checkbox" id="id_categoria" name="id_categoria" value="2"> Electronica</label><br>
      <label><input type="checkbox" id="id_categoria" name="id_categoria" value="3"> Moviles</label><br>
      <label><input type="checkbox" id="id_categoria" name="id_categoria" value="4"> Coches</label><br>
      <label><input type="checkbox" id="id_categoria" name="id_categoria" value="5"> Belleza</label><br>
      <label><input type="checkbox" id="id_categoria" name="id_categoria" value="6"> Hogar</label><br>
 	  </div>
                            
    <div class="form-group"> <!-- Street 2 -->
        <label for="street2_id" class="font-weight-bold">TITULO</label>
        <input type="text" class="form-control" id="titulo" name="titulo" placeholder="Introduzca titulo">
    </div>    

    <div class="form-group"> <!-- City-->
        <label for="city_id" class="font-weight-bold">DESCRIPCION DEL PRODUCTO</label>
        <input type="text" class="form-control" id="descripcion" name="descripcion" placeholder="Introduzca descripcion del producto">
    </div>     
      <div class="form-group"> <!-- Zip Code-->
        <label for="zip_id" class="font-weight-bold">PRECIO</label>
        <input type="text" class="form-control" id="precio" name="precio" placeholder="Introduca precio">
    </div>
    <div class="form-group">
     <label for="full_name_id" class="font-weight-bold">PRIORIDAD</label><br>
      <label><input type="checkbox" id="prioridad" name="prioridad" value="1"> Premium</label><br>
      <label><input type="checkbox" id="prioridad" name="prioridad" value="2"> Basico</label><br> 
      
     <!--  <div class="form-group"> 
        <label for="zip_id" class="font-weight-bold">FECHA</label>
        <input type="text" class="form-control" id="fecha" name="fecha" placeholder=" YYYY-MM-DD">
    </div> 
    -->                               
       <div class="form-group"> <!-- Zip Code-->
        <label for="zip_id" class="font-weight-bold">FECHA2</label>
        <input type="date" min="2018-01-01" max="2025-12-31" class="form-control" id="fecha" name="fecha" >
    </div> 
    
    <div class="form-group"> <!-- Submit Button -->
        <button type="submit" class="btn btn-primary">PUBLICAR ANUNCIO</button>
    </div>   
     
    
</form>
<center>
		<a href="index" class="btn btn-primary btn-sm" role="button" aria-pressed="true">SALIR</a>
	</center>
</div>


</body>
</html>