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
    </head>
    <body>
        <!--import del nav-->
        <jsp:include page="nav.jsp"/>

        <section class="home-slider owl-carousel img" style="background-image: url(images/bg_1.jpg);">
            <div class="slider-item">
                <div class="overlay"></div>
                <div class="container">
                    <!--                    <div class="row slider-text align-items-center" data-scrollax-parent="true">-->

                    <br><br><br>
                    <div class="card">
                        <div class="col-md-12 col-sm-12 ftco-animate m-4">
                            <div class="row">
                                <div class="col-lg-8 d-flex ftco-animate">
                                    <div class="services-wrap d-flex">
                                        <a href="#" class="img" style="background-image: url('images/${menu.nombre}.jpg');"></a>
                                        <div class="text p-4">
                                            <h3>${menu.nombre}</h3>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
                                            <p class="price" style="font-size: 2rem;"><span>$ ${menu.precio}</span> <a href="#" class="ml-2 btn btn-white btn-outline-white">AGREGAR</a></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-4 col-sm-4">
                                    <h4 style="color:black;">Establecer cantidad</h4>
                                    <div class="form-group">
                                        <form id="my-form" method="POST" action="MenuSeleccionar">
                                            <select name="cantidadPersonas" class="col-10">
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                            </select>
                                            <input name="codigoMenu" type="hidden" value="${menu.codigo}"/>
                                            <br/><br/>
                                            <input class="btn btn-warning col-10" type="submit" value="Confirmar pedido"/>
                                        </form>
                                            <br/>
<!--                                        <input class="btn btn-warning" type="submit" form="my-form" value="Agregar selección"/>-->
                                        <a class="btn btn-warning col-10" href="MenuSeleccionar">Cancelar</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

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
</body>
</html>
