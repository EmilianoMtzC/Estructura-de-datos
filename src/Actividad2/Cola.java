package Actividades.Actividad2;

/**
 * Cola generica basada en una lista ligada simple.
 * Sigue el principio FIFO: el primero en entrar es el primero en salir.
 */
public class Cola<T> {

    public final LinkedList<T> elementos;

    public Cola() {
        elementos = new LinkedList<>(1);
    }

    public void enqueue(T data) {
        elementos.createData(data);
    }

    public T dequeue() {
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
