package Actividades.Actividad4;

/** Representa un proceso dentro del sistema operativo simulado. */
public class Proceso {
    private final int id;
    private final String name;

    public Proceso(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Proceso " + id + ": " + name;
    }
}
