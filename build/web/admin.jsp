 <%-- 
    Document   : admin
    Created on : 6/05/2021, 04:35:05 PM
    Author     : molin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" import="java.sql.*, java.util.*, java.text.*"%>
  
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
            <div class="contenedor-todo">
                <form action="" class="formulario1">
                    <section class="formulario1-section">
                        <form action="">
                <div>
                    <div class="botones">
                        <div class="boton2" onclick="agregarHelado()"><i class="fas fa-ice-cream"></i> <div class="espacio"></div>Agregar Helado</div>
                    </div>

                    <table border="2" border: 2px solid black; border-radius: 13px; padding: 19px; font-size: 24px;">

                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Helado</th>
                                <th>Precio</th>
                                <th>Actualizar Datos</th>
                                <th>Borrar</th>
                            </tr>
                        </thead>

                        <tbody>

                            <%
        Connection con = null;
        Statement set = null;
        ResultSet rs = null;
        
        String url, userName, password, driver;
        url = "jdbc:mysql://localhost/registro";
        userName = "root";
        password = "Montero.69";
        driver = "com.mysql.jdbc.Driver";
        
                                try {
                                    Class.forName(driver);
                                    con = DriverManager.getConnection(url, userName, password);
                                    try {
                                        String q = "select * menu";
                                        set = con.createStatement();
                                        rs = set.executeQuery(q);
                                        while (rs.next()) {
                            %>

                            <tr>
                                <td><%= rs.getInt("id")%></td>
                                <td><%= rs.getString("helado")%></td>
                                <td><%= rs.getInt("precio")%></td>

                                <td style="padding: 30px;"> 
                                    <a class="" href="actualizar.jsp?id=<%=rs.getInt("id")%>">Editar</a>
                                </td>
                                <td style="padding: 30px;">
                                    <a class="" href="borrar.jsp?id=<%=rs.getInt("id")%>"> Borrar </a>
                                </td>
                            </tr>
                            
                            
                            
                            

                            <%
                                        }
                                        rs.close();
                                        set.close();
                                    } catch (SQLException ed) {
                                        System.out.println("Error al consultar la tabla");
                                        System.out.println(ed.getMessage());
                                    }
                                    con.close();
                                } catch (Exception e) {
                                    System.out.println("Error al conectar con la bd");
                                    System.out.println(e.getMessage());
                                    System.out.println(e.getStackTrace());
                                }
                            %>

                        </tbody>

                    </table>

                </div>
                        </form>
                    </section>
                </form>
            </div>
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