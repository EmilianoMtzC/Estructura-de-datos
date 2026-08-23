package Actividades.Actividad2;

import java.util.Scanner;

/** Clase principal. */
public class Main {

    void main() {
        Scanner sc = new Scanner(System.in);
        Cola<String> procesos = new Cola<>();
        Pila<String> historial = new Pila<>();
        int opcion;

        do {
            IO.println("\n=== GESTION DE PROCESOS ===");
            IO.println("1. Agregar proceso");
            IO.println("2. Ejecutar siguiente proceso");
            IO.println("3. Ver siguiente proceso");
            IO.println("4. Mostrar procesos pendientes");
            IO.println("5. Ver ultimo proceso ejecutado");
            IO.println("6. Mostrar historial de procesos");
            IO.println("7. Ejecutar pruebas");
            IO.println("8. Salir");
            IO.print("Elige una opcion (1-8): ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    IO.print("Nombre del proceso: ");
                    String nombre = sc.nextLine();
                    procesos.enqueue(nombre);
                    IO.println("Proceso agregado correctamente");
                    break;

                case 2:
                    if (procesos.isEmpty()) {
                        IO.println("No hay procesos pendientes");
                        break;
                    }
                    String procesoEjecutado = procesos.dequeue();
                    historial.push(procesoEjecutado);
                    IO.println("Proceso ejecutado: " + procesoEjecutado);
                    break;

                case 3:
                    if (procesos.isEmpty()) {
                        IO.println("No hay procesos pendientes");
                    } else {
                        IO.println("Siguiente proceso: " + procesos.peek());
                    }
                    break;

                case 4:
                    procesos.mostrar();
                    break;

                case 5:
                    if (historial.isEmpty()) {
                        IO.println("No se han ejecutado procesos");
                    } else {
                        IO.println("Ultimo proceso ejecutado: " + historial.peek());
                    }
                    break;

                case 6:
                    historial.mostrar();
                    break;

                case 7:
                    Pruebas.ejecutarPruebas();
                    break;

                case 8:
                    IO.println("Programa finalizado");
                    break;

                default:
                    IO.println("Opcion invalida");
            }
        } while (opcion != 8);
    }
}
