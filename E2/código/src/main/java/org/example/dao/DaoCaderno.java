package org.example.dao;

import org.example.database.Conexao;
import org.example.module.Caderno;
import org.example.module.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoCaderno {

    public void inserirCaderno(String tamanho, String cor, Integer num_pagina, String tipo){
        String sql = "INSERT INTO caderno(tamanho, cor, numero_pag, tipo) values(?,?,?,?)";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, tamanho);
            pst.setString(2, cor);
            pst.setInt(3, num_pagina);
            pst.setString(4, tipo);

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir novo caderno: " + e.getMessage());

        }
    }

    public List<Caderno> listarCadernos(){
        List<Caderno> cadernoList = new ArrayList<>();

        String sql = "SELECT * FROM caderno;";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                Caderno caderno = new Caderno(rs.getInt("id"), rs.getString("tamanho"),
                        rs.getString("cor"), rs.getInt("numero_pag"), rs.getString("tipo"));
                cadernoList.add(caderno);
            }
            return cadernoList;
        } catch (SQLException e) {
            System.out.println("Erro ao listar os cadernos : " + e.getMessage());

            return null;
        }

    }

    public void deletarCaderno(Integer id){
        String sql_delete = "DELETE FROM caderno where id = ?";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql_delete);

            pst.setInt(1, id);
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao deletar o caderno: " + e.getMessage());
        }
    }

    public void updateCaderno(Integer id, String tamanho, String cor, Integer numero_pag, String tipo){

        String sql_update = "UPDATE caderno SET tamanho = ?, cor = ?, numero_pag = ?, tipo = ? where id = ?";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql_update);
            pst.setString(1, tamanho);
            pst.setString(2, cor);
            pst.setInt(3, numero_pag);
            pst.setString(4, tipo);
            pst.setInt(5, id);
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o caderno: "+ e.getMessage());
        }
    }
}
