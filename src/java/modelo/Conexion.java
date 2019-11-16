/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author BlueOcean
 */
public class Conexion {
//    public String bd = "resto_conn";
//    public String user = "usuario_resto";
//    public String pass = "usuario_resto";
//    public String url = "jdbc:mysql://localhost:3306/" + bd;

    public Connection conn;
    public Statement sentencia; //Camino a la bd

    public Connection conectar(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@instanciaportafolio.cbnfc3jcixca.us-east-2.rds.amazonaws.com:1521:ORCL", "admin", "restoadmin");
            //System.out.println("Conexión éxitosa");
            return conn;
        } catch (Exception e) {
           //JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
            System.out.println("Problemas al conectar");
        }
        return null;
    }

    public void desconectar() throws SQLException{
        conn.close();
    }
}
