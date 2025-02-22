package tarefa;

import java.util.Scanner;

public class Questao14 {

	public static void main(String[] args) {
//		Ler a hora de início e a hora de fim de um jogo de Xadrez (considere apenas horas inteiras, sem os minutos)
//		e calcule a duração do jogo em horas, sabendo-se que o tempo máximo de duração do jogo é de 24 horas e que 
//		jogo pode iniciar em um dia e terminar no dia seguinte.

		Scanner entrada = new Scanner(System.in);
		System.out.println("Insira a hora de inicio: ");
		int horaInicio = entrada.nextInt();
		System.out.println("Insira a hora de fim: ");
		int horaFim = entrada.nextInt();
		int totalHoras;
		if (horaFim >= horaInicio) {
			totalHoras = horaFim - horaInicio ;
		}	else {
			totalHoras = (24 - horaInicio) + horaFim;
		}
		System.out.println("total de horas " + totalHoras);
		
		entrada.close();
		
	}
}
