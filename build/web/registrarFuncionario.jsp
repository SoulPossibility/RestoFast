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
                        <input name="run" type="text" required="true" onkeypress="return rut(event)" class="validate" minlength="8" maxlength="9" min="1000000" max="25000000">
                        <label for="run">Run</label>
                    </div>
                    <div class="input-field col s6">
                        <input name="nombres" type="text" required="true" onkeypress="return soloLetras(event)" class="validate">
                        <label for="nombres">Nombres</label>
                    </div>
                    <div class="input-field col s6">
                        <input name="apellido_paterno" type="text" required="true" onkeypress="return soloLetras(event)" class="validate">
                        <label for="apellido_paterno">Apellido Paterno</label>
                    </div>
                    <div class="input-field col s6">
                        <input name="apellido_materno" type="text" required="true" onkeypress="return soloLetras(event)" class="validate">
                        <label for="apellido_materno">Apellido Materno</label>
                    </div>
                    <div class="input-field col s6">
                        <input name="sexo" type="text" required="true" class="validate" onkeypress="return sexo(event)" maxlength="1" minlength="1" pattern="f|m">
                        <label for="sexo">Sexo (F/M)</label>
                    </div>
                    <div class="input-field col s6">
                        <input name="nacionalidad" type="text" required="true" onkeypress="return soloLetras(event)" class="validate">
                        <label for="nacionalidad">Nacionalidad</label>
                    </div>
                    <div class="input-field col s6">
                        <input name="fecha_nacimiento" type="date" required="true" min="1930-01-01" max="2019-11-18" >
                        <label for="fecha_nacimiento">Fecha de Nacimiento</label>
                    </div>
                    <div class="input-field col s6">
                        <input name="direccion" type="text" required="true" class="validate">
                        <label for="direccion">Dirección</label>
                    </div>
                    <div class="input-field col s6">
                        <input name="telefono" type="text" class="validate" onkeypress="return soloNumeros(event)" minlength="9"  maxlength="9">
                        <label for="telefono">Teléfono</label>
                    </div>
                    <div class="input-field col s6">
                        <input name="email" type="email" required="true" class="validate">
                        <label for="email">Email</label>
                    </div>
                    <div class="centered input-field col s6">
                        <input name="sueldo_base" type="number" required="true" class="validate" min="1" max="99999999">
                        <label for="sueldo_base">Sueldo Base</label>
                    </div>
                </div>
                <div class="input-field col s6">
                    <button class="btn" type="submit" name="action">Registrar</button>
                </div>
            </form>
            <a href="adminMenu.jsp" class="waves-effect waves-red btn" >Volver</a>
        </div>
        
        
        
        <!--Validaciones-->
        <script>
            function rut(e) {
                key = e.keyCode || e.which;
                tecla = String.fromCharCode(key).toLowerCase();
                letras = " 0123456789k";
                especiales = "8-37-39-46";

                tecla_especial = false
                for (var i in especiales) {
                    if (key == especiales[i]) {
                        tecla_especial = true;
                        break;
                    }
                }
                if(letras.indexOf(tecla)==-1 && !tecla_especial){
            return false;
        }
            }
            
            function soloLetras(e) {
                key = e.keyCode || e.which;
                tecla = String.fromCharCode(key).toLowerCase();
                letras = " áéíóúabcdefghijklmnñopqrstuvwxyz";
                especiales = "8-37-39-46";

                tecla_especial = false
                for (var i in especiales) {
                    if (key == especiales[i]) {
                        tecla_especial = true;
                        break;
                    }
                }
                if(letras.indexOf(tecla)==-1 && !tecla_especial){
            return false;
        }
            }
            
            function soloNumeros(e) {
                key = e.keyCode || e.which;
                tecla = String.fromCharCode(key).toLowerCase();
                letras = " 0123456789";
                especiales = "8-37-39-46";

                tecla_especial = false
                for (var i in especiales) {
                    if (key == especiales[i]) {
                        tecla_especial = true;
                        break;
                    }
                }
                if(letras.indexOf(tecla)==-1 && !tecla_especial){
            return false;
        }
            }
            
            function sexo(e) {
                key = e.keyCode || e.which;
                tecla = String.fromCharCode(key).toUpperCase();
                letras = " fm";
                especiales = "8-37-39-46";  

                tecla_especial = false
                for (var i in especiales) {
                    if (key == especiales[i]) {
                        tecla_especial = true;
                        break;
                    }
                }
                if(letras.indexOf(tecla)==-1 && !tecla_especial){
            return false;
        }
            }

        </script>

        <!--JavaScript at end of body for optimized loading-->
        <script type="text/javascript" src="js/materialize.min.js"></script>
    </body>
</html>
