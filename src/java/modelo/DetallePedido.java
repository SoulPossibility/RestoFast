/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author femxn
 */
public class DetallePedido {

    private int pedido_id;
    private int producto_id;
    private int cantidad;
    private int valor;
    private String descripcion;

    private Pedido pedido;
    private Producto producto;

    public DetallePedido() {
    }

    public DetallePedido(int pedido_id, int producto_id, int cantidad, int valor, String descripcion) {
        this.pedido_id = pedido_id;
        this.producto_id = producto_id;
        this.cantidad = cantidad;
        this.valor = valor;
        this.descripcion = descripcion;
    }

    public DetallePedido(int pedido_id, int producto_id, int cantidad, int valor, String descripcion, Pedido pedido, Producto producto) {
        this.pedido_id = pedido_id;
        this.producto_id = producto_id;
        this.cantidad = cantidad;
        this.valor = valor;
        this.descripcion = descripcion;
        this.pedido = pedido;
        this.producto = producto;
    }

    public int getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(int pedido_id) {
        this.pedido_id = pedido_id;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}
