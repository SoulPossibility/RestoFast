<%-- 
    Document   : listarProveedor
    Created on : 15-09-2019, 12:46:29
    Author     : BlueOcean
--%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Proveedor"%>

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
            <h4>Usando JSTL (Ver código)</h4>
            <h5>Proveedores registrados:</h5>

            <!-- 
            Para mostrar la información respetando el modelo MVC usamos JSTL que se importo en la línea 7 de está página.
            c:foreach simula un for, tambien se encuentran otras funciones como el if y otras pero de distinta forma, 
            se recomienda revisar documentación, son pocos y dan mucha seguridad, menos lineas de código y facilidad de entendimiento para los demás.
            -->

            <ul>
                <c:forEach items="${proveedores}" var="pro">
                    <li style="list-style-type: disc;">Nombre: ${pro.nombre} Direccion: ${pro.direccion} Telefono: ${pro.telefono} Email: ${pro.email}</li>
                    </c:forEach>
            </ul>
            <br/>
            <!--Ejemplo usando un if-->
            <c:if test="${cantidad > 0}">
                <h6>Proveedores inscritos en : ${nombreSistema} -> ${cantidad}</h6>
            </c:if>

            
                
                
                
            <!---------------- SEGUNDA FORMA DE MOSTRAR DATOS (NO TAN RECOMENDADO)----------------->    
            <br/><br/>
            <hr>
            <h4>Usando Scriplets (Ver código)</h4>
            <h5>Proveedores registrados:</h6>

                <!--
                Otra forma de hacer lo mismo pero ya no se recomienda mucho su uso por la comunidad de Java, es usando scriplets <% %>
                Menos seguridad, mas código y debugeo más complejo.
                -->
                <%
                    List<Proveedor> listaProv = new ArrayList();
                    String nombreSistema = "";
                    int cantidad = 0;
                    try {
                        listaProv = (ArrayList) request.getAttribute("proveedores");
                        nombreSistema = request.getAttribute("nombreSistema").toString();
                        cantidad = (Integer) request.getAttribute("cantidad");

                        out.println("<ul>");
                        for (Proveedor prov : listaProv) {
                            out.println("<li style=list-style-type: disc;'>Nombre: " + prov.getNombre() + " Direccion:" + prov.getDireccion() + " Telefono:" + prov.getTelefono() + " Email:" + prov.getEmail() + "</li>");
                        }
                        out.println("</ul>");

                        if (cantidad > 0) {
                            out.print("<br/>");
                            out.print("<h6>Proveedores inscritos en : " + nombreSistema + " -> " + cantidad + "</h6>");
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
