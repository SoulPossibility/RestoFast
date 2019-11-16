<%-- 
    Document   : mesaEstablecer
    Created on : 12-10-2019, 23:12:24
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
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <div class="container">
            <h1>Establezca la mesa:</h1>
            <form method="post" action="MesaEstablecer">
                <select name="seleccionMesa">
                    <c:forEach items="${mesas}" var="mesa">
                        <option value="${mesa.numero}">${mesa.numero}</option>
                    </c:forEach>
                </select>

                Nombre cliente
                <input type="text" name="nombreCliente"/>
                
                <select name="usuarioSeleccionado">
                    <c:forEach items="${usuarios}" var="usuario">
                        <option value="${usuario.nombre_usuario}">${usuario.nombre_usuario}</option>
                    </c:forEach>
                </select>

                <select name="cantComensales">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="4">5</option>
                    <option value="4">6</option>
                </select>

                <button type="submit" class="btn btn-primary">Seleccionar</button>
            </form>
        </div>
    </body>
</html>
