<%-- 
    Document   : index
    Created on : 25-09-2019, 22:58:49
    Author     : BlueOcean
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

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
        
        <script src="js/graphs//Chart.bundle.js"></script>
        <script src="js/graphs//utils.js"></script>
        <script src="js/jquery-1.11.1.js" type="text/javascript"></script>
    </head>
    <body>
        <!--import del nav-->
        <jsp:include page="nav.jsp"/>

        <div class="row">
            <div class="col-3">
                <h3>Nelly:</h3>
                <br/>
                <a href="ListarPedido">Listar Pedidos</a>
                <br/>
                <a href="ListarProducto">Listar Producto</a>
            </div>
            <div class="col-3">
                <h3>Javier:</h3>
                <div class="container center">

                    <div><h5><p style="color: #ffffff">Página de administración del personal</p></h5></div>
                    <br/>

                    <tr><a href="registrarFuncionario.jsp" class="waves-effect waves-light btn">Registrar funcionario</a></tr>
                    <br/>
                    <br/>
                    <a href="ListarFuncionario" class="waves-effect waves-light btn" >Listar funcionarios</a>
                </div>
            </div>
            <div class="col-3">

            </div>
            <div class="col-3">
                <h3>Mario</h3>
                <a class="btn btn-primary btn-lg btn-block" href="Login.jsp">Login</a>
                <a class="btn btn-primary btn-lg btn-block" href="EstadoMesas.jsp">xd</a>
            </div>
        </div>

        <div>
            <div style="width:75%;">
                <canvas id="canvas"></canvas>
            </div>
            <br>
            <br>
            <button id="randomizeData">Randomize Data</button>
            <button id="addDataset">Add Dataset</button>
            <button id="removeDataset">Remove Dataset</button>
            <button id="addData">Add Data</button>
            <button id="removeData">Remove Data</button>
            <script>
                var MONTHS = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
                var config = {
                    type: 'line',
                    data: {
                        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
                        datasets: [{
                                label: 'My First dataset',
                                backgroundColor: window.chartColors.red,
                                borderColor: window.chartColors.red,
                                data: [
                                    randomScalingFactor(),
                                    randomScalingFactor(),
                                    randomScalingFactor(),
                                    randomScalingFactor(),
                                    randomScalingFactor(),
                                    randomScalingFactor(),
                                    randomScalingFactor()
                                ],
                                fill: false,
                            }, {
                                label: 'My Second dataset',
                                fill: false,
                                backgroundColor: window.chartColors.blue,
                                borderColor: window.chartColors.blue,
                                data: [
                                    randomScalingFactor(),
                                    randomScalingFactor(),
                                    randomScalingFactor(),
                                    randomScalingFactor(),
                                    randomScalingFactor(),
                                    randomScalingFactor(),
                                    randomScalingFactor()
                                ],
                            }]
                    },
                    options: {
                        responsive: true,
                        title: {
                            display: true,
                            text: 'Chart.js Line Chart'
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
                                        labelString: 'Month'
                                    }
                                }],
                            yAxes: [{
                                    display: true,
                                    scaleLabel: {
                                        display: true,
                                        labelString: 'Value'
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
        </div>

    </body>
</html>
