package tarefa;

import java.util.Scanner;

public class Questao3 {
	
		public static void main(String[] args) {
//		Escreva um algoritmo para ler o salário mensal atual de um funcionário e o percentual de reajuste. Calcular e escrever o valor do novo salário. 
				Scanner entrada = new Scanner(System.in);
				System.out.println("Informe o nome do funcionário: ");
				String nome = entrada.nextLine();
				
				System.out.println("Informe o salário do funcionário: ");
				double salarioAtual = entrada.nextDouble();
				entrada.nextLine();
				
				System.out.println("Informe o reajuste salarial(%): ");
				int reajuste = entrada.nextInt();
				entrada.nextLine();
				
				double salarioReajustado = salarioAtual+ ((salarioAtual * reajuste) / 100) ;
				System.out.printf("%n O funcionário %s com o salário atual de R$ %.2f %n teve um reajuste de %d porcento e seu salário reajustado é R$ %.2f", nome, salarioAtual,reajuste, salarioReajustado);
				entrada.close();
		
	}
}
