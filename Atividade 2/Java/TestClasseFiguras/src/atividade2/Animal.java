package atividade2;

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

    public void mostrarInformacaoAnimal(){
        System.out.println("-------------");
        System.out.println("Animal: " + getAnimal());
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Tipo: " + getTipo());
        System.out.println("Costume: " + getCostumeAnimal());
        System.out.println("-------------");
    }

    public void Comer(){
        System.out.println(getNome() + " está comendo!");
    }


    public void movimentar(){
        System.out.println(getNome() + " está " + this.movimento + "!");
    }

}
