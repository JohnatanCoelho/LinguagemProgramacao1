package org.example.module;

public class Animal {
    private Integer id;
    private String animal;
    private String nome;
    private String tipo;
    private Integer idade;
    private String costumeAnimal;
    private String movimento;

    public Animal(Integer id, String animal, String nome, String tipo, Integer idade, String costume, String movimento){
        this.id = id;
        this.animal = animal;
        this.nome = nome;
        this. tipo = tipo;
        this.idade = idade;
        this.costumeAnimal = costume;
        this.movimento = movimento;
    }

    public Integer getId() {
        return id;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCostumeAnimal(String costumeAnimal) {
        this.costumeAnimal = costumeAnimal;
    }

    public void setMovimento(String movimento) {
        this.movimento = movimento;
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
