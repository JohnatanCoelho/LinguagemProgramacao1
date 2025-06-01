package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.example.dao.DaoBolo;
import org.example.dao.DaoPlanta;
import org.example.module.Pessoa;
import org.example.module.Planta;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class PlantaController {

    @FXML
    private Button btnEnviar;

    @FXML
    private TableView<Planta> tblView;

    @FXML
    private TableColumn<Planta, String> tblCor;

    @FXML
    private TableColumn<Planta, String> tblNome;

    @FXML
    private TableColumn<Planta, String> tblTipo;

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

    @FXML
    private Button btnVoltar;

    ObservableList<Planta> plantaList = FXCollections.observableArrayList();

    Planta novaPlanta;

    DaoPlanta daoPlanta = new DaoPlanta();

    @FXML
    void enviarDados(ActionEvent event) {
            // Pegando dados da Planta
            String nome = txtNome.getText();
            String tipo = txtTipo.getText();
            String cor = txtCor.getText();
            Integer nivelAgua = Integer.parseInt(txtNivel.getText());

            daoPlanta.inserirPlanta(nome, tipo, cor, nivelAgua);

        statusPlanta.setText("...");
        nivelAguaResultado.setText("...");

        txtAreaDsc.clear();
            limparCampos();
            atualizarTabela();

    }

    public void limparCampos(){
        //Limpando campos
        txtNome.clear();
        txtTipo.clear();
        txtCor.clear();
        txtNivel.clear();
    }


    @FXML
    void atualizarPlanta(ActionEvent event) {
        if (novaPlanta != null){
            String nome = txtNome.getText();
            String tipo = txtTipo.getText();
            String cor = txtCor.getText();
            Integer nivelAgua = Integer.parseInt(txtNivel.getText());

            daoPlanta.updatePlanta(novaPlanta.getId(),nome, tipo, cor, nivelAgua);


            statusPlanta.setText("...");
            nivelAguaResultado.setText("...");

            txtAreaDsc.clear();

            novaPlanta = null;
            limparCampos();
            atualizarTabela();

        } else {
            alerta();
        }
    }

    @FXML
    void deletarPlanta(ActionEvent event) {
        if(novaPlanta != null){
            Alert alertDelete = new Alert(Alert.AlertType.CONFIRMATION, "Deseja excluir mesmo?", ButtonType.YES, ButtonType.NO);

            Optional<ButtonType> resultado = alertDelete.showAndWait();
            if(resultado.isPresent() && resultado.get() == ButtonType.YES){
                daoPlanta.deletarPlanta(novaPlanta.getId());

                statusPlanta.setText("...");
                nivelAguaResultado.setText("...");

                txtAreaDsc.clear();

                novaPlanta = null;
                limparCampos();
                atualizarTabela();
            }
        } else {
            alerta();
        }
    }

    public void atualizarTabela(){
        List<Planta> listaPlanta = daoPlanta.listarPlantas();

        plantaList.clear();

        //adicionando a pessoa na lista
        for (Planta planta: listaPlanta) {
           plantaList.add(planta);
        }

        tblView.setItems(plantaList);

      limparCampos();

    }


    @FXML
    void pegarLinha(MouseEvent event) {
        int i = tblView.getSelectionModel().getSelectedIndex();

        novaPlanta = tblView.getItems().get(i);

        txtNome.setText(novaPlanta.getNome());
        txtTipo.setText(novaPlanta.getTipo());
        txtCor.setText(novaPlanta.getCor());

        //Verificar o Nível da água
        statusPlanta.setText(novaPlanta.verificarONivelAgua());
        nivelAguaResultado.setText(Integer.toString(novaPlanta.getNivelAgua()));

        // Descrição da Planta
        txtAreaDsc.setText(novaPlanta.mostrarInformacaoPlanta());
    }

    @FXML
    void voltarTelaPrincipal(ActionEvent event) throws IOException {
        org.example.App.setRoot("telaPrincipal");
    }

    public void alerta(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Ação");
        alert.setHeaderText("Selecione a linha da tabela primeiro!");
        alert.show();
    }

    @FXML
    void initialize(){

        tblNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tblTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tblCor.setCellValueFactory(new PropertyValueFactory<>("cor"));

        atualizarTabela();
    }


}
