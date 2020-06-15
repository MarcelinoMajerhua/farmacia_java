
package dataAccesObject;

import datos.Proveedor;
import interfaces.DAOProveedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOProveedorImpl extends Conexion implements DAOProveedor{
    private final String SELECT ="call mostrarProveedor(?,?)";
    private final String INSERT ="insert into proveedor (nombre_proveedor,direccion_proveedor,telefono_proveedor,detalle)\n" +
"        values (?,?,?,?)";
    private final String EXISTENCE="call evaluarExistenciaProveedor(?,?)";
    private final String EXISTENCENAME="call existenciaNombreProveedor(?)";
    private final String EXISTENCEPHONE="call existenciaTelefonoProveedor(?)"; 
   
    //direccion proveedor,telefono,detalle
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
    public Proveedor listarUno(int id) throws Exception {
        Proveedor pv =new Proveedor();
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(SELECT);
            st.setString(1, "unitario");
            st.setInt(2, id);
            st.executeUpdate();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                pv.setIdProveedor(rs.getInt("id_proveedor"));
                pv.setDetalleProveedor(rs.getString("detalle"));
                pv.setDireccionProveedor(rs.getString("direccion_proveedor"));
                pv.setNombreProveedor(rs.getString("nombre_proveedor"));
                pv.setTelefonoProveedor(rs.getString("telefono_proveedor"));
            };
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return pv;
    }

    @Override
    public void insertar(Proveedor pr) throws Exception {
        try {
            /*values (_nombre_proveedor,_direccion_proveedor,_telefono_proveedor,_detalle)"*/
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(INSERT);
            st.setString(1, pr.getNombreProveedor());
            st.setString(2, pr.getDireccionProveedor());
            st.setString(3, pr.getTelefonoProveedor());
            st.setString(4, pr.getDetalleProveedor());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public List<Proveedor> buscarProveedor(String dato) throws Exception {
        List <Proveedor> lista;
        String SHEARCH ="select*from proveedor where nombre_proveedor LIKE '%"+dato+"%' or direccion_proveedor LIKE '%"+dato+"%' or telefono_proveedor LIKE '%"+dato+"%' or detalle LIKE '%"+dato+"%'limit 20";
        try {
            this.conectar();
            lista = new ArrayList();
            PreparedStatement st = this.conexion.prepareStatement(SHEARCH);
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
    public int evaluarExistencia(String nombre, String telefono) throws Exception {
         int cont=0;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(EXISTENCE);
            st.setString(1, nombre);
            st.setString(2, telefono);
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
    public boolean evaluarExistenciaNombre(String nombre) throws Exception {
        boolean cont=false;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(EXISTENCENAME);
            st.setString(1, nombre);
            st.executeUpdate();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                cont=true;
            };
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return  cont;
    }

    @Override
    public boolean evaluarExistenciaTelefono(String telefono) throws Exception {
        boolean cont=false;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(EXISTENCEPHONE);
            st.setString(1, telefono);
            st.executeUpdate();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                cont=true;
            };
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return  cont;
    }

    @Override
    public void actualizar(Proveedor pr) throws Exception {
        String UPDATE ="update proveedor set nombre_proveedor ='"+pr.getNombreProveedor()+"', direccion_proveedor='"+pr.getDireccionProveedor()+"',telefono_proveedor='"+pr.getTelefonoProveedor()+"',detalle='"+pr.getDetalleProveedor()+"' where id_proveedor="+pr.getIdProveedor(); 
         try {
             System.out.println(UPDATE);
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(UPDATE);
            st.executeUpdate();
         
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }


}
