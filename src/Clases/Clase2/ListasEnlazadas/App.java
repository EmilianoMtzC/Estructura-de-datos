package Clases.Clase2.ListasEnlazadas;

public class App {
    public static void main(String[] args) throws Exception {
        //Crear nodos
        Node<Integer> n1 = new Node<>(10);
        Node<Integer> n2 = new Node<>(20);
        Node<Integer> n3 = new Node<>(30);

        //Conectar nodos
        n1.next = n2;
        n2.next = n3;

        //Recorrido de la estructura
        Node<Integer> actual = n1;
        while(actual != null) {
            IO.println("Dato: " + actual.data);
            actual = actual.next;
        }

    }


}
