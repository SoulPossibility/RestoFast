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
import modelo.Cliente;

/**
 *
 * @author BlueOcean
 */
public class ClienteDAO {

    public boolean registrar(Cliente cliente) {
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().conectar();
        String sql = "INSERT INTO cliente (id, nombre) VALUES (?,?)";
        try {
            ps = con.prepareStatement("SELECT MAX(id) FROM cliente");
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1) + 1;
            }
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, cliente.getNombre());

            ps.execute();
            con.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }
    
    public Cliente registrarRetornar(Cliente cliente) {
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().conectar();
        String sql = "INSERT INTO cliente (id, nombre) VALUES (?,?)";
        try {
            ps = con.prepareStatement("SELECT MAX(id) FROM cliente");
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1) + 1;
            }
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, cliente.getNombre());
            cliente.setId(id);
            
            ps.execute();
            con.close();
            return cliente;
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());   
        }
    }

    public boolean eliminar(int id) {
        PreparedStatement ps = null;
        Connection con = new Conexion().conectar();
        String sql = "DELETE FROM cliente WHERE id=?";
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

    public Cliente buscar(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM cliente WHERE id="+id+"";
        try {
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, id);}
            Statement stmt = con.createStatement();
            stmt.executeQuery(sql);
            //ps.execute();
            rs = stmt.executeQuery(sql);
            Cliente cliente = null;
            if (rs.next()) {
                cliente = new Cliente(rs.getInt(1), rs.getString(2));
                //return cliente;
            } else {
                con.close();
            }
            return cliente;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public ArrayList<Cliente> listar() {
        ArrayList<Cliente> lista = new ArrayList<>();
        Statement st;
        ResultSet rs;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM cliente";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Cliente cliente = new Cliente(rs.getInt("id"), rs.getString("nombre"));
                lista.add(cliente);
            }
            con.close();
            return lista;
        } catch (SQLException e) {
            System.err.println(e);
            return lista;
        }
    }
}
