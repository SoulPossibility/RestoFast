<%-- 
    Document   : mesaEstablecer
    Created on : 12-10-2019, 23:12:24
    Author     : BlueOcean
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body style=" background-image: url('images/about.jpg');">
        <div class="container">
            <br/><br/><br/>
            <div class="card">
                <div class="card-header">
                    TOTEM RESTOFAST
                </div>
                <div class="card-body  shadow p-3 mb-5 bg-white rounded">
                    <div class="col-12 text-center" style="font-size: 1.3rem;">
                        <h5 class="card-title" style="color: black; font-size: 1.5rem;">Asignación de mesas</h5>
                        <form method="post" action="MesaEstablecer">
                            <span>Seleccionar Mesa</span><br/>
                            <select class="col-3" name="seleccionMesa">
                                <c:forEach items="${mesas}" var="mesa">
                                    <option value="${mesa.numero}">Número ${mesa.numero}</option>
                                </c:forEach>
                            </select>

                            <br/>
                            <span>Ingresar Cliente</span><br/>
                            <input class="col-3" type="text" name="nombreCliente" placeholder="Nombre de cliente"/>
                            <br/>
                            <span>Seleccionar Garzón</span><br/>
                            <select class="col-3" name="usuarioSeleccionado">
                                <c:forEach items="${usuarios}" var="usuario">
                                    <option value="${usuario.nombre_usuario}">${usuario.funcionario.nombres} ${usuario.funcionario.apellidoPaterno}</option>
                                </c:forEach>
                            </select>
                            <br/>
                            <span>Cantidad de Comensales</span><br/>
                            <select class="col-3" name="cantComensales">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                            </select>
                            <br/><br/>
                            <button type="submit" class="btn btn-primary btn-large col-3">INICIAR ATENCIÓN</button>
                        </form>
                    </div>

                </div>
            </div>            
        </div>
        <style>
            .cbmesatamano{
                font-size: 1.3rem;
            }
        </style>
    </body>
</html>
