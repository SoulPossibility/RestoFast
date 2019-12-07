/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Conexion;
import modelo.Producto;

/**
 *
 * @author BlueOcean
 */
public class ProductoDAO {
    public ArrayList<Producto> listarMSP() {
        ArrayList<Producto> lista = new ArrayList<>();
        Statement st;
        ResultSet rs;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM producto";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Producto prod = new Producto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
                lista.add(prod);
            }
            con.close();
            return lista;
        } catch (SQLException e) {
            System.err.println(e);
            return lista;
        }
    }
    
    public Producto buscar(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM producto WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            rs = ps.executeQuery();
            if (rs.next()) {
                Producto prod = new Producto(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6),
                         rs.getInt(7), rs.getInt(8));
                con.close();
                return prod;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        System.out.println("No se pudo encontrar el producto");
        return null;
    }

    public ArrayList<Producto> listar() {
        ArrayList<Producto> lista = new ArrayList<>();
        Statement st;
        ResultSet rs;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM producto ORDER BY id ASC";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Producto producto = new Producto(rs.getInt("id"),rs.getString("nombre"),rs.getString("tipo"), rs.getDate("fecha_elaboracion"), rs.getDate("fecha_vencimiento"), rs.getInt("precio"),
                         rs.getInt("stock"), rs.getInt("proveedor_id"));
                lista.add(producto);
            }
            con.close();
            return lista;
        } catch (SQLException e) {
            System.err.println(e);
            return lista;
        }
    }
    
    public ArrayList<Producto> listarStock() throws SQLException {
        ArrayList<Producto> lista = new ArrayList<>();       
        Statement st;
        ResultSet rs;
        Connection con = new Conexion().conectar();
        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM producto WHERE id IN(?)");
        //String sql = 
        try {
            Array array = con.createArrayOf("NUMBER", lista.toArray());
            st = con.createStatement();
            pstmt.setArray (1, array);
            //st.setInt(1, );
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto(rs.getInt("id"),rs.getString("nombre"),rs.getString("tipo"), rs.getDate("fecha_elaboracion"), rs.getDate("fecha_vencimiento"), rs.getInt("precio"),
                         rs.getInt("stock"), rs.getInt("proveedor_id"));
                lista.add(producto);
            }
            con.close();
            return lista;
        } catch (SQLException e) {
            System.err.println(e);
            return lista;
        }
    }
    
    
}
