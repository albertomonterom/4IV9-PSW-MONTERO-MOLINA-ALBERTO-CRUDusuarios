/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletsUsuario;

import Modelo.MUsuario;
import UsuarioControl.AccionesUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.sql.*;
import java.util.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author molin
 */
public class guardarUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            /*
            
            Generar la sesion del usuario
            
            */
            
            HttpSession sesionCli = request.getSession(true);
            
            String idsesion = sesionCli.getId();
            
            long fechacreacion = sesionCli.getCreationTime();
            
            long fechaultimoacceso = sesionCli.getLastAccessedTime();
            
                        //vamos a generar "cookie" de la sesion
            
            Integer cuenta = (Integer)sesionCli.getAttribute("cuenta.ss");
            
            if(cuenta == null){
                cuenta = new Integer(1);
            }else{
                cuenta = new Integer(cuenta.intValue()+1);
            }
            
            sesionCli.setAttribute("cuenta.ss", cuenta);
            
            //vamos a imprimir los valores de la sesion
            
            System.out.println("Id Sesion: "+idsesion);
            System.out.println("Fecha en que fue creada: " + new java.sql.Date(fechacreacion).toString());
            System.out.println("Fecha de ultimo acceso: "+ new java.sql.Date(fechaultimoacceso).toString());
            
            
                        //vamos a visualizar los parametros del hasmap
            
            Enumeration parametrosSesion = sesionCli.getAttributeNames();
            
            while(parametrosSesion.hasMoreElements()){
                String parametros = (String)parametrosSesion.nextElement();
                Object valor = sesionCli.getAttribute(parametros);
                System.out.println("El parametro es: " +parametros 
                                    + "Su valor es: " +valor.toString());
            }
            
            
            
            
            
            
            
            String nom, appat, apmat, cumple, email, dom, telfij, cel, pass;  
            int edad;

            nom = request.getParameter("nombre");
            appat = request.getParameter("appat");
            apmat = request.getParameter("apmat");
            cumple = request.getParameter("cumple");
            edad = Integer.parseInt(request.getParameter("edad"));
            email = request.getParameter("email");
            dom = request.getParameter("domicilio");
            telfij = request.getParameter("telfij");
            cel = request.getParameter("cel");
            pass = request.getParameter("password");
            
            
            MUsuario e = new MUsuario();
            e.setNombre(nom);
            e.setAppat(appat);
            e.setApmat(apmat);
            e.setCumple(cumple);
            e.setEdad(edad);
            e.setEmail(email);
            e.setDomicilio(dom);
            e.setTelfij(telfij);
            e.setCel(cel);
            e.setPassword(pass);
            
            
            
            int estatus = AccionesUsuario.registrarUsuario(e);
            
            if(estatus > 0){
                response.sendRedirect("registroempleados.jsp");
            }else{
                response.sendRedirect("error.jsp");
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
