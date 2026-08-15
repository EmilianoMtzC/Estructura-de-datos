package Clases.Clase2.ListasEnlazadas.Ejercicios;

public class Alumno {

    //Atributos
    public String nombre;
    public String telefono;
    public String matricula;
    public String correo;

    //Constructor
    public Alumnos(String nombre, String telefono, String matricula, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.matricula = matricula;
        this.correo = correo;
    }

    // Getters
    public String getNombre() {return nombre;}
    public String getTelefono() {return telefono;}
    public String getMatricula() {return matricula;}
    public String getCorreo() {return correo;}

    @Override
    public String toString() {
        return "Alumno: " + nombre + " | Telefono " + telefono + " | Matricula " + matricula + " | Correo " + correo;
    }

}


