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
public class Eliminar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
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
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Eliminar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Eliminar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            
            
            
            
                        int id;
            
            id = Integer.parseInt(request.getParameter("ideliminar"));
            
            String q= "delete from mregistro where id_usu = "+id;
            
            try{
                
                set.execute(q);
                out.println("<h1>USUARIO ELIMINADO</h1>"
                    + "<br>"
                    + "<a href = 'index.html'>Regresar al menu principal</a>"
                    + "<br>"
                    + "<a href = 'Registro'>Ir al registro</a>");
                
            }catch(Exception e){
                
                out.println("<h1>USUARIO NO ELIMINADO, OCURRIO UN ERROR</h1>");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
                
            }
            
            out.println("</body>");

            
            out.println("</html>");
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
