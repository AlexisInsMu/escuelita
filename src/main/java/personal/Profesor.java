package personal;

public class Profesor extends person {
    private String cedula;
    private String titulo;
    private int canReportes;

    public Profesor(String name, String lastName, String email, String password, Roles role, String cedula, String titulo) {
        super(name, lastName, email, password, role);
        this.cedula = cedula;
        this.titulo = titulo;
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
    public  int getCanReportes(){
        return canReportes;
    }
    public void setCanReportes(int canReportes){
        this.canReportes = canReportes;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCedula: " + cedula + "\nTitulo: " + titulo;
    }
}


