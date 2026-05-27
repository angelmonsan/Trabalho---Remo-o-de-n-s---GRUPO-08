package Trabalho_Remocao_De_Nos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Scanner para entrada de dados
        Scanner scanner = new Scanner(System.in);

        // Criação da árvore binária
        ArvoreBinaria arvore = new ArvoreBinaria();

        // Variável do menu
        int opcao;

        // MENU PRINCIPAL
        do {

            System.out.println("SISTEMA ÁRVORE BINÁRIA:");
            System.out.println("1 - Inserir número");
            System.out.println("2 - Remover número");
            System.out.println("3 - Mostrar árvore");
            System.out.println("4 - Limpar árvore");
            System.out.println("5 - Mostrar números para teste");
            System.out.println("6 - Encerrar sistema");

            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                // INSERÇÃO DE NÚMEROS
                case 1:

                    // Variável para continuar inserindo
                    String continuarInserindo;

                    do {

                        System.out.print("\nDigite um número: ");

                        int numero = scanner.nextInt();

                        // Chama metodo inserir
                        arvore.inserir(numero);

                        // Pergunta se deseja continuar
                        System.out.print("\nDeseja inserir outro número? (s/n): ");

                        continuarInserindo = scanner.next();

                    } while (continuarInserindo.equalsIgnoreCase("s"));

                    break;

                // REMOVER NÚMERO
                case 2:

                    System.out.print("\nDigite o número para remover: ");

                    int remover = scanner.nextInt();

                    // Chama metodo remover
                    arvore.remover(remover);

                    break;

                // MOSTRAR ÁRVORE
                case 3:

                    // Mostra a árvore simplificada
                    arvore.mostrar();

                    break;

                // LIMPAR ÁRVORE
                case 4:

                    // Remove todos os nós
                    arvore.limpar();

                    break;

                // MOSTRAR NÚMEROS PARA TESTE
                case 5:

                    System.out.println("NÚMEROS PARA TESTE:");

                    System.out.println("Digite nesta ordem:");
                    System.out.println("50");
                    System.out.println("30");
                    System.out.println("70");
                    System.out.println("20");
                    System.out.println("40");
                    System.out.println("60");
                    System.out.println("80");
                    System.out.println("65");

                    System.out.println("TESTES DE REMOÇÃO");

                    System.out.println("20 - Nó folha(Não possui Filhos).");
                    System.out.println("60 - Nó com um filho(No caso o 65).");
                    System.out.println("30 - Nó com dois filhos(Mas deve ter o 20 e 40).");
                    System.out.println("50 - Remoção da raiz(Raiz Principal da árvore).");

                    break;

                // ENCERRAR SISTEMA
                case 6:

                    System.out.println("\nEncerrando sistema.");
                    System.out.println("Programa finalizado com sucesso.");

                    break;

                // OPCAO INVÁLIDA
                default:

                    System.out.println("\nOpção inválida.");
                    System.out.println("Tente novamente.");
            }

        } while (opcao != 6);

        // Fecha scanner
        scanner.close();
    }
}