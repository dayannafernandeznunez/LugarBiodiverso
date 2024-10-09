package model;

/**
 * Clase controladora que gestiona la lógica de negocios para los lugares biodiversos.
 */

public class LugarController {
    private LugarBiodiverso[] lugares;
    private int contadorLugares;

    public LugarController() {
        lugares = new LugarBiodiverso[100]; // Capacidad máxima de 100 lugares
        contadorLugares = 0;
    }

    public void agregarLugar(LugarBiodiverso lugar) {
        if (contadorLugares < 100) {
            lugares[contadorLugares] = lugar;
            contadorLugares++;
        } else {
            System.out.println("No se pueden agregar más lugares, límite alcanzado.");
        }
    }

    public void agregarEspecieALugar(String nombreLugar, Especie especie) {
        for (int i = 0; i < contadorLugares; i++) {
            if (lugares[i].getNombre().equalsIgnoreCase(nombreLugar)) {
                lugares[i].agregarEspecie(especie);
                return;
            }
        }
        System.out.println("Lugar no encontrado.");
    }

    public LugarBiodiverso getLugarConMayorEspecies() {
        LugarBiodiverso lugarMax = null;
        int maxEspecies = 0;

        for (int i = 0; i < contadorLugares; i++) {
            int cantidadEspecies = lugares[i].getEspecies().length; // Ajustar el método para contar especies
            if (cantidadEspecies > maxEspecies) {
                maxEspecies = cantidadEspecies;
                lugarMax = lugares[i];
            }
        }

        return lugarMax;
    }

    public int getContadorLugares() {
        return contadorLugares;
    }
}
