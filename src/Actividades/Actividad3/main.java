package Actividades.Actividad3;
import java.util.Scanner;

public class main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- ACTIVIDAD 3: RECURSIVIDAD ---");
            System.out.println("1. Serie de Fibonacci");
            System.out.println("2. Suma de subconjuntos");
            System.out.println("3. Resolver Sudoku");
            System.out.println("0. Salir");
            opcion = leerEntero("Elige una opcion: ");

            switch (opcion) {
                case 1 -> ejecutarFibonacci();
                case 2 -> ejecutarSubsetSum();
                case 3 -> ejecutarSudoku();
                case 0 -> System.out.println("Hasta luego.");
                default -> System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }

    private static void ejecutarFibonacci() {
        int n;
        do {
            n = leerEntero("Ingresa n (mayor o igual a 0): ");
        } while (n < 0);
        System.out.println("Fibonacci(" + n + ") = " + Fibonacci.calcular(n));
    }

    private static void ejecutarSubsetSum() {
        int cantidad;
        do {
            cantidad = leerEntero("Cantidad de numeros: ");
        } while (cantidad < 0);

        int[] numeros = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            numeros[i] = leerEntero("Numero " + (i + 1) + ": ");
        }
        int objetivo = leerEntero("Suma objetivo: ");

        boolean existe = SubsetSum.existeSubconjunto(numeros, objetivo);
        System.out.println(existe
                ? "Si existe un subconjunto con esa suma."
                : "No existe un subconjunto con esa suma.");
    }

    private static void ejecutarSudoku() {
        boolean ingresarDatos = leerSiNo("Quieres ingresar los datos tu? (s/n): ");
        int[][] tablero = new int[9][9];

        if (ingresarDatos) {
            System.out.println("Ingresa las 81 celdas del Sudoku; usa 0 para una celda vacia.");
            for (int fila = 0; fila < 9; fila++) {
                for (int columna = 0; columna < 9; columna++) {
                    int valor;
                    do {
                        valor = leerEntero("Fila " + (fila + 1) + ", columna " + (columna + 1) + ": ");
                    } while (valor < 0 || valor > 9);
                    tablero[fila][columna] = valor;
                }
            }
        } else {
            tablero = Sudoku.generarAleatorio();
        }

        System.out.println("\nSudoku sin resolver:");
        Sudoku.imprimir(tablero);

        if (Sudoku.resolver(tablero)) {
            System.out.println("\nSudoku resuelto:");
            Sudoku.imprimir(tablero);
        } else {
            System.out.println("El Sudoku no tiene solucion.");
        }
    }

    private static boolean leerSiNo(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String respuesta = sc.next().trim().toLowerCase();
            if (respuesta.equals("s") || respuesta.equals("si")) {
                return true;
            }
            if (respuesta.equals("n") || respuesta.equals("no")) {
                return false;
            }
            System.out.println("Responde con s (si) o n (no).");
        }
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextInt()) {
                return sc.nextInt();
            }
            System.out.println("Ingresa un numero entero valido.");
            sc.next();
        }
    }
}
