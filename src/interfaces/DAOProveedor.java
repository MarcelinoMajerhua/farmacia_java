
package interfaces;

import datos.Proveedor;
import java.util.List;

public interface DAOProveedor {
   public List <Proveedor> listar()throws Exception;
   public List <Proveedor> listarUno(int id) throws Exception;
   public void insertar(Proveedor pr) throws Exception;
}
