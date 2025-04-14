package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class TimesController {

    @FXML
    private Button btnEnviar;

    @FXML
    private Button btnExibir;

    @FXML
    private Button btnVoltar;

    @FXML
    private ComboBox<Integer> golCasa;

    @FXML
    private ComboBox<Integer> golVisitante;

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtArena;

    @FXML
    private TextField txtCasa;

    @FXML
    private TextField txtVisitante;

    TimeDeFutebol novaPartida;

    @FXML
    void VoltarTelaPrincipal(ActionEvent event) throws IOException {
        org.example.App.setRoot("telaPrincipal");
    }

    @FXML
    void enviarDadosDaPartida(ActionEvent event) {
        String arena = txtArena.getText();
        String casa = txtCasa.getText();
        String visitante = txtVisitante.getText();

        // Determinando os dados da partida
        novaPartida = new TimeDeFutebol(casa, arena,visitante);

        // Limpando campos
        txtArea.clear();
        txtCasa.clear();
        txtVisitante.clear();

    }

    @FXML
    void exibirResultado(ActionEvent event) {
        Integer golsCasa = golCasa.getValue();
        Integer golsVisitante = golVisitante.getValue();

        //Atualizando os gols da partida
        novaPartida.perguntarOPlacar(golsCasa, golsVisitante);

        // Verificação de resultados
        txtArea.setText(novaPartida.mostrarPlacar());
    }

    @FXML
    void initialize(){
        golCasa.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10);
        golVisitante.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10);
    }


}
