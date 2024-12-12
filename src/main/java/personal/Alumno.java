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

    //Se obtiene el número de alumnos.
    public static int getContador() {
        return contador; // Método estático para obtener el valor del contador
    }

    //Se obtiene la matricula del alumno
    public String getMatricula() {
        return matricula;
    }

    //Se establace la matricula
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    //Inscribe una materia y registra su calificación inicial.
    public void inscribirMateria(Materia materia, String calificacion) {
        materiasCalificaciones.put(materia, calificacion); 
    }

    //Se obtiene la lista de materias inscritas junto con sus calificaciones.
    public Map<Materia, String> getMateriasCalificaciones() {
        return materiasCalificaciones;
    }

    //Imprime los datos del Alumno(datos de person), su matricula del alumno con la lista 
    //de las materias inscritas con sus calificaciones actuales en esa mataria.
    @Override
    public String toString() {
        return super.toString() + "\nMatricula: " + matricula + "\nMaterias: " + materiasCalificaciones;
    }
}