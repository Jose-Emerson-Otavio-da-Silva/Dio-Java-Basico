package one.digitalinnovation;

public class Main {
    public static void main(String[] args) {
        Fila<String> minhFila = new Fila<>();

        minhFila.enqueue("primeiro");
        minhFila.enqueue("segundo");
        minhFila.enqueue("terceiro");
        minhFila.enqueue("quarto");

        System.out.println(minhFila);

        System.out.println(minhFila.dequeue());

        System.out.println(minhFila);

        minhFila.enqueue("ultimo");

        System.out.println(minhFila);

        System.out.println(minhFila.first());
    }
}