package org.example.dao;

import org.example.database.Conexao;
import org.example.module.Livro;
import org.example.module.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoLivro {

    public void inserirLivro(String nomeLivro, String autor, Integer anoLancamento, String citacao1, String citacao2, String citacao3){
        String sql = "INSERT INTO livro(nome, autor, ano_lancamento, citacao_1, citacao_2, citacao_3) values(?,?,?,?,?,?)";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, nomeLivro);
            pst.setString(2, autor);
            pst.setInt(3, anoLancamento);
            pst.setString(4, citacao1);
            pst.setString(5, citacao2);
            pst.setString(6, citacao3);

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir novo instrumento: " + e.getMessage());

        }
    }

    public List<Livro> listarLivros(){
        List<Livro> livroList = new ArrayList<>();

        String sql = "SELECT * FROM livro;";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
               Livro livro = new Livro(rs.getInt("id"), rs.getString("nome"), rs.getString("autor"), rs.getInt("ano_lancamento"),
                       rs.getString("citacao_1"), rs.getString("citacao_2"), rs.getString("citacao_3"));

                livroList.add(livro);
            }
            return livroList;
        } catch (SQLException e) {
            System.out.println("Erro ao listar os livros : " + e.getMessage());

            return null;
        }

    }

    public void updateLivro(Integer id, String nome, String autor, Integer ano, String citacao1, String citacao2, String citacao3){
        String sql_update = "UPDATE livro set nome = ?, autor = ?, ano_lancamento = ?, citacao_1 = ?, citacao_2 = ?, citacao_3 = ? where id = ?";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql_update);
            pst.setString(1, nome);
            pst.setString(2, autor);
            pst.setInt(3, ano);
            pst.setString(4,citacao1);
            pst.setString(5, citacao2);
            pst.setString(6, citacao3);
            pst.setInt(7, id);

            pst.executeUpdate();

        } catch(SQLException e){
            System.out.println("Erro ao atualizar o livro: " + e.getMessage());
        }

    }

    public void deletarLivro(Integer id){
        String sql_deleteTudo = "Delete from livro where id = ?";

        try {
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql_deleteTudo);
            pst.setInt(1, id);
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao deletar o livro: " + e.getMessage() );
        }
    }
}
