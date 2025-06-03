package org.example.dao;

import org.example.database.Conexao;
import org.example.module.Camisa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoCamisa {

    public void inserirCamisa(String tamanho, String cor, String tipo){
        String sql = "INSERT INTO camisa(tamanho, cor, tipo) values(?,?,?)";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, tamanho);
            pst.setString(2, cor);
            pst.setString(3, tipo);

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir nova camisa: " + e.getMessage());
        }

    }

    public List<Camisa> listarCamisas(){
        List<Camisa> camisaList = new ArrayList<>();

        String sql = "SELECT * FROM camisa;";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                Camisa camisa = new Camisa(rs.getInt("id"), rs.getString("tamanho"),
                        rs.getString("cor"), rs.getString("tipo"));
                   camisaList.add(camisa);
            }
            return camisaList;
        } catch (SQLException e) {
            System.out.println("Erro ao listar as camisas : " + e.getMessage());

            return null;
        }

    }

    public void updateCamisa(Integer id, String tamanho, String cor, String tipo){
        String sql_update = "UPDATE camisa SET tamanho = ?, cor = ?, tipo = ? where id = ?";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql_update);
            pst.setString(1 , tamanho);
            pst.setString(2, cor);
            pst.setString(3, tipo);
            pst.setInt(4, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar camisa: " + e.getMessage() );
        }
    }

    public void deletarCamisa(Integer id){
        String sql_delete = "DELETE FROM camisa where id = ?";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql_delete);
            pst.setInt(1, id);

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao deletar a camisa: " + e.getMessage());
        }
    }
}
