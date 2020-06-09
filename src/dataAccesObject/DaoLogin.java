
package dataAccesObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import presentacion.UILogin;

public class DaoLogin extends Conexion{
    private final String CONSULTA ="select id_usuario,activo from usuario where (email=?)and(contraseña=?)";
    public int validarIngreso(){
        
        int resultado =0;
        String usuario = UILogin.txtUsuario.getText();
        String clave = UILogin.txtPassword.getText().trim();
        
        try {
            
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement(CONSULTA);
            st.setString(1, usuario);
            st.setString(2, clave);
            ResultSet rs = st.executeQuery();
            if(rs.next()&&rs.getBoolean("activo")){
                resultado=1;
                this.cerrar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "error de conexio", JOptionPane.ERROR_MESSAGE);
        }
        
        return resultado;
    }
}
