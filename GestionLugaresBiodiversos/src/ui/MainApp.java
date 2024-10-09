
package ui;

import model.LugarBiodiverso;
import model.Especie.java;
import model.Comunidad;
import model.LugarController;
import model.TipoEspecie;
import model.TipoComunidad;

import java.util.Scanner;


import java.util.Scanner;

/**
 * Clase principal que gestiona la interacción del usuario.
 */

public class MainApp {
    private static Scanner scanner = new Scanner(System.in);
    private static LugarController lugarController = new LugarController();

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            mostrarMenuPrincipal();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    agregarLugar();
                    break;
                case 2:
                    agregarEspecie();
                    break;
                case 3:
                    ingresarComunidad();
                    break;
                case 4:
                    lugarConMayorEspecies();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente nuevamente.");
            }
        }
        scanner.close();
    }

    public static void mostrarMenuPrincipal() {
        System.out.println("\n=== Menú Principal ===");
        System.out.println("1. Agregar Lugar Biodiverso");
        System.out.println("2. Agregar Especie a un Lugar");
        System.out.println("3. Ingresar Comunidad");
        System.out.println("4. Consultar Lugar con Mayor Cantidad de Especies");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void agregarLugar() {
        // Solicitar datos del lugar y agregar
        System.out.print("Nombre del lugar: ");
        String nombre = scanner.nextLine();
        System.out.print("Departamento: ");
        String departamento = scanner.nextLine();
        System.out.print("Área (km²): ");
        double area = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Foto: ");
        String foto = scanner.nextLine();
        System.out.print("Fecha de Inauguración: ");
        String fecha = scanner.nextLine();
        System.out.print("Recursos Económicos necesarios: ");
        double recursos = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer

        // Crear y agregar el lugar
        LugarBiodiverso lugar = new LugarBiodiverso(nombre, departamento, area, foto, fecha, null, recursos);
        lugarController.agregarLugar(lugar);
        System.out.println("Lugar agregado con éxito.");
    }

    public static void agregarEspecie() {
        // Solicitar datos de la especie
        System.out.print("Nombre del lugar: ");
        String nombreLugar = scanner.nextLine();
        System.out.print("Nombre de la especie: ");
        String nombreEspecie = scanner.nextLine();
        System.out.print("Tipo (Flora/Fauna): ");
        String tipoStr = scanner.nextLine();
        TipoEspecie tipo = tipoStr.equalsIgnoreCase("flora") ? TipoEspecie.FLORA : TipoEspecie.FAUNA;
        System.out.print("Foto de la especie: ");
        String foto = scanner.nextLine();
        System.out.print("Cantidad de ejemplares: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        // Crear y agregar la especie al lugar
        Especie especie = new Especie(nombreEspecie, tipo, foto, cantidad);
        lugarController.agregarEspecieALugar(nombreLugar, especie);
    }

    public static void ingresarComunidad() {
        // Solicitar datos de la comunidad y agregar
        System.out.print("Nombre de la comunidad: ");
        String nombre = scanner.nextLine();
        System.out.print("Tipo (Afrocolombiana, Indígena, Raizal): ");
        String tipoStr = scanner.nextLine();
        TipoComunidad tipo = TipoComunidad.valueOf(tipoStr.toUpperCase());
        System.out.print("Nombre del representante: ");
        String representanteNombre = scanner.nextLine();
        System.out.print("Celular del representante: ");
        String representanteCelular = scanner.nextLine();
        System.out.print("Cantidad de habitantes: ");
        int habitantes = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Problemas (separados por coma): ");
        String problemasString = scanner.nextLine();
        String[] problemas = problemasString.split(",");

        // Crear y agregar la comunidad
        Comunidad comunidad = new Comunidad(nombre, tipo, representanteNombre, representanteCelular, habitantes, problemas);
        // Aquí se podría asociar la comunidad a un lugar
        System.out.println("Comunidad ingresada con éxito.");
    }

    public static void lugarConMayorEspecies() {
        LugarBiodiverso lugar = lugarController.getLugarConMayorEspecies();
        if (lugar != null) {
            System.out.println("El lugar con mayor cantidad de especies es: " + lugar.getNombre());
        } else {
            System.out.println("No hay lugares registrados.");
        }
    }
}
