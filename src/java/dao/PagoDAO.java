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
import modelo.Pago;
import modelo.SesionAtencion;

/**
 *
 * @author BlueOcean
 */
public class PagoDAO {

    public boolean registrar(Pago pago) {
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().conectar();
        String sql = "INSERT INTO pago (id, fecha, monto, metodo_pago, anotacion, session_atencion_id) VALUES (?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement("SELECT MAX(id) FROM pago");
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1) + 1;
            }
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setDate(2, pago.getFecha());
            ps.setInt(3, pago.getMonto());
            ps.setString(4, pago.getMetodo_pago());
            ps.setString(5, pago.getAnotacion());
            ps.setInt(6, pago.getSessionAtencion().getId());

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
        String sql = "DELETE FROM pago WHERE id=?";
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

    public Pago buscar(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM pago WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            rs = ps.executeQuery();
            if (rs.next()) {
                //Obtener sesion_atencion desde la base de datos y crear su objeto para asociarlo al objeto pago posteriormente
                SesionAtencionDAO sesionAtencionDAO = new SesionAtencionDAO();
                SesionAtencion sesion = sesionAtencionDAO.buscar(rs.getInt(6));
                Pago pago = new Pago(rs.getInt(1), rs.getDate(2), rs.getInt(3), rs.getString(4), rs.getString(5), sesion);
                con.close();
                return pago;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        System.out.println("No se pudo encontrar el pago");
        return null;
    }

    public ArrayList<Pago> listar() {
        ArrayList<Pago> lista = new ArrayList<>();
        Statement st;
        ResultSet rs;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM pago";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                //Obtener sesion_atencion desde la base de datos y crear su objeto para asociarlo al objeto pago posteriormente
                SesionAtencionDAO sesionAtencionDAO = new SesionAtencionDAO();
                SesionAtencion sesion = sesionAtencionDAO.buscar(rs.getInt(6));
                Pago proveedor = new Pago(rs.getInt(1), rs.getDate(2), rs.getInt(3), rs.getString(4), rs.getString(5), sesion);
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
