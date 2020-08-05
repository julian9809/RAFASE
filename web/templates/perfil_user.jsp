<%-- 
    Document   : perfil_usuario
    Created on : 27/06/2020, 09:41:38 AM
    Author     : david
--%>

<%@page import="modelo.Ciudad"%>
<%@page import="modelo.Direccion"%>
<%@page import="control.DAOFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesion = request.getSession();
    HttpSession usuarios = request.getSession();
    String ciudad = "no ciudad";

    if (sesion.getAttribute("Ciudad") != null) {
        ciudad = sesion.getAttribute("Ciudad").toString();
    } else {
        out.print("<script>location.replace('../index.jsp');</script>");
    }

    String producto_buscado = request.getParameter("busqueda");
    String categoria = request.getParameter("categoria");
    String usuario = usuarios.getAttribute("usuario").toString();

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Usuario</title>
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
        <!---------------------- Alertify CSS ---------------------->
        <!-- CSS -->
        <link rel="stylesheet" href="../css/alertify/alertify.min.css"/>
        <!-- Default theme -->
        <link rel="stylesheet" href="../css/alertify/themes/default.min.css"/>
        <!-- Semantic UI theme -->
        <link rel="stylesheet" href="../css/alertify/themes/semantic.min.css"/>
        <!-- Bootstrap theme -->
        <link rel="stylesheet" href="../css/alertify/themes/bootstrap.min.css"/>
        <!---------------------- Alertify CSS ---------------------->
        <!-- Customs styles for this template -->
        <link rel="stylesheet" href="../css/custom/productos.css">
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
        <!-- Alertifyjs JavaScript -->
        <script type="text/javascript" src="../js/alertifyjs/alertify.min.js"></script>
    </head>
    <body>
        <!-------------------------------Barra de navegación--------------------------------->
        <nav class="navbar navbar-expand-lg navbar navbar-light bg-light sticky-top scrolling-navbar">
            <img id="logo" src="../img/Logo.png">
            <a class="navbar-brand" href="index.jsp">Inicio</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="../BuscarProducto?usuario=<%=usuario%>&producto_buscado=">Productos<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="pago.jsp">Ir a pagar<span class="sr-only">(current)</span></a>
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
                <div class="btn-group btn-sm" role="group">
                    <a class="btn btn-outline-info btn-sm align-middle ml-0" href="sign.jsp" role="button">Iniciar sesión</a>
                    <a class="btn btn-outline-primary btn-sm align-middle" href="registro_user.jsp" role="button">Registrarse</a>
                </div>
                <%} else {%>
                <div class="nav-item dropdown avatar">
                    <a class="nav-link p-0 dropdown-toggle" id="navbarDropdownMenuLink-4" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        <img src="https://mdbootstrap.com/img/Photos/Avatars/avatar-5.jpg" class="rounded-circle z-depth-0"
                             alt="avatar image" height="35"> <%=usuario%> </a>
                    <div class="dropdown-menu dropdown-menu-left dropdown-menu-md-right dropdown-info" aria-labelledby="navbarDropdownMenuLink-4">
                        <a class="dropdown-item" href="../cerrarSesion?usuario=visitante">Cerrar sesión</a>
                    </div>
                </div>
                <%}//End If visitante%>
            </div>
        </nav>
        <!-------------------------------Contenido-------------------------------------->
        <%
            DAOFacade facade = new DAOFacade();
            Direccion dir = facade.getDireccion();
            Ciudad ciudades = facade.getCiudad();

            try {
                facade.buscarDireccionResidencia(usuario, usuarios.getAttribute("contraseña").toString(),
                        facade.buscarTipoID(usuario, usuarios.getAttribute("contraseña").toString()),
                        facade.buscarIdCliente(usuario, usuarios.getAttribute("contraseña").toString()));
                facade.buscarCiudades(usuarios.getAttribute("usuario").toString(),
                        usuarios.getAttribute("contraseña").toString());
            } catch (Exception e1) {
        %>
        <script type="text/javascript">
            alertify.alert("Error", "<%= "Error --> " + e1 + e1.getMessage()%>", function () {
                alertify.message('OK');
            });
        </script>
        <%
            }//end catch            
