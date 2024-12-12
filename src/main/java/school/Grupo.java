package school;

import java.util.List;
import java.util.ArrayList;

public class Grupo {
    private String nombre;
    private List<Materia> materias;

    //Constructor: se creará con el nombre y una lista vacía de las materias de ese grupo.
    public Grupo(String nombre) {
        this.nombre = nombre;
        this.materias = new ArrayList<>();
    }

    public Grupo() {
        this.nombre =  "";
        this.materias = new ArrayList<>();
    }

    //Se obtiene el nombre del grupo
    public String getNombre() {
        return nombre;
    }

    //Se establece el nombre del grupo
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Se obtiene la lista de materias de ese grupo
    public List<Materia> getMaterias() {
        return materias;
    }

    //Se agrega un materia más a la lista
    public void addMateria(Materia materia) {
        this.materias.add(materia);
    }

    //Se elimina una materia de la lista
    public void removeMateria(Materia materia) {
        this.materias.remove(materia);
    }

    //Imprimer la lista de materias
    public String imprimirMaterias(){
        StringBuilder materias = new StringBuilder();
        for (Materia materia : this.materias) {
            materias.append(materia.getNombre()).append(", ");
        }
        return materias.toString();
    }

    //Imprime el nombre de grupo junto con su lista de materias
    @Override
    public String toString() {
        return "Grupo: " + nombre + "\nMaterias: " + materias;
    }

    //Busca una materia en la lista por su nombre
    public Materia buscarMateriaPorNombre(String nombre) {
        for (Materia materia : materias) {
            if (materia.getNombre().equalsIgnoreCase(nombre)) {
                return materia;
            }
        }
        return null; // Returns null if the subject is not found
    }
}