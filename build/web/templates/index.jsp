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
        <script src="http://code.jquery.com/jquery-latest.js"></script>
    </head>
    <body>
        <header>
            <div class="container-fluid">
		<div class="row">
                    <div class="col-md-6 ">
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
        <!------------------------------Barra de navegacion-------------------------------------------->
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
        <!--------------------------------Carrusel de imagenes------------------------------------------->
        <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="carousel-item active" style="height: 40vh">
                    <img src="../img/Granel.jpg" class="d-block w-100" alt="granel">
                    <div class="carousel-caption d-none d-md-block">
                        <h5 style="text-shadow:5px 5px 7px #000000">Mercado</h5>
                        <p style="text-shadow:5px 5px 7px #000000">Todo lo que necesitas para tu hogar.</p>
                    </div>
                </div>
                <div class="carousel-item"  style="height: 40vh">
                    <img src="../img/Celulares.jpg" class="d-block w-100" alt="celulares">
                        <div class="carousel-caption d-none d-md-block">
                            <h5 style="text-shadow:5px 5px 7px #000000">Tecnología</h5>
                            <p style="text-shadow:5px 5px 7px #000000">Encuentra todos los articulos tecnologicos.</p>
                        </div>
                </div>
                <div class="carousel-item"  style="height: 40vh">
                    <img src="../img/Libros.jpg" class="d-block w-100" alt="libros">
                    <div class="carousel-caption d-none d-md-block">
                        <h5 style="text-shadow:5px 5px 7px #000000">Libros</h5>
                        <p style="text-shadow:5px 5px 7px #000000">Encuentra variedad de libros de todas categorias.</p>
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
        <br>
        <!--------------------------------Productos------------------------------------------->
        <center>
            <h2>Categorias</h2>
        </center>
        <div class="container-fluid">
        <div class="row">
        <div class="col">
            <span></span>     
        </div>
        <div class="card-deck col-8">
            <div class="card text-white bg-primary mb-3" style="max-width: 18rem;">
                <div class="card-header">Entretenimiento</div>
                    <div class="card-body">
                        <h5 class="card-title text-center">
                            <svg class="bi bi-film" width="3em" height="3em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd" d="M0 1a1 1 0 0 1 1-1h14a1 1 0 0 1 1 1v14a1 1 0 0 1-1 1H1a1 1 0 0 1-1-1V1zm4 0h8v6H4V1zm8 8H4v6h8V9zM1 1h2v2H1V1zm2 3H1v2h2V4zM1 7h2v2H1V7zm2 3H1v2h2v-2zm-2 3h2v2H1v-2zM15 1h-2v2h2V1zm-2 3h2v2h-2V4zm2 3h-2v2h2V7zm-2 3h2v2h-2v-2zm2 3h-2v2h2v-2z"/>
                            </svg>
                        </h5>
                        <center>
                            <button type="button" class="btn btn-light">Ver articulos</button>
                        </center>                        
                    </div>
            </div>
            <div class="card text-white bg-secondary mb-3" style="max-width: 18rem;">
                <div class="card-header">Hogar</div>
                    <div class="card-body">
                        <h5 class="card-title text-center">
                            <svg class="bi bi-house-door" width="3em" height="3em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd" d="M7.646 1.146a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 .146.354v7a.5.5 0 0 1-.5.5H9.5a.5.5 0 0 1-.5-.5v-4H7v4a.5.5 0 0 1-.5.5H2a.5.5 0 0 1-.5-.5v-7a.5.5 0 0 1 .146-.354l6-6zM2.5 7.707V14H6v-4a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 .5.5v4h3.5V7.707L8 2.207l-5.5 5.5z"/>
                                <path fill-rule="evenodd" d="M13 2.5V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
                            </svg>
                        </h5>
                        <center>
                            <button type="button" class="btn btn-light">Ver articulos</button>
                        </center> 
                    </div>
            </div>
            <div class="card text-white bg-success mb-3" style="max-width: 18rem;">
                <div class="card-header">Mercado</div>
                    <div class="card-body">
                        <h5 class="card-title text-center">
                            <svg class="bi bi-basket2" width="3em" height="3em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd" d="M1.111 7.186A.5.5 0 0 1 1.5 7h13a.5.5 0 0 1 .489.605l-1.5 7A.5.5 0 0 1 13 15H3a.5.5 0 0 1-.489-.395l-1.5-7a.5.5 0 0 1 .1-.42zM2.118 8l1.286 6h9.192l1.286-6H2.118z"/>
                                <path fill-rule="evenodd" d="M11.314 1.036a.5.5 0 0 1 .65.278l2 5a.5.5 0 1 1-.928.372l-2-5a.5.5 0 0 1 .278-.65zm-6.628 0a.5.5 0 0 0-.65.278l-2 5a.5.5 0 1 0 .928.372l2-5a.5.5 0 0 0-.278-.65z"/>
                                <path d="M4 10a1 1 0 0 1 2 0v2a1 1 0 1 1-2 0v-2zm3 0a1 1 0 0 1 2 0v2a1 1 0 1 1-2 0v-2zm3 0a1 1 0 0 1 2 0v2a1 1 0 1 1-2 0v-2zM0 6.5A.5.5 0 0 1 .5 6h15a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5H.5a.5.5 0 0 1-.5-.5v-1z"/>
                            </svg>
                        </h5>
                        <center>
                            <button type="button" class="btn btn-light">Ver articulos</button>
                        </center> 
                    </div>
            </div>
        </div>
        <div class="col">
            <span></span>     
        </div>
        </div>
        </div>
        <script src="../js/jquery.js"></script>
        <script src="../js/bootstrap.min.js"></script>
    </body>
</html>