%>

        <div class="container mt-5">
            <div class="card">
                <div class="card-header">
                    <ul class="nav nav-tabs card-header-tabs">
                        <li class="nav-item">
                            <a class="nav-link active" data-toggle="tab" href="#datosPersonales" role="tab">Datos personales</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="tab" href="#direcciones" role="tab">Direcciones</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="tab" href="#mediosPago" role="tab">Medios de Pago</a>
                        </li>
                    </ul>
                </div>
                <div class="card-body">
                    <div class="tab-content pt-4">
                        <div class="tab-pane fade in show active" id="datosPersonales" role="tabpanel">
                            <table class="table table-borderless">
                                <tbody>
                                    <tr>
                                        <td>Nickname</td>
                                        <td><%=usuario%></td>
                                    </tr>
                                    <tr>
                                        <td>Nombre</td>
                                    </tr>
                                    <tr>
                                        <td>Email</td>
                                    </tr>
                                    <tr>
                                        <td>Telefono</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="tab-pane fade in show" id="direcciones" role="tabpanel">
                            <div class="d-flex justify-content-between">
                                <a class="btn btn-primary" data-toggle="collapse" href="#direccionResidencia" role="button" aria-expanded="false"
                                   aria-controls="direccionResidencia">Dirección de residencia</a>
                                <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#direccionEnvio"
                                        aria-expanded="false" aria-controls="direccionEnvio">Direcciones de envio</button>
                                <button class="btn btn-primary" type="button" data-toggle="collapse" data-target=".multi-collapse"
                                        aria-expanded="false" aria-controls="direccionResidencia direccionEnvio">Todas las direcciones</button>
                            </div>

                            <div class="row">
                                <div class="col">
                                    <div class="collapse multi-collapse" id="direccionResidencia">
                                        <div class="card card-body">
                                            <table class="table table-borderless">
                                                <% if (dir.getDireccion_completa_array().isEmpty()) {%>
                                                <tr>
                                                    <td>No tienes direcciones registradas</td>
                                                    <td><a class="btn btn-info btn-sm align-middle ml-0" href="perfil_user.jsp" role="button" data-toggle="modal" data-target="#modalDireccion">Registrar dirección</a></td>
                                                    <!------------------------------------Modal--------------------------------------------->
                                                <div class="modal fade" id="modalDireccion" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                                                     aria-hidden="true">
                                                    <div class="modal-dialog modal-notify modal-warning" role="document">
                                                        <!--Content-->
                                                        <div class="modal-content">
                                                            <!--Header-->
                                                            <div class="modal-header text-center">
                                                                <h4 class="modal-title white-text w-100 font-weight-bold py-2">Registra tu dirección</h4>
                                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                    <span aria-hidden="true" class="white-text">&times;</span>
                                                                </button>
                                                            </div>

                                                            <!--Body-->

                                                            <form action="../registrar_direccion" method="post">
                                                                <div class="modal-body">
                                                                    <div class="md-form mb-5">
                                                                        <i class="fas fa-home prefix grey-text"></i>
                                                                        <input type="text" id="direccion" name="direccion" class="form-control validate">
                                                                        <label data-error="wrong" data-success="right" for="direccion">Dirección</label>
                                                                    </div>

                                                                    <div class="form-group">
                                                                        <textarea class="form-control rounded-0 validate" maxlength="50" id="extras" name="extras" rows="3" placeholder="Datos adicionales"></textarea>
                                                                    </div>

                                                                    <div class="md-form">
                                                                        <select class="browser-default custom-select mb-4" name="id_ciudad" id="id_ciudad" required>
                                                                            <option selected hidden disabled>Escoge tu ciudad</option>
                                                                            <%
                                                                                for (int i = 0; i < ciudades.getId_ciudad_array().size(); i++) {
                                                                            %>
                                                                            <option value="<%= ciudades.getId_ciudad_array().get(i).toString() %>"><%= ciudades.getNombre_array().get(i)%></option>
                                                                            <%}//End for ciudad%>
                                                                        </select>
                                                                    </div>
                                                                    
                                                                    <p>Tipo de dirección</p>
                                                                    <!-- Group of default radios - option 1 -->
                                                                    <div class="custom-control custom-radio">
                                                                        <input type="radio" class="custom-control-input" id="residencia" name="tipo_direccion" value="R" checked>
                                                                        <label class="custom-control-label" for="residencia">Residencia</label>
                                                                    </div>

                                                                    <!-- Group of default radios - option 2 -->
                                                                    <div class="custom-control custom-radio">
                                                                        <input type="radio" class="custom-control-input" id="envio" name="tipo_direccion" value="E">
                                                                        <label class="custom-control-label" for="envio">Envio</label>
                                                                    </div>
                                                                </div>
                                                                <!--Footer-->
                                                                <div class="modal-footer justify-content-center">
                                                                    <button class="btn btn-warning waves-effect" type="submit">Registrar</button>
                                                                </div>
                                                            </form>
                                                        </div>
                                                        <!--/.Content-->
                                                    </div>
                                                </div>
                                                </tr>
                                                <%} else {%>
                                                <%
                                                    for (int i = 0; i < dir.getDireccion_completa_array().size(); i++) {
                                                %>
                                                <tr>
                                                    <td><%=dir.getDireccion_completa_array().get(i)%></td>
                                                </tr>
                                                <tr class="grey lighten-2">
                                                    <td>Datos adicionales</td>
                                                </tr>
                                                <tr>
                                                    <td><%=dir.getExtras_array().get(i)%></td>
                                                </tr>
                                                <%} //end for%>
                                                <%} //end if%>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="collapse multi-collapse" id="direccionEnvio">
                                        <div class="card card-body">
                                            Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. Nihil
                                            anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident.
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="mediosPago" role="tabpanel">

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--------------------------------FOOTER--------------------------------->
        <footer class="container footer mt-5">
            <p class="float-right"><a href="#">Volver al arriba</a></p>
            <p>&copy; 2020 RAFASE, Inc. &middot; <a href="#">Privacidad</a> &middot; <a href="#">Términos y Condiciones</a></p>
        </footer>
    </body>
</html>
