
package dataAccesObject;

import datos.Venta;
import interfaces.DAOVenta;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;


public class DAOVentaImpl extends Conexion implements DAOVenta{
    private final String SELECTALL="";
    private final String INSERT="call vender(?,?,?,?)";
    @Override
    public void registrar(Venta v) throws Exception {
        try {
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement(INSERT);
            st.setInt(1, v.getCandidadVenta());
            st.setInt(2, v.getIdProducto());
            st.setInt(3, v.getIdUsuario());
            st.setDate(4, v.getFechaVenta());
            st.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public List<Venta> listar() throws Exception {
        List<Venta> list = new ArrayList();
        return list;
    }
    
}
