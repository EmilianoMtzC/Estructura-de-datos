package Actividades.Actividad3;

import java.util.Random;

public class Sudoku {
    private static final Random ALEATORIO = new Random();

    public static boolean resolver(int[][] tablero) {
        return resolverDesde(tablero, 0, 0);
    }
    public static int[][] generarAleatorio() {
        int[][] tablero = new int[9][9];
        resolverAleatorio(tablero, 0, 0);

        int[] posiciones = new int[81];
        for (int i = 0; i < posiciones.length; i++) {
            posiciones[i] = i;
        }
        mezclar(posiciones);

        for (int i = 0; i < 45; i++) {
            int posicion = posiciones[i];
            tablero[posicion / 9][posicion % 9] = 0;
        }
        return tablero;
    }

    private static boolean resolverDesde(int[][] tablero, int fila, int columna) {
        if (fila == 9) {
            return true;
        }

        int siguienteFila = columna == 8 ? fila + 1 : fila;
        int siguienteColumna = columna == 8 ? 0 : columna + 1;

        if (tablero[fila][columna] != 0) {
            return resolverDesde(tablero, siguienteFila, siguienteColumna);
        }

        for (int numero = 1; numero <= 9; numero++) {
            if (esValido(tablero, fila, columna, numero)) {
                tablero[fila][columna] = numero;
                if (resolverDesde(tablero, siguienteFila, siguienteColumna)) {
                    return true;
                }
                tablero[fila][columna] = 0; // backtracking
            }
        }
        return false;
    }

    private static boolean resolverAleatorio(int[][] tablero, int fila, int columna) {
        if (fila == 9) {
            return true;
        }

        int siguienteFila = columna == 8 ? fila + 1 : fila;
        int siguienteColumna = columna == 8 ? 0 : columna + 1;
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        mezclar(numeros);

        for (int numero : numeros) {
            if (esValido(tablero, fila, columna, numero)) {
                tablero[fila][columna] = numero;
                if (resolverAleatorio(tablero, siguienteFila, siguienteColumna)) {
                    return true;
                }
                tablero[fila][columna] = 0;
            }
        }
        return false;
    }

    private static void mezclar(int[] valores) {
        for (int i = valores.length - 1; i > 0; i--) {
            int j = ALEATORIO.nextInt(i + 1);
            int temporal = valores[i];
            valores[i] = valores[j];
            valores[j] = temporal;
        }
    }

    private static boolean esValido(int[][] tablero, int fila, int columna, int numero) {
        for (int i = 0; i < 9; i++) {
            if (tablero[fila][i] == numero || tablero[i][columna] == numero) {
                return false;
            }
        }

        int inicioFila = (fila / 3) * 3;
        int inicioColumna = (columna / 3) * 3;
        for (int i = inicioFila; i < inicioFila + 3; i++) {
            for (int j = inicioColumna; j < inicioColumna + 3; j++) {
                if (tablero[i][j] == numero) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void imprimir(int[][] tablero) {
        for (int[] fila : tablero) {
            for (int numero : fila) {
                System.out.print(numero + " ");
            }
            System.out.println();
        }
    }
}
