package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import java.io.IOException;

public class LivroController {

    @FXML
    private Button btnCitacao;

    @FXML
    private Button btnEnviar;

    @FXML
    private Button btnVolta;

    @FXML
    private TextField txtAno;

    @FXML
    private TextArea txtAreaCitacao;

    @FXML
    private TextArea txtAreaDesc;

    @FXML
    private TextField txtAutor;

    @FXML
    private TextField txtCitacao;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCitacao2;

    @FXML
    private TextField txtCitacao3;

    @FXML
    private Label lblAviso;

    Livro novoLivro;


    @FXML
    void enviarDadosLivro(ActionEvent event) {
        String nome = txtNome.getText();
        String autor = txtAutor.getText();
        Integer anoLancamento = Integer.parseInt(txtAno.getText());
        novoLivro = new Livro(nome, autor, anoLancamento);

        // Limpando campos
        txtNome.setText("");
        txtAutor.setText("");
        txtAno.setText("");

        // Enviando a descrição do Livro
        txtAreaDesc.setText(novoLivro.exibirLivro());

    }

    @FXML
    void enviarCitacao(ActionEvent event) {
        if(novoLivro == null) {
            lblAviso.setText("Por favor, cadastre o livro antes de adicionar citações.");
        }   else {
        String citacao1 = txtCitacao.getText();
        String citacao2 = txtCitacao2.getText();
        String citacao3 = txtCitacao3.getText();
        novoLivro.adicionarCitacao(citacao1, citacao2, citacao3);

        //Colocando para mostrar na tela
        txtAreaCitacao.setText(novoLivro.exibirCitacao());
        txtAreaCitacao.setWrapText(true);

        // Limpeza de campos
        txtCitacao.clear();
        txtCitacao2.clear();
        txtCitacao3.clear();

        }

    }

    @FXML
    void voltaTelaPrincipal(ActionEvent event)  throws IOException {
        org.example.App.setRoot("telaPrincipal");
    }

}
