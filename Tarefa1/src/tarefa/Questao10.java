package tarefa;

import java.util.Scanner;

public class Questao10 {
	
	public static void main(String[] args) {
//		LER AS NOTAS DA 1A. E 2A. AVALIAÇÕES DE UM ALUNO. 
//		CALCULAR A MÉDIA ARITMÉTICA SIMPLES E ESCREVER UMA 
//		MENSAGEM QUE DIGA SE O ALUNO FOI OU NÃO APROVADO 
//		(CONSIDERAR QUE NOTA IGUAL OU MAIOR QUE 6 O ALUNO É APROVADO). 
//		ESCREVER TAMBÉM A MÉDIA CALCULADA. 
		Scanner entrada = new Scanner(System.in);
		System.out.println("Insira a sua primeira nota: ");
		double nota1 = entrada.nextDouble();
		entrada.nextLine();
		
		System.out.println("Insira a sua segunda nota: ");
		double nota2 = entrada.nextDouble();
		entrada.nextLine();
		String mensagem;
		double media = (nota1 + nota2)/2;
		if(media >= 6){
			System.out.println("-----------------------");
			mensagem = "O aluno foi Aprovado!";
			System.out.printf("Sua média é: %.1f %n", media );
			System.out.println(mensagem);
		}else {
			System.out.println("-----------------------");
			mensagem = "O aluno não foi Aprovado!";
			System.out.printf("Sua média é: %.1f %n", media );
			System.out.println(mensagem);
		}
		entrada.close();
	
	} 
}

