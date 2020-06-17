
package interfaces;

import datos.Usuario;
import java.util.List;

public interface DAOUsuario {
    public void registrar(Usuario usu)throws Exception;
    public void modificar(Usuario usu)throws Exception;
    public List <Usuario> listar() throws Exception;
    public boolean evaluarExistenciaEmail(String email) throws Exception;
    public boolean evaluarExistenciaNombre(String nombre) throws Exception;

}
