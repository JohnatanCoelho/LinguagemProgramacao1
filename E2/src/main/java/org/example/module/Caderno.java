package org.example.module;

import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;

public class Caderno {
    private Integer id;
    private String tamanho;
    private String cor;
    private int numPaginas;
    private String tipo;

    @FXML
    private Rectangle capa;

    public Caderno(Integer id, String tamanho, String cor, Integer numPaginas, String tipo) {
       this.id = id;
        this.tamanho = tamanho;
        this.cor = cor;
        this.numPaginas = numPaginas;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public String getCor() {
        return cor;
    }

    public Rectangle getCapa() {
        return capa;
    }

    public String getTamanho() {
        return tamanho;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getNumPaginas() {
        return numPaginas;
    }

    public void  arrancarPaginas() {
        if(this.numPaginas > 0 ) {
            this.numPaginas = this.numPaginas - 1;
        }
    }

}
