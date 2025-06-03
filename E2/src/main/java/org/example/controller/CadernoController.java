package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.example.dao.DaoCaderno;
import org.example.module.Caderno;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class CadernoController {

    @FXML
    private Button btnEnviar;

    @FXML
    private TableColumn<Caderno, String> tblCor;

    @FXML
    private TableColumn<Caderno, String> tblTamanho;

    @FXML
    private TableColumn<Caderno, String> tblTipo;

    @FXML
    private TableView<Caderno> tblView;

    @FXML
    private Button btnVoltar;

    @FXML
    private Rectangle capa;

    @FXML
    private ComboBox<String> corCombo;

    @FXML
    private TextField txtPagina;

    @FXML
    private TextField txtTamanho;

    @FXML
    private TextField txtTipo;

    @FXML
    private TextArea txtArea;

    @FXML
    private Label lblTotalPg;

    private DaoCaderno daoCaderno = new DaoCaderno();

    Caderno novoCaderno;

    ObservableList<Caderno> cadernoList = FXCollections.observableArrayList();

    @FXML
    void enviarDadosCaderno(ActionEvent event) {
        // Tamanho 20 matérias
        String tamanho = txtTamanho.getText();
        String tipo = txtTipo.getText();
        Integer paginas = Integer.parseInt(txtPagina.getText());
        String cor = corCombo.getValue();

        daoCaderno.inserirCaderno(tamanho, cor, paginas, tipo);

        //Limpando campos
       limparCampos();
       atualizarTabela();

    }

    public void atualizarTabela(){
        List<Caderno> listaCaderno = daoCaderno.listarCadernos();

        cadernoList.clear();

        for(Caderno caderno : listaCaderno){
            cadernoList.add(caderno);
        }

        limparCampos();
        tblView.setItems(cadernoList);

    }

    public void limparCampos(){
        //Limpando campos
        txtPagina.clear();
        txtTamanho.clear();
        txtTipo.clear();
        txtArea.clear();
        lblTotalPg.setText("...");
        capa.setFill(Color.WHITE);
    }

    @FXML
    void atualizarCaderno(ActionEvent event) {
        /* Método de atualizar pessoas da lista da tabela*/
        if(novoCaderno != null){

            daoCaderno.updateCaderno(novoCaderno.getId(), txtTamanho.getText(), corCombo.getValue().toString(),
                    Integer.parseInt(txtPagina.getText()), txtTipo.getText());

            // Limpando
            novoCaderno = null;
            limparCampos();
            atualizarTabela();

        } else {
            alerta();
        }
    }

    @FXML
    void deletarCaderno(ActionEvent event) {
        if (novoCaderno != null) {
            Alert alertarDelete = new Alert(Alert.AlertType.CONFIRMATION, "Deseja mesmo excluir! ", ButtonType.YES, ButtonType.NO);

            Optional<ButtonType> result = alertarDelete.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.YES){
                daoCaderno.deletarCaderno(novoCaderno.getId());

                limparCampos();
                atualizarTabela();
                novoCaderno = null;
            }

        } else {
            alerta();
        }
    }

    @FXML
    void pegarLinha(MouseEvent event) {
        int i = tblView.getSelectionModel().getSelectedIndex();

        novoCaderno = (Caderno) tblView.getItems().get(i);

        txtTamanho.setText(novoCaderno.getTamanho());
        txtPagina.setText(Integer.toString(novoCaderno.getNumPaginas()));
        txtTipo.setText(novoCaderno.getTipo());
        corCombo.setValue(novoCaderno.getCor());

        String cor = novoCaderno.getCor();
        System.out.println(cor);

        // Trocar a cor da capa
        if (cor.equalsIgnoreCase( "Azul")) {
            capa.setFill(Color.BLUE);
        } else if (cor.equalsIgnoreCase( "Amarelo")){
            capa.setFill(Color.YELLOW);
        } else if(cor.equalsIgnoreCase("Verde")){
            capa.setFill(Color.GREEN);
        } else if(cor.equalsIgnoreCase("Roxo")){
            capa.setFill(Color.PURPLE);
        }

        lblTotalPg.setText(Integer.toString(novoCaderno.getNumPaginas()));

    }

    public void alerta(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Ação");
        alert.setHeaderText("Selecione a linha da tabela primeiro!");
        alert.show();
    }


    @FXML
    void TrocaPagina(ActionEvent event) {
        txtArea.clear();
        txtArea.setPromptText("Página trocada...");
    }

    @FXML
    void arrancarUmaFolhaCaderno(ActionEvent event) {
        novoCaderno.arrancarPaginas();
        lblTotalPg.setText(Integer.toString(novoCaderno.getNumPaginas()));

    }


    @FXML
    void voltarTelaPrincipal(ActionEvent event) throws IOException {
        org.example.App.setRoot("telaPrincipal");
    }

    @FXML
    void initialize(){

        corCombo.getItems().addAll("Azul", "Amarelo", "Verde", "Roxo");

        tblTamanho.setCellValueFactory(new PropertyValueFactory<>("tamanho"));
        tblCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        tblTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

        atualizarTabela();
    }

}