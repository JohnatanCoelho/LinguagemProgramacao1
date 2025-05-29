package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.module.Bolo;

import java.io.IOException;

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

    @FXML
    void adicionarIngredientes(ActionEvent event) {
        // Adicionando Ingredientes
        novoBolo = new Bolo(Integer.parseInt(txtQuantidade.getText()),txtIngrediente.getText());
        ingredientes.add(novoBolo);
        // Limpando Campos
        txtIngrediente.setText("");
        txtQuantidade.setText("");
    }

    @FXML
    void enviarDados(ActionEvent event) {
        String nome = txtNomeBolo.getText();
        String cobertura = txtCobertura.getText();
        //Status
        lblNome.setText(nome);
        lblCobertura.setText(cobertura);

        // Limpando Campos
        txtNomeBolo.setText("");
        txtCobertura.setText("");

    }

    @FXML
    void voltaTelaPrincipal(ActionEvent event) throws IOException {
        org.example.App.setRoot("telaPrincipal");
    }

    @FXML
    void initialize(){
        //Indicando os valores na tabela
        tblIngredientes.setCellValueFactory(new PropertyValueFactory<>("ingredientes"));
        tblQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));

        tblView.setItems(ingredientes);
    }


}
