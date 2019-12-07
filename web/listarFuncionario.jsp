<%-- 
    Document   : listarFuncionario
    Created on : 02-10-2019, 20:37:46
    Author     : Javier
--%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!--Importante para estilos, Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <!--Opcional, Para usar iconos-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Opcional, Let browser know website is optimized for mobile (mejor visualización en smartphones)-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>
    <body>
        <div class="container">

            <!---------------- PRIMER MODO DE MOSTRAR DATOS (RECOMENDADO)------------------>

            <h5>Funcionarios registrados</h5>
            <c:if test="${cantidad > 0}">
                <h6>Actualmente existen ${cantidad} funcionarios en la base de datos de ${nombreSistema} </h6>
            </c:if>

            <!-- 
            Para mostrar la información respetando el modelo MVC usamos JSTL que se importo en la línea 7 de está página.
            c:foreach simula un for, tambien se encuentran otras funciones como el if y otras pero de distinta forma, 
            se recomienda revisar documentación, son pocos y dan mucha seguridad, menos lineas de código y facilidad de entendimiento para los demás.
            -->

            <ul>
                <table class="centered">
                    <thead>
                        <tr>
                            <th data-field="">Run</th>
                            <th data-field="name">Nombres</th>
                            <th data-field="price">Apellido Paterno</th>
                            <th data-field="name">Apellido Materno</th>
                            <th data-field="name">Fecha Nacimiento</th>
                            <th data-field="name">Email</th>
                            <th data-field="name">Sueldo Base</th>
                     
                            <th data-field="name">Eliminar</th>
                    <tbody>
                        <tr>

                            <c:forEach items="${funcionarios}" var="fn">

                                <td>${fn.run}</td>
                                <td>${fn.nombres}</td>
                                <td>${fn.apellidoPaterno}</td>
                                <td>${fn.apellidoMaterno}</td>
                                <td>${fn.fechaNacimiento}</td>
                                <td>${fn.email}</td>
                                <td>${fn.sueldoBase}</td>
                                
                                <td>  <a href="EliminarFuncionario?run=${fn.run}" class="waves-effect waves-light btn"><i class="material-icons left">clear</i></a></td>

                            </tr>      
                        </tbody>    
                    </c:forEach>
                    </tr>
                    </thead>
                </table>
            </ul>
            <br/>

            <a href="adminMenu.jsp" class="waves-effect waves-red btn" >Volver</a>






            <!---------------- SEGUNDA FORMA DE MOSTRAR DATOS (NO TAN RECOMENDADO)----------------    
            <br/><br/>
            <hr>
            <h4>Usando Scriplets (Ver código)</h4>
            <h5>Proveedores registrados:</h6>

            <!--
            Otra forma de hacer lo mismo pero ya no se recomienda mucho su uso por la comunidad de Java, es usando scriplets <% %>
            Menos seguridad, mas código y debugeo más complejo.
            
            <%
                List<Funcionario> listaFun = new ArrayList();
                String nombreSistema = "";
                int cantidad = 0;
                try {
                    listaFun = (ArrayList) request.getAttribute("funcionarios");
                    nombreSistema = request.getAttribute("nombreSistema").toString();
                    cantidad = (Integer) request.getAttribute("cantidad");

                    out.println("<ul>");
                    for (Funcionario func : listaFun) {
                        out.println("<li style=list-style-type: disc;'>Nombres: " + func.getNombres() + " Nacionalidad: " + func.getNacionalidad() + " Telefono: " + func.getTelefono() + " Email: " + func.getEmail() + "</li>");
                    }
                    out.println("</ul>");

                    if (cantidad > 0) {
                        out.print("<br/>");
                        out.print("<h6>Funcionarios inscritos en : " + nombreSistema + " -> " + cantidad + "</h6>");
                    }
                } catch (Exception e) {
                    out.print(e.getMessage());
                }
            %> 

    </div>
            <!--JavaScript at end of body for optimized loading-->
            <script type="text/javascript" src="js/materialize.min.js"></script>
    </body>
</html>
