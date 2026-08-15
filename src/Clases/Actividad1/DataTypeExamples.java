package Clases.Actividad1;


public class DataTypeExamples {

    public void intExample() {
        LinkedList<Integer> list = new LinkedList<>(1);

        list.createData(10);
        list.createData(20);
        list.createData(30);

        IO.println("Ejemplo integer: ");
        list.readData();
    }

    public void stringExample() {
        LinkedList<String> list = new LinkedList<>(2);
        list.createData("Hola");
        list.createData("Mundo");
        list.createData("Adios");

        IO.println("Ejemplo string: ");
        list.readData();
    }

    public void abstractExample() {
        LinkedList<Contacto> list = new LinkedList<>(3);
        list.createData(new Contacto("Juan", "123456789"));
        list.createData(new Contacto("Pedro", "987654321"));
        list.createData(new Contacto("Maria", "098765432"));

        IO.println("Ejemplo abstract: ");
        list.readData();
    }
    
}
