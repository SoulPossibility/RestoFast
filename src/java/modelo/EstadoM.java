/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Asus
 */
public class EstadoM {
      private int numero;
      private int capacidad;
      private String Estado;

    public EstadoM() {
    }

    public EstadoM(int numero, int capacidad, String Estado) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.Estado = Estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
      
  
    
    
    
    
}
