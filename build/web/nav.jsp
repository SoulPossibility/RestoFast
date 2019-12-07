<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
        <a class="navbar-brand" href="paginaEjemplo/index.html"><span class="flaticon-pizza-1 mr-1"></span>Resto<br><small>FAST</small></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>
        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
                <c:if test="${sessionScope.sesionUsuario.rol.id == 1}">
                    <li class="nav-item"><a href="index23.jsp" class="nav-link">Inicio de prueba</a></li>
                    <li class="nav-item"><a href="adminMenu.jsp" class="nav-link">Menu principal</a></li>
                    <li class="nav-item"><a href="EstadoMesa" class="nav-link">Estado de mesas</a></li>
                    <li class="nav-item"><a href="ClienteConfigurarMesa" class="nav-link">Configurar mesa</a></li>
                    <li class="nav-item"><a href="adminReportes.jsp" class="nav-link">Reportes</a></li>
                    <li class="nav-item"><a href="MesaEstablecer" class="nav-link">Totem</a></li>
                    </c:if>

                <c:if test="${sessionScope.sesionUsuario.rol.id == 5}">
                    <li class="nav-item"><a href="ClienteConfigurarMesa" class="nav-link">Configurar mesa</a></li>
                    <li class="nav-item"><a href="MesaEstablecer" class="nav-link">Totem</a></li>
                    </c:if>

                <c:if test="${sessionScope.sesionUsuario.rol.id == 3}">
                    <li class="nav-item"><a href="CocineroPedidos?comando=cargar" class="nav-link">Pedidos cocinero</a></li>
                    </c:if>
                    <c:if test="${sessionScope.sesionUsuario.rol.id == 6}">
                    <li class="nav-item"><a href="ListarPedido" class="nav-link">Listar Pedidos</a></li>
                    <li class="nav-item"><a href="ListarProducto" class="nav-link">Listar Productos</a></li>
                    </c:if>

                <li class="nav-item"><a href="Login" class="nav-link">Cerrar Sesión</a></li>
                <!--                <li class="nav-item"><a href="MesaEstablecer" class="nav-link">Establecer numero de mesa</a></li>
                                <li class="nav-item"><a href="ClientePantallaInicio" class="nav-link">Pantalla inicio</a></li>
                                <li class="nav-item"><a href="MenuSeleccionar" class="nav-link">Seleccionar menu</a></li>-->


                <!--                <li class="nav-item"><a href="a_graph.jsp" class="nav-link">Graph</a></li>-->
                <!--                <li class="nav-item"><a href="Controller?estado=1" class="nav-link">Cerrar Sesión</a></li>-->


                <!--                <li class="nav-item"><a href="services.html" class="nav-link">Services</a></li>
                                <li class="nav-item"><a href="blog.html" class="nav-link">Blog</a></li>
                                <li class="nav-item"><a href="about.html" class="nav-link">About</a></li>
                                <li class="nav-item active"><a href="contact.html" class="nav-link">Contact</a></li>-->
            </ul>
        </div>
    </div>
</nav>