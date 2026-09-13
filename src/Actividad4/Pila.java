package Actividad4;

/**
 * Pila genérica basada en una lista ligada.
 * Sigue el principio LIFO: el último elemento agregado es el primero en salir.
 *
 * @param <T> tipo de dato almacenado
 */
public class Pila<T> {
    private final LinkedList<T> elements = new LinkedList<>();

    /** Inserta un elemento en el tope de la pila. */
    public void push(T data) {
        elements.addFirst(data);
    }

    /** Retira y devuelve el elemento del tope. */
    public T pop() {
        return elements.removeFirst();
    }

    /** Consulta el elemento del tope sin retirarlo. */
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
