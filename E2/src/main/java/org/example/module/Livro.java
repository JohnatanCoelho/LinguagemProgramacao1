package org.example.module;

public class Livro {
    private String nomeLivro;
    private String autor;
    private Integer anoLancamento;
    private String citacao1;
    private String citacao2;
    private String citacao3;

    public Livro(String nomeLivro, String autor, Integer anoLancamento) {
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


    public String exibirLivro(){
        String livro = "------------------------\n"
                        + "Informações do livro: \n"
                        + "Nome do livro: " + getNomeLivro() + "\n"
                        + "Autor: " + getAutor() + "\n"
                        +"Ano de lançamento: " + getAnoLancamento() + "\n"
                        + "------------------------";
        return livro;
    }

    public void adicionarCitacao(String citacao1, String citacao2, String citacao3){
        //A suprema arte da guerra é derrotar o inimigo sem lutar.
        this.citacao1 = citacao1;

        //As oportunidades multiplicam-se à medida que são agarradas.
        this.citacao2 = citacao2;

        //Diante de uma larga frente de batalha, procure o ponto mais fraco e, ali, ataque com a sua maior força.
        this.citacao3 = citacao3;
    }


    public String exibirCitacao(){
        String exibicao = "1 - " + citacao1
                          + "\n2 - " + citacao2
                          + "\n3 - " + citacao3 ;
       return exibicao;
    }

}

