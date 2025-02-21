package tarefa;

import java.util.Scanner;

public class Questao12 {
	public static void main(String[] args) {
//		Ler dois valores (considere que não serão lidos valores iguais) e escrever o maior deles. 
		Scanner entrada = new Scanner(System.in);
		System.out.println("Insira o primeiro número: ");
		int num1 = entrada.nextInt();
		entrada.nextLine();
		System.out.println("Insira o segundo número: ");
		int num2 = entrada.nextInt();
		entrada.nextLine();
		if(num1 == num2) {
			System.out.println("Os numeros não podem ser iguais");
		}	else {
			if(num1 > num2) {
				System.out.println("O número " + num1 + " é maior que " + num2);
			} else {
				System.out.println("O número " + num2 + " é maior que " + num1);
			}
		}
		entrada.close();
	}
}
