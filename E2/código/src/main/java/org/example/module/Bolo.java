package org.example.module;

public class Bolo {
    private Integer id;
    private String nomeBolo;
    private Integer quantidade;
    private String ingredientes;
    private String cobertura;

    public Bolo(Integer id, String ingrediente, Integer quantidade){
        this.id = id;
        this.ingredientes = ingrediente;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
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

}




