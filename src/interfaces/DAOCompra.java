
package interfaces;

import datos.Compra;
import java.util.List;

public interface DAOCompra {
    public void registrar(Compra c)throws Exception;
    public List <Compra> listar() throws Exception;
}
