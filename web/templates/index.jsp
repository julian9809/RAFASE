<%-- 
    Document   : inicio
    Created on : 18/06/2020, 04:12:31 PM
    Author     : julia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RAFASE</title>
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="../css/index.css">
        <link rel="stylesheet" media="screen" href="https://fontlibrary.org/face/averia" type="text/css"/>
        <script src="../js/bootstrap.min.js"></script>
    </head>
    <body>
        <header>
            <div class="container-fluid">
		<div class="row">
                    <div class="col-md-5 ">
			<div class="row">
                            <div class="col-md-2 text-center">
				<img id="logo" src="../img/Logo.png">				
                            </div>
                            <div class="col-md-8 text-center">
                                <h2 class="text-left" id="titulo">RAFASE</h2>
                                <h5 class="text-left">Rapido, Facil y Seguro</h5>
                            </div>
			</div>
                    </div>
                    <div class="col-md-4">
			<span></span>
                    </div>
                    <div class="col-md-2 text-left">
			
                    </div>
		</div>
            </div>
        </header>
        <nav class="navbar navbar-expand-lg navbar navbar-light bg-light">
            <a class="navbar-brand" href="#">Inicio</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                  <a class="nav-link" href="#">Ir a Pagar<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">Control</a>
                </li>
              </ul>
              <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Buscar producto" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>                
              </form>
                <button class="btn btn-outline-info iniciar_sesion">Iniciar sesión</button>
                <button class="btn btn-outline-primary">Registrarse</button>
            </div>
          </nav>
    </body>
</html>
