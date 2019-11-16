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
import modelo.Proveedor;

/**
 *
 * @author BlueOcean
 */
public class ProveedorDAO {

    public boolean registrar(Proveedor prov) {
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().conectar();
        String sql = "INSERT INTO proveedor (id, nombre, direccion, telefono, email) VALUES (?,?,?,?,?)";
        try {
            ps = con.prepareStatement("SELECT MAX(id) FROM proveedor");
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1) + 1;
            }
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, prov.getNombre());
            ps.setString(3, prov.getDireccion());
            ps.setString(4, prov.getTelefono());
            ps.setString(5, prov.getEmail());

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
        String sql = "DELETE FROM proveedor WHERE id=?";
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

    public Proveedor buscar(String nombre) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM proveedor WHERE nombre=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.execute();
            rs = ps.executeQuery();
            if (rs.next()) {
                Proveedor prov = new Proveedor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                con.close();
                return prov;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        System.out.println("No se pudo encontrar el proveedor");
        return null;
    }

    public ArrayList<Proveedor> listar() {
        ArrayList<Proveedor> lista = new ArrayList<>();
        Statement st;
        ResultSet rs;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM proveedor";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Proveedor proveedor = new Proveedor(rs.getInt("id"), rs.getString("nombre"), rs.getString("direccion"), rs.getString("telefono"), rs.getString("email"));
                lista.add(proveedor);
            }
            con.close();
            return lista;
        } catch (SQLException e) {
            System.err.println(e);
            return lista;
        }
    }
}
