<%-- 
    Document   : registro_user
    Created on : 25/06/2020, 02:10:22 PM
    Author     : david
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Registro de clientes</title>
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
        <!-- Custom styles for this template -->
        <link rel="stylesheet" href="../css/custom/registro_user.css">
        <link rel="stylesheet" href="../css/custom/checkPassword.css">
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
        <!-- Custom Javacript-->
        <script type="text/javascript" src="../js/custom/checkPassword.js"></script>
        <script type="text/javascript" src="../js/custom/viewPassword.js"></script>
        <script type="text/javascript" src="../js/custom/validatePassword.js"></script>
    </head>
    <body>
        <div class="container register">
            <div class="row">
                <div class="col-md-3 register-left">
                    <img src="../img/Logo_blanco.png" alt=""/>
                    <h3>Bienvenido</h3>
                    <p class="texto_img">¡Te toma 30 segundos registrarse y empezar a comprar!</p>
                    <p class="texto_btn">¿Ya estas registrado?</p>
                    <a class="btn"  href="sign.jsp" role="button">Ir a Iniciar Sesión</a>
                </div>
                <div class="col-md-9 register-right">
                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                            <h3 class="register-heading">¡Registrate como cliente!</h3>
                            <form id="registro_user" class="row register-form" action="../registro_user" method="post" onsubmit="return validatePassword();">
                                <div class="col-md-6">
                                    <div class="md-form md-bg">
                                        <input type="text" class="form-control white" name="nombre" id="nombre" required/>
                                        <label for="nombre">Nombre(s)</label>
                                    </div>
                                    <div class="md-form md-bg">
                                        <input type="text" class="form-control white" name="apellido" id="apellido" required/>
                                        <label for="apellido">Apellido(s)</label>
                                    </div>
                                    <div class="input-group">
                                        <div class="md-form md-bg input-group-prepend mt-0 mb-0">
                                            <input type="text" class="form-control white mb-0" name="cedula" id="cedula" required/>
                                            <label for="cedula">Cedula</label>
                                        </div>
                                        <select class="browser-default custom-select custom-select-lg input-group-prepend text-muted font-weight-lighter white" name="tipo_id" id="tipo_id" required>
                                            <option class="text-muted font-weight-lighter" value="" hidden disabled selected>Tipo ID</option>
                                            <option class="text-muted font-weight-lighter" value="CC" required>Cedula</option>
                                            <option class="text-muted font-weight-lighter" value="CE" required>Cedula de extranjeria</option>
                                        </select>
                                    </div>
                                    
                                    <div class="md-form md-bg mb-0">
                                        <input type="date" class="form-control text-muted white mb-0" max="2002-01-01" value="" name="fecha_nacimiento" id="fecha_nacimiento" required/>
                                        <small for="fecha_nacimiento" class="text-muted">Fecha de nacimiento</small>
                                    </div>
                                    <div class="form-group">
                                        <div class="custom-control custom-radio custom-control-inline"> 
                                            <input type="radio" class="custom-control-input" name="gender" value="M" id="gender1" required>
                                            <label class="custom-control-label" for="gender1"> Hombre </label>
                                        </div>
                                        <div class="custom-control custom-radio custom-control-inline"> 
                                            <input type="radio" class="custom-control-input" name="gender" value="F" id="gender2" required>
                                            <label class="custom-control-label" for="gender2"> Mujer </label>
                                        </div>
                                        <div class="custom-control custom-radio custom-control-inline"> 
                                            <input type="radio" class="custom-control-input" name="gender" value="O" id="gender3" required>
                                            <label class="custom-control-label" for="gender3"> Otro </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="md-form md-bg">
                                        <input type="email" class="form-control white" value="" name="email" id="email" required/>
                                        <label for="email">Correo Electronico</label>
                                    </div>
                                    <div class="md-form md-bg">
                                        <input type="text" class="form-control white" value="" name="username" id="username" required/>
                                        <label for="username">Nombre de usuario</label>
                                    </div>
                                    <div class="md-form md-bg mb-0">
                                        <input type="password" class="form-control white mb-0" value="" name="password" id="password" autocomplete="new-password" required/>
                                        <label for="password">Contraseña</label>
                                        <div id="show_password" class="fa fa-eye-slash password-icon"></div>
                                        <div id="strengthMessage"></div>
                                    </div>
                                    <div class="md-form md-bg">
                                        <input type="password" class="form-control white mb-0" value="" name="confirme_password" id="confirme_password" autocomplete="new-password" required/>
                                        <label for="confirme_password">Confirmar Contraseña</label>
                                        <div id="show_confirme_password" class="fa fa-eye-slash password-icon"></div>
                                    </div>
                                    <button class="btn btn-outline-success my-2 my-sm-0 btnRegister" type="submit">Registrarse</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--Scripts de respuesta del servlet-->
        <%
            try {
                //Si e = 1, el username ya existe
                if (request.getParameter("e").equals("1")) {
        %>
        <script  type = "text/javascript">
            alertify.alert("Error", "El nombre de usuario escrito ya esta en uso, intente con otro nombre", function () {
                alertify.message('Intente con otro nombre');

            });
        </script>
        <%
                }//End if e == 1
            } catch (Exception e) {
            }
        %>
    </body>
</html>
