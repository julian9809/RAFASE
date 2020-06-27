<%-- 
    Document   : sesion
    Created on : 22/06/2020, 03:33:15 PM
    Author     : david
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Nosotros tenemos que poner eso xd">
        <title>Iniciar Sesión</title>
        <!-- Bootstrap core CSS -->
        <link href="../css/bootstrap/bootstrap.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="../css/custom/sign.css" rel="stylesheet">
        <!-- Customs fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Averia+Libre&display=swap" rel="stylesheet">
    </head>
    <body>
        <form class="form-signin">
            <div class="text-center mb-4">
                <img id="logo" class="mb-4" src="../img/Logo.png" alt="">
                <h1 class="h3 mb-3 font-weight-normal">Iniciar Sesión</h1>
                <p>Por favor, ingrese sus datos de sesión.</p>
            </div>

            <div class="form-label-group">
                <input type="text" id="username" class="form-control" placeholder="Username" required autofocus>
                <label for="username">Nombre de Usuario</label>
            </div>

            <div class="form-label-group">
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                <label for="inputPassword">Contraseña</label>
            </div>

            <div class="checkbox mb-3">
                <label>
                    <input type="checkbox" value="remember-me"> Recuérdame
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Iniciar Sesión</button>
            <p class="mt-5 mb-3 text-muted text-center"><a href="#">Administrador</a> &copy; 2020</p>
        </form>
        <!-------------------------------Scripts--------------------------------->
        <script src="../js/jquery.js"></script>
        <script src="../js/bootstrap.min.js"></script>
    </body>
</html>
