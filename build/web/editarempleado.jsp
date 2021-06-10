<%-- 
    Document   : editarempleado
    Created on : 10/06/2021, 02:32:08 AM
    Author     : molin
--%>

<%@page import="MVCModelo.Empleado"%>
<%@page import="MVCcontrol.AccionesEmpleado"%>
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
                <h1 class="home__tittle">Tabla de Actualizar<br><span>Empleados</span></h1>
            </div>
        </div>
                    <div class = "containerRegistro">
                <form method = "post" name = "actualizarempleado" action="actualizarEmpleado">
                    <table class = "table" border = "2">
                                        <%
                    int id = Integer.parseInt(request.getParameter("id"));
                    
                    Empleado e = AccionesEmpleado.buscarEmpleadoById(id);
                    %>
                <tr>
                    <td>ID</td>
                    <td><input type="hidden" name="id2" value="<%=e.getId()%>" ></td>
                </tr>
                        
                        <tr>
                            <td>Nombre: </td>
                            <td><input type = "text" name = "nombre2" size = "30" value="<%=e.getNombre()%>"></td>
                        </tr>
                        <tr>
                            <td>Telefono Celular: </td>
                            <td><input type = "text" name = "cel2" size = "30" value="<%=e.getCel()%>"></td>
                        </tr>
                        <tr>
                            <td>Password: </td>
                            <td><input type = "password" name = "password2" size = "30" value="<%=e.getPassword()%>"></td>
                        </tr>
                        <tr>
                            <td>Email: </td>
                            <td><input type = "text" name = "email2" size = "30" value="<%=e.getEmail()%>" ></td>
                        </tr>
                        <tr>
                            <td>Pais: </td>
                            <td><select name="pais2">
                                    <option>Mexico</option>
                                    <option>EU</option>
                                    <option>Argentina</option>
                                    <option>Colombia</option>
                                    <option>Uruguay</option>
                                    <option>Brasil</option>
                                    <option>España</option>
                                
                                </select></td>    
                        </tr>
                        <tr>
                            <td colspan="2" ><input type="submit"
                                                    value="Actualizar Empleado"></td>
                        </tr>
                    </table>
                </form>
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
