package Clases.Actividad1;

/**
 * Representa un nodo genérico que puede utilizarse como elemento
 * de una estructura de datos enlazada.
 * Cada nodo almacena un dato y referencias al nodo siguiente
 * y al nodo anterior, permitiendo formar estructuras enlazadas
 * simples o dobles.
 *
 * @param <T> tipo de dato que almacenará el nodo
 */
public class Node<T> {

    // Atributos del nodo
    public T data;          // Datos que contiene el nodo
    public Node<T> next;    // Referencia al siguiente nodo
    public Node<T> prev;    // Referencia al nodo anterior

    // Constructor
    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    // Metodo toString
    /**
     * Devuelve el valor del nodo en forma de String.
     *
     * Si el valor de nodo == null, devuelve "null".
     *
     * @return representacion en String del dato almacenado en el nodo.
     */
    @Override
    public String toString() {
        return data != null ? data.toString() : "null";
    }
}
