
package Fachadas;

import Tablas.Cancion;
import Tablas.Genero;
import Tablas.Pelicula;
import java.util.Vector;
import Fachadas.FachadaException;

/**
 *
 * @author 133739 - 116462
 */
public interface IFachada {

    /**
     *
     * @param cancion
     * @return
     * @throws FachadaException
     */
    public Cancion obten(Cancion cancion) throws FachadaException;

    /**
     *
     * @param cancion
     * @throws FachadaException
     */
    public void agrega(Cancion cancion) throws FachadaException;

    /**
     *
     * @param cancion
     * @throws FachadaException
     */
    public void elimina(Cancion cancion) throws FachadaException;

    /**
     *
     * @param claveCancion
     * @param cancion
     * @throws FachadaException
     */
    public void actualiza(String claveCancion, Cancion cancion) throws FachadaException;
    
    /**
     *
     * @param genero
     * @return
     * @throws FachadaException
     */
    public Genero obten(Genero genero) throws FachadaException;

    /**
     *
     * @param genero
     * @throws FachadaException
     */
    public void agrega(Genero genero) throws FachadaException;

    /**
     *
     * @param genero
     * @throws FachadaException
     */
    public void elimina(Genero genero) throws FachadaException;

    /**
     *
     * @param claveGenero
     * @param genero
     * @throws FachadaException
     */
    public void actualiza(String claveGenero, Genero genero) throws FachadaException;
    
    /**
     *
     * @return
     * @throws FachadaException
     */
    public Vector consultaGeneros() throws FachadaException;

    /**
     *
     * @return
     * @throws FachadaException
     */
    public Vector consultaCanciones() throws FachadaException;

    /**
     *
     * @return
     * @throws FachadaException
     */
    public Vector consultaPeliculas() throws FachadaException;
    
    /**
     *
     * @param pelicula
     * @return
     * @throws FachadaException
     */
    public Pelicula obten(Pelicula pelicula) throws FachadaException;

    /**
     *
     * @param pelicula
     * @throws FachadaException
     */
    public void agrega(Pelicula pelicula) throws FachadaException;

    /**
     *
     * @param pelicula
     * @throws FachadaException
     */
    public void elimina(Pelicula pelicula) throws FachadaException;

    /**
     *
     * @param clavePelicula
     * @param pelicula
     * @throws FachadaException
     */
    public void actualiza(String clavePelicula, Pelicula pelicula) throws FachadaException;
}
