package atividade2;

public class Carro {
    private String nome;
    private String marca;
    private boolean ligado;
    private int ponteiro;

    public Carro(String nome, String marca, int ponteiro, boolean ligado){
        this.nome = nome;
        this.marca = marca;
        this.ponteiro = ponteiro;
        this.ligado = ligado;
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

