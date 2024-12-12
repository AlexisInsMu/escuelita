package personal;

public class Profesor extends person {
    private String cedula;
    private String titulo;
    private int canReportes; //Cantidad de reportes que tiene el profe.

    //Constructor
    public Profesor(String name, String lastName, String email, String password, Roles role, String cedula, String titulo) {
        super(name, lastName, email, password, role); // Llamamos al constructor de la clase base person.
        this.cedula = cedula;
        this.titulo = titulo;
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
}


