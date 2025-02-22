package tarefa;

import java.util.Scanner;

public class Questao16 {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		int jan,fev,mar;
		jan = 15000;
		fev = 23000;
		mar = 17000;
		
		int despesaTotal = jan + fev + mar;
		double mediaMensal = despesaTotal/3;
		
		System.out.printf("Despesa total:R$ %d %nMédia Mensal: R$ %.2f", despesaTotal, mediaMensal);
		
		 sc.close();
		}
		
}

