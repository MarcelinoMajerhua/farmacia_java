
package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JTextField;




public class Herramienta {
    
    public Herramienta(){
    }
    
    public java.util.Date cambiarFormato(String fecha) throws ParseException{
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsed = formato.parse(fecha);
        return parsed;
    }
    
    public Date cambiarFechaDateSql(java.util.Date fecha) throws ParseException{
        java.sql.Date dateSql=new java.sql.Date(fecha.getTime());
        return dateSql;
    };
    
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
     public void validarSoloNumerosFlotante(JTextField campo){
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(c=='.'){
                    c='1';
                };
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
    public boolean esVacio(String campo){
        boolean campoVacio=false; //lleno
        System.out.println(campo.replaceAll("\\s",""));
        if(campo.replaceAll("\\s","").equals("")){//entra cuando esta vcio 
            campoVacio=true;
        };
        return campoVacio;
    };
    public int esPunto(String campo){
        int numeroPunto=0;
        if(campo.length()>0){
            for(int i=0;i<campo.length();i++){
                if(campo.charAt(i)=='.'&&numeroPunto<2){
                    numeroPunto++;
                };
            };
        };
        return numeroPunto;
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
    public boolean esDiferente(String original,String nuevo){
        boolean resp = false;
        if(!original.replaceAll("\\s","").equals(nuevo.replaceAll("\\s",""))){
            resp = true;
        }
        return resp;
    };

}
