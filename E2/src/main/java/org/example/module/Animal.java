package org.example.module;

public class Animal {
    private String animal;
    private String nome;
    private String tipo;
    private int idade;
    private String costumeAnimal;
    private String movimento;

    public Animal(String animal, String nome, String tipo, int idade, String costume, String movimento){
        this.animal = animal;
        this.nome = nome;
        this. tipo = tipo;
        this.idade = idade;
        this.costumeAnimal = costume;
        this.movimento = movimento;
    }

    public String getAnimal() {
        return animal;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCostumeAnimal() {
        return costumeAnimal;
    }

    public String getMovimento() {
        return movimento;
    }

    public String mostrarInformacaoAnimal(){
        String infAnimal = "-------------" +
                            "\n Informações: "   +
                            "\nAnimal: " + getAnimal() +
                            "\nNome: " + getNome() +
                            "\nIdade: " + getIdade() +
                            "\nTipo: " + getTipo() +
                            "\nCostume: " + getCostumeAnimal() +
                            "\n-------------" +
                            "\n\n" + comer() +
                            "\n" + movimentar();
        return infAnimal;
    }

    public String comer(){
        String come = getNome() + " está comendo!";
        return come;
    }


    public String movimentar(){
        String movimento = getNome() + " está " + getMovimento() + "!";
        return movimento;
    }

}
