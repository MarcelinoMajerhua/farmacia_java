
package dataAccesObject;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Pool {
    Connection con=null;
    private String url = "jdbc:mysql://localhost/farmacia"+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String usuario = "Farmacia";
    private String password = "966756538M@rcelin0";
    
    public Pool(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con=DriverManager.getConnection(url,usuario,password);
        }catch(Exception e){
            System.err.println("Error: " + e);
        }
        
    }
}
