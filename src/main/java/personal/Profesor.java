package personal;

import school.Materia;

import java.util.ArrayList;

public class Profesor extends person {
    private String cedula;
    private String titulo;
    private int canReportes;
    private final ArrayList<Materia> materias;
    private final ArrayList<String> reportes;
    private final ArrayList<String> grupos;

    public Profesor(String name, String lastName, String email, String password, Roles role, String cedula, String titulo) {
        super(name, lastName, email, password, role);
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCanReportes() {
        return canReportes;
    }

    public void setCanReportes(int canReportes) {
        this.canReportes = canReportes;
    }

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