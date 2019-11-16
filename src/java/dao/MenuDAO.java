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
import modelo.Menu;

/**
 *
 * @author BlueOcean
 */
public class MenuDAO {
    public boolean registrar(Menu menu) {
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().conectar();
        String sql = "INSERT INTO menu (codigo, nombre, tiempo_preparacion, precio, tipo) VALUES (?,?,?,?,?)";
        try {
            rs = ps.executeQuery();
            
            ps = con.prepareStatement(sql);
            ps.setString(1, menu.getCodigo());
            ps.setString(2, menu.getNombre());
            ps.setInt(3, menu.getTiempoPreparacion());
            ps.setInt(4, menu.getPrecio());
            ps.setString(5, menu.getTipo());

            ps.execute();
            con.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }

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

    public Menu buscar(String codigo) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM menu WHERE codigo=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            ps.execute();
            rs = ps.executeQuery();
            if (rs.next()) {
                Menu prov = new Menu(rs.getString("codigo"), rs.getString("nombre"), rs.getInt("tiempo_preparacion"), rs.getInt("precio"), rs.getString("tipo"));
                con.close();
                return prov;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        System.out.println("No se pudo encontrar el menu");
        return null;
    }

    public ArrayList<Menu> listar() {
        ArrayList<Menu> lista = new ArrayList<>();
        Statement st;
        ResultSet rs;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM menu";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Menu menu = new Menu(rs.getString("codigo"), rs.getString("nombre"), rs.getInt("tiempo_preparacion"), rs.getInt("precio"), rs.getString("tipo"));
                lista.add(menu);
            }
            con.close();
            return lista;
        } catch (SQLException e) {
            System.err.println(e);
            return lista;
        }
    }
}
