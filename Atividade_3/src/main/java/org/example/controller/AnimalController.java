package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AnimalController {

    @FXML
    private Button btnEnviar;

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

            Animal novoAnimal = new Animal(animal, nome, tipo, idade, costume, movimento);

            txtAnimal.setText("");
            txtNome.setText("");
            txtIdade.setText("");
            txtTipo.setText("");
            txtCostume.setText("");
            txtMovimento.setText("");

            txtAreaInf.setText(novoAnimal.mostrarInformacaoAnimal());

    }

}
