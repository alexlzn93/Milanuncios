<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MIS ANUNCIOS</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<%@ page import= "java.util.Date" %>
<body>

<%Date fecha= new Date(); %>
<center><h2>MADRID A <%=fecha.toString() %>  </h2></center>
<div class="container">
<form role="form" method="post" action="ver_mis_anuncios">
<div class="form-group">
    <label for="user">INTRODUZCA SU NOMBRE PARA VER TUS ANUNCIOS</label>
    <input type="text" class="form-control" id="user" name="user"  placeholder="Introduzca su nombre para ver sus anuncios">
  </div>


  
  <button type="submit" class="btn btn-success" value="alta" name="alta" >VER MIS ANUNCIOS</button>
 
  
</form>
<h1> ${anuncio }</h1>
<h1> ${mensaje }</h1>

	<center>
		<a href="index" class="btn btn-primary btn-sm" role="button" aria-pressed="true">IR AL MENU</a>
	</center>
</div>
</body>
</html>