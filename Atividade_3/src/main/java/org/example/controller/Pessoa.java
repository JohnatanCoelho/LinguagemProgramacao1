package org.example.controller;

public class Pessoa {
    private String nome;
    private String sexo;
    private Integer idade;


    public Pessoa(String nome, String sexo, Integer idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public int getIdade() {
        return idade;
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


