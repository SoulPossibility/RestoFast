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
import modelo.Mesa;

/**
 *
 * @author BlueOcean
 */
public class MesaDAO {
    public boolean registrar(Mesa mesa) {
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().conectar();
        String sql = "INSERT INTO mesa (numero, capacidad, estado) VALUES (?,?,?)";
        try {
            //ps = con.prepareStatement("SELECT MAX(id) FROM proveedor");
            rs = ps.executeQuery();
            //if (rs.next()) {
            //    id = rs.getInt(1) + 1;
            //}
            ps = con.prepareStatement(sql);
            ps.setInt(1, mesa.getNumero());
            ps.setInt(2, mesa.getCapacidad());
            ps.setString(3, mesa.getEstado());

            ps.execute();
            con.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public boolean eliminar(int numero) {
        PreparedStatement ps = null;
        Connection con = new Conexion().conectar();
        String sql = "DELETE FROM mesa WHERE numero=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, numero);
            ps.execute();
            con.close();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    public Mesa buscar(int numero) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM mesa WHERE numero=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, numero);
            ps.execute();
            rs = ps.executeQuery();
            if (rs.next()) {
                Mesa mesa = new Mesa(rs.getInt(1), rs.getInt(2), rs.getString(3));
                con.close();
                return mesa;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        System.out.println("No se pudo encontrar la mesa");
        return null;
    }

    public ArrayList<Mesa> listar() {
        ArrayList<Mesa> lista = new ArrayList<>();
        Statement st;
        ResultSet rs;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM mesa ORDER BY numero ASC";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Mesa mesa = new Mesa(rs.getInt(1), rs.getInt(2), rs.getString(3));
                lista.add(mesa);
            }
            con.close();
            return lista;
        } catch (SQLException e) {
            System.err.println(e);
            return lista;
        }
    }
}
