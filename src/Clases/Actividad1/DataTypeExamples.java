package Clases.Actividad1;


/**
 * Contiene ejemplos del uso de diferentes tipos de datos
 * dentro de las listas enlazadas genericas.
 */
public class DataTypeExamples {

    /**
     * Demuestra el uso de datos enteros en una lista simple.
     * Integer es la clase envolvente que permite utilizar valores int
     * dentro de una estructura generica.
     */
    public void intExample() {
        LinkedList<Integer> list = new LinkedList<>(1);

        list.createData(10);
        list.createData(20);
        list.createData(30);

        IO.println("Ejemplo integer: ");
        list.readData();
    }

    /**
     * Demuestra el uso de Strings de texto en una lista doblemente enlazada.
     */
    public void stringExample() {
        LinkedList<String> list = new LinkedList<>(2);
        list.createData("Hola");
        list.createData("Mundo");
        list.createData("Adios");

        IO.println("Ejemplo string: ");
        list.readData();
    }

    /**
     * Demuestra el uso de objetos Contacto en una lista circular.
     * Contacto representa un tipo de dato complejo creado por el usuario.
     */
    public void abstractExample() {
        LinkedList<Contacto> list = new LinkedList<>(3);
        list.createData(new Contacto("Juan", "123456789"));
        list.createData(new Contacto("Pedro", "987654321"));
        list.createData(new Contacto("Maria", "098765432"));

        IO.println("Ejemplo abstract: ");
        list.readData();
    }
    
}
