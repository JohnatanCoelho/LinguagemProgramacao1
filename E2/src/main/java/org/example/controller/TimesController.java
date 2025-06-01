package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.example.dao.DaoTime;
import org.example.module.TimeDeFutebol;

import java.io.IOException;
import java.sql.Time;

public class TimesController {

    @FXML
    private Button btnEnviar;

    @FXML
    private TableColumn<TimeDeFutebol, String> tblArena;

    @FXML
    private TableColumn<TimeDeFutebol, String> tblCasa;

    @FXML
    private TableColumn<TimeDeFutebol, Integer> tblGolCasa;

    @FXML
    private TableColumn<TimeDeFutebol, Integer> tblGolVisitante;

    @FXML
    private TableView<TimeDeFutebol> tblView;

    @FXML
    private TableColumn<?, ?> tblVisitante;

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

   private TimeDeFutebol novaPartida;

   private DaoTime daoTime = new DaoTime();

   private ObservableList<TimeDeFutebol> timeList = FXCollections.observableArrayList();


    @FXML
    void VoltarTelaPrincipal(ActionEvent event) throws IOException {
        org.example.App.setRoot("telaPrincipal");
    }

    @FXML
    void enviarDadosDaPartida(ActionEvent event) {
        String arena = txtArena.getText();
        String casa = txtCasa.getText();
        String visitante = txtVisitante.getText();
        Integer golsCasa = golCasa.getValue();
        Integer golsVisitante = golVisitante.getValue();

        // Determinando os dados da partida
        daoTime.inserirPartida();

        // Limpando campos
        limparCampos();
        txtArea.setText(novaPartida.mostrarPlacar());
    }


    @FXML
    void pegarLinha(MouseEvent event) {
        int i = tblView.getSelectionModel().getSelectedIndex();

        novaPartida = tblView.getItems().get(i);

        txtCasa.setText(novaPartida.getTimeCasa());
        txtVisitante.setText(novaPartida.getTimeVisitante());
        txtArena.setText(novaPartida.getArena());
        golCasa.setValue(novaPartida.getGolsCasa());
        golVisitante.setValue(novaPartida.getGolsVisitante());


    }

    public void limparCampos(){
        txtArea.clear();
        txtCasa.clear();
        txtVisitante.clear();
        golCasa.setValue(0);
        golVisitante.setValue(0);
        txtArea.clear();
    }

    @FXML
    void initialize(){
        golCasa.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10);
        golVisitante.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10);

        tblCasa.setCellValueFactory(new PropertyValueFactory<>("timeCasa"));
        tblVisitante.setCellValueFactory(new PropertyValueFactory<>("timeVisitante"));
        tblArena.setCellValueFactory(new PropertyValueFactory<>("arena"));
        tblGolCasa.setCellValueFactory(new PropertyValueFactory<>("golsCasa"));
        tblGolVisitante.setCellValueFactory(new PropertyValueFactory<>("golsVisitante"));
    }


}
