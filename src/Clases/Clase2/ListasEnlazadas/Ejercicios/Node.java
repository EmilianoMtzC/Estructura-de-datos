package Clases.Clase2.ListasEnlazadas.Ejercicios;

public class Node<T> {
    public Alumnos data;
    public Node<T> next;
    public Node<T> prev;

    public Node(Alumnos data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public String toString() {
        return data != null ? data.toString() : "null";
    }
}


