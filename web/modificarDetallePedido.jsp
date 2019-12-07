<%-- 
    Document   : newjspmodificarDetallePedido
    Created on : 10-10-2019, 16:00:20
    Author     : femxn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Modificar Detalle Pedido</title>

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
        
        <form name="FormModDelPedido" action="ModificarDetallePedido" method="post">   
            <input type="hidden" name="pedido_id" value="${detallePedido.pedido_id}"/>
            <input type="hidden" name="producto_id" value="${detallePedido.producto_id}"/>
            <table class="table table-dark">
                <thead>
                    <tr>
                        <th><h2> Modificar Detalle Pedido</h2></th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="d-flex">
                        <th class="col-1">Código Pedido:</th>
                        <td><input type="text" name="pedido_id" disabled value="${detallePedido.pedido_id}"/></td>                       
                    </tr>
                    <tr class="d-flex">
                        <th class="col-1">Código Producto:</th>
                        <td><input type="text" name="producto_id" disabled value="${detallePedido.producto_id}"/></td>
                    </tr>
                    <tr class="d-flex">
                        <th class="col-1">Cantidad:</th>
                        <td><input type="text" name="cantidad" value="${detallePedido.cantidad}"/></td>
                    </tr>
                    <tr class="d-flex">
                        <th class="col-1">Valor:</th>
                        <td><input type="text" name="valor" disabled value="${detallePedido.valor}"/></td>
                    </tr>
                    <tr class="d-flex">
                        <th class="col-1">Descripción:</th>
                        <td><input type="text" name="descripcion" disabled value="${detallePedido.descripcion}"/></td>
                    </tr>
                    <tr class="d-flex">
                        <td class="col-1"><input type="submit" value="Cancelar" class="btn btn-secondary"/></td>
                        <td><input type="submit" value="Modificar" onclick="ValidarForm()" class="btn btn-primary"/></td>
                    </tr>
                </tbody>
            </table>
        </form>
        <script>
            function ValidarForm() {

                var txtCantidad = document.forms["FormModDelPedido"]["cantidad"].value;
                if (txtCantidad <= 0 || isNaN(txtCantidad)) {
                    alert('ERROR AL INGRESAR CANTIDAD');
                    return false;
                }                
                
                var txtCantidadVacio = document.getElementById("cantidad").value;
                if (txtCantidadVacio === null || txtCantidadVacio.length === 0 || /^\s+$/.test(txtCantidadVacio)) {
                    return false;
                }
            }
        </script>
    </body>
</html>
