package Clases.Actividad1;
import java.util.Scanner;
import java.util.Objects;

/**
 * Representa un contacto que puede almacenarse dentro de una lista enlazada.
 * Cada contacto contiene nombre, direccion y numero de telefono.
 */
public class Contacto {

    // Datos del contacto
    String nombre;
    String direccion;
    String telefono;

    /**
     * Crea un contacto con todos sus datos.
     *
     * @param nombre nombre del contacto
     * @param direccion direccion del contacto
     * @param telefono numero de telefono del contacto
     */
    public Contacto(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    /**
     * Crea un contacto sin direccion.
     *
     * @param nombre nombre del contacto
     * @param telefono numero de telefono del contacto
     */
    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.direccion = null;
        this.telefono = telefono;
    }

    // Metodos get para consultar los datos del contacto
    public String getNombre() {
        return nombre;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getDireccion() {
        return direccion;
    }


    // Metodos set para modificar los datos del contacto
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    /**
     * Solicita al usuario los datos y los asigna al contacto actual.
     *
     * @param nombre parametro conservado para identificar el dato solicitado
     * @param telefono parametro conservado para identificar el dato solicitado
     */
    public void newContacto(String nombre, String telefono) {
        Scanner sc = new Scanner(System.in);
        IO.println("Ingrese los datos del nuevo contacto: ");
        IO.print("Nombre: ");
        this.nombre = sc.nextLine();
        IO.print("Quieres aniadir direccion: ");
        int opcion = sc.nextInt();
        if (opcion == 1) {
            IO.print("Direccion: ");
            this.direccion = sc.nextLine();
        } else {return;}

        IO.print("Telefono: ");
        this.telefono = sc.nextLine();

    }

    /**
     * Devuelve todos los datos del contacto en forma de String.
     *
     * @return representacion en String del contacto
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre +
                ", Direccion: " + direccion +
                ", Telefono: " + telefono;
    }

    /**
     * Compara contactos utilizando el nombre y el telefono.
     * La direccion no se utiliza porque es un dato opcional.
     *
     * @param obj objeto que se comparara con el contacto
     * @return true si ambos contactos tienen el mismo nombre y telefono
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Contacto)) {
            return false;
        }

        Contacto otro = (Contacto) obj;

        return Objects.equals(nombre, otro.nombre)
                && Objects.equals(telefono, otro.telefono);
    }

    /**
     * Genera el codigo hash con los mismos datos utilizados en equals.
     *
     * @return codigo hash del contacto
     */
    @Override
    public int hashCode() {
        return Objects.hash(nombre, telefono);
    }

}
