
package interfaces;

import datos.Usuario;
import java.util.List;

public interface DAOUsuario {
    public void registrar(Usuario usu)throws Exception;
    public void modificar(Usuario usu)throws Exception;
    public void eliminar(Usuario usu)throws Exception;
    public List <Usuario> listar() throws Exception;
    public List <Usuario> mostrarUno(Usuario usu) throws Exception;
}
