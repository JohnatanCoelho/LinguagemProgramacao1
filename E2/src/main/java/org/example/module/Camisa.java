package org.example.module;

public class Camisa{
    private Integer id;
    private String tamanho;
    private String cor;
    private String tipo;
    private Boolean vestida;

    public Camisa(Integer id, String tamanho, String cor, String tipo) {
        this.id = id;
        this.tamanho = tamanho;
        this.cor = cor;
        this.tipo = tipo;

    }

    public String getTamanho() {
        return tamanho;
    }

    public String getCor() {
        return cor;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getId() {
        return id;
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
