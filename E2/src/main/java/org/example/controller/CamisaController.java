package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.example.module.Camisa;

import java.io.IOException;

public class CamisaController {

    @FXML
    private Rectangle RtCorCamisa;

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

    Camisa novaCamisa;

    @FXML
    void enviarDadosCamisa(ActionEvent event) {
        String tamanho = txtTamanho.getText();
        String cor = cmbCor.getValue();
        String tipo = txtTipo.getText();

        novaCamisa = new Camisa(tamanho, cor, tipo);

        //Limpando Campos
        txtTamanho.clear();
        txtTipo.clear();

        if (cor == "Azul"){
            RtCorCamisa.setFill(Color.BLUE);
        } else if (cor == "Amarelo") {
            RtCorCamisa.setFill(Color.YELLOW);
        } else if(cor == "Verde"){
            RtCorCamisa.setFill(Color.GREEN);
        } else if(cor == "Roxo"){
            RtCorCamisa.setFill(Color.PURPLE);
        } else if(cor == "Vermelho"){
            RtCorCamisa.setFill(Color.RED);
        }
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
    void voltarTelaPrincipal(ActionEvent event) throws IOException {
            org.example.App.setRoot("telaPrincipal");
    }

    @FXML
    void initialize(){
        cmbCor.getItems().addAll("Azul", "Amarelo", "Verde", "Roxo", "Vermelho");
    }

}
