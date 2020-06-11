
package datos;

import java.sql.Date;


public class Producto {
    
    private String nombre;
    private Date fecha_vencimiento;
    private String codigo_barra;
    private int stock;
    private int id_proveedor;
    private float precio;
    private int codigo;
    private String tipo_producto;

    public String getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }
    
    public Producto(){};
    public Producto(String nombre, Date fecha_vencimiento, String codigo_barra, int stock, int id_proveedor, float precio) {
        this.nombre = nombre;
        this.fecha_vencimiento = fecha_vencimiento;
        this.codigo_barra = codigo_barra;
        this.stock = stock;
        this.id_proveedor = id_proveedor;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public String getCodigo_barra() {
        return codigo_barra;
    }

    public void setCodigo_barra(String codigo_barra) {
        this.codigo_barra = codigo_barra;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
}
