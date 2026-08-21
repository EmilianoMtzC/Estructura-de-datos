package Clases.Semana1.ListasEnlazadas;

class Node<T> {
    public T data; // El dato del nodo
    public Node<T> next; // El enlace al siguiente nodo (Apuntador)
    public Node<T> prev; // El enlace al anterior nodo (Apuntador)

    // Constructor
    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public String toSting() {
        // Operadores ternarios
        return data != null ? data.toString() : "null";
    }

}
