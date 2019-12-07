<%-- 
    Document   : Login
    Created on : 16-10-2019, 20:09:06
    Author     : macev
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <!--        Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>


        <title>Login</title>   

    </head>
    <body style=" background-image: url('images/bg_3.jpg'); background-size: cover;">
        <br>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-8 offset-2">
                    <br/><br/><br/><br/>
                    <div class="card shadow-lg text-center p-4">
                        <br/>
                        <img class="img-fluid p-1" style="width: 10rem; display: block; margin: 0 auto;" src="images/logo_restofast.jpg" alt="logo">
                        <h4 class="tituloResto">RESTAURANTE RESTOFAST</h4>
                         <br/> <br/>
                        <form action="Controller">
                            <div class="form-group">
                                <div class="input-group flex-nowrap">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="addon-wrapping"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></span>
                                    </div>
                                    <input id="txtNombre_U" class="form-control" type="text" name="txtNombre_U" placeholder="Ingrese Nombre Usuario" class="col-6">
                                </div>
                                <div class="input-group flex-nowrap">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="addon-wrapping"><span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>   </span>
                                    </div>
                                    <input id="txtPass" class="form-control" type="password" name="txtPass" placeholder="Ingrese Contraseña">
                                </div>
                                <br/><br/>
                                <button id="btnAceptar" class="btn btn-info btn-block col-8 offset-2" name="bt" value="iniciar" type="submit">
                                    Ingresar
                                </button>
                            </div>
                        </form>
                        <br/>
                        <c:if test="${msg != null}">
                            <p id="msgError" class="alert-warning">${msg}</p>
                        </c:if>

                        <div class="card-footer">
                            <div class="d-flex justify-content-center">
                                <a href="#">¿Olvidaste tú Contraseña ?</a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            </br>
            </br>
            </br>
            </br>
            </br>


        </div>

        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <style>
            #txtPass ,#txtNombre_U, #btnAceptar, #addon-wrapping{
                font-size: 1.5rem;
            }

            #msgError{
                font-size: 1.7rem;
                height: 30px;
            }
            
            .tituloResto{
                color: #138496;
                font-size: 2rem;
            }
        </style>
    </body>
</html>
