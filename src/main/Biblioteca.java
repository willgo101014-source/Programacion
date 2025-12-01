package main;

import socios.Socio;
import socios.Bibliotecarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        List<Socio> listaSocios = new ArrayList<>();
        List<Bibliotecarios> listaBiblio = new ArrayList<>();
        String opcion;

        do {
            System.out.println("MENÚ BIBLIOTECA");
            System.out.println("0. Introducir datos de socios/bibliotecarios");
            System.out.println("1. Visualizar todos los socios");
            System.out.println("2. Visualizar únicamente bibliotecarios");
            System.out.println("3. Visualizar bibliotecarios de una sección");
            System.out.println("4. Buscar por nombre");
            System.out.println("5. Mostrar socios por cuota");
            System.out.println("6. Mostrar bibliotecarios por años");
            System.out.println("7. Dar de baja");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextLine();

            switch (opcion) {
                case "0":
                    System.out.print("DNI: ");
                    String dni = teclado.nextLine();
                    System.out.print("Nombre completo: ");
                    String nombre = teclado.nextLine();
                    System.out.print("Mes de alta: ");
                    int mes = Integer.parseInt(teclado.nextLine());
                    System.out.print("Año de alta: ");
                    int anio = Integer.parseInt(teclado.nextLine());
                    System.out.print("Límite de libros: ");
                    int limite = Integer.parseInt(teclado.nextLine());
                    System.out.print("¿Es bibliotecario? (S/N): ");
                    String esB = teclado.nextLine().toUpperCase();

                    boolean existe = false;
                    for (Socio s : listaSocios) if (s.getDni().equals(dni)) existe = true;

                    if (existe) System.out.println("Error: Ya existe un socio con ese DNI.");
                    else {
                        Socio s = new Socio(dni, nombre, mes, anio, limite);
                        listaSocios.add(s);
                        if (esB.equals("S")) {
                            System.out.print("Sección: ");
                            String sec = teclado.nextLine();
                            listaBiblio.add(new Bibliotecarios(s, sec));
                        }
                        System.out.println("Datos agregados correctamente.");
                    }
                    break;

                case "1":
                    for (Socio s : listaSocios) {
                        boolean esBiblio = false;
                        for (Bibliotecarios b : listaBiblio) {
                            if (b.getSocio().getDni().equals(s.getDni())) {
                                b.mostrarInfo();
                                esBiblio = true;
                                break;
                            }
                        }
                        if (!esBiblio) s.mostrarInfo();
                    }
                    break;

                case "2":
                    if (listaBiblio.isEmpty()) System.out.println("No hay bibliotecarios.");
                    else for (Bibliotecarios b : listaBiblio) b.mostrarInfo();
                    break;

                case "3":
                    System.out.print("Ingrese la sección: ");
                    String secBuscar = teclado.nextLine();
                    boolean encontrado = false;
                    for (Bibliotecarios b : listaBiblio) {
                        if (b.getSeccion().equalsIgnoreCase(secBuscar)) {
                            System.out.println(b.getSocio().getNombreCompleto());
                            encontrado = true;
                        }
                    }
                    if (!encontrado) System.out.println("No hay bibliotecarios en esa sección.");
                    break;

             

                case "5":
                    System.out.print("Ingrese cuota mínima: ");
                    double cuotaMin = Double.parseDouble(teclado.nextLine());
                    boolean encontradoC = false;
                    for (Socio s : listaSocios) {
                        double cuota = s.calcularCuota();
                        for (Bibliotecarios b : listaBiblio)
                            if (b.getSocio().getDni().equals(s.getDni())) cuota = b.calcularCuotaFinal();
                        boolean esB1 = false;
                        for (Bibliotecarios b : listaBiblio) if (b.getSocio().getDni().equals(s.getDni())) esB1 = true;
                        if (cuota >= cuotaMin) {
                            System.out.println(s.getNombreCompleto() + " - Cuota: " + cuota + "€, Bibliotecario: " + (esB1 ? "Sí" : "No"));
                            encontradoC = true;
                        }
                    }
                    if (!encontradoC) System.out.println("No se encontraron socios con esa cuota.");
                    break;

                case "6":
                    System.out.print("Ingrese años mínimos ");
                    int aniosMin = Integer.parseInt(teclado.nextLine());
                    boolean encontradoA = false;
                    for (Bibliotecarios b : listaBiblio) {
                        if (b.getSocio().aniosEnBiblioteca() >= aniosMin) {
                            System.out.println(b.getSocio().getNombreCompleto() + "  Años" + b.getSocio().aniosEnBiblioteca());
                            encontradoA = true;
                        }
                    }
                    if (!encontradoA) System.out.println("No hay bibliotecarios");
                    break;

                case "8":
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }

            System.out.println();
        } while (!opcion.equals("8"));

        teclado.close();
    }
}
