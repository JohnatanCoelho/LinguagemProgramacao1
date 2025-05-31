package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.example.dao.DaoBolo;
import org.example.module.Bolo;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class BoloController {

    @FXML
    private Button btnAdicionar;

    @FXML
    private TextField txtCobertura;

    @FXML
    private TextField txtIngrediente;

    @FXML
    private TextField txtNomeBolo;

    @FXML
    private TextField txtQuantidade;

    @FXML
    private TableColumn<Bolo, String> tblIngredientes;

    @FXML
    private TableColumn<Bolo, Integer> tblQuantidade;

    @FXML
    private TableView<Bolo> tblView;

    @FXML
    private Label lblCobertura;

    @FXML
    private Label lblNome;

    ObservableList<Bolo> ingredientes = FXCollections.observableArrayList();

    Bolo novoBolo;

    DaoBolo daoBolo = new DaoBolo();

    @FXML
    void adicionarIngredientes(ActionEvent event) {
        // Adicionando Ingredientes
      String ingrediente = txtIngrediente.getText();
      Integer quantidade = Integer.parseInt(txtQuantidade.getText());

      daoBolo.inserirBolo(ingrediente, quantidade);

        // Limpando Campos
        limparCampos();
        atualizarTabela();
    }

    @FXML
    void enviarDados(ActionEvent event) {

        String nome = txtNomeBolo.getText();
        String cobertura = txtCobertura.getText();
        //Status
        lblNome.setText(nome);
        lblCobertura.setText(cobertura);

        daoBolo.deletarTudo();

        atualizarTabela();

        //Limpando
        limparCampos();

    }

    public void atualizarTabela(){
        List<Bolo> boloList = daoBolo.listarBolos();

        ingredientes.clear();

        for(Bolo bolo: boloList){
            ingredientes.add(bolo);
        }

        tblView.setItems(ingredientes);
        limparCampos();
    }

    @FXML
    void AtualizarIngrediente(ActionEvent event) {
        if (novoBolo != null){
            daoBolo.updateBolo(novoBolo.getId(), txtIngrediente.getText(), Integer.parseInt(txtQuantidade.getText()));

            novoBolo = null;
            limparCampos();
            atualizarTabela();

        }   else{
            alerta();
        }
    }

    @FXML
    void deletarIngrediente(ActionEvent event) {
        if (novoBolo != null) {
            Alert alertarDelete = new Alert(Alert.AlertType.CONFIRMATION, "Deseja mesmo excluir! ", ButtonType.YES, ButtonType.NO);

            Optional<ButtonType> result = alertarDelete.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.YES){
                daoBolo.deletarBolo(novoBolo.getId());

                limparCampos();
                atualizarTabela();
                novoBolo = null;

            }

        } else {
            alerta();
        }
    }

    @FXML
    void pegarLinha(MouseEvent event) {
        int i = tblView.getSelectionModel().getSelectedIndex();

        novoBolo = tblView.getItems().get(i);

        txtIngrediente.setText(novoBolo.getIngredientes());
        txtQuantidade.setText(Integer.toString(novoBolo.getQuantidade()));
    }

    @FXML
    void voltaTelaPrincipal(ActionEvent event) throws IOException {
        org.example.App.setRoot("telaPrincipal");
    }

    public void limparCampos(){
        txtIngrediente.clear();
        txtNomeBolo.clear();
        txtQuantidade.clear();
        txtCobertura.clear();
    }

    @FXML
    void initialize(){
        //Indicando os valores na tabela
        tblIngredientes.setCellValueFactory(new PropertyValueFactory<>("ingredientes"));
        tblQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));

        tblView.setItems(ingredientes);
        atualizarTabela();
    }

    public void alerta(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Ação");
        alert.setHeaderText("Selecione a linha da tabela primeiro!");
        alert.show();
    }


}
