package Clases.Clase2.ListasEnlazadas.Ejercicios;

public class App {
    void main() {
        Alumnos a1 = new Alumnos("Juan", "123456789", "123456789", "Juan@gmail.com");
        Alumnos a2 = new Alumnos("Pedro", "987654321", "987654321", "Pedro@gmail.com");
        Alumnos a3 = new Alumnos("Maria", "098765432", "098765432", "Maria@gmail.com");

        Node n1 = new Node(a1);
        Node n2 = new Node(a2);
        Node n3 = new Node(a3);

        n1.next = n2;
        n2.next = n3;

        Node actual = n1;
        while(actual != null) {
            System.out.println(actual.data);
            actual = actual.next;
        }

    }
}
