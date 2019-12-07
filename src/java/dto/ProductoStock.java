/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import modelo.Producto;

/**
 *
 * @author femxn
 */
public class ProductoStock {
    Producto producto;
    private int cantidad;
    
    public ProductoStock() {
    }

    public ProductoStock(Producto producto, int cantidad) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    
   
}
