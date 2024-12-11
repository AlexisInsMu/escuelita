package menu;
import java.util.Scanner;

import personal.Profesor;
import personal.Roles;
import school.university;
import school.Grupo;
import school.Materia;
import personal.Roles;

public class Menu {

    public Menu() {
    }
    public static void menu_admin(Scanner scanner, university uni, Profesor profesor_vacio){
        System.out.println("----Menu ADMIN----");
        System.out.println("Selecciona una de las opciones siguientes");
        while(true){
            System.out.println("1-. Crear un profesor");
            System.out.println("2-. Crear un grupo");
            System.out.println("3-. Crear un alumno");
            System.out.println("4-. Crear una materia");
            System.out.println("5-. Salir del menu");
            int op2 = scanner.nextInt();
            scanner.nextLine(); // Consume the leftover newline
            switch (op2) {
                case 1:
                    crear_profesor(scanner, uni);
                    break;

                case 2:
                    crear_grupo(scanner, uni, profesor_vacio);
                    break;

                case 3:
                   crear_alumno(scanner, uni);
                    break;

                case 4:
                    // Add case 4 logic here
                    break;

                case 5:
                    System.out.println("Saliendo del menu");
                    return; // Exit the loop

                default:
                    throw new AssertionError();
            }
        }

    }

