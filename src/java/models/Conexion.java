/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.*;

/**
 *
 * @author molin
 */
public class Conexion {
    
    private String username = "root";
    private String password = "Montero.69";
    private String hostname = "localhost";
    private String port = "3306";
    private String database = "carritojsp";
    private String classname = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://"+hostname+":"+port+"/"+database;
    private Connection conn;
    
    public Conexion() {
    try{
        Class.forName(classname);
        conn = DriverManager.getConnection(url, username, password);
    
    }catch (Exception e) {
        System.out.println(e.getMessage());
    }
    
    
    }
    
    public Connection getConnection() {
        return this.conn;
    
    }

}


