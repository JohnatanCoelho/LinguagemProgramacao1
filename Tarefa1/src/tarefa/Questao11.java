package tarefa;

import java.util.Scanner;

public class Questao11 {
	public static void main(String[] args) {
//		Ler o ano atual e o ano de nascimento de uma pessoa.
//		Escrever uma mensagem que diga se ela poderá ou não 
//		votar este ano (não é necessário considerar o mês em que a pessoa nasceu).
		Scanner entrada = new Scanner(System.in);
		System.out.println("Informe o ano atual: ");
		int anoAtual = entrada.nextInt();
		entrada.nextLine();
		System.out.println("Informe o seu ano de nascimento ");
		int anoNascimento = entrada.nextInt();
		entrada.nextLine();

		int votar = anoAtual - anoNascimento;
		String mensagem;
		if (votar >= 18) {
			mensagem ="Pode votar este ano!" ;
			System.out.println(mensagem);
		} else {
			mensagem ="Não pode votar este ano!";
			System.out.println(mensagem);
		}
		entrada.close();
	}
}
