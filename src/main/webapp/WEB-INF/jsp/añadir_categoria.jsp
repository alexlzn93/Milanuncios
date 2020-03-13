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
<title>AÑADIR CATEGORIA</title>
</head>
<body>
<div class="container">
<form action="añadirCategoria" role="form" method="post" >

    <div class="form-group"> <!-- Full Name -->
        <label for="full_name_id" class="font-weight-bold">ID-Categoria</label>
        <input type="text" class="form-control" id="id" name="id" placeholder="Introduzca id Categoria">
    </div>    
    <div class="form-group"> <!-- Full Name -->
        <label for="full_name_id" class="font-weight-bold">Descripcion</label>
        <input type="text" class="form-control" id="descripcion" name="descripcion" placeholder="Introduzca descripcion de Categoria">
    </div> 
    <div class="form-group"> <!-- Submit Button -->
        <button type="submit" class="btn btn-primary">AÑADIR CATEGORIA</button>
    </div>  
    </form>
    
    <h1>${categoriaNueva}</h1>
<center>
		<a href="index" class="btn btn-primary btn-sm" role="button" aria-pressed="true">Menu</a>
	</center>
</div>
</body>
</html>