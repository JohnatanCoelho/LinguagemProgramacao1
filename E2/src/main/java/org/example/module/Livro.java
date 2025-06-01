package org.example.module;

public class Livro {
    private Integer id;
    private String nomeLivro;
    private String autor;
    private Integer anoLancamento;
    private String citacao1;
    private String citacao2;
    private String citacao3;

    public Livro(Integer id, String nomeLivro, String autor, Integer anoLancamento, String citacao1, String citacao2, String citacao3) {
        this.id = id;
        this.nomeLivro = nomeLivro;
        this.autor = autor;
        this.anoLancamento = anoLancamento;

        //A suprema arte da guerra é derrotar o inimigo sem lutar.
        this.citacao1 = citacao1;

        //As oportunidades multiplicam-se à medida que são agarradas.
        this.citacao2 = citacao2;

        //Diante de uma larga frente de batalha, procure o ponto mais fraco e, ali, ataque com a sua maior força.
        this.citacao3 = citacao3;
    }

    public Integer getId() {
        return id;
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

    public String exibirCitacao(){
        String exibicao = "1 - " + citacao1
                          + "\n2 - " + citacao2
                          + "\n3 - " + citacao3 ;
       return exibicao;
    }

}

