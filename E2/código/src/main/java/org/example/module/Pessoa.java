package org.example.module;

public class Pessoa {
    private Integer id;
    private String nome;
    private String sexo;
    private Integer idade;

    public Pessoa(Integer id, String nome, String sexo, Integer idade){
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    }

    public Integer getId(){return id;}

    public void setId(Integer id){
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
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


