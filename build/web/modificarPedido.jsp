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
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form name="FormModPedido" action="ModificarPedido" method="post">
            <table class="table table-dark">
                <thead>
                    <tr>
                        <th><h2>Modificar Pedido</h2></th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="d-flex">
                        <th class="col-1">Código Pedido:</th>
                        <td><input type="text" name="pedido_id"/></td>                       
                    </tr>
                    <tr class="d-flex">
                        <th class="col-1">Fecha Solicitud:</th>
                        <td><input type="text" name="estado"/></td>
                    </tr>
                    <tr class="d-flex">
                        <th class="col-1">Estado:</th>
                        <td><input type="text" name="cantidad"/></td>
                    </tr>
                    <tr class="d-flex">
                        <th class="col-1">Nombre Solicitante:</th>
                        <td><input type="text" name="usuario_nombre_usuario"/></td>
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
