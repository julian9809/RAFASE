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
        <!-- RAFASE icon -->
        <link rel="icon" href="../img/Logo.png" type="image/png">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
        <!-- Google Fonts Roboto -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="../css/bootstrap/bootstrap.min.css">
        <!-- Material Design Bootstrap -->
        <link rel="stylesheet" href="../css/mdb/mdb.min.css">
        <!-- Custom styles for this template -->
        <link href="../css/custom/sign.css" rel="stylesheet">
        <link rel="stylesheet" href="../css/custom/checkPassword.css">
        <!-- Customs fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Averia+Libre&display=swap" rel="stylesheet">
        <!-------------------------------Scripts--------------------------------->
        <!-- jQuery -->
        <script type="text/javascript" src="../js/jquery.js"></script>
        <!-- Bootstrap tooltips -->
        <script type="text/javascript" src="../js/popper.min.js"></script>
        <!-- Bootstrap core JavaScript -->
        <script type="text/javascript" src="../js/bootstrap.min.js"></script>
        <!-- MDB core JavaScript -->
        <script type="text/javascript" src="../js/mdb.min.js"></script>
        <!-- Custom Javacript-->
        <script type="text/javascript" src="../js/custom/checkPassword.js"></script>
        <script type="text/javascript" src="../js/custom/viewPassword.js"></script>
    </head>
    <body>
        <form class="form-signin" action = "../IniciarSesion" method = "post">
            <div class="text-center">
                <img id="logo" class="mb-2" src="../img/Logo.png" alt="">
                <h1 class="h3 mb-2 font-weight-normal">Iniciar Sesión</h1>
                <p>Por favor, ingrese sus datos de sesión.</p>
            </div>
            <div class="md-form md-bg white input-with-pre-icon">
                <i class="fas fa-user input-prefix"></i>
                <input type="text" id="username" class="form-control white validate mb-0" autocomplete="username" required autofocus name = "username">
                <label for="username">Nombre de Usuario</label>
            </div>
            <div class="md-form md-bg white input-with-pre-icon mb-3">
                <i class="fas fa-lock input-prefix"></i>
                <input type="password" id="password" class="form-control white validate mb-0" autocomplete="current-password" required name = "password">
                <label for="password">Contraseña</label>
                <div id="show_password" class="fa fa-eye-slash password-icon"></div>
            </div>
            <div class="custom-control custom-checkbox mb-2">
                <input type="checkbox" class="custom-control-input" value="remember-me" id="remember-me">
                <label class="custom-control-label" for="remember-me">Recuérdame</label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Iniciar Sesión</button>

            <div class="text-center mt-2">
                <p>¿No estas registrado?
                    <a href="registro_user.jsp">Registrate</a>
                </p>
            </div>
            <!--------------------------------FOOTER--------------------------------->
            <footer class="container mb-0">
                <p class="mb-1 text-center"><a href="#">Privacidad</a> &middot; <a href="#">Términos y Condiciones</a></p>
                <p class="text-muted text-center mb-0">&copy; 2020 RAFASE, Inc.&middot; <a href="#">Administrador</a></p>
            </footer>
        </form>
    </body>
</html>
