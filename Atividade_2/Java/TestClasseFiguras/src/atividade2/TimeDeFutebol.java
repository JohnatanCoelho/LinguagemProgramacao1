package atividade2;

import java.util.Scanner;

public class TimeDeFutebol {
    private String timeCasa;
    private String arena;
    private String timeVisitante;
    private int golsCasa;
    private int golsVisitante;

    public TimeDeFutebol(String time, String arena, String rival){
        this.timeCasa = time;
        this.arena = arena;
        this.timeVisitante = rival;
    }

    public String getTimeCasa() {
        return timeCasa;
    }

    public String getArena() {
        return arena;
    }

    public String getTimeVisitante() {
        return timeVisitante;
    }

    public int getGolsCasa() {
        return golsCasa;
    }

    public int getGolsVisitante() {
        return golsVisitante;
    }

    public void perguntarOPlacar(Scanner entrada){

        System.out.println("Quantos gols o "+ getTimeCasa()+ " tiveram na partida? ");
        this.golsCasa = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Quantos gols o " + getTimeVisitante() + " tiveram na partida? " );
        this.golsVisitante = entrada.nextInt();
        verificacaoResultados();

    }

    private void verificacaoResultados(){
        if (getGolsCasa() > getGolsVisitante()){
            System.out.println("O "+ getTimeCasa() + " ganhou a partida!");
        } else if (getGolsCasa() < getGolsVisitante()){
            System.out.println("O "+ getTimeVisitante() + " ganhou a partida!");
        } else {
            System.out.println("Empate!");
        }
    }

    public void mostrarPlacar(){
        System.out.println("------------------");
        System.out.println("PLACAR: \n" + getTimeCasa() + " X " + getTimeVisitante());
        System.out.println(getGolsCasa()+ " X " + getGolsVisitante());
        System.out.println("------------------");
    }

}
