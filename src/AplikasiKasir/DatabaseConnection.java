/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AplikasiKasir;
import java.sql.*;

/**
 *
 * @author Asus
 */
public class DatabaseConnection {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
        String url = "jdbc:mysql://localhost:3307/db_restoran_ducky";
        String user = "root";
        String password = "";
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database Connected");
        } catch (SQLException e) {
            System.err.println("Connection Failed: " + e.getMessage());
        }
    }
    return connection;
    }
}
