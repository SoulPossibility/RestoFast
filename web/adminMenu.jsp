<%-- 
    Document   : adminMenu
    Created on : 10-11-2019, 3:00:03
    Author     : BlueOcean
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <body style=" background-image: url('images/bg_3.jpg'); background-size: cover;">
        <jsp:include page="nav.jsp"/>

        <div class="container">
            <div class="card p-4 m-4 bg-light">
                <div class="card-body text-center">
                    <h3>Administración de mesas</h3>
                    <hr>
                    <c:if test="${sessionScope.sesionUsuario.rol.id == 1}">
                        <a class="btn btn-info opcionAdmin" href="EstadoMesa">Ver Estado de Mesas</a>
                        <br/><br/>
                    </c:if>

                    <a class="btn btn-info opcionAdmin" href="ClienteConfigurarMesa">Configurar Número de Mesa</a>
                    <br/><br/>
                    <a class="btn btn-info opcionAdmin" href="ClientePantallaInicio">Iniciar como Mesa</a>
                    <c:if test="${sinMesa !=null}">
                        <div class="alert-warning"><p>Debe configurar una mesa</p></div>
                    </c:if>
                    <br/><br/>

                    <a class="btn btn-info opcionAdmin" href="MesaEstablecer">Iniciar como Tótem</a>
                    <br/><br/>

                    <c:if test="${sessionScope.sesionUsuario.rol.id == 1}">
                        <h3>Gestión de reportes</h3>
                        <hr>
                        <a class="btn btn-info opcionAdmin" href="adminReportes.jsp">Ver Datos Estadísticos</a>
                        <br/><br/>
                        <h3>Gestión de funcionarios</h3>
                        <hr>
                        <a class="btn btn-info opcionAdmin" href="registrarFuncionario.jsp">Registrar funcionarios</a>
                        <br/><br/>
                        <a class="btn btn-info opcionAdmin" href="ListarFuncionario">Listar funcionarios</a>
                        <br/><br/>
                    </c:if>
                </div>
            </div>
        </div>

        <style>
            .opcionAdmin{
                width: 250px;
                font-size: 1.1rem !important;
            }

            body, h3{
                color: black;
                font-size: 1.2rem;
                font-weight: lighter;
            }
        </style>
    </body>
</html>
