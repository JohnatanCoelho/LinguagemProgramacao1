package org.example.dao;

import com.mysql.cj.protocol.Resultset;
import org.example.module.Pessoa;
import org.example.database.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoPessoa {

    public void inserirDados(String nome, String sexo, Integer idade){
        String sql = "INSERT INTO pessoa(nome, sexo, idade) values(?,?,?)";
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, nome);
            pst.setString(2, sexo);
            pst.setInt(3, idade);

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage() );
            e.printStackTrace();
        }
    }

    public List<Pessoa> listarPessoas(){
        List<Pessoa> pessoaList = new ArrayList<>();

        String sql = "SELECT * FROM pessoa;";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                Pessoa novaPessoa = new Pessoa(rs.getInt("id"), rs.getString("nome"), rs.getString("sexo"), rs.getInt("idade"));

                pessoaList.add(novaPessoa);
            }
            return pessoaList;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());

            return null;
        }

    }

    public void updatePessoa(Integer id,String nome, String sexo, Integer idade){

        String sql = "UPDATE pessoa set nome = ?, sexo = ?, idade = ? where id = ?";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, nome);
            pst.setString(2,sexo);
            pst.setInt(3, idade);
            pst.setInt(4, id);

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error para atualizar a pessoa: " + e.getMessage());
        }
    }

    public void deletarPessoa(Integer id){
        String sql_deletar = "DELETE FROM pessoa where id = ?";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql_deletar);

            pst.setInt(1, id);

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao DELETAR pessoa: " + e.getMessage());
        }
    }
}
