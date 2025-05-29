package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.example.module.Caderno;

import java.io.IOException;

public class CadernoController {

    @FXML
    private Button btnEnviar;

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


    Caderno novoCaderno;

    @FXML
    void enviarDadosCaderno(ActionEvent event) {
        // Tamanho 20 matérias
        String tamanho = txtTamanho.getText();
        String tipo = txtTipo.getText();
        Integer paginas = Integer.parseInt(txtPagina.getText());
        String cor = corCombo.getValue();

        novoCaderno = new Caderno(tamanho, cor, paginas,tipo);

        lblTotalPg.setText(txtPagina.getText());

        //Limpando campos
        txtPagina.clear();
        txtTamanho.clear();
        txtTipo.clear();
        txtArea.clear();

        // Trocar a cor da capa
        if (cor == "Azul") {
            capa.setFill(Color.BLUE);
        } else if (cor == "Amarelo"){
            capa.setFill(Color.YELLOW);
        } else if(cor == "Verde"){
            capa.setFill(Color.GREEN);
        } else if(cor == "Roxo"){
            capa.setFill(Color.PURPLE);
        }
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
    }

}