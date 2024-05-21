package reproductor.de.musica;

import java.io.Serializable;

public class Cancion implements Serializable {
    private String titulo;
    private String artista;
    private String album;
    private String genero;

    public Cancion(String titulo, String artista, String album, String genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.genero = genero;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getArtista() {
        return artista;
    }
    public String getAlbum() {
        return album;
    }
    public String getGenero() {
        return genero;
    }
    @Override
    public String toString() {
        return "Cancion{" + "titulo='" + titulo + '\'' +", artista='" + artista + '\'' +", album='" + album + '\'' +", genero='" + genero + '\'' +'}';
    }
}
