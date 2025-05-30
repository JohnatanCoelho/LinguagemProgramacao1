package org.example.module;

public class Carro {
    private Integer id;
    private String nome;
    private String marca;
    private boolean ligado;
    private int ponteiro;

    public Carro(Integer id, String nome, String marca){
        this.id = id;
        this.nome = nome;
        this.marca = marca;
    }

    public Integer getId(){ return id; }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public void ligarCarro(){

        if(ligado != true){
            System.out.println("Ligando carro!");
            this.ligado = true;
        }else{
            System.out.println("O carro já está ligado!");
        }

    }
    public void acelerar(int incremento, int limiteVelocidade) {
        if (this.ligado) {
            System.out.println("Acelerando...");
            while(incremento + this.ponteiro <= limiteVelocidade){
                this.ponteiro += incremento;
                System.out.println("Nível ponteiro: " + this.ponteiro);
            }
        }else{
            System.out.println("O carro desligado, não é possível acelerar!");
        }
    }

    public void freiar(int discremento){
        if(this.ligado){
            System.out.println("Freiando...");
            while(this.ponteiro - discremento > 0){
                this.ponteiro -= discremento;
                System.out.println("Nível ponteiro : " + this.ponteiro);
            }
        }
    }
}

