<%-- 
    Document   : admon
    Created on : 17/08/2020, 02:25:59 PM
    Author     : julia
--%>

<%@page import="modelo.Ciudad"%>
<%@page import="modelo.InventarioRafase"%>
<%@page import="modelo.Proveedor"%>
<%@page import="util.CaException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="modelo.Admon"%>
<%@page import="control.DAOFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    request.setCharacterEncoding("UTF-8");
    HttpSession sesion = request.getSession();
    String ciudad = "no ciudad";
    if (sesion.getAttribute("Ciudad") != null) {
        ciudad = sesion.getAttribute("Ciudad").toString();
    } else {
        out.print("<script>location.replace('../index.jsp');</script>");
    }

    String usuario = sesion.getAttribute("usuario").toString();
    String contraseña = sesion.getAttribute("contraseña").toString();

    String ciudad_stock = request.getParameter("ciudad_stock");

%>
<html lang="es">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Administrador</title>
        <!-- RAFASE icon -->
        <link rel="icon" href="../img/Logo.png" type="image/png">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
        <!-- Bootstrap core CSS -->
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <!-- Material Design Bootstrap -->
        <link href="../css/mdb.min.css" rel="stylesheet">
        <!-- Your custom styles (optional) -->
        <link href="../css/style.min.css" rel="stylesheet">
        <!---------------------- Alertify CSS ---------------------->
        <!-- CSS -->
        <link rel="stylesheet" href="../css/alertify/alertify.min.css"/>
        <!-- Default theme -->
        <link rel="stylesheet" href="../css/alertify/themes/default.min.css"/>
        <!-- Semantic UI theme -->
        <link rel="stylesheet" href="../css/alertify/themes/semantic.min.css"/>
        <!-- Bootstrap theme -->
        <link rel="stylesheet" href="../css/alertify/themes/bootstrap.min.css"/>
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
        <style>

            .map-container{
                overflow:hidden;
                padding-bottom:56.25%;
                position:relative;
                height:0;
            }
            .map-container iframe{
                left:0;
                top:0;
                height:100%;
                width:100%;
                position:absolute;
            }
        </style>        
    </head>

    <body class="grey lighten-3">

        <!--Main Navigation-->
        <header>

            <!-- Navbar -->
            <nav class="navbar fixed-top navbar-expand-lg navbar-light white scrolling-navbar">
                <div class="container-fluid">

                    <!-- Brand -->
                    <a class="navbar-brand waves-effect" href="index.jsp">
                        <strong class="blue-text">Inicio</strong>
                    </a>

                    <!-- Collapse -->
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <!-- Links -->
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">

                        <!-- Left -->
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item">
                                <a class="nav-link waves-effect" href="../BuscarProducto?producto_buscado=">Productos
                                    <span class="sr-only">(current)</span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link waves-effect" href="pago.jsp">Ir a pagar</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link waves-effect" href="admon.jsp">Control</a>
                            </li>
                        </ul>

                        <!-- Right 
                        <ul class="navbar-nav nav-flex-icons">
                          <li class="nav-item">
                            <a href="https://www.facebook.com/mdbootstrap" class="nav-link waves-effect" target="_blank">
                              <i class="fab fa-facebook-f"></i>
                            </a>
                          </li>
                          <li class="nav-item">
                            <a href="https://twitter.com/MDBootstrap" class="nav-link waves-effect" target="_blank">
                              <i class="fab fa-twitter"></i>
                            </a>
                          </li>
                          <li class="nav-item">
                            <a href="https://github.com/mdbootstrap/bootstrap-material-design" class="nav-link border border-light rounded waves-effect"
                              target="_blank">
                              <i class="fab fa-github mr-2"></i>MDB GitHub
                            </a>
                          </li>
                        </ul>
                        -->
                    </div>

                </div>
            </nav>
            <!-- Navbar -->

            <!-- Sidebar -->
            <div class="sidebar-fixed position-fixed">

                <a class="waves-effect">
                    <img src="../img/rafase.gif" class="img-fluid" alt="">
                </a>

                <div class="list-group list-group-flush" id="list-tab" role="tablist">
                    <a href="" onclick="statistics()" class="list-group-item waves-effect list-group-item-action" data-toggle="list" role="tab">
                        <i class="fas fa-chart-pie mr-3"></i>Estadísticas</a>
                    <a href="" onclick="clientes()" class="list-group-item list-group-item-action waves-effect list-group-item-action" data-toggle="list" role="tab">
                        <i class="fas fa-users mr-3"></i>Clientes</a>
                    <a href="" onclick="proveedores()" class="list-group-item list-group-item-action waves-effect list-group-item-action" data-toggle="list" role="tab">
                        <i class="fas fa-shipping-fast mr-3"></i>Proveedores</a>
                    <a href="" onclick="stock()" class="list-group-item list-group-item-action waves-effect list-group-item-action" data-toggle="list" role="tab">
                        <i class="fas fa-clipboard-list mr-3"></i>Stock</a>
                    <a href="" onclick="sucursales()" class="list-group-item list-group-item-action waves-effect list-group-item-action" data-toggle="list" role="tab">
                        <i class="fas fa-map mr-3"></i>Sucursales</a>
                    <a href="" onclick="perfil()" class="list-group-item waves-effect list-group-item-action" data-toggle="list" role="tab">
                        <i class="fas fa-user mr-3"></i>Perfil de administrador</a>
                </div>

            </div>
            <!-- Sidebar -->

        </header>
        <!--Main Navigation-->

        <!--Main layout-->
        <main class="pt-5 mx-lg-5">
            <div class="container-fluid mt-5" id="statistics">               

                <!--Grid row-->
                <div class="row wow fadeIn">

                    <!--Grid column-->
                    <div class="col-md-6 mb-4">

                        <!--Card-->
                        <div class="card">

                            <!--Card content-->
                            <div class="card-body">

                                <!-- Table  -->
                                <table class="table table-hover">

                                    <!-- Table body -->
                                    <tbody>
                                        <tr>
                                            <td>Valor total vendido</td>
                                            <td>Cell 2</td>
                                        </tr>
                                        <tr>
                                            <td>Producto más vendido</td>
                                            <td>Cell 5</td>
                                        </tr>
                                        <tr>
                                            <td>Producto menos vendido</td>
                                            <td>Cell 8</td>
                                        </tr>
                                        <tr>
                                            <td>Cliente con mayor volumen de compras</td>
                                            <td>Cell 8</td>
                                        </tr>
                                        <tr>
                                            <td>Pagos rechazados</td>
                                            <td>Cell 8</td>
                                        </tr>
                                        <tr>
                                            <td>Tiempo promedio de entrega del pedido</td>
                                            <td>Cell 8</td>
                                        </tr>
                                    </tbody>
                                    <!-- Table body -->
                                </table>
                                <!-- Table  -->

                            </div>

                        </div>
                        <!--/.Card-->

                    </div>
                    <!--Grid column-->

                    <!--Grid column-->
                    <div class="col-lg-6 col-md-6 mb-4">

                        <!--Card-->
                        <div class="card">

                            <!-- Card header -->
                            <div class="card-header text-center">
                                Bar chart
                            </div>

                            <!--Card content-->
                            <div class="card-body">

                                <canvas id="myChart"></canvas>

                            </div>

                        </div>
                        <!--/.Card-->

                    </div>
                    <!--Grid column-->                    

                </div>
                <!--Grid row-->

                <!--Grid row-->
                <div class="row wow fadeIn">  

                    <!--Grid column-->
                    <div class="col-lg-6 col-md-6 mb-4">

                        <!--Card-->
                        <div class="card">

                            <!-- Card header -->
                            <div class="card-header text-center">
                                Pie chart
                            </div>

                            <!--Card content-->
                            <div class="card-body">

                                <canvas id="pieChart"></canvas>

                            </div>

                        </div>
                        <!--/.Card-->                        

                    </div>
                    <!--Grid column--> 

                    <!--Grid column-->
                    <div class="col-lg-6 col-md-6 mb-4">

                        <!--Card-->
                        <div class="card">

                            <!-- Card header -->
                            <div class="card-header">Horizontal Bar Chart</div>

                            <!--Card content-->
                            <div class="card-body">

                                <canvas id="horizontalBar"></canvas>

                            </div>

                        </div>
                        <!--/.Card-->

                    </div>
                    <!--Grid column-->

                </div>
                <!--Grid row-->

                <!--Grid row-->
                <div class="row wow fadeIn">

                    <!--Grid column-->
                    <div class="col-lg-6 col-md-6 mb-4">

                        <!--Card-->
                        <div class="card">

                            <!-- Card header -->
                            <div class="card-header">Line chart</div>

                            <!--Card content-->
                            <div class="card-body">

                                <canvas id="lineChart"></canvas>

                            </div>

                        </div>
                        <!--/.Card-->

                    </div>
                    <!--Grid column-->

                    <!--Grid column-->
                    <div class="col-lg-6 col-md-6 mb-4">

                        <!--Card-->
                        <div class="card">

                            <!-- Card header -->
                            <div class="card-header">Radar Chart</div>

                            <!--Card content-->
                            <div class="card-body">

                                <canvas id="radarChart"></canvas>

                            </div>

                        </div>
                        <!--/.Card-->

                    </div>
                    <!--Grid column-->

                    <!--Grid column-->
                    <div class="col-lg-6 col-md-6 mb-4">

                        <!--Card-->
                        <div class="card">

                            <!-- Card header -->
                            <div class="card-header">Doughnut Chart</div>

                            <!--Card content-->
                            <div class="card-body">

                                <canvas id="doughnutChart"></canvas>

                            </div>

                        </div>
                        <!--/.Card-->

                    </div>
                    <!--Grid column-->

                </div>
                <!--Grid row-->                

            </div>

            <%                DAOFacade facade = new DAOFacade();
                Admon adm = facade.getAdmon();
                Proveedor proveedor = facade.getProveedor();
                Ciudad ciu = facade.getCiudad();
                InventarioRafase inventarioRafase = facade.getInventario_rafase();

                try {
                    facade.buscarAdministradores(usuario, contraseña);
                    facade.buscarProveedores(usuario, contraseña);
                    facade.buscarCiudades(usuario, contraseña);
                } catch (CaException e1) {
                    String error = e1.toString();
                    error = error.replaceAll("\n", "");
            %>
            <script type="text/javascript">
                alertify.alert("Error", "<%= "Error --> " + error%>", function () {
                    alertify.error('Acceso denegado');
                }).set({onshow: null, onclose: function () {
                        setTimeout(() => {
                            window.location = 'index.jsp';
                        }, 1000);
                    }});
            </script>
            <%
                }//end catch            
            %>

            <!--Administrador-->
            <div class="container-fluid mt-5 py-lg-5" id="perfil">
                <div class="card">
                    <div class="card-header warning-color white-text">
                        Administrador
                    </div>
                    <div class="card-body">
                        <table class="table">
                            <thead class="grey lighten-2">
                                <tr>
                                    <th>Datos personales</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% if (adm.getId_administrador_array().isEmpty()) { %>
                                <tr>
                                    <td>No se encuentran administradores</td>
                                </tr>
                                <% } else { %>
                                <%
                                    for (int i = 0; i < adm.getId_administrador_array().size(); i++) {
                                %>
                                <tr>
                                    <td scope="row" class="font-weight-bold">Nombre</td>
                                    <td><%= adm.getNombre_completo_array().get(i)%></td>
                                </tr>
                                <tr>
                                    <td scope="row" class="font-weight-bold">Email</td>
                                    <td><%= adm.getCorreo_array().get(i)%></td>
                                </tr>
                                <% } //end for %>
                                <% } //end if %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <!--Administrador-->

            <!--Proveedores-->
            <div class="container-fluid mt-5 py-lg-5" id="proveedores">
                <div class="card">
                    <div class="card-header info-color-dark white-text">
                        Listado de proveedores
                    </div>
                    <div class="card-body">
                        <% 
                            if (proveedor.getId_proveedor_array().isEmpty()) {
                        %>
                        <table class="table">
                            <tbody>
                                <tr>
                                    <td>No hay proveedores agregados</td>
                                    <td><a class="btn btn-info btn-sm align-middle ml-0" href="admon.jsp" role="button" data-toggle="modal" data-target="#modalProveedor">Registrar proveedor</a></td>
                                </tr>
                            </tbody>
                        </table>
                        <% } else { %>
                        <table class="table">
                            <thead class="grey lighten-2">
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Dirección</th>
                                </tr>                            
                            </thead>
                            <tbody>
                                <%
                                    for (int i = 0; i < proveedor.getId_proveedor_array().size(); i++) {
                                %>                        
                                <tr>
                                    <th scope="row"><%= i + 1%></th>
                                    <td><%= proveedor.getNombre_array().get(i)%></td>
                                    <td><%= proveedor.getDireccion_array().get(i)%></td>
                                </tr>

                                <% } //end for %>
                            </tbody>
                        </table>
                        <div class="text-center">
                            <a class="btn btn-info btn-sm align-middle ml-0" href="admon.jsp" role="button" data-toggle="modal" data-target="#modalProveedor">Registrar proveedor</a>
                        </div>
                        <% } //end if %>                            
                    </div>
                </div>
            </div>
            <!--Proveedores-->

            <!------------------------------------Modal proveedores--------------------------------------------->
            <div class="modal fade" id="modalProveedor" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog modal-notify" role="document">
                    <!--Content-->
                    <div class="modal-content">
                        <!--Header-->
                        <div class="modal-header text-center info-color">
                            <h4 class="modal-title white-text w-100 font-weight-bold py-2">Registra proveedor</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true" class="white-text">&times;</span>
                            </button>
                        </div>
                        <!--Body-->
                        <form action="../registrar_proveedor" method="post">
                            <div class="modal-body">                                
                                <div class="md-form mb-5 amber-input active-amber-input">
                                    <i class="fas fa-portrait prefix"></i>
                                    <label for="nombreProveedor" data-error="wrong" data-success="right">Nombre de proveedor</label>
                                    <input type="text" class="form-control validate mb-0" id="nombreProveedor"  name="nombreProveedor" required>
                                    <small class="text-muted">Nombre completo del proveedor</small>
                                    <div class="invalid-feedback">
                                        Nombre del proveedor es requerido
                                    </div>
                                </div>
                                <div class="md-form mb-5 amber-input active-amber-input">
                                    <i class="fas fa-id-card prefix"></i>
                                    <label for="numero" data-error="wrong" data-success="right">NIT</label>
                                    <input type="number" class="form-control validate" id="numero" name="numero" required>
                                    <div class="invalid-feedback">
                                        NIT requerido
                                    </div>
                                </div> 
                                <div class="md-form mb-5 amber-input active-amber-input">
                                    <i class="fas fa-home prefix"></i>
                                    <label for="direccionProveedor" data-error="wrong" data-success="right">Dirección del proveedor</label>
                                    <input type="text" class="form-control validate" id="direccionProveedor" name="direccionProveedor" required>
                                    <div class="invalid-feedback">
                                        Dirección del proveedor requerido
                                    </div>
                                </div>
                                <!--Footer-->
                                <div class="modal-footer justify-content-center">
                                    <button class="btn btn-info waves-effect" type="submit">Registrar</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- modal proveedores -->
            
            <!--Clientes-->
            <div class="container-fluid mt-5 py-lg-5" id="clientes">
                <div class="card">
                    <div class="card-header warning-color white-text">
                        Clientes
                    </div>
                </div>
            </div>
            <!--Clientes-->

            <!--Stock-->
            <div class="container-fluid mt-5 py-lg-5" id="stock">
                <div class="card">
                    <div class="card-header success-color white-text">
                        Stock
                    </div>
                    <div class="card-body">
                        <table class="table table-bordered">
                            <thead class="grey lighten-2">
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Producto</th>
                                    <th scope="col">Categoria</th>
                                    <th scope="col">Subcategoria</th>
                                    <th scope="col">Marca</th>
                                    <th scope="col">Referencia</th>
                                    <th scope="col">Existencias</th>
                                    <th scope="col">Precio base</th>
                                </tr>
                            </thead>
                            <tbody>                            
                                <%  
                                    for (int j = 0; j < ciu.getId_ciudad_array().size(); j++) {
                                        facade.buscarProducto(usuario, contraseña, "", ciu.getNombre_array().get(j), "", "");
                                %>
                                <tr>
                                    <td colspan="8" class="text-center info-color white-text font-weight-bold"><%= ciu.getNombre_array().get(j)%></td>
                                </tr>
                                <%
                                    for (int i = 0; i < inventarioRafase.getProducto().getId_producto_array().size(); i++) {
                                %>
                                <tr>
                                    <th scope="row"><%= i + 1%></th>
                                    <td><%= inventarioRafase.getProducto().getNombre_producto_array().get(i)%></td>
                                    <td><%= inventarioRafase.getCategoria().getNombre_categoria_array().get(i)%></td>
                                    <td><%= inventarioRafase.getSubcategoria().getNombre_subcategoria_array().get(i)%></td>
                                    <td><%= inventarioRafase.getProducto().getMarca_producto_array().get(i)%></td>
                                    <td><%= inventarioRafase.getProducto().getReferencia_producto_array().get(i)%></td>
                                    <td><%= inventarioRafase.getInventario().getExistencias_array().get(i)%></td>
                                    <td><%= inventarioRafase.getInventario().getPrecio_base_array().get(i)%></td>
                                </tr>
                                <% } //end for %>
                                <% } //end for %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <!--Stock-->

            <!--Sucursales-->
            <div class="container-fluid mt-5 py-lg-5" id="sucursales">
                <div class="card">
                    <!-- Card header -->
                    <div class="card-header info-color white-text">Nuestra sede pricipal</div>

                    <!--Card content-->
                    <div class="card-body">
                        <!--Google map-->
                        <div id="map-container-google-2" class="z-depth-1-half map-container" style="height: 500px">
                            <iframe src="https://maps.google.com/maps?q=bogota&t=&z=13&ie=UTF8&iwloc=&output=embed" frameborder="0"
                                    style="border:0" allowfullscreen></iframe>
                        </div>

                        <!--Google Maps-->

                    </div>
                </div>
            </div>
            <!--Sucursales-->


        </main>
        <!--Main layout-->



        <!-- SCRIPTS -->
        <!-- JQuery -->
        <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
        <!-- Bootstrap tooltips -->
        <script type="text/javascript" src="../js/popper.min.js"></script>
        <!-- Bootstrap core JavaScript -->
        <script type="text/javascript" src="../js/bootstrap.min.js"></script>
        <!-- MDB core JavaScript -->
        <script type="text/javascript" src="../js/mdb.min.js"></script>
        <!-- Initializations -->
        <script type="text/javascript">
                // Animations initialization
                new WOW().init();

        </script>

        <!-- Charts -->
        <script>

            $("#proveedores").hide();
            $("#perfil").hide();
            $("#statistics").hide();
            $("#stock").hide();
            $("#sucursales").hide();
            $("#clientes").hide();

            function statistics() {
                if ($("#statistics").is(":hidden")) {
                    $("#clientes").hide();
                    $("#sucursales").hide();
                    $("#proveedores").hide();
                    $("#perfil").hide();
                    $("#stock").hide();
                    $("#statistics").show();
                }
            }

            function perfil() {
                if ($("#perfil").is(":hidden")) {
                    $("#clientes").hide();
                    $("#sucursales").hide();
                    $("#proveedores").hide();
                    $("#statistics").hide();
                    $("#stock").hide();
                    $("#perfil").show();
                }
            }

            function proveedores() {
                if ($("#proveedores").is(":hidden")) {
                    $("#clientes").hide();
                    $("#sucursales").hide();
                    $("#perfil").hide();
                    $("#statistics").hide();
                    $("#stock").hide();
                    $("#proveedores").show();
                }
            }

            function stock() {
                if ($("#stock").is(":hidden")) {
                    $("#clientes").hide();
                    $("#sucursales").hide();
                    $("#perfil").hide();
                    $("#statistics").hide();
                    $("#proveedores").hide();
                    $("#stock").show();
                }
            }
            
            function sucursales() {
                if ($("#sucursales").is(":hidden")) {
                    $("#clientes").hide();
                    $("#perfil").hide();
                    $("#statistics").hide();
                    $("#proveedores").hide();
                    $("#stock").hide();
                    $("#sucursales").show();
                }
            }
            
            function clientes() {
                if ($("#clientes").is(":hidden")) {
                    $("#sucursales").hide();
                    $("#perfil").hide();
                    $("#statistics").hide();
                    $("#proveedores").hide();
                    $("#stock").hide();
                    $("#clientes").show();
                }
            }

            // Line
            var ctx = document.getElementById("myChart").getContext('2d');
            var myChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
                    datasets: [{
                            label: '# of Votes',
                            data: [12, 19, 3, 5, 2, 3],
                            backgroundColor: [
                                'rgba(255, 99, 132, 0.2)',
                                'rgba(54, 162, 235, 0.2)',
                                'rgba(255, 206, 86, 0.2)',
                                'rgba(75, 192, 192, 0.2)',
                                'rgba(153, 102, 255, 0.2)',
                                'rgba(255, 159, 64, 0.2)'
                            ],
                            borderColor: [
                                'rgba(255,99,132,1)',
                                'rgba(54, 162, 235, 1)',
                                'rgba(255, 206, 86, 1)',
                                'rgba(75, 192, 192, 1)',
                                'rgba(153, 102, 255, 1)',
                                'rgba(255, 159, 64, 1)'
                            ],
                            borderWidth: 1
                        }]
                },
                options: {
                    scales: {
                        yAxes: [{
                                ticks: {
                                    beginAtZero: true
                                }
                            }]
                    }
                }
            });

            //pie
            var ctxP = document.getElementById("pieChart").getContext('2d');
            var myPieChart = new Chart(ctxP, {
                type: 'pie',
                data: {
                    labels: ["Red", "Green", "Yellow", "Grey", "Dark Grey"],
                    datasets: [{
                            data: [100, 50, 100, 40, 120],
                            backgroundColor: ["#F7464A", "#46BFBD", "#FDB45C", "#949FB1", "#4D5360"],
                            hoverBackgroundColor: ["#FF5A5E", "#5AD3D1", "#FFC870", "#A8B3C5", "#616774"]
                        }]
                },
                options: {
                    responsive: true
                }
            });


            //line
            var ctxL = document.getElementById("lineChart").getContext('2d');
            var myLineChart = new Chart(ctxL, {
                type: 'line',
                data: {
                    labels: ["January", "February", "March", "April", "May", "June", "July"],
                    datasets: [{
                            label: "My First dataset",
                            backgroundColor: [
                                'rgba(105, 0, 132, .2)',
                            ],
                            borderColor: [
                                'rgba(200, 99, 132, .7)',
                            ],
                            borderWidth: 2,
                            data: [65, 59, 80, 81, 56, 55, 40]
                        },
                        {
                            label: "My Second dataset",
                            backgroundColor: [
                                'rgba(0, 137, 132, .2)',
                            ],
                            borderColor: [
                                'rgba(0, 10, 130, .7)',
                            ],
                            data: [28, 48, 40, 19, 86, 27, 90]
                        }
                    ]
                },
                options: {
                    responsive: true
                }
            });


            //radar
            var ctxR = document.getElementById("radarChart").getContext('2d');
            var myRadarChart = new Chart(ctxR, {
                type: 'radar',
                data: {
                    labels: ["Eating", "Drinking", "Sleeping", "Designing", "Coding", "Cycling", "Running"],
                    datasets: [{
                            label: "My First dataset",
                            data: [65, 59, 90, 81, 56, 55, 40],
                            backgroundColor: [
                                'rgba(105, 0, 132, .2)',
                            ],
                            borderColor: [
                                'rgba(200, 99, 132, .7)',
                            ],
                            borderWidth: 2
                        }, {
                            label: "My Second dataset",
                            data: [28, 48, 40, 19, 96, 27, 100],
                            backgroundColor: [
                                'rgba(0, 250, 220, .2)',
                            ],
                            borderColor: [
                                'rgba(0, 213, 132, .7)',
                            ],
                            borderWidth: 2
                        }]
                },
                options: {
                    responsive: true
                }
            });

            //doughnut
            var ctxD = document.getElementById("doughnutChart").getContext('2d');
            var myLineChart = new Chart(ctxD, {
                type: 'doughnut',
                data: {
                    labels: ["Red", "Green", "Yellow", "Grey", "Dark Grey"],
                    datasets: [{
                            data: [300, 50, 100, 40, 120],
                            backgroundColor: ["#F7464A", "#46BFBD", "#FDB45C", "#949FB1", "#4D5360"],
                            hoverBackgroundColor: ["#FF5A5E", "#5AD3D1", "#FFC870", "#A8B3C5", "#616774"]
                        }]
                },
                options: {
                    responsive: true
                }
            });

        </script>

        <!--Google Maps-->
        <script src="https://maps.google.com/maps/api/js"></script>
        <script>
            // Regular map
            function regular_map() {
                var var_location = new google.maps.LatLng(40.725118, -73.997699);

                var var_mapoptions = {
                    center: var_location,
                    zoom: 14
                };

                var var_map = new google.maps.Map(document.getElementById("map-container"),
                        var_mapoptions);

                var var_marker = new google.maps.Marker({
                    position: var_location,
                    map: var_map,
                    title: "New York"
                });
            }

            new Chart(document.getElementById("horizontalBar"), {
                "type": "horizontalBar",
                "data": {
                    "labels": ["Red", "Orange", "Yellow", "Green", "Blue", "Purple", "Grey"],
                    "datasets": [{
                            "label": "My First Dataset",
                            "data": [22, 33, 55, 12, 86, 80, 14],
                            "fill": false,
                            "backgroundColor": ["rgba(255, 99, 132, 0.2)", "rgba(255, 159, 64, 0.2)",
                                "rgba(255, 205, 86, 0.2)", "rgba(75, 192, 192, 0.2)",
                                "rgba(54, 162, 235, 0.2)",
                                "rgba(153, 102, 255, 0.2)", "rgba(201, 203, 207, 0.2)"
                            ],
                            "borderColor": ["rgb(255, 99, 132)", "rgb(255, 159, 64)", "rgb(255, 205, 86)",
                                "rgb(75, 192, 192)", "rgb(54, 162, 235)", "rgb(153, 102, 255)",
                                "rgb(201, 203, 207)"
                            ],
                            "borderWidth": 1
                        }]
                },
                "options": {
                    "scales": {
                        "xAxes": [{
                                "ticks": {
                                    "beginAtZero": true
                                }
                            }]
                    }
                }
            });

        </script>
    </body>

</html>
