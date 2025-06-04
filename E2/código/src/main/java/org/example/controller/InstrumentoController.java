package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.example.dao.DaoInstrumento;
import org.example.module.Instrumento;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


public class InstrumentoController {

    @FXML
    private Button btnPause;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnEnviar;

    @FXML
    private Label lblVol;

    @FXML
    private CheckBox chkLigado;

    @FXML
    private Slider sliderVolume;

    @FXML
    private TextField txtCaminho;

    @FXML
    private TextField txtNomeInstrumento;

    @FXML
    private Button voltar;

    @FXML
    private TableColumn<Instrumento, Integer> tblId;

    @FXML
    private TableColumn<Instrumento, String> tblNome;

    @FXML
    private TableView<Instrumento> tblView;

    ObservableList<Instrumento> instrumentoList = FXCollections.observableArrayList();

    Instrumento novoInstrumento;

    DaoInstrumento daoIntrumento = new DaoInstrumento();

    @FXML
    void atualizarInstrumento(ActionEvent event) {
        if (novoInstrumento != null){
            daoIntrumento.updateInstrumento(novoInstrumento.getId(), txtNomeInstrumento.getText(), txtCaminho.getText());

            novoInstrumento = null;
            limparCampos();
            atualizarTabela();

        }   else{
            alerta();
        }
    }

    @FXML
    void deletarInstrumento(ActionEvent event) {
        if (novoInstrumento != null) {
            Alert alertarDelete = new Alert(Alert.AlertType.CONFIRMATION, "Deseja mesmo excluir! ", ButtonType.YES, ButtonType.NO);

            Optional<ButtonType> result = alertarDelete.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.YES){
                daoIntrumento.deletarInstrumento(novoInstrumento.getId());

                limparCampos();
                atualizarTabela();
                novoInstrumento = null;

            }

        } else {
            alerta();
        }
    }

    public void atualizarTabela(){
        List<Instrumento> instList = daoIntrumento.listarInstrumentos();

        instrumentoList.clear();

        for(Instrumento inst: instList){
            instrumentoList.add(inst);
        }

        tblView.setItems(instrumentoList);

        limparCampos();

    }


    @FXML
    void voltarTelaPrincipal (ActionEvent event) throws IOException {
        org.example.App.setRoot("telaPrincipal");
    }

    @FXML
    void enviarDados(ActionEvent event) {
       // C:\Users\John\Desktop\atividade3\src\main\resources\org\example\somInstrumento\guitarra.wav
        String nome = txtNomeInstrumento.getText();
        String caminho = txtCaminho.getText();

        daoIntrumento.inserirInstrumento(nome, caminho);

        limparCampos();

        atualizarTabela();

    }

    @FXML
    void mudarVolume(MouseEvent event) {
       Integer volume = (int) sliderVolume.getValue();
        lblVol.setText(Integer.toString(volume));
    }

    @FXML
    void pegarLinha(MouseEvent event) {
            int i = tblView.getSelectionModel().getSelectedIndex();

            novoInstrumento = tblView.getItems().get(i);

            txtNomeInstrumento.setText(novoInstrumento.getNomeInstrumento());
            txtCaminho.setText(novoInstrumento.getCaminhoSom());

    }

    @FXML
    void pauseSom(ActionEvent event) {
        if(novoInstrumento != null){
            novoInstrumento.pararSom();
        } else{
            alerta();
        }
    }

    @FXML
    void playSom(ActionEvent event) {
        if (novoInstrumento != null){
        novoInstrumento.tocarSom(novoInstrumento.getCaminhoSom());
        } else {
            alerta();
        }
    }

    public void alerta(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Ação");
        alert.setHeaderText("Selecione a linha da tabela primeiro!");
        alert.show();
    }

    public void limparCampos(){

       txtNomeInstrumento.clear();
       txtCaminho.clear();
    }


    @FXML
    public void initialize(){

        // Definindo dados para cada coluna tabela
        tblId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblNome.setCellValueFactory(new PropertyValueFactory<>("nomeInstrumento"));

        tblView.setItems(instrumentoList);

        atualizarTabela();
    }


}
