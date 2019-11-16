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
import modelo.Funcionario;

/**
 *
 * @author BlueOcean
 */
public class FuncionarioDAO {

    public boolean registrar(Funcionario fun) {

        System.out.println("valoresfuncionario" + fun.getRun());
        System.out.println("valoresfuncionario" + fun.getNombres());
        System.out.println("valoresfuncionario " + fun.getFechaNacimiento());
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().conectar();
        String sql = "INSERT INTO funcionario (run, nombres, apellido_paterno, apellido_materno, "
                + " sexo, nacionalidad, fecha_nacimiento, direccion, telefono, email, sueldo_base) "
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
//            ps = con.prepareStatement("SELECT run FROM funcionario");
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                id = rs.getInt(1) + 1;
//            }
            ps = con.prepareStatement(sql);
            ps.setString(1, fun.getRun());
            ps.setString(2, fun.getNombres());
            ps.setString(3, fun.getApellidoMaterno());
            ps.setString(4, fun.getApellidoMaterno());
            ps.setString(5, fun.getSexo());
            ps.setString(6, fun.getNacionalidad());
            ps.setDate(7, (java.sql.Date) fun.getFechaNacimiento());
            ps.setString(8, fun.getDireccion());
            ps.setString(9, fun.getTelefono());
            ps.setString(10, fun.getEmail());
            ps.setInt(11, fun.getSueldoBase());

            ps.execute();
            con.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public boolean eliminar(String run) {
        PreparedStatement ps = null;
        Connection con = new Conexion().conectar();
        String sql = "DELETE FROM funcionario WHERE run=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, run);
            ps.execute();
            con.close();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    public Funcionario buscar(String run) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM funcionario WHERE run=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, run);
            ps.execute();
            rs = ps.executeQuery();
            if (rs.next()) {
                Funcionario func = new Funcionario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11));
                con.close();
                return func;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        System.out.println("No se pudo encontrar el funcionario");
        return null;
    }

    public ArrayList<Funcionario> listar() {
        ArrayList<Funcionario> lista = new ArrayList<>();
        Statement st;
        ResultSet rs;
        Connection con = new Conexion().conectar();
        String sql = "SELECT * FROM funcionario";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Funcionario funcionario = new Funcionario(rs.getString("run"), rs.getString("nombres"), rs.getString("apellido_paterno"), rs.getString("apellido_materno"), rs.getString("sexo"),
                        rs.getString("nacionalidad"), rs.getDate("fecha_nacimiento"), rs.getString("direccion"), rs.getString("telefono"), rs.getString("email"), rs.getInt("sueldo_base"));
                lista.add(funcionario);
            }
            con.close();
            return lista;
        } catch (SQLException e) {
            System.err.println(e);
            return lista;
        }
    }
}
