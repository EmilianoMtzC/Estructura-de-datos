package Actividades.Actividad3;

public class Fibonacci {
    public static int calcular(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return calcular(n - 1) + calcular(n - 2);
    }
}
