package Clases.Semana3.RetoCafeteria.ManejoClientes;
import Clases.Semana3.RetoCafeteria.Node;

public class Queue {
    public Node<String> front;
    public Node<String> back;
    public int size;

    public Queue() {
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    public boolean isEmpty() {return front == null;}

    public void Enqueue(String nombre) {
        Node<String> newNode = new Node<>(nombre);
        if (isEmpty()) {
            front = newNode;
            back = newNode;
            IO.println("Se agrego el primer elemento");
            return;
        }
        back.next = newNode;
        back = newNode;
        size++;
        IO.println("Se agrego el ultimo elemento");
    }

    public String Dequese() {
        if(isEmpty()) {
            IO.println("No hay elementos en la cola");
            return null;
        }
        String attend = front.data;
        front = front.next;
        if (front == null) back = null;

        size--;
        IO.println("El elemento atendido es: " + attend);
        return attend;
    }

    public void peek() {
        if(isEmpty()) {
            IO.println("No hay elementos en la cola");
        }
        Node<String> current = front;
        IO.println("El elemento en la cola es: " + current.data);
        while (current.next != null) {
            IO.println("El siguiente elemento es: " + current.next.data);
            current = current.next;
        }
        IO.println("El ultimo elemento es: " + current.data);
    }

}
