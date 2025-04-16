package org.example.controller;

import java.util.Scanner;

public class Camisa{
    private String tamanho;
    private String cor;
    private String tipo;
    private Boolean vestida;

    public Camisa(String tamanho, String cor, String tipo) {
        this.tamanho = tamanho;
        this.cor = cor;
        this.tipo = tipo;

    }

    public String lavar() {
        String lavada = "Lavando a camisa...";
        return lavada;

    }

    public String vestir(){
        this.vestida = true;
        String camisaVestida = "Vestindo camisa...";
        return camisaVestida;
    }

    public String tirarCamisa(){
        this.vestida = false;
        String camisaTirada = "Tirando camisa...";
        return camisaTirada;
    }



}
