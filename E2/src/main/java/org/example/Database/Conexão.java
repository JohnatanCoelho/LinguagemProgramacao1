package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexão {

    private static String url = "jdbc:mysql//localhost:3306/lp1E2";
    private static String user = "root";
    private static String password = "-";

    public static Connection conectar(){
        Connection conn;
        try{
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar no banco: " + e.getMessage());
            return null;
        }
        return conn;
    }
}
