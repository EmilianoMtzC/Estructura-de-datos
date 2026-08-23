package Actividades.Actividad2;

/**
 * Pila generica.
 * Sigue el principio el ultimo en entrar es el primero en salir.
 */
public class Pila<T> {

    public final LinkedList<T> elementos;

    public Pila() {
        elementos = new LinkedList<>(1);
    }

    public void push(T data) {
        elementos.addFirst(data);
    }

    public T pop() {
        return elementos.removeFirst();
    }

    public T peek() {
        return elementos.getFirst();
    }

    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    public int getSize() {
        return elementos.getSize();
    }

    public void mostrar() {
        elementos.readData();
    }
}
