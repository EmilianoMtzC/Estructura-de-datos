package Clases.Clase2.ListasEnlazadas.Ejercicios;

public class ListaEnlazada<T> {

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
    public void setTipoLista(int tipoLista) {
        this.tipoLista = tipoLista;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void appendNode(T data) {
        Node<T> nuevo = new Node<T>(data);

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
                Node<T> actual = head;
                while (actual.next != null) {
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

    public void showList() {

        // Verificar si la lista está vacía.
        if(isEmpty()) {
            IO.println("Nada, no hay nada...");
            return;
        }
        IO.print("Elementos de la lista: ");
        Node<T> actual = head;
        int i = 0;

        do{
            IO.print(actual.data + " -> ");
            actual = actual.next;
            if(tipoLista == 3 && actual == head) {
                break;
            }
            i++;
        } while(actual != null);

        if (tipoLista == 3){
            IO.println("Fin");
        } else {
            IO.println("null");
        }

    }

    public boolean search(T data) {
        if (isEmpty()) return false;
        Node<T> actual = head;
        do{
            if (actual.data.equals(data)) return true;
            actual = actual.next;
            if (tipoLista == 3 && actual == head) break;

        } while(actual != null);
        return false;
    }

    public void eliminar(T data) {
        if (isEmpty()) {
            IO.println("Ta mas vacia que mi cartera");
            return;
        }

        Node<T> actual = head;
        Node<T> anterior = null;
        boolean encontrado = false;
    // i
        do {
            if(actual.data.equals(data)) {
                encontrado = true;
                break;
            }
            anterior = actual;
            actual = actual.next;
            if(tipoLista == 3 && actual == head) break;


        } while(actual != null);
        if(!encontrado) {
            IO.println("No se encontro el dato");
            return;
        }

        if (size == 1) {
            head = null;
            tail = null;
        } else if (actual == head) { // ELIMINAR EL PRIMER ELEMENTO
            head = head.next;
            if(tipoLista ==2) head.prev = null;
            if(tipoLista == 3) tail.next = head;
        } else if (actual == tail) { // ELIMINAR EL ULTIMO ELEMENTO
            tail = anterior;
            if(tipoLista == 2) tail.next = null;
            if(tipoLista == 3) tail.next = head;
        } else {                    // ELIMINAR UN ELEMENTO EN MEDIO DE LA LISTA
            anterior.next = actual.next;
            if(tipoLista == 2 && actual.next != anterior) actual.next.prev = anterior;

        }
        size--;
        IO.println("Elemento eliminado");
    }


}
