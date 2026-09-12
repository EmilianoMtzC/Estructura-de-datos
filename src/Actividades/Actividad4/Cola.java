package Actividades.Actividad4;

/**
 * Cola genérica basada en una lista ligada.
 * Sigue el principio FIFO: el primer elemento agregado es el primero en salir.
 *
 * @param <T> tipo de dato almacenado
 */
public class Cola<T> {
    private final LinkedList<T> elements = new LinkedList<>();

    /** Inserta un elemento al final de la cola. */
    public void enqueue(T data) {
        elements.addLast(data);
    }

    /** Retira y devuelve el elemento que se encuentra al frente. */
    public T dequeue() {
        return elements.removeFirst();
    }

    /** Consulta el elemento que se encuentra al frente sin retirarlo. */
    public T peek() {
        return elements.getFirst();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int getSize() {
        return elements.getSize();
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
