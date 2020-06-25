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
        <title>Registro de clientes</title>
        <link rel="icon" href="../img/Logo.png" type="image/png">
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="../css/bootstrap/bootstrap.min.css">
        <link rel="stylesheet" href="../css/bootstrap/bootstrap-theme.min.css">
        <!-- Custom styles for this template -->
        <link rel="stylesheet" href="../css/custom/registro_user.css">
    </head>
    <body>
        <div class="container register">
            <div class="row">
                <div class="col-md-3 register-left">
                    <img src="../img/LogoCheems.png" alt=""/>
                    <h3>Bienvenido</h3>
                    <p class="texto_img">¡Te toma 30 segundos registrarse y empezar a comprar!</p>
                    <p class="texto_btn">¿Ya estas registrado?</p>
                    <a class="btn"  href="sign.jsp" role="button">Ir a Iniciar Sesión</a>
                </div>
                <div class="col-md-9 register-right">
                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                            <h3 class="register-heading">¡Registrate como cliente!</h3>
                            <div class="row register-form">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Nombre(s) *" value="" />
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Apellido(s) *" value="" />
                                    </div>
                                    <div class="form-group">
                                        <input type="text" name="Cedula" class="form-control" placeholder="Cedula *" value="" />
                                    </div>
                                    <div class="form-group">
                                        <input type="email" class="form-control" placeholder="Correo Electronico *" value="" />
                                    </div>                                    
                                    <div class="form-group">
                                        <div class="maxl">
                                            <label class="radio inline"> 
                                                <input type="radio" name="gender" value="hombre" checked>
                                                <span> Hombre </span> 
                                            </label>
                                            <label class="radio inline"> 
                                                <input type="radio" name="gender" value="mujer">
                                                <span> Mujer </span> 
                                            </label>
                                            <label class="radio inline"> 
                                                <input type="radio" name="gender" value="otro">
                                                <span> Otro </span> 
                                            </label>    
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Nombre de usuario *" value="" />
                                    </div>
                                    <div class="form-group">
                                        <input type="date" class="form-control" placeholder="Fecha de nacimiento *" value="" />
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control" placeholder="Contraseña *" value="" />
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control"  placeholder="Confirmar Contraseña *" value="" />
                                    </div>
                                    <input type="submit" class="btnRegister"  value="Registrarse"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-------------------------------Scripts--------------------------------->
        <script src="../js/jquery.js"></script>
        <script src="../js/bootstrap.min.js"></script>
    </body>
</html>
