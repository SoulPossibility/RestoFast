<%-- 
    Document   : adminReportes
    Created on : 07-11-2019, 1:54:21
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
                    <h2 class="text-left">Reportes</h2>
                    <hr>
                    <div class="row">
                        <div class="col-4">
                            <img src="images/dataAnalysis.png" alt="analisis" width="270px" height="170px">
                        </div>
                        <div class="col-4">
                            <form method='POST' action='ReporteMenus'>
                                <p class="m-4 text-left" href="ReporteMenus">Seleccionar fecha:</p>
                                <input id="btnReporte" class="" type="date" name="fechaReporteMenu">
                                <c:if test="${msgError != null}">
                                    <p style="color: red;">${msgError}</p>
                                </c:if>
                                <button id="btnReporte" class="btn btn-info">Consultar Menus</button>
                            </form>

                            <a id="btnReporte" class="btn btn-info m-4" href="ReportePedidos">Consultar Pedidos</a>
                            <br/>
                            <button id="btnReporte" class="btn btn-info">Consultar Finanzas</button>
                            <br/>
                            <a id="btnReporte" class="btn btn-info m-4" href="ReporteGarzon">Rendimiento garzones 2019</a>
                            <br/><br/>

                        </div>
                        <div class="col-4">
                            <br/><br/>
                            <br/>
                            <p>*Información sobre el consumo diario de la oferta de menus </p>
                            <p>*Información de los pedidos solicitados y aprobados desde bodega</p>
                            <p>*Datos correspondientes al movimiento de caja (No disponible)</p>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <style>
            h2 {
                color: black;
            }

            #btnReporte{
                width: 250px;
            }

        </style>
    </body>
</html>
