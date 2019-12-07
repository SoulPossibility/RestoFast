<%-- 
    Document   : menuBodeguero
    Created on : 19-11-2019, 11:27:47
    Author     : BlueOcean
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <jsp:include page="nav.jsp"/>

        <div class="container">
            <div class="card p-4 m-4 bg-light text-center">
                <h2>Menú de bodeguero</h2>
                <hr>
                <div class="card-body text-center">
                    <p>Seleccione una opción:</p>
                    <a class="btn btn-info opcionAdmin" href="ListarPedido">Listar Pedidos</a>
                    <br/>
                    <br/>
                    <a class="btn btn-info opcionAdmin" href="ListarProducto">Listar Productos</a>
                </div>
            </div>
        </div>

        <style>
            .opcionAdmin{
                width: 250px;
                font-size: 1.1rem !important;
            }

            body, h2{
                color: black;
            }
        </style>
    </body>
</html>