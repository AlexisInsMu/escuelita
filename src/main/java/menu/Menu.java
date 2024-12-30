package menu;

import java.util.Scanner;

import personal.Alumno;
import personal.Profesor;
import personal.Roles;
import school.university;
import school.Grupo;
import school.Materia;
import utils.TerminalUtils;

public class Menu {

    public Menu() {
    }

    public static void menu_admin(Scanner scanner, university uni, Profesor profesor_vacio) {
        while (true) {
            TerminalUtils.clearTerminal();
            System.out.println("----Menu ADMIN----");
            System.out.println("Selecciona una de las opciones siguientes");
            System.out.println("1-. Crear un profesor");
            System.out.println("2-. Crear un grupo");
            System.out.println("3-. Inscribir un alumno");
            System.out.println("4-. Crear una materia");
            System.out.println("5-. Ver listado de profesores");
            System.out.println("6-. Ver listado de alumnos");
            System.out.println("7-. Ver listado de grupos");
            System.out.println("8-. Ver listado de materias");
            System.out.println("9-. Salir del menu");
            int op2 = scanner.nextInt();
            scanner.nextLine(); // Consume the leftover newline
            switch (op2) {
                case 1:
                    crear_profesor(scanner, uni, new Materia(), 0);
                    break;

                case 2:
                    crear_grupo(scanner, uni, profesor_vacio);
                    break;

                case 3:
                    crear_alumno(scanner, uni);
                    break;

                case 4:
                    crear_materia(scanner, uni);
                    break;


                case 5:
                    TerminalUtils.clearTerminal();
                    System.out.println("----Listado de profesores----");
                    System.out.println(uni.imprimirProfesores());
                    break;

                case 6:
                    TerminalUtils.clearTerminal();
                    System.out.println("----Listado de alumnos----");
                    System.out.println(uni.imprimirAlumnos());
                    break;

                case 7:
                    TerminalUtils.clearTerminal();
                    System.out.println("----Listado de grupos----");
                    System.out.println(uni.imprimirGrupos());
                    break;

                case 8:
                    TerminalUtils.clearTerminal();
                    System.out.println("----Listado de materias----");
                    System.out.println(uni.imprimirMaterias());
                    break;
                case 9:
                    System.out.println("Saliendo del menu");
                    return; // Exit the loop

                default:
                    throw new AssertionError();
            }
        }

    }

