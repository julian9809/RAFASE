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
        <link rel="icon" href="../img/Logo.png" type="image/png">
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="../css/bootstrap/bootstrap.min.css">
        <link rel="stylesheet" href="../css/bootstrap/bootstrap-theme.min.css">
        <!-- Custom styles for this template -->
        <link rel="stylesheet" href="../css/custom/registro_user.css">
        <!-- Customs fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Averia+Libre&display=swap" rel="stylesheet">
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
                            <form class="row register-form" action="../registro_user" method="post">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Nombre(s) *" value="" name="nombre" id="nombre"/>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Apellido(s) *" value="" name="apellido" id="apellido"/>
                                    </div>
                                    <div class="form-group form-check-inline">
                                        <input type="text" class="form-control" placeholder="Cedula *" value="" name="cedula" id="cedula"/>
                                        <select class="form-control" name="tipo_cedula" id="tipo_cedula">
                                            <option selected>Tipo de documento...</option>
                                            <option>Cedula</option>
                                            <option>Tarjeta de identidad</option>
                                            <option>Cedula de extranjeria</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <input type="email" class="form-control" placeholder="Correo Electronico *" value="" name="email" id="email"/>
                                    </div>                                    
                                    <div class="form-group">
                                        <div class="maxl">
                                            <label class="radio inline"> 
                                                <input type="radio" name="gender" value="M" checked id="gender">
                                                <span> Hombre </span> 
                                            </label>
                                            <label class="radio inline"> 
                                                <input type="radio" name="gender" value="F" id="gender">
                                                <span> Mujer </span> 
                                            </label>
                                            <label class="radio inline"> 
                                                <input type="radio" name="gender" value="O" id="gender">
                                                <span> Otro </span> 
                                            </label>    
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Nombre de usuario *" value="" name="nickname" id="nikename"/>
                                    </div>
                                    <div class="form-group">
                                        <input type="date" class="form-control" max="2002-01-01" placeholder="Fecha de nacimiento *" value="" name="fecha_nacimiento" id="fecha_nacimiento"/>
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control" placeholder="Contraseña *" value="" name="password" id="password"/>
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control"  placeholder="Confirmar Contraseña *" value="" name="confirme_password" id="confirme_password"/>
                                    </div>
                                    <button class="btn btn-outline-success my-2 my-sm-0 btnRegister" type="submit">Registrarse</button>
                                </div>
                            </form>
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
