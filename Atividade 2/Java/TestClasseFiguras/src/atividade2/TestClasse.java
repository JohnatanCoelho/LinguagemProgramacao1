package atividade2;

import java.util.Scanner;

public class TestClasse{

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcao = 1;
        while(opcao  > 0){
            System.out.println("Classes:   ");
            System.out.println("1 - Pessoas ");
            System.out.println("2 - Carros");
            System.out.println("3 - Animais");
            System.out.println("4 - Instrumentos");
            System.out.println("0 - Sair");
            opcao = entrada.nextInt();
            entrada.nextLine();
        switch (opcao){
            case 1:
                Pessoa John = new Pessoa("John", 'M', 19);
                John.andar();
                John.sentar();
                John.comer();
                System.out.println("");
                break;
                
            case 2:
                //Carros
                Carro FordKa =  new Carro("Fordka","Ford", 0, false);
                FordKa.ligarCarro();

                //MÉTODO PARA ACELERAR O CARRO
                System.out.println("Acelerar? [S/N]");
                String acelerarCarro = entrada.nextLine().toUpperCase();
                if(acelerarCarro.equals("S")) {
                FordKa.acelerar(10, 100);
                }

                //MÉTODO PARA FREIAR O CARRO
                 System.out.println("Deseja freiar? [S/N]");
                 String resp = entrada.nextLine().toUpperCase();
                 if(resp.equals("S")){
                 FordKa.freiar(5);
                 }
                System.out.println("");
                break;

            case 3:
                //Animais
                Animal gato = new Animal("Gato","Frajola","Mamífero", 2,"arranhar", "correndo");
                gato.mostrarInformacaoAnimal();
                gato.Comer();
                gato.movimentar();
                System.out.println("");
                break;

            case 4:
                //Instrumentos musicais
                Instrumento guitarra = new Instrumento("guitarra", false, 0, "src\\instrumentoSom\\guitarra.wav");
                guitarra.ligarInstrumento();
                System.out.println("O valor do volume: ");
                int limiteVolume = entrada.nextInt();
                guitarra.aumentarVolume(limiteVolume);

                System.out.println("Abaixar o volume para: ");
                int volumeAbaixado = entrada.nextInt();

                guitarra.abaixarVolume(volumeAbaixado, limiteVolume);

                guitarra.perguntarParaTocar(entrada);
                if(entrada.nextLine().toUpperCase().equals("S")){
                    guitarra.tocarSom();
                }
                System.out.println("");
                break;

            case 5:
                // Bolo
                Bolo b1 = new Bolo();
                System.out.println("Nome do bolo: ");
                String nomeBolo = entrada.nextLine();
                b1.setNomeBolo(nomeBolo);
                b1.adicionarIngredientes(entrada);
                System.out.println("-----------");
                System.out.println("Lista de Ingredientes: ");
                System.out.println(b1.getNomeBolo());
                b1.exibirIngredientes();
                System.out.println("-----------");
                b1.finalizarBolo("Chocolate");

                break;

            case 0:
                System.out.println("Saindo....");
                break;

            default:
                System.out.println("Opção inválida!");
                break;
    }

    }
        entrada.close();
}
}
