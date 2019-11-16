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
import modelo.EstadoM;

/**
 *
 * @author Asus
 */
public class EstadoMesaDAO {

    public boolean EstadoMesas(EstadoM estadoMesas) {
        int numero = 0;
        int capacidad = 0;
        String estado;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().conectar();
        String sql = "INSERT INTO mesa (numero, capacidad, estado) VALUES (?,?,?)";
        try {
            ps = con.prepareStatement("SELECT MAX(numero) FROM mesa");
            rs = ps.executeQuery();
            if (rs.next()) {
                numero = rs.getInt(1) + 1;
            }
            ps = con.prepareStatement(sql);
            ps.setInt(1, numero);
            ps.setInt(2, capacidad);
            ps.setString(3, estadoMesas.getEstado());

            ps.execute();
            con.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public EstadoM buscarMesa(int numero) {
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
                EstadoM estad = new EstadoM(rs.getInt(1), rs.getInt(2), rs.getString(3));
                con.close();
                return estad;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        System.out.println("No se pudo encontrar el Mesa");
        return null;
    }

    public boolean eliminar(int id) {
        PreparedStatement ps = null;
        Connection con = new Conexion().conectar();
        String sql = "DELETE FROM mesa WHERE numero=?";
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

    public ArrayList<EstadoM> listar() {
        ArrayList<EstadoM> lista = new ArrayList<>();
        Statement st;
        ResultSet rs;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM mesa";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                EstadoM Estad = new EstadoM(rs.getInt("numero"), rs.getInt("capacidad"), rs.getString("estado"));
                lista.add(Estad);
            }
            con.close();
            return lista;
        } catch (SQLException e) {
            System.err.println(e);
            return lista;
        }
    }

}
