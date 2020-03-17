<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro Usuario</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<%@ page import= "java.util.Date" %>
<body>

<%Date fecha= new Date(); %>
<center><h2>MADRID A <%=fecha.toString() %>  </h2></center>
<div class="container">
<form role="form" method="get" action="usario_existe">
<div class="form-group">
    <label for="user">Nombre :</label>
    <input type="text" class="form-control" id="username" name="user"  placeholder="Introduzca nombre">
   	
   	<label for="user">Password :</label>
   	<input type="password" class="form-control" id="password" name="password" placeholder="Introduzca contraseña">
    
  </div>

  
  <button type="submit" class="btn btn-success" value="alta" name="alta" >PUBLICA OTRO ANUNCIO</button>
 
  
</form>

<h1>${mensajeError }</h1>
 
	<center>
		<a href="index" class="btn btn-primary btn-sm" role="button" aria-pressed="true">IR AL MENU</a>
	</center>
</div>
</body>
</html>