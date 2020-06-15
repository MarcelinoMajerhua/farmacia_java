
package interfaces;

import datos.Compra;
import java.sql.Date;
import java.util.List;

public interface DAOCompra {
    public void registrar(Compra c)throws Exception;
    public List <Object> listarConPersonal(String accion, int id, Date fecha) throws Exception;
}
