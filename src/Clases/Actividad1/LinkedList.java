package Clases.Actividad1;

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


    /**
     * Agrega un nuevo elemento al final de la lista.
     * @param data dato que se agregará a la lista
     */
    public void add(T data) {
        Node<T> newNode = new Node<>(data);

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
}
