package atividade2;

import java.util.Scanner;

public class Caderno {
    private String tamanho;
    private String cor;
    private int numPaginas;
    private String tipo;

    public Caderno(String tamanho, String cor, int numPaginas, String tipo) {
        this.tamanho = tamanho;
        this.cor = cor;
        this.numPaginas = numPaginas;
        this.tipo = tipo;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public String getCor() {
        return cor;
    }

    public void escreverNoCaderno(Scanner entrada){
        System.out.println("Escrever: ");
        String texto = entrada.nextLine();
        System.out.println("Texto escrito no caderno: " + texto);
        System.out.println("");
    }

    public void arrancarPaginas(Scanner entrada){
        System.out.println("Quantas páginas quer arrancar?");
        int numPaginas = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Atual número de páginas no caderno: " + (getNumPaginas() - numPaginas));
        System.out.println("");
    }

    public void trocarCorCapa(Scanner entrada){
        System.out.println("Qual a nova cor do caderno? ");
        this.cor = entrada.nextLine();
        System.out.println("Nova cor do caderno: " + getCor());
        System.out.println("");

    }
}
