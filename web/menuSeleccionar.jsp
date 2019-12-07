<%-- 
    Document   : clienteMenu
    Created on : 25-09-2019, 23:13:40
    Author     : BlueOcean
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
    </head>
    <body>
        <!--import del nav-->
        <jsp:include page="nav.jsp"/>

        <div class="container">
            <c:if test="${fn:length(carrito) eq 0}">
                <div class="row justify-content-center mb-5 pb-3 mt-5 pt-5">
                    <div class="col-md-7 heading-section text-center ftco-animate">
                        <h2 class="mb-4">NUESTRO MENÚ</h2>
                        <p>Mesa: ${sessionScope.mesaEstablecida.numero}</p>
                        <p class="flip"><span class="deg1"></span><span class="deg2"></span><span class="deg3"></span></p>
                        <p class="mt-5">Los mejores platos y bebidas, escoga de nuestra selecta variedad de platos producidos por el mejor talento culinario.</p>
                    </div>
                </div>
            </c:if>

            <c:if test="${fn:length(carrito) gt 0}">
                <div class="row justify-content-center mb-5 pb-3 mt-5 pt-5">
                    <div class="col-md-7 heading-section text-center ftco-animate">
                        <h2 class="mb-4">SELECCIONADO DEL MENÚ</h2>
                        <p class="flip"><span class="deg1"></span><span class="deg2"></span><span class="deg3"></span></p>
                        <p class="mt-5">Los mejores platos y bebidas, escoga de nuestra selecta variedad de platos producidos por el mejor talento culinario.</p>
                        <table class="table table-striped">
                            <tr>
                                <th>Nombre</th>
                                <th>Tiempo de preparacion</th>
                                <th>Cantidad</th>
                                <th>Precio</th>
                                <th>Opcion</th>
                            </tr>
                            <tbody>
                                <c:forEach items="${carrito}" var="item">
                                    <tr>
                                        <td>${item.menu.nombre}</td>
                                        <td>${item.menu.tiempoPreparacion}</td>
                                        <td>${item.cantidad}</td>
                                        <td>${item.precio}</td>
                                        <td>
                                            <a href="MenuGestion?codigoEliminacion=${item.menu.codigo}&totalCarrito=${totalCarrito}">Eliminar</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <tr><td></td><td></td><td></td><td>TOTAL:</td><td>${totalCarrito}</td></tr>
                            </tbody>
                        </table>
                        <form method="POST" action="ClienteRealizarPedido">
                            <c:forEach items="${sessionScope.carrito}" var="menu">
                                <input name="idmenu" type="hidden" value="${item.menu.codigo}"/>
                            </c:forEach>
                            <button class="btn btn-warning col-4" type="submit">REALIZAR PEDIDO</button>

                            <!--                            Birthday:
                                                        <input type="date" name="dateValue">
                                                        <input type="submit">-->
                        </form>
                    </div>
                </div>
            </c:if>
            
            <div class="row">
                <div class="col-md-6">
                    <p>PLATOS PRINCIPALES</p>
                    <c:forEach items="${platos}" var="plato">
                        <a class="" href="MenuSeleccionarCantidad?cliente=1&menu=${plato.codigo}">
                            <div class="pricing-entry d-flex ftco-animate">
                                <!--                                <div class="img" style="background-image: url(images/pizza-1.jpg);"></div>-->
                                <div class="img" style="background-image: url('images/${plato.nombre}.jpg'); background-size: 100% 100%; "></div>
                                <div class="desc pl-3">
                                    <div class="d-flex text align-items-center">
                                        <h3><span>${plato.nombre}</span></h3>
                                        <span class="price">$ ${plato.precio}</span>
                                    </div>
                                    <div class="d-block">
                                        <p>Servido en ${plato.tiempoPreparacion} minutos</p>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </c:forEach>
                </div>

                <div class="col-md-6">
                    <p>BEBIDAS</p>
                    <c:forEach items="${bebidas}" var="bebida">
                        <a class="" href="MenuSeleccionarCantidad?cliente=1&menu=${bebida.codigo}">
                            <div class="pricing-entry d-flex ftco-animate">
                                <div class="img" style="background-image: url('images/${bebida.nombre}.jpg'); background-size: 100% 100%;"></div>
                                <div class="desc pl-3">
                                    <div class="d-flex text align-items-center">
                                        <h3><span>${bebida.nombre}</span></h3>
                                        <span class="price">$ ${bebida.precio}</span>
                                    </div>
                                    <div class="d-block">
                                        <p>Servido en ${bebida.tiempoPreparacion} minutos</p>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </c:forEach>
                </div>
            </div>

            <br/><br/>
            <!--POSTRES-->
            <div class="row">
                <div class="col-md-6">
                    <p>POSTRES</p>
                    <c:forEach items="${postres}" var="postre">
                        <a class="" href="MenuSeleccionarCantidad?cliente=1&menu=${postre.codigo}">
                            <div class="pricing-entry d-flex ftco-animate">
                                <div class="img" style="background-image: url('images/${postre.nombre}.jpg'); background-size: 100% 100%;"></div>
                                <div class="desc pl-3">
                                    <div class="d-flex text align-items-center">
                                        <h3><span>${postre.nombre}</span></h3>
                                        <span class="price">$ ${postre.precio}</span>
                                    </div>
                                    <div class="d-block">
                                        <p>Servido en ${postre.tiempoPreparacion} minutos</p>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </c:forEach>
                </div>
            </div>


            


        </div>

        <script>

            function validateForm() {
                alert("hola");
                var x = document.forms["myForm"]["fname"].value;
                if (x <= 0) {
                    alert("Name must be filled out");
                    return false;
                }
            }
        </script>

        <!-- loader -->
        <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>

        <script src="js/jquery.min.js"></script>
        <script src="js/jquery-migrate-3.0.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.easing.1.3.js"></script>
        <script src="js/jquery.waypoints.min.js"></script>
        <script src="js/jquery.stellar.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/aos.js"></script>
        <script src="js/jquery.animateNumber.min.js"></script>
        <script src="js/bootstrap-datepicker.js"></script>
        <script src="js/jquery.timepicker.min.js"></script>
        <script src="js/scrollax.min.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
        <script src="js/google-map.js"></script>
        <script src="js/main.js"></script>


        <style>
            .clientemenu-item:hover {
                background-color: #E3E3E3;
            }

        </style>
    </body>
</html>
