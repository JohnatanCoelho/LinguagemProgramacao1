package tarefa;

import java.util.Scanner;

public class Questao6 {

		public static void main(String[] args) {
//			Escreva um algoritmo para ler uma temperatura em graus Fahrenheit, calcular e escrever o valor correspondente em graus Celsius.
//			Observação: Para testar se a sua resposta está correta saiba que 100°C = 212°F
			
			Scanner entrada = new Scanner(System.in);
			
			System.out.println("Informe o valor em grau Fahrenheit: ");
			int fahrenheit = entrada.nextInt();
			double celsius = (fahrenheit - 32)*(5.0/9.0);
			System.out.printf("Fahrenheit: %d %nCelsius: %.2f ", fahrenheit, celsius);
			entrada.close();
		}
}
