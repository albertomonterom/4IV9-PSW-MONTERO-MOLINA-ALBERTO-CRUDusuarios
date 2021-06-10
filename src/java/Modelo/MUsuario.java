/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author molin
 */
import Control.Conexion;
import java.sql.*;

public class MUsuario {
    
    /*
    id_usuario, nombre_usuario, appat_usuario
    apmat_usuario, fecha_nacimiento_usuario, tel_usuario
    cel_usuario, dir_usuario, user_usuario, pass_usuario 
    privilegio_usuario
    */
    
    
    
    private int id, edad;
    private String nombre, appat, apmat, cumple, email, domicilio, telfij, cel, password;


    public MUsuario (){
   
    }
    
    //CRUD usuario
    
    //un metodo para verificar el tipo de usuario segun el privilegio

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAppat() {
        return appat;
    }

    public void setAppat(String appat) {
        this.appat = appat;
    }

    public String getApmat() {
        return apmat;
    }

    public void setApmat(String apmat) {
        this.apmat = apmat;
    }

    public String getCumple() {
        return cumple;
    }

    public void setCumple(String cumple) {
        this.cumple = cumple;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelfij() {
        return telfij;
    }

    public void setTelfij(String telfij) {
        this.telfij = telfij;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    
    
}
