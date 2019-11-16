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
import modelo.Conexion;
import modelo.Rol;

/**
 *
 * @author BlueOcean
 */
public class RolDAO {
    public Rol buscar(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM rol WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            rs = ps.executeQuery();
            if (rs.next()) {
                Rol rol = new Rol(rs.getInt(1), rs.getString(2));
                con.close();
                return rol;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        System.out.println("No se pudo encontrar el rol");
        return null;
    }
}
