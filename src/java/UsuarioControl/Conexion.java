/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UsuarioControl;

/**
 *
 * @author molin
 */
import java.sql.*;

public class Conexion {
        public static Connection getConnection(){
        String url, userName, password;
        
        url = "jdbc:mysql://localhost/usuarios";
        userName = "root";
        password = "Montero.69";
        
        Connection con = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection(url, userName, password);
            
            System.out.println("Conexion Exitosa con la BD");
        
        }catch(Exception e){
            System.out.println("Error al conectar la BD");
            System.out.println(e.getMessage());
        
        }
        return con;
    }
    
}
