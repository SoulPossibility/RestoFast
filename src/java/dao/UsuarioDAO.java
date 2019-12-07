/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Conexion;
import modelo.Funcionario;
import modelo.Rol;
import modelo.Usuario;

/**
 *
 * @author BlueOcean
 */
public class UsuarioDAO {
//    public boolean registrar(Proveedor prov) {
//        int id = 1;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        Connection con = new Conexion().conectar();
//        String sql = "INSERT INTO proveedor (id, nombre, direccion, telefono, email) VALUES (?,?,?,?,?)";
//        try {
//            ps = con.prepareStatement("SELECT MAX(id) FROM proveedor");
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                id = rs.getInt(1) + 1;
//            }
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, id);
//            ps.setString(2, prov.getNombre());
//            ps.setString(3, prov.getDireccion());
//            ps.setString(4, prov.getTelefono());
//            ps.setString(5, prov.getEmail());
//
//            ps.execute();
//            con.close();
//            return true;
//        } catch (SQLException e) {
//            System.err.println(e);
//            e.printStackTrace();
//            throw new IllegalArgumentException(e.getMessage());
//        }
//    }
//
//    public boolean eliminar(int id) {
//        PreparedStatement ps = null;
//        Connection con = new Conexion().conectar();
//        String sql = "DELETE FROM proveedor WHERE id=?";
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, id);
//            ps.execute();
//            con.close();
//            return true;
//        } catch (Exception e) {
//            System.err.println(e);
//            return false;
//        }
//    }

    public Usuario buscar(String nombreUsuario) {
        RolDAO rolDAO = new RolDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM usuario WHERE nombre_usuario=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreUsuario);
            ps.execute();
            rs = ps.executeQuery();
            if (rs.next()) {
                Rol rol = null;
                rol = rolDAO.buscar(rs.getInt("rol_id"));
                Funcionario funcionario = null;
                funcionario = funcionarioDAO.buscar(rs.getString("funcionario_run"));
                Usuario usuario = new Usuario(rs.getString("nombre_usuario"), rs.getString("password"), rol, funcionario);
                con.close();
                return usuario;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        System.out.println("No se pudo encontrar al usuario");
        return null;
    }

    public ArrayList<Usuario> listar() {
        ArrayList<Usuario> lista = new ArrayList<>();
        Statement st;
        ResultSet rs;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM usuario";

        RolDAO rolDAO = new RolDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                //Buscar rol
                Rol rol = rolDAO.buscar(rs.getInt(3));
                Funcionario fun = funcionarioDAO.buscar(rs.getString(4));
                Usuario usuario = new Usuario(rs.getString(1), rs.getString(2), rol, fun);
                lista.add(usuario);
            }
            con.close();
            return lista;
        } catch (SQLException e) {
            System.err.println(e);
            return lista;
        }
    }

    public ArrayList<Usuario> listarSinObjetos() {
        ArrayList<Usuario> lista = new ArrayList<>();
        Statement st;
        ResultSet rs;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM usuario";
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                //Buscar rol
                Usuario usuario = new Usuario(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
                lista.add(usuario);
            }
            con.close();
            return lista;
        } catch (SQLException e) {
            System.err.println(e);
            return lista;
        }
    }
    
    public ArrayList<Usuario> listarGarzonesSinObjetos() {
        ArrayList<Usuario> lista = new ArrayList<>();
        Statement st;
        ResultSet rs;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM usuario WHERE rol_id = 5";
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                //Buscar rol
                Usuario usuario = new Usuario(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
                lista.add(usuario);
            }
            con.close();
            return lista;
        } catch (SQLException e) {
            System.err.println(e);
            return lista;
        }
    }

    public int iniciarSesion(Usuario usu) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM usuario WHERE Nombre_Usuario=? and password=?";
        int r = 0;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usu.getNombre_usuario());
            ps.setString(2, usu.getPassword());
            ps.execute();
            rs = ps.executeQuery();

            while (rs.next()) {
                r = r + 1;
                usu.setNombre_usuario(rs.getString("Nombre_Usuario"));
                usu.setPassword(rs.getString("password"));
            }
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }

    }
}
