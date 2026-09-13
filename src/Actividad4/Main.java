package Actividad4;

import java.util.Scanner;

/** Punto de entrada para el gestor de procesos del sistema operativo simulado. */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SistemaOperativoSimulado operatingSystem = new SistemaOperativoSimulado();
        int option;

        do {
            showMenu();
            option = readInteger("Elige una opcion: ");
                switch (option) {
                    case 1 -> addProcess(operatingSystem);
                    case 2 -> System.out.println("Proceso ejecutado: " + operatingSystem.executeNextProcess());
                    case 3 -> System.out.println("Siguiente proceso: " + operatingSystem.peekNextProcess());
                    case 4 -> System.out.println("Procesos pendientes: " + operatingSystem.getPendingProcesses());
                    case 5 -> System.out.println("Ultimo proceso ejecutado: "
                            + operatingSystem.peekLastExecutedProcess());
                    case 6 -> System.out.println("Historial de ejecucion: "
                            + operatingSystem.getExecutionHistory());
                    case 7 -> Pruebas.ejecutarPruebas();
                    case 0 -> System.out.println("Programa finalizado.");
                    default -> System.out.println("Opcion no valida.");
                }

        } while (option != 0);
    }

    private static void showMenu() {
        System.out.println("\n=== ACTIVIDAD 4: GESTOR DE PROCESOS ===");
        System.out.println("1. Agregar proceso");
        System.out.println("2. Ejecutar siguiente proceso");
        System.out.println("3. Ver siguiente proceso");
        System.out.println("4. Mostrar procesos pendientes");
        System.out.println("5. Ver ultimo proceso ejecutado");
        System.out.println("6. Mostrar historial de ejecucion");
        System.out.println("7. Ejecutar pruebas");
        System.out.println("0. Salir");
    }

    private static void addProcess(SistemaOperativoSimulado operatingSystem) {
        System.out.print("Nombre del proceso: ");
        String name = scanner.nextLine();
        System.out.println("Proceso agregado: " + operatingSystem.addProcess(name));
    }

    private static int readInteger(String message) {
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                int option = scanner.nextInt();
                scanner.nextLine();
                return option;
            }
            System.out.println("Ingresa un numero entero valido.");
            scanner.nextLine();
        }
    }
}
