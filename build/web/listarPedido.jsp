<%-- 
    Document   : listarPedido
    Created on : 09-10-2019, 16:05:35
    Author     : femxn
--%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Pedido"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Pedidos</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1></h1>
        <div class="container">
            <tr><h1><div class="text-center">Listado de Pedido registrados</div></h1></tr>
        <table class="table table-dark">
            <thead>                          
                <tr>
                    <th scope="col">Código Pedido</th>
                    <th scope="col">Fecha Solicitud</th>
                    <th scope="col">Estado</th>
                    <th scope="col">Nombre Funcionario</th>
                    <th scope="col">Modificar</th>
                    <th scope="col">Eliminar</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${pedido}" var="pedi">
                    <tr>
                        <th scope="row">${pedi.id}</th>
                        <td>${pedi.fecha_solicitud}</td>
                        <td>${pedi.estado} </td>
                        <td>${pedi.usuario_nombre_usuario}</td>
                        <td><a href="modificarPedido.jsp">Modificar</a></td>
                        <td><a href="EliminarPedido?id=${pedi.id}">Eliminar</a></td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <script type="text/javascript" src="js/materialize.min.js"></script>
</body>
</html>
