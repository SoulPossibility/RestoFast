/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.util.ArrayList;
import java.util.*;
import dao.*;

/**
 *
 * @author macev
 */
public interface ServicioLocal {
    void insertar(Object o);
    void sincronizar(Object o);
    
    public int validar(Usuario usu);
    
   UsuarioDAO buscarUsuario(int nombre);
    void editarProducto(String nombre,String password);
    List<UsuarioDAO>getUsuario();
    
    //inicar sesion
   Usuario iniciarSesion(String nombre_usuario,String clave);
    
    //comprar
   
    
    void editarContraseña(String rut, String Clave, String nClave);
    
}
