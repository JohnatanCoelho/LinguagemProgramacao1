package tarefa;

import java.util.Scanner;

public class Questao7 {
	public static void main(String[] args) {
		
		//Ler um valor e escrever a mensagem É MAIOR QUE 10! se o valor lido for maior que 10, 
//		caso contrário escrever NÃO É MAIOR QUE 10! 
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Insira um valor: ");
		int num = entrada.nextInt();
		if(num>10) {
			System.out.println("É MAIOR QUE 10!");
		}
		else {
			System.out.println("NÃO É MAIOR QUE 10");
		}
		entrada.close();
	}

}
