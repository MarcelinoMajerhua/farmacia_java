
package dataAccesObject;

import datos.Proveedor;
import interfaces.DAOProveedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOProveedorImpl extends Conexion implements DAOProveedor{
    private final String SELECT ="call mostrarProveedor(?,?)";
    @Override
    public List<Proveedor> listar() throws Exception {
        List<Proveedor> lista;
        try {
            this.conectar();
            lista = new ArrayList();
            PreparedStatement st = this.conexion.prepareStatement(SELECT);
            st.setString(1, "todo");
            st.setInt(2, 0);
            st.executeUpdate();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Proveedor pv = new Proveedor();
                pv.setIdProveedor(rs.getInt("id_proveedor"));
                pv.setDetalleProveedor(rs.getString("detalle"));
                pv.setDireccionProveedor(rs.getString("direccion_proveedor"));
                pv.setNombreProveedor(rs.getString("nombre_proveedor"));
                pv.setTelefonoProveedor(rs.getString("telefono_proveedor"));
                lista.add(pv);
            };
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return lista;
    }

    @Override
    public List<Proveedor> listarUno(int id) throws Exception {
        List<Proveedor> lista;
        try {
            this.conectar();
            lista = new ArrayList();
            PreparedStatement st = this.conexion.prepareStatement(SELECT);
            st.setString(1, "unitario");
            st.setInt(2, id);
            st.executeUpdate();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Proveedor pv = new Proveedor();
                pv.setIdProveedor(rs.getInt("id_proveedor"));
                pv.setDetalleProveedor(rs.getString("detalle"));
                pv.setDireccionProveedor(rs.getString("direccion_proveedor"));
                pv.setNombreProveedor(rs.getString("nombre_proveedor"));
                pv.setTelefonoProveedor(rs.getString("telefono_proveedor"));
                lista.add(pv);
            };
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return lista;
    }

    @Override
    public void insertar(Proveedor pr) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
