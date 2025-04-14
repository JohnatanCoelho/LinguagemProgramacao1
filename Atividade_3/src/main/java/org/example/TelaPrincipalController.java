package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;

public class TelaPrincipalController {

    @FXML
    private Button btnAnimal;

    @FXML
    private Button btnCarro;

    @FXML
    private Button btnPessoa;

    @FXML
    private Button btnPlanta;

    @FXML
    private Button btnInstrumento;

    @FXML
    private Button btnBolo;

    @FXML
    private Button btnLivro;

    @FXML
    private Button btnTimes;

    @FXML
    void trocaTelaCarro(ActionEvent event) throws IOException {
        App.setRoot("carro");
    }
    @FXML
    void trocaTelaPessoa(ActionEvent event) throws IOException {
        App.setRoot("pessoa");
    }
    @FXML
    void trocaTelaInstrumento(ActionEvent event) throws IOException{
        App.setRoot("instrumento");
    }

    @FXML
    void trocaTelaAnimal(ActionEvent event) throws IOException {
            App.setRoot("animal");
    }

    @FXML
    void trocaTelaBolo(ActionEvent event) throws IOException {
        App.setRoot("bolo");
    }

    @FXML
    void trocaTelaPlanta(ActionEvent event) throws IOException{
        App.setRoot("planta");
    }

    @FXML
    void trocaTelaLivro(ActionEvent event) throws IOException {
        App.setRoot("livro");

    }

    @FXML
    void trocaTelaTimes(ActionEvent event) throws IOException{
        App.setRoot("times");
    }

    @FXML
    void trocaTelaCaderno(ActionEvent event) throws IOException{
        App.setRoot("caderno");
    }
}
