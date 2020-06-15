
package interfaces;

import datos.Venta;
import java.sql.Date;
import java.util.List;

public interface DAOVenta {
    public void registrar(Venta v)throws Exception;
    public List <Object> listarVenPersonal(String accion, int id, Date fecha) throws Exception;
}
