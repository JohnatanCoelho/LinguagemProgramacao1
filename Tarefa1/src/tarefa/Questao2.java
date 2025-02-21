package tarefa;

import java.util.Scanner;

public class Questao2 {

		public static void main(String[] args) {
//			 Escreva um algoritmo para ler o número total de eleitores de um município,
//			o número de votos brancos, nulos e válidos.
//			Calcular e escrever o percentual que cada um representa em relação ao total de eleitores. 
			
			Scanner entrada = new Scanner(System.in);
			System.out.println("Informe o número de eleitores: ");
			int eleitores = entrada.nextInt();
			entrada.nextLine();
			System.out.println("Informe o número de votos nulos: ");
			int votoNulo = entrada.nextInt();
			entrada.nextLine();			
			System.out.println("Informe o número de votos em branco: ");
			int votoBranco = entrada.nextInt();			
			entrada.nextLine();			
			System.out.println("Informe o número de votos válidos: ");
			int votoValido = entrada.nextInt();			
			entrada.nextLine();	
			
			int percentualVotoNulo = (100 *votoNulo) / eleitores ;
			int percentualVotoBranco = (100 *votoBranco) / eleitores ;
			int percentualVotoValido = (100 *votoValido) / eleitores ;
			
			System.out.println("Numero de eleitores: " + eleitores);
			System.out.println("Percentual do voto nulo : " + percentualVotoNulo + "%");
			System.out.println("Percentual do voto em branco: " + percentualVotoBranco + "%");
			System.out.println("Percentual do voto válido: " + percentualVotoValido + "%");
			
			entrada.close();
			
			}
}
