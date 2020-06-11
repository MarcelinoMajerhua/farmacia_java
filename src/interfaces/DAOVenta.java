
package interfaces;

import datos.Venta;
import java.util.List;

public interface DAOVenta {
    public void registrar(Venta v)throws Exception;
    public List <Venta> listar() throws Exception;
}
