package school;

import java.util.List;
import java.util.ArrayList;

public class Grupo {
    private String nombre;
    private List<Materia> materias;

    public Grupo(String nombre) {
        this.nombre = nombre;
        this.materias = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void addMateria(Materia materia) {
        this.materias.add(materia);
    }

    public void removeMateria(Materia materia) {
        this.materias.remove(materia);
    }

    @Override
    public String toString() {
        return "Grupo: " + nombre + "\nMaterias: " + materias;
    }
}