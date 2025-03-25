package Fracao;

import java.awt.*;
import java.util.Scanner;

public class TestClasse {

    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int opcao = 1;
        while(opcao > 0){
        System.out.println("---------------------------");
        System.out.println("Escolha a operação: ");
        System.out.println("1 - Fração Soma ");
        System.out.println("2 - Fração Subtração ");
        System.out.println("3 - Fração Multiplicação ");
        System.out.println("4 - Fração Divisão ");
        System.out.println("0 - Sair");
        System.out.println("---------------------------");
        opcao = entrada.nextInt();
        switch(opcao){
            case 1:
                System.out.println("Informe primeiro o numerador e depois o denominador");
                System.out.println("Fração 1:");
                Fracao fracao1 = new Fracao(entrada.nextInt(), entrada.nextInt());
                System.out.println("Fração 2:");
                Fracao fracao2 = new Fracao(entrada.nextInt(), entrada.nextInt());
                Fracao soma = fracao1.somar(fracao2);
                System.out.println("Resultado: " + soma);
                break;

            case 2:
                System.out.println("Informe primeiro o numerador e depois o denominador");
                System.out.println("Fração 1:");
                Fracao fracaoSub1 = new Fracao(entrada.nextInt(), entrada.nextInt());
                System.out.println("Fração 2:");
                Fracao fracaoSub2 = new Fracao(entrada.nextInt(), entrada.nextInt());
                Fracao subtracao = fracaoSub1.subtrair(fracaoSub2);
                System.out.println("Resultado: " + subtracao);
                break;

            case 3:
                System.out.println("Informe primeiro o numerador e depois o denominador");
                System.out.println("Fração 1:");
                Fracao fracaoMul1 = new Fracao(entrada.nextInt(), entrada.nextInt());
                System.out.println("Fração 2:");
                Fracao fracaoMul2 = new Fracao(entrada.nextInt(), entrada.nextInt());
                Fracao multiplicacao = fracaoMul1.multiplicar(fracaoMul2);
                System.out.println("Resultado: " + multiplicacao);
                break;

            case 4:
                System.out.println("Informe primeiro o numerador e depois o denominador");
                System.out.println("Fração 1:");
                Fracao fracaoDiv1= new Fracao(entrada.nextInt(), entrada.nextInt());
                System.out.println("Fração 2:");
                Fracao fracaoDiv2 = new Fracao(entrada.nextInt(), entrada.nextInt());
                Fracao divisao = fracaoDiv1.dividir(fracaoDiv2);
                System.out.println("Resultado: " + divisao);
                break;

            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

        }
        entrada.close();
    }
}
