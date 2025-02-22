package tarefa;

import java.util.Scanner;

public class Questao15 {
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	 System.out.println("Insira horas no mês trabalhada: ");
	 int horas = sc.nextInt();
	 sc.nextLine();
	 System.out.println("Insira salário por hora: ");
	 double salHora = sc.nextDouble();
	 sc.nextLine();
	
	 double salTotal = horas*salHora;
	 if(horas > 160) {
		 double acresimo = (salTotal*0.5) + salTotal;
		 System.out.println("Total de horas: " + horas);
		 System.out.println("O salário do funcionário com acrésimo é: R$ " + acresimo);
		 }	else {
			 System.out.println("Total de horas: " + horas);
			 System.out.println("O salário do funcionário sem acrésimo é : R$ " + salTotal);
		 }
	
	 sc.close();
	}
}
