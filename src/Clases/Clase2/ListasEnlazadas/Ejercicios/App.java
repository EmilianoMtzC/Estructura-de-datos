package Clases.Clase2.ListasEnlazadas.Ejercicios;
import java.util.LinkedList;
import java.util.Scanner;

public class App<T> {
    void main() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        int opcionLista = 0;

        do {
            IO.print("=== MENU ===");
            IO.println("1. Elegir tipo de lista");
            IO.println("2. Ver los tipos de datos");
            IO.println("3. Insertar elemento");
            IO.println("4. Mostrar elemento");
            IO.println("5. Buscar elemento");
            IO.println("6. Eliminar elemento");
            IO.println("7. Salir");
            IO.print("Elige una opcion (1-7): ");
            opcion = sc.nextInt();

            int tipoDato = 0;
            ListaEnlazada<T> lista = null;
            switch (opcion) {
                case 1:
                    IO.println("==== Crear lista ====");
                    IO.println("Tipo de lista (1-3): ");
                    IO.println("1. Lista Enlazada. \n 2. Lista Doblemente Enlazada. \n 3. Lista Circular.");
                    opcionLista = sc.nextInt();
                    lista = new ListaEnlazada(opcionLista);

                    break;

                case 2:
                    // Definir el tipo de dato de una lista
                    IO.println("Tipo de dato: ");
                    IO.println("1. Int \n 2. String \n 3. Double \n 4. float \n 5. Alumnos");
                    tipoDato = sc.nextInt();
                    break;

                case 3:
                    if (lista == null) {
                        IO.println("No hay lista creada");
                        break;
                    }
                    IO.println("Ingresa el dato a insertar: \n 1. Numero Entero, 2. Texto, 3. Alumno");
                    int opcionDato = sc.nextInt();
                    if (opcionDato == 1) {
                       IO.println("Ingresa el dato a Numerico: ");
                       int val = sc.nextInt();
                       lista.appendNode(val);
                       System.out.println("Elemento insertado");

                    } else if (opcionDato == 2) {
                        IO.println("Ingresa el dato a Texto: ");
                        String texto = sc.nextLine();
                        lista.appendNode(texto);
                        System.out.println("Elemento insertado");
                    } else if (opcionDato == 3) {
                        IO.println("Ingresa el dato a Alumno: ");
                        IO.println("Ingresa el nombre del alumno: ");
                        String nombre = sc.nextLine();
                        IO.println("Ingresa el telefono del alumno: ");
                        String telefono = sc.nextLine();
                        IO.println("Ingresa el edad del alumno: ");
                        String matricula = sc.nextLine();
                        IO.println("Ingresa el correo del alumno: ");
                        String correo = sc.nextLine();
                        Alumno alumno = new Alumno(nombre, telefono, matricula, correo);

                        lista.appendNode(alumno);
                        System.out.println("Elemento insertado");
                    }

                    break;
            }

        } while (opcion == 7);

    }
}
