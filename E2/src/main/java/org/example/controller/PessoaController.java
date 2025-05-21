package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class PessoaController {

    @FXML
    private Button btnEnviar;

    @FXML
    private TableColumn<Pessoa, Integer> tblIdade;

    @FXML
    private TableColumn<Pessoa, String> tblNome;

    @FXML
    private TableColumn<Pessoa, String> tblSexo;

    @FXML
    private TableView<Pessoa> tblView;

    @FXML
    private TextArea txtAreaAcao;

    @FXML
    private TextField textIdade;

    @FXML
    private TextField textNome;

    @FXML
    private TextField textSexo;

    @FXML
    private Button voltar;

    private ObservableList<Pessoa> pessoaList = FXCollections.observableArrayList();

    @FXML
    void voltarTelaPrincipal(ActionEvent event) throws IOException {
            org.example.App.setRoot("telaPrincipal");
    }

    @FXML
    void pegarDadosPessoa(ActionEvent event) {

        // Pegando os dados
            String nome = textNome.getText();
            String sexo = textSexo.getText();
            Integer idade = Integer.parseInt(textIdade.getText());

            Pessoa novaPessoa = new Pessoa(nome, sexo, idade);

            //adicionando a pessoa na lista
            pessoaList.add(novaPessoa);

            // Alterando o espaço TextField
            textNome.setText("");
            textIdade.setText("");
            textSexo.setText("");

            txtAreaAcao.setText(nome + " está caminhando!\n"
                                + nome + " está sentado!\n"
                                + nome + " está comendo!");
    }

    @FXML
    public void initialize(){

        // Definindo dados para cada coluna tabela
        tblNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tblSexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        tblIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));

        tblView.setItems(pessoaList);
    }

}
