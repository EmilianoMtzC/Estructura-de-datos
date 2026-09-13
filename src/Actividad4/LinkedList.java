package Actividad4;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Lista simplemente ligada genérica.
 *
 * Esta versión ajusta la lista de la Actividad 1 para utilizarla como base
 * de pilas y colas: conserva referencias tanto al primer como al último nodo.
 * Por ello, agregar al inicio, agregar al final y quitar el primero son
 * operaciones de tiempo constante.
 *
 * @param <T> tipo de dato almacenado
 */
public class LinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    /** Indica si la lista no contiene elementos. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Devuelve la cantidad de elementos almacenados. */
    public int getSize() {
        return size;
    }

    /** Agrega un dato al inicio de la lista. */
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    /** Agrega un dato al final de la lista. */
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /** Consulta el primer dato sin retirarlo. */
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("La lista esta vacia");
        }
        return head.data;
    }

    /** Retira y devuelve el primer dato de la lista. */
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("La lista esta vacia");
        }

        Node<T> removed = head;
        head = head.next;
        removed.next = null;
        size--;

        // Al retirar el ultimo nodo se deben actualizar ambos extremos.
        if (head == null) {
            tail = null;
        }
        return removed.data;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            result.append(iterator.next());
            if (iterator.hasNext()) {
                result.append(", ");
            }
        }
        return result.append(']').toString();
    }
}
