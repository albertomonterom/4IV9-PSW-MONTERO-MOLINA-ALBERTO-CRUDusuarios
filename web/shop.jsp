<%@page import="controllers.ControladorProducto"%>
<%
    ControladorProducto cp = new ControladorProducto();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">
        <link rel="stylesheet" href="assets/css/styles.css">
        <link rel="stylesheet" href="assets/css/iniciar.css">
        <link rel="shortcut icon" href="assets/img/logo_transparent(1).png"> 
        <title>B&J's IceCream</title>
    </head>
    <body>
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
                        <li class="nav__item"><a href="#promociones" class="nav__link">Promociones</a></li>
                        <li class="nav__item"><a href="iniciar.html" class="nav__link">Iniciar Sesión</a></li>
                    </ul>
                </div>
                <div>
                    <i class="fas fa-shopping-cart nav__cart"></i>
                    <i class="fas fa-bars nav__toggle" id="nav-toggle"></i>
                </div>
            </nav>
        </header>
        <main class="l-main">
            <section class="home" id="home">
                <div class="home__container bd-grid">
                    
                        <h1 class="home__tittle">HELADO<br><span>BROWNIE</span></h1>
                     
                         
                         <!--Cargar productos-->
                        

                         <%= cp.getProductos()%>
                         
                         

                        
                        <form class="formulario_menu_nap">
                            <select class="formulario_campo">
                                <option class="text_formulario" disabled selected>--Seleccionar tamaño--</option> 
                                <option>Chica</option> 
                                <option>Mediana</option> 
                                <option>Grande</option> 
                            </select> 
                            <input class="formulario_campo" type="number" placeholder="" min='1' max='10'>
                            <input class="button_submit" type="submit" value="AGREGAR AL CARRITO">
                        </form>

            </section>


        </main>
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
    </body>
</html>
