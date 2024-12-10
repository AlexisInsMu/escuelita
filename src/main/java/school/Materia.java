package school;

import personal.Alumno;
import personal.Profesor;

import java.util.HashMap;
import java.util.Map;

public class Materia {
    private String nombre;
    private final Map<Alumno, String> alumnosCalificaciones;
    private Profesor profesor;
    private Profesor profesor_aux =  null;
    private Grupo grupo;

    public Materia(String nombre, Profesor profesor, Grupo grupo) {
        this.nombre = nombre;
        this.alumnosCalificaciones = new HashMap<>();
        this.profesor = profesor;
        this.grupo = grupo;
    }

    public  boolean hayProfesor_auxiliar(){
        return profesor_aux != null;
    }

    public void setProfesor_auxiliar(Profesor profesor_aux){
        this.profesor_aux = profesor_aux;
    }

    public Profesor getProfesor_auxiliar(){
        return profesor_aux;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void inscribirAlumno(Alumno alumno, String calificacion) {
        alumnosCalificaciones.put(alumno, calificacion);
        alumno.inscribirMateria(this, calificacion);
    }

    public Map<Alumno, String> getAlumnosCalificaciones() {
        return alumnosCalificaciones;
    }

    @Override
    public String toString() {
        return nombre;
    }
}