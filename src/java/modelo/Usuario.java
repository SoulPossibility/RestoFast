/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author BlueOcean
 */
public class Usuario {

    private String nombre_usuario;
    private String password;
    private int id_rol;
    private String rutFuncionario;
    private Rol rol;
    private Funcionario funcionario;

    public Usuario() {
    }

    public Usuario(String nombre_usuario, String password, int id_rol, String rutFuncionario) {
        this.nombre_usuario = nombre_usuario;
        this.password = password;
        this.id_rol = id_rol;
        this.rutFuncionario = rutFuncionario;
    }

    public Usuario(String nombre_usuario, String password, Rol rol, Funcionario funcionario) {
        this.nombre_usuario = nombre_usuario;
        this.password = password;
        this.rol = rol;
        this.funcionario = funcionario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

}
