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
public class Pago {
    private int id;
    private Date fecha;
    private int monto;
    private String metodo_pago;
    private String anotacion;
    private SesionAtencion sessionAtencion;

    public Pago() {
    }

    public Pago(int id, Date fecha, int monto, String metodo_pago, String anotacion, SesionAtencion sessionAtencion) {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
        this.metodo_pago = metodo_pago;
        this.anotacion = anotacion;
        this.sessionAtencion = sessionAtencion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public String getAnotacion() {
        return anotacion;
    }

    public void setAnotacion(String anotacion) {
        this.anotacion = anotacion;
    }

    public SesionAtencion getSessionAtencion() {
        return sessionAtencion;
    }

    public void setSessionAtencion(SesionAtencion sessionAtencion) {
        this.sessionAtencion = sessionAtencion;
    }
    
    
}
