package Tablas;

/**
 *
 * @author 133739 - 116462
 */
public class Genero {

    private String cveGenero;
    private String nombre;
    private char tipoMedio;

    /**
     * Constructor vacio.
     */
    public Genero() {
    }

    /**
     * Crea un genero a base de una clave.
     *
     * @param cveGenero 
     */
    public Genero(String cveGenero) {
        this.cveGenero = cveGenero;
    }

    /**
     * Crea un genero con todos los parametros dados.
     *
     * @param cveGenero La clave de este genero.
     * @param nombre El nombre de este genero.
     * @param tipoMedio El tipo de medio de este genero.
     */
    public Genero(String cveGenero, String nombre, char tipoMedio) {
        this.cveGenero = cveGenero;
        this.nombre = nombre;
        this.tipoMedio = tipoMedio;

    }

    //Getters

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @return
     */
    public char getTipoMedio() {
        return tipoMedio;
    }

    /**
     *
     * @return
     */
    public String getCveGenero() {
        return cveGenero;
    }

    //Setters

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @param cveGenero
     */
    public void setCveGenero(String cveGenero) {
        this.cveGenero = cveGenero;
    }

    /**
     *
     * @param tipoMedio
     */
    public void setTipoMedio(char tipoMedio) {
        this.tipoMedio = tipoMedio;
    }
}
