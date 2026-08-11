import java.util.Scanner;

void main() {
    Scanner sc = new Scanner(System.in);
    /* TIPOS DE DATOS */

    // Enteros
    int edad = 16;

    // Nuembres reales
    float peso = 70.5f; // 32 Bits
    double dinero = 100.05; // 64 Bits

    // Caracteres
    /* En este caso no es como tal un tipo de dato en Java */
    char letra = 'a';
    String nombre = "Juan";

    // Logico
    boolean esMayor = false;

    IO.println("DATOS DEL ALUMNO: ");
    System.out.printf("Nombre: %s, Edad: %d, años", nombre, edad);

    //Oeraciones
    int a = 10;
    int b = 8;
    int suma = a + b;
    IO.println("\nSuma: " + suma);

    // INPUT
    IO.println("De que estado eres: ");
    // String estado = sc.nextLine();
    // IO.println("Tu estado es: " + estado);

    // Estructuras condicionales

    System.out.println("Ponme tu calificacion: ");
    double calificacion = sc.nextDouble();

    if (calificacion <= 6) {
        IO.println("Jaja bot");
    } else {
        IO.println("Que Pro");
    }

    //for
    IO.println("Tabla de multiplicar ");
    IO.println("Que tabla quieres: ");
    int tabla = sc.nextInt();
    for (int i = 1; i <= 10; i++) {
        IO.println(tabla + " x " + i + " = " + (tabla * i));
    }

    // do-while
    int opcion;
    do {
        System.out.println("=== MENÚ ===");
        System.out.println("1. Saludar");
        System.out.println("2. Hora");
        System.out.println("3. Salir");
        System.out.println("Elije una opcion (1-3): ");
        switch (opcion = sc.nextInt()) {
            case 1:
                IO.println("Hola");
                break;
            case 2:
                IO.println("La hora es: " + System.currentTimeMillis());
                break;
            case 3:
                IO.println("Adios");
                break;
            default:
                IO.println("Opcion no valida");
        }
    }while(opcion != 3);

}
