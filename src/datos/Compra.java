
package datos;

import java.sql.Date;


public class Compra {
    private int camtidadComprada;
    private float precioTotalCompra;
    private int idProducto;
    private int idUsuario;
    private Date fechaCompra;

    public Compra(){};
    public Compra(int camtidadComprada, float precioTotalCompra, int idProducto, int idUsuario, Date fechaCompra) {
        this.camtidadComprada = camtidadComprada;
        this.precioTotalCompra = precioTotalCompra;
        this.idProducto = idProducto;
        this.idUsuario = idUsuario;
        this.fechaCompra = fechaCompra;
    }

    public int getCamtidadComprada() {
        return camtidadComprada;
    }

    public void setCamtidadComprada(int camtidadComprada) {
        this.camtidadComprada = camtidadComprada;
    }

    public float getPrecioTotalCompra() {
        return precioTotalCompra;
    }

    public void setPrecioTotalCompra(float precioTotalCompra) {
        this.precioTotalCompra = precioTotalCompra;
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

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    
    
}
