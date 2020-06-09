
package dataAccesObject;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexion {
    Connection conexion=null;
    private final String NameClass ="com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost/farmacia"+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String usuario = "Farmacia";
    private final String password = "966756538M@rcelin0";
    
    
    public void conectar() throws Exception{
        try {
            conexion = DriverManager.getConnection(url,usuario,password);
            Class.forName(NameClass);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }
    
    public void cerrar() throws SQLException{
        if(conexion!=null){
            if(!conexion.isClosed()){
                conexion.close();
            }
        }
    }
}
