<%-- 
    Document   : clienteBievenida
    Created on : 12-10-2019, 23:29:54
    Author     : BlueOcean
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido</h1>
        Pulsar boton para continuar
        <form method="get" action="ClientePantallaInicio">
            <button type="submit">Continuar con la atención</button>
        </form>
        <div class="alert-warning">
            <c:choose>
                <c:when test="${mensajeError != null}">
                    <p>${mensajeError}</p>
                </c:when>
            </c:choose>
        </div>
        <i>Nota: Las mesas 1 y 5 están disponibles para ejemplo, 
        Se debe iniciar una sesion_atención desde un TÓTEM, la fecha de termino de esa sesion_atencion debe setearse a null para que pueda ser reconocida</i>
        <br/><br/><i>Hay un ejemplo casi hecho de crear unan sesion_atencion en el Servlet 'MesaEstablecer' incluso con su página 'mesaEstablecer.jsp'</i>
        <br/><br/><i>Esto simula lo que debería hacer el totem al menos en funcionalidad</i>
    </body>
</html>
