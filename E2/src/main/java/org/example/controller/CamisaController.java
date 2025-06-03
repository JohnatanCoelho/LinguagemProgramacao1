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
import org.example.dao.DaoCamisa;
import org.example.module.Camisa;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class CamisaController {

    @FXML
    private Rectangle RtCorCamisa;

    @FXML
    private TableColumn<Camisa, String> tblCor;

    @FXML
    private TableColumn<Camisa, String > tblTam;

    @FXML
    private TableColumn<Camisa, String> tblTipo;

    @FXML
    private TableView<Camisa> tblView;

    @FXML
    private Button btnEnviar;

    @FXML
    private Button btnLavar;

    @FXML
    private Button btnVoltar;

    @FXML
    private CheckBox chkVestir;

    @FXML
    private TextField txtTamanho;

    @FXML
    private TextField txtTipo;

    @FXML
    private Label lblStatus;

    @FXML
    private Label lblVestida;

    @FXML
    private Label lblAviso;

    @FXML
    private ComboBox<String> cmbCor;

    DaoCamisa daoCamisa = new DaoCamisa();

    Camisa novaCamisa;



    private ObservableList<Camisa> camisaList = FXCollections.observableArrayList();

    @FXML
    void enviarDadosCamisa(ActionEvent event) {
        String tamanho = txtTamanho.getText();
        String cor = cmbCor.getValue();
        String tipo = txtTipo.getText();

        daoCamisa.inserirCamisa(tamanho, cor, tipo);

        atualizarTabela();

        novaCamisa = null;

       limparCampos();
    }

    @FXML
    void pegarLinha(MouseEvent event) {
        int i = tblView.getSelectionModel().getSelectedIndex();

        novaCamisa = tblView.getItems().get(i);

        txtTamanho.setText(novaCamisa.getTamanho());
        txtTipo.setText(novaCamisa.getTipo());
        cmbCor.setValue(novaCamisa.getCor());
        lblAviso.setText("Aviso");

        String cor = novaCamisa.getCor();

        if (cor.equalsIgnoreCase( "Azul")){
            RtCorCamisa.setFill(Color.BLUE);
        } else if (cor.equalsIgnoreCase("Amarelo")) {
            RtCorCamisa.setFill(Color.YELLOW);
        } else if(cor.equalsIgnoreCase( "Verde")){
            RtCorCamisa.setFill(Color.GREEN);
        } else if(cor.equalsIgnoreCase("Roxo")){
            RtCorCamisa.setFill(Color.PURPLE);
        } else if(cor.equalsIgnoreCase( "Vermelho")){
            RtCorCamisa.setFill(Color.RED);
        }

    }

    public void limparCampos(){
        //Limpando campos
        txtTamanho.clear();
        txtTipo.clear();
        cmbCor.setValue("");
        RtCorCamisa.setFill(Color.WHITE);

        lblVestida.setText("...");
        lblStatus.setText("...");

    }

    public void atualizarTabela(){
        List<Camisa> listaCamisa = daoCamisa.listarCamisas();

        camisaList.clear();

        for (Camisa camisa : listaCamisa){
            camisaList.add(camisa);
        }

        tblView.setItems(camisaList);
    }

    @FXML
    void vestirACamisa(ActionEvent event) {

        if (novaCamisa == null) {
            lblAviso.setText("Primeiro cadastre a camisa!");
        } else {
            lblVestida.setText(novaCamisa.vestir());

            if (chkVestir.isSelected() == false) {
                lblVestida.setText(novaCamisa.tirarCamisa());
            }
        }
    }

    @FXML
    void lavarCamisa(ActionEvent event) {
        if (novaCamisa == null){
            lblAviso.setText("Primeiro cadastre a camisa!");
        } else if (chkVestir.isSelected()){
            lblStatus.setText("Primeiro tire a camisa para lavar!");
        }   else {
            lblStatus.setText(novaCamisa.lavar());
        }
    }

    @FXML
    void atualizarCamisa(ActionEvent event) {
        /* Método de atualizar pessoas da lista da tabela*/
        if(novaCamisa != null){

            daoCamisa.updateCamisa(novaCamisa.getId(), txtTamanho.getText(), cmbCor.getValue(), txtTipo.getText());

            // Limpando
            novaCamisa = null;
            limparCampos();
            atualizarTabela();

        } else {
            alerta();
        }
    }

    @FXML
    void deletarCamisa(ActionEvent event) {
        if (novaCamisa != null) {
            Alert alertarDelete = new Alert(Alert.AlertType.CONFIRMATION, "Deseja mesmo excluir! ", ButtonType.YES, ButtonType.NO);

            Optional<ButtonType> result = alertarDelete.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.YES){
                daoCamisa.deletarCamisa(novaCamisa.getId());

                limparCampos();
                atualizarTabela();
                novaCamisa = null;
            }

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

    @FXML
    void voltarTelaPrincipal(ActionEvent event) throws IOException {
            org.example.App.setRoot("telaPrincipal");
    }

    @FXML
    void initialize(){

        cmbCor.getItems().addAll("Azul", "Amarelo", "Verde", "Roxo", "Vermelho");

        tblTam.setCellValueFactory(new PropertyValueFactory<>("tamanho"));
        tblCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        tblTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

        tblView.setItems(camisaList);
        atualizarTabela();
    }

}
