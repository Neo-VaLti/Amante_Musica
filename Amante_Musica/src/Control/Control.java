package Control;

import Fachadas.FachadaBD;
import Fachadas.IFachada;
import Interfaz.DlgCancion;
import Interfaz.DlgConexion;
import Interfaz.DlgGenero;
import Interfaz.DlgPelicula;
import Tablas.Cancion;
import Tablas.Genero;
import Tablas.Pelicula;
import javax.swing.JOptionPane;
import Persistencias.Conexion;
import Fachadas.FachadaException;
import objetosServicio.Fecha;
import Excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author javier
 */
public abstract class Control {

    /*
        @author 133739 - 116462
    */
    
    //Una clase de utilidad que sirve para generar TableModels.
    private static Conversiones conversiones = new Conversiones();
    //La conexion activa hacia la base de datos.
    private static Conexion conexion;
    //La fachada de esta instancia control.
    private static IFachada fachada;

    /**
     * Crea la conexion hacia la base de datos especificada. En caso de que no
     * se pueda conectar, retornara falso. De lo contrario, la conexion se
     * establece y se retorna verdadero.
     *
     */
    public static void crearConexion() {
        DlgConexion dlg = new DlgConexion(null, true);
        String accion = dlg.getAccion();

        if (accion != null && accion.equalsIgnoreCase(DlgConexion.ACEPTAR)) {
            try {
                conexion = new Conexion(dlg.getHost(), dlg.getUsuario(), dlg.getPassword());
                fachada = new FachadaBD(dlg.getHost(), dlg.getUsuario(), dlg.getPassword());
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "No se pudo establecer una conexion hacia la base de datos. " + e.getMessage());

                //Se vuelve mostrar el dialogo de conexion hasta que se escoja un host valido.
                crearConexion();
            } finally {
                // Cierra la conexión 
                try {
                    if (conexion != null) {
                        conexion.close();
                    }
                } catch (PersistenciaException pe) {

                }
            }
        } else if (accion == null || accion.equalsIgnoreCase(DlgConexion.CANCELAR)) {
            System.exit(0);
        }
    }

    /**
     * Agrega una nueva cancion a la lista de canciones.
     */
    public static void agregarCancion() {
        DlgCancion dlg = new DlgCancion(null, true, DlgCancion.CMD_AGREGAR, fachada);
        String accion = dlg.getAccion();

        if (accion != null && accion.equalsIgnoreCase(DlgCancion.A_ACEPTAR)) {
            try {
                Cancion cancion = new Cancion();

                //Vamos a obtener el genero que se selecciono.
                String claveGeneroSeleccionado = dlg.getClaveGenero();
                Genero genero = fachada.obten(new Genero(claveGeneroSeleccionado));

                cancion.setGenero(genero);
                cancion.setClave(dlg.getClave());
                cancion.setTitulo(dlg.getTitulo());
                cancion.setInterprete(dlg.getInterprete());
                cancion.setAutor(dlg.getAutor());
                cancion.setAlbum(dlg.getAlbum());
                cancion.setDuracion(Integer.parseInt(dlg.getDuracion()));
                try {
                    cancion.setFecha(new Fecha(dlg.getFecha()));
                } catch (Exception ex) {
                    Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                }

                fachada.agrega(cancion);

                JOptionPane.showMessageDialog(null, "Se agrego un nueva cancion exitosamente.");
            } catch (FachadaException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Hubo un error agregando. " + e.getMessage());
            }
        }
    }

    /**
     * Actualiza una cancion dentro de la lista de canciones.
     */
    public static void actualizarCancion() {
        DlgCancion dlg = new DlgCancion(null, true, DlgCancion.CMD_ACTUALIZAR, fachada);
        String accion = dlg.getAccion();

        if (accion != null && accion.equalsIgnoreCase(DlgCancion.A_ACEPTAR)) {
            try {
                Cancion cancion = new Cancion();

                //Vamos a obtener el genero que se selecciono.
                String claveGeneroSeleccionado = dlg.getClaveGenero();
                Genero genero = fachada.obten(new Genero(claveGeneroSeleccionado));

                cancion.setGenero(genero);
                cancion.setClave(dlg.getClave());
                cancion.setTitulo(dlg.getTitulo());
                cancion.setInterprete(dlg.getInterprete());
                cancion.setAutor(dlg.getAutor());
                cancion.setAlbum(dlg.getAlbum());
                cancion.setDuracion(Integer.parseInt(dlg.getDuracion()));
                try {
                    cancion.setFecha(new Fecha(dlg.getFecha()));
                } catch (Exception ex) {
                    Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                }

                fachada.actualiza(dlg.getClaveAntigua(), cancion);

                JOptionPane.showMessageDialog(null, "Se actualizo la cancion exitosamente.");
            } catch (FachadaException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Hubo un error actualizando. " + e.getMessage());
            }
        }
    }

    /**
     * Elimina una cancion dentro de la lista de canciones.
     */
    public static void eliminarCancion() {
        DlgCancion dlg = new DlgCancion(null, true, DlgCancion.CMD_ELIMINAR, fachada);
        String accion = dlg.getAccion();

        if (accion != null && accion.equalsIgnoreCase(DlgCancion.A_ACEPTAR)) {
            try {
                Cancion cancion = new Cancion();

                //Vamos a obtener el genero que se selecciono.
                String claveGeneroSeleccionado = dlg.getClaveGenero();
                Genero genero = fachada.obten(new Genero(claveGeneroSeleccionado));

                cancion.setGenero(genero);
                cancion.setClave(dlg.getClave());
                cancion.setTitulo(dlg.getTitulo());
                cancion.setInterprete(dlg.getInterprete());
                cancion.setAutor(dlg.getAutor());
                cancion.setAlbum(dlg.getAlbum());
                cancion.setDuracion(Integer.parseInt(dlg.getDuracion()));
                try {
                    cancion.setFecha(new Fecha(dlg.getFecha()));
                } catch (Exception ex) {
                    Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                }

                fachada.elimina(cancion);

                JOptionPane.showMessageDialog(null, "Se elimino la cancion exitosamente.");
            } catch (FachadaException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Hubo un error eliminando. " + e.getMessage());
            }
        }
    }

    /**
     * Agrega un nuevo genero a la lista de generos.
     */
    public static void agregarGenero() {
        DlgGenero dlg = new DlgGenero(null, true, DlgGenero.CMD_AGREGAR, null);
        String accion = dlg.getAccion();

        if (accion != null && accion.equalsIgnoreCase(DlgGenero.A_ACEPTAR)) {
            Genero genero = new Genero(dlg.getCveGenero(), dlg.getNombre(), dlg.getTipoMedio());

            try {
                fachada.agrega(genero);

                JOptionPane.showMessageDialog(null, "Se agrego un nuevo genero exitosamente.");
            } catch (FachadaException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Hubo un error agregando. " + e.getMessage());
            }
        }
    }

    /**
     * Actualiza un genero de la lista de generos.
     */
    public static void actualizarGenero() {
        DlgGenero dlg = new DlgGenero(null, true, DlgGenero.CMD_ACTUALIZAR, fachada);
        String accion = dlg.getAccion();

        if (accion != null && accion.equalsIgnoreCase(DlgGenero.A_ACEPTAR)) {
            Genero genero = new Genero(dlg.getCveGenero(), dlg.getNombre(), dlg.getTipoMedio());

            try {
                fachada.actualiza(dlg.getClaveAntigua(), genero);

                JOptionPane.showMessageDialog(null, "Se actualizo el genero exitosamente.");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Hubo un error actualizando. " + e.getMessage());
            }
        }
    }

    /**
     * Elimina un genero de la lista de generos.
     */
    public static void eliminarGenero() {
        DlgGenero dlg = new DlgGenero(null, true, DlgGenero.CMD_ELIMINAR, fachada);
        String accion = dlg.getAccion();

        if (accion != null && accion.equalsIgnoreCase(DlgGenero.A_ACEPTAR)) {
            Genero genero = new Genero(dlg.getCveGenero(), dlg.getNombre(), dlg.getTipoMedio());

            try {
                fachada.elimina(genero);

                JOptionPane.showMessageDialog(null, "Se elimino el genero exitosamente.");
            } catch (FachadaException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Hubo un error eliminando. " + e.getMessage());
            }
        }
    }

    /**
     * Retorna una tabla de generos disponibles de la base de datos.
     *
     * @return La tabla de generos.
     */
    public static ModeloTabla getTablaGeneros() {
        ModeloTabla tabla = new ModeloTabla();
        tabla.setModelo(conversiones.generosTablaModel(fachada));
        tabla.setTitulo("Generos");

        return tabla;
    }

    /**
     * Retorna una tabla de canciones disponibles de la base de datos.
     *
     * @return La tabla de canciones.
     */
    public static ModeloTabla getTablaCanciones() {
        ModeloTabla tabla = new ModeloTabla();
        tabla.setModelo(conversiones.cancionesTablaModel(fachada));
        tabla.setTitulo("Canciones");

        return tabla;
    }

    /**
     *
     * @return
     */
    public static ModeloTabla getTablaPeliculas() {
        ModeloTabla tabla = new ModeloTabla();
        tabla.setModelo(conversiones.peliculasTablaModel(fachada));
        tabla.setTitulo("Peliculas");

        return tabla;
    }

    /**
     *
     */
    public static void agregarPelicula() {
        DlgPelicula dlg = new DlgPelicula(null, true, DlgPelicula.CMD_AGREGAR, fachada);
        String accion = dlg.getAccion();

        if (accion != null && accion.equalsIgnoreCase(DlgCancion.A_ACEPTAR)) {
            try {
                Pelicula pelicula = new Pelicula();

                //Vamos a obtener el genero que se selecciono.
                String claveGeneroSeleccionado = dlg.getClaveGenero();
                Genero genero = fachada.obten(new Genero(claveGeneroSeleccionado));

                pelicula.setGenero(genero);
                pelicula.setClave(dlg.getClave());
                pelicula.setTitulo(dlg.getTitulo());
                pelicula.setDirector(dlg.getDirector());
                pelicula.setAutor1(dlg.getAutor1());
                pelicula.setAutor2(dlg.getAutor2());
                pelicula.setDuracion(Integer.parseInt(dlg.getDuracion()));
                try {
                    pelicula.setFecha(new Fecha(dlg.getFecha()));
                } catch (Exception ex) {
                    Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                }

                fachada.agrega(pelicula);

                JOptionPane.showMessageDialog(null, "Se agrego un nueva pelicula exitosamente.");
            } catch (FachadaException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Hubo un error agregando. " + e.getMessage());
            }
        }
    }

    /**
     * Actualiza una pelicula dentro de la lista de peliculas.
     */
    public static void actualizarPeliculas() {
        DlgPelicula dlg = new DlgPelicula(null, true, DlgPelicula.CMD_ACTUALIZAR, fachada);
        String accion = dlg.getAccion();

        if (accion != null && accion.equalsIgnoreCase(DlgPelicula.A_ACEPTAR)) {
            try {
                Pelicula pelicula = new Pelicula();

                //Vamos a obtener el genero que se selecciono.
                String claveGeneroSeleccionado = dlg.getClaveGenero();
                Genero genero = fachada.obten(new Genero(claveGeneroSeleccionado));

                pelicula.setGenero(genero);
                pelicula.setClave(dlg.getClave());
                pelicula.setTitulo(dlg.getTitulo());
                pelicula.setDirector(dlg.getDirector());
                pelicula.setAutor1(dlg.getAutor1());
                pelicula.setAutor2(dlg.getAutor2());
                pelicula.setDuracion(Integer.parseInt(dlg.getDuracion()));
                try {
                    pelicula.setFecha(new Fecha(dlg.getFecha()));
                } catch (Exception ex) {
                    Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                }

                fachada.actualiza(dlg.getClaveAntigua(), pelicula);

                JOptionPane.showMessageDialog(null, "Se actualizo la pelicula exitosamente.");
            } catch (FachadaException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Hubo un error actualizando. " + e.getMessage());
            }
        }
    }

    /**
     * Elimina una pelicula dentro de la lista de peliculas.
     */
    public static void eliminarPelicula() {
        DlgPelicula dlg = new DlgPelicula(null, true, DlgPelicula.CMD_ELIMINAR, fachada);
        String accion = dlg.getAccion();

        if (accion != null && accion.equalsIgnoreCase(DlgCancion.A_ACEPTAR)) {
            try {
                Pelicula pelicula = new Pelicula();

                //Vamos a obtener el genero que se selecciono.
                String claveGeneroSeleccionado = dlg.getClaveGenero();
                Genero genero = fachada.obten(new Genero(claveGeneroSeleccionado));

                pelicula.setGenero(genero);
                pelicula.setClave(dlg.getClave());
                pelicula.setTitulo(dlg.getTitulo());
                pelicula.setDirector(dlg.getDirector());
                pelicula.setAutor1(dlg.getAutor1());
                pelicula.setAutor2(dlg.getAutor2());
                pelicula.setDuracion(Integer.parseInt(dlg.getDuracion()));
                try {
                    pelicula.setFecha(new Fecha(dlg.getFecha()));
                } catch (Exception ex) {
                    Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                }

                fachada.elimina(pelicula);

                JOptionPane.showMessageDialog(null, "Se elimino la pelicula exitosamente.");
            } catch (FachadaException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Hubo un error eliminando. " + e.getMessage());
            }
        }
    }

}
