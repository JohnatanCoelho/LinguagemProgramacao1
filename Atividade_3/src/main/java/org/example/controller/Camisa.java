package org.example.controller;

import java.util.Scanner;

public class Camisa {
    private String tamanho;
    private String cor;
    private String tipo;
    private boolean vestida;

    public Camisa(String tamanho, String cor, String tipo, boolean vestida) {

        this.tamanho = tamanho;
        this.cor = cor;
        this.tipo = tipo;
        this.vestida = vestida;

    }

    public void lavar() {
        if(vestida == false){
            System.out.println("");
            System.out.println("Lavando a camisa...");
        } else{
            System.out.println("Precisa tirar primeiro a camisa");
            tirarCamisa();
        }
    }

    public void vestir(Scanner entrada) {
        if (vestida == false) {
            System.out.println("Vestir a camisa? [S/N] ");
            String decisaoVestir = entrada.nextLine();
            if (decisaoVestir.equalsIgnoreCase("S")) {
                System.out.println("Vestindo a camisa...");
                this.vestida = true;
            } else {
                System.out.println("Não vestiu a camisa...");
                this.vestida = false;
            }
            System.out.println();
        }else{
            System.out.println("Você já está com uma camisa vestida");
        }
    }

    public void tirarCamisa(){
        if(this.vestida == true){
            System.out.println("Tirando a camisa...");
            this.vestida = false;
            lavar();
        }
    }

}
