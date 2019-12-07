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
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import modelo.Conexion;
import modelo.Pedido;

/**
 *
 * @author femxn
 */
public class PedidoDAO {
 public boolean registrar(Pedido pedi) {
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().conectar();
        String sql = "INSERT INTO pedido (id, fecha_solicitud, estado, usuario_nombre_usuario) VALUES (?,?,?,?)";
        try {
            ps = con.prepareStatement("SELECT MAX(id) FROM pedido");
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1) + 1;
            }
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setDate(2, (java.sql.Date) pedi.getFecha_solicitud());
            ps.setString(3, pedi.getEstado());
            ps.setString(4, pedi.getUsuario_nombre_usuario());            

            ps.execute();
            con.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }
 
 public Pedido registrarConRetorno(Pedido pedi) {
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().conectar();
        String sql = "INSERT INTO pedido (id, fecha_solicitud, estado, usuario_nombre_usuario) VALUES (?,?,?,?)";
        try {
            ps = con.prepareStatement("SELECT MAX(id) FROM pedido");
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1) + 1;
            }
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setDate(2, (java.sql.Date) pedi.getFecha_solicitud());
            ps.setString(3, pedi.getEstado());
            ps.setString(4, pedi.getUsuario_nombre_usuario());            

            ps.execute();
            con.close();
            
            pedi.setId(id);
            return pedi;
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public boolean eliminar(int id) {
        System.out.println("Este es el ID:" + id);
        PreparedStatement ps = null;
        Connection con = new Conexion().conectar();
        String sql = "DELETE FROM pedido WHERE id=?";
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

    public Pedido buscar(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM pedido WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            rs = ps.executeQuery();
            if (rs.next()) {
                Pedido pedi = new Pedido(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4));
                con.close();
                return pedi;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        System.out.println("No se pudo encontrar el proveedor");
        return null;
    }

    public ArrayList<Pedido> listar() {
        ArrayList<Pedido> lista = new ArrayList<>();
        Statement st;
        ResultSet rs;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM pedido ORDER BY id ASC";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Pedido pedido = new Pedido(rs.getInt("id"), rs.getDate("fecha_solicitud"), rs.getString("estado"), rs.getString("usuario_nombre_usuario"));
                lista.add(pedido);
            }
            con.close();
            return lista;
        } catch (SQLException e) {
            System.err.println(e);
            return lista;
        }
    }
    
    public boolean update(Pedido pedi) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().conectar();
        String sql = "UPDATE pedido SET fecha_solicitud = ?, estado= ?, usuario_nombre_usuario=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setDate(1, (java.sql.Date) pedi.getFecha_solicitud());
            ps.setString(2, pedi.getEstado());
            ps.setString(3, pedi.getUsuario_nombre_usuario()); 
            ps.setInt(4, pedi.getId());

            ps.execute();
            con.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
