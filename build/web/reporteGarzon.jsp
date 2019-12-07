<%-- 
    Document   : reporteGarzon
    Created on : 19-11-2019, 6:09:34
    Author     : BlueOcean
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>

        <script src="js/graphs/Chart.bundle.js" type="text/javascript"></script>
        <script src="js/graphs/utils.js" type="text/javascript"></script>

        <link rel="stylesheet" href="css/style.css">

        <title>JSP Page</title>
        <style>
            canvas{
                -moz-user-select: none;
                -webkit-user-select: none;
                -ms-user-select: none;
            }
        </style>
    </head>
    <body>
    <body style="background-image: url('images/gallery-3.jpg');">
        <jsp:include page="nav.jsp"/>
        <br/><br/>
        <div class="container">
            <div class="card">
                <div class="card-header">
                    <div class="card-title">
                        RENDIMIENTO DE GARZONES
                    </div>
                </div>
                <div class="card-body p-4 m-4">
                    <div id="container" style="width: 100%;">
                        <div class="alert-primary shadow p-3">
                            Información correspondiente a la cantidad de clientes atendidos según el garzón registrado en el sistema.
                            <br/>
                            Los datos corresponden al año 2019.
                        </div>
                        <br/>
                        <div class="row">
                            <div class="col-8">
                                <div id="canvas-holde" style="width:100%; border: solid;">
                                    <canvas id="chart-area"></canvas>
                                </div>
                            </div>
                            <div class="col-4">

                            </div>
                        </div>


                        <!--TABLA GARZONES-->
                        <div>
                            <table class="table table-striped table-sm" style="font-size: 0.8rem;">
                                <thead class="">
                                <th>Run</th>
                                <th>Nombre</th>
                                <th>Sueldo base</th>
                                <th>Cantidad</th>
                                </thead>
                                <tbody>
                                    <c:set var="totalClientes" scope="application" value="0"></c:set>
                                    <c:forEach items="${graphGarzon}" var="item">
                                        <tr>
                                            <td>${item.funcionario.run}</td>
                                            <td>${item.funcionario.nombres} ${item.funcionario.apellidoPaterno}</td>
                                            <td>${item.funcionario.sueldoBase}</td>
                                            <td>${item.cantidadAnual}</td>
                                            <c:set var="totalClientes" scope="application" value="${totalClientes = totalClientes + item.cantidadAnual}"></c:set>
                                            </tr>
                                    </c:forEach>
                                    <tr>
                                        <td>TOTAL</td><td></td><td></td><td><c:out value="${totalClientes}"></c:out></td>
                                        </tr>
                                    </tbody>
                                </table>
                                <p>La cantidad total de clientes antendidos el año 2019 han sido de: ${totalClientes} personas</p>
                        </div>

                    </div>
                </div>
            </div>
        </div>


                        
        <script>
            var randomScalingFactor = function () {
            return Math.round(Math.random() * 100);
            };
            var config = {
            type: 'pie',
                    data: {
                    datasets: [{
                    data: [
            <c:forEach items="${graphGarzon}" var="item">
                ${item.cantidadAnual},
            </c:forEach>
                    //                                randomScalingFactor(),
                    //                                randomScalingFactor(),
                    //                                randomScalingFactor(),
                    //                                randomScalingFactor(),
                    //                                randomScalingFactor(),
                    ],
                            backgroundColor: [
                                    window.chartColors.red,
                                    window.chartColors.orange,
                                    window.chartColors.yellow,
                                    window.chartColors.green,
                                    window.chartColors.blue,
                            ],
                            label: 'Dataset 1'
                    }],
                            labels: [
            <c:forEach items="${graphGarzon}" var="item">
                            '${item.funcionario.nombres} ${item.funcionario.apellidoPaterno}',
            </c:forEach>
                                                //                        'Red',
                                                //                        'Orange',
                                                //                        'Yellow',
                                                //                        'Green',
                                                //                        'Blue'
                                                ]
                                        },
                                        options: {
                                        responsive: true
                                        }
                                };
                                window.onload = function () {
                                var ctx = document.getElementById('chart-area').getContext('2d');
                                window.myPie = new Chart(ctx, config);
                                };
                                document.getElementById('randomizeData').addEventListener('click', function () {
                                config.data.datasets.forEach(function (dataset) {
                                dataset.data = dataset.data.map(function () {
                                return randomScalingFactor();
                                });
                                });
                                window.myPie.update();
                                });
                                var colorNames = Object.keys(window.chartColors);
                                document.getElementById('addDataset').addEventListener('click', function () {
                                var newDataset = {
                                backgroundColor: [],
                                        data: [],
                                        label: 'New dataset ' + config.data.datasets.length,
                                };
                                for (var index = 0; index < config.data.labels.length; ++index) {
                                newDataset.data.push(randomScalingFactor());
                                var colorName = colorNames[index % colorNames.length];
                                var newColor = window.chartColors[colorName];
                                newDataset.backgroundColor.push(newColor);
                                }

                                config.data.datasets.push(newDataset);
                                window.myPie.update();
                                });
                                document.getElementById('removeDataset').addEventListener('click', function () {
                                config.data.datasets.splice(0, 1);
                                window.myPie.update();
                                });
        </script>
    </body>
</html>
