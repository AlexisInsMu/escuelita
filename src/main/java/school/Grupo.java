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

    public String imprimirMaterias(){
        StringBuilder materias = new StringBuilder();
        for (Materia materia : this.materias) {
            materias.append(materia.getNombre()).append(", ");
        }
        return materias.toString();
    }
    @Override
    public String toString() {
        return "Grupo: " + nombre + "\nMaterias: " + materias;
    }


    public Materia buscarMateriaPorNombre(String nombre) {
        for (Materia materia : materias) {
            if (materia.getNombre().equalsIgnoreCase(nombre)) {
                return materia;
            }
        }
        return null; // Returns null if the subject is not found
    }
}