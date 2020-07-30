<%-- 
    Document   : inicio
    Created on : 18/06/2020, 04:12:31 PM
    Author     : julia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesion = request.getSession();
    HttpSession usuarios = request.getSession();
    String ciudad = "no ciudad";

    if (!sesion.getAttribute("Ciudad").equals("no ciudad")) {
        ciudad = sesion.getAttribute("Ciudad").toString();
    } else {
        out.print("<script>location.replace('../index.jsp');</script>");
    }

    String usuario = usuarios.getAttribute("usuario").toString();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>RAFASE</title>
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
    </head>
    <body>
        <header>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-3 col-sm-2 col-md-2 col-lg-1 col-xl-1 text-center">
                        <img id="logo" src="../img/rafase.gif">				
                    </div>
                    <div class="col-5 col-sm-7 col-md-8 col-lg-9 col-xl-9">
                        <h2 class="text-left" id="titulo">RAFASE</h2>
                        <h5 class="text-left" id="lema">Rapido, Facil y Seguro</h5>
                    </div>
                    <div class="col-4 col-sm-3 col-md-2 col-lg-2 col-xl-2 my-auto">
                        <a class="float-right text-white ciudad" href="../Ciudad?cerrar=true"><%=ciudad%></a>
                    </div>
                </div>
            </div>
        </header>
        <!--------------------------------Barra de navegacion--------------------------------->
        <nav class="navbar navbar-expand-lg navbar navbar-light bg-light sticky-top scrolling-navbar">
            <a class="navbar-brand" href="../index.jsp">Inicio</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="../BuscarProducto?usuario=<%=usuario%>&producto_buscado=">Productos<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="pago.jsp">Ir a Pagar<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Control</a>
                    </li>
                </ul>
                <form action="../BuscarProducto" method="post" class="form-inline my-2 my-lg-0 ml-auto">
                    <div class="input-group form-sm form-2">
                        <input class="form-control" type="text" placeholder="Buscar productos" name="producto_buscado" id="producto_buscado" aria-label="Search">
                        <div class="input-group-append">
                            <button class="input-group-text grey lighten-5 mr-2">
                                <i class="fas fa-search text-grey" aria-hidden="true"></i>
                            </button>
                        </div>
                    </div>
                </form>
                <%if (usuario.equals("visitante")) {%>
                <div class="btn-group" role="group">
                    <a class="btn btn-outline-info btn-sm align-middle ml-0" href="sign.jsp" role="button">Iniciar sesión</a>
                    <a class="btn btn-outline-primary btn-sm align-middle" href="registro_user.jsp" role="button">Registrarse</a>
                </div>
                <%} else {%>
                <div class="nav-item dropdown avatar">
                    <a class="nav-link p-0 dropdown-toggle" id="navbarDropdownMenuLink-4" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        <img src="https://mdbootstrap.com/img/Photos/Avatars/avatar-5.jpg" class="rounded-circle z-depth-0"
                             alt="avatar image" height="35"> <%=usuario%> </a>
                    <div class="dropdown-menu dropdown-menu-right dropdown-info" aria-labelledby="navbarDropdownMenuLink-4">
                        <a class="dropdown-item" href="#">My account</a>
                        <a class="dropdown-item" href="../cerrarSesion?usuario=visitante">Log out</a>
                    </div>
                </div>
                <%}%>
            </div>
        </nav>
        <!--------------------------------Carrusel de imagenes--------------------------------->
        <div id="carouselExampleCaptions" class=" carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="carousel-item active" style="height: 40vh">
                    <img src="../img/Granel.jpg" class="d-block w-100" alt="granel">
                    <div class="carousel-caption d-none d-md-block text-white">
                        <h4 style="text-shadow:5px 5px 7px #000">Mercado</h4>
                        <p style="text-shadow:5px 5px 7px #000">Todo lo que necesitas para tu hogar.</p>
                    </div>
                </div>
                <div class="carousel-item"  style="height: 40vh">
                    <img src="../img/Celulares.jpg" class="d-block w-100" alt="celulares">
                    <div class="carousel-caption d-none d-md-block text-white">
                        <h4 style="text-shadow:5px 5px 7px #000">Tecnología</h4>
                        <p style="text-shadow:5px 5px 7px #000">Encuentra todos los articulos tecnologicos.</p>
                    </div>
                </div>
                <div class="carousel-item"  style="height: 40vh">
                    <img src="../img/Libros.jpg" class="d-block w-100" alt="libros">
                    <div class="carousel-caption d-none d-md-block text-white">
                        <h4 style="text-shadow:5px 5px 7px #000">Libros</h4>
                        <p style="text-shadow:5px 5px 7px #000">Encuentra variedad de libros de todas categorias.</p>
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <!--------------------------------Productos--------------------------------->
        <div class="container-fluid">
            <h1 class="display-4 mt-2 mb-4 text-center">Categorias</h1>
            <div class="row justify-content-center">
                <div class="card-deck col-12 text-center">
                    <div class="col-md-6 col-xl-4">
                        <div class="card text-white bg-primary mb-4 shadow-sm">
                            <div class="card-header">Entretenimiento</div>
                            <div class="card-body">
                                <h5 class="card-title">
                                    <svg class="bi bi-film" width="3em" height="3em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd" d="M0 1a1 1 0 0 1 1-1h14a1 1 0 0 1 1 1v14a1 1 0 0 1-1 1H1a1 1 0 0 1-1-1V1zm4 0h8v6H4V1zm8 8H4v6h8V9zM1 1h2v2H1V1zm2 3H1v2h2V4zM1 7h2v2H1V7zm2 3H1v2h2v-2zm-2 3h2v2H1v-2zM15 1h-2v2h2V1zm-2 3h2v2h-2V4zm2 3h-2v2h2V7zm-2 3h2v2h-2v-2zm2 3h-2v2h2v-2z"/>
                                    </svg>
                                </h5>
                                <center>
                                    <a class="btn btn-light" href="../BuscarProducto?categoria=Entretenimiento" role="button" id="categoria" name="categoria" value="Entretenimento">Ver articulos</a>
                                </center>                        
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-xl-4">
                        <div class="card text-white bg-secondary mb-4 shadow-sm">
                            <div class="card-header">Hogar</div>
                            <div class="card-body">
                                <h5 class="card-title">
                                    <svg class="bi bi-house-door" width="3em" height="3em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd" d="M7.646 1.146a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 .146.354v7a.5.5 0 0 1-.5.5H9.5a.5.5 0 0 1-.5-.5v-4H7v4a.5.5 0 0 1-.5.5H2a.5.5 0 0 1-.5-.5v-7a.5.5 0 0 1 .146-.354l6-6zM2.5 7.707V14H6v-4a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 .5.5v4h3.5V7.707L8 2.207l-5.5 5.5z"/>
                                    <path fill-rule="evenodd" d="M13 2.5V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
                                    </svg>
                                </h5>
                                <center>
                                    <a class="btn btn-light" href="../BuscarProducto?categoria=Hogar" role="button">Ver articulos</a>
                                </center> 
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-4">
                        <div class="card text-white bg-success mb-4 shadow-sm">
                            <div class="card-header">Mercado</div>
                            <div class="card-body">
                                <h5 class="card-title">
                                    <svg class="bi bi-basket2" width="3em" height="3em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd" d="M1.111 7.186A.5.5 0 0 1 1.5 7h13a.5.5 0 0 1 .489.605l-1.5 7A.5.5 0 0 1 13 15H3a.5.5 0 0 1-.489-.395l-1.5-7a.5.5 0 0 1 .1-.42zM2.118 8l1.286 6h9.192l1.286-6H2.118z"/>
                                    <path fill-rule="evenodd" d="M11.314 1.036a.5.5 0 0 1 .65.278l2 5a.5.5 0 1 1-.928.372l-2-5a.5.5 0 0 1 .278-.65zm-6.628 0a.5.5 0 0 0-.65.278l-2 5a.5.5 0 1 0 .928.372l2-5a.5.5 0 0 0-.278-.65z"/>
                                    <path d="M4 10a1 1 0 0 1 2 0v2a1 1 0 1 1-2 0v-2zm3 0a1 1 0 0 1 2 0v2a1 1 0 1 1-2 0v-2zm3 0a1 1 0 0 1 2 0v2a1 1 0 1 1-2 0v-2zM0 6.5A.5.5 0 0 1 .5 6h15a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5H.5a.5.5 0 0 1-.5-.5v-1z"/>
                                    </svg>
                                </h5>
                                <center>
                                    <a class="btn btn-light" href="../BuscarProducto?categoria=Mercado" role="button">Ver articulos</a>
                                </center> 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
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
