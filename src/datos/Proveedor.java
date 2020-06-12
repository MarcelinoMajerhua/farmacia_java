
package datos;


public class Proveedor {
    private int idProveedor;
    private String nombreProveedor;
    private String DireccionProveedor;
    private String telefonoProveedor;
    private String detalleProveedor;

   
    
    public Proveedor(){};

    public Proveedor(int idProveedor, String nombreProveedor, String DireccionProveedor, String telefonoProveedor, String detalleProveedor) {
        this.nombreProveedor = nombreProveedor;
        this.DireccionProveedor = DireccionProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.detalleProveedor = detalleProveedor;
        this.idProveedor=idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getDireccionProveedor() {
        return DireccionProveedor;
    }

    public void setDireccionProveedor(String DireccionProveedor) {
        this.DireccionProveedor = DireccionProveedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getDetalleProveedor() {
        return detalleProveedor;
    }

    public void setDetalleProveedor(String detalleProveedor) {
        this.detalleProveedor = detalleProveedor;
    }
    
     public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    
}
