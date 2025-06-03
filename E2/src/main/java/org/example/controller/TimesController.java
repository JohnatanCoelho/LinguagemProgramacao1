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
import java.util.List;
import java.util.Optional;

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
        daoTime.inserirPartida(casa, visitante, arena, golsCasa, golsVisitante);

        // Limpando campos
        limparCampos();
        atualizarTabela();

    }

    public void atualizarTabela(){
        List<TimeDeFutebol> tm = daoTime.listarTime();

        timeList.clear();

        for (TimeDeFutebol time : tm){
            timeList.add(time);
        }

        limparCampos();
        tblView.setItems(timeList);
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

        txtArea.setText(novaPartida.mostrarPlacar());


    }

    @FXML
    void atualizarPartida(ActionEvent event) {
        if(novaPartida != null){
            // Pegando os novos dados e mandando para o dao
           daoTime.updatePartida(novaPartida.getId(), txtCasa.getText(),
                    txtVisitante.getText(), txtArena.getText(), golCasa.getValue(), golVisitante.getValue());

            // Limpando
            novaPartida = null;
            limparCampos();
            atualizarTabela();
            txtArea.clear();
        } else {
            alerta();
        }
        atualizarTabela();
    }

    @FXML
    void deletarPartida(ActionEvent event) {
        if (novaPartida != null) {
            Alert alertarDelete = new Alert(Alert.AlertType.CONFIRMATION, "Deseja mesmo excluir! ", ButtonType.YES, ButtonType.NO);

            Optional<ButtonType> result = alertarDelete.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.YES){
                daoTime.deletarPartida(novaPartida.getId());

                limparCampos();
                atualizarTabela();
                novaPartida = null;
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


    public void limparCampos(){
        txtArea.clear();
        txtCasa.clear();
        txtVisitante.clear();
        golCasa.setValue(0);
        golVisitante.setValue(0);
        txtArea.clear();
        txtArena.clear();
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

        tblView.setItems(timeList);
        atualizarTabela();
    }


}
