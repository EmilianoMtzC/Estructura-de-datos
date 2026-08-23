package Actividades.Actividad2;

/** Realiza pruebas sencillas de la pila y la cola. */
public class Pruebas {

    public static void ejecutarPruebas() {
        IO.println("\n=== PRUEBAS DE PILA ===");
        Pila<String> pila = new Pila<>();
        pila.push("Proceso 1");
        pila.push("Proceso 2");

        IO.println("Tope esperado: Proceso 2");
        IO.println("Tope obtenido: " + pila.peek());
        IO.println("Elemento removido: " + pila.pop());
        IO.println("Nuevo tope: " + pila.peek());

        IO.println("\n=== PRUEBAS DE COLA ===");
        Cola<String> cola = new Cola<>();
        cola.enqueue("Proceso 1");
        cola.enqueue("Proceso 2");

        IO.println("Frente esperado: Proceso 1");
        IO.println("Frente obtenido: " + cola.peek());
        IO.println("Elemento removido: " + cola.dequeue());
        IO.println("Nuevo frente: " + cola.peek());
    }
}
