
package dataAccesObject;

import datos.Usuario;
import interfaces.DAOUsuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DAOUsuarioImpl extends Conexion implements DAOUsuario{
    private final String INSERT = "insert into usuario(email,contraseña,telefono_usuario,nombre,categoria,activo)"+
            "values(?,?,?,?,?,?)";
    private final String UPDATE ="update usuario set email=?,contraseña=?,telefono_usuario=?,nombre=?,categoria=?, activo=?"+
            " where id_usuario=?";
    
    private final String DELETE = "delete from usuario where id_usuario=?;";
    private final String SELECTALL ="select id_usuario,email,telefono_usuario,nombre,categoria,activo from usuario";
    private final String SELECTONE = "select id_usuario,email,telefono_usuario,nombre,categoria,activo from usuario where id_usuario=?";
    @Override
    public void registrar(Usuario usu) throws Exception {
        try {
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement(INSERT);
            st.setString(1, usu.getEmail());
            st.setString(2, usu.getContraseña());
            st.setString(3, usu.getTelefono());
            st.setString(4, usu.getNombre());
            st.setBoolean(5, usu.getCategoria());
            st.setBoolean(6, usu.getActivo());
            st.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void modificar(Usuario usu) throws Exception {
        try {
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement(UPDATE);
            st.setString(1, usu.getEmail());
            st.setString(2, usu.getContraseña());
            st.setString(3, usu.getTelefono());
            st.setString(4, usu.getNombre());
            st.setBoolean(5, usu.getCategoria());
            st.setBoolean(6, usu.getActivo());
            st.setInt(7,usu.getId_modificar());
            st.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void eliminar(Usuario usu) throws Exception {
        try {
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement(DELETE);
            st.setInt(1, usu.getId_modificar());
            st.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public List<Usuario> listar() throws Exception {
        List<Usuario> lista;
        
        try {
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement(SELECTALL);
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();//para crear nuevo objetos se tiene que instaciar la veces que queremos 
                //select id_usuario,email,telefono_usuario,nombre,categoria,activo from usuario
                usuario.setId_modificar(rs.getInt("id_usuario"));
                usuario.setEmail(rs.getString("email"));
                usuario.setTelefono(rs.getString("telefono_usuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCategoria(rs.getBoolean("categoria"));
                usuario.setActivo(rs.getBoolean("activo"));
                lista.add(usuario);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return lista;
    }

    @Override
    public List<Usuario> mostrarUno(Usuario usu) throws Exception {
         List<Usuario> lista;
        try {
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement(SELECTONE);
            st.setInt(1, usu.getId_modificar());
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                //select id_usuario,email,telefono_usuario,nombre,categoria,activo from usuario
            
                Usuario usuario = new Usuario();
                usuario.setId_modificar(rs.getInt("id_usuario"));
                usuario.setEmail(rs.getString("email"));
                usuario.setTelefono(rs.getString("telefono_usuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCategoria(rs.getBoolean("categoria"));
                usuario.setActivo(rs.getBoolean("activo"));
                lista.add(usuario);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return lista;
    } 
}
