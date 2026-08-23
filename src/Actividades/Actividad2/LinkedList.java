package Actividades.Actividad2;

import java.util.Objects;

/**
 * Lista ligada generica que puede ser simple, doble o circular.
 * Incluye operaciones en los extremos para servir como base de pilas y colas.
 *
 * @param <T> tipo de dato almacenado
 */
public class LinkedList<T> {

    public Node<T> head;
    public Node<T> tail;
    public int size;
    public int listType;

    public LinkedList(int listType) {
        if (listType < 1 || listType > 3) {
            throw new IllegalArgumentException("Tipo de lista invalido");
        }

        this.listType = listType;
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    /** Agrega un elemento al inicio de la lista. */
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            if (listType == 2) {
                head.prev = newNode;
            }
            head = newNode;
        }

        if (listType == 3) {
            tail.next = head;
        }
        size++;
    }

    /** Agrega un elemento al final de la lista. */
    public void createData(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            if (listType == 2) {
                newNode.prev = tail;
            }
            tail = newNode;
        }

        if (listType == 3) {
            tail.next = head;
        }
        size++;
    }

    /** Consulta el primer elemento sin eliminarlo. */
    public T getFirst() {
        if (isEmpty()) {
            IO.println("La lista esta vacia");
            return null;
        }
        return head.data;
    }

    /** Elimina y devuelve el primer elemento. */
    public T removeFirst() {
        if (isEmpty()) {
            IO.println("La lista esta vacia");
            return null;
        }

        T data = head.data;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            if (listType == 2) {
                head.prev = null;
            }
            if (listType == 3) {
                tail.next = head;
            }
        }
        size--;
        return data;
    }

    public boolean searchData(T data) {
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(current.data, data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void readData() {
        if (isEmpty()) {
            IO.println("La lista esta vacia");
            return;
        }

        IO.println("Datos de la lista:");
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            IO.println(current.data);
            IO.println("--------------------");
            current = current.next;
        }
    }

    public void updateData(int position, T newData) {
        Node<T> current = getNode(position);
        if (current == null) {
            return;
        }
        current.data = newData;
        IO.println("Dato actualizado correctamente.");
    }

    public void deleteData(T data) {
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(current.data, data)) {
                deleteData(i);
                return;
            }
            current = current.next;
        }
        IO.println("No se encontro el dato");
    }

    public void deleteData(int position) {
        if (!validatePosition(position)) {
            return;
        }

        if (position == 0) {
            removeFirst();
            IO.println("Elemento eliminado");
            return;
        }

        Node<T> previous = getNode(position - 1);
        Node<T> current = previous.next;
        previous.next = current.next;

        if (current == tail) {
            tail = previous;
        }
        if (listType == 2 && current.next != null) {
            current.next.prev = previous;
        }
        if (listType == 3) {
            tail.next = head;
        }

        size--;
        IO.println("Elemento eliminado");
    }

    public Node<T> getNode(int position) {
        if (!validatePosition(position)) {
            return null;
        }
        Node<T> current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        return current;
    }

    public boolean validatePosition(int position) {
        if (position < 0 || position >= size) {
            IO.println("Posicion invalida");
            return false;
        }
        return true;
    }
}
