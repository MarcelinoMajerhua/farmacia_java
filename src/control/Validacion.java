package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//import presentacion.pnlEmpleados;

public class Validacion {

    public void validarSoloLetras(JTextField campo){
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                int k =(int)e.getKeyChar();
                if(Character.isDigit(c)|| k>=33 && k<=64 || k>=91 && k<=96 || k>=123 ){
                    e.consume();
                }
            }            
        });
    }
    
   public void validarLetrasyNumeros(JTextField campo){
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                int k =(int)e.getKeyChar();
                if(k>=33 && k<=47 || k>=57 && k<=64 || k>=91 && k<=96 || k>=123 ){
                    e.consume();
                }
            }   
        });
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
    public void limitarCaracteres(JTextField campo, int tamanio){
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                int cantidad = campo.getText().length();
                if(cantidad>=tamanio){
                    e.consume();
                }
            }           
        });
    }
     public static String strPreguntaSiNo(String strMensaje){
         int seleccion = JOptionPane.showOptionDialog(null, 
                 strMensaje, 
                 "Seleccione una opción",
                 JOptionPane.YES_NO_CANCEL_OPTION ,
                 JOptionPane.QUESTION_MESSAGE,
                 null, 
                 new Object[]{"Si","No"},
                 "Si");
         if(seleccion!=-1){
             if((seleccion+1)==1){
                 return "Si";
             }else{
                 return "No";
             }           
         }
         return null;   
     }
}

