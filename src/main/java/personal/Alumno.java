package personal;

import school.Materia;

import java.util.HashMap;
import java.util.Map;

public class Alumno extends person {
    private String matricula;
    private Map<Materia, String> materiasCalificaciones;

    public Alumno(String name, String lastName, String email, String password, Roles role, String matricula) {
        super(name, lastName, email, password, role);
        this.matricula = matricula;
        this.materiasCalificaciones = new HashMap<>();
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

    @Override
    public String toString() {
        return super.toString() + "\nMatricula: " + matricula + "\nMaterias: " + materiasCalificaciones;
    }
}