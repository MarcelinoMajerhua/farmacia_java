
package datos;

import java.sql.Date;


public class Venta {
    private int candidadVenta;
    private float precioTotalVenta;
    private int idProducto;
    private int idUsuario;
    private Date fechaVenta;

    public Venta(int candidadVenta, float precioTotalVenta, int idProducto, int idUsuario, Date fechaVenta) {
        this.candidadVenta = candidadVenta;
        this.precioTotalVenta = precioTotalVenta;
        this.idProducto = idProducto;
        this.idUsuario = idUsuario;
        this.fechaVenta = fechaVenta;
    }
    
    public Venta(){};

    public int getCandidadVenta() {
        return candidadVenta;
    }

    public void setCandidadVenta(int candidadVenta) {
        this.candidadVenta = candidadVenta;
    }

    public float getPrecioTotalVenta() {
        return precioTotalVenta;
    }

    public void setPrecioTotalVenta(float precioTotalVenta) {
        this.precioTotalVenta = precioTotalVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
    
    
}
