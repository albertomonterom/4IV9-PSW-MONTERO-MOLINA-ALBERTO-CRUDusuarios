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
public class Registro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request se encargará de atender las peticiones del cliente
     * @param response servlet response se encargará de atender las respuestas por parte del servidor
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //variables globales
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
    
    //la tabla que creamos se llama mregistro
    /*
    PARA CREAR UNA TABLE EN MySQL
    
    1. create database Nombre de la bd;
    ->Para usarla escribimos lo siguiente
    2. use Nombre de la bd;
    ->Para crear una tabla
    3. create table Nombre de la tabla;
    ->Para mostrar las tablas en la base de datos una vez allí 
    4. show tables;
    ->Para seleccionar la tabla en esa base de datos:
    3. select * from Nombre de la tabla;
    el asterisco significa que se selecciona todas las columnas 
    si quiero seleccionar una colunma en específico
    
    Entonces:
    select * nombredelacolumna from nombre de la tabla 
    Entonces 
    select * nombredelacolumna, nombredela2columna from nombre de la tabla 
    Podemos ordenar la tabla ordenandolas mediante un atributo 
    
    ejemplo:
    select * nombredelacolumna, nombredela2columna from nombre de la tabla order by nombre de algun atributo
    
    
    select * from mregistro
    ->selecciona todo de la tabla "mregistro"
    
    
    Extra:
    Para ver los atributos 
    
    ->describe Nombre de la tabla;
    */
    
    
    /*
    CRUD
    C->Crear->Crear
    R->Read->Leer
    U->Update->Actualizar
    D->Delete->Eliminar
    */

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String nom, appat, apmat, correo, ip, ipr;
            int edad, puerto, puertor;
            

            
            nom = request.getParameter("nombre");
            appat = request.getParameter("appat");
            apmat = request.getParameter("apmat");
            edad = Integer.parseInt(request.getParameter("edad"));
            correo = request.getParameter("correo");
            
            
            /*local address*/
            ip = request.getLocalAddr();
            puerto = request.getLocalPort();
            
            ipr = request.getRemoteAddr();
            puertor = request.getRemotePort();
            
            //vamos a registrar en la bd
            try{
                
                                    /*
                    Para poder registrar usuario es necesario la sentencia insert
                    bajo el siguiente esquema:
                    
                    insert into nombretabla (atributo1, atributo2, ...) values("valor1"), ("valor2"), ("valor3")
                    
                    ""son para valores de tipo cadena
                    ''numerico
                    nada numerico
                    */
                    
                    
                
            String q = "insert into mregistro "
                    + "(nom_usu, appat_usu, apmat_usu, edad_usu, email_usu)"
                    + "values"
                    + "('"+nom+"', '"+appat+"', '"+apmat+"', "+edad+", '"+correo+"')";
            
            
            set.executeUpdate(q);
                System.out.println("Registro exitoso en la tabla");
            
            

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registro</title>");            
            out.println("</head>");
            out.println("<body>"
                    + "<br>"
                    + "Tu nombre es:"+nom
                    + "<br>"
                    + "Tu apellido paterno es:"+appat
                    + "<br>"
                    + "Tu apellido materno es: "+apmat
                    + "<br>"
                    + "Tu edad es: "+edad
                    + "<br>"
                    + "Tu email es: "+correo
                    + "<br>"
                    + "IP Local: "+ip
                    + "<br>"
                    + "Puerto Local: "+puerto
                    + "<br>"
                    + "IP Remota: "+ipr
                    + "<br>"
                    + "Puerto Remoto: "+puertor
                    + "<br>");

            out.println("<h1>Registro Exitoso</h1>"
                    + "<a href='index.html'>Regresar al menú principal</a>");
            out.println("</body>");
            out.println("</html>");
            
            }catch(Exception e){
                System.out.println("Error al registrar en la tabla");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
                
                            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registro</title>");            
            out.println("</head>");
            out.println("<body>"
            + "<br>");

            out.println("<h1>Registro no exitoso, ocurrio un error</h1>"
                    + "<a href='index.html'>Regresar al Menú principal</a>");
            out.println("</body>");
            out.println("</html>");
                
                
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
