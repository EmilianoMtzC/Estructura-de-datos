package Clases.Clase2.ListasEnlazadas.Ejercicios;

public class ListaEnlazada {

    //Atributos de la Lista
    public Node<T> head;  // Primer Nodo
    public Node<T> tail;  // Ultimo Nodo / Lista Circular
    public int tipoLista; // 1. Simples | 2. Doble | 3. Circular
    public int size;

    //Constructor
    public ListaEnlazada(int tipoLista) {
        this.tipoLista = tipoLista;
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Métodos
    public boolean isEmpty() {
        return head == null;
    }

    public void appendNode(T data) {
        Node<T> nuevo = new Node<> (data);

        //Verificar si la lista está vacía
        if (isEmpty()) {
            head = nuevo;
            tail = nuevo;

            //Unicamente si es circular
            if (tipoLista == 3) {
                head.next = head;
            }

        } else {
            if (tipoLista == 1) {
                Node<T> actual = head;+while (actual.next != null) {
                    actual = actual.next;
                }
                actual.next = nuevo;
                tail = nuevo;
            } else if (tipoLista == 2) {
                tail.next = nuevo;
                nuevo.prev = tail;
                tail = nuevo;

            } else if (tipoLista == 3) {
                tail.next = nuevo;
                nuevo.next = head;
                tail = nuevo;
            }
            size++;
        }



    }

}
