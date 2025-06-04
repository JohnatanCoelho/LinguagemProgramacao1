package org.example.dao;

import javafx.collections.ObservableList;
import org.example.database.Conexao;
import org.example.module.Carro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoCarro {

    public void inserirCarro(String nome, String marca){
        String sql = "INSERT INTO carro(nome, marca) values(?,?)";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, nome);
            pst.setString(2, marca);

            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir novo carro: " + e.getMessage());

        }
    }

    public List<Carro> buscarCarros(){
        String sql_select = "SELECT * FROM carro";
        List<Carro> carroList = new ArrayList<>();

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql_select);

            ResultSet result = pst.executeQuery();

            while(result.next()){

            Carro carro = new Carro(result.getInt("id"), result.getString("nome"), result.getString("marca"));
            carroList.add(carro);
            }

            return carroList;
        } catch(SQLException e) {

            System.out.println("Erro ao buscar carro: " + e.getMessage());

            return null;
        }

    }

    public void updateCarro(Integer id, String nome, String marca){
        String sql_update = "UPDATE carro SET nome = ?, marca = ? where id = ?";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql_update);
            pst.setString(1, nome);
            pst.setString(2, marca);
            pst.setInt(3, id);

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar carro: " + e.getMessage());
        }
    }

    public void deletarCarro(Integer id){
        String sql_delete = "DELETE FROM carro where id= ?";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql_delete);
            pst.setInt(1, id);

            pst.executeUpdate();

        } catch (SQLException e){
            System.out.println("Erro ao deletar o carro: " + e.getMessage());
        }
    }

}
