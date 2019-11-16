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
import modelo.DetallePedido;

/**
 *
 * @author femxn
 */
public class DetallePedidoDAO {
    
        public boolean registrar(DetallePedido detPedi) {
            System.out.println("descripcion " + detPedi.getDescripcion());
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().conectar();
        String sql = "INSERT INTO detalle_pedido (pedido_id, producto_id, cantidad, valor, descripcion) VALUES (?,?,?,?,?)";
        try {            
            ps = con.prepareStatement(sql);
            ps.setInt(1, detPedi.getPedido_id());
            ps.setInt(2, detPedi.getProducto_id());
            ps.setInt(3, detPedi.getCantidad());
            ps.setInt(4, detPedi.getValor());
            ps.setString(5, detPedi.getDescripcion());
            ps.execute();
            con.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public boolean eliminar(int pedido_id) {
        PreparedStatement ps = null;
        Connection con = new Conexion().conectar();
        String sql = "DELETE FROM detalle_pedido WHERE pedido_id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pedido_id);
            ps.execute();
            con.close();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    public DetallePedido buscar(int pedido_id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM detalle_pedido WHERE pedido_id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pedido_id);
            ps.execute();
            rs = ps.executeQuery();
            if (rs.next()) {
                DetallePedido detPedi = new DetallePedido(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
                con.close();
                return detPedi;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        System.out.println("No se pudo encontrar el pedido");
        return null;
    }

    public ArrayList<DetallePedido> listar() {
        ArrayList<DetallePedido> lista = new ArrayList<>();
        Statement st;
        ResultSet rs;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM detalle_pedido";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                DetallePedido detallePedido = new DetallePedido(rs.getInt("pedido_id"), rs.getInt("producto_id"), rs.getInt("cantidad"), rs.getInt("valor"), rs.getString("descripcion"));
                lista.add(detallePedido);
            }
            con.close();
            return lista;
        } catch (SQLException e) {
            System.err.println(e);
            return lista;
        }
    }
    
}
