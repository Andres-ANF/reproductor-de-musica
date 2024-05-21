package reproductor.de.musica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaReproduccion implements Serializable {
    private String nombre;
    private List<Cancion> canciones;
    public ListaReproduccion(String nombre) {
        this.nombre = nombre;
        this.canciones = new ArrayList<>();
    }
    public String getNombre() {
        return nombre;
    }
    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }
    public void eliminarCancion(Cancion cancion) {
        canciones.remove(cancion);
    }
    public void listarCanciones() {
        if (canciones.isEmpty()) {
            System.out.println("La lista de reproducción está vacía.");
        } else {
            for (Cancion cancion : canciones) {
                System.out.println(cancion);
            }
        }
    }
    public static ListaReproduccion obtenerListaPorNombre(String nombre, List<ListaReproduccion> listasReproduccion) {
        for (ListaReproduccion lista : listasReproduccion) {
            if (lista.getNombre().equals(nombre)) {
                return lista;
            }
        }
        return null;
    }
}
