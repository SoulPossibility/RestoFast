/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import modelo.Menu;

/**
 *
 * @author BlueOcean
 */
public class MenuGraficoDTO {
    private int cantidad;
    private int precioMaximo;
    private Menu menu;

    public MenuGraficoDTO() {
    }

    public MenuGraficoDTO(int cantidad, int precioMaximo, Menu menu) {
        this.cantidad = cantidad;
        this.precioMaximo = precioMaximo;
        this.menu = menu;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioMaximo() {
        return precioMaximo;
    }

    public void setPrecioMaximo(int precioMaximo) {
        this.precioMaximo = precioMaximo;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    
    
}
