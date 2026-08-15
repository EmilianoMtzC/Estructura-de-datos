package Clases.Actividad1;
import java.util.Scanner;

public class Main {
    void main() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        int opcionLista = 0;
        int opcionTipo = 0;
        LinkedList<?> lista = null;
        LinkedList<String> listaString = null;
        LinkedList<Integer> listaInteger = null;
        LinkedList<Contacto> listaContacto = null;

        do {
            IO.print("=== MENU ===");
            IO.println("1. Elegir tipo de lista");
            IO.println("2. Seleccionar tipo de dato");
            IO.println("3. Insertar elemento");
            IO.println("4. Mostrar elemento");
            IO.println("5. Buscar elemento");
            IO.println("6. Eliminar elemento");
            IO.println("7. Salir");
            IO.print("Elige una opcion (1-7): ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    IO.print("Tipo de lista: ");
                    IO.println("1. Enlazada simple");
                    IO.println("2. Enlazada doble");
                    IO.println("3. Circular simple");
                    opcionLista = sc.nextInt();
                    lista = new LinkedList<>(opcionLista);
                    break;

                case 2:
                    if(lista == null){IO.println("Selecciona una lista"); break;}

                    IO.println("Que tipo de dato quieres agregar: ");
                    IO.println("1. String");
                    IO.println("2. Integer");
                    IO.println("3. Contacto");
                    opcionTipo = sc.nextInt();

                    switch (opcionTipo) {
                        case 1:
                            listaString = new LinkedList<>(opcionLista);
                            lista = listaString;
                            IO.println("Tipo String seleccionado.");
                            break;

                        case 2:
                            listaInteger = new LinkedList<>(opcionLista);
                            lista = listaInteger;
                            IO.println("Tipo Integer seleccionado.");
                            break;

                        case 3:
                            listaContacto = new LinkedList<>(opcionLista);
                            lista = listaContacto;
                            IO.println("Tipo Contacto seleccionado.");
                            break;

                        default:
                            IO.println("Tipo de dato invalido.");
                    }
                    break;

                case 3:
                    boolean correcto = true;
                    if (lista == null) {IO.println("Selecciona una lista"); break;}

                    if (opcionTipo == 3) {

                        sc.nextLine();

                        IO.println("Agregar contacto:");

                        IO.print("Ingrese el nombre: ");
                        String nombre = sc.nextLine();

                        IO.print("Desea ingresar una direccion? (1-Si, 2-No): ");
                        int opcionDireccion = sc.nextInt();

                        String direccion = "";

                        if (opcionDireccion == 1) {
                            sc.nextLine();

                            IO.print("Ingrese la direccion: ");
                            direccion = sc.nextLine();
                        }

                        sc.nextLine();

                        IO.print("Ingrese el telefono: ");
                        String telefono = sc.nextLine();

                        Contacto contacto =
                                new Contacto(nombre, direccion, telefono);

                        listaContacto.createData(contacto);

                        IO.println("Elemento agregado correctamente.");

                    }
                    else if (opcionTipo == 1) {
                        IO.println("Ingresa el String a agregar: ");

                        sc.nextLine(); // limpiar el Enter pendiente
                        String dato = sc.nextLine();

                        listaString = (LinkedList<String>) lista;
                        listaString.createData(dato);

                        break;
                    }
                    else if (opcionTipo == 2) {
                        IO.println("Ingresa el Integer a agregar: ");

                        int dato = sc.nextInt();

                        listaInteger = (LinkedList<Integer>) lista;
                        listaInteger.createData(dato);

                        break;
                    }
                    break;


                case 4:
                    if (lista == null) {IO.println("Selecciona una lista"); break;}

                    if (opcionTipo == 1) {
                        listaString.readData();
                    } else if (opcionTipo == 2) {
                        listaInteger.readData();
                    } else if (opcionTipo == 3) {
                        listaContacto.readData();
                    } else {
                        IO.println("Selecciona un tipo de dato o crea una lista.");
                    }

                    break;

                case 5:
                    break;

                case 6:
                    break;

                case 7:
                    break;
            }


        } while (opcion != 7);

    }
}