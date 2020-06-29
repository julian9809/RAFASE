<%-- 
    Document   : productos
    Created on : 24/06/2020, 11:39:59 AM
    Author     : julia
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Producto"%>
<%@page import="control.ProductosDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
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
        <title>Productos</title>
        <link rel="icon" href="../img/Logo.png" type="image/png">
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/bootstrap-theme.min.css">
        <!-- Customs styles for this template -->
        <link rel="stylesheet" href="../css/custom/productos.css">
        <!-- Customs fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Averia+Libre&display=swap" rel="stylesheet">
    </head>
    <body>
        <!-------------------------------Barra de navegación--------------------------------->
        <nav class="navbar navbar-expand-lg navbar navbar-light bg-light">
            <img id="logo" src="../img/Logo.png">
            <a class="navbar-brand" href="../MantenerUsuario?usuario=<%=usuario%> &pagina=inicio">Inicio</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="../MantenerUsuario?usuario=<%=usuario%> &pagina=productos">Productos<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
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
                <%if(usuario.equals("visitante")){%>
                <div class="btn-group" role="group">
                    <a class="btn btn-outline-info iniciar_sesion"  href="sign.jsp" role="button">Iniciar sesión</a>
                    <a class="btn btn-outline-primary"  href="registro_user.jsp" role="button">Registrarse</a>
                </div>
                <%}else{%>
                <div class="btn-group" role="group">
                    <a class="btn btn-outline-info iniciar_sesion"  href="#" role="button"><%=usuario%></a>
                    <form><a class="btn btn-outline-primary"  href="cerrarSesion?usuario=visitante" role="button">Log out</a></form>
                </div>
                <%}%>
            </div>
        </nav>
        <!-------------------------------Contenido-------------------------------------->
        <% ProductosDAO productosDAO = new ProductosDAO();
            ArrayList<Producto> listaproductos = new ArrayList<Producto>();
            listaproductos = productosDAO.buscarProducto("visitante", "abc123", producto_buscado);
        %>
        <h1>Productos</h1>

        <table border="2">
            <thead>
            <th>No</th><th>idProducto</th> <th>Nombre</th> <th>Marca</th> <th>Referencia</th><th>Caracteristicas</th> <th>Foto</th> <th>Precio</th> <th>Unidades</th> <th>Subcategoria</th>
        </thead>
        <tbody>
            <%for (int i = 0; i < listaproductos.size(); i++) {%>
            <tr>
                <td><%=(i + 1)%> </td>
                <td><%=listaproductos.get(i).getId_producto()%></td>
                <td><%=listaproductos.get(i).getNombre_producto()%></td>
                <td><%=listaproductos.get(i).getMarca_producto()%></td>
                <td><%=listaproductos.get(i).getReferencia_producto()%></td>
                <td><%=listaproductos.get(i).getCaracteristicas_producto()%></td>
                <td><%=listaproductos.get(i).getFoto()%></td>
                <td><%=listaproductos.get(i).getPrecio_base()%></td>
                <td><%=listaproductos.get(i).getUnidad_medida()%></td>
                <td><%=listaproductos.get(i).getId_subcategoria()%></td>
                <td><form method="post" action = "../AgregarProducto">
                        <input type="hidden" name = "usuario" id="usuario" value=<%=usuario%>>
                    <input type="hidden" name = "busqueda" id="busqueda" value=<%=producto_buscado%>>
                    <button class="btn btn-outline-success my-2 my-sm-0 buscar" type="submit">Añadir producto</button>                
                </form></td>
            </tr>
            <%}%>
        </tbody>
    </table>
    <!-------------------------------boton flotante--------------------------------->
    <a class="btn btn-success btn-carrito" href="productos.jsp" role="button" data-toggle="modal" data-target="#exampleModal">
        <svg class="bi bi-cart4" id="carrito" width="3em" height="3em" viewBox="0 0 20 20" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
        <path fill-rule="evenodd" d="M0 2.5A.5.5 0 0 1 .5 2H2a.5.5 0 0 1 .485.379L2.89 4H14.5a.5.5 0 0 1 .485.621l-1.5 6A.5.5 0 0 1 13 11H4a.5.5 0 0 1-.485-.379L1.61 3H.5a.5.5 0 0 1-.5-.5zM3.14 5l.5 2H5V5H3.14zM6 5v2h2V5H6zm3 0v2h2V5H9zm3 0v2h1.36l.5-2H12zm1.11 3H12v2h.61l.5-2zM11 8H9v2h2V8zM8 8H6v2h2V8zM5 8H3.89l.5 2H5V8zm0 5a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0zm9-1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0z"/>
        </svg>
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
                <div class="modal-body">
                    ...
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Volver</button>
                    <button type="button" class="btn btn-success">Pagar</button>
                </div>
            </div>
        </div>
    </div>
    <!-------------------------------Scripts--------------------------------->
    <script src="../js/jquery.js"></script>
    <script src="../js/bootstrap.min.js"></script>
</body>
</html>
