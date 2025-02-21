package tarefa;

import java.util.Scanner;

public class Questao9 {

	public static void main(String[] args) {
		
//		 As maçãs custam R$ 1,30 cada se forem compradas menos de uma dúzia, e R$ 1,00 se forem compradas pelo menos doze. Escreva um programa que leia o número de maçãs compradas, 
//		 calcule e escreva o custo total da compra. 
		
		Scanner entrada = new Scanner(System.in);
		double total;
		System.out.println("Qual a quantidade de maçãs?");
		int quantMaca = entrada.nextInt();
		
		if(quantMaca <= 6){
			total = quantMaca* 1.30;
		}else {
			total = quantMaca *1.0; 
		}
		System.out.println("O total a pagar é: R$ " + total);
		
		entrada.close();		
		
	}
}
