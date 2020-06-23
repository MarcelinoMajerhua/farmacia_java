
package dataAccesObject;

import datos.Producto;
import interfaces.DAOProducto;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DAOProductoImpl extends Conexion implements DAOProducto{
    private final String INSERT = "insert into producto (nombre_producto,fecha_vencimiento,codigo_barra,stock,id_proveedor,precio,tipo_producto)\n" +
"        values (?,?,?,?,?,?,?)";
    private final String DELETE ="delete from producto where id_producto=?";
    private final String SELECTALLSHELL="select*from producto where fecha_vencimiento >= curdate()";
    private final String SELECTALLPRODUCT="select*from producto";
    private final String SELECTONE="select*from producto where id_producto = ?";
    private final String EXISTENCE = "call evaluarExistenciaProducto(?,?)";
    private final String ADD ="update producto set stock=stock+? where id_producto=?";
    private final String SHEARNAME = "select*from producto where nombre_producto=?";
    private final String SHEARCB = "select*from producto where codigo_barra=?";
    private final String SHEARCHID ="select id_producto from producto where (nombre_producto=?) and (tipo_producto=?) and (codigo_barra=?);";
    private final String SELECTVENCIDO="select* from producto where fecha_vencimiento < curdate()";
    private final String SELECTVENCER="select * from producto where (day(fecha_vencimiento)-day(curdate())>0)and(day(fecha_vencimiento)-day(curdate())<11)and(month(fecha_vencimiento)-month(curdate())=0)and(year(fecha_vencimiento)-year(curdate())=0)";
    private final String LOWSTOCK ="select * from producto where stock<=10";
    private final String UPDATEDATE ="update producto set fecha_vencimiento=? where (?<=fecha_vencimiento) and (id_producto=?)";
    @Override
    public void registrar(Producto pr) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(INSERT);
            st.setString(1, pr.getNombre());
            st.setDate(2, pr.getFecha_vencimiento());
            st.setString(3, pr.getCodigo_barra());
            st.setInt(4,0);
            st.setInt(5,pr.getId_proveedor());
            st.setFloat(6, pr.getPrecio());
            st.setString(7, pr.getTipo_producto());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        
    }

    @Override
    public void modificar(Producto pr) throws Exception {
        String UPDATE="update producto set nombre_producto='"+pr.getNombre()+"',fecha_vencimiento='"+pr.getFecha_vencimiento()+"',codigo_barra='"+pr.getCodigo_barra()+"',id_proveedor='"+pr.getId_proveedor()+"',precio='"+pr.getPrecio()+"',tipo_producto='"+pr.getTipo_producto()+"' where id_producto="+pr.getCodigo();
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(UPDATE);
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
            PreparedStatement st = this.conexion.prepareStatement(SELECTALLSHELL);
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
                p.setTipo_producto(rs.getString("tipo_producto"));
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
                p.setTipo_producto(rs.getString("tipo_producto"));
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
    public List<Producto> buscarProducto(String pr) throws Exception {
        List <Producto> lista;
        String SEARCHONE ="select*from producto where nombre_producto LIKE '%"+pr+"%' or fecha_vencimiento LIKE '%"+pr+"%' or precio LIKE '%"+pr+"%' or tipo_producto LIKE '%"+pr+"%' or codigo_barra LIKE '%"+pr+"%' limit 20";
        try {
            this.conectar();
            lista = new ArrayList();
            PreparedStatement st = this.conexion.prepareStatement(SEARCHONE);
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
                p.setTipo_producto(rs.getString("tipo_producto"));
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
    public int evaluarExistencia(String nombreP, String codigoB) throws Exception {
        int cont=0;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(EXISTENCE);
            st.setString(1, nombreP);
            st.setString(2, codigoB);
            st.executeUpdate();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                cont++;
            };
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return  cont;
    }

    @Override
    public void agregarStock(int cantidad, int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(ADD);
            st.setInt(1, cantidad);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public boolean evaluarExistenciaNombre(String nombre) throws Exception {
        boolean res = false;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(SHEARNAME);
            st.setString(1, nombre);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                res = true;
            };
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return res;
}

    @Override
    public boolean evaluarExistenciaCB(String codigoB) throws Exception {
        boolean res = false;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(SHEARCB);
            st.setString(1, codigoB);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                res = true;
            };
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return res;
    }

    @Override
    public int recuperarCodigo(Producto pr) throws Exception {
        int id=0;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(SHEARCHID );
            st.setString(1, pr.getNombre());
            st.setString(2, pr.getTipo_producto());
            st.setString(3, pr.getCodigo_barra());
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                id = rs.getInt("id_producto");
            };
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return id;
    }

    @Override
    public List<Producto> listarproducto() throws Exception {
        List <Producto> lista;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(SELECTALLPRODUCT);
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
                p.setTipo_producto(rs.getString("tipo_producto"));
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
    public List<Producto> listarProductoVencer() throws Exception {
        List <Producto> lista;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(SELECTVENCER);
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
                p.setTipo_producto(rs.getString("tipo_producto"));
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
    public List<Producto> listarProductoVencido() throws Exception {
        List <Producto> lista;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(SELECTVENCIDO);
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
                p.setTipo_producto(rs.getString("tipo_producto"));
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
    public List<Producto> listarProductoBajoStock() throws Exception {
        List <Producto> lista;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(LOWSTOCK);
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
                p.setTipo_producto(rs.getString("tipo_producto"));
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
    public void acctualizarFechaVencimiento(Date fecha, int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(UPDATEDATE);
            st.setDate(1, fecha);
            st.setDate(2, fecha);
            st.setInt(3, id);
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }
    
}
