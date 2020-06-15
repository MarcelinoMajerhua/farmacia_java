
package dataAccesObject;

import datos.Venta;
import interfaces.DAOVenta;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DAOVentaImpl extends Conexion implements DAOVenta{
    private final String INSERT="call vender(?,?,?,?)";
    private final String SHOWSELL="call mostrarVenta(?,?,?)";
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
    public List<Object> listarVenPersonal(String accion,int id,Date fecha) throws Exception {
        List<Object> lista;
        try {
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement(SHOWSELL);
            st.setString(1, accion);
            st.setInt(2, id);
            st.setDate(3, fecha);
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object[] item={
                    rs.getString("Nombre vendedor"),
                    rs.getString("Nombre producto"),
                    rs.getInt("Cantidad vendida"),
                    rs.getFloat("Precio total venta"),
                    rs.getDate("fecha"),
                };
                lista.add(item);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return lista;
    }
    
}
