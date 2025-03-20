package atividade2;

import java.util.ArrayList;
import java.util.Scanner;

public class Bolo {
    String nomeBolo;
    ArrayList<String> Ingredientes = new ArrayList<>();

    public String getNomeBolo() {
        return nomeBolo;
    }

    public void setNomeBolo(String nomeBolo) {
        this.nomeBolo = nomeBolo;
    }

    public void adicionarIngredientes(Scanner entrada){
        String op = "S";
        while(op.equalsIgnoreCase("S")){
            System.out.println("Digite o nome do ingrediente: ");
            String nomeIngrediente = entrada.nextLine();

            // Adiciona o ingrediente na lista
            Ingredientes.add(nomeIngrediente);

            //Perguntando se deseja continuar
            System.out.println("Deseja adicionar outro ingrediente? [S/N]");
            op = entrada.nextLine().toUpperCase();
        }
    }

    public void exibirIngredientes(){
        for(String ingrediente : Ingredientes){
            System.out.println(ingrediente);
        }
    }
    public void finalizarBolo(String cobertura){
        System.out.println("Finalizando o bolo " + getNomeBolo() + " com cobertura de " + cobertura);
    }

}




