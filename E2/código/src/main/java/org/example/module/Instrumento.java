package org.example.module;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Instrumento {
    private Integer id;
    private String nomeInstrumento;
    private boolean ligado;
    private double volume;
    private String caminhoSom;
    Clip clip;


    public Instrumento(Integer id, String nome, String caminhoSom){
        this.id = id;
        this.nomeInstrumento = nome;
        this.caminhoSom = caminhoSom;
    }

    public Integer getId() {
        return id;
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


    public void tocarSom(String caminhoSom){
        try{
            // Método para carregar o arquivo do som
            File arquivo = new File(caminhoSom); // Caminho associado aquele instrumento

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
