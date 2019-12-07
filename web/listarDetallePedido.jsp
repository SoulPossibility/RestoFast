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
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Detalle Pedido</title>

        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Nothing+You+Could+Do" rel="stylesheet">

        <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">
        <link rel="stylesheet" href="css/aos.css">
        <link rel="stylesheet" href="css/ionicons.min.css">

        <link rel="stylesheet" href="css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="css/jquery.timepicker.css">

        <link rel="stylesheet" href="css/flaticon.css">
        <link rel="stylesheet" href="css/icomoon.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    </head>
</head>
<body>
    
    <jsp:include page="nav.jsp"/>
    
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
                    <td><a href="ObtenerDetallePedido?pedido_id=${delped.pedido_id}&producto_id=${delped.producto_id}">Modificar</a></td>
                    <td><a href="EliminarDetallePedido?pedido_id=${delped.pedido_id}&producto_id=${delped.producto_id}">Eliminar</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
