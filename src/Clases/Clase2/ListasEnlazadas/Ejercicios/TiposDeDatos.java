package Clases.Clase2.ListasEnlazadas.Ejercicios;

public class TiposDeDatos {
    void main() {
        IO.println("Tipos de datos");

        //Datos Primitivos
        ListaEnlazada<Integer> listaEnteros = new ListaEnlazada<>(1);
        listaEnteros.appendNode(1);
        listaEnteros.appendNode(2);
        listaEnteros.appendNode(3);
        listaEnteros.appendNode(4);
        listaEnteros.showList();

        // Tipo de datos complejos
        ListaEnlazada<String> ListaString = new ListaEnlazada<>(2);

        ListaString.appendNode("Hola");
        ListaString.appendNode("Como");
        ListaString.appendNode("Estas");
        ListaString.appendNode("??");
        ListaString.showList();

        //Lista abstractos
        ListaEnlazada<Alumnos> listaAbstractos = new ListaEnlazada<>(3);

        listaAbstractos.appendNode(new Alumnos("Juan", "123456789", "123456789", ""));
        listaAbstractos.appendNode(new Alumnos("Maria", "987654321", "987654321", ""));
        listaAbstractos.appendNode(new Alumnos("Pedro", "098765432", "098765432", ""));
        listaAbstractos.showList();

    }
}
