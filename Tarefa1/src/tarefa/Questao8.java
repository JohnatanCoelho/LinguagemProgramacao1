package tarefa;

import java.util.Scanner;

public class Questao8 {

	public static void main(String[] args) {
//		Ler um valor e escrever é positivo ou negativo (considere o valor zero como positivo)
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Insira um valor: ");
		int num = entrada.nextInt();	
		if(num>=0){
			String mensagem = "Número positivo!" ;
			System.out.println(mensagem);		
		}else {
			String mensagem = "Número negativo!";
			System.out.println(mensagem);
		}
		entrada.close();
	}
}
