package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.example.dao.DaoLivro;
import org.example.module.Livro;

import java.awt.font.FontRenderContext;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class LivroController {

    @FXML
    private Button btnCitacao;


    @FXML
    private TableColumn<Livro, Integer> tblAno;

    @FXML
    private TableColumn<Livro, String> tblAutor;

    @FXML
    private TableColumn<Livro, String> tblNome;

    @FXML
    private TableView<Livro> tblView;

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

    ObservableList<Livro> livroList = FXCollections.observableArrayList();

    Livro novoLivro;

    DaoLivro daoLivro = new DaoLivro();


    @FXML
    void enviarDadosLivro(ActionEvent event) {
        String nome = txtNome.getText();
        String autor = txtAutor.getText();
        Integer anoLancamento = Integer.parseInt(txtAno.getText());

        String citacao1 = txtCitacao.getText();
        String citacao2 = txtCitacao2.getText();
        String citacao3 = txtCitacao3.getText();

        daoLivro.inserirLivro(nome, autor, anoLancamento, citacao1, citacao2, citacao3);

        limparCampos();
        txtAreaCitacao.clear();

        atualizarTabela();

    }

    public void atualizarTabela(){
        List<Livro> listaLivro = daoLivro.listarLivros();

        livroList.clear();

        for(Livro livro: listaLivro){
            livroList.add(livro);
        }

        tblView.setItems(livroList);
    }

    @FXML
    void atualizarLivro(ActionEvent event) {
        /* Método de atualizar pessoas da lista da tabela*/
        if(novoLivro != null){

            daoLivro.updateLivro(novoLivro.getId(), txtNome.getText(), txtAutor.getText(),
                    Integer.parseInt(txtAno.getText()), txtCitacao.getText(), txtCitacao2.getText(), txtCitacao3.getText());

            // Limpando
            novoLivro = null;
            limparCampos();
            atualizarTabela();
            txtAreaCitacao.clear();

        } else {
            alerta();
        }
    }

    @FXML
    void deletarLivro(ActionEvent event) {
        if (novoLivro != null) {
            Alert alertarDelete = new Alert(Alert.AlertType.CONFIRMATION, "Deseja mesmo excluir! ", ButtonType.YES, ButtonType.NO);

            Optional<ButtonType> result = alertarDelete.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.YES){
                daoLivro.deletarLivro(novoLivro.getId());

                limparCampos();
                atualizarTabela();
                novoLivro = null;
                txtAreaCitacao.clear();

            }

        } else {
            alerta();
        }
    }

    @FXML
    void pegarLinha(MouseEvent event) {
        int i = tblView.getSelectionModel().getSelectedIndex();
        novoLivro = tblView.getItems().get(i);

        txtNome.setText(novoLivro.getNomeLivro());
        txtAutor.setText(novoLivro.getAutor());
        txtAno.setText(Integer.toString(novoLivro.getAnoLancamento()));
        txtCitacao.setText(novoLivro.getCitacao1());
        txtCitacao2.setText(novoLivro.getCitacao2());
        txtCitacao3.setText(novoLivro.getCitacao3());

        txtAreaCitacao.setText(novoLivro.exibirCitacao());
        txtAreaCitacao.setWrapText(true);

    }

    public void alerta(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Ação");
        alert.setHeaderText("Selecione a linha da tabela primeiro!");
        alert.show();
    }


    public void limparCampos(){
        // Limpeza de campos
        txtCitacao.clear();
        txtCitacao2.clear();
        txtCitacao3.clear();

        txtNome.clear();
        txtAutor.clear();
        txtAno.clear();
    }

    @FXML
    void voltaTelaPrincipal(ActionEvent event)  throws IOException {
        org.example.App.setRoot("telaPrincipal");
    }

    @FXML
    void initialize(){
        tblNome.setCellValueFactory(new PropertyValueFactory<>("nomeLivro"));
        tblAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        tblAno.setCellValueFactory(new PropertyValueFactory<>("anoLancamento"));

        atualizarTabela();
    }

}
