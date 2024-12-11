package menu;
import java.util.Scanner;

import personal.Profesor;
import personal.Roles;
import school.university;
import school.Grupo;
import school.Materia;
import personal.Roles;

public class Menu {
    public static void main(String []args) {
        Scanner scanner = new Scanner (System.in);
        Menu menu = new Menu();
        university uni = new university();

        System.out.println("-----menu-----");
        System.out.println("1-. Adminsitrador");
        System.out.println("2-. Alumno");
        System.out.println("3-. Profesor");
        int op1 = scanner.nextInt();
        Profesor profesor_vacio = new Profesor("","","","", Roles.PROFESOR,"","");

        switch (op1) {
            case 1:
                System.out.println("----Menu ADMIN----");
                System.out.println("Crea y selecciona un grupo:");
                String grupo = scanner.nextLine();
                Grupo grupito = new Grupo(grupo);
                uni.addGrupo(grupito);

                System.out.println("¿Cuántas materias deseas agregar a ese grupo?: ");
                int cantSubjetcs = scanner.nextInt();
                System.out.println("Ingresa sus nombres de cada una:");
                for (int i = 0; i < cantSubjetcs; i++){
                    System.out.println("Materia" + i+1);
                    String subject = scanner.nextLine();
                    Materia materia = new Materia(subject, profesor_vacio, grupito);
                    grupito.addMateria(materia);
                    uni.addMateria(materia.getNombre(), grupito);
                }
                System.out.println(grupito.getMaterias());

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

                }
                
            case 2:
                
            case 3:
                
                break;
            default:
                throw new AssertionError();
        }
    }
}
