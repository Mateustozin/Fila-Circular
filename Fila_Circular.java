public class FilaCircular<T> {
    private T[] fila;
    private int tamanho;
    private int inicio;
    private int fim;
    private int capacidade;

 
    @SuppressWarnings("unchecked")
    public FilaCircular(int capacidade) {
        this.capacidade = capacidade;
        this.fila = (T[]) new Object[capacidade];
        this.inicio = 0;
        this.fim = 0;
        this.tamanho = 0;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public boolean estaCheia() {
        return tamanho == capacidade;
    }

    
    public void enfileirar(T elemento) {
        if (estaCheia()) {
            throw new RuntimeException("Fila cheia");
        }
        fila[fim] = elemento;
        fim = (fim + 1) % capacidade;
        tamanho++;
    }

    
    public T desenfileirar() {
        if (estaVazia()) {
            throw new RuntimeException("Fila vazia");
        }
        T elemento = fila[inicio];
        fila[inicio] = null; 
        inicio = (inicio + 1) % capacidade;
        tamanho--;
        return elemento;
    }

    
    public T espiar() {
        if (estaVazia()) {
            throw new RuntimeException("Fila vazia");
        }
        return fila[inicio];
    }

    
    public int getTamanho() {
        return tamanho;
    }

    
    public void imprimirFila() {
        System.out.print("Fila: ");
        for (int i = 0; i < capacidade; i++) {
            System.out.print(fila[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FilaCircular<Integer> fila = new FilaCircular<>(5);

        fila.enfileirar(1);
        fila.enfileirar(2);
        fila.enfileirar(3);
        fila.imprimirFila();

        System.out.println("Desenfileirado: " + fila.desenfileirar());
        fila.imprimirFila();

        fila.enfileirar(4);
        fila.enfileirar(5);
        fila.enfileirar(6);
        fila.imprimirFila();

        System.out.println("Desenfileirado: " + fila.desenfileirar());
        fila.imprimirFila();
    }
}