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
public class SesionAtencion {

    private int id;
    private Date fecha_inicio;
    private Date fecha_termino;
    private int cantidad_comensales;

    private int mesa;
    private int cliente;
    private String usuario;

    private Mesa mesaObject;
    private Cliente clienteObject;
    private Usuario usuarioObject;

    public SesionAtencion() {
    }

    public SesionAtencion(int id, Date fecha_inicio, Date fecha_termino, int cantidad_comensales, int cliente, int mesa, String usuario) {
        this.id = id;
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
        this.cantidad_comensales = cantidad_comensales;
        this.mesa = mesa;
        this.cliente = cliente;
        this.usuario = usuario;
    }

    public SesionAtencion(int id, Date fecha_inicio, Date fecha_termino, int cantidad_comensales, Cliente cliente, Mesa mesa, Usuario usuario) {
        this.id = id;
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
        this.cantidad_comensales = cantidad_comensales;
        this.mesa = mesa.getNumero();
        this.cliente = cliente.getId();
        this.usuario = usuario.getNombre_usuario();
        this.mesaObject = mesa;
        this.clienteObject = cliente;
        this.usuarioObject = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_termino() {
        return fecha_termino;
    }

    public void setFecha_termino(Date fecha_termino) {
        this.fecha_termino = fecha_termino;
    }

    public int getCantidad_comensales() {
        return cantidad_comensales;
    }

    public void setCantidad_comensales(int cantidad_comensales) {
        this.cantidad_comensales = cantidad_comensales;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Mesa getMesaObject() {
        return mesaObject;
    }

    public void setMesaObject(Mesa mesaObject) {
        this.mesaObject = mesaObject;
    }

    public Cliente getClienteObject() {
        return clienteObject;
    }

    public void setClienteObject(Cliente clienteObject) {
        this.clienteObject = clienteObject;
    }

    public Usuario getUsuarioObject() {
        return usuarioObject;
    }

    public void setUsuarioObject(Usuario usuarioObject) {
        this.usuarioObject = usuarioObject;
    }

}
