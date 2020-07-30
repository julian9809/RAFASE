<%-- 
    Document   : index
    Created on : 8/07/2020, 08:07:27 PM
    Author     : david
--%>

<%@page import="modelo.Ciudad"%>
<%@page import="control.DAOFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%> 
<!DOCTYPE html>
<%
    HttpSession usuarios = request.getSession();
    
    if(usuarios.getAttribute("usuario")==null){
        usuarios.setAttribute("usuario", "visitante");
        usuarios.setAttribute("contraseña", "abc123");
    }else{
        usuarios.getAttribute("usuario");
        usuarios.getAttribute("contraseña");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>RAFASE</title>
        <!-- RAFASE icon -->
        <link rel="icon" href="img/Logo.png" type="image/png">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
        <!-- Google Fonts Roboto -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
        <!-- Material Design Bootstrap -->
        <link rel="stylesheet" href="css/mdb/mdb.min.css">
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
        <link rel="stylesheet" href="css/custom/cover.css">
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
    <body class="text-center">
        <div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
            <header class="masthead mb-auto">
                <div class="inner">
                    <img id="logo" class="masthead-brand" src="img/rafase.gif">
                    <nav class="nav nav-masthead justify-content-center">
                        <a class="nav-link" href="templates/index.jsp">Quienes Somos</a>
                        <a class="nav-link" href="#">Contacto</a>
                    </nav>
                </div>
            </header>
            <%
                DAOFacade facade = new DAOFacade();
                Ciudad ciudad = facade.getCiudad();
                try {
                    facade.buscarCiudades(usuarios.getAttribute("usuario").toString(),
                            usuarios.getAttribute("contraseña").toString());
                } catch (Exception e1) {
                    %>
                    <script type="text/javascript">
                        alertify.alert("Error","<%= "Error --> " + e1 + e1.getMessage() %>", function(){
                            alertify.message('OK');
                        });
                    </script>
                    <%
                }//End catch
            %>
            <main role="main" class="inner cover">
                <h1 class="cover-heading">RAFASE</h1>
                <p class="lead inicio">Somos una tienda virtual con varias sucursales fisicas en distintas ciudades del pais, escoge tu ciudad eh inicia a comprar de forma rapida y sencilla.</p>
                <form class="lead btn-group" action="Ciudad" method="post">
                    <select class="btn btn-lg btn-light" name="ciudad" id="ciudad">
                        <option selected hidden disabled>Escoge tu ciudad</option>
                        <%  
                            for (int i = 0; i < ciudad.getId_ciudad_array().size(); i++) {
                        %>
                        <option value="<%= ciudad.getNombre_array().get(i) %>"><%= ciudad.getNombre_array().get(i) %></option>
                        <%}//End for ciudad%>
                    </select>
                    <button class="btn btn-lg btn-success" type="summit">Continuar</button>
                </form>
            </main>
            <!--------------------------------FOOTER--------------------------------->
            <footer class="container footer mastfoot mt-auto">
                <div class="inner">
                    <p>&copy; 2020 RAFASE, Inc. &middot; <a href="#">Privacidad</a> &middot; <a href="#">Términos y Condiciones</a></p>
                </div>
            </footer>
        </div>
    </body>
</html>
