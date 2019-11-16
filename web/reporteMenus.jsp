<%-- 
    Document   : reporteMenus
    Created on : 08-11-2019, 23:32:16
    Author     : BlueOcean
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>

        <script src="js/graphs/Chart.bundle.js" type="text/javascript"></script>
        <script src="js/graphs/utils.js" type="text/javascript"></script>

        <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
        <link rel="stylesheet" href="css/animate.css">

        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">

        <link rel="stylesheet" href="css/aos.css">

        <link rel="stylesheet" href="css/ionicons.min.css">

        <link rel="stylesheet" href="css/flaticon.css">
        <link rel="stylesheet" href="css/icomoon.css">
        <link rel="stylesheet" href="css/style.css">
        <style>
            canvas{
                -moz-user-select: none;
                -webkit-user-select: none;
                -ms-user-select: none;
            }

            canvas2{
                -moz-user-select: none;
                -webkit-user-select: none;
                -ms-user-select: none;
            }
        </style>
    </head>
    <body id="page-top" style="background-image: ;">
        <jsp:include page="nav.jsp"/>
        <div class="container">
            <div class="card">
                <div class="card-header">
                    <div class="card-title">
                        DATA DE COMESTIBLES
                    </div>
                </div>
                <div class="card-body p-4 m-4">
                    <div id="container" style="width: 100%;">
                        <canvas id="canvas"></canvas>
                    </div>
                    <br><br>
                    <div>
                        <table class="table table-striped table-sm" style="font-size: 0.8rem;">
                            <thead class="">
                            <th>Código</th>
                            <th>Nombre</th>
                            <th>Cantidad</th>
                            <th>Tipo</th>
                            <th>Precio</th>
                            <th>Total</th>
                            </thead>
                            <tbody>
                                <c:set var="totalComestibles" scope="application" value="0"></c:set>
                                <c:forEach items="${listaGraphComestibles}" var="item">
                                    <tr>
                                        <td>${item.menu.codigo}</td>
                                        <td>${item.menu.nombre}</td>
                                        <td>${item.cantidad}</td>
                                        <td>${item.menu.tipo}</td>
                                        <td>$${item.menu.precio}</td>
                                        <td>$${item.cantidad * item.menu.precio}</td>
                                        <c:set var="totalComestibles" scope="application" value="${totalComestibles + item.cantidad * item.menu.precio}"></c:set>
                                        </tr>
                                </c:forEach>
                                <tr>
                                    <td>TOTAL</td><td></td><td></td><td></td><td></td><td><c:out value="$${totalComestibles}"></c:out></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <br/><br/>

                <div class="card">
                    <div class="card-header">
                        <div class="card-title">
                            DATA DE BEBESTIBLES
                        </div>
                    </div>
                    <div class="card-body p-4 m-4">
                        <div id="container" style="width: 100%;">
                            <canvas id="canvas2"></canvas>
                        </div>
                        <div>
                            <table class="table table-striped table-sm" style="font-size: 0.8rem;">
                                <thead>
                                <th>Código</th>
                                <th>Nombre</th>
                                <th>Cantidad</th>
                                <th>Tipo</th>
                                <th>Precio</th>
                                <th>Total</th>
                                </thead>

                                <tbody>
                                <c:set var="totalBebestibles" scope="application" value="0"></c:set>
                                <c:forEach items="${listaGraphBebestibles}" var="item">
                                    <tr>
                                        <td>${item.menu.codigo}</td>
                                        <td>${item.menu.nombre}</td>
                                        <td>${item.cantidad}</td>
                                        <td>${item.menu.tipo}</td>
                                        <td>$${item.menu.precio}</td>
                                        <td>$${item.cantidad * item.menu.precio}</td>
                                        <c:set var="totalBebestibles" scope="application" value="${totalBebestibles + item.cantidad * item.menu.precio}"></c:set>
                                        </tr>
                                </c:forEach>
                                <tr>
                                    <td>TOTAL</td><td></td><td></td><td></td><td></td><td><c:out value="$${totalBebestibles}"></c:out></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>


                <div class="card">
                    <div class="card-header">
                        <div class="card-title">
                            HOLA
                        </div>
                    </div>
                    <div class="card-body">

                    </div>
                </div>



            </div>

            <!--GRAFICO 1-->
            <script>
                //var MONTHS = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
                var MONTHS = ${arregloComestibles};
                var color = Chart.helpers.color;
                var barChartData = {
                labels: ${arregloComestibles},
                        datasets: [{
                        label: 'Platos principales',
                                backgroundColor: color(window.chartColors.red).alpha(0.5).rgbString(),
                                borderColor: window.chartColors.red,
                                borderWidth: 1,
                                data: [
            <c:forEach items="${listaGraphComestibles}" var="menu">
                <c:choose>
                    <c:when test="${menu.menu.tipo == 'Plato'}">
                        ${menu.cantidad},
                    </c:when>
                    <c:otherwise>
                                0,
                    </c:otherwise>
                </c:choose>
            </c:forEach>
                                //					randomScalingFactor(),
                                //					randomScalingFactor(),
                                //					randomScalingFactor(),
                                //					randomScalingFactor(),
                                //					randomScalingFactor(),
                                //					randomScalingFactor(),
                                //					randomScalingFactor()
                                ]
                        }, {
                        label: 'Postres',
                                backgroundColor: color(window.chartColors.blue).alpha(0.5).rgbString(),
                                borderColor: window.chartColors.blue,
                                borderWidth: 1,
                                data: [
            <c:forEach items="${listaGraphComestibles}" var="menu">
                <c:choose>
                    <c:when test="${menu.menu.tipo == 'Postre'}">
                        ${menu.cantidad},
                    </c:when>
                    <c:otherwise>
                                0,
                    </c:otherwise>
                </c:choose>
            </c:forEach>
                                ],
                        }]

                };
        </script>

        <!--GRAFICO 2-->
        <script>
            //var MONTHS = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
            var MONTHS = ${arregloBebestibles};
            var color = Chart.helpers.color;
            var barChartData2 = {
            labels: ${arregloBebestibles},
                    datasets: [{
                    label: 'Bebidas',
                            backgroundColor: color(window.chartColors.red).alpha(0.5).rgbString(),
                            borderColor: window.chartColors.red,
                            borderWidth: 1,
                            data: [
            <c:forEach items="${listaGraphBebestibles}" var="menu">
                <c:choose>
                    <c:when test="${menu.menu.tipo == 'Bebida'}">
                        ${menu.cantidad},
                    </c:when>
                    <c:otherwise>
                            0,
                    </c:otherwise>
                </c:choose>
            </c:forEach>
//					randomScalingFactor(),
//					randomScalingFactor(),
//					randomScalingFactor(),
//					randomScalingFactor(),
//					randomScalingFactor(),
//					randomScalingFactor(),
//					randomScalingFactor()
                            ]
                    }, {
                    label: 'Bebidas alcoholicas',
                            backgroundColor: color(window.chartColors.blue).alpha(0.5).rgbString(),
                            borderColor: window.chartColors.blue,
                            borderWidth: 1,
                            data: [
            <c:forEach items="${listaGraphBebestibles}" var="menu">
                <c:choose>
                    <c:when test="${menu.menu.tipo == 'Alcohol'}">
                        ${menu.cantidad},
                    </c:when>
                    <c:otherwise>
                            0,
                    </c:otherwise>
                </c:choose>
            </c:forEach>
                            ]
                    }]

            };
        </script>

        <!--VISUALIZAR MAS DE 1 GRAFICO POR PAGINA-->
        <script>
            window.onload = function () {
            var ctx = document.getElementById('canvas').getContext('2d');
            window.myBar = new Chart(ctx, {
            type: 'bar',
                    data: barChartData,
                    options: {
                    responsive: true,
                            legend: {
                            position: 'top',
                            },
                            title: {
                            display: true,
                                    text: 'Cantidad de comestibles solicitados'
                            },
                            //TEXTO CUSTOM PARA LOS TOOLTIPS
//                            tooltips: {
//                            enabled: true,
//                            mode: 'single',
//                            callbacks: {
//                                label: function(tooltipItems, data) { 
//                                    return tooltipItems.yLabel + ' : ' + tooltipItems.xLabel + " Files";
//                                }
//                            }
//                        },
                    }
            });
            var ctx2 = document.getElementById('canvas2').getContext('2d');
            window.myBar = new Chart(ctx2, {
            type: 'bar',
                    data: barChartData2,
                    options: {
                    responsive: true,
                            legend: {
                            position: 'top',
                            },
                            title: {
                            display: true,
                                    text: 'Cantidad de bebestibles solicitados'
                            }
                    }
            });
            };
        </script>

        <style>
            body{
                background: url(images/fondo_restaurante.png) no-repeat fixed;
            }
        </style>


    </body>
</html>
