/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UsuarioControl;


import static MVCcontrol.Conexion.getConnection;
import Modelo.MUsuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author molin
 */
public class AccionesUsuario {
        /*
    Son todas las operaciones o requerimientos funcionales con que el usuario operara el sistema
    
    registrarEmpleado -> Empleado e
    actualizarEmpleado  -> Empleado e
    eliminarEmpleado  -> int id
    buscarEmpleadoporID -> int id
    buscarTodoslosEmpleados -> ??arraylist
    VerificarUsuario -> String user, pass
    
    */
    public static int registrarUsuario(MUsuario e){
        int estatus = 0;
        
        
        try{
            
            Connection con = Conexion.getConnection();
            
            String q = "insert into usuarios(nom_usu, appat_usu, apmat_usu, cumple_usu, edad_usu, email_usu, dom_usu, telfij_usu, cel_usu, contra_usu) "
                    + "values(?,?,?,?,?,?,?,?,?,?)";
            
            
            PreparedStatement ps = con.prepareStatement(q);
            //usar getter and setter
            
            
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getAppat());
            ps.setString(3, e.getApmat());
            ps.setString(4, e.getCumple());
            ps.setInt(5, e.getEdad());
            ps.setString(6, e.getEmail());
            ps.setString(7, e.getDomicilio());
            ps.setString(8, e.getTelfij());
            ps.setString(9, e.getCel());
            ps.setString(10, e.getPassword());
            
            
            
            estatus = ps.executeUpdate();
            System.out.println("Registro Exitoso del Usuario");
            con.close();
            

        
        }catch(Exception ed){
            
            System.out.println("Error al registrar al Usuario");
            System.out.println(ed.getMessage());
            
        }
        return estatus;
    }
    
    public boolean autenticacion(String cel, String password) {
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String consulta = "select * from usuarios where cel_usu = ? and contra_usu = ?";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, cel);
            pst.setString(2, password);
            rs = pst.executeQuery();

            if (rs.absolute(1)) {
                return true;
            }

        } catch (Exception e) {
            System.err.println("Error" + e);
        } finally {
            try {
                if (getConnection() != null) {
                    getConnection().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error" + e);
            }
        }

        return false;
    }

    
}
