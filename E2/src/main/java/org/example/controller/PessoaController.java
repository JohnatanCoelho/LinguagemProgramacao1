package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.example.dao.DaoPessoa;
import org.example.module.Pessoa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PessoaController {

    @FXML
    private Button btnEnviar;

    @FXML
    private TableColumn<?, ?> tblId;

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

    Pessoa pessoaDalinha;

    // Dao
    DaoPessoa pessoaDao = new DaoPessoa();

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
            pessoaDao.inserirDados(nome, sexo, idade);

        txtAreaAcao.setText(nome + " está caminhando!\n"
                + nome + " está sentado!\n"
                + nome + " está comendo!");

            atualizarTabela();

    }

    public void atualizarTabela(){
        List<Pessoa> listaPessoa = pessoaDao.listarPessoas();

        pessoaList.clear();

        //adicionando a pessoa na lista
        for (Pessoa novaPessoa: listaPessoa) {
            pessoaList.add(novaPessoa);
        }

        tblView.setItems(pessoaList);

        // Alterando o espaço TextField
        textNome.setText("");
        textIdade.setText("");
        textSexo.setText("");

    }

    @FXML
    void pegarLinha(MouseEvent event) {
        int i = tblView.getSelectionModel().getSelectedIndex();

        pessoaDalinha = tblView.getItems().get(i);

        textNome.setText(pessoaDalinha.getNome());
        textSexo.setText(pessoaDalinha.getSexo());
        textIdade.setText(Integer.toString(pessoaDalinha.getIdade()));

    }

    @FXML
    void atualizarPessoa(ActionEvent event) {
        if(pessoaDalinha != null){
            // Pegando os novos dados e mandando para o dao
            pessoaDao.updatePessoa(pessoaDalinha.getId(), textNome.getText(),
                    textSexo.getText(), Integer.parseInt(textIdade.getText()));

            // Limpando
            pessoaDalinha = null;
            textNome.clear();
            textIdade.clear();
            textSexo.clear();

        } else {
            alerta();
        }
        atualizarTabela();
    }

    @FXML
    void deletarPessoas(ActionEvent event) {
        if (pessoaDalinha != null){

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Deseja excluir mesmo?",ButtonType.YES, ButtonType.NO);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.YES){
                pessoaDao.deletarPessoa(pessoaDalinha.getId());
                pessoaDalinha = null;
            }
        }else{
            alerta();
        }

        atualizarTabela();
    }

    public void alerta(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Ação");
        alert.setHeaderText("Selecione a linha da tabela primeiro!");
        alert.show();
    }

    @FXML
    public void initialize(){

        // Definindo dados para cada coluna tabela
        tblId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tblSexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        tblIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));

        tblView.setItems(pessoaList);

        atualizarTabela();
    }

}
