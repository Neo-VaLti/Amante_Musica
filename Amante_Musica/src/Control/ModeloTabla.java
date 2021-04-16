package Control;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author javier
 */
public class ModeloTabla {

    private String titulo;
    private DefaultTableModel modelo;

    /**
     *
     */
    public ModeloTabla() {
    }

    /**
     *
     * @param titulo
     * @param modelo
     */
    public ModeloTabla(String titulo, DefaultTableModel modelo) {
        this.titulo = titulo;
        this.modelo = modelo;
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
    public DefaultTableModel getModelo() {
        return modelo;
    }

    /**
     *
     * @param modelo
     */
    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }
}
