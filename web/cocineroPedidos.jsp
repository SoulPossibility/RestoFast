<%-- 
    Document   : cocineroPedidos
    Created on : 01-10-2019, 13:22:16
    Author     : BlueOcean
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="date" class="java.util.Date"/>
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

        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">

        <link rel="stylesheet" href="css/aos.css">

        <link rel="stylesheet" href="css/ionicons.min.css">

        <link rel="stylesheet" href="css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="css/jquery.timepicker.css">


        <link rel="stylesheet" href="css/flaticon.css">
        <link rel="stylesheet" href="css/icomoon.css">
        <link rel="stylesheet" href="css/style.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

    </head>

    <body style=" background-image: url('images/kitchen_bg.jpg');">
        <jsp:include page="nav.jsp"/>
        <div class="container">
            <h2><c:out value="${sessionScope.sesionUsuario.rol.descripcion}"/></h2>
            <div class="card p-4">
                <div class="container">
                    <div class="table-responsive">
                        <table id="example" class="table table-hover" style="width:100%; font-size: 0.9rem; color: black;">
                            <thead>
                                <tr>
                                    <th>Pedido</th>
                                    <th>Producto</th>
                                    <th>Tipo</th>
                                    <th>Cantidad</th>
                                    <th>Hora de solicitud</th>
                                    <th>Mesa</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${ordenesPendientes}" var="orden">
                                    <tr>
                                        <td><img src="images/${orden.menu.nombre}.jpg" alt="img" style="width: 60px; height: 60px;"/></td>
                                        <td>${orden.menu.nombre}</td>
                                        <td>${orden.menu.tipo}</td>
                                        <td>${orden.cantidad}</td>
                                        <td><fmt:formatDate var="time"  
                                                    value="${orden.fecha}"
                                                    pattern="YYdd"/>
                                <br/>${time}</td>
                                <td>${orden.sesionAtencion.mesa}</td>
                                <td><a class="btn conluirOrden" href="">Terminar</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>


        <script src="js/jquery.min.js"></script>
        <script src="js/jquery-migrate-3.0.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.easing.1.3.js"></script>
        <script src="js/jquery.waypoints.min.js"></script>
        <script src="js/jquery.stellar.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/aos.js"></script>
        <script src="js/jquery.animateNumber.min.js"></script>
        <script src="js/bootstrap-datepicker.js"></script>
        <script src="js/jquery.timepicker.min.js"></script>
        <script src="js/scrollax.min.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
        <script src="js/google-map.js"></script>
        <script src="js/main.js"></script>

        <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>

        <script>
            $(document).ready(function () {
                $('#example').DataTable();
            });



        </script>

        <!--        <script>
                    setTimeout(function () {
                        location.reload();
                    }, 1000);
                </script>-->

        <style>
            .conluirOrden{
                width: 150px;
                height: 50px;
                background-color: red; 
            }

            table{
                text-align: center !important;
                vertical-align: middle !important;
            }
        </style>

    </body>
</html>
