package org.example.controller;

import java.util.Scanner;

public class Planta {
    private String nome;
    private String tipo;
    private String cor;
    private int nivelAgua;

    public Planta(String nome, String tipo, String cor, Integer nivelAgua){
        this.nome = nome;
        this.tipo = tipo;
        this.cor = cor;
        this.nivelAgua = nivelAgua;
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

    public void setNivelAgua(int nivelAgua) {
        this.nivelAgua = nivelAgua;
    }

    public String verificarONivelAgua(){
       String nivel;
       if (nivelAgua < 10){
           nivel = "A planta precisa de água";
       }else {
           nivel = "A planta já está regada!";
       }
       return nivel;
   }

    public void regar(){
        System.out.println(getNome() + " precisa de agua!" );
        System.out.println("Encher até o nível: ");
        System.out.println("A planta está no nível de água: " + getNivelAgua());
    }

    public String mostrarInformacaoPlanta() {
        String descricao;
        if(this.tipo.equalsIgnoreCase("Angiosperma")){
            descricao = "Desrição do tipo de planta 🌱:\n\n"+ getTipo().toUpperCase()+ ": " + " são plantas vasculares com sementes que se \ncaracterizam por apresentar flor e fruto!";
        }
        else if(this.tipo.equalsIgnoreCase("Briofitas")){
            descricao = "Desrição do tipo de planta 🌱:\n\n"+ getTipo().toUpperCase() + ": " + " são plantas pequenas, avasculares e não vasculares,\nque incluem musgos, hepáticas e antóceros!";
        }
        else if(this.tipo.equalsIgnoreCase("pteridofitas")){
            descricao = "Desrição do tipo de planta 🌱:\n\n" + getTipo().toUpperCase() + ": " + "são um grupo parafilético de vegetais vasculares sem sementes!";
        }
        else if ( this.tipo.equalsIgnoreCase("gimnospermas")) {
            descricao = "Desrição do tipo de planta 🌱:\n\n" + getTipo().toUpperCase() + ": " + "árvores ou arbustos lenhosos que apresentam raízes, folhas,\ncaules, estróbilos (como a pinha), sementes e vasos condutores! ";
        } else{
            descricao = "";
        }
        return descricao;
    }
}
