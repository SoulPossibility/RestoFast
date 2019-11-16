/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author BlueOcean
 */
public class Producto {
    private int id;
    private String nombre;
    private String tipo;
    private Date fechaElaboracion;
    private Date fechaVencimiento;
    private int precio;
    private int stock;
    private int IdProveedor;
    private Proveedor proveedor;

    public Producto(int id, String nombre, String tipo, Date fechaElaboracion, Date fechaVencimiento, int precio, int stock, Proveedor proveedor) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.fechaElaboracion = fechaElaboracion;
        this.fechaVencimiento = fechaVencimiento;
        this.precio = precio;
        this.stock = stock;
        this.proveedor = proveedor;
    }

    public Producto(int id, String nombre, String tipo, Date fechaElaboracion, Date fechaVencimiento, int precio, int stock, int IdProveedor) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.fechaElaboracion = fechaElaboracion;
        this.fechaVencimiento = fechaVencimiento;
        this.precio = precio;
        this.stock = stock;
        this.IdProveedor = IdProveedor;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaElaboracion() {
        return fechaElaboracion;
    }

    public void setFechaElaboracion(Date fechaElaboracion) {
        this.fechaElaboracion = fechaElaboracion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public int getIdProveedor() {
        return IdProveedor;
    }

    public void setIdProveedor(int IdProveedor) {
        this.IdProveedor = IdProveedor;
    }
    
    
    
}
