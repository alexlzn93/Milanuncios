
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Please sign in</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>
  </head>
  <body>
  	<div class="container-fluid">
 <div class="alert alert-success" role="alert">
 ${mensajeError}
</div> 
  </div>
     <div class="container">
      <form class="form-signin" method="post" action="usuarioLogueado">
      
        <div class="container-fluid"><h1>Please sign in</h1></div>
        
       <br>
        <p>
          <label for="username" class="sr-only">Username</label>
          <input type="text" id="username" name="user" class="form-control" placeholder="Introduzca nombre de usuario" required autofocus>
        </p>
        <p>
          <label for="password" class="sr-only">Password</label>
          <input type="password" id="password" name="password" class="form-control" placeholder="Introduzca password" required>
        </p>
<input name="_csrf" type="hidden" value="f3632c9a-5e47-4f35-bf50-e79637325592" />
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
</div>
</body></html>