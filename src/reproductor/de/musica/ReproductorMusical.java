package reproductor.de.musica;

import java.util.*;

public class ReproductorMusical {

    private Map<String, Cancion> biblioteca;
    private List<ListaReproduccion> listasReproduccion;
    private boolean reproduciendo;
    private boolean enPausa;
    private int volumenActual;
    private List<Cancion> cancionesMasEscuchadas;
    private List<Cancion> cancionesFavoritas;

    public ReproductorMusical() {
        this.biblioteca = new HashMap<>();
        this.listasReproduccion = new ArrayList<>();
        this.reproduciendo = false;
        this.enPausa = false;
        this.volumenActual = 50; // Nivel de volumen inicial
        this.cancionesMasEscuchadas = new ArrayList<>();
        this.cancionesFavoritas = new ArrayList<>();
    }
    public Map<String, Cancion> getBiblioteca() {
        return biblioteca;
    }
    public void crearCancion(String titulo, String artista, String album, String genero) {
        Cancion cancion = new Cancion(titulo, artista, album, genero);
        biblioteca.put(titulo, cancion);
    }
    public void agregarCancionABiblioteca(Cancion cancion) {
        biblioteca.put(cancion.getTitulo(), cancion);
    }
    public void listarCancionesEnBiblioteca() {
        if (biblioteca.isEmpty()) {
            System.out.println("La biblioteca está vacía.");
        } else {
            for (Cancion cancion : biblioteca.values()) {
                System.out.println(cancion);
            }
        }
    }
    public void reproducirCancion(String titulo) {
        Cancion cancion = biblioteca.get(titulo);
        if (cancion != null) {
            reproduciendo = true;
            enPausa = false;
            System.out.println("Reproduciendo: " + cancion);
        } else {
            System.out.println("Canción no encontrada en la biblioteca.");
        }
    }
    public void pausarReanudarCancion() {
        if (reproduciendo) {
            enPausa = !enPausa;
            System.out.println(enPausa ? "Canción en pausa." : "Reanudando canción.");
        } else {
            System.out.println("No hay ninguna canción en reproducción.");
        }
    }
    public void avanzarEnCancion() {
        if (reproduciendo) {
            System.out.println("Avanzando en la canción...");
        } else {
            System.out.println("No hay ninguna canción en reproducción.");
        }
    }
    public void retrocederEnCancion() {
        if (reproduciendo) {
            System.out.println("Retrocediendo en la canción...");
        } else {
            System.out.println("No hay ninguna canción en reproducción.");
        }
    }
    public void controlarVolumen(int volumen) {
        if (volumen < 0 || volumen > 100) {
            System.out.println("El nivel de volumen debe estar entre 0 y 100.");
        } else {
            volumenActual = volumen;
            System.out.println("Volumen ajustado a: " + volumenActual);
        }
    }
    public void buscarCanciones(String termino) {
        for (Cancion cancion : biblioteca.values()) {
            if (cancion.getTitulo().contains(termino) ||
                cancion.getArtista().contains(termino) ||
                cancion.getAlbum().contains(termino) ||
                cancion.getGenero().contains(termino)) {
                System.out.println(cancion);
            }
        }
    }
    public void ordenarCanciones(int criterio) {
        List<Cancion> listaCanciones = new ArrayList<>(biblioteca.values());
        switch (criterio) {
            case 1:
                listaCanciones.sort(Comparator.comparing(Cancion::getTitulo));
                break;
            case 2:
                listaCanciones.sort(Comparator.comparing(Cancion::getArtista));
                break;
            case 3:
                listaCanciones.sort(Comparator.comparing(Cancion::getAlbum));
                break;
            case 4:
                listaCanciones.sort(Comparator.comparing(Cancion::getGenero));
                break;
            default:
                System.out.println("Criterio de ordenamiento inválido.");
                return;
        }
        for (Cancion cancion : listaCanciones) {
            System.out.println(cancion);
        }
    }
    public void eliminarCancionDeBiblioteca(String titulo) {
        Cancion cancion = biblioteca.remove(titulo);
        if (cancion != null) {
            System.out.println("Canción eliminada de la biblioteca.");
        } else {
            System.out.println("Canción no encontrada en la biblioteca.");
        }
    }
    public List<ListaReproduccion> getListasReproduccion() {
        return listasReproduccion;
    }
}
