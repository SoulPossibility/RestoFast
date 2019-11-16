<%-- 
    Document   : clienteConfigurarMesa
    Created on : 10-11-2019, 2:52:28
    Author     : BlueOcean
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

    </head>
    <body>
        <jsp:include page="nav.jsp"/>

        <div class="container">
            <div class="card">
                <div class="card-header p-4">
                    <h1>Asignación de Mesa</h1>
                    <p>Debe seleccionar una mesa disponible para que esta pueda empezar a operar en el actual dispositivo</p>
                </div>
                <div class="card-body p-4">
                    <div class="offset-md-3 col-md-6 text-center">
                        <div class="list-group">
                            <a id="linkHeader" href="#" class="list-group-item bg-dark">Seleccione una mesa</a>
                            <c:forEach items="${mesas}" var="mesa">
                                <a href="ClienteConfigurarMesa?EstablecerMesa=${mesa.numero}" class="list-group-item">Mesa ${mesa.numero}</a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <div class="card-footer">
                    <ul>
                        <li>Se crearà un archivo en un directorio del equipo que contiene el nùmero seleccionado en la ruta "home.user/NombreDeUsuario/numeroMesaRestoFast.txt"</li>
                        <li>Realizado el paso anterior se podrà acceder a la interfaz de selección de menús para los clientes.</li>
                    </ul>

                </div>
            </div>
        </div>

        <c:if test="${msgInfo != null}">
            <!-- Modal -->
            <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-body text-center">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <p>Èxito</p>
                            <p>${msgInfo}</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                            <!--                            <button type="button" class="btn btn-primary">Aceptar</button>-->
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
    </body>
    <script>
        $("#exampleModalCenter").modal();
    </script>



    <style>
        a, .list-group-item{
            font-size: 2.0rem;
        }

        body{
            background: url(images/fondo_restaurante.png) no-repeat fixed;
        }

        #linkHeader{
            color: white;
            hover: false;
            cursor: default;
        }
    </style>
</html>
