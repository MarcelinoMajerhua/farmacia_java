
package dataAccesObject;

import datos.Compra;
import interfaces.DAOCompra;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOCompraImpl extends Conexion implements DAOCompra{
    private final String INSERT = "call comprar(?,?,?,?,?)";
    private final String SHOWSELL="call mostrarCompra(?,?,?)";
    public void registrar(Compra c) throws Exception {
        try {
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement(INSERT);
            st.setInt(1, c.getCamtidadComprada());
            st.setFloat(2, c.getPrecioTotalCompra());
            st.setInt(3, c.getIdProducto());
            st.setInt(4, c.getIdUsuario());
            st.setDate(5, c.getFechaCompra());
            st.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public List<Object> listarConPersonal(String accion, int id, Date fecha) throws Exception {
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
                    rs.getInt("Cantidad comprada"),
                    rs.getFloat("Precio total compra"),
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
