<%-- 
    Document   : clienteBievenida
    Created on : 12-10-2019, 23:29:54
    Author     : BlueOcean
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
    <body style=" background-image: url('images/about.jpg'); background-size: cover;">
        <div class="container">
            <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
            <div class="card">
                <div class="card-body">
                    <div class="text-center">
                        <h1>Información</h1>
                        <hr>
                        <div class="alert-warning">
                            <c:choose>
                                <c:when test="${mensajeError != null}">
                                    <p>${mensajeError}</p>
                                    <i>Se debe iniciar una atención con el cliente desde el totem para habilitar esta mesa, gracias por su comprensión</i>
                                </c:when>
                            </c:choose>
                        </div>
                        <br/>

                        Pulsar boton para continuar
                        <form method="get" action="ClientePantallaInicio">
                            <button class="btn btn-warning" type="submit">Continuar con la atención</button>
                        </form>
                        <a href="Login">Cerrar</a>
                    </div>
                </div>
            </div>
        </div>

        <script>
            setTimeout(function () {
                location.reload();
            }, 10000);
        </script>
    </body>
</html>
