
package dataAccesObject;

import datos.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import presentacion.UILogin;

public class DaoLogin extends Conexion{
    private final String CONSULTA ="select nombre,categoria,id_usuario,activo from usuario where (email=?)and(contraseña=?)";

    public Usuario validarIngreso(){
        
        int resultado =0;
        String nombre;
        boolean categoria;
        int id_usuario;
        boolean activo;
        Usuario us = new Usuario();
        String usuario = UILogin.txtUsuario.getText();
        String clave = UILogin.txtPassword.getText().trim();
        
        try {
            
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement(CONSULTA);
            st.setString(1, usuario);
            st.setString(2, clave);
            ResultSet rs = st.executeQuery();
            if(rs.next()&&rs.getBoolean("activo")){
                us.setLogueado(true);
                us.setActivo(rs.getBoolean("activo"));
                us.setCategoria(rs.getBoolean("categoria"));
                us.setId_modificar(rs.getInt("id_usuario"));
                us.setNombre(rs.getString("nombre"));
                this.cerrar();
            }else{
                us.setActivo(false);
                us.setLogueado(false);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "error de conexio", JOptionPane.ERROR_MESSAGE);
        }
        
        return us;
    }
}
