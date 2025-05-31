package org.example.dao;

import org.example.database.Conexao;
import org.example.module.Bolo;
import org.example.module.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoBolo {

    public void inserirBolo(String ingrediente, Integer quantidade){
        String sql = "INSERT INTO bolo(ingrediente, quantidade) values(?,?)";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, ingrediente);
            pst.setInt(2, quantidade);

            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir novo bolo: " + e.getMessage());

        }
    }

    public void deletarTudo(){
        String sql_deleteTudo = "Delete from bolo";

        try {
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql_deleteTudo);
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao deletar todos os ingredientes: " + e.getMessage() );
        }
    }

    public List<Bolo> listarBolos(){
        List<Bolo> boloList = new ArrayList<>();

        String sql = "SELECT * FROM bolo;";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
               Bolo novoBolo = new Bolo(rs.getInt("id"), rs.getString("ingrediente"), rs.getInt("quantidade"));

                boloList.add(novoBolo);
            }
            return boloList;

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());

            return null;
        }

    }

    public void updateBolo(Integer id, String ingrediente, Integer quantidade){
        String sql_update = "UPDATE bolo set ingrediente = ?, quantidade= ? where id = ?";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql_update);

            pst.setString(1, ingrediente);
            pst.setInt(2, quantidade);
            pst.setInt(3, id);

            pst.executeUpdate();

        }catch(SQLException e){
            System.out.println("Erro ao atualizar o bolo: " + e.getMessage());
        }

    }

    public void deletarBolo(Integer id){
        String sql_deleteTudo = "Delete from bolo where id = ?";

        try {
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql_deleteTudo);
            pst.setInt(1, id);
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao deletar todos os ingredientes: " + e.getMessage() );
        }
    }

}
