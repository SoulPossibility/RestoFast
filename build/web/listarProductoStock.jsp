<%-- 
    Document   : listarProductoStock
    Created on : 16-10-2019, 19:18:23
    Author     : femxn
--%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Producto"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Producto</title>

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
            <tr><h1><div class="text-center">Listado de Producto Faltante</div></h1></tr>
        <table class="table table-dark">
            <thead>                          
                <tr>
                    <th scope="col">Código Producto</th>
                    <th scope="col">Nombre Producto</th>
                    <th scope="col">Tipo</th>
                    <th scope="col">Código Proveedor</th>
                    <th scope="col">Cantidad</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listaProdStocks}" var="prodStock">
                    <tr>
                        <th scope="row">${prodStock.producto.id}</th>
                        <td>${prodStock.producto.nombre}</td>
                        <td>${prodStock.producto.tipo} </td>
                        <td>${prodStock.producto.proveedor_id}</td>
                        <td>${prodStock.cantidad}</td>                         
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <script type="text/javascript" src="js/materialize.min.js"></script>
</html>
