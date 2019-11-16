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
public class MenuCantidadDTO {
    private Menu menu;
    private int cantidad;
    private int precio;

    public MenuCantidadDTO() {
    }

    public MenuCantidadDTO(Menu menu, int cantidad) {
        this.menu = menu;
        this.cantidad = cantidad;
        setPrecio(calcularPrecio());
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        setPrecio(calcularPrecio());
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int calcularPrecio(){
        return this.menu.getPrecio() * this.cantidad;
    }
    
}
