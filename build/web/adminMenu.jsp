<%-- 
    Document   : adminMenu
    Created on : 10-11-2019, 3:00:03
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
            <div class="card p-4 m-4 bg-light">
                <div class="card-body text-center">
                    <h2>Seleccionar configuración de mesas</h2>
                    <br/>
                    <a class="btn btn-info opcionAdmin" href="EstadoMesa">Ver Estado de Mesas</a>
                    <br/><br/>
                    <a class="btn btn-info opcionAdmin" href="ClienteConfigurarMesa">Configurar Número de Mesa</a>
                    <br/><br/>
                    <a class="btn btn-info opcionAdmin" href="ClientePantallaInicio">Iniciar Atención de Mesa</a>
                    <br/><br/>
                    <a class="btn btn-info opcionAdmin" href="adminReportes.jsp">Ver Datos Estadísticos</a>
                    <br/><br/>
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
