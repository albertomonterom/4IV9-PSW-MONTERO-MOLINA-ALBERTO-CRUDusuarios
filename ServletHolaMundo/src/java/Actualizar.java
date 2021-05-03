/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//esta se encarga del objeto para la conexión con la bd
import java.sql.Connection;
import java.sql.DriverManager;
//esta se encarga de poder realizar las sentencias sql como son:
//insert, delete, update, create, alter, drop

import java.sql.Statement;
//esta se encarga de generar un objeto para poder realizar las consultas
import java.sql.ResultSet;
import javax.servlet.ServletConfig;

/**
 *
 * @author molin
 */
public class Actualizar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        private Connection con;
        private Statement set;
        private ResultSet rs;
        
        
            //constructor: para poder inicializar
    public void init(ServletConfig cfg) throws ServletException{
                //como se va a conectar a la bd
                
                String url = "jdbc:mysql:3306//localhost/registro4IV9";
                            //tipodriver:gestorbd:puerto//IP/nombrebd                                                       
                String userName = "root";
                String password = "Montero.69";                
                try{           
                    Class.forName("com.mysql.jdbc.Driver");
                    /*A veces el tipo de driver ya tiene incluido el puerto de comunicación,
                    es por ello que nos arroja un error de conexión, para resolver este error 
                    simplemente hacemos lo siguiente
                    
                    url = "jdbc:mysql://localhost/registro4IV9";
                    */
                    
                    url = "jdbc:mysql://localhost/registro4IV9";    
                    con = DriverManager.getConnection(url, userName, password);
                    set = con.createStatement();                   
                    System.out.print("Conexión exitosa");
                    
                }catch(Exception e){                  
                    System.out.println("Conexión no exitosa");
                    System.out.println(e.getMessage());
                    //StackTrace no sidce donde está el error
                    System.out.println(e.getStackTrace());    
                }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Modificar</title>"
                    + "<link rel='stylesheet' href='masterstyle.css'>"
                    + "<script src='validar.js'></script>");            
            out.println("</head>");
            out.println("<body>");
             out.println("<h1>Tabla del Registro de Usuarios</h1>"
                    + "<table border='2'>"
                    + "<thead>"
                        + "<tr>"
                        + "<th>ID</th>"
                        + "<th>Nombre Completo</th>"
                        + "<th>Edad</th>"
                        + "<th>Correo</th>"
                        + "</tr>"
                    + "<thead>"
                    + "<tbody>");
            String nom, appat, apmat, correo, q, qq;
            int edad, id;
            id = Integer.parseInt(request.getParameter("idmodificar"));
            q = "select * from mregistro where id_usu = "+id;
             try{
                set = con.createStatement();
                rs = set.executeQuery(q);
                while(rs.next()){
                    id = rs.getInt("id_usu");
                    nom = rs.getString("nom_usu");
                    appat = rs.getString("appat_usu");
                    apmat = rs.getString("apmat_usu");
                    edad = rs.getInt("edad_usu");
                    correo = rs.getString("email_usu");
                    out.println("<tr>"
                                + "<td>"+id+"</td>"
                                + "<td>"+nom+" "+appat+" "+apmat+"</td>"
                                + "<td>"+edad+"</td>"
                                + "<td>"+correo+"</td>"
                            + "</tr>"
                            +"<br>");
                    out.println("</tbody>"
                    + "</table>"
                    + "<br>"
                            +"<form name='formularioModificar' method='post' action='Actualizar_2'>"
                            +"<h2>Modifique los datos</h2>"
                            +"<h2>ID</h2>"
                     +"<input type='text' onkeypress='return validarNumeros(event)' value='"+id+"' name ='id_modificar'>"
                             +"<br>"
                            +"<h2>Nombre</h2>"
                     +"<input type='text' onkeypress='return validarLetras(event)' value='"+nom+"' name ='nom_modificar'>"
                             +"<br>"
                              +"<h2>Apellido Paterno</h2>"
                     +"<input type='text' onkeypress='return validarLetras(event)' value='"+appat+"' name ='appat_modificar'>"
                             +"<br>"
                              +"<h2>Apellido Materno</h2>"
                     +"<input type='text' onkeypress='return validarLetras(event)' value='"+apmat+"' name ='apmat_modificar'>"
                             +"<br>"
                              +"<h2>Edad</h2>"
                     +"<input type='text' onkeypress='return validarNumeros(event)' value='"+edad+"' name ='edad_modificar'>"
                             +"<br>"
                              +"<h2>Correo</h2>"
                     +"<input type='email' value='"+correo+"' name ='correo_modificar'>"
                             +"<br>"
                             +"<br>"
                             +"<input type='submit' value='Modificar Registro'>"
                             +"<br>"
                             +"</form>"
                    + "<a href='index.html' >Regresar al Menu Principal</a>"
                    + "<br>");
                }
                System.out.println("Modificacion exitosa");
                rs.close();
                set.close();
            }catch(Exception e){
                System.out.println("Error al realizar la modificacion");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
    public void destroy(){
        try{
            con.close();
        }catch(Exception e){
            super.destroy();
        }
    }    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}