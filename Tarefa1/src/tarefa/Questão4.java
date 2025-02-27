package tarefa;

import java.util.Scanner;

public class Questão4 {

		public static void main(String[] args) {	
//			O custo de um carro novo ao consumidor é a soma do custo de fábrica com a porcentagem
//			do distribuidor e dos impostos (aplicados ao custo de fábrica). Supondo que o percentual 
//			do distribuidor seja de 28% e os impostos de 45%, escrever um algoritmo para ler o custo 
//			de fábrica de um carro, calcular e escrever o custo final ao consumidor
			
			Scanner entrada = new Scanner(System.in);
			
			int distribuidor, imposto;
			distribuidor = 28; 
			imposto = 45;
			System.out.println("Informe o custo da fábrica: ");
			double custoFabrica = entrada.nextDouble();
			
			double custoFinal = ((((custoFabrica*distribuidor)/100)+((custoFabrica*imposto)/100))+custoFabrica);
			
			System.out.printf("O custo final do consumidor é: R$ %.2f", custoFinal);
			entrada.close();
			
			
		}
}
