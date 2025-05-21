package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

        private static String host = "localhost";
        private static String port = "3306";
        private static String name = "lp1";
        private static String user = "root";
        private static String password = "xxxxx";

        static String url = "jdbc:mysql://" + host + ":" + port + "/" + name;

        public static Connection conectar(){
            try{
                return DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.out.println("Não foi possível conectar com o banco: " +  e.getMessage());
                return null;
            }

        }

    public static void main(String[] args) {
        conectar();
    }
}
