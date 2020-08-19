<%-- 
    Document   : pago
    Created on : 30/07/2020, 04:55:28 PM
    Author     : julia
--%>

<%@page import="modelo.Carrito"%>
<%@page import="modelo.Ciudad"%>
<%@page import="control.DAOFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesion = request.getSession();
    String ciudad = "no ciudad";

    if (sesion.getAttribute("Ciudad") != null) {
        ciudad = sesion.getAttribute("Ciudad").toString();
    } else {
        out.print("<script>location.replace('../index.jsp');</script>");
    }

    String usuario = sesion.getAttribute("usuario").toString();

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Tu Carrito</title>
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
                            <button class="input-group-text form-control grey lighten-5 mr-2">
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
                    <div class="dropdown-menu dropdown-menu-left dropdown-menu-lg-right dropdown-info" aria-labelledby="navbarDropdownMenuLink-4">
                        <a class="dropdown-item" href="perfil_user.jsp">Mi cuenta</a>
                        <a class="dropdown-item" href="../cerrarSesion?usuario=visitante">Cerrar sesión</a>
                    </div>
                </div>
                <%}//End If visitante%>
            </div>
        </nav>
        <!-------------------------------Contenido-------------------------------------->
        <%
            DAOFacade facade = new DAOFacade();
            Ciudad ciudadObj = facade.getCiudad();
            try {
                facade.buscarCiudades(sesion.getAttribute("usuario").toString(),
                        sesion.getAttribute("contraseña").toString());
            } catch (Exception e1) {
                String error = e1.toString();
                error = error.replaceAll("\n", "");
        %>
        <script type="text/javascript">
            alertify.alert("Error", "<%= "Error --> " + error%>", function () {
                alertify.message('OK');
            });
        </script>
        <%
            }//End catch
        %>
        <div class="container-fluid mt-3">


            <!--Section: Content-->
            <section class="dark-grey-text">

                <div class="card">
                    <div class="card-body">

                        <!--Grid row-->
                        <div class="row">

                            <!--Grid column-->
                            <div class="col-lg-8">

                                <!-- Pills navs -->
                                <ul class="nav nav-pills nav-justified pills-primary font-weight-bold">
                                    <li class="nav-item">
                                        <a class="nav-link active" data-toggle="tab" href="#tabCheckoutBilling" role="tab">1. Facturación</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" data-toggle="tab" href="#tabCheckoutPayment" role="tab">2. Metodo de pago</a>
                                    </li>
                                </ul>
                                <!--Formulario con id para el pago, se coloca en los input el id del form-->
                                <form id="pagar"></form>
                                <!-- Pills panels -->
                                <div class="tab-content pt-4">
                                    <!--Panel 1-->
                                    <div class="tab-pane fade in show active" id="tabCheckoutBilling" role="tabpanel">

                                        <!--Card content-->

                                        <!--Grid row-->
                                        <div class="row">

                                            <!--Grid column-->
                                            <div class="col-md-6">

                                                <!--firstName-->
                                                <div class="md-form md-bg mt-0">
                                                    <input type="text" class="form-control" name="nombre" id="nombre" form="pagar" required/>
                                                    <label for="nombre">Nombre(s)</label>
                                                </div>

                                            </div>
                                            <!--Grid column-->

                                            <!--Grid column-->
                                            <div class="col-md-6">

                                                <!--lastName-->
                                                <div class="md-form md-bg mt-0">
                                                    <input type="text" class="form-control" name="apellido" id="apellido" form="pagar" required/>
                                                    <label for="apellido">Apellido(s)</label>
                                                </div>

                                            </div>
                                            <!--Grid column-->

                                        </div>
                                        <!--Grid row-->

                                        <!--Username-->
                                        <div class="md-form md-bg mt-0">
                                            <input type="text" class="form-control" value="" name="username" id="username" form="pagar" required/>
                                            <label for="username">Nombre de usuario</label>
                                        </div>

                                        <!--email-->
                                        <div class="md-form md-bg">
                                            <input type="email" class="form-control" value="" name="email" id="email" form="pagar" required/>
                                            <label for="email">Correo Electronico</label>
                                        </div>

                                        <!--address-->
                                        <div class="md-form md-bg">
                                            <input type="text" id="direccion" name="direccion" class="form-control" form="pagar" required>
                                            <label for="direccion">Dirección</label>
                                        </div>
                                        <!--Datos adicionales-->
                                        <div class="md-form md-bg">
                                            <textarea class="md-textarea form-control" maxlength="50" id="extras" name="extras" rows="2" form="pagar"></textarea>
                                            <label for="extras">Datos adicionales</label>
                                        </div>

                                        <!--Grid row-->
                                        <div class="row">

                                            <!--Grid column-->
                                            <div class="col-lg-6 col-md-6 mb-6">

                                                <label for="country">Ciudad</label>
                                                <select class="custom-select d-block" name="ciudad" id="ciudad" form="pagar" required>
                                                    <option value="" selected hidden disabled>Escoge tu ciudad</option>
                                                    <%
                                                        for (int i = 0; i < ciudadObj.getId_ciudad_array().size(); i++) {
                                                    %>
                                                    <option value="<%= ciudadObj.getNombre_array().get(i)%>"><%= ciudadObj.getNombre_array().get(i)%></option>
                                                    <%}//End for ciudad%>
                                                </select>

                                            </div>
                                            <!--Grid column-->

                                            <!--Grid column-->
                                            <div class="col-lg-6 col-md-6 mb-6">

                                                <label for="zip">Código postal</label>
                                                <input type="text" class="form-control" id="zip" form="pagar" required>

                                            </div>
                                            <!--Grid column-->

                                        </div>
                                        <!--Grid row-->

                                        <hr>

                                        <div class="custom-control custom-checkbox mb-1">
                                            <input type="checkbox" class="custom-control-input" id="chekboxRules" form="pagar" required>
                                            <label class="custom-control-label" for="chekboxRules">Acepto los terminos y condiciones</label>
                                        </div>
                                        <div class="custom-control custom-checkbox mb-1">
                                            <input type="checkbox" class="custom-control-input" id="safeTheInfo" form="pagar">
                                            <label class="custom-control-label" for="safeTheInfo">Guardar esta información para una proxima vez</label>
                                        </div>

                                        <hr>
                                    </div>
                                    <!--/.Panel 1-->

                                    <!--Panel 2-->
                                    <div class="tab-pane fade" id="tabCheckoutPayment" role="tabpanel">

                                        <div class="form-group">
                                            <div class="custom-control custom-radio mb-2">
                                                <input name="tipoPago" type="radio" class="custom-control-input" id="tipoPago1" value="C" form="pagar" required>
                                                <label class="custom-control-label" for="tipoPago1">Tarjeta de Credito</label>
                                            </div>
                                            <div class="custom-control custom-radio mb-2">
                                                <input name="tipoPago" type="radio" class="custom-control-input" id="tipoPago2" value="D" form="pagar" disabled required>
                                                <label class="custom-control-label" for="tipoPago2">Tarjeta de Debito (Próximamente)</label>
                                            </div>
                                            <div class="custom-control custom-radio mb-2">
                                                <input name="tipoPago" type="radio" class="custom-control-input" id="tipoPago3" value="P" form="pagar" disabled required>
                                                <label class="custom-control-label" for="tipoPago3">Paypal (Próximamente)</label>
                                            </div>
                                            <div class="custom-control custom-radio mb-2">
                                                <input name="tipoPago" type="radio" class="custom-control-input" id="tipoPago4" value="E" form="pagar" disabled required>
                                                <label class="custom-control-label" for="tipoPago4">PSE (Próximamente)</label>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="md-form md-bg">
                                                    <input type="text" class="form-control mb-0" id="nombreTarCre"  name="nombreTarCre" form="pagar" required>
                                                    <label for="nombre">Nombre en la tarjeta</label>
                                                    <small class="text-muted">Nombre completo en la parte de atras de la tarjeta</small>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="md-form md-bg">
                                                    <input type="number" class="form-control" min="100000000000" max="999999999999" id="numero" name="numero" form="pagar" required>
                                                    <label for="numero">Número de la tarjeta de credito</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-3 col-md-2">
                                                <div class="md-form md-bg">
                                                    <label for="mes" data-error="wrong" data-success="right">MM</label>
                                                    <input type="number" class="form-control" min="1" max="12" id="mes" name="mes" form="pagar" required>
                                                </div>
                                            </div>
                                            <label class="my-auto">/</label>
                                            <div class="col-3 col-md-2">
                                                <div class="md-form md-bg">
                                                    <label for="año" data-error="wrong" data-success="right">AA</label>
                                                    <input type="number" class="form-control" min="20" max="28" id="año" name="año" form="pagar" required>
                                                </div>
                                            </div>

                                            <div class="col-3 col-md-3">
                                                <div class="md-form md-bg">
                                                    <input type="text" class="form-control" id="CVV" form="pagar" required>
                                                    <label for="CVV">CVV</label>
                                                </div>
                                            </div>
                                        </div>
                                        <hr>

                                    </div>
                                    <!--/.Panel 2-->
                                </div>
                                <!-- Pills panels -->


                            </div>
                            <!--Grid column-->
                            <%  
                                Carrito carrito = facade.getCarrito();
                                try {
                                    facade.consultarCarrito(usuario, facade.buscarIdCiudad(usuario, sesion.getAttribute("contraseña").toString(), sesion.getAttribute("Ciudad").toString()));
                            %>
                            <!--Grid column-->
                            <div class="col-lg-4 mb-4">

                                <button class="btn btn-primary btn-lg btn-block" type="submit" form="pagar">Pagar</button>

                                <!--Card-->
                                <div class="card z-depth-0 border border-light rounded-0">

                                    <!--Card content-->
                                    <div class="card-body">
                                        <h4 class="mb-4 mt-1 h5 text-center font-weight-bold">Summary</h4>

                                        <hr>
                                        <%
                                            double total = 0;
                                            for (int i = 0; i < carrito.getId_pedido_array().size(); i++) {
                                        %>
                                        <dl class="row">
                                            <dd class="col-sm-6">
                                                <%= carrito.getNombre_producto_array().get(i)%>
                                            </dd>
                                            <dd class="col-sm-2">
                                                x<%= carrito.getCantidad_array().get(i)%>
                                            </dd>
                                            <dd class="col-sm-4">
                                                $ <%= carrito.getPrecio_base_array().get(i) + (carrito.getPrecio_base_array().get(i) * carrito.getIva_array().get(i))%>
                                            </dd>
                                        </dl>

                                        <hr>
                                        <%
                                                total = total + (carrito.getCantidad_array().get(i) * (carrito.getPrecio_base_array().get(i) + (carrito.getPrecio_base_array().get(i) * carrito.getIva_array().get(i))));
                                            }//End for carrito
                                        %>

                                        <dl class="row">
                                            <dt class="col-sm-8">
                                                Total
                                            </dt>
                                            <dt class="col-sm-4">
                                                $ <%= total%>
                                            </dt>
                                        </dl>
                                    </div>

                                </div>
                                <!--/.Card-->



                            </div>
                            <!--Grid column-->
                            <%
                            } catch (Exception e1) {
                                String error = e1.toString();
                                error = error.replaceAll("\n", "");
                            %>
                            <script  type = "text/javascript">
                                alertify.alert("Error", "<%= "Error-- > " + error %>", function () {
                                    alertify.message('OK');
                                });
                            </script>
                            <%
                                } finally {

                                }//End catch
                            %>
                        </div>
                        <!--Grid row-->

                    </div>
                </div>

            </section>
            <!--Section: Content-->


        </div>
        <!--------------------------------FOOTER--------------------------------->
        <footer class="footer">
            <div class="container mt-5">
                <p class="float-right"><a href="#">Volver al arriba</a></p>
                <p>&copy; 2020 RAFASE, Inc. &middot; <a href="#">Privacidad</a> &middot; <a href="#">Términos y Condiciones</a></p>
            </div>
        </footer>
    </body>
</html>