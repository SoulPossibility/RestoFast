/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author femxn
 */
public class Producto {

    private int id;
    private String nombre;
    private String tipo;
    private Date fecha_elaboracion;
    private Date fecha_vencimiento;
    private int precio;
    private int stock;
    private int proveedor_id;
    private Proveedor proveedor;

    public Producto() {
    }

    public Producto(int id, String nombre, String tipo, Date fecha_elaboracion, Date fecha_vencimiento, int precio, int stock, int proveedor_id) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.fecha_elaboracion = fecha_elaboracion;
        this.fecha_vencimiento = fecha_vencimiento;
        this.precio = precio;
        this.stock = stock;
        this.proveedor_id = proveedor_id;
    }

    public Producto(int id, String nombre, String tipo, Date fecha_elaboracion, Date fecha_vencimiento, int precio, int stock, int proveedor_id, Proveedor proveedor) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.fecha_elaboracion = fecha_elaboracion;
        this.fecha_vencimiento = fecha_vencimiento;
        this.precio = precio;
        this.stock = stock;
        this.proveedor_id = proveedor_id;
        this.proveedor = proveedor;
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

    public Date getFecha_elaboracion() {
        return fecha_elaboracion;
    }

    public void setFecha_elaboracion(Date fecha_elaboracion) {
        this.fecha_elaboracion = fecha_elaboracion;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
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

    public int getProveedor_id() {
        return proveedor_id;
    }

    public void setProveedor_id(int proveedor_id) {
        this.proveedor_id = proveedor_id;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

}
