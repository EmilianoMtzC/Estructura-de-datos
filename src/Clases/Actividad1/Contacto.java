package Clases.Actividad1;
import java.util.Scanner;

public class Contacto {
    String nombre;
    String direccion;
    String telefono;

    public Contacto(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.direccion = null;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getDireccion() {
        return direccion;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


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

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                ", Direccion: " + direccion +
                ", Telefono: " + telefono;
    }
}
