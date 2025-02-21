package tarefa;

import java.util.Scanner;

public class Questao13 {

	public static void main(String[] args) {
//		 Ler dois valores (considere que não serão lidos valores iguais) e escrevê-los em ordem crescente. 
		Scanner entrada = new Scanner(System.in);
		int x = 1;
		System.out.println("Insira o primeiro valor: ");
		int num1 = entrada.nextInt();
		System.out.println("Insira o segundo valor: ");
		entrada.nextLine();
		int num2 = entrada.nextInt();
		entrada.nextLine();
		if(num1 == num2) {
			System.out.println("Não pode ser lido valores iguais");
		}	else {
			if(num1 > num2) {	
				System.out.println(num2 + ", " + num1);
			}	else {
				System.out.println(num1 + "," + num2);
			}
		}
		entrada.close();
	}
}
