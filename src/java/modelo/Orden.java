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
public class Orden {
    private int id;
    private String estado;
    private Date fecha;
    private String codigoMenu;
    private Menu menu;
    private int idSesion;
    private SesionAtencion sesionAtencion;
    private int cantidad;

    public Orden() {
    }

    public Orden(int id, String estado, Date fecha, Menu menu, SesionAtencion sesionAtencion, int cantidad) {
        this.id = id;
        this.estado = estado;
        this.fecha = fecha;
        this.menu = menu;
        this.sesionAtencion = sesionAtencion;
        this.cantidad = cantidad;
    }

    public Orden(int id, String estado, Date fecha, String codigoMenu, int idSesion, int cantidad) {
        this.id = id;
        this.estado = estado;
        this.fecha = fecha;
        this.codigoMenu = codigoMenu;
        this.idSesion = idSesion;
        this.cantidad = cantidad;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public SesionAtencion getSesionAtencion() {
        return sesionAtencion;
    }

    public void setSesionAtencion(SesionAtencion sesionAtencion) {
        this.sesionAtencion = sesionAtencion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigoMenu() {
        return codigoMenu;
    }

    public void setCodigoMenu(String codigoMenu) {
        this.codigoMenu = codigoMenu;
    }

    public int getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(int idSesion) {
        this.idSesion = idSesion;
    }

    @Override
    public String toString() {
        return "Orden{" + "id=" + id + ", estado=" + estado + ", fecha=" + fecha + ", menu=" + menu + ", sesionAtencion=" + sesionAtencion + ", cantidad=" + cantidad + '}';
    }

    
    
}
