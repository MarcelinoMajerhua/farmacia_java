
package datos;


public class Usuario {
    
    private String email;
    private String contraseña;
    private String telefono;
    private String nombre;
    private boolean categoria;
    private boolean activo;
    private int id_modificar;
    private boolean logueado;

    public boolean getLogueado() {
        return logueado;
    }

    public void setLogueado(boolean logueado) {
        this.logueado = logueado;
    }
    
    
    public Usuario(){};
    public Usuario(String email, String contraseña, String telefono, String nombre, boolean categoria, boolean activo) {
        this.email = email;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.nombre = nombre;
        this.categoria = categoria;
        this.activo = activo;
    }

    public String getEmail() {
        return email;
    }
    public int getId_modificar() {
        return id_modificar;
    }

    public void setId_modificar(int id_modificar) {
        this.id_modificar = id_modificar;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getCategoria() {
        return categoria;
    }

    public void setCategoria(boolean categoria) {
        this.categoria = categoria;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
}
