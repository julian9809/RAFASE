<%-- 
    Document   : inicio
    Created on : 18/06/2020, 04:12:31 PM
    Author     : julia
--%>
<%@page import="modelo.Carrito"%>
<%@page import="control.PedidoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Producto"%>
<%@page import="control.ProductosDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String producto_buscado = request.getParameter("busqueda");
    String usuario = "";
    if (request.getParameter("usuario") == null) {
        usuario = "visitante";
    } else {
        usuario = request.getParameter("usuario");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>JSP Page</title>
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
        <!-- Customs styles for this template -->
        <link rel="stylesheet" href="../css/custom/index.css">
        <!-- Customs fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Averia+Libre&display=swap" rel="stylesheet">
        <script src="../js/bootstrap.min.js"></script>
    </head>
    <body>
        <header>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-2 col-md-2 col-lg-1 col-xl-1 text-center">
                        <img id="logo" src="../img/rafase.gif">				
                    </div>
                    <div class="col-sm-10 col-md-10 col-lg-11 col-xl-11 text-center">
                        <h2 class="text-left" id="titulo">RAFASE</h2>
                        <h5 class="text-left">Rapido, Facil y Seguro</h5>
                    </div>
                </div>
            </div>
        </header>
        <!-------------------------------Barra de navegación--------------------------------->
        <nav class="navbar navbar-expand-lg navbar navbar-light bg-light sticky-top">
            <img id="logo" src="../img/Logo.png">
            <a class="navbar-brand" href="../MantenerUsuario?usuario=<%=usuario%>&pagina=inicio">Inicio</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="../BuscarProducto?usuario=<%=usuario%>&producto_buscado=">Productos<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Ir a pagar<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Control</a>
                    </li>
                </ul>
                <form action="../BuscarProducto" method="post" class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Buscar productos" name="producto_buscado" id="producto_buscado" aria-label="Search">
                    <input type="hidden" name = "usuario" id="usuario" value=<%=usuario%>>
                    <button class="btn btn-outline-success my-2 my-sm-0 buscar" type="submit">Buscar</button>                
                </form>
                <%if (usuario.equals("visitante")) {%>
                <div class="btn-group" role="group">
                    <a class="btn btn-outline-info"  href="sign.jsp" role="button">Iniciar sesión</a>
                    <a class="btn btn-outline-primary"  href="registro_user.jsp" role="button">Registrarse</a>
                </div>
                <%} else {%>
                <div class="btn-group" role="group">
                    <a class="btn btn-outline-info"  href="#" role="button"><%=usuario%></a>
                    <form><a class="btn btn-outline-primary"  href="../cerrarSesion?usuario=visitante" role="button">Log out</a></form>
                </div>
                <%}%>
            </div>
        </nav>
        <!--------------------------------FOOTER--------------------------------->
        <footer class="container">
            <p class="float-right"><a href="#">Volver al arriba</a></p>
            <p>&copy; 2020 RAFASE, Inc. &middot; <a href="#">Privacidad</a> &middot; <a href="#">Términos y Condiciones</a></p>
        </footer>
        <!-------------------------------Scripts--------------------------------->
        <!-- jQuery -->
        <script type="text/javascript" src="../js/jquery.js"></script>
        <!-- Bootstrap tooltips -->
        <script type="text/javascript" src="../js/popper.min.js"></script>
        <!-- Bootstrap core JavaScript -->
        <script type="text/javascript" src="../js/bootstrap.min.js"></script>
        <!-- MDB core JavaScript -->
        <script type="text/javascript" src="../js/mdb.min.js"></script>
    </body>
</html>
