<%-- 
    Document   : listarDetallePedido
    Created on : 30-09-2019, 16:44:03
    Author     : femxn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Pedido</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>             
        <form form name="FormDetalle" action="RegistrarDetallePedido"  method="post">
            <table class="table table-dark">
                <thead>
                    <tr>
                        <th><h2>Registrar Detalle Pedido</h2></th>
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
                        <th class="col-1"><input type="submit" value="Cancelar"/></th>
                        <td><input type="submit" value="Registrar" onclick="ValidarForm()"/></td>
                    </tr>
                </tbody>
            </table>
        </form>
        <script>
            //Validar formulario
            function ValidarForm() {

                var txtPedido = document.forms["FormDetalle"]["pedido_id"].value;
                if (isNaN(txtPedido) || txtPedido <= 0) {
                    alert('ERROR AL INGRESAR CÒDIGO DE PEDIDO');
                    return false;
                }

                var txtProducto = document.forms["FormDetalle"]["producto_id"].value;
                if (isNaN(txtProducto) || txtProducto <= 0) {
                    alert('ERROR AL INGRESAR CÒDIGO DE PRODUCTO');
                    return false;
                }

                var txtCantidad = document.forms["FormDetalle"]["cantidad"].value;
                if (txtCantidad <= 0 || isNaN(txtCantidad)) {
                    alert('ERROR AL INGRESAR CANTIDAD');
                    return false;
                }

                var txtValor = document.forms["FormDetalle"]["valor"].value;
                if (txtValor <= 0 || isNaN(txtValor)) {
                    alert('ERROR AL INGRESAR VALOR');
                    return false;
                }

                var txtDescripcion = document.forms["FormDetalle"]["descripcion"].value;
                if (txtDescripcion.length === 0 || /^\s+$/.test(txtDescripcion)) {
                    alert("ERROR AL INGRESAR DESCRIPCIÓN");
                    return false;
                }
            }
        </script>
    </body>
</html>
