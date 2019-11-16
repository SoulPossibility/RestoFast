<%-- 
    Document   : reportePedidos
    Created on : 07-11-2019, 2:18:02
    Author     : BlueOcean
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>

        <script src="js/graphs/Chart.bundle.js" type="text/javascript"></script>
        <script src="js/graphs/utils.js" type="text/javascript"></script>

        <link rel="stylesheet" href="css/style.css">
        <style>
            canvas{
                -moz-user-select: none;
                -webkit-user-select: none;
                -ms-user-select: none;
            }
        </style>
    </head>
    <body style="background-image: none;">
        <jsp:include page="nav.jsp"/>
        <div class="container">
            <div style="width:100%;">
                <div class="row">
                    <div class="col-12">
                        <canvas id="canvas"></canvas>
                    </div>
                    <div class="col-6">

                    </div>
                </div>

            </div>
            <br>
            <br>
            <!--            <button id="randomizeData">Randomize Data</button>
                        <button id="addDataset">Add Dataset</button>
                        <button id="removeDataset">Remove Dataset</button>
                        <button id="addData">Add Data</button>
                        <button id="removeData">Remove Data</button>-->

            <div>
                <table class="table table-stripped table-sm">
                    <thead>
                        <tr>
                            <th>Enero</th>
                            <th>Febrero</th>
                            <th>Marzo</th>
                            <th>Abril</th>
                            <th>Mayo</th>
                            <th>Junio</th>
                            <th>Julio</th>
                            <th>Agosto</th>
                            <th>Septiembre</th>
                            <th>Octubre</th>
                            <th>Noviembre</th>
                            <th>Diciembre</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <c:forEach items="${pedidosGraph}" var="columna">
                                <td>${columna.valorMaximo}</td>
                            </c:forEach>
                        </tr>
                        <tr>
                            <c:forEach items="${pedidosGraph}" var="columna">
                                <td>${columna.cantidadMaxima}</td>
                            </c:forEach>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>


        <script>
            function getDaysInMonth(month, year) {
                var date = new Date(Date.UTC(year, month, 1));
                var days = [];
                while (date.getMonth() === month) {
                    days.push(new Date(date));
                    date.setDate(date.getDate() + 1);
                }
                return days;
            }


            //var MONTHS = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
            var MONTHS = getDaysInMonth(10, 2019);
            var config = {
                type: 'line',
                data: {
                    //labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
                    labels: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
                    datasets: [{
                            label: 'Precio de productos',
                            backgroundColor: window.chartColors.red,
                            borderColor: window.chartColors.red,
                            data: [
            <c:forEach items="${pedidosGraph}" var="columna">
                ${columna.valorMaximo},
            </c:forEach>
//                                randomScalingFactor(),
//                                randomScalingFactor(),
//                                randomScalingFactor(),
//                                randomScalingFactor(),
//                                randomScalingFactor(),
//                                randomScalingFactor(),
//                                randomScalingFactor()


                            ],
                            lineTension: 0,
                            fill: false,
                        }
                        //, {
//                            label: 'My Second dataset',
//                            fill: false,
//                            backgroundColor: window.chartColors.blue,
//                            borderColor: window.chartColors.blue,
//                            data: [
//                                randomScalingFactor(),
//                                randomScalingFactor(),
//                                randomScalingFactor(),
//                                randomScalingFactor(),
//                                randomScalingFactor(),
//                                randomScalingFactor(),
//                                randomScalingFactor()
//                            ],
                        //}
                        ]
                },
                options: {
                    responsive: true,
                    title: {
                        display: true,
                        text: 'Productos mas solicitados'
                    },
                    tooltips: {
                        mode: 'index',
                        intersect: false,
                    },
                    hover: {
                        mode: 'nearest',
                        intersect: true
                    },
                    scales: {
                        xAxes: [{
                                display: true,
                                scaleLabel: {
                                    display: true,
                                    labelString: 'Producto'
                                }
                            }],
                        yAxes: [{
                                display: true,
                                scaleLabel: {
                                    display: true,
                                    labelString: 'Precio'
                                }
                            }]
                    }
                }
            };
            window.onload = function () {
                var ctx = document.getElementById('canvas').getContext('2d');
                window.myLine = new Chart(ctx, config);
            };
            document.getElementById('randomizeData').addEventListener('click', function () {
                config.data.datasets.forEach(function (dataset) {
                    dataset.data = dataset.data.map(function () {
                        return randomScalingFactor();
                    });
                });
                window.myLine.update();
            });
            var colorNames = Object.keys(window.chartColors);
            document.getElementById('addDataset').addEventListener('click', function () {
                var colorName = colorNames[config.data.datasets.length % colorNames.length];
                var newColor = window.chartColors[colorName];
                var newDataset = {
                    label: 'Dataset ' + config.data.datasets.length,
                    backgroundColor: newColor,
                    borderColor: newColor,
                    data: [],
                    fill: false
                };
                for (var index = 0; index < config.data.labels.length; ++index) {
                    newDataset.data.push(randomScalingFactor());
                }

                config.data.datasets.push(newDataset);
                window.myLine.update();
            });
            document.getElementById('addData').addEventListener('click', function () {
                if (config.data.datasets.length > 0) {
                    var month = MONTHS[config.data.labels.length % MONTHS.length];
                    config.data.labels.push(month);
                    config.data.datasets.forEach(function (dataset) {
                        dataset.data.push(randomScalingFactor());
                    });
                    window.myLine.update();
                }
            });
            document.getElementById('removeDataset').addEventListener('click', function () {
                config.data.datasets.splice(0, 1);
                window.myLine.update();
            });
            document.getElementById('removeData').addEventListener('click', function () {
                config.data.labels.splice(-1, 1); // remove the label first

                config.data.datasets.forEach(function (dataset) {
                    dataset.data.pop();
                });
                window.myLine.update();
            });
        </script>
    </body>
</html>
