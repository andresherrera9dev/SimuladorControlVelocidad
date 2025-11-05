package com.ITCelaya.simuladorcontrolvelocidad.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Para acceder a la base de datos debes tener este usuario FIS y la base de datos SpeedControl
 * CREATE USER 'FIS'@'localhost' IDENTIFIED BY 'SQLPass123';
 * GRANT ALL PRIVILEGES ON speedControl.* TO 'FIS'@'localhost';
 */

public class MySQLConnection {
    private static Connection conn = null;
    private static String HOSTNAME    = "localhost";
    private static String DATABASE = "SpeedControl";
    private static String PORT = "3306";
    private static String USERNAME = "FIS";
    private static String PASSWORD = "SQLPass123";

    private static final String URL = "jdbc:mysql://" + HOSTNAME + ":" + PORT + "/" + DATABASE + "?serverTimezone=UTC";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, "MySQL JDBC Driver not found.", ex);
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, "Error connecting to database.", ex);
            return null;
        }
    }
    
    public static void Disconnect() {
        try {
            conn.close();
            System.out.println("Database connection has been terminated.");
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
