package org.example.controller;

import java.util.ArrayList;

public class Bolo {
    private String nomeBolo;
    private int quantidade;
    private String ingredientes;
    private String cobertura;

    public Bolo(int quantidade, String ingrediente){
        adicionarIngredientes(quantidade, ingrediente);
    }

    public String getNomeBolo() {
        return nomeBolo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setNomeBolo(String nomeBolo) {
        this.nomeBolo = nomeBolo;
    }

    public void adicionarIngredientes(int quantidade,String nomeIngrediente){
        this.ingredientes = nomeIngrediente;
        this.quantidade = quantidade;

    }

    public void finalizarBolo(String cobertura){
        this.cobertura = cobertura;
        System.out.println("Finalizando o bolo " + getNomeBolo() + " com cobertura de " + cobertura);
    }

}




