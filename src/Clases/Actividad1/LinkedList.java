package Clases.Actividad1;

import java.util.Objects;

/**
 * Representa una lista enlazada genérica que puede funcionar como
 * lista simplemente enlazada, doblemente enlazada o circular.
 *
 * @param <T> tipo de dato que almacenará la lista
 */
public class LinkedList<T> {

    // Atributos de la lista
    public Node<T> head;        // Primer nodo de la lista
    public Node<T> tail;        // Ultimo nodo de la lista
    public int size;            // Tamanio de la lista
    public int listType;        // 1: simple enlazada, 2: doblemente enlazada, 3: circular

    // Constructor
    public LinkedList(int listType) {
        if (listType < 1 || listType > 3) {
            throw new IllegalArgumentException("Tipo de lista invalido");
        }

        this.listType = listType;
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Metodos

    /**
     * Verifica si la lista está vacía.
     *
     * @return True si la lista no contiene elementos;
     *         False en caso contrario
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * @return tamanio de la lista.
     */
    public int getSize() {
        return size;
    }

    // READ
    /**
     * Muestra los datos de la lista.
     */
    public void printData() {
        if (isEmpty()) {
            IO.println("La lista esta vacia");
            return;
        }
        IO.print("Datos de la lista: ");
    }

    // SEARCH
    /**
     * Busca un elemento en la lista.
     * @param data dato que se buscara en la lista.
     */
    public boolean searchData(T data) {
        if (isEmpty()) {
            return false;
        }

        Node<T> current = head;

        if (listType == 3) {
            do {
                if (Objects.equals(current.data, data)) {
                    return true;
                }

                current = current.next;
            } while (current != head);

        } else {
            while (current != null) {
                if (Objects.equals(current.data, data)) {
                    return true;
                }

                current = current.next;
            }
        }

        return false;
    }


    // CREATE
    /**
     * Agrega un nuevo elemento al final de la lista.
     * @param data dato que se agregará a la lista
     */
    public void createData(T data) {
        Node<T> newNode = new Node<>(data);     // Crea un nuevo nodo con el dato

        /**
         * Agrega un nuevo elemento al final de la lista.
         * @param data dato que se agregará a la lista
         */
        if (isEmpty()){
            head = newNode;
            tail = newNode;

            if (listType == 3) {
                head.next = head;
            }

        } else {
            if (listType == 1) {
                Node<T> current = head;

                while (current.next != null) {
                    current = current.next;
                }
                tail.next = newNode;
                tail = newNode;


            } else if (listType == 2) {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            } else if (listType == 3) {
                tail.next = newNode;
                newNode.next = head;
                tail = newNode;
            }


        }
        size++;
    }

    // READ
    /**
     * Muestra los datos de la lista.
     */
    public void readData() {
        if (isEmpty()) {
            IO.println("La lista esta vacia");
            return;
        }

        IO.println("Datos de la lista:");

        Node<T> current = head;

        if (listType == 3) {

            do {
                IO.println(current.data);
                IO.println("--------------------");

                current = current.next;
            } while (current != head);

        } else {

            while (current != null) {
                IO.println(current.data);
                IO.println("--------------------");

                current = current.next;
            }
        }
    }

    // UPDATE
    /**
     * Actualiza el dato de un nodo de la lista.
     * @param newData dato que se sustituira en la lista
     */
    public void updateData(int position, T newData) {
        if (isEmpty()) {
            IO.println("La lista esta vacia");
            return;
        }

        if (position < 0 || position >= size) {
            IO.println("Posicion invalida.");
            return;
        }

        Node<T> current = head;

        for (int i = 0; i < position; i++) {
            current = current.next;
        }

        current.data = newData;

        IO.println("Dato actualizado correctamente.");
    }

    // DELETE
    /**
     * Busca un elemento en la lista y lo elimina.
     * @param data dato que se eliminara en la lista.
     */
    public void deleteData(T data) {
        if (isEmpty()) {
            IO.println("La lista esta vacia");
            return;
        }

        Node<T> current = head;
        Node<T> previous = null;
        boolean found = false;

        while(current != null) {
            if(Objects.equals(current.data, data)) {
                found = true;
                break;
            }
            previous = current;
            current = current.next;
            if(listType == 3 && current == head) break;
        }

        if(!found) {
            IO.println("No se encontro el dato");
            return;
        }

        if (size == 1) {
            head = null;
            tail = null;
        } else if (current == head) { // ELIMINAR EL PRIMER ELEMENTO
            head = head.next;
            if(listType ==2) head.prev = null;
            if(listType == 3) tail.next = head;
        } else if (current == tail) { // ELIMINAR EL ULTIMO ELEMENTO
            tail = previous;
            if(listType == 2) tail.next = null;
            if(listType == 3) tail.next = head;
        } else {                    // ELIMINAR UN ELEMENTO EN MEDIO DE LA LISTA
            previous.next = current.next;
            if(listType == 2 && current.next != previous) current.next.prev = previous;

        }
        size--;
        IO.println("Elemento eliminado");
    }

    /**
     * Elimina un elemento de la lista utilizando su posicion.
     * @param position posicion del elemento que se eliminara.
     */
    public void deleteData(int position) {
        if (isEmpty()) {
            IO.println("La lista esta vacia");
            return;
        }

        if (position < 0 || position >= size) {
            IO.println("Posicion invalida.");
            return;
        }

        Node<T> current = head;

        for (int i = 0; i < position; i++) {
            current = current.next;
        }

        deleteData(current.data);
    }

}
