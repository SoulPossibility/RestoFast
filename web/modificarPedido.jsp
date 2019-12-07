<%-- 
    Document   : modificarPedido
    Created on : 10-10-2019, 16:00:05
    Author     : femxn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Pedido</title>

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
        
        <form name="FormModPedido" action="ModificarPedido" method="post">
            <input type="hidden" name="pedido_id" value="${pedido.id}"/>
            <table class="table table-dark">
                <thead>
                    <tr>
                        <th><h2>Modificar Pedido</h2></th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="d-flex">
                        <th class="col-1">Código Pedido:</th>
                        <td><input type="text" name="pedido_id" disabled value="${pedido.id}"/></td>                       
                    </tr>
                    <tr class="d-flex">
                        <th class="col-1">Fecha Solicitud:</th>
                        <td><input type="date" name="fecha_solicitud" value="${pedido.fecha_solicitud}"/></td>
                    </tr>
                    <tr class="d-flex">
                        <th class="col-1">Estado:</th>
                        <td><input type="text" name="estado" value="${pedido.estado}"/></td>
                    </tr>
                    <tr class="d-flex">
                        <th class="col-1">Nombre Solicitante:</th>
                        <td><input type="text" name="usuario_nombre_usuario" disabled value="${pedido.usuario_nombre_usuario}"/></td>
                    </tr>
                    <tr class="d-flex">
                        <td class="col-1"><input type="submit" value="Cancelar" class="btn btn-secondary"/></td>
                        <td><input type="submit" value="Modificar" class="btn btn-primary"/></td>
                    </tr>
                </tbody>
            </table>
        </form>
        <script>
            function ValidarForm() {
                
                var txtEstado = document.getElementById("estado").value;
                if (txtEstado === null || txtEstado.length === 0 || /^\s+$/.test(txtEstado)) {
                    return false;
                }
            }
        </script>
    </body>
</html>
