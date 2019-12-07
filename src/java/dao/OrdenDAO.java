/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import modelo.Conexion;
import modelo.Menu;
import modelo.Orden;
import modelo.Proveedor;
import modelo.SesionAtencion;

/**
 *
 * @author BlueOcean
 */
public class OrdenDAO {

    public boolean registrar(Orden orden) {
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().conectar();
        String sql = "INSERT INTO orden (id, estado, fecha, menu_codigo, sesion_atencion_id, cantidad) VALUES (?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement("SELECT MAX(id) FROM orden");
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1) + 1;
            }
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, orden.getEstado());
            ps.setDate(3, orden.getFecha());
            ps.setString(4, orden.getMenu().getCodigo());
            ps.setInt(5, orden.getSesionAtencion().getId());
            ps.setInt(6, orden.getCantidad());

            ps.execute();
            con.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }
    
    public int actualizar(Orden orden){
        int r = 0;
        PreparedStatement ps = null;
        Connection con = new Conexion().conectar();
        String sql = "UPDATE orden set estado=? where id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, orden.getEstado());
            ps.setInt(2, orden.getId());
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            }else{
                r = 0;
            }
            System.out.println("iafjasñkfjasñkdlfjsalkñd: " + r);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return r;
    }
    
    public Orden buscar(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM orden WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            rs = ps.executeQuery();
            if (rs.next()) {
                Orden orden = new Orden(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
                con.close();
                return orden;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        System.out.println("No se pudo encontrar el proveedor");
        return null;
    }

    public ArrayList<Orden> listar() {
        ArrayList<Orden> lista = new ArrayList<>();
        Statement st;
        ResultSet rs;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM orden";

        SesionAtencionDAO sesionDAO = new SesionAtencionDAO();
        MenuDAO menuDAO = new MenuDAO();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                //int id, String estado, Date fecha, Menu menu, SesionAtencion sesionAtencion
                SesionAtencion sesion = sesionDAO.buscar(rs.getInt(5));
                Menu menu = menuDAO.buscar(rs.getString(4));

                Date date;
                Timestamp timestamp = rs.getTimestamp(3);
                if (timestamp != null) {
                    date = new Date(timestamp.getTime());
                }else{
                    date = null;
                }
                
                Orden orden = new Orden(rs.getInt(1), rs.getString(2), date, menu, sesion, rs.getInt(6));
                lista.add(orden);
            }
            con.close();
            return lista;
        } catch (SQLException e) {
            System.err.println(e);
            return lista;
        }
    }

    public ArrayList<Orden> listarSinObjetos() {
        ArrayList<Orden> lista = new ArrayList<>();
        Statement st;
        ResultSet rs;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM orden";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Orden orden = new Orden(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
                lista.add(orden);
            }
            con.close();
            return lista;
        } catch (SQLException e) {
            System.err.println(e);
            return lista;
        }
    }

    public ArrayList<Orden> listarPendientesSinObjetos() {
        ArrayList<Orden> lista = new ArrayList<>();
        Statement st;
        ResultSet rs;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM orden where estado = 'elaborando'";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Orden orden = new Orden(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
                lista.add(orden);
            }
            con.close();
            return lista;
        } catch (SQLException e) {
            System.err.println(e);
            return lista;
        }
    }

    public ArrayList<Orden> listarPendientes() {
        ArrayList<Orden> lista = new ArrayList<>();
        Statement st;
        ResultSet rs;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM orden where estado = 'elaborando'";

        SesionAtencionDAO sesionDAO = new SesionAtencionDAO();
        MenuDAO menuDAO = new MenuDAO();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                //int id, String estado, Date fecha, Menu menu, SesionAtencion sesionAtencion
                SesionAtencion sesion = sesionDAO.buscar(rs.getInt(5));
                Menu menu = menuDAO.buscar(rs.getString(4));

                Orden orden = new Orden(rs.getInt(1), rs.getString(2), rs.getDate(3), menu, sesion, rs.getInt(6));
                lista.add(orden);
            }
            con.close();
            return lista;
        } catch (SQLException e) {
            System.err.println(e);
            return lista;
        }
    }
}
