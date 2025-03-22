package atividade2;

import java.util.Scanner;

public class Planta {
    String nome;
    String tipo;
    String cor;
    int nivelAgua;

    public Planta(String nome, String tipo, String cor){
        this.nome = nome;
        this.tipo = tipo;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCor() {
        return cor;
    }

    public int getNivelAgua(){
        return nivelAgua;
    }

   public int verificarONivelAgua(Scanner entrada){
       System.out.println("Qual o nível de agua da planta?");
        int nivel = entrada.nextInt();
        this.nivelAgua = nivel;
        return nivel;
   }
    public void regar(Scanner entrada){
        System.out.println(getNome() + " precisa de agua!" );
        System.out.println("Encher até o nível: ");
        int nivel = entrada.nextInt();
        this.nivelAgua = nivel;
        System.out.println("A planta está no nível de água: " + getNivelAgua());
    }

    public void mostrarInformacaoPlanta() {
        System.out.println("---------------");
        System.out.println("Planta: " + getNome());
        System.out.println("Tipo: " + getTipo());
        System.out.println("Cor: " + getCor());
        System.out.println("Nível de água: " + getNivelAgua());
        System.out.println(" ");
        System.out.println("Desrição do tipo de planta 🌱: ");
        if(this.tipo.equalsIgnoreCase("Angiosperma")){
            System.out.println(getTipo().toUpperCase()+ ": " + " são plantas vasculares com sementes que se \ncaracterizam por apresentar flor e fruto!");
        }
        else if(this.tipo.equalsIgnoreCase("Briofitas")){
            System.out.println(getTipo().toUpperCase() + ": " + " são plantas pequenas, avasculares e não vasculares,\nque incluem musgos, hepáticas e antóceros!");
        }
        else if(this.tipo.equalsIgnoreCase("pteridofitas")){
            System.out.println(getTipo().toUpperCase() + ": " + "são um grupo parafilético de vegetais vasculares sem sementes!");
        }
        else if ( this.tipo.equalsIgnoreCase("gimnospermas")) {
            System.out.println(getTipo().toUpperCase() + ": " + "árvores ou arbustos lenhosos que apresentam raízes, folhas,\ncaules, estróbilos (como a pinha), sementes e vasos condutores! ");
        }
        System.out.println("---------------");
        System.out.println("");
    }
}
