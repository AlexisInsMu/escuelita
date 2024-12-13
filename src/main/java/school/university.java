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

    //Constructor
    public university() {
        this.alumnos = new ArrayList<Alumno>();
        this.profesores = new ArrayList<Profesor>();
        this.materias = new ArrayList<String>();
        this.grupos = new ArrayList<Grupo>();
    }

    //Agregar un alumno
    public void addAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    //Agregar un profesor
    public void addProfesor(Profesor profesor) {
        profesores.add(profesor);
    }

    //Agrega una materia a un grupo.
    public void addMateria(Materia materia, Grupo grupo) {
        
        if(grupos.contains(grupo)){
            if(grupo.getMaterias().contains(materia)) {
                System.out.println("Materia already exists");
            }else{
                grupo.addMateria(materia);
            }
        }else{
            //Si el grupo no existe, lo crea y luego agrega la materia.
            grupos.add(grupo);
            if(grupo.getMaterias().contains(materia)) {
                System.out.println("Materia already exists");
            }else{
                grupo.addMateria(materia);
            }
        }
        //Evita duplicados tanto en grupos como en materias.
        if (materias.contains(materia.getNombre())) {
            System.out.println("Subject already exists");
        }else{
            materias.add(materia.getNombre());
        }
    }

    //Agrega un grupo
    public void addGrupo(Grupo grupo) {
        if(grupos.contains(grupo)){
            System.out.println("Group already exists");
        }else{
            grupos.add(grupo);
        }
    }

    //Se obtiene un alumno
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    //Se agrega un reporte al profesor.
    //Va a recibir el objeto Profesor al cual se le asigna el reporte y
    //el texto del reporte. 
    public void addReporte(Profesor profesor, String reporte){
        reportes.put(profesor, reporte);
    }

    //Buscamos un grupo por su nombre.
    public Grupo buscarGrupoPorNombre(String nombre) {
        for (Grupo grupo : grupos) {
            if (grupo.getNombre().equalsIgnoreCase(nombre)) {
                return grupo;
            }
        }
        return null; // Retorna null si no se encuentra el grupo
    }

    //Se obtiene un profesor.
    public List<Profesor> getProfesores() {
        return profesores;
    }

    //Se obtiene la lista de las materias
    public List<String> getMaterias() {
        return materias;
    }

    //Se obtiene la lista de grupos registrados.
    public List<Grupo> getGrupos() {
        return grupos;
    }

    //Buscamos un profesor en la lista por su cedula.
    public Profesor buscarProfesorPorCedula(String cedula) {
        for (Profesor profesor : profesores) {
            if (profesor.getCedula().equalsIgnoreCase(cedula)) {
                return profesor;
            }
        }
        return null; // Retorna null si no se encuentra el profesor
    }

    //Método principal que muestra un caso prueba.
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


    //Buscamos un alumno en la lista por su Matricula.
    public Alumno buscarAlumnoPorMatricula(String matriculaAlumno) {
        for(var x : alumnos){
            if(x.getMatricula().equalsIgnoreCase(matriculaAlumno)){
                return x;
            }
        }
        return null;
    }

    //Se obtiene el numero máximo de capacidad de alumnos.
    public int getAlumnosMax() {
        return capacidadAlumnos;
    }

    public String imprimirProfesores() {
        StringBuilder profe = new StringBuilder();
        for(var x :  profesores){
            profe.append(x.getName()).append(" ").append(x.getLastName()).append("\n");
        }
        return profe.toString();
    }
    public String imprimirAlumnos() {
        StringBuilder alumn = new StringBuilder();
        for(var x :  alumnos){
            alumn.append(x.getName()).append(" ").append(x.getLastName()).append("\n");
        }
        return alumn.toString();
    }
    public String imprimirMaterias() {
        StringBuilder mater = new StringBuilder();
        for(var x :  materias){
            mater.append(x).append("\n");
        }
        return mater.toString();
    }
    public String imprimirGrupos() {
        StringBuilder grup = new StringBuilder();
        for(var x :  grupos){
            grup.append(x.getNombre()).append("\n");
        }
        return grup.toString();
    }
}