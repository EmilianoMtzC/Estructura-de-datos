package Actividad4;

/**
 * Nodo genérico de una lista simplemente ligada.
 *
 * @param <T> tipo de dato almacenado
 */
class Node<T> {
    final T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
    }
}
