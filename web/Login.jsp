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
    <body>
        <br>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    </br>
                    </br>
                    </br>
                    </br>
                    </br>
                    <div class="card text-center p-4">
                        <h4>INICIAR SESION</h4>
                        <br/>
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
                                </br>
                                </br>
                                <button id="btnAceptar" class="btn btn-info" name="bt" value="iniciar" type="submit">
                                    Aceptar
                                </button>
                            </div>
                        </form>
                        <br/>
                        <c:if test="${msg != null}">
                            <p id="msgError" class="alert-warning">${msg}</p>
                        </c:if>
                    </div>
                </div>

            </div>
            </br>
            </br>
            </br>
            </br>
            </br>

            <div class="card-footer">
                <div class="d-flex justify-content-center links">
                    ¿No Tienes Una Cuenta?<a href="#">Sign Up</a>
                </div>
                <div class="d-flex justify-content-center">
                    <a href="#">¿Olvidaste tú Contraseña ?</a>
                </div>
            </div>
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
        </style>
    </body>
</html>
