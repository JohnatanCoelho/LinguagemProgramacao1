package org.example.dao;

import org.example.database.Conexao;
import org.example.module.Animal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoAnimal {

    public void inserirAnimal(String animal, String nome, Integer idade, String tipo, String costume,String movimento){
        String sql = "INSERT INTO animal(animal, nome, idade, tipo, costume, movimento) values(?,?,?,?,?,?)";
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, animal);
            pst.setString(2, nome);
            pst.setInt(3, idade);
            pst.setString(4, tipo);
            pst.setString(5, costume);
            pst.setString(6, movimento);

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage() );
            e.printStackTrace();
        }
    }

    public List<Animal> listarAnimais(){
        String sql_select = "SELECT * FROM animal ";
        List<Animal> animalList = new ArrayList<>();

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql_select);

            ResultSet result =  pst.executeQuery();

            while(result.next()){
                Animal animalnovo = new Animal(result.getInt("id"), result.getString("animal"),
                        result.getString("nome"), result.getString("tipo"), result.getInt("idade"),
                        result.getString("costume"), result.getString("movimento"));

                        animalList.add(animalnovo);
            }
            return animalList;

        } catch (SQLException e) {
            System.out.println("Erro ao listar os animais: " + e.getMessage());
            return null;
        }

    }

    public void updateAnimal(Integer id, String animal, String nome, String tipo, Integer idade, String costume, String movimento ){
        String sql_update = "UPDATE animal set animal = ?, nome = ?, tipo = ?, idade = ?, " +
                "costume = ?, movimento = ? where id = ?";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql_update);

            pst.setString(1, animal);
            pst.setString(2, nome);
            pst.setString(3, tipo);
            pst.setInt(4, idade);
            pst.setString(5, costume);
            pst.setString(6, movimento);
            pst.setInt(7, id);

            pst.executeUpdate();

        }catch(SQLException e){
            System.out.println("Erro ao atualizar o animal: " + e.getMessage());
        }

    }

    public void deletarAnimal(Integer id){
        String sql_delete = "Delete from animal where id = ?";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement pst = conn.prepareStatement(sql_delete);

            pst.setInt(1, id);
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao deletar animal " + e.getMessage());
        }
    }
}
