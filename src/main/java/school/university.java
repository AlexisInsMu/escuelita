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
    private static int capacidadAlumnos = 2;


    public university() {
        this.alumnos = new ArrayList<Alumno>();
        this.profesores = new ArrayList<Profesor>();
        this.materias = new ArrayList<String>();
        this.grupos = new ArrayList<Grupo>();
    }

    public void addAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    public void addProfesor(Profesor profesor) {
        profesores.add(profesor);
    }

    public void addMateria(Materia materia, Grupo grupo) {
        if(grupos.contains(grupo)){
            if(grupo.getMaterias().contains(materia)) {
                System.out.println("Materia already exists");
            }else{
                grupo.addMateria(materia);
            }
        }else{
            grupos.add(grupo);
            if(grupo.getMaterias().contains(materia)) {
                System.out.println("Materia already exists");
            }else{
                grupo.addMateria(materia);
            }
        }
        if (materias.contains(materia.getNombre())) {
            System.out.println("Subject already exists");
        }else{
            materias.add(materia.getNombre());
        }
    }

    public void addGrupo(Grupo grupo) {
        if(grupos.contains(grupo)){
            System.out.println("Group already exists");
        }else{
            grupos.add(grupo);
        }
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }
    public void addReporte(Profesor profesor, String reporte){
        reportes.put(profesor, reporte);
    }
    public Grupo buscarGrupoPorNombre(String nombre) {
        for (Grupo grupo : grupos) {
            if (grupo.getNombre().equalsIgnoreCase(nombre)) {
                return grupo;
            }
        }
        return null; // Retorna null si no se encuentra el grupo
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


    public Profesor buscarProfesorPorCedula(String cedula) {
        for (Profesor profesor : profesores) {
            if (profesor.getCedula().equalsIgnoreCase(cedula)) {
                return profesor;
            }
        }
        return null; // Retorna null si no se encuentra el profesor
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
        //uni.addMateria(materia1);
        uni.addGrupo(grupo1);

        System.out.println("University Management System Initialized");
    }

    public Alumno buscarAlumnoPorMatricula(String matriculaAlumno) {
        for(var x : alumnos){
            if(x.getMatricula().equalsIgnoreCase(matriculaAlumno)){
                return x;
            }
        }
        return null;
    }

    public int getAlumnosMax() {
        return capacidadAlumnos;
    }
}