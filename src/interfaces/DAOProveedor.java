
package interfaces;

import datos.Proveedor;
import java.util.List;

public interface DAOProveedor {
   public List <Proveedor> listar()throws Exception;
   public List <Proveedor> listarUno(int id) throws Exception;
   public void insertar(Proveedor pr) throws Exception;
   public void actualizar(Proveedor pr) throws  Exception;
   public List <Proveedor> buscarProveedor(String dato) throws Exception;
   public int evaluarExistencia(String nombre,String telefono) throws  Exception;
   public boolean evaluarExistenciaNombre(String nombre) throws Exception;
   public boolean evaluarExistenciaTelefono(String telefono) throws Exception;
   
}
