package tarefa;

import java.util.Scanner;

public class Questao8 {

	public static void main(String[] args) {
//		Ler um valor e escrever é positivo ou negativo (considere o valor zero como positivo)
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Insira um valor: ");
		int num = entrada.nextInt();	
		if(num>=0){
			System.out.println("Número positivo!");		
		}else {
			System.out.println("Número negativo");
		}
		entrada.close();
	}
}
