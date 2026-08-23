package Actividades.Actividad2;

/**
 * Representa un nodo generico.
 *
 * @param <T> tipo de dato almacenado en el nodo
 */
public class Node<T> {

    public T data;
    public Node<T> next;
    public Node<T> prev;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return data != null ? data.toString() : "null";
    }
}
