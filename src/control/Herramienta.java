
package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;



public class Herramienta {
    private String dia;
    private String mes;
    private String annio;
    private Date fechaHoy;
    
    public Herramienta(){
    }
    
    public Date fechaSql(String fecha) throws ParseException{
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsed = formato.parse(fecha);
        java.sql.Date dateSql=new java.sql.Date(parsed.getTime());
        return dateSql;
    }
    
     public void validarSoloNumeros(JTextField campo){
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                }
            }           
        });
    }
     
    public Date fechaHoy(){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fecha = new java.util.Date();
        java.sql.Date dateSql=new java.sql.Date(fecha.getTime());
        
        return dateSql;
    }
    

}
