package Clases.Actividad1;
import java.util.Scanner;

/**
 * Clase principal del programa.
 * Muestra el menu y permite al usuario trabajar con los diferentes
 * tipos de listas y datos.
 */
public class Main {

    /**
     * Punto de entrada del programa.
     */
    void main() {
        Scanner sc = new Scanner(System.in);

        // Opciones seleccionadas por el usuario
        int opcion;
        int opcionLista = 0;
        int opcionTipo = 0;

        // Listas disponibles para cada tipo de dato
        LinkedList<?> lista = null;
        LinkedList<String> listaString = null;
        LinkedList<Integer> listaInteger = null;
        LinkedList<Contacto> listaContacto = null;
        DataTypeExamples ejemplos = new DataTypeExamples();

        // El menu se repite hasta que el usuario selecciona la opcion de salir
        do {
            IO.println("=== MENU ===");
            IO.println("1. Elegir tipo de lista");
            IO.println("2. Seleccionar tipo de dato");
            IO.println("3. Insertar elemento");
            IO.println("4. Mostrar lista");
            IO.println("5. Buscar elemento");
            IO.println("6. Actualizar elemento");
            IO.println("7. Eliminar elemento");
            IO.println("8. Ejemplos de tipos de datos");
            IO.println("9. Salir");
            IO.print("Elige una opcion (1-9): ");
            opcion = sc.nextInt();

            switch (opcion) {
                // Seleccion del tipo de lista enlazada
                case 1:
                    IO.println("\nTipo de lista: ");
                    IO.println("1. Enlazada simple");
                    IO.println("2. Enlazada doble");
                    IO.println("3. Circular simple");
                    IO.print("Elige una opcion del (1-3): ");
                    opcionLista = sc.nextInt();

                    if (opcionLista < 1 || opcionLista > 3) {
                        IO.println("Tipo de lista invalido.");
                        opcionLista = 0;
                    } else {
                        lista = new LinkedList<>(opcionLista);
                        opcionTipo = 0;
                        listaString = null;
                        listaInteger = null;
                        listaContacto = null;
                        IO.println("Tipo de lista seleccionado.");
                    }
                    break;

                // Seleccion del tipo de dato que almacenara la lista
                case 2:
                    if(lista == null){IO.println("Selecciona una lista"); break;}

                    IO.println("\nQue tipo de dato quieres agregar: ");
                    IO.println("1. String");
                    IO.println("2. Integer");
                    IO.println("3. Contacto");
                    IO.print("Elige una opcion del (1-3): ");
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
                    if (lista == null) {IO.println("\nSelecciona una lista"); break;}
                    if (opcionTipo == 0) {IO.println("\nSelecciona un tipo de dato"); break;}

                    if (opcionTipo == 3) {

                        sc.nextLine();

                        IO.println("\nAgregar contacto:");

                        IO.print("Ingrese el nombre: ");
                        String nombre = sc.nextLine();

                        IO.print("Desea ingresar una direccion? (1-Si, 2-No): ");
                        int opcionDireccion = sc.nextInt();

                        String direccion = "";

                        sc.nextLine();

                        if (opcionDireccion == 1) {
                            IO.print("Ingrese la direccion: ");
                            direccion = sc.nextLine();
                        }

                        IO.print("Ingrese el telefono: ");
                        String telefono = sc.nextLine();

                        Contacto contacto =
                                new Contacto(nombre, direccion, telefono);

                        listaContacto.createData(contacto);

                        IO.println("Elemento agregado correctamente.");

                    }
                    else if (opcionTipo == 1) {
                        IO.println("\nIngresa el String a agregar: ");

                        sc.nextLine();
                        String dato = sc.nextLine();

                        listaString.createData(dato);

                        break;
                    }
                    else if (opcionTipo == 2) {
                        IO.println("\nIngresa el Integer a agregar: ");

                        int dato = sc.nextInt();

                        listaInteger.createData(dato);

                        break;
                    }
                    break;


                // Muestra todos los elementos de la lista seleccionada
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

                // Busca un elemento por su valor
                case 5:
                    if (lista == null) {
                        IO.println("Selecciona una lista");
                        break;
                    }

                    IO.println("Que dato quieres buscar:");

                    if (opcionTipo == 1) {
                        sc.nextLine();

                        IO.print("Ingresa el String: ");
                        String dato = sc.nextLine();

                        if (listaString.searchData(dato)) {
                            IO.println("El elemento si existe en la lista.");
                        } else {
                            IO.println("El elemento no existe en la lista.");
                        }

                    }
                    else if (opcionTipo == 2) {

                        IO.print("Ingresa el Integer: ");
                        int dato = sc.nextInt();

                        if (listaInteger.searchData(dato)) {
                            IO.println("El elemento si existe en la lista.");
                        } else {
                            IO.println("El elemento no existe en la lista.");
                        }

                    }
                    else if (opcionTipo == 3) {

                        sc.nextLine();

                        IO.print("Ingrese el nombre del contacto: ");
                        String nombre = sc.nextLine();

                        IO.print("Ingrese el telefono del contacto: ");
                        String telefono = sc.nextLine();

                        // La direccion no se solicita porque el contacto se identifica
                        Contacto contacto = new Contacto(nombre, "", telefono);

                        if (listaContacto.searchData(contacto)) {
                            IO.println("El contacto si existe en la lista.");
                        } else {
                            IO.println("El contacto no existe en la lista.");
                        }

                    }
                    else {
                        IO.println("Selecciona un tipo de dato.");
                    }

                    break;

                // Sustituye el elemento que se encuentra en una posicion
                case 6:
                    if (lista == null) {
                        IO.println("Selecciona una lista");
                        break;
                    }

                    if (opcionTipo == 1) {
                        IO.println("Actualiza el String de la lista: ");
                        listaString.readData();

                        IO.println("Ingresa la posicion del String a modificar: (int): ");
                        int posicion = sc.nextInt();
                        sc.nextLine(); // limpiar el Enter

                        IO.print("Ingresa el nuevo String: ");
                        String nuevoString = sc.nextLine();

                        listaString.updateData(posicion, nuevoString);
                    } else if (opcionTipo == 2) {
                        IO.println("Actualiza el Int de la lista: ");
                        listaInteger.readData();

                        IO.println("Ingresa la posicion del Int a modificar: (int): ");
                        int posicion = sc.nextInt();
                        sc.nextLine(); // limpiar el Enter

                        IO.print("Ingresa el nuevo Int: ");
                        int nuevoInt = sc.nextInt();

                        listaInteger.updateData(posicion, nuevoInt);

                    } else if (opcionTipo == 3) {
                        IO.println("Actualiza el Contacto de la lista: ");
                        listaContacto.readData();

                        IO.println("Ingresa la posicion del Contacto a modificar: (int): ");
                        int posicion = sc.nextInt();
                        sc.nextLine();

                        IO.print("Ingrese el nuevo nombre: ");
                        String nombre = sc.nextLine();

                        IO.print("Ingrese la nueva direccion: ");
                        String direccion = sc.nextLine();

                        IO.print("Ingrese el nuevo telefono: ");
                        String telefono = sc.nextLine();

                        Contacto contacto = new Contacto(nombre, direccion, telefono);
                        listaContacto.updateData(posicion, contacto);

                    }

                    break;

                // Elimina el elemento que se encuentra en una posicion
                case 7:
                    if (lista == null) {IO.println("Selecciona una lista");break;}

                    if (opcionTipo == 1) {
                        IO.println("Ingresa la posicion del String a eliminar: (int): ");
                        int posicion = sc.nextInt();
                        sc.nextLine();
                        listaString.deleteData(posicion);
                    }
                    else if (opcionTipo == 2) {
                        IO.println("Ingresa la posicion del Int a eliminar: (int): ");
                        int posicion = sc.nextInt();
                        sc.nextLine();
                        listaInteger.deleteData(posicion);
                    }
                    else if (opcionTipo == 3) {
                        IO.println("Ingresa la posicion del Contacto a eliminar: (int): ");
                        int posicion = sc.nextInt();
                        sc.nextLine();
                        listaContacto.deleteData(posicion);
                    }
                    else {
                        IO.println("Selecciona un tipo de dato.");
                        break;
                    }

                    break;

                // Ejecuta los ejemplos incluidos en DataTypeExamples
                case 8:
                    IO.println("\n=== EJEMPLOS DE TIPOS DE DATOS ===");
                    IO.println("1. Integer");
                    IO.println("2. String");
                    IO.println("3. Contacto");
                    IO.print("Elige una opcion del (1-3): ");
                    int opcionEjemplo = sc.nextInt();

                    if (opcionEjemplo == 1) {
                        ejemplos.intExample();
                    } else if (opcionEjemplo == 2) {
                        ejemplos.stringExample();
                    } else if (opcionEjemplo == 3) {
                        ejemplos.abstractExample();
                    } else {
                        IO.println("Ejemplo invalido.");
                    }
                    break;

                case 9:
                    IO.println("Programa finalizado.");
                    break;

                default:
                    IO.println("Opcion invalida.");
            }


        } while (opcion != 9);

    }
}
