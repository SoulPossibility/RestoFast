<%-- 
    Document   : registrarFuncionario
    Created on : 02-10-2019, 21:53:17
    Author     : Javier
--%>

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



        <div class="container center">
            <h5>Registrar Funcionario</h5>
            <form class="col s7 centered" method="POST" action="RegistrarFuncionario">
                <div class="row centered">
                    <div class="input-field col s6">
                        <input name="run" type="text" class="validate">
                        <label for="run">Run</label>
                    </div>
                    <div class="input-field col s6">
                        <input name="nombres" type="text" class="validate">
                        <label for="nombres">Nombres</label>
                    </div>
                    <div class="input-field col s6">
                        <input name="apellido_paterno" type="text" class="validate">
                        <label for="apellido_paterno">Apellido Paterno</label>
                    </div>
                    <div class="input-field col s6">
                        <input name="apellido_materno" type="text" class="validate">
                        <label for="apellido_materno">Apellido Materno</label>
                    </div>
                    <div class="input-field col s6">
                        <input name="sexo" type="text" class="validate">
                        <label for="sexo">Sexo</label>
                    </div>
                    <div class="input-field col s6">
                        <input name="nacionalidad" type="text" class="validate">
                        <label for="nacionalidad">Nacionalidad</label>
                    </div>
                    <div class="input-field col s6">
                        <input name="fecha_nacimiento" type="date" >
                        <label for="fecha_nacimiento">Fecha de Nacimiento</label>
                    </div>
                    <div class="input-field col s6">
                        <input name="direccion" type="text" class="validate">
                        <label for="direccion">Dirección</label>
                    </div>
                    <div class="input-field col s6">
                        <input name="telefono" type="text" class="validate">
                        <label for="telefono">Teléfono</label>
                    </div>
                    <div class="input-field col s6">
                        <input name="email" type="text" class="validate">
                        <label for="email">Email</label>
                    </div>
                    <div class="centered input-field col s6">
                        <input name="sueldo_base" type="text" class="validate">
                        <label for="sueldo_base">Sueldo Base</label>
                    </div>
                </div>




                <!--Boton que activa el metodo post de la pagina y por lo tanto se activa el action del form-->
                <div class="input-field col s6">
                    <button class="btn" type="submit" name="action">Registrar</button>
                </div>
            </form>
            <a href="index.jsp" class="waves-effect waves-red btn" >Volver</a>
        </div>

        <!--JavaScript at end of body for optimized loading-->
        <script type="text/javascript" src="js/materialize.min.js"></script>
    </body>
</html>
