package personal;

import school.Materia;

import java.util.HashMap;
import java.util.Map;

public class Alumno extends person {
    private String matricula;
    private Map<Materia, String> materiasCalificaciones;
    private static int contador = 0;

    public Alumno(String name, String lastName, String email, String password, Roles role, String matricula) {
        super(name, lastName, email, password, role);
        this.matricula = matricula;
        this.materiasCalificaciones = new HashMap<>();
        contador++; // Incrementar el contador cada vez que se crea un nuevo alumno
    }

    public static int getContador() {
        return contador; // Métudo estático para obtener el valor del contador
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void inscribirMateria(Materia materia, String calificacion) {
        materiasCalificaciones.put(materia, calificacion);
    }

    public Map<Materia, String> getMateriasCalificaciones() {
        return materiasCalificaciones;
    }

    public String imprimirCalificaciones(){
        String calificaciones = "";
        for (Map.Entry<Materia, String> entry : materiasCalificaciones.entrySet()) {
            Materia materia = entry.getKey();
            String calificacion = entry.getValue();
            calificaciones += "Materia: " + materia.getNombre() + " Calificacion: " + calificacion + "\n";
        }
        return calificaciones;
    }
    public String imprimirMaterias(){
        String materias = "";
        for (Map.Entry<Materia, String> entry : materiasCalificaciones.entrySet()) {
            Materia materia = entry.getKey();
            materias += "Materia: " + materia.getNombre() + " Grupo: " + materia.getGrupo() + "\n";
        }
        return materias;
    }


    @Override
    public String toString() {
        return super.toString() + "\nMatricula: " + matricula + "\nMaterias: " + materiasCalificaciones;
    }
}