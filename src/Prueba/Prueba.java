
package Prueba;

import control.Herramienta;
import java.text.ParseException;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Prueba {
    
    Herramienta h = new Herramienta();
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fecha = new java.util.Date();
        System.err.println(formato.format(fecha));
    }
}
