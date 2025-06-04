package org.example.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import org.example.dao.DaoCarro;
import org.example.module.Carro;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class CarroController {

    @FXML
    private TextField txtNomeCarro;

    @FXML
    private TableColumn<Carro, Integer> tblId;

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

    Carro carro;
    DaoCarro daoCarro = new DaoCarro();
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

        daoCarro.inserirCarro(nomeCarro, marcaCarro);

        atualizarTabela();
    }

    public void atualizarTabela(){
        //Método atualiza a tabela com novos dados
        List<Carro> carList = daoCarro.buscarCarros();

        carroList.clear();

        for(Carro novoCarro: carList){
            carroList.add(novoCarro);
        }

        tblView.setItems(carroList);

        //Limpando
        txtNomeCarro.clear();
        txtMarcaCarro.clear();
    }

    @FXML
    void pegarLinha(MouseEvent event) {
        int i = tblView.getSelectionModel().getSelectedIndex();

        carro = tblView.getItems().get(i);

        txtNomeCarro.setText(carro.getNome());
        txtMarcaCarro.setText(carro.getMarca());
    }

    @FXML
    void atualizarCarro(ActionEvent event) {
        /* Método de atualizar pessoas da lista da tabela*/
        if(carro != null){
            // Pegando os novos dados e mandando para o dao
            daoCarro.updateCarro(carro.getId(), txtNomeCarro.getText(),
                    txtMarcaCarro.getText());

            // Limpando
            carro = null;
            txtNomeCarro.clear();
            txtMarcaCarro.clear();

        } else {
            alerta();
        }
        atualizarTabela();
    }

    @FXML
    void deletarCarro(ActionEvent event) {
        /*Método de deletar a pessoa*/

        if (carro!= null){

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Deseja excluir mesmo?",ButtonType.YES, ButtonType.NO);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.YES){
                daoCarro.deletarCarro(carro.getId());
               carro = null;
            }
        }else{
            alerta();
        }

        atualizarTabela();
    }


    public void alerta(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Ação");
        alert.setHeaderText("Selecione a linha da tabela primeiro!");
        alert.show();
    }

    @FXML
    void initialize(){
        // Indicando a mudança de células - Destinos dos dados
        tblId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblNomeCarro.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tblMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));

        tblView.setItems(carroList);

        atualizarTabela();

    }

}
