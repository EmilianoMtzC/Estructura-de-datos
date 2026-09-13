package Actividad4;

import java.util.NoSuchElementException;
import java.util.Objects;

/** Pruebas funcionales de la lista ligada, la pila, la cola y su integración. */
public class Pruebas {
    private static int testsPassed;

    public static void ejecutarPruebas() {
        testsPassed = 0;
        probarListaLigada();
        probarPila();
        probarCola();
        probarSistemaOperativo();
        System.out.println("Pruebas finalizadas correctamente: " + testsPassed);
    }

    private static void probarListaLigada() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(10);
        list.addLast(20);
        verify(10, list.removeFirst(), "La lista debe retirar el primer elemento");
        verify(20, list.removeFirst(), "La lista debe actualizar correctamente el ultimo nodo");
        verify(true, list.isEmpty(), "La lista debe quedar vacia");
        list.addLast(30);
        verify(30, list.getFirst(), "La lista debe poder reutilizarse despues de vaciarse");
    }

    private static void probarPila() {
        Pila<String> stack = new Pila<>();
        stack.push("A");
        stack.push("B");
        verify("B", stack.peek(), "Peek de pila debe consultar el ultimo elemento");
        verify("B", stack.pop(), "Pop de pila debe retirar el ultimo elemento");
        verify("A", stack.pop(), "La pila debe conservar el orden LIFO");
        verify(true, stack.isEmpty(), "La pila debe quedar vacia");
        verifyException(stack::pop, "Pop en una pila vacia debe informar el error");
    }

    private static void probarCola() {
        Cola<String> queue = new Cola<>();
        queue.enqueue("A");
        queue.enqueue("B");
        verify("A", queue.peek(), "Peek de cola debe consultar el primer elemento");
        verify("A", queue.dequeue(), "Dequeue debe retirar el primer elemento");
        verify("B", queue.dequeue(), "La cola debe conservar el orden FIFO");
        verify(true, queue.isEmpty(), "La cola debe quedar vacia");
        verifyException(queue::dequeue, "Dequeue en una cola vacia debe informar el error");
    }

    private static void probarSistemaOperativo() {
        SistemaOperativoSimulado os = new SistemaOperativoSimulado();
        os.addProcess("Navegador");
        os.addProcess("Editor");
        verify("Navegador", os.peekNextProcess().getName(), "El primer proceso debe quedar al frente");
        verify("Navegador", os.executeNextProcess().getName(), "Debe ejecutarse el proceso mas antiguo");
        verify("Editor", os.executeNextProcess().getName(), "Debe respetarse el orden de la cola");
        verify("Editor", os.peekLastExecutedProcess().getName(), "El historial debe usar una pila");
        verify(false, os.hasPendingProcesses(), "No deben quedar procesos pendientes");
    }

    private static void verify(Object expected, Object actual, String message) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionError(message + ". Esperado: " + expected + ", obtenido: " + actual);
        }
        testsPassed++;
    }

    private static void verifyException(Runnable operation, String message) {
        try {
            operation.run();
            throw new AssertionError(message);
        } catch (NoSuchElementException expected) {
            testsPassed++;
        }
    }
}
