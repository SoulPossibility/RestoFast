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
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form name="FormModDelPedido" action="ModificarDetallePedido" method="post">       
            <table class="table table-dark">
                <thead>
                    <tr>
                        <th><h2> Modificar Detalle Pedido</h2></th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="d-flex">
                        <th class="col-1">Código Pedido:</th>
                        <td><input type="text" name="pedido_id"/></td>                       
                    </tr>
                    <tr class="d-flex">
                        <th class="col-1">Código Producto:</th>
                        <td><input type="text" name="producto_id"/></td>
                    </tr>
                    <tr class="d-flex">
                        <th class="col-1">Cantidad:</th>
                        <td><input type="text" name="cantidad"/></td>
                    </tr>
                    <tr class="d-flex">
                        <th class="col-1">Valor:</th>
                        <td><input type="text" name="valor"/></td>
                    </tr>
                    <tr class="d-flex">
                        <th class="col-1">Descripción:</th>
                        <td><input type="text" name="descripcion"/></td>
                    </tr>
                    <tr class="d-flex">
                        <td class="col-1"><input type="submit" value="Cancelar"/></td>
                        <td><input type="submit" value="Modificar"/></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
