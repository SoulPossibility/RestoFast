/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.Conexion;
import modelo.Mesa;
import modelo.SesionAtencion;
import modelo.Usuario;

/**
 *
 * @author BlueOcean
 */
public class SesionAtencionDAO {

    public boolean registrar(SesionAtencion sesionAtencion) {
        System.out.println("intenta");
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().conectar();
        String sql = "INSERT INTO sesion_atencion (id, fecha_inicio, fecha_termino, cantidad_comensales, cliente_id, mesa_numero, usuario_nombre_usuario) VALUES (?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement("SELECT MAX(id) FROM sesion_atencion");
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1) + 1;
            }
            ps = con.prepareStatement(sql);
            System.out.println("EL MAXIMO OBTENIDO ES : " + id);
            ps.setInt(1, id);
            //ps.setString(id, sql);

            //ps.setDate(2, date);
            //ps.setDate(3, date);
            ps.setDate(2, sesionAtencion.getFecha_inicio());
            ps.setDate(3, sesionAtencion.getFecha_termino());
            ps.setInt(4, sesionAtencion.getCantidad_comensales());
            ps.setInt(5, sesionAtencion.getCliente());
            ps.setInt(6, sesionAtencion.getMesa());
            ps.setString(7, sesionAtencion.getUsuario());
            System.out.println("ejecuta");
            ps.execute();
            con.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public boolean eliminar(int id) {
        PreparedStatement ps = null;
        Connection con = new Conexion().conectar();
        String sql = "DELETE FROM sesion_atencion WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            con.close();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    public SesionAtencion buscar(int id) {
        //INSTANCIA DE CLASES TIPO DAO
        MesaDAO mesaDAO = new MesaDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        //INSTANCIA DE VARIABLES
        Mesa mesa = new Mesa();
        Cliente cliente = new Cliente();
        Usuario usuario = new Usuario();

        //CÓDIGO SQL
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM sesion_atencion WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            rs = ps.executeQuery();
            if (rs.next()) {
                //ASIGNACIÓN DE VARIABLES SEGÚN ELEMENTO ENCONTRADO EN CADA DAO
                cliente = clienteDAO.buscar(rs.getInt(5));
                mesa = mesaDAO.buscar(rs.getInt(6));
                usuario = usuarioDAO.buscar(rs.getString(7));

                SesionAtencion sesionAtencion = new SesionAtencion(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7));
                sesionAtencion.setMesaObject(mesa);
                sesionAtencion.setClienteObject(cliente);
                sesionAtencion.setUsuarioObject(usuario);
                con.close();
                return sesionAtencion;
            }
        } catch (SQLException e) {
            System.err.println(e);
            System.out.println("Error, no se pudo encontrar la sesionAtencion");
        }

        return null;
    }

//    public ArrayList<SesionAtencion> listar() {
//        ArrayList<SesionAtencion> lista = new ArrayList<>();
//        //OBJETOS DAO
//        ClienteDAO clienteDAO = new ClienteDAO();
//        MesaDAO mesaDAO = new MesaDAO();
//        UsuarioDAO usuarioDAO = new UsuarioDAO();
//
//        Statement st;
//        ResultSet rs;
//        Connection con = new Conexion().conectar();
//        String sql = "SELECT * FROM sesion_atencion";
//        try {
//            st = con.createStatement();
//            rs = st.executeQuery(sql);
//            while (rs.next()) {
//                Cliente cliente = null;
//                Mesa mesa = null;
//                Usuario usuario = null;
//                cliente = clienteDAO.buscar(rs.getInt("cliente_id"));
//                mesa = mesaDAO.buscar(rs.getInt("mesa_numero"));
//                usuario = usuarioDAO.buscar(rs.getString("usuario_nombre_usuario"));
//
//                SesionAtencion SesionAtencion = new SesionAtencion(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getInt(4), mesa, cliente, usuario);
//                lista.add(SesionAtencion);
//            }
//            con.close();
//            return lista;
//        } catch (SQLException e) {
//            System.err.println(e);
//            return lista;
//        }
//    }

    public ArrayList<SesionAtencion> listarSinObjetos() {
        ArrayList<SesionAtencion> lista = new ArrayList<>();
        //OBJETOS DAO
//        ClienteDAO clienteDAO = new ClienteDAO();
//        MesaDAO mesaDAO = new MesaDAO();
//        UsuarioDAO usuarioDAO = new UsuarioDAO();

        Statement st;
        ResultSet rs;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM sesion_atencion";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
//                Cliente cliente = null;
//                Mesa mesa = null;
//                Usuario usuario = null;
//                cliente = clienteDAO.buscar(rs.getInt(5));
//                mesa = mesaDAO.buscar(rs.getInt(6));
//                usuario = usuarioDAO.buscar(rs.getString(7));

                SesionAtencion SesionAtencion = new SesionAtencion(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7));
                lista.add(SesionAtencion);
            }
            con.close();
            return lista;
        } catch (SQLException e) {
            System.err.println(e);
            return lista;
        }
    }

}
