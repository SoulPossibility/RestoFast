/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;
import modelo.DetallePedido;

/**
 *
 * @author BlueOcean
 */
public class PedidosGraficoDTO {

    private int valorMaximo;
    private int cantidadMaxima;
    private ArrayList<DetallePedido> listaDetalle;

    public PedidosGraficoDTO() {
    }

    public PedidosGraficoDTO(int valorMaximo, int cantidadMaxima, ArrayList<DetallePedido> listaDetalle) {
        this.valorMaximo = 0;
        this.cantidadMaxima = 0;
        this.listaDetalle = listaDetalle;
    }
    
    public int getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(int valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public int getCantidadMaxima() {
        return cantidadMaxima;
    }

    public void setCantidadMaxima(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
    }

    public ArrayList<DetallePedido> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(ArrayList<DetallePedido> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }

    

}
