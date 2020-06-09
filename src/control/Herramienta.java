
package control;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class Herramienta {
    public Herramienta(){
    }
    
    public Date fechaSql(String fecha) throws ParseException{
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsed = formato.parse(fecha);
        java.sql.Date dateSql=new java.sql.Date(parsed.getTime());
        return dateSql;
    }
    

}
