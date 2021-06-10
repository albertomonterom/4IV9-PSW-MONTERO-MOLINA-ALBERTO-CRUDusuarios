<%-- 
    Document   : consultarEmpleados
    Created on : 7/06/2021, 09:01:57 PM
    Author     : molin
--%>

<%@page import="MVCcontrol.AccionesEmpleado"%>
<%@page import="java.util.List"%>
<%@page import="MVCModelo.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">
        <link rel="stylesheet" href="assets/css/styles.css">
        <link rel="stylesheet" href="assets/css/MVC.css">
        <link rel="shortcut icon" href="assets/img/logo_transparent(1).png">
        <title>B&J's IceCream</title>
    </head>
                <!-- HEADER -->
        <header class="l-header">
            <nav class="nav bd-grid">
                <div>
                    <a href="index.html" class="nav__logo">BEN <span>AND JERRY'S</span></a>
                </div>
                <div class="nav__menu" id="nav-menu">
                    <ul class="nav__list">
                        <li class="nav__item"><a href="index.html" class="nav__link active">Inicio</a></li>
                        <li class="nav__item"><a href="sabores.html" class="nav__link">Sabores</a></li>
                        <li class="nav__item"><a href="promociones.html" class="nav__link">Promociones</a></li>
                        <li class="nav__item"><a href="iniciar.html" class="nav__link">Iniciar Sesión</a></li>
                    </ul>
                </div>
                <div>
                    <i class="fas fa-shopping-cart nav__cart"></i>
                    <i class="fas fa-bars nav__toggle" id="nav-toggle"></i>
                </div>
            </nav>
        </header>
    <body>
        <div class = "title_mvc">
            <div class = "title_sabores">
                <h1 class="home__tittle">Tabla de Todos los<br><span>Empleados</span></h1>
            </div>
        </div>
        <br>
        <table class = "table" border = "2">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Password</th>
                    <th>Telefono Celular</th>
                    <th>Email</th>
                    <th>Pais</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            
            <tbody>
                <% 
                List<Empleado> lista = AccionesEmpleado.buscarAllEmpleados();
                
                for(Empleado e : lista){
                    
                    %>
                    <tr>
                        <td> <%=e.getId()%> </td>
                        <td> <%=e.getNombre()%> </td>
                        <td> <%=e.getCel()%> </td>
                        <td> <%=e.getPassword()%> </td>
                        <td> <%=e.getEmail()%> </td>
                        <td> <%=e.getPais()%> </td>
                        <td> <a href="editarempleado.jsp?id=<%=e.getId()%>" >Editar</a> </td>
                        <td> <a href="borrarEmpleado?id=<%=e.getId()%>" >Borrar</a> </td>
                    </tr>    
                    <%
                }
                %>  
            </tbody>
            
        </table>
                
        <br>
        <div class = "containerConsulta">
        <a href="index.html">Regresar al Menu Principal</a>
        </div>
                        <!-- FOOTER -->
        <footer class="footer section">
            <section class="numerofooter">
                <a href="tel:5537325700" class="phone">
                    <span><i class="fas fa-phone" aria-hidden=true></i></span>
                </a>
            </section>
            <section class="nombresfooter">
                Montero Molina Alberto,&nbsp;&nbsp;
                Pérez García Benjamín Arturo,&nbsp;&nbsp;
                Sánchez Romero Eduardo Alberto.&nbsp;&nbsp;
            </section>
            <div class="social">
                <ul>
                    <li><a href="https://www.facebook.com/Healthy-Sex-103772591813714" class="facebook"><i class="fab fa-facebook-f"></i></a></li>
                    <li><a href="https://www.instagram.com/healthysex_21/" class="instagram"><i class="fab fa-instagram"></i></a></li>
                    <li><a href="https://twitter.com/HEALTHYSEX3" class="twitter"><i class="fab fa-twitter"></i></a></li>
                </ul>
            </div>
        </footer>
        <script src="assets/js/main.js"></script>
        <script src="assets/js/contacto.js"></script>
    </body>
</html>
