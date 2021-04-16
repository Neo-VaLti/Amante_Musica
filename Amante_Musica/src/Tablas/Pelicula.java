/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import objetosServicio.Fecha;

/**
 *
 * @author 133739 - 116462
 */
public class Pelicula {

    private String clave;
    private String titulo;
    private Genero genero;
    private String autor1;
    private String autor2;
    private String director;
    private int duracion;
    private Fecha fecha;

    /**
     *
     */
    public Pelicula() {

    }

    /**
     *
     * @param clave
     */
    public Pelicula(String clave) {
        this.clave = clave;
    }

    /**
     *
     * @param clave
     * @param titulo
     * @param genero
     * @param autor1
     * @param autor2
     * @param director
     * @param duracion
     * @param fecha
     */
    public Pelicula(String clave, String titulo, Genero genero, String autor1, String autor2, String director, int duracion, Fecha fecha) {
        this.clave = clave;
        this.titulo = titulo;
        this.genero = genero;
        this.autor1 = autor1;
        this.autor2 = autor2;
        this.director = director;
        this.duracion = duracion;
        this.fecha = fecha;
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
     * @param clave
     */
    public void setClave(String clave) {
        this.clave = clave;
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
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     *
     * @return
     */
    public String getDirector() {
        return director;
    }

    /**
     *
     * @param director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     *
     * @return
     */
    public String getAutor1() {
        return autor1;
    }

    /**
     *
     * @param autor1
     */
    public void setAutor1(String autor1) {
        this.autor1 = autor1;
    }

    /**
     *
     * @return
     */
    public String getAutor2() {
        return autor2;
    }

    /**
     *
     * @param autor2
     */
    public void setAutor2(String autor2) {
        this.autor2 = autor2;
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
     * @param fecha
     */
    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
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
     * @param genero
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     *
     * @return
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     *
     * @param duracion
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

}
