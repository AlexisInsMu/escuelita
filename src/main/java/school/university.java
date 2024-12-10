package school;

import personal.Alumno;
import personal.Profesor;
import personal.Roles;
import personal.Roles.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class university {
    private final List<Alumno> alumnos;
    private final List<Profesor> profesores;
    private final List<String> materias;
    private final List<Grupo> grupos;
    private Map<Profesor, String> reportes;


    public university() {
        this.alumnos = new ArrayList<>();
        this.profesores = new ArrayList<>();
        this.materias = new ArrayList<>();
        this.grupos = new ArrayList<>();
    }

    public void addAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    public void addProfesor(Profesor profesor) {
        profesores.add(profesor);
    }

    public void addMateria(Materia materia) {
        //materias.add(materia.getNombre());
    }

    public void addGrupo(Grupo grupo) {
        grupos.add(grupo);
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public List<String> getMaterias() {
        return materias;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public static void main(String[] args) {
        university uni = new university();

        // Example usage
        Alumno alumno1 = new Alumno("John", "Doe", "john.doe@example.com", "password", Roles.ESTUDIANTE, "A001");
        Profesor profesor1 = new Profesor("Jane", "Smith", "jane.smith@example.com", "password", Roles.PROFESOR, "1234A", "PhD");
        Grupo grupo1 = new Grupo("Group A");
        //Materia materia1 = new Materia("Mathematics", profesor1, grupo1);

        uni.addAlumno(alumno1);
        uni.addProfesor(profesor1);
        uni.addMateria(materia1);
        uni.addGrupo(grupo1);

        System.out.println("University Management System Initialized");
    }
}