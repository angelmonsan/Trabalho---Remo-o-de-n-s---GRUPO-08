package Trabalho_Remocao_De_Nos;

public class No {

    // Valor armazenado no nó
    int valor;

    // Referência para filho da esquerda
    No esquerda;

    // Referência para filho da direita
    No direita;

    // CONSTRUTOR
    // Sempre que um novo nó for criado, ele vai receber um valor.
    public No(int valor) {

        this.valor = valor;

        // Inicialmente os filhos começam vazios
        this.esquerda = null;
        this.direita = null;
    }
}