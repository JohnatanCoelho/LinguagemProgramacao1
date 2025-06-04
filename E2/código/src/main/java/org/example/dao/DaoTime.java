package org.example.dao;

import org.example.database.Conexao;
import org.example.module.TimeDeFutebol;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoTime {

     public void inserirPartida(String time, String arena, String rival, Integer golsCasa, Integer golsVisitante){
         String sql = "INSERT INTO time(time_casa, time_visitante, arena, gol_casa, gol_visitante) values(?,?,?,?,?)";

         try{
             Connection conn = Conexao.conectar();
             PreparedStatement pst = conn.prepareStatement(sql);

             pst.setString(1, time);
             pst.setString(2, rival);
             pst.setString(3,arena);
             pst.setInt(4, golsCasa);
             pst.setInt(5, golsVisitante);

             pst.executeUpdate();

         } catch (SQLException e) {
             System.out.println("Erro ao inserir partida: " + e.getMessage());
         }
     }

     public List<TimeDeFutebol> listarTime(){
         List<TimeDeFutebol> timeList = new ArrayList<>();
         String sql_select = "SELECT * FROM time";

         try {
             Connection conn = Conexao.conectar();
             PreparedStatement pst = conn.prepareStatement(sql_select);
             ResultSet result = pst.executeQuery();

             while(result.next()){
                 TimeDeFutebol time = new TimeDeFutebol(result.getInt("id"), result.getString("time_casa"),
                         result.getString("time_visitante"), result.getString("arena"), result.getInt("gol_casa"),
                         result.getInt("gol_visitante"));
                 timeList.add(time);
             }
             return timeList;
         } catch (SQLException e) {
             System.out.println("Erro ao listar o time: " + e.getMessage());
                return null;
         }
     }

     public void updatePartida(Integer id, String time, String arena, String rival, Integer golsCasa, Integer golsVisitante ){
         String sql_update = "UPDATE time SET time_casa = ?, time_visitante = ?, " +
                 "arena = ?, gol_casa = ?, gol_visitante = ? where id = ?";

         try{
             Connection conn = Conexao.conectar();
             PreparedStatement pst = conn.prepareStatement(sql_update);
             pst.setString(1, time);
             pst.setString(2, rival);
             pst.setString(3, arena);
             pst.setInt(4, golsCasa);
             pst.setInt(5, golsVisitante);
             pst.setInt(6, id);
             pst.executeUpdate();
         } catch (SQLException e) {
             System.out.println("Erro ao atualizar time: " + e.getMessage());
         }
     }

     public void deletarPartida(Integer id){
         String delete = "DELETE FROM time where id = ?";

         try{
             Connection conn = Conexao.conectar();
             PreparedStatement pst = conn.prepareStatement(delete);
             pst.setInt(1, id);
             pst.executeUpdate();

         } catch (SQLException e) {
             System.out.println("Erro ao deletar Partida: " + e.getMessage());
         }
     }
}
