package model;

/**
 * Clase que representa un lugar biodiverso.
 */
public class LugarBiodiverso {
    private String nombre;
    private String departamento;
    private double area;
    private String foto;
    private String fechaInauguracion;
    private Comunidad comunidad;
    private double recursosEconomicos;
    private Especie[] especies;
    private int contadorEspecies;

    public LugarBiodiverso(String nombre, String departamento, double area, String foto, String fechaInauguracion,
                           Comunidad comunidad, double recursosEconomicos) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.area = area;
        this.foto = foto;
        this.fechaInauguracion = fechaInauguracion;
        this.comunidad = comunidad;
        this.recursosEconomicos = recursosEconomicos;
        this.especies = new Especie[50]; // Capacidad máxima de 50 especies
        this.contadorEspecies = 0;
    }

    public void agregarEspecie(Especie especie) {
        if (contadorEspecies < 50) {
            especies[contadorEspecies] = especie;
            contadorEspecies++;
        } else {
            System.out.println("No se pueden agregar más especies, límite alcanzado.");
        }
    }

    public Especie[] getEspecies() {
        return especies;
    }

    public String getNombre() {
        return nombre;
    }

    public Comunidad getComunidad() {
        return comunidad;
    }
}
