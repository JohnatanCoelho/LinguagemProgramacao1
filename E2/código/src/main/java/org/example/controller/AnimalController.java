package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.example.dao.DaoAnimal;
import org.example.module.Animal;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class AnimalController {

    @FXML
    private Button btnEnviar;

    @FXML
    private TableView<Animal> tblView;

    @FXML
    private TableColumn<Animal, String> animalTb;

    @FXML
    private TableColumn<Animal, String> costumeAnimal;

    @FXML
    private TableColumn<Animal, Integer> idAnimal;

    @FXML
    private TableColumn<Animal, Integer> idadeAnimal;

    @FXML
    private TableColumn<Animal, String> movimentoAnimal;

    @FXML
    private TableColumn<Animal, String> nomeAnimaĺ;

    @FXML
    private TableColumn<Animal, String> tipoAnimal;

    @FXML
    private TextField txtAnimal;

    @FXML
    private TextArea txtAreaInf;

    @FXML
    private TextField txtCostume;

    @FXML
    private TextField txtIdade;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtTipo;

    @FXML
    private TextField txtMovimento;

    @FXML
    private Button voltar;

   private ObservableList<Animal> animalList = FXCollections.observableArrayList();

   private Animal animalLinha;

   private DaoAnimal daoAnimal = new DaoAnimal();

    @FXML
    void voltarTelaPrincipal(ActionEvent event) throws IOException {
        org.example.App.setRoot("telaPrincipal");
    }

    @FXML
    void EnviarDados(ActionEvent event) {
            String animal = txtAnimal.getText();
            String nome = txtNome.getText();
            Integer idade = Integer.parseInt(txtIdade.getText());
            String tipo = txtTipo.getText();
            String costume = txtCostume.getText();
            String movimento = txtMovimento.getText();

            daoAnimal.inserirAnimal(animal, nome, idade, tipo, costume, movimento);

            limparCampos();

            atualizarTabela();

    }

    @FXML
    void atualizarAnimal(ActionEvent event) {
        if (animalLinha != null){
            daoAnimal.updateAnimal(animalLinha.getId(), txtAnimal.getText(), txtNome.getText(),
                    txtTipo.getText(), Integer.parseInt(txtIdade.getText()), txtCostume.getText(), txtMovimento.getText());

            animalLinha = null;
            atualizarTabela();
            limparCampos();

        } else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Ação");
            alert.setHeaderText("Selecione a linha da tabela primeiro!");
            alert.show();
        }
    }

    @FXML
    void deletarAnimal(ActionEvent event) {
        if (animalLinha != null){
           Alert alertarDelete = new Alert(Alert.AlertType.CONFIRMATION, "Deseja excluir mesmo?", ButtonType.YES, ButtonType.NO);

           Optional<ButtonType> resultado = alertarDelete.showAndWait();
           if (resultado.isPresent() && resultado.get() == ButtonType.YES){
               daoAnimal.deletarAnimal(animalLinha.getId());

               animalLinha = null;
               txtAreaInf.clear();
               atualizarTabela();
           }
        }   else {
            alertar();
        }
    }


    public void atualizarTabela(){

        List<Animal> anmList = daoAnimal.listarAnimais();
        animalList.clear();

        for(Animal anm : anmList ){
            animalList.add(anm);
        }

        tblView.setItems(animalList);

        limparCampos();

    }

    public void limparCampos(){

        txtAnimal.clear();
        txtNome.clear();
        txtIdade.clear();
        txtTipo.clear();
        txtMovimento.clear();
        txtCostume.clear();
        txtAreaInf.clear();
    }

    @FXML
    void pegarDadosLinha(MouseEvent event) {
        int i = tblView.getSelectionModel().getSelectedIndex();
        animalLinha = tblView.getItems().get(i);

        //Ação de mudar a textarea
        txtAreaInf.setText(animalLinha.mostrarInformacaoAnimal());

        // Adicionando para atualizar o dado ou deletar dentro dos texts
        txtAnimal.setText(animalLinha.getAnimal());
        txtNome.setText(animalLinha.getNome());
        txtIdade.setText(Integer.toString(animalLinha.getIdade()));
        txtTipo.setText(animalLinha.getTipo());
        txtCostume.setText(animalLinha.getCostumeAnimal());
        txtMovimento.setText(animalLinha.getMovimento());

    }

    public void alertar(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Ação");
        alert.setHeaderText("Selecione a linha da tabela primeiro!");
        alert.show();
    }


    @FXML
    void initialize(){
        idAnimal.setCellValueFactory(new PropertyValueFactory<>("id"));
        animalTb.setCellValueFactory(new PropertyValueFactory<>("animal"));
        nomeAnimaĺ.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tipoAnimal.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        idadeAnimal.setCellValueFactory(new PropertyValueFactory<>("idade"));
        costumeAnimal.setCellValueFactory(new PropertyValueFactory<>("costumeAnimal"));
        movimentoAnimal.setCellValueFactory(new PropertyValueFactory<>("movimento"));

        tblView.setItems(animalList);

        atualizarTabela();
    }



}
