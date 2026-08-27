package Clases.Semana3.RetoCafeteria;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Button boton = new Button("Hola JavaFX");

        VBox root = new VBox(10);
        root.getChildren().add(boton);

        Scene scene = new Scene(root, 400, 300);

        stage.setTitle("Reto Cafetería");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}








/*
package Clases.Semana3.RetoCafeteria;
import Clases.Semana3.RetoCafeteria.ManejoClientes.Queue;
import Clases.Semana3.RetoCafeteria.InventarioRapido.HashTable;
import Clases.Semana3.RetoCafeteria.HistorialCompras.Stack;
import java.util.Scanner;

public class App {
    public void main() {
        int opcion = 0;
        Queue cliente = new Queue();
        HashTable<String, Integer> inventario = new HashTable<>(10);
        Stack historial = new Stack();

        Scanner sc = new Scanner(System.in);

        while (opcion != 4) {
            IO.println("=============== MENU ===============");
            IO.println("    1. Fila de espera");
            IO.println("    2. Historial de compras");
            IO.println("    3. Inventario Cafeteria");
            IO.println("    4. Salir");
            IO.println("=====================================");
            IO.print("Elige una opcion (1-4): ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: {
                    int opcionCliente = 0;

                    IO.println("============ FILA DE ESPERA ============");
                    IO.println(" 1. Ingresar cliente ");
                    IO.println(" 2. Cliente atendido ");
                    IO.println(" 3. Mostrar clientes en espera ");
                    IO.println(" 4. Salir ");
                    IO.println("==========================================");
                    IO.print("Elige una opcion (1-3): ");
                    opcionCliente = sc.nextInt();
                    sc.nextLine();

                    if (opcionCliente == 1) {
                        IO.print("Ingresa el nombre del cliente: ");
                        String nombre = sc.nextLine();
                        cliente.Enqueue(nombre);
                    } else if (opcionCliente == 2) {
                        cliente.Dequese();
                    } else if (opcionCliente == 3) {
                        cliente.peek();
                    } else if (opcionCliente == 4) {
                        IO.println("Saliendo...");
                    }
                    break;
                }

                case 2: {
                    IO.println("============ HISTORIAL DE COMPRAS ============");
                    IO.println(" 1. Ingresar producto ");
                    IO.println(" 2. Mostrar historial de compras ");
                    IO.println(" 3. Salir ");
                    IO.println("==========================================");
                    IO.print("Elige una opcion (1-2): ");
                    int opcionHistorial = sc.nextInt();
                    sc.nextLine();

                    if (opcionHistorial == 1) {
                        IO.print("Ingresa el nombre del producto vendido: ");
                        String producto = sc.nextLine();
                        historial.push(producto);
                    } else if (opcionHistorial == 2) {
                        historial.showStack();
                    } else if (opcionHistorial == 3) {
                        IO.println("Saliendo...");
                    }
                    break;
                }

                case 3: {
                    IO.println("============ INVENTARIO CAFETERIA ============");
                    IO.println(" 1. Ingresar producto ");
                    IO.println(" 2. Buscar producto ");
                    IO.println(" 3. Mostrar inventario ");
                    IO.println(" 4. Salir ");
                    IO.println("==========================================");
                    IO.print("Elige una opcion (1-4): ");
                    int opcionInventario = sc.nextInt();
                    sc.nextLine();

                    if (opcionInventario == 1) {
                        IO.print("Ingresa el id del producto: ");
                        String id = sc.nextLine();
                        IO.print("Ingresa la cantidad del producto: ");
                        int cantidad = sc.nextInt();
                        sc.nextLine();
                        inventario.put(id, cantidad);
                    } else if (opcionInventario == 2) {
                        IO.print("ID del producto: ");
                        String idProducto = sc.nextLine();
                        IO.println("Cantidad: " + inventario.getV(idProducto));
                    } else if (opcionInventario == 3) {
                        inventario.showTable();
                    } else if (opcionInventario == 4) {
                        IO.println("Saliendo...");
                    }
                    break;
                }

                case 4:
                    IO.println("Saliendo del programa...");
                    break;

                default:
                    IO.println("Opcion no valida");
                    break;
            }
        }
        sc.close();
    }
}
*/