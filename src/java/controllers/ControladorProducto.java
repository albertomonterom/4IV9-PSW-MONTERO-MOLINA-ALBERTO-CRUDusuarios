/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import classes.Producto;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ModeloProducto;

/**
 *
 * @author molin
 */
public class ControladorProducto {
    public String getProductos() {
        ModeloProducto mp = new ModeloProducto();
        String htmlcode = "";
        try {
            for(Producto producto : mp.getAllProductos()) {
                htmlcode += "<div class=\"home__container bd-grid\">\n" +
                        "                    <div class=\"home__data_nap\">\n" +
                        "                        <h1 class=\"home__tittle\">"+producto.getNombre()+"</h1>\n" +
                        "                     <div class=\"producto\">\n" +
                        "                            <img src=\""+producto.getImg()+"\" alt=\"\" class=\"img_producto_cho\">\n" +
                        "                            \n" +
                        "                        <div class=\"paleta_contenido_nap\">\n" +
                        "                            En BEN and JERRY'S…¡el brownie es redondo! \n" +
                        "                            <h1 class = \"precio_sabores\">$"+producto.getPrecio()+"</h1>\n" +
                        "                        </div>\n" +
                        "                            \n" +
                        "\n" +
                        "                        \n" +
                        "                        <form class=\"formulario_menu_nap\">\n" +
                        "                            <select class=\"formulario_campo\">\n" +
                        "                                <option class=\"text_formulario\" disabled selected>--Seleccionar tamaño--</option> \n" +
                        "                                <option>Chica</option> \n" +
                        "                                <option>Mediana</option> \n" +
                        "                                <option>Grande</option> \n" +
                        "                            </select> \n" +
                        "                            <input class=\"formulario_campo\" type=\"number\" placeholder=\"\" min='1' max='10'>\n" +
                        "                            <input class=\"button_submit\" type=\"submit\" value=\"AGREGAR AL CARRITO\">\n" +
                        "                        </form>\n" +
                        "                     </div>\n" +
                        "                        \n" +
                        "                </div>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return htmlcode;
    
    }
    
}
