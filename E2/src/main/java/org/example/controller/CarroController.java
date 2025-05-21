package org.example.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;

import java.io.IOException;

public class CarroController {

    @FXML
    private TextField txtNomeCarro;

    @FXML
    private Button btnEnviarDadosCarro;


    @FXML
    private RadioButton rdLigar;

    @FXML
    private TextField txtMarcaCarro;

    @FXML
    private Label lblOnEOff;

    @FXML
    private TableColumn<Carro, String> tblMarca;

    @FXML
    private TableColumn<Carro, String> tblNomeCarro;

    @FXML
    private Slider sldNivel;

    @FXML
    private TableView<Carro> tblView;

    @FXML
    private Button voltar;

    private ObservableList<Carro> carroList = FXCollections.observableArrayList();

    @FXML
    void voltarTelaPrincipal(ActionEvent event) throws IOException {
        org.example.App.setRoot("telaPrincipal");

    }

    @FXML
    void PegarDadosCarro(ActionEvent event) {

        if(rdLigar.isSelected()){
            lblOnEOff.setText("Carro ligado! ");
            // Atualiza o valor do slider gradualmente

            Timeline timeline = new Timeline();
            sldNivel.setValue(0);
            for(Integer i = 0; i <= 100; i++){
                final int step = i;
                KeyFrame keyframe = new KeyFrame(Duration.millis(i * 50), e ->{
                    sldNivel.setValue(step);
                });
                timeline.getKeyFrames().add(keyframe);
            }
            timeline.play();

        } else {
            lblOnEOff.setText("Carro desligado! ");

        }

        String nomeCarro = txtNomeCarro.getText();
        String marcaCarro = txtMarcaCarro.getText();

        Carro novoCarro = new Carro(nomeCarro, marcaCarro);

        txtNomeCarro.setText("");
        txtMarcaCarro.setText("");

        carroList.add(novoCarro);

    }

    @FXML
    void initialize(){
        // Indicando a mudança de células - Destinos dos dados
        tblNomeCarro.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tblMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));

        tblView.setItems(carroList);

    }

}
