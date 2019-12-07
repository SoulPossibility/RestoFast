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
        <title>Listado de Pedidos</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
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
    <body>
        
        <jsp:include page="nav.jsp"/>
        
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
                    <th scope="col">Detalle</th>
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
                        <td><a href="ListarDetallePedidoID?id=${pedi.id}">Detalle</a></td>
                        <td><a href="ObtenerPedido?id=${pedi.id}">Modificar</a></td>
                        <td><a href="EliminarPedido?id=${pedi.id}">Eliminar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>   
</body>
</html>
