
package interfaces;

import datos.Producto;
import java.util.List;


public interface DAOProducto {
   public void  registrar(Producto pr) throws Exception;
   public void modificar(Producto pr)throws Exception;
   public void eliminar(Producto pr)throws Exception;
   public List <Producto> listar()throws Exception;
   public List <Producto> listarUno(Producto pr) throws Exception;
}
