<%-- 
    Document   : productos
    Created on : 24/06/2020, 11:39:59 AM
    Author     : julia
--%>

<%@page import="util.CaException"%>
<%@page import="modelo.InventarioRafase"%>
<%@page import="modelo.Pedido"%>
<%@page import="control.DAOFacade"%>
<%@page import="modelo.Carrito"%>
<%@page import="modelo.Producto"%>
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

    String producto_buscado = request.getParameter("busqueda");
    String categoria = request.getParameter("categoria");
    String usuario = sesion.getAttribute("usuario").toString();

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Productos</title>
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
            InventarioRafase inventarioRafase = facade.getInventario_rafase();
            try {
                facade.buscarProducto(sesion.getAttribute("usuario").toString(),
                        sesion.getAttribute("contraseña").toString(),
                        producto_buscado, ciudad, "", categoria);
            } catch (Exception e1) {
        %>
        <script type="text/javascript">
            alertify.alert("Error", "<%= "Error --> " + e1 + e1.getMessage() %>", function () {
                alertify.message('OK');
            });
        </script>
        <%
            }//End catch
        %>        
        <!--------------------------------Productos--------------------------------->
        <div class="container-fluid my-5">

            <!--Section: Content-->
            <section class="dark-grey-text text-center">

                <!-- Section heading -->
                <h1 class="font-weight-bold mb-4 pb-2">Productos</h1>
                <!-- Section description -->
                <p class="grey-text w-responsive mx-auto mb-5">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ante nulla, sagittis et commodo ac, sollicitudin at purus. Quisque elementum diam eget luctus feugiat. Donec turpis dolor, pulvinar vitae luctus vitae, imperdiet id est. Aenean interdum sem sed sapien suscipit, sit amet aliquet diam blandit. Maecenas mollis, sem sed volutpat cursus, felis sem euismod magna, vel condimentum nulla quam a mauris. Mauris sit amet dapibus augue. Curabitur quam libero, feugiat sed efficitur a, porta ac elit. Nam at fringilla urna, non convallis elit. Donec sed nisi gravida, ullamcorper ex et, aliquam metus. Nulla at quam metus. Donec dictum ipsum tristique nisl posuere, at congue risus tincidunt.
                </p>

                <!-- Grid row -->
                <div class="row justify-content-center">
                    <div class="card-deck col-12 text-center">
                        <%
                            for (int i = 0; i < inventarioRafase.getProducto().getId_producto_array().size(); i++) {
                        %>
                        <!-- Grid column -->
                        <div class="col-lg-4 col-md-6 mb-4">

                            <form id="agregar_producto_<%= inventarioRafase.getProducto().getId_producto_array().get(i)%>" method="post" action = "../AgregarProducto">
                                <!-- Card -->
                                <div class="card card-cascade">
                                    <!-- Card image -->
                                    <div class="view view-cascade overlay zoom">
                                        <img src="../img/Productos/<%= inventarioRafase.getCategoria().getNombre_categoria_array().get(i)
                                                + "/" + inventarioRafase.getSubcategoria().getNombre_subcategoria_array().get(i)
                                                + "/" + inventarioRafase.getProducto().getId_producto_array().get(i)
                                                + "/" + inventarioRafase.getProducto().getFoto_array().get(i)%>" class="img-responsive card-img-top"
                                             alt="Imagen de <%= inventarioRafase.getProducto().getNombre_producto_array().get(i)%>"
                                             title="Imagen de <%= inventarioRafase.getProducto().getNombre_producto_array().get(i)%>">
                                        <a>
                                            <div class="mask rgba-white-slight"></div>
                                        </a>
                                    </div>
                                    <!-- Card image -->
                                    <!-- Card content -->
                                    <div class="card-body card-body-cascade text-center pb-3">
                                        <!-- Title -->
                                        <h5 class="card-title mb-1">
                                            <a class="font-weight-bold" href="#!"><%= inventarioRafase.getProducto().getNombre_producto_array().get(i)%></a>
                                        </h5>
                                        <!-- Description -->
                                        <p class="card-text">
                                            <%= inventarioRafase.getProducto().getCaracteristicas_producto_array().get(i)%>
                                        </p>
                                        <!-- Card footer -->
                                        <div class="card-footer px-1 white text-center">
                                            <div class="d-flex justify-content-between">
                                                <span class="font-weight-bold align-middle">
                                                    $<%= inventarioRafase.getInventario().getPrecio_base_array().get(i)
                                                            + (inventarioRafase.getInventario().getPrecio_base_array().get(i)
                                                            * inventarioRafase.getProducto().getIva_array().get(i))%>
                                                </span>
                                            </div>
                                            <div class="d-flex justify-content-between mt-2">
                                                <div class="def-number-input number-input safari_only">
                                                    <button type="button" onclick="this.parentNode.querySelector('input[type=number]').stepDown()" class="minus form-control"></button>
                                                    <input type="number" class="form-control quantity" min="0" max="99" placeholder="Cant" value="" name="cantidad" id="cantidad" required>
                                                    <button type="button" onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="plus form-control"></button>
                                                </div>
                                                <!--Entradas escondidad-->
                                                <input type="hidden" name = "id_producto" id="id_producto" value=<%= inventarioRafase.getProducto().getId_producto_array().get(i)%>>
                                                <input type="hidden" name = "busqueda" id="busqueda" value=<%= producto_buscado%>>
                                                <input type="hidden" name = "categoria" id="categoria" value=<%= categoria%>>
                                                <!--Entradas escondidad-->
                                                <button class="btn btn-success btn-sm my-auto btnRedondo" type="submit" form="agregar_producto_<%= inventarioRafase.getProducto().getId_producto_array().get(i)%>" title="Añadir al carrito">
                                                    <i class="fas fa-cart-arrow-down fa-2x"></i>
                                                </button>
                                            </div>
                                        </div>

                                    </div>
                                    <!-- Card content -->
                                </div>
                                <!-- Card -->

                            </form>
                        </div>
                        <!-- Grid column -->
                        <%}//End For%>
                    </div>
                </div>
                <!-- Grid row -->
                <!-- Grid row -->
                <div class="row justify-content-center mt-3 mb-4">
                    <!-- Pagination -->
                    <nav class="mb-4">
                        <ul class="pagination pagination-circle pg-blue mb-0">
                            <!-- First -->
                            <li class="page-item disabled clearfix d-none d-md-block">
                                <a class="page-link waves-effect waves-effect">First</a>
                            </li>
                            <!-- Arrow left -->
                            <li class="page-item disabled">
                                <a class="page-link waves-effect waves-effect" aria-label="Previous">
                                    <span aria-hidden="true">«</span>
                                    <span class="sr-only">Previous</span>
                                </a>
                            </li>
                            <!-- Numbers -->
                            <li class="page-item active">
                                <a class="page-link waves-effect waves-effect">1</a>
                            </li>
                            <li class="page-item">
                                <a class="page-link waves-effect waves-effect">2</a>
                            </li>
                            <li class="page-item">
                                <a class="page-link waves-effect waves-effect">3</a>
                            </li>
                            <li class="page-item">
                                <a class="page-link waves-effect waves-effect">4</a>
                            </li>
                            <li class="page-item">
                                <a class="page-link waves-effect waves-effect">5</a>
                            </li>
                            <!-- Arrow right -->
                            <li class="page-item">
                                <a class="page-link waves-effect waves-effect" aria-label="Next">
                                    <span aria-hidden="true">»</span>
                                    <span class="sr-only">Next</span>
                                </a>
                            </li>
                            <!-- First -->
                            <li class="page-item clearfix d-none d-md-block">
                                <a class="page-link waves-effect waves-effect">Last</a>
                            </li>
                        </ul>
                    </nav>
                    <!-- Pagination -->
                </div>
                <!-- Grid row -->
            </section>
            <!--Section: Content-->
        </div>
        <!-------------------------------boton flotante--------------------------------->
        <% if(!usuario.equals("visitante")) {%>
        <a class="btn btn-default btn-carrito floating-action-button" href="productos.jsp" role="button" data-toggle="modal" data-target="#modalCarrito">
            <i class="fas fa-shopping-cart fa-3x"></i>
        </a>
        <!---------------------- Modal --------------------------------->
        <div class="modal fade" id="modalCarrito" tabindex="-1" role="dialog" aria-labelledby="modalCarritoLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-lg modal-notify modal-success" role="document">
                <div class="modal-content">
                    <div class="modal-header default-color-dark">
                        <h5 class="modal-title text-white font-weight-bold" id="modalCarritoLabel">Tu carrito</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <%  
                        Carrito carrito = facade.getCarrito();
                        try {
                                facade.consultarCarrito(usuario, facade.buscarIdCiudad(usuario, sesion.getAttribute("contraseña").toString(), sesion.getAttribute("Ciudad").toString()));
                    %>   
                    <div class="modal-body table-responsive">

                        <table class="table table-hover my-0">

                            <!-- Table head -->
                            <thead class="mdb-color text-white">
                                <tr>
                                    <th></th>
                                    <th class="font-weight-bold">
                                        <h5>Producto</h5>
                                    </th>
                                    <th class="font-weight-bold">
                                        <h5>Subcategoria</h5>
                                    </th>
                                    <th></th>
                                    <th class="font-weight-bold">
                                        <h5>Precio</h5>
                                    </th>
                                    <th class="font-weight-bold">
                                        <h5>Cantidad</h5>
                                    </th>
                                    <th class="font-weight-bold">
                                        <h5>Monto</h5>
                                    </th>
                                    <th></th>
                                </tr>
                            </thead>
                            <!-- /.Table head -->

                            <!-- Table body -->
                            <tbody>
                                <!-- First row -->
                                <%
                                    double total = 0;
                                    for (int i = 0; i < carrito.getId_pedido_array().size(); i++) {
                                %>
                                <tr>
                                    <th scope="row">
                                        <img src="../img/Productos/<%= carrito.getNombre_categoria_array().get(i)
                                                + "/" + carrito.getNombre_subcategoria_array().get(i)
                                                + "/" + carrito.getId_producto_array().get(i)
                                                + "/" + carrito.getFoto_array().get(i)%>" alt="" class="img-fluid z-depth-0">
                                    </th>
                                    <td>
                                        <h5 class="font-weight-bold">
                                            <%= carrito.getNombre_producto_array().get(i)%>
                                        </h5>
                                        <p class="text-muted"><%= carrito.getMarca_producto_array().get(i)%></p>
                                    </td>
                                    <td><%= carrito.getNombre_subcategoria_array().get(i)%></td>
                                    <td></td>
                                    <td>$<%= carrito.getPrecio_base_array().get(i) + (carrito.getPrecio_base_array().get(i) * carrito.getIva_array().get(i))%></td>
                                    <td>
                                        <input type="number" value="<%= carrito.getCantidad_array().get(i)%>" aria-label="Search" class="form-control" style="width: 100px">
                                    </td>
                                    <td class="font-weight-bold">$<%= carrito.getCantidad_array().get(i) * (carrito.getPrecio_base_array().get(i) + (carrito.getPrecio_base_array().get(i) * carrito.getIva_array().get(i)))%>
                                    </td>
                                    <td>
                                        <button type="button" class="btn btn-sm btn-primary btnRedondo" data-toggle="tooltip" data-placement="top"
                                                title="Remove item">X
                                        </button>
                                    </td>
                                </tr>
                                <!-- /.First row -->
                                <%
                                    total = total + (carrito.getCantidad_array().get(i)*(carrito.getPrecio_base_array().get(i) + (carrito.getPrecio_base_array().get(i) * carrito.getIva_array().get(i))));
                                    }//End for carrito
                                %>
                            </tbody>
                            <!-- /.Table body -->

                        </table>

                    </div>
                    <!-- /.Shopping Cart table -->
                    <!-- Footer carrito-->
                    <div class="modal-footer justify-content-between">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Volver</button>
                        <div class="ml-auto">
                            <h4 class="font-weight-bold">
                                Total: $<%= total %>
                            </h4>
                        </div>
                        <a type="button" class="float-right btn btn-success" href="pago.jsp">Pagar
                            <i class="fas fa-angle-right right"></i>
                        </a>
                    </div>
                    <%
                    } catch (Exception e1) {
                    %>
                    <script  type = "text/javascript">
                        alertify.alert("Error", "<%= "Error-- > " + e1 + e1.getMessage()%>", function () {
                            alertify.message('OK');
                        });
                    </script>
                    <%
                        } finally {

                        }//End catch
                    %>
                </div>
            </div>
        </div>
        <% }//End if isVisitante %>        
    </body>
    <!--------------------------------FOOTER--------------------------------->
    <footer class="page-footer text-center font-small info-color-dark darken-2 mt-4 wow fadeIn">
        <div class="footer-copyright py-3">
            <p class="float-right"><a href="#">Volver al arriba</a></p>
            <p>&copy; 2020 RAFASE, Inc. &middot; <a href="#">Privacidad</a> &middot; <a href="#">Términos y Condiciones</a></p>
        </div>
    </footer>
</html>
