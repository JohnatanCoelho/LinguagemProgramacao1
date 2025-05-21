package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;


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

    Instrumento novoInstrumento;

    @FXML
    void voltarTelaPrincipal (ActionEvent event) throws IOException {
        org.example.App.setRoot("telaPrincipal");
    }

    @FXML
    void enviarDados(ActionEvent event) {
       // C:\Users\John\Desktop\atividade3\src\main\resources\org\example\somInstrumento\guitarra.wav
           novoInstrumento = new Instrumento(txtNomeInstrumento.getText(), chkLigado.isSelected(),sliderVolume.getValue(), txtCaminho.getText());
    }


    @FXML
    void mudarVolume(MouseEvent event) {
       Integer volume = (int) sliderVolume.getValue();
        lblVol.setText(Integer.toString(volume));
    }

    @FXML
    void pauseSom(ActionEvent event) {
        novoInstrumento.pararSom();
    }

    @FXML
    void playSom(ActionEvent event) {
        novoInstrumento.tocarSom();
    }



}
