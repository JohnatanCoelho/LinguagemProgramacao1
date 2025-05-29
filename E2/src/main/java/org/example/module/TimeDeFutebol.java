package org.example.module;

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

    public void perguntarOPlacar(Integer golsCasa, Integer golsVisitante){
        this.golsCasa = golsCasa;
        this.golsVisitante = golsVisitante;

    }

    public String verificacaoResultados(){
        String resultado;
        if (getGolsCasa() > getGolsVisitante()){
            resultado = ("O "+ getTimeCasa() + " ganhou a partida!").toUpperCase();
        } else if (getGolsCasa() < getGolsVisitante()){
           resultado = ("O "+ getTimeVisitante() + " ganhou a partida!").toUpperCase();
        } else {
            resultado = "Empate!".toUpperCase();
        }
        return resultado;
    }

    public String mostrarPlacar(){
        String resultado = verificacaoResultados();
        String placar = "------------------"
                        + "\n PLACAR:\n"
                        + getTimeCasa() + " X " + getTimeVisitante() + "\n"
                        + getGolsCasa()+ " X " + getGolsVisitante() + "\n"
                        + "------------------\n"
                        + resultado;

        return placar;
    }

}
