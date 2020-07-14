<%-- 
    Document   : index
    Created on : 8/07/2020, 08:07:27 PM
    Author     : david
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>RAFASE</title>
        <link rel="icon" href="img/Logo.png" type="image/png">
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
        <!-- Customs styles for this template -->
        <link rel="stylesheet" href="css/custom/cover.css">
        <!-- Customs fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Averia+Libre&display=swap" rel="stylesheet">     
        <script src="http://code.jquery.com/jquery-latest.js"></script>
    </head>
    <body class="text-center">
        <div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
            <header class="masthead mb-auto">
                <div class="inner">
                    <img id="logo" class="masthead-brand" src="img/rafase.gif">
                    <nav class="nav nav-masthead justify-content-center">
                        <a class="nav-link" href="templates/index.jsp">Quienes Somos</a>
                        <a class="nav-link" href="#">Contacto</a>
                    </nav>
                </div>
            </header>

            <main role="main" class="inner cover">
                <h1 class="cover-heading">RAFASE</h1>
                <p class="lead inicio">Somos una tienda virtual con varias sucursales fisicas en distintas ciudades del pais, escoge tu ciudad eh inicia a comprar de forma rapida y sencilla.</p>
                <form class="lead btn-group">
                    <select class="btn btn-lg btn-secondary" name="ciudad" id="ciudad">
                        <option selected>Escoge tu ciudad</option>
                        <option value="BT">Bogotá</option>
                        <option value="ME">Medellin</option>
                        <option value="CA">Cali</option>
                    </select>
                    <button class="btn btn-lg btn-success" type="summit">Continuar</button>
                </form>
            </main>

            <footer class="container footer mastfoot mt-auto">
                <div class="inner">
                <p>&copy; 2020 RAFASE, Inc. &middot; <a href="#">Privacidad</a> &middot; <a href="#">Términos y Condiciones</a></p>
                </div>
            </footer>
            <!-------------------------------Scripts--------------------------------->
            <script src="js/jquery.js"></script>
            <script src="js/bootstrap.min.js"></script>
        </div>
    </body>
</html>
