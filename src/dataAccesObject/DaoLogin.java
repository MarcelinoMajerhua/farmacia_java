
package dataAccesObject;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import presentacion.UILogin;

public class DaoLogin {
    Pool metodosPool = new Pool();
    Statement st;
    ResultSet rs;
    public int validarIngreso(){
        int resultado =0;
        String usuario = UILogin.txtUsuario.getText();
        String clave = UILogin.txtPassword.getText().trim();
        try {
            st = metodosPool.con.createStatement();
            System.out.println("call mostrarUsuario("+usuario+","+clave+")");
            rs=st.executeQuery("call mostrarUsuario("+"'"+usuario+"'"+","+"'"+clave+"'"+")");
            
            if(rs.next()){
                resultado=1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "error de conexio", JOptionPane.ERROR_MESSAGE);
        }finally{
            try {
                metodosPool.con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "error de desconexio", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return resultado;
    }
}
