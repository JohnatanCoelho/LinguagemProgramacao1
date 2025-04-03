package atividade2;

public class Pessoa {
    private String nome;
    private char sexo;
    private int idade;


    public Pessoa(String nome, char sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    }

    public void andar() {
        System.out.println(this.nome + " está caminhando!");
    }

    public void sentar() {
        System.out.println(this.nome + " está sentado! ");
    }

    public void comer() {
        System.out.println(this.nome + " está comendo!");
    }

}


