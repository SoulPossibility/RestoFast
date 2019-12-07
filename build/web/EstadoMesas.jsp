<%-- 
    Document   : EstadoMesas
    Created on : 26-sep-2019, 13:04:33
    Author     : Asus
--%>



<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@page import="java.util.ArrayList"%>
<%@page import="modelo.EstadoM"%>
<%@page import="controlador.EstadoMesa" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Estado Mesas</title>   

    </head >
    <body>
        <div class="container" class="row">
            <div class="p-3 mb-2 bg-info text-white  ">

                <h1 class="">Estado De Las Mesas</h1>
                <c:if test="${mesas > 0}">  
                    <h4>Mesas Registradas en : ${nombreSistema} = ${mesas}</h4>
                </c:if>
            </div>

            <form>
                <div class="card-deck" class="col">


                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">N° Mesa</th>
                                <th scope="col">Capacidad</th>
                                <th scope="col">Estado</th>

                            </tr>
                        </thead>

                        <c:forEach items="${Estado}" var="pra" >


                            <tbody>
                                <tr>
                                    <th scope="row">${pra.numero}</th>
                                    <td>${pra.capacidad}</td>
                                    <td>${pra.estado}</td>
                                </tr>

                            </tbody>



                            <br/>
                        </c:forEach>



                    </table>



                    <div class="card text-white bg-info mb-3">
                        <a href="adminMenu.jsp" class="btn btn-secondary btn-lg " role="button" aria-pressed="true">Volver</a>
                    </div>

                </div>
                <script src="js/bootstrap.min.js" type="text/javascript"></script>
            </form>
        </div>
    </body>
</html>
