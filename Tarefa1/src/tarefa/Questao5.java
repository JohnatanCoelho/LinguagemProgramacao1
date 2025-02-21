package tarefa;

import java.util.Scanner;

public class Questao5 {

	public static void main(String[] args) {
//		Uma revendedora de carros usados paga a seus funcionários vendedores um salário fixo por mês,
//		mais uma comissão também fixa para cada carro vendido e mais 5% do valor das vendas por ele efetuadas.
//		Escrever um algoritmo que leia o número de carros por ele vendidos, o valor total de suas vendas, 
//		o salário fixo e o valor que ele recebe por carro vendido. Calcule e escreva o salário final do vendedor.
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Qual o salário fixo?");
		double salFixo = entrada.nextDouble();
		entrada.nextLine();
		
		System.out.println("Quantos carros você vendeu?");
		int quantCarro = entrada.nextInt();
		entrada.nextLine();
		
		System.out.println("Qual o valor total das suas vendas?");
		double valorVendas = entrada.nextDouble();
		entrada.nextLine();
		
		System.out.println("Qual o valor que recebe por cada carro vendido?");
		double comissao = entrada.nextDouble();
		entrada.nextLine();
		
		double total = salFixo + (quantCarro*comissao) + (valorVendas * (5.0/100)) ;
		
		System.out.printf("%n Salário final do vendedor: R$ %.2f", total);
		
		entrada.close();
	}
}
