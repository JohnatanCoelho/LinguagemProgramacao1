package org.example.dao;

import org.example.database.Conexao;
import org.example.module.Planta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoPlanta {
    public void inserirPlanta(String nome, String tipo, String cor, Integer nivelAgua){
        String sql = "INSERT INTO planta(nome, tipo, cor, nivel) values(?,?,?, ?)";
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, nome);
            pst.setString(2, tipo);
            pst.setString(3, cor);
            pst.setInt(4, nivelAgua);

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage() );
            e.printStackTrace();
        }
    }

    public List<Planta> listarPlantas(){
        String sql_select = "SELECT * FROM  planta";
        List<Planta> plantaList = new ArrayList<>();
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql_select);

            ResultSet result =  pst.executeQuery();

            while(result.next()){
                Planta novaPlanta = new Planta(result.getInt("id"), result.getString("nome"),
                        result.getString("tipo"), result.getString("cor"), result.getInt("nivel"));
                plantaList.add(novaPlanta);

            }
            return plantaList;
        } catch (SQLException e) {
            System.out.println("Erro ao listar plantas: " + e.getMessage());
            return null;
        }
    }

    public void updatePlanta(Integer id, String nome, String tipo, String cor, Integer nivel){
        String sql_update = "UPDATE planta SET nome = ?, tipo = ?, cor = ?, nivel = ? where id = ?";

        try{
          Connection conn = Conexao.conectar();
          PreparedStatement pst = conn.prepareStatement(sql_update);

          pst.setString(1, nome);
          pst.setString(2, tipo);
          pst.setString(3, cor);
          pst.setInt(4, nivel);
          pst.setInt(5, id);

          pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar plantas: " + e.getMessage());
        }

    }

    public void deletarPlanta(Integer id){
        String sql_deletar = "DELETE FROM planta where id = ?";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql_deletar);

            pst.setInt(1, id);

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao DELETAR planta: " + e.getMessage());
        }
    }

}
