<%-- 
    Document   : listarProducto
    Created on : 15-10-2019, 19:12:43
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
        
        <form action="ListarProductoStock" method="post" onsubmit="Validar(event)" id="form">
            <h1></h1>
            <div class="container">
                <tr><h1><div class="text-center">Listado de Producto</div></h1></tr>
                <table class="table table-dark">
                    <thead>                          
                        <tr>
                            <th scope="col">Código Producto</th>
                            <th scope="col">Nombre Producto</th>
                            <th scope="col">Tipo</th>
                            <th scope="col">Fecha Elaboración</th>
                            <th scope="col">Fecha Vencimiento</th>
                            <th scope="col">Precio</th>
                            <th scope="col">Stock</th>
                            <th scope="col">Código Proveedor</th>
                            <th scope="col">Seleccionar</th>
                            <th scope="col">Cantidad</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${producto}" var="prod">
                            <tr>
                                <th scope="row">${prod.id}</th>
                                <td>${prod.nombre}</td>
                                <td>${prod.tipo} </td>
                                <td>${prod.fecha_elaboracion}</td>
                                <td>${prod.fecha_vencimiento}</td>
                                <td>${prod.precio}</td>
                                <td>${prod.stock}</td>
                                <td>${prod.proveedor_id}</td>
                                <td><input type="checkbox" id="myCheck" name="producto" value="${prod.id}" onClick="enableCant(${prod.id})"/></td>    
                                <td><input type="number" name="cantidad" disabled id="cant-${prod.id}" class="cantidad"/></td>   
                            </tr>
                        </c:forEach>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="8"></td>
                            <td><input type="submit" value="Agregar" class="btn btn-primary"/></td>
                        </tr>
                    </tfoot>
                </table>
            </div>
        </form>
        <script>
            function enableCant(id) {

                var input = document.getElementById("cant-" + id)
                input.disabled = !input.disabled;
                input.value = "";

            }

            function Validar(e) {
                e.preventDefault();
                var inputs = document.getElementsByClassName("cantidad");
                var count = 0;

                for (i = 0; i < inputs.length; i++) {
                    if (!inputs[i].disabled && inputs[i].value == "")
                    {
                        alert('ERROR TIENE QUE INGRESAR CANTIDAD');
                        return false;
                    }
                    if (inputs[i].disabled) {
                        count++;
                    }

                    console.log(inputs[i].value)
                }
                if (count == inputs.length) {
                    alert('ERROR NO A SELECIONADO NINGÚN PRODUCTO');
                    return false;
                }
                
                document.getElementById('form').submit();
                
            }
        </script>
    </body>
</html>
