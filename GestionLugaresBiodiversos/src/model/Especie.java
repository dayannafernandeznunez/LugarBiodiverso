package model;
/**
 * Clase que representa una especie dentro de un lugar biodiverso.
 */

public class Especie {
    private String nombre;
    private TipoEspecie tipo; // Flora o Fauna
    private String foto;
    private int cantidadEjemplares;

    public Especie(String nombre, TipoEspecie tipo, String foto, int cantidadEjemplares) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.foto = foto;
        this.cantidadEjemplares = cantidadEjemplares;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoEspecie getTipo() {
        return tipo;
    }

    public String getFoto() {
        return foto;
    }

    public int getCantidadEjemplares() {
        return cantidadEjemplares;
    }

    public void modificarDatos(String nombre, TipoEspecie tipo, String foto, int cantidadEjemplares) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.foto = foto;
        this.cantidadEjemplares = cantidadEjemplares;
    }
}