    private static void crear_materia(Scanner scanner, university uni) {
        try {
            TerminalUtils.clearTerminal();
            System.out.println("Nombre de la materia:  ");
            String materia = scanner.nextLine();

            System.out.println("Dame el grupo al que pertenece la materia: ");
            String grupo = scanner.nextLine();


            if (uni.buscarGrupoPorNombre(grupo) != null) {
                if (uni.buscarGrupoPorNombre(grupo).buscarMateriaPorNombre(materia) != null) {
                    System.out.println("Materia ya existe");
                    return;
                }
            }
            Profesor profesor_vacio = new Profesor();
            Materia materia1 = new Materia(materia, profesor_vacio, new Grupo());
            uni.addMateria(materia1, uni.buscarGrupoPorNombre(grupo));
            Profesor profesor = crear_profesor(scanner, uni, materia1, 1);
            if (profesor == null) {
                System.out.println("Profesor no se pudo asignar");
            }
        } catch (Exception e) {
            System.err.println("Ocurrió un error al procesar los datos del alumno: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void crear_alumno(Scanner scanner, university uni) {
        try {
            TerminalUtils.clearTerminal();
            if (!uni.getAlumnos().isEmpty() && Alumno.getContador() == uni.getAlumnosMax()) {
                System.out.println("No se pueden agregar más alumnos");
                return;
            }
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

            if (uni.getGrupos().isEmpty()) {
                System.out.println("No hay grupos creados");
            } else if (uni.buscarGrupoPorNombre(grupo) != null) {
                if (uni.buscarGrupoPorNombre(grupo).buscarMateriaPorNombre(materia) != null) {
                    if (!uni.getAlumnos().isEmpty() && uni.buscarAlumnoPorMatricula(matricula_alumno) != null) {
                        System.out.println("Alumno ya estaba inscrito");
                        return;
                    }
                    System.out.println("Agregando alumno a la materia");
                    Alumno alumno = new Alumno(nombre_alumno, apellido_alumno, email_alumno, pass_alumno, Roles.ESTUDIANTE, matricula_alumno);
                    uni.buscarGrupoPorNombre(grupo).buscarMateriaPorNombre(materia).inscribirAlumno(alumno, "0");
                    uni.addAlumno(alumno);
                } else {
                    System.out.println("Materia no encontrada");
                }
            } else {
                System.out.println("Grupo encontrado");
            }
        } catch (Exception e) {
            System.err.println("Ocurrió un error al procesar los datos del alumno: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void crear_grupo(Scanner scanner, university uni, Profesor profesorVacio) {
        try {
            TerminalUtils.clearTerminal();
            System.out.println("Nombre del grupo: ");
            String nombre_grupo = scanner.nextLine();
            if (uni.buscarGrupoPorNombre(nombre_grupo) != null) {
                System.out.println("Grupo ya existe");
                return;
            }
            Grupo grupo = new Grupo(nombre_grupo);
            uni.addGrupo(grupo);

            System.out.println("¿Cuántas materias deseas agregar a ese grupo?: ");
            int cantSubjetcs = scanner.nextInt();
            scanner.nextLine(); // Consume the leftover newline
            if (cantSubjetcs > 0) {
                System.out.println("Ingresa sus nombres de cada una:");
                for (int i = 0; i < cantSubjetcs; i++) {
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
                crear_profesor(scanner, uni, x, 1);
            }
            System.out.println("¿Quiere ver el listado de todo? y/n");
            char ver = scanner.next().charAt(0);
            if (ver == 'y') {
                for (var x : grupo.getMaterias()) {
                    System.out.println(x.getNombre());
                }
            }
        } catch (Exception e) {
            System.err.println("Ocurrió un error al procesar los datos del grupo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static Profesor crear_profesor(Scanner scanner, university uni, Materia materi, int control) {
        try {
            TerminalUtils.clearTerminal();
            String materia;
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


            if (control == 1) {
                System.out.println("Agregando profesor a la materia");
                Profesor profesor;
                if (uni.buscarProfesorPorCedula(cedula_profe) != null) {
                    profesor = uni.buscarProfesorPorCedula(cedula_profe);
                    profesor.addMateria(materi);
                    materi.setProfesor(profesor);
                    return null;
                } else {
                    profesor = new Profesor(nombre_profe, apellido_profe, email_profe, pass_profe, Roles.PROFESOR, cedula_profe, titulo_profe);
                    profesor.addMateria(materi);
                    materi.setProfesor(profesor);
                    uni.addProfesor(profesor);

                }

            } else {
                System.out.println("Dame el grupo al que pertenece el profesor: ");
                String grupo = scanner.nextLine();
                System.out.println("Dame el nombre de la materia: ");
                materia = scanner.nextLine();

                if (uni.getGrupos().isEmpty()) {
                    System.out.println("No hay grupos creados");
                } else if (uni.buscarGrupoPorNombre(grupo) != null) {
                    if (uni.buscarGrupoPorNombre(grupo).buscarMateriaPorNombre(materia) != null) {
                        if (uni.buscarGrupoPorNombre(grupo).buscarMateriaPorNombre(materia).getProfesor().getName().equals(nombre_profe)) {
                            System.out.println("Profesor ya existe");
                            return null;
                        }
                        System.out.println("Agregando profesor a la materia");
                        Profesor profesor = new Profesor(nombre_profe, apellido_profe, email_profe, pass_profe, Roles.PROFESOR, cedula_profe, titulo_profe);
                        uni.buscarGrupoPorNombre(grupo).buscarMateriaPorNombre(materia).setProfesor(profesor);
                        uni.addProfesor(profesor);
                        return profesor;
                    } else {
                        System.out.println("Materia no encontrada");
                    }
                } else {
                    System.out.println("Grupo no encontrado");
                }

            }

        } catch (Exception e) {
            System.err.println("Ocurrió un error al procesar los datos del profesor: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        university uni = new university();
        Profesor profesor_vacio = new Profesor("", "", "", "", Roles.PROFESOR, "", "");

        while (true) {
            TerminalUtils.clearTerminal();
            System.out.println("-----Menu Principal-----");
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
                    menu_alumno(scanner, uni);
                    break;

                case 3:
                    menu_profesor(scanner, uni);
                    break;

                case 4:
                    return; // Exit the loop
                default:
                    throw new AssertionError();
            }

        }
    }

    private static void menu_profesor(Scanner scanner, university uni) {
        TerminalUtils.clearTerminal();
        while (true) {
            TerminalUtils.clearTerminal();
            System.out.println("----Menu PROFESOR----");
            System.out.println("Selecciona una de las opciones siguientes");
            System.out.println("1-. Ver materias");
            System.out.println("2-. Ver alumnos");
            System.out.println("3-. Ver grupos");
            System.out.println("4-. Salir del menu");
            int op2 = scanner.nextInt();
            scanner.nextLine(); // Consume the leftover newline
            switch (op2) {
                case 1:
                    TerminalUtils.clearTerminal();
                    System.out.println("Dame la cedula del profesor: ");
                    String cedula = scanner.nextLine();
                    if (uni.buscarProfesorPorCedula(cedula) != null) {
                        System.out.println(uni.buscarProfesorPorCedula(cedula).imprimirMaterias());
                    } else {
                        System.out.println("Profesor no encontrado");
                    }
                    break;

                case 2:
                    TerminalUtils.clearTerminal();
                    System.out.println("Dame la cedula del profesor: ");
                    String cedula2 = scanner.nextLine();
                    if (uni.buscarProfesorPorCedula(cedula2) != null) {
                        System.out.println(uni.buscarProfesorPorCedula(cedula2).imprimirAlumnos());
                    } else {
                        System.out.println("Profesor no encontrado");
                    }
                    break;

                case 3:
                    TerminalUtils.clearTerminal();
                    System.out.println("Dame la cedula del profesor: ");
                    String cedula3 = scanner.nextLine();
                    if (uni.buscarProfesorPorCedula(cedula3) != null) {
                        System.out.println(uni.buscarProfesorPorCedula(cedula3).imprimirGrupos());
                    } else {
                        System.out.println("Profesor no encontrado");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del menu");
                    return; // Exit the loop

                default:
                    throw new AssertionError();
            }
        }

    }

    private static void menu_alumno(Scanner scanner, university uni) {
        while (true) {
            TerminalUtils.clearTerminal();
            System.out.println("----Menu ALUMNO----");
            System.out.println("Selecciona una de las opciones siguientes");
            System.out.println("1-. Ver materias inscritas");
            System.out.println("2-. Ver calificaciones");
            System.out.println("3-. Salir del menu");
            int op2 = scanner.nextInt();
            scanner.nextLine(); // Consume the leftover newline
            switch (op2) {
                case 1:
                    TerminalUtils.clearTerminal();
                    System.out.println("Dame la matricula del alumno: ");
                    String matricula = scanner.nextLine();
                    if (uni.buscarAlumnoPorMatricula(matricula) != null) {
                        System.out.println(uni.buscarAlumnoPorMatricula(matricula).imprimirMaterias());
                    } else {
                        System.out.println("Alumno no encontrado");
                    }
                    break;

                case 2:
                    TerminalUtils.clearTerminal();
                    System.out.println("Dame la matricula del alumno: ");
                    String matricula2 = scanner.nextLine();
                    if (uni.buscarAlumnoPorMatricula(matricula2) != null) {
                        System.out.println(uni.buscarAlumnoPorMatricula(matricula2).imprimirCalificaciones());
                    } else {
                        System.out.println("Alumno no encontrado");
                    }
                    break;

                case 3:
                    TerminalUtils.clearTerminal();
                    System.out.println("Saliendo del menu");
                    return; // Exit the loop

                default:
                    throw new AssertionError();
            }
        }
    }
}