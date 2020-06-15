
package interfaces;

import datos.Producto;
import java.util.List;


public interface DAOProducto {
   public void  registrar(Producto pr) throws Exception;
   public void modificar(Producto pr)throws Exception;
   public void eliminar(Producto pr)throws Exception;
   public List <Producto> listar()throws Exception;
   public List <Producto> listarUno(Producto pr) throws Exception;
   public List <Producto> buscarProducto(String pr) throws Exception;
   public int evaluarExistencia(String nombreP,String codigoB) throws  Exception;
   public void agregarStock(int cantidad, int id) throws Exception;
   public boolean evaluarExistenciaNombre(String nombre) throws Exception;
   public boolean evaluarExistenciaCB(String codigoB) throws Exception;
}
