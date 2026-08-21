package Clases.Semana2.Queue;

public class QueueSimple {
    public Node<String> front;
    public Node<String> back;
    public int size;

    public QueueSimple() {
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    public boolean isEmpty() {return front == null;}

    public void Enqueue(String nombre) {
        Node<String> nuevoNodo = new Node<>(nombre);
        if (isEmpty()) {
            front = nuevoNodo;
            back = nuevoNodo;
            IO.println("Se agrego el primer elemento");
            return;
        }
        back.next = nuevoNodo;
        back = nuevoNodo;
        size++;
        IO.println("Se agrego el ultimo elemento");
    }

    public String Dequese() {
        if(isEmpty()) {
            IO.println("No hay elementos en la cola");
            return null;
        }
        String atendido = front.data;
        front = front.next;
        if (front == null) back = null;

        size--;
        IO.println("El elemento atendido es: " + atendido);
        return atendido;
    }

    public void peek() {
        if(isEmpty()) {
            IO.println("No hay elementos en la cola");
            ;
        }
        Node<String> actual = front;
        IO.println("El elemento en la cola es: " + actual.data);
        while (actual.next != null) {
            IO.println("El siguiente elemento es: " + actual.next.data);
            actual = actual.next;
        }
        IO.println("El ultimo elemento es: " + actual.data);
    }

}
