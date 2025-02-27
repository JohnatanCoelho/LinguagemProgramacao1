package tarefa;

import java.util.Scanner;

public class Questao17 {
	public static void main(String[] args) {
		
		// Programa que leia as notas e calcule a média de LP1 deste semestre, referente a um determinado aluno.
		Scanner entrada = new Scanner(System.in);
		//(P1*0.6+((E1+E2)/2)*0.4)*0.5+(max(((P1*0.6+((E1+E2)/2)*0.4)-5.9),0)/((P1*0.6+((E1+E2)/2)*0.4)-5.9))*(API*0.5)+X+(SUB*0.3)
			System.out.println("Insira a sua nota da primeira prova: ");
			double p1 = entrada.nextDouble();
			entrada.nextLine();
			System.out.println("Insira a sua nota no exercício 1: ");
			double e1 = entrada.nextDouble();
			entrada.nextLine();
			System.out.println("Insira a sua nota no exercício 2: ");
			double e2 = entrada.nextDouble();
			entrada.nextLine();
			System.out.println("Insira o valor dos pontos extras: ");
			double x = entrada.nextDouble();
			
			double media = (((p1*0.6)+((e1+e2)/2)*0.4))*0.5;
			double max = Math.max(((p1*0.6)+(((e1+e2)/2)*0.4))-5.9, 0);
			double fator = max / (((p1*0.6)+((e1+e2)/2)*0.4)-5.9); 
			double notaTotal;
			
			if(fator == 1) {
				System.out.println("Insira a nota da API: ");
				double api = entrada.nextDouble();
				notaTotal =  media + (fator* (api*0.5))+ x;
				System.out.printf("Sua nota final: %.2f", notaTotal);
				
			}	else{
				System.out.println("Insira a nota do exame: ");
				double sub = entrada.nextDouble() ;
				double notaSubTotal = fator + (sub*0.3) + media + x ;
				System.out.printf("%nSua nota final: %.2f ", notaSubTotal);
			}
			
		entrada.close();
	}
}
