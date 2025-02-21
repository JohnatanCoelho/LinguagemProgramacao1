package tarefa;

import java.util.Scanner;

public class Questao1{

		public static void main(String[] args) {
			//Faça um algoritmo que leia a idade de uma pessoa expressa em anos, meses e dias e
			//escreva a idade dessa pessoa expressa apenas em dias. Considerar ano com 365 dias e mês com 30 dias. 
			Scanner entrada = new Scanner(System.in);
			System.out.println("Informe a sua idade: ");
			int idade = entrada.nextInt();
			entrada.nextLine();
			System.out.println("Quantos meses você vive sua idade? ");
			int meses = entrada.nextInt();
			entrada.nextLine();
			System.out.println("Quantos dias você vive sua idade? ");
			int dia = entrada.nextInt();			
			int totalDias = (idade*365)+(meses*30) + dia ;
			
			System.out.println("Dias totais: " + totalDias);
			
			entrada.close();
			
		}
}
