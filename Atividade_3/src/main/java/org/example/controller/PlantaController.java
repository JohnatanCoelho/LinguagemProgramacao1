package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PlantaController {

    @FXML
    private Button btnEnviar;

    @FXML
    private TextField txtCor;

    @FXML
    private TextField txtNivel;

    @FXML
    private TextField txtNome;

    @FXML
    private Button btnNivel;

    @FXML
    private TextField txtTipo;

    @FXML
    private Label nivelAguaResultado;

    @FXML
    private Label statusPlanta;

    @FXML
    private TextArea txtAreaDsc;

    Planta novaPlanta;

    @FXML
    void enviarDados(ActionEvent event) {
            // Pegando dados da Planta
            String nome = txtNome.getText();
            String tipo = txtTipo.getText();
            String cor = txtCor.getText();
            Integer nivelAgua = Integer.parseInt(txtNivel.getText());

            novaPlanta = new Planta(nome, tipo, cor, nivelAgua);

            //Limpando campos
            txtNome.setText("");
            txtTipo.setText("");
            txtCor.setText("");
            txtNivel.setText("");

        // Verificar o nível da água
            statusPlanta.setText(novaPlanta.verificarONivelAgua());
            nivelAguaResultado.setText(Integer.toString(nivelAgua));

            // Descrição da Planta
            txtAreaDsc.setText(novaPlanta.mostrarInformacaoPlanta());

    }

    @FXML
    void aumentarAgua(ActionEvent event) {
        Integer nivelAgua = Integer.parseInt(txtNivel.getText());
        novaPlanta.setNivelAgua(nivelAgua);

        // Verificar o nível da água
        statusPlanta.setText(novaPlanta.verificarONivelAgua());
        nivelAguaResultado.setText(Integer.toString(nivelAgua));
    }

}
