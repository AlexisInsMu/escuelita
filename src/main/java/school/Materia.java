package school;

import personal.Alumno;
import personal.Profesor;

import java.util.HashMap;
import java.util.Map;

public class Materia {
    private String nombre;
    //relaciona a los alumnos inscritos con sus calificaciones
    private final Map<Alumno, String> alumnosCalificaciones;
    private Profesor profesor;
    private Profesor profesor_aux =  null;
    private Grupo grupo;

    //Constructor: Se crea ya con un nombre, un profesor asignado y un grupo asignados.

    public Materia(String nombre, Profesor profesor, Grupo grupo) {
        this.nombre = nombre;
        this.alumnosCalificaciones = new HashMap<>();
        this.profesor = profesor;
        this.grupo = grupo;
    }

    public Materia() {

        this.nombre = "";
        this.alumnosCalificaciones = new HashMap<>();
        this.profesor = new Profesor();
        this.grupo = new Grupo();
    }

    //Verificamos si hay un profesor auxiliar asignado a la materia
    public  boolean hayProfesor_auxiliar(){
        return profesor_aux != null;
    }

    //Asignamos un profesor auxiliar a la materia
    public void setProfesor_auxiliar(Profesor profesor_aux){
        this.profesor_aux = profesor_aux;
    }

    //Se obtiene el profesor auxiliar
    public Profesor getProfesor_auxiliar(){
        return profesor_aux;
    }

    //Se obtiene el profesor
    public Profesor getProfesor() {
        return profesor;
    }


    //Se obtiene el nombre de la materia
    public String getNombre() {
        return nombre;
    }

    //Se establce el nombre de la materia
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Se inscribe un alumno en la materia y registra su calificación inicial
    public void inscribirAlumno(Alumno alumno, String calificacion) {
        alumnosCalificaciones.put(alumno, calificacion);
        // Actualiza la lista de materias del alumno
        alumno.inscribirMateria(this, calificacion);
    }

    //Se obtiene la lista de alumnos inscritos junto con sus calificaciones
    public Map<Alumno, String> getAlumnosCalificaciones() {
        return alumnosCalificaciones;
    }

    //Imprime el nombre de la materia
    @Override
    public String toString() {
        return nombre;
    }

    //Se establece un profesor.
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Grupo getGrupo() {
        return grupo;
    }
    public void setGrupo(Grupo grupo){
        this.grupo = grupo;
    }
}