package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

        private static String host = "localhost";
        private static String port = "3306";
        private static String name = "lp1";
        private static String user = "userlp";
        private static String password = "lp123";

        static String url = "jdbc:mysql://" + host + ":" + port + "/" + name;

        public static Connection conectar(){
            try{
                return DriverManager.getConnection(url, user, password);

            } catch (SQLException e) {
                System.out.println("Erro: " +  e.getMessage());
                e.printStackTrace();
                return null;
            }

        }

    public static void main(String[] args) {
        conectar();
    }
}
