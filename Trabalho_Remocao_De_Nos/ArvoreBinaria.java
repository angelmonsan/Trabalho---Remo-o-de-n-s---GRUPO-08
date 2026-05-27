package Trabalho_Remocao_De_Nos;

public class ArvoreBinaria {

    // RAIZ DA ÁRVORE
    No raiz;

    // INSERÇÃO

    public void inserir(int valor) {

        System.out.println("Inserindo valor: " + valor);

        // Criação do novo nó
        No novo = new No(valor);

        // Caso a árvore esteja vazia
        if (raiz == null) {

            raiz = novo;

            System.out.println("A árvore estava vazia.");
            System.out.println("O número " + valor + " virou a raiz.");

            return;
        }

        // Variáveis auxiliares
        No atual = raiz;
        No anterior = null;

        // Procura posição correta
        while (atual != null) {

            anterior = atual;

            // Vai para esquerda
            if (valor < atual.valor) {

                System.out.println(valor + " é menor que " + atual.valor);
                System.out.println("Indo para esquerda.");

                atual = atual.esquerda;
            }

            // Vai para direita
            else if (valor > atual.valor) {

                System.out.println(valor + " é maior que " + atual.valor);
                System.out.println("Indo para direita.");

                atual = atual.direita;
            }

            // Valor repetido
            else {

                System.out.println("Valor já existe.");
                return;
            }
        }

        // Inserção final
        if (valor < anterior.valor) {

            anterior.esquerda = novo;

            System.out.println("Inserido na esquerda de "
                    + anterior.valor);
        }

        else {

            anterior.direita = novo;

            System.out.println("Inserido na direita de "
                    + anterior.valor);
        }
    }

    // REMOÇÃO

    public void remover(int valor) {

        System.out.println("Removendo valor: " + valor);

        No atual = raiz;
        No pai = null;

        // Procura o nó
        while (atual != null && atual.valor != valor) {

            pai = atual;

            // Procura esquerda
            if (valor < atual.valor) {

                System.out.println(valor + " é menor que "
                        + atual.valor);

                System.out.println("Indo para esquerda.");

                atual = atual.esquerda;
            }

            // Procura direita
            else {

                System.out.println(valor + " é maior que "
                        + atual.valor);

                System.out.println("Indo para direita.");

                atual = atual.direita;
            }
        }

        // Valor não encontrado
        if (atual == null) {

            System.out.println("Valor não encontrado.");
            return;
        }

        System.out.println("Nó encontrado: " + atual.valor);

        // CASO 1 - NÓ FOLHA
        if (atual.esquerda == null && atual.direita == null) {

            System.out.println("Nó folha.");

            // Caso seja a raiz
            if (atual == raiz) {

                raiz = null;
            }

            // Remove da esquerda
            else if (pai.esquerda == atual) {

                pai.esquerda = null;
            }

            // Remove da direita
            else {

                pai.direita = null;
            }
        }

        // CASO 2 - FILHO ESQUERDO
        else if (atual.direita == null) {

            System.out.println("Possui apenas filho esquerdo.");

            if (atual == raiz) {

                raiz = atual.esquerda;
            }

            else if (pai.esquerda == atual) {

                pai.esquerda = atual.esquerda;
            }

            else {

                pai.direita = atual.esquerda;
            }
        }

        // CASO 3 - FILHO DIREITO
        else if (atual.esquerda == null) {

            System.out.println("Possui apenas filho direito.");

            if (atual == raiz) {

                raiz = atual.direita;
            }

            else if (pai.esquerda == atual) {

                pai.esquerda = atual.direita;
            }

            else {

                pai.direita = atual.direita;
            }
        }

        // CASO 4 - DOIS FILHOS
        else {

            System.out.println("Possui dois filhos.");

            No menorPai = atual;
            No menor = atual.direita;

            // Procura menor valor da direita
            while (menor.esquerda != null) {

                menorPai = menor;
                menor = menor.esquerda;
            }

            System.out.println("Menor valor encontrado: "
                    + menor.valor);

            // Substitui valor
            atual.valor = menor.valor;

            // Remove menor nó
            if (menorPai.esquerda == menor) {

                menorPai.esquerda = menor.direita;
            }

            else {

                menorPai.direita = menor.direita;
            }
        }

        System.out.println("Remoção concluída.");
    }

    // MOSTRAR ÁRVORE SIMPLIFICADA

    public void mostrar() {

        System.out.println("MOSTRANDO ÁRVORE:");

        // Verifica se a árvore está vazia
        if (raiz == null) {

            System.out.println("Árvore vazia.");
            return;
        }

        // FILA PARA PERCORRER A ARVORE
        No[] fila = new No[100];

        int inicio = 0;
        int fim = 0;

        // Coloca a raiz na fila
        fila[fim] = raiz;
        fim++;

        // PERCORRE TODOS OS NÓS
        while (inicio < fim) {

            No atual = fila[inicio];
            inicio++;

            System.out.println("Nó: " + atual.valor);

            // VERIFICA SE É A RAIZ
            if (atual == raiz) {

                System.out.println("Tipo: Raiz");
            }

            // VERIFICA SE É FOLHA
            else if (atual.esquerda == null
                    && atual.direita == null) {

                System.out.println("Tipo: Nó folha");
            }

            // NÓ COM FILHOS
            else {

                System.out.println("Tipo: Nó com filho");
            }

            // FILHO ESQUERDO
            if (atual.esquerda != null) {

                System.out.println("Filho esquerdo: "
                        + atual.esquerda.valor);

                fila[fim] = atual.esquerda;
                fim++;
            }

            else {

                System.out.println("Filho esquerdo: null");
            }

            // FILHO DIREITO
            if (atual.direita != null) {

                System.out.println("Filho direito: "
                        + atual.direita.valor);

                fila[fim] = atual.direita;
                fim++;
            }

            else {

                System.out.println("Filho direito: null");
            }

            // STATUS DOS FILHOS
            if (atual.esquerda == null
                    && atual.direita == null) {

                System.out.println("Status: Sem filhos");
            }

            else {

                System.out.println("Status: Possui filho(s)");
            }
        }
    }

    // LIMPAR ÁRVORE

    public void limpar() {

        raiz = null;

        System.out.println("\nToda árvore foi apagada.");
    }
}