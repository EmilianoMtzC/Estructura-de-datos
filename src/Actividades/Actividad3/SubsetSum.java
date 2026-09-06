package Actividades.Actividad3;

public class SubsetSum {
    public static boolean existeSubconjunto(int[] numeros, int objetivo) {
        return existeSubconjunto(numeros, objetivo, 0);
    }

    private static boolean existeSubconjunto(int[] numeros, int objetivo, int indice) {
        if (objetivo == 0) {
            return true;
        }
        if (indice == numeros.length) {
            return false;
        }
        return existeSubconjunto(numeros, objetivo - numeros[indice], indice + 1)
                || existeSubconjunto(numeros, objetivo, indice + 1);
    }
}
