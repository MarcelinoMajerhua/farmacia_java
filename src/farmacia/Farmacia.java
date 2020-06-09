/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;

import com.sun.awt.AWTUtilities;
import control.Herramienta;
import dataAccesObject.DAOProductoImpl;
import dataAccesObject.DAOUsuarioImpl;
import datos.Producto;
import datos.Usuario;
import interfaces.DAOProducto;
import interfaces.DAOUsuario;
import java.sql.Date;
import java.text.SimpleDateFormat;


public class Farmacia {

    
    public static void main(String[] args) {
        /*
        Usuario us = new Usuario();
        try {
            DAOUsuario dao = new DAOUsuarioImpl();
            for(Usuario u: dao.listar()){
                System.out.println(u.getEmail());
            }
             
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }*/
        
        presentacion.UILogin i;
        i=new presentacion.UILogin();
        i.setVisible(true);
    }
    
}
