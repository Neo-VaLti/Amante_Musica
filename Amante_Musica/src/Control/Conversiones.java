package Control;

import Fachadas.IFachada;
import Tablas.Cancion;
import Tablas.Genero;
import Tablas.Pelicula;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author javier
 */
public class Conversiones {

    /*
        @author 133739 - 116462
    */
    
    // Arreglos con los nombres de las columnas de las tablas
    String nombresColumnasTablaGeneros[] = {"CveGenero", "Nombre", "Tipo Medio"};
    String nombresColumnasTablaCanciones[] = {"Clave", "Titulo", "CveGenero", "Interprete", "Autor", "Album", "Duracion", "Fecha"};
    String nombresColumnasTablaPeliculas[] = {"Clave", "Titulo", "CveGenero", "Autor 1", "Autor 2", "Directo", "Duracion", "Fecha"};

    /**
     * Genera un tableModel con los datos de todos los generos disponibles.
     *
     * @param fachada La fachada conectada a la base de datos.
     * @return El table model con todos los generos disponibles.
     */
    public DefaultTableModel generosTablaModel(IFachada fachada) {
        try {
            Vector generos = fachada.consultaGeneros();
            Object[][] tabla = new Object[generos.size()][nombresColumnasTablaGeneros.length];

            for (int i = 0; i < generos.size(); i++) {
                Genero genero = (Genero) generos.get(i);

                tabla[i][0] = genero.getCveGenero();
                tabla[i][1] = genero.getNombre();
                tabla[i][2] = genero.getTipoMedio();
            }

            return new DefaultTableModel(tabla, nombresColumnasTablaGeneros);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se ha podido obtener la tabla de generos." + e.getMessage());
        }

        return null;
    }

    /**
     * Genera un tableModel con los datos de todos las canciones disponibles.
     *
     * @param fachada La fachada conectada a la base de datos.
     * @return El table model con todos las canciones disponibles.
     */
    public DefaultTableModel cancionesTablaModel(IFachada fachada) {
        try {
            Vector canciones = fachada.consultaCanciones();
            Object[][] tabla = new Object[canciones.size()][nombresColumnasTablaCanciones.length];

            for (int i = 0; i < canciones.size(); i++) {
                Cancion cancion = (Cancion) canciones.get(i);

                tabla[i][0] = cancion.getClave();
                tabla[i][1] = cancion.getTitulo();
                tabla[i][2] = cancion.getGenero();
                tabla[i][3] = cancion.getInterprete();
                tabla[i][4] = cancion.getAutor();
                tabla[i][5] = cancion.getAlbum();
                tabla[i][6] = cancion.getDuracion();
                tabla[i][7] = cancion.getFecha().toString();
            }

            return new DefaultTableModel(tabla, nombresColumnasTablaCanciones);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se ha podido obtener la tabla de generos." + e.getMessage());
        }

        return null;
    }

    /**
     *
     * @param fachada
     * @return
     */
    public DefaultTableModel peliculasTablaModel(IFachada fachada) {
        try {
            Vector peliculas = fachada.consultaPeliculas();
            Object[][] tabla = new Object[peliculas.size()][nombresColumnasTablaPeliculas.length];

            for (int i = 0; i < peliculas.size(); i++) {
                Pelicula pelicula = (Pelicula) peliculas.get(i);

                tabla[i][0] = pelicula.getClave();
                tabla[i][1] = pelicula.getTitulo();
                tabla[i][2] = pelicula.getGenero().getNombre();
                tabla[i][3] = pelicula.getAutor1();
                tabla[i][4] = pelicula.getAutor2();
                tabla[i][5] = pelicula.getDirector();
                tabla[i][6] = pelicula.getDuracion();
                tabla[i][7] = pelicula.getFecha().toString();
            }

            return new DefaultTableModel(tabla, nombresColumnasTablaPeliculas);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se ha podido obtener la tabla de generos." + e.getMessage());
        }

        return null;
    }
}