    private static void crear_alumno(Scanner scanner, university uni) {
        try {
            System.out.println("Nombre del alumno: ");
            String nombre_alumno = scanner.nextLine();

            System.out.println("Apellido del alumno: ");
            String apellido_alumno = scanner.nextLine();

            System.out.println("Email del alumno: ");
            String email_alumno = scanner.nextLine();

            System.out.println("Password del alumno: ");
            String pass_alumno = scanner.nextLine();

            System.out.println("Matricula del alumno: ");
            String matricula_alumno = scanner.nextLine();

            System.out.println("Dame el grupo al que pertenece el alumno: ");
            String grupo = scanner.nextLine();

            System.out.println("Dame el nombre de la materia: ");
            String materia = scanner.nextLine();

            if(uni.getGrupos().isEmpty()){
                System.out.println("No hay grupos creados");
            }else if(uni.buscarGrupoPorNombre(grupo) != null){
                if(uni.buscarGrupoPorNombre(grupo).buscarMateriaPorNombre(materia) != null) {
                    System.out.println("Agregando alumno a la materia");
                    uni.buscarGrupoPorNombre(grupo).buscarMateriaPorNombre(materia).inscribirAlumno(nombre_alumno, apellido_alumno, email_alumno, pass_alumno, Roles.ALUMNO, matricula_alumno);
                }else {
                    System.out.println("Materia no encontrada");
                }
            }else{
                System.out.println("Grupo encontrado");
            }
        } catch (Exception e) {
            System.err.println("Ocurrió un error al procesar los datos del alumno: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void crear_grupo(Scanner scanner, university uni, Profesor profesorVacio) {
        try {
            System.out.println("Nombre del grupo: ");
            String nombre_grupo = scanner.nextLine();
            if(uni.buscarGrupoPorNombre(nombre_grupo) != null){
                System.out.println("Grupo ya existe");
                return;
            }
            Grupo grupo = new Grupo(nombre_grupo);
                uni.addGrupo(grupo);

            System.out.println("¿Cuántas materias deseas agregar a ese grupo?: ");
            int cantSubjetcs = scanner.nextInt();
            scanner.nextLine(); // Consume the leftover newline
            if(cantSubjetcs> 0){
                System.out.println("Ingresa sus nombres de cada una:");
                for (int i = 0; i < cantSubjetcs; i++){
                    System.out.println("Materia" + (i + 1));
                    String subject = scanner.nextLine();
                    Materia materia = new Materia(subject, profesorVacio, grupo);
                    grupo.addMateria(materia);
                    uni.addMateria(materia, grupo);
                }
                System.out.println(grupo.imprimirMaterias());

            }

            System.out.println("Agrega los profesores a las materias agregadas");
            for (var x : grupo.getMaterias()) {
                crear_profesor(scanner, uni);
            }
            System.out.println("¿Quiere ver el listado de todo? y/n");
            char ver = scanner.next().charAt(0);
            if (ver == 'y')
            {
                for(var x :  grupo.getMaterias()){
                    System.out.println(x.getNombre());
                }
            }
        }catch (Exception e) {
            System.err.println("Ocurrió un error al procesar los datos del grupo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void crear_profesor(Scanner scanner, university uni) {
        try {
            System.out.println("Nombre del profesor: ");
            String nombre_profe = scanner.nextLine();

            System.out.println("Apellido del profesor: ");
            String apellido_profe = scanner.nextLine();

            System.out.println("Email del profesor: ");
            String email_profe = scanner.nextLine();

            System.out.println("Password del profesor: ");
            String pass_profe = scanner.nextLine();

            System.out.println("Cédula del profesor: ");
            String cedula_profe = scanner.nextLine();

            System.out.println("Título del profesor: ");
            String titulo_profe = scanner.nextLine();

            System.out.println("Dame el grupo al que pertenece el profesor: ");
            String grupo = scanner.nextLine();

            System.out.println("Dame el nombre de la materia: ");
            String materia = scanner.nextLine();

            if(uni.getGrupos().isEmpty()){
                System.out.println("No hay grupos creados");
            }else if(uni.buscarGrupoPorNombre(grupo) != null){
                if(uni.buscarGrupoPorNombre(grupo).buscarMateriaPorNombre(materia) != null) {
                    if(uni.buscarGrupoPorNombre(grupo).buscarMateriaPorNombre(materia).getProfesor().getName().equals(nombre_profe)){
                        System.out.println("Profesor ya existe");
                        return;
                    }
                    System.out.println("Agregando profesor a la materia");
                    Profesor profesor = new Profesor(nombre_profe, apellido_profe, email_profe, pass_profe, Roles.PROFESOR, cedula_profe, titulo_profe);
                    uni.buscarGrupoPorNombre(grupo).buscarMateriaPorNombre(materia).setProfesor(profesor);
                    uni.addProfesor(profesor);
                }else {
                    System.out.println("Materia no encontrada");
                }
            }else{
                System.out.println("Grupo encontrado");
            }
        } catch (Exception e) {
            System.err.println("Ocurrió un error al procesar los datos del profesor: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String []args) {

        System.out.println("1 Crea y selecciona un profesor:");
        System.out.println("2 Crea y selecciona un grupo:");
        System.out.println("3 Crea y selecciona un Alumno:");
        System.out.println("4 Crea y selecciona una materia:");
        System.out.println("Salir del menu secundario");
        String grupo = scanner.nextLine();
        Grupo grupito = new Grupo(grupo);
        uni.addGrupo(grupito);

        System.out.println("¿Cuántas materias deseas agregar a ese grupo?: ");
        int cantSubjetcs = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline
        System.out.println("Ingresa sus nombres de cada una:");
        for (int i = 0; i < cantSubjetcs; i++){
            System.out.println("Materia" + (i + 1));
            String subject = scanner.nextLine();
            Materia materia = new Materia(subject, profesor_vacio, grupito);
            grupito.addMateria(materia);
            uni.addMateria(materia, grupito);
        }
        System.out.println(grupito.imprimirMaterias());

        System.out.println("Agrega los profesores a las materias agregadas");
        for (var x : grupito.getMaterias()) {
            try {
                System.out.println("Materia: " + x.getNombre());

                System.out.println("Nombre del profesor: ");
                String nombre_profe = scanner.nextLine();

                System.out.println("Apellido del profesor: ");
                String apellido_profe = scanner.nextLine();

                System.out.println("Email del profesor: ");
                String email_profe = scanner.nextLine();

                System.out.println("Password del profesor: ");
                String pass_profe = scanner.nextLine();

                System.out.println("Cédula del profesor: ");
                String cedula_profe = scanner.nextLine();

                System.out.println("Título del profesor: ");
                String titulo_profe = scanner.nextLine();

                Profesor profesor = new Profesor(nombre_profe, apellido_profe, email_profe, pass_profe, Roles.PROFESOR, cedula_profe, titulo_profe);
                x.setProfesor(profesor);
            } catch (Exception e) {
                System.err.println("Ocurrió un error al procesar los datos del profesor: " + e.getMessage());
                e.printStackTrace();
            }
        }
        System.out.println("¿Quiere ver el listado de todo? y/n");
        char ver = scanner.next().charAt(0);
        if (ver == 'y')
        {
            for(var x :  grupito.getMaterias()){
                System.out.println(x.getNombre() + " " + x.getProfesor());
            }
        }
        Scanner scanner = new Scanner(System.in);
        university uni = new university();
        Profesor profesor_vacio = new Profesor("","","","", Roles.PROFESOR,"","");

        while(true){
            System.out.println("-----menu-----");
            System.out.println("1-. Adminsitrador");
            System.out.println("2-. Alumno");
            System.out.println("3-. Profesor");
            System.out.println("4-. Salir");
            int op1 = scanner.nextInt();
            scanner.nextLine(); // Consume the leftover newline
            switch (op1) {
                case 1:
                    menu_admin(scanner, uni, profesor_vacio);
                    break;

                case 2:
                    System.out.println("----Menu ALUMNO----");
                    System.out.println();
                    break;

                case 3:
                    // Add case 3 logic here
                    break;

                default:
                    throw new AssertionError();
            }

        }
    }
}