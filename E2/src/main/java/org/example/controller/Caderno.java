package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.Scanner;

public class Caderno {
    private String tamanho;
    private String cor;
    private int numPaginas;
    private String tipo;

    @FXML
    private Rectangle capa;

    public Caderno(String tamanho, String cor, int numPaginas, String tipo) {
        this.tamanho = tamanho;
        this.cor = cor;
        this.numPaginas = numPaginas;
        this.tipo = tipo;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void  arrancarPaginas() {
        if(this.numPaginas > 0 ) {
            this.numPaginas = this.numPaginas - 1;
        }
    }

}
