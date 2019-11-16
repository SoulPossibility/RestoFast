<%-- 
    Document   : listarDetallePedido
    Created on : 01-10-2019, 18:55:49
    Author     : femxn
--%>

<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.DetallePedido"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Detalle Pedido</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
</head>
<body>
    <div class="container">
        <tr><h1><div class="text-center">Listado de Detalles Pedido registrados</div></h1></tr>
    <table class="table table-dark">
        <thead>                          
            <tr>
                <th scope="col">Código Pedido</th>
                <th scope="col">Código Producto</th>
                <th scope="col">Cantidad</th>
                <th scope="col">Valor</th>
                <th scope="col">Descripción</th>
                <th scope="col">Modificar</th>
                <th scope="col">Eliminar</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${detallePedido}" var="delped">
                <tr>
                    <th scope="row">${delped.pedido_id}</th>
                    <td>${delped.producto_id}</td>
                    <td>${delped.cantidad} </td>
                    <td>${delped.valor}</td>
                    <td>${delped.descripcion}</td>
                    <td><a href="modificarDetallePedido.jsp">Modificar</a></td>
                    <td><a href="EliminarDetallePedido?pedido_id=${delped.pedido_id}">Eliminar</a></td>

                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<script type="text/javascript" src="js/materialize.min.js"></script>
</body>
</html>
