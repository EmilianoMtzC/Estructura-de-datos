package Actividad4;

import java.util.NoSuchElementException;

/**
 * Módulo de gestión de procesos de un sistema operativo simulado.
 * La cola conserva el orden de ejecución y la pila guarda el historial,
 * colocando el proceso ejecutado más recientemente en el tope.
 */
public class SistemaOperativoSimulado {
    private final Cola<Proceso> readyQueue = new Cola<>();
    private final Pila<Proceso> executionHistory = new Pila<>();
    private int nextId = 1;

    /** Registra un proceso y lo coloca al final de la cola de espera. */
    public Proceso addProcess(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("El nombre del proceso no puede estar vacio");
        }

        Proceso process = new Proceso(nextId++, name.trim());
        readyQueue.enqueue(process);
        return process;
    }

    /** Ejecuta el proceso que lleva más tiempo esperando. */
    public Proceso executeNextProcess() {
        if (readyQueue.isEmpty()) {
            throw new NoSuchElementException("No hay procesos pendientes");
        }

        Proceso process = readyQueue.dequeue();
        executionHistory.push(process);
        return process;
    }

    public Proceso peekNextProcess() {
        if (readyQueue.isEmpty()) {
            throw new NoSuchElementException("No hay procesos pendientes");
        }
        return readyQueue.peek();
    }

    public Proceso peekLastExecutedProcess() {
        if (executionHistory.isEmpty()) {
            throw new NoSuchElementException("No se han ejecutado procesos");
        }
        return executionHistory.peek();
    }

    public boolean hasPendingProcesses() {
        return !readyQueue.isEmpty();
    }

    public boolean hasExecutedProcesses() {
        return !executionHistory.isEmpty();
    }

    public int getPendingProcessCount() {
        return readyQueue.getSize();
    }

    public String getPendingProcesses() {
        return readyQueue.toString();
    }

    public String getExecutionHistory() {
        return executionHistory.toString();
    }
}
