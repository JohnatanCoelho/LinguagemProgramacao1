package org.example.controller;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Instrumento {
    private String nomeInstrumento;
    private boolean ligado;
    private double volume;
    private String caminhoSom;
    Clip clip;


    public Instrumento(String nome, boolean ligado, double volume, String caminhoSom){
        this.nomeInstrumento = nome;
        this.ligado = ligado;
        this.volume = volume;
        this.caminhoSom = caminhoSom;
    }

    public String getCaminhoSom() {
        return caminhoSom;
    }

    public String getNomeInstrumento() {
        return nomeInstrumento;
    }

    public double getVolume() {
        return volume;
    }

    public void ligarInstrumento(){
        if(this.ligado != true){
            this.ligado = true;
            System.out.println("Ligando " + getNomeInstrumento());
        }
    }
    public void aumentarVolume(double limiteVolume){
        System.out.println("----------------");
        System.out.println("Aumentando volume");
        for(this.volume = 0 ; this.volume <= limiteVolume ; this.volume = this.volume + 1 ){
            System.out.println("Volume : " + getVolume());
        }
    }
    public void abaixarVolume(double abaixarVolume, double limiteVolume){
        System.out.println("----------------");
        System.out.println("Abaixando volume");
        for(this.volume = limiteVolume ; this.volume >= abaixarVolume ; this.volume = this.volume - 1 ){
            System.out.println("Volume : " + getVolume());
        }
    }

//    public String perguntarParaTocar(Scanner entrada){
//        System.out.println("----------------");
//        System.out.println("Deseja tocar o som? [S/N]");
//        String resp = entrada.nextLine().toUpperCase();
//        return resp;
//    }

    public void tocarSom(){
        try{
            // Método para carregar o arquivo do som
            File arquivo = new File(getCaminhoSom()); // Caminho associado aquele instrumento

            //Arquivo sendo convertido em um fluxo de aúdio para realimentar o clip
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(arquivo);

            //API Clip usada para tocar, pausar e parar sons
            //Criado um objeto clip que será usado para manipular o áudio
            clip = AudioSystem.getClip();

            // Abre o fluxo de aúdio e associa o fluxo de áudio ao Clip
            clip.open(audioStream);

            clip.start();
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }
    public void pararSom(){
        try {
            clip.stop();
            clip.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
