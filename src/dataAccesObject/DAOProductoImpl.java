
package dataAccesObject;

import datos.Producto;
import interfaces.DAOProducto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DAOProductoImpl extends Conexion implements DAOProducto{
    private final String INSERT = "insert into producto (nombre_producto,fecha_vencimiento,codigo_barra,stock,id_proveedor,precio)\n" +
"        values (?,?,?,?,?,?)";
    private final String UPDATE ="update producto set nombre_producto=?,\n" +
"        fecha_vencimiento=?,\n" +
"        codigo_barra=?,\n" +
"        stock=?,\n" +
"        id_proveedor=?,\n" +
"        precio=?\n" +
"        where id_producto= ?;";
    private final String DELETE ="delete from producto where id_producto=?";
    private final String SELECTALL="select*from producto";
    private final String SELECTONE="select*from producto where id_producto = ?";
    @Override
    public void registrar(Producto pr) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(INSERT);
            st.setString(1, pr.getNombre());
            st.setDate(2, pr.getFecha_vencimiento());
            st.setString(3, pr.getCodigo_barra());
            st.setInt(4,pr.getStock());
            st.setInt(5,pr.getId_proveedor());
            st.setFloat(6, pr.getPrecio());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        
    }

    @Override
    public void modificar(Producto pr) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(UPDATE);
            st.setString(1, pr.getNombre());
            st.setDate(2, pr.getFecha_vencimiento());
            st.setString(3, pr.getCodigo_barra());
            st.setInt(4, pr.getStock());
            st.setInt(5, pr.getId_proveedor());
            st.setFloat(6, pr.getPrecio());
            st.setInt(7, pr.getCodigo());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void eliminar(Producto pr) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(DELETE);
            st.setInt(1, pr.getCodigo());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
         
        }finally{
            this.cerrar();
        }
    }

    @Override
    public List<Producto> listar() throws Exception {
        List <Producto> lista;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(SELECTALL);
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Producto p = new Producto();
                p.setCodigo(rs.getInt("id_producto"));
                p.setCodigo_barra(rs.getString("codigo_barra"));
                p.setFecha_vencimiento(rs.getDate("fecha_vencimiento"));
                p.setId_proveedor(rs.getInt("id_proveedor"));
                p.setNombre(rs.getString("nombre_producto"));
                p.setPrecio(rs.getFloat("precio"));
                p.setStock(rs.getInt("stock"));
                lista.add(p);
                
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return lista;
    }

    @Override
    public List<Producto> listarUno(Producto pr) throws Exception {
        List <Producto> lista;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(SELECTONE);
            st.setInt(1,pr.getCodigo());
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                Producto p = new Producto();
                p.setCodigo(rs.getInt("id_producto"));
                p.setCodigo_barra(rs.getString("codigo_barra"));
                p.setFecha_vencimiento(rs.getDate("fecha_vencimiento"));
                p.setId_proveedor(rs.getInt("id_proveedor"));
                p.setNombre(rs.getString("nombre_producto"));
                p.setPrecio(rs.getFloat("precio"));
                p.setStock(rs.getInt("stock"));
                lista.add(p);
                
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return lista;
    }
    
}
