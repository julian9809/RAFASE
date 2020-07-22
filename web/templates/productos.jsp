<%-- 
    Document   : productos
    Created on : 24/06/2020, 11:39:59 AM
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
    HttpSession sesion = request.getSession();
    String ciudad = "no ciudad";
    
    if(sesion.getAttribute("Ciudad")!=null){
        ciudad = sesion.getAttribute("Ciudad").toString();
    }else{
        out.print("<script>location.replace('../index.jsp');</script>");
    }
    
    String producto_buscado = request.getParameter("busqueda");
    String usuario = "";
    System.out.println("" + request.getParameter("usuario"));
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
        <!-- Customs styles for this template -->
        <link rel="stylesheet" href="../css/custom/productos.css">
        <!-- Customs fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Averia+Libre&display=swap" rel="stylesheet">
    </head>
    <body>
        <!-------------------------------Barra de navegación--------------------------------->
        <nav class="navbar navbar-expand-lg navbar navbar-light bg-light sticky-top scrolling-navbar">
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
                <form action="../BuscarProducto" method="post" class="form-inline my-2 my-lg-0 ml-auto">
                    <input class="form-control mr-sm-2" type="search" placeholder="Buscar productos" name="producto_buscado" id="producto_buscado" aria-label="Search">
                    <input type="hidden" name="usuario" id="usuario" value=<%=usuario%>>
                </form>
                <%if (usuario.equals("visitante")) {%>
                <div class="btn-group btn-sm" role="group">
                    <a class="btn btn-outline-info btn-sm align-middle ml-0" href="sign.jsp" role="button">Iniciar sesión</a>
                    <a class="btn btn-outline-primary btn-sm  align-middle" href="registro_user.jsp" role="button">Registrarse</a>
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
        <!-------------------------------Contenido-------------------------------------->
        <% ProductosDAO productosDAO = new ProductosDAO();
            ArrayList<Producto> listaproductos = new ArrayList<>();
            listaproductos = productosDAO.buscarProducto("visitante", "abc123", producto_buscado);
        %>
        <h1>Productos</h1>
        <div class="table-responsive">
            <table class="table table-bordered table-hover">
                <thead class="thead-dark">
                <th>No</th>
                <th>Nombre</th>
                <th>Marca</th>
                <th>Referencia</th>
                <th>Caracteristicas</th>
                <th>Foto</th>
                <th>Precio</th>
                <th>Unidades</th>
                </thead>
                <tbody>
                    <%for (int i = 0; i < listaproductos.size(); i++) {%>
                    <tr>
                        <th scope="row"><%=(i + 1)%> </th>
                        <td><%=listaproductos.get(i).getNombre_producto()%></td>
                        <td><%=listaproductos.get(i).getMarca_producto()%></td>
                        <td><%=listaproductos.get(i).getReferencia_producto()%></td>
                        <td><%=listaproductos.get(i).getCaracteristicas_producto()%></td>
                        <td><img class="img-thumbnail img-responsive" alt="Responsive image" width="150" height="150" src="../img/Productos/<%=listaproductos.get(i).getFoto()%>"></td>
                        <td><%=listaproductos.get(i).getPrecio_base()%></td>
                        <td><%=listaproductos.get(i).getUnidad_medida()%></td>
                        <td>
                            <form method="post" action = "../AgregarProducto">
                                <input type="hidden" name = "id_producto" id="id_producto" value=<%=listaproductos.get(i).getId_producto()%>>
                                <input type="hidden" name = "usuario" id="usuario" value=<%=usuario%>>
                                <input type="hidden" name = "busqueda" id="busqueda" value=<%=producto_buscado%>>
                                <button class="btn btn-outline-success my-2 my-sm-0 buscar" type="submit">Añadir producto</button>                
                            </form>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>

        <!-------------------------------boton flotante--------------------------------->
        <%if (!usuario.equals("visitante")) {%>
        <a class="btn btn-default btn-carrito floating-action-button" href="productos.jsp" role="button" data-toggle="modal" data-target="#exampleModal">
            <i class="fas fa-shopping-cart fa-3x"></i>
        </a>

        <!---------------------- Modal --------------------------------->

        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Tu carrito</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <% PedidoDAO pedidoDAO = new PedidoDAO();
                        ArrayList<Carrito> listarcarrito = new ArrayList<>();
                        listarcarrito = pedidoDAO.consultarCarrito(usuario);
                        if (!listarcarrito.isEmpty()) {
                            double total = 0;
                    %>
                    <div class="modal-body table-responsive">
                        <h2>Pedido: <%=listarcarrito.get(0).getId_pedido()%></h2>
                        <table class="table table-bordered table-hover">
                            <thead class="thead-dark">
                            <th>Nombre</th>
                            <th>Cantidad</th>
                            <th>Precio</th>
                            </thead>
                            <tbody>
                                <%for (int i = 0; i < listarcarrito.size(); i++) {%>
                                <tr>
                                    <td><%=listarcarrito.get(i).getNombreProducto()%></td>
                                    <td><%=listarcarrito.get(i).getCantidad()%></td>
                                    <td><%=listarcarrito.get(i).getPrecio_base()%></td>
                                    <%
                                        total = total + (listarcarrito.get(i).getPrecio_base() * listarcarrito.get(i).getCantidad());%>
                                </tr>
                                <%}%>
                            </tbody>
                            <td colspan="2">Total</td>
                            <td><%=total%></td>
                        </table>
                    </div>
                    <%}%>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Volver</button>
                        <button type="button" class="btn btn-success">Pagar</button>
                    </div>
                </div>
            </div>
        </div>
        <%}%>
        <!--------------------------------Productos--------------------------------->
        <div class="container-fluid">
            <h1 class="display-4 mt-2 mb-4 text-center">Productos</h1>

            <div class="row justify-content-center">
                <div class="card-deck col-12 text-center">
                    <%for (int i = 0; i < listaproductos.size(); i++) {%>
                    <div class="col-md-6 col-xl-4">
                        <div class="card bg-light border-info mb-4 shadow-sm">

                            <!--td><%=listaproductos.get(i).getNombre_producto()%></td>
                            <td><%=listaproductos.get(i).getMarca_producto()%></td>
                            <td><%=listaproductos.get(i).getReferencia_producto()%></td>
                            <td><%=listaproductos.get(i).getCaracteristicas_producto()%></td>
                            <td></td>
                            <td><%=listaproductos.get(i).getPrecio_base()%></td>
                            <td><%=listaproductos.get(i).getUnidad_medida()%></td>
                            <td>
                                <form method="post" action = "../AgregarProducto">
                                    <input type="hidden" name = "id_producto" id="id_producto" value=<%=listaproductos.get(i).getId_producto()%>>
                                    <input type="hidden" name = "usuario" id="usuario" value=<%=usuario%>>
                                    <input type="hidden" name = "busqueda" id="busqueda" value=<%=producto_buscado%>>
                                    <button class="btn btn-outline-success my-2 my-sm-0 buscar" type="submit">Añadir producto</button>                
                                </form>
                            </td-->
                            <div class="card-header"><%=listaproductos.get(i).getNombre_producto()%></div>
                            <div class="card-body">
                                <h5 class="card-title">
                                    <img class="img-thumbnail img-responsive" alt="Responsive image" width="200" height="200" src="../img/Productos/<%=listaproductos.get(i).getFoto()%>">
                                </h5>
                                <p>$<%=listaproductos.get(i).getPrecio_base()%></p>
                                <form method="post" action = "../AgregarProducto">
                                    <input type="hidden" name = "id_producto" id="id_producto" value=<%=listaproductos.get(i).getId_producto()%>>
                                    <input type="hidden" name = "usuario" id="usuario" value=<%=usuario%>>
                                    <input type="hidden" name = "busqueda" id="busqueda" value=<%=producto_buscado%>>
                                    <div class="btn-group" role="group">
                                        <input type="number" min="0" max="99" class="form-control" placeholder="Cant" value="" name="Cantidad" id="Cantidad"/>
                                        <button class="btn btn-success my-0 bordes" type="submit"><i class="fas fa-cart-arrow-down fa-2x"></i></button>                
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <%}%>
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
