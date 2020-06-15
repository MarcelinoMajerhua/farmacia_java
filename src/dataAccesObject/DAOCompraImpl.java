
package dataAccesObject;

import datos.Compra;
import interfaces.DAOCompra;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOCompraImpl extends Conexion implements DAOCompra{
    private final String INSERT = "call comprar(?,?,?,?)";
    private final String SHOWSELL="call mostrarCompra(?,?,?)";
    public void registrar(Compra c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
