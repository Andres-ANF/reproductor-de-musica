package reproductor.de.musica;

import java.util.Scanner;

public class ReproductorDeMusica {
    public static void main(String[] args) {
        ReproductorMusical reproductor = new ReproductorMusical();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear canción");
            System.out.println("2. Agregar canción a la biblioteca");
            System.out.println("3. Listar canciones en la biblioteca");
            System.out.println("4. Reproducir canción");
            System.out.println("5. Pausar/Reanudar canción");
            System.out.println("6. Avanzar en canción");
            System.out.println("7. Retroceder en canción");
            System.out.println("8. Controlar volumen");
            System.out.println("9. Buscar canciones");
            System.out.println("10. Ordenar canciones");
            System.out.println("11. Eliminar canción de la biblioteca");
            System.out.println("12. Crear lista de reproducción");
            System.out.println("13. Agregar canción a lista de reproducción");
            System.out.println("14. Listar canciones en lista de reproducción");
            System.out.println("15. Eliminar canción de lista de reproducción");
            System.out.println("0. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título de la canción: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el artista de la canción: ");
                    String artista = scanner.nextLine();
                    System.out.print("Ingrese el álbum de la canción: ");
                    String album = scanner.nextLine();
                    System.out.print("Ingrese el género de la canción: ");
                    String genero = scanner.nextLine();
                    reproductor.crearCancion(titulo, artista, album, genero);
                    break;
                case 2:
                    System.out.print("Ingrese el título de la canción a agregar: ");
                    String tituloAgregar = scanner.nextLine();
                    Cancion cancionAgregar = reproductor.getBiblioteca().get(tituloAgregar);
                    if (cancionAgregar != null) {
                        reproductor.agregarCancionABiblioteca(cancionAgregar);
                        System.out.println("Canción agregada a la biblioteca.");
                    } else {
                        System.out.println("Canción no encontrada en la biblioteca.");
                    }
                    break;
                case 3:
                    reproductor.listarCancionesEnBiblioteca();
                    break;
                case 4:
                    System.out.print("Ingrese el título de la canción a reproducir: ");
                    String tituloReproducir = scanner.nextLine();
                    reproductor.reproducirCancion(tituloReproducir);
                    break;
                case 5:
                    reproductor.pausarReanudarCancion();
                    break;
                case 6:
                    reproductor.avanzarEnCancion();
                    break;
                case 7:
                    reproductor.retrocederEnCancion();
                    break;
                case 8:
                    System.out.print("Ingrese el nivel de volumen (0-100): ");
                    int volumen = scanner.nextInt();
                    reproductor.controlarVolumen(volumen);
                    break;
                case 9:
                    System.out.print("Ingrese el término de búsqueda: ");
                    String terminoBusqueda = scanner.nextLine();
                    reproductor.buscarCanciones(terminoBusqueda);
                    break;
                case 10:
                    System.out.println("Seleccione el criterio de ordenamiento:");
                    System.out.println("1. Título");
                    System.out.println("2. Artista");
                    System.out.println("3. Álbum");
                    System.out.println("4. Género");
                    int criterio = scanner.nextInt();
                    reproductor.ordenarCanciones(criterio);
                    break;
                case 11:
                    System.out.print("Ingrese el título de la canción a eliminar: ");
                    String tituloEliminar = scanner.nextLine();
                    reproductor.eliminarCancionDeBiblioteca(tituloEliminar);
                    break;
                case 12:
                    System.out.print("Ingrese el nombre de la lista de reproducción: ");
                    String nombreLista = scanner.nextLine();
                    ListaReproduccion listaReproduccion = new ListaReproduccion(nombreLista);
                    reproductor.getListasReproduccion().add(listaReproduccion);
                    System.out.println("Lista de reproducción creada.");
                    break;
                case 13:
                    System.out.print("Ingrese el nombre de la lista de reproducción: ");
                    String nombreListaAgregar = scanner.nextLine();
                    ListaReproduccion listaAgregar = ListaReproduccion.obtenerListaPorNombre(nombreListaAgregar, reproductor.getListasReproduccion());
                    if (listaAgregar != null) {
                        System.out.print("Ingrese el título de la canción a agregar: ");
                        String tituloCancionLista = scanner.nextLine();
                        Cancion cancionListaAgregar = reproductor.getBiblioteca().get(tituloCancionLista);
                        if (cancionListaAgregar != null) {
                            listaAgregar.agregarCancion(cancionListaAgregar);
                            System.out.println("Canción agregada a la lista de reproducción.");
                        } else {
                            System.out.println("Canción no encontrada en la biblioteca.");
                        }
                    } else {
                        System.out.println("Lista de reproducción no encontrada.");
                    }
                    break;
                case 14:
                    System.out.print("Ingrese el nombre de la lista de reproducción: ");
                    String nombreListaListar = scanner.nextLine();
                    ListaReproduccion listaListar = ListaReproduccion.obtenerListaPorNombre(nombreListaListar, reproductor.getListasReproduccion());
                    if (listaListar != null) {
                        listaListar.listarCanciones();
                    } else {
                        System.out.println("Lista de reproducción no encontrada.");
                    }
                    break;
                case 15:
                    System.out.print("Ingrese el nombre de la lista de reproducción: ");
                    String nombreListaEliminar = scanner.nextLine();
                    ListaReproduccion listaEliminar = ListaReproduccion.obtenerListaPorNombre(nombreListaEliminar, reproductor.getListasReproduccion());
                    if (listaEliminar != null) {
                        System.out.print("Ingrese el título de la canción a eliminar: ");
                        String tituloCancionEliminar = scanner.nextLine();
                        Cancion cancionListaEliminar = reproductor.getBiblioteca().get(tituloCancionEliminar);
                        if (cancionListaEliminar != null) {
                            listaEliminar.eliminarCancion(cancionListaEliminar);
                            System.out.println("Canción eliminada de la lista de reproducción.");
                        } else {
                            System.out.println("Canción no encontrada en la biblioteca.");
                        }
                    } else {
                        System.out.println("Lista de reproducción no encontrada.");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 0);
    }
}
