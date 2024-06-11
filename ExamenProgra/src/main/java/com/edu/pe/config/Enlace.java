
package com.edu.pe.config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author lipaj
 */
public class Enlace {

    public static Connection getEnlace() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/BD_JUEGO";
            String usr = "root";
            String psw = "";
            con = DriverManager.getConnection(url, usr, psw);
            System.out.println("Conexion exitosa!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }
    
    public static void main(String[] args) {
        Enlace.getEnlace();
    }
}
