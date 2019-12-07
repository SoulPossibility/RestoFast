/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import modelo.Funcionario;
import modelo.Usuario;

/**
 *
 * @author BlueOcean
 */
public class GarzonGraficoDTO {
    private Funcionario funcionario;
    private Usuario usuario;
    private int cantidadAnual;

    public GarzonGraficoDTO() {
        
    }

    public GarzonGraficoDTO(Funcionario funcionario, Usuario usuario, int cantidadAnual) {
        this.funcionario = funcionario;
        this.usuario = usuario;
        this.cantidadAnual = cantidadAnual;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getCantidadAnual() {
        return cantidadAnual;
    }

    public void setCantidadAnual(int cantidadAnual) {
        this.cantidadAnual = cantidadAnual;
    }
    
    
    
    
}
