/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author femxn
 */
public class Pedido {

    private int id;
    private Date fecha_solicitud;
    private String estado;
    private String usuario_nombre_usuario;

    private Usuario usuario;

    public Pedido() {
    }

    public Pedido(int id, Date fecha_solicitud, String estado, String usuario_nombre_usuario) {
        this.id = id;
        this.fecha_solicitud = fecha_solicitud;
        this.estado = estado;
        this.usuario_nombre_usuario = usuario_nombre_usuario;
    }

    public Pedido(int id, Date fecha_solicitud, String estado, String usuario_nombre_usuario, Usuario usuario) {
        this.id = id;
        this.fecha_solicitud = fecha_solicitud;
        this.estado = estado;
        this.usuario_nombre_usuario = usuario_nombre_usuario;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha_solicitud() {
        return fecha_solicitud;
    }

    public void setFecha_solicitud(Date fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuario_nombre_usuario() {
        return usuario_nombre_usuario;
    }

    public void setUsuario_nombre_usuario(String usuario_nombre_usuario) {
        this.usuario_nombre_usuario = usuario_nombre_usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
