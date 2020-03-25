<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro Usuario</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
</head>
<%@ page import= "java.util.Date" %>
<body>

<%Date fecha= new Date(); %>
<center><h2>MADRID A <%=fecha.toString() %>  </h2></center>
	<div class="container-fluid">
 <div class="alert alert-danger" role="alert">
 ${mensajeAltaUser }
</div> 
  </div>
<div class="container">
<form:form role="form" method="get" action="/add_usuario" modelAttribute="usuario">
<div class="form-group">
    <label for="user">Nombre :</label>
    <form:input  class="form-control" id="user" path="user" value="${usuario.getUser()}" placeholder="Introduzca nombre"/>
  </div>
  <div class="form-group">
    <label for="email">Email :</label>
    <form:input class="form-control" id="email" path="email"  value="${usuario.getEmail()}" placeholder="Introduzca email"/>
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <form:password class="form-control" id="password" path="password" value="${usuario.getPassword()}" placeholder="Introduzca contraseña"/>
  </div>

  
  <button type="submit" class="btn btn-success" value="alta" name="alta" >REGISTRATE</button>
 
  
</form:form>


<center><h3> ${mensaje}</h3>
<center><h3> ${alerta}</h3>
 
	<center>
		<a href="index" class="btn btn-primary btn-sm" role="button" aria-pressed="true">IR AL MENU</a>
	</center>
	
</div>
</body>
</html>