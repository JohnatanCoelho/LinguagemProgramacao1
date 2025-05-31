package org.example.dao;

import org.example.database.Conexao;
import org.example.module.Animal;
import org.example.module.Instrumento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoInstrumento {

    public void inserirInstrumento(String nome, String caminho){
        String sql = "INSERT INTO instrumento(nome, caminho) values(?,?)";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, nome);
            pst.setString(2, caminho);

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir novo instrumento: " + e.getMessage());

        }
    }

    public List<Instrumento> listarInstrumentos(){
        String sql_select = "SELECT * FROM instrumento";
        List<Instrumento> instrumentoList= new ArrayList<>();

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql_select);

            ResultSet result =  pst.executeQuery();

            while(result.next()){
                Instrumento instrumentoNovo = new Instrumento(result.getInt("id"),
                        result.getString("nome"), result.getString("caminho"));

                instrumentoList.add(instrumentoNovo);
            }
            return instrumentoList;

        } catch (SQLException e) {
            System.out.println("Erro ao listar os instrumentos: " + e.getMessage());
            return null;
        }

    }

    public void updateInstrumento(Integer id, String nome, String caminho){
        String sql_update = "UPDATE instrumento set nome = ?, caminho= ? where id = ?";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql_update);

            pst.setString(1, nome);
            pst.setString(2, caminho);
            pst.setInt(3, id);

            pst.executeUpdate();

        }catch(SQLException e){
            System.out.println("Erro ao atualizar o instrumento: " + e.getMessage());
        }

    }

    public void deletarInstrumento(Integer id){
        String sql_delete = "DELETE FROM instrumento where id= ?";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql_delete);
            pst.setInt(1, id);

            pst.executeUpdate();

        } catch (SQLException e){
            System.out.println("Erro ao deletar o instrumento: " + e.getMessage());
        }
    }
}
