<%-- 
    Document   : registrarPedido
    Created on : 03-10-2019, 12:49:27
    Author     : femxn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Pedido</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>        
    </head>
    <body>        
        <form name="FormPedido" action="RegistrarPedido" method="post">
            <table class="table table-dark">
                <thead>
                    <tr>
                        <th><h2>Registrar Pedido</h2></th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="d-flex">
                        <th class="col-1">Código Pedido:</th>
                        <td><input type="text" name="pedido_id"/></td>
                    </tr>
                    <tr class="d-flex">
                        <th class="col-1">Fecha Solicitud:</th>
                        <td><input type="date" name="fecha_solicitud"/></td>
                    </tr>
                    <tr class="d-flex">
                        <th class="col-1">Estado:</th>
                        <td><input type="text" name="estado"/></td>
                    </tr>
                    <tr class="d-flex">
                        <th class="col-1">Nombre de Funcionario:</th>
                        <td><input type="text" name="usuario_nombre_usuario"/></td>
                    </tr>
                    <tr class="d-flex">
                        <th class="col-1"><input type="submit" value="Cancelar"/></th>
                        <td><input type="submit" value="Registrar" onclick="ValidarForm()"/></td>
                    </tr>
                </tbody>
            </table>
        </form>
        <script>
            //Validar formulario
            function ValidarForm() {

                var txtPedido = document.forms["FormPedido"]["pedido_id"].value;
                if (isNaN(txtPedido) || txtPedido <= 0) {
                    alert('ERROR AL INGRESAR CÒDIGO DE PEDIDO');
                    return false;
                }

                var txtFechaSol = document.forms["FormPedido"]["fecha_solicitud"].value;
                if (isNaN(txtFechaSol) || txtFechaSol <= 0) {
                    alert('ERROR AL INGRESAR FECHA');
                    return false;
                }

                var txtEstado = document.forms["FormDetalle"]["estado"].value;
                if (txtEstado.length === 0 || /^\s+$/.test(txtEstado)) {
                    alert("ERROR AL INGRESAR ESTADO");
                    return false;
                }

                var txtNomUser = document.forms["FormDetalle"]["usuario_nombre_usuario"].value;
                if (txtNomUser.length === 0 || /^\s+$/.test(txtNomUser)) {
                    alert("ERROR AL INGRESAR NOMBRE SOLICITANTE");
                    return false;
                }
            }
        </script>

    </body>
</html>
