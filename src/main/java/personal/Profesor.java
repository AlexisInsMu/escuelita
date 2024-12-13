package personal;

import school.Materia;

import java.util.ArrayList;

public class Profesor extends person {
    private String cedula;
    private String titulo;
    private int canReportes; //Cantidad de reportes que tiene el profe
    private final ArrayList<Materia> materias;
    private final ArrayList<String> reportes;
    private final ArrayList<String> grupos;

    //Constructor
    public Profesor(String name, String lastName, String email, String password, Roles role, String cedula, String titulo) {
        super(name, lastName, email, password, role); // Llamamos al constructor de la clase base person.
        this.cedula = cedula;
        this.titulo = titulo;
        this.materias = new ArrayList<>();
        this.reportes = new ArrayList<>();
        this.grupos = new ArrayList<>();
        this.canReportes = 0;
    }

    public Profesor() {
        super();
        reportes = new ArrayList<>();
        materias = new ArrayList<>();
        this.grupos = new ArrayList<>();
        canReportes = 0;
    }

    public void addMateria(Materia materia) {
        materias.add(materia);
        if(!this.grupos.contains(materia.getGrupo().getNombre())){
            this.grupos.add(materia.getGrupo().getNombre());
        }
    }

    public void removeMateria(Materia materia) {
        materias.remove(materia);
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public void addReporte(String reporte) {
        reportes.add(reporte);
        canReportes++;
    }

    public void removeReporte(String reporte) {
        reportes.remove(reporte);
        canReportes--;
    }

    public ArrayList<String> getReportes() {
        return reportes;
    }

    //Se obtiene la cedula del profesor
    public String getCedula() {
        return cedula;
    }

    //Se establece una cedula para un profesor
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    //Se obtiene el título del profesor
    public String getTitulo() {
        return titulo;
    }

    //Se establece un título para un profesor
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }



    //Se obtiene la cantidad de reportes que tiene un profesor
    public  int getCanReportes(){
        return canReportes;
    }


    //Se establece la cantidad de reportes que tiene un profesor
    public void setCanReportes(int canReportes){
        this.canReportes = canReportes;
    }

    //Imprime los datos de la clase person más los de esta clase.
    @Override
    public String toString() {
        return super.toString() + "\nCedula: " + cedula + "\nTitulo: " + titulo;
    }

    public String imprimirMaterias() {
        StringBuilder materias = new StringBuilder();
        for (Materia materia : this.materias) {
            materias.append(materia.getNombre()).append(", ");
        }
        return materias.toString();
    }

    public String imprimirAlumnos() {
        StringBuilder alumnos = new StringBuilder();
        for (Materia materia : this.materias) {
            alumnos.append("Materia: ").append(materia.getNombre()).append("\nAlumnos: ").append(materia.getAlumnosCalificaciones().keySet()).append("\n");
        }
        return alumnos.toString();
    }

    public String imprimirGrupos() {

        StringBuilder grupos = new StringBuilder();
        for (String grupo : this.grupos) {
            grupos.append(grupo).append(", ");
        }
        return grupos.toString();
    }
}