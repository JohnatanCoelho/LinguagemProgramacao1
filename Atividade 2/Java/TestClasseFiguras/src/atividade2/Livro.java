package atividade2;

import java.util.Scanner;

public class Livro {
    String nomeLivro;
    String autor;
    int anoLancamento;
    String citacao1;
    String citacao2;
    String citacao3;

    public Livro(String nomeLivro, String autor, int anoLancamento) {
        this.nomeLivro = nomeLivro;
        this.autor = autor;
        this.anoLancamento = anoLancamento;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }
    public String getAutor(){
       return autor;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public String getCitacao1() {
        return citacao1;
    }

    public String getCitacao2() {
        return citacao2;
    }

    public String getCitacao3() {
        return citacao3;
    }

    public void setCitacao1(String citacao1) {
        this.citacao1 = citacao1;
    }

    public void setCitacao2(String citacao2) {
        this.citacao2 = citacao2;
    }

    public void setCitacao3(String citacao3){
        this.citacao3 = citacao3;
    }

    public void exibirLivro(){
        System.out.println("------------------------");
        System.out.println("Informações do livro: ");
        System.out.println("Nome do livro: " + getNomeLivro());
        System.out.println("Autor: " + getAutor());
        System.out.println("Ano de lançamento: " + getAnoLancamento());
        System.out.println("------------------------");
    }

    public void inserirCitacao(Scanner entrada){
        //A suprema arte da guerra é derrotar o inimigo sem lutar.
        System.out.println("Insira primeira citação: ");
        setCitacao1(entrada.nextLine());

        //As oportunidades multiplicam-se à medida que são agarradas.
        System.out.println("Insira segunda citação: ");
        setCitacao2(entrada.nextLine());

        //Diante de uma larga frente de batalha, procure o ponto mais fraco e, ali, ataque com a sua maior força.
        System.out.println("Insira terceira citação: ");
        setCitacao3(entrada.nextLine());

        System.out.println("");
    }

    public void exibirCitacoes(Scanner entrada){
        System.out.println("Escolha um número para mostrar citações de 1 a 3: ");
        int op = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Citação escolhida foi : " + op);
        switch (op){
            case 1:
                System.out.println("'"+ getCitacao1() + "'");
                break;
            case 2:
                System.out.println("'" + getCitacao2()+ "'");
                break;
            case 3:
                System.out.println("'" + getCitacao3() + "'");
                break;
        }
        System.out.println("------------------------");
    }


}

