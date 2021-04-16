package Tablas;

import objetosServicio.Fecha;

/**
 *
 * @author 133739 - 116462
 */
public class Cancion {

    private String clave;
    private String titulo;
    private String interprete;
    private String autor;
    private String album;

    private Fecha fecha;
    private Genero genero;

    private int duracion;

    /**
     * Constructor vacio.
     */
    public Cancion() {
    }

    /**
     * Crea una nueva cancion a partir de una clave.
     *
     * @param clave La clave de esta cancion.
     */
    public Cancion(String clave) {
        this.clave = clave;
    }

    /**
     *
     * @param clave La clave de esta cancion.
     * @param titulo El titulo de esta cancion.
     * @param genero El genero de esta cancion.
     * @param interprete El interprete de esta cancion.
     * @param autor El autor de esta cancion.
     * @param album El album de esta cancion.
     * @param duracion La duracion de esta cancion.
     * @param fecha La fecha en la cual se creo esta cancion.
     */
    public Cancion(String clave, String titulo, Genero genero, String interprete, String autor, String album, int duracion, Fecha fecha) {
        this.clave = clave;
        this.titulo = titulo;
        this.genero = genero;
        this.interprete = interprete;
        this.autor = autor;
        this.album = album;
        this.duracion = duracion;
        this.fecha = fecha;
    }

    //Getters

    /**
     *
     * @return
     */
    public String getAlbum() {
        return album;
    }

    /**
     *
     * @return
     */
    public String getAutor() {
        return autor;
    }

    /**
     *
     * @return
     */
    public String getClave() {
        return clave;
    }

    /**
     *
     * @return
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     *
     * @return
     */
    public String getInterprete() {
        return interprete;
    }

    /**
     *
     * @return
     */
    public Fecha getFecha() {
        return fecha;
    }

    /**
     *
     * @return
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     *
     * @return
     */
    public int getDuracion() {
        return duracion;
    }

    //Setters

    /**
     *
     * @param clave
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     *
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     *
     * @param interprete
     */
    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }

    /**
     *
     * @param autor
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     *
     * @param album
     */
    public void setAlbum(String album) {
        this.album = album;
    }

    /**
     *
     * @param fecha
     */
    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * @param genero
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     *
     * @param duracion
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
