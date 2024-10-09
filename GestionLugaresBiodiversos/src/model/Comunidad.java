package model;

/**
 * Clase que representa una comunidad que cuida un lugar biodiverso.
 */
public class Comunidad {
    private String nombre;
    private TipoComunidad tipo; // Afrocolombiana, Indígena, Raizal
    private String representanteNombre;
    private String representanteCelular;
    private int cantidadHabitantes;
    private String[] problemas; // Almacena los problemas que enfrenta la comunidad
    private int contadorProblemas;

    public Comunidad(String nombre, TipoComunidad tipo, String representanteNombre, String representanteCelular,
                     int cantidadHabitantes, String[] problemas) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.representanteNombre = representanteNombre;
        this.representanteCelular = representanteCelular;
        this.cantidadHabitantes = cantidadHabitantes;
        this.problemas = problemas;
        this.contadorProblemas = problemas.length; // Contar la cantidad de problemas
    }

    public String getNombre() {
        return nombre;
    }

    public String[] getProblemas() {
        return problemas;
    }

    public boolean tieneProblemas(String problema) {
        for (int i = 0; i < contadorProblemas; i++) {
            if (problemas[i].equalsIgnoreCase(problema)) {
                return true;
            }
        }
        return false;
    }
}
