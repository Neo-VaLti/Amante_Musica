package Fachadas;

import Persistencias.Peliculas;
import Persistencias.Canciones;
import Persistencias.Generos;
import Tablas.Cancion;
import Tablas.Genero;
import Tablas.Pelicula;
import java.sql.Connection;
import java.util.Vector;
import javax.swing.JOptionPane;
import Persistencias.Conexion;
import Excepciones.PersistenciaException;

/**
 *
 * @author javier
 */
public class FachadaBD implements IFachada {

    // URL de la base de datos. Sintaxis:
    // "jdbc:mysql://dir IP del servidor/base de datos"
    // Si la base de datos está en la máquina local use localhost en lugar de
    // la dirección IP del servidor
    private String url = "jdbc:mysql://localhost/amantemusica";
    // Nombre del usuario que tiene acceso a la base de datos
    private String usuario = "root";
    // Password del usuario
    private String password = "";

    //Catalogo de canciones.
    private final Canciones catalogoCanciones;
    //Catalogo de generos.
    private final Generos catalogoGeneros;
    //Catalogo Peliculas
    private final Peliculas catalogoPeliculas;

    /**
     * Constructor predeterminado
     * @param url
     * @param usuario
     * @param password
     */
    public FachadaBD(String url, String usuario, String password) {
        this.url = url;
        this.usuario = usuario;
        this.password = password;
        // Crea un objeto del tipo catalogoCanciones para accesar a la tabla
        // canciones
        catalogoCanciones = new Canciones("canciones");
        catalogoGeneros = new Generos("generos");
        catalogoPeliculas = new Peliculas("peliculas");
    }

    /**
     * Agrega una canción a la tabla canciones. No se permiten canciones con
     * claves repetidas
     *
     * @param cancion Cancion a agregar
     * @throws FachadaException Si la canción está repetida o no se puede
     * agregar la canción a la tabla canciones.
     */
    @Override
    public void agrega(Cancion cancion) throws FachadaException {
        Conexion conexion = null;

        try {
            //Establece la conexion hacia la base de datos definida.
            conexion = new Conexion(url, usuario, password);
            Connection conn = conexion.getConexion();
            catalogoCanciones.setConexion(conn);

            //Primero se busca la cancion en la tabla de canciones.
            Cancion target = catalogoCanciones.obten(cancion);

            if (target != null) {
                JOptionPane.showMessageDialog(null, "No se puede agregar una cancion repetida.");
                throw new FachadaException("Cancion Repetida");
            }

            catalogoCanciones.agrega(cancion);
        } catch (Exception pe) {
            throw new FachadaException("No se puede agregar la canción", pe);
        } finally {
            // Cierra la conexión 
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (PersistenciaException pe) {
                throw new FachadaException("No se puede agregar la canción", pe);
            }
        }
    }

    /**
     * Actualiza una canción de la tabla canciones
     *
     * @param claveCancion
     * @param cancion Cancion a actualizar
     * @throws FachadaException Si no se puede actualizar la canción de la tabla
     * canciones.
     */
    @Override
    public void actualiza(String claveCancion, Cancion cancion) throws FachadaException {
        Conexion conexion = null;
        try {
            // Establece la conexion con la base de datos
            conexion = new Conexion(url, usuario, password);
            Connection conn = conexion.getConexion();
            catalogoCanciones.setConexion(conn);
            // Actualiza la canción de la tabla canciones
            catalogoCanciones.actualiza(claveCancion, cancion);
        } catch (Exception pe) {
            throw new FachadaException("No se puede actualizar la canción", pe);
        } finally {
            // Cierra la conexión
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (PersistenciaException pe) {
                throw new FachadaException("No se puede actualizar la canción", pe);
            }
        }
    }

    /**
     * Agrega un género a la tabla géneros. No se permiten géneros con claves
     * repetidas
     *
     * @param genero Género a agregar
     * @throws FachadaException Si el género está repetido o no se puede agregar
     * el género a la tabla generos.
     */
    @Override
    public void agrega(Genero genero) throws FachadaException {
        Conexion conexion = null;

        try {
            //Se establece la conexion hacia la base de datos definida.
            conexion = new Conexion(url, usuario, password);
            Connection conn = conexion.getConexion();
            catalogoGeneros.setConexion(conn);

            //Checaremos si no existe un genero con los mismos datos dentro
            //de la base de datos.
            Genero target = catalogoGeneros.obten(genero);

            if (target != null) {
                JOptionPane.showMessageDialog(null, "No se puede agregar un genero repetido.");
                throw new FachadaException("Genero repetido");
            }

            catalogoGeneros.agrega(genero);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede agregar el género", pe);
        } finally {
            // Cierra la conexión
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (PersistenciaException pe) {
                throw new FachadaException("No se puede agregar el género", pe);
            }
        }
    }

    /**
     * Actualiza un género de la tabla géneros
     *
     * @param claveGenero La clave del genero antiguo a actualizarse.
     * @param genero Género a actualizar
     * @throws FachadaException Si no se puede actualizar el género de la tabla
     * generos.
     */
    @Override
    public void actualiza(String claveGenero, Genero genero) throws FachadaException {
        Conexion conexion = null;
        try {
            // Establece la conexion con la base de datos
            conexion = new Conexion(url, usuario, password);
            Connection conn = conexion.getConexion();
            catalogoGeneros.setConexion(conn);
            // Actualiza el género de la tabla generos
            catalogoGeneros.actualiza(claveGenero, genero);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede actualizar el género", pe);
        } finally {
            // Cierra la conexión
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (PersistenciaException pe) {
                throw new FachadaException("No se puede actualizar el género", pe);
            }
        }
    }

    /**
     * Obtiene una canción de la tabla canciones
     *
     * @param cancion Cancion a obtener
     * @return La canción si existe, null en caso contrario
     * @throws FachadaException Si no se puede obtener la canción.
     */
    @Override
    public Cancion obten(Cancion cancion) throws FachadaException {
        Conexion conexion = null;
        Cancion cancionHallada;
        Genero generoHallado;
        try {
            // Establece la conexion con la base de datos
            conexion = new Conexion(url, usuario, password);
            Connection conn = conexion.getConexion();
            catalogoCanciones.setConexion(conn);
            catalogoGeneros.setConexion(conn);
            // Obten la canción 
            cancionHallada = catalogoCanciones.obten(cancion);
            if (cancionHallada != null) {
                // Obten el género de la canción
                generoHallado = catalogoGeneros.obten(cancionHallada.getGenero());
                // Se agrega el género a la canción
                cancionHallada.setGenero(generoHallado);
            }
            // Regresa la canción
            return cancionHallada;
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener la canción", pe);
        } finally {
            // Cierra la conexión
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (PersistenciaException pe) {
                throw new FachadaException("No se puede obtener la canción", pe);
            }
        }
    }

    /**
     * Elimina una canción de la tabla canciones
     *
     * @param cancion Cancion a eliminar
     * @throws FachadaException Si no se puede eliminar la canción de la tabla
     * canciones.
     */
    @Override
    public void elimina(Cancion cancion) throws FachadaException {
        Conexion conexion = null;
        try {
            // Establece la conexion con la base de datos
            conexion = new Conexion(url, usuario, password);
            Connection conn = conexion.getConexion();
            catalogoCanciones.setConexion(conn);
            // Elimina la canción de la tabla canciones
            catalogoCanciones.elimina(cancion);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede eliminar la canción", pe);
        } finally {
            // Cierra la conexión
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (PersistenciaException pe) {
                throw new FachadaException("No se puede eliminar la canción", pe);
            }
        }
    }

    /**
     * Obtiene una lista todas las canciones
     *
     * @return Vector con la lista de todas las canciones
     * @throws FachadaException Si no se puede obtener la lista de canciones
     */
    @Override
    public Vector consultaCanciones() throws FachadaException {
        Conexion conexion = null;
        try {
            // Establece la conexion con la base de datos
            conexion = new Conexion(url, usuario, password);
            Connection conn = conexion.getConexion();
            catalogoCanciones.setConexion(conn);
            // Regresa el vector con la lista de canciones
            return agregaGeneroCanciones(catalogoCanciones.lista());
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener la lista de canciones", pe);
        } finally {
            // Cierra la conexión
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (PersistenciaException pe) {
                throw new FachadaException("No se puede obtener la lista de canciones", pe);
            }
        }
    }

    /**
     * Le agrega los atributos del género a cada canción de la lista
     *
     * @param listaCanciones Lista de las canciones a las que se les agregará
     * los atributos del género
     * @return Vector con la lista de canciones
     * @throws FachadaException Si hay un problema al conectarse a la * base de
     * datos
     */
    private Vector agregaGeneroCanciones(Vector listaCanciones) throws FachadaException {
        Genero genero;
        Cancion cancion;
        Conexion conexion = null;
        try {
            // Establece la conexion con la base de datos
            conexion = new Conexion(url, usuario, password);
            Connection conn = conexion.getConexion();
            catalogoGeneros.setConexion(conn);
            // Para cada canción de la lista
            for (int i = 0; i < listaCanciones.size(); i++) {
                // Obtén la canción de la lista
                cancion = (Cancion) listaCanciones.elementAt(i);
                // Obten el género de la canción del catálogo de géneros
                genero = catalogoGeneros.obten(cancion.getGenero());
                // Agrega el género a la canción
                cancion.setGenero(genero);
                listaCanciones.setElementAt(cancion, i);
            }
            // Regresa el vector con la lista canciones
            return listaCanciones;
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener la lista de canciones", pe);
        } finally {
            // Cierra la conexión
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (PersistenciaException pe) {
                throw new FachadaException("No se puede obtener la lista de canciones", pe);
            }
        }
    }

    /**
     * Obtiene un Vector de todos los generos.
     *
     * @return Vector un vector con todos los generos.
     * @throws FachadaException Si no se pudo conectar a la base de datos.
     */
    @Override
    public Vector consultaGeneros() throws FachadaException {
        Conexion conexion = null;

        try {
            // Establece la conexion con la base de datos
            conexion = new Conexion(url, usuario, password);
            Connection conn = conexion.getConexion();
            catalogoGeneros.setConexion(conn);

            // Regresa el vector con la lista de canciones
            return catalogoGeneros.lista();
        } catch (Exception e) {

        } finally {
            // Cierra la conexión
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (PersistenciaException pe) {
                throw new FachadaException("No se puede obtener la lista de generos.", pe);
            }
        }

        return null;
    }

    /**
     * Obtiene un género de la tabla generos
     *
     * @param genero Género a obtener
     * @return El género si existe, null en caso contrario
     * * @throws FachadaException Si no se puede obtener el género.
     * @throws Fachadas.FachadaException
     */
    public Genero obten(Genero genero) throws FachadaException {
        Conexion conexion = null;
        try {
            // Establece la conexion con la base de datos
            conexion = new Conexion(url, usuario, password);
            Connection conn = conexion.getConexion();
            catalogoGeneros.setConexion(conn);
            // Obten el género
            return catalogoGeneros.obten(genero);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener el género", pe);
        } finally {
            // Cierra la conexión
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (PersistenciaException pe) {
                throw new FachadaException("No se puede obtener el género", pe);
            }
        }
    }

    /**
     * Elimina un género de la tabla generos
     *
     * @param genero Género a eliminar
     * @throws FachadaException Si no se puede eliminar el género de la tabla
     * generos.
     */
    @Override
    public void elimina(Genero genero) throws FachadaException {
        Conexion conexion = null;
        try {
            // Establece la conexion con la base de datos
            conexion = new Conexion(url, usuario, password);
            Connection conn = conexion.getConexion();
            catalogoGeneros.setConexion(conn);
            // Elimina el género de la tabla generos
            catalogoGeneros.elimina(genero);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede eliminar el género", pe);
        } finally {
            // Cierra la conexión
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (PersistenciaException pe) {
                throw new FachadaException("No se puede eliminar el género", pe);
            }
        }
    }

    /**
     *
     * @param pelicula
     * @return
     * @throws FachadaException
     */
    @Override
    public Pelicula obten(Pelicula pelicula) throws FachadaException {
        Conexion conexion = null;
        Pelicula peliculaHallada;
        Genero generoHallado;

        try {
            // Establece la conexion con la base de datos
            conexion = new Conexion(url, usuario, password);
            Connection conn = conexion.getConexion();
            catalogoPeliculas.setConexion(conn);
            catalogoGeneros.setConexion(conn);

            // Obten la pelicula
            peliculaHallada = catalogoPeliculas.obten(pelicula);
            if (peliculaHallada != null) {
                // Obten el género de la canción
                generoHallado = catalogoGeneros.obten(peliculaHallada.getGenero());
                // Se agrega el género a la canción
                peliculaHallada.setGenero(generoHallado);
            }
            // Regresa la canción
            return peliculaHallada;
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener la Pelicula", pe);
        } finally {
            // Cierra la conexión
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (PersistenciaException pe) {
                throw new FachadaException("No se puede obtener la Pelicula", pe);
            }
        }
    }

    /**
     *
     * @param pelicula
     * @throws FachadaException
     */
    @Override
    public void agrega(Pelicula pelicula) throws FachadaException {
        Conexion conexion = null;

        try {
            //Establece la conexion hacia la base de datos definida.
            conexion = new Conexion(url, usuario, password);
            Connection conn = conexion.getConexion();
            catalogoPeliculas.setConexion(conn);

            //Primero se busca la cancion en la tabla de canciones.
            Pelicula target = catalogoPeliculas.obten(pelicula);

            if (target != null) {
                JOptionPane.showMessageDialog(null, "No se puede agregar una Pelicula repetida.");
                throw new FachadaException("Pelicula Repetida");
            }

            catalogoPeliculas.agrega(pelicula);
        } catch (Exception pe) {
            throw new FachadaException("No se puede agregar la Pelicula", pe);
        } finally {
            // Cierra la conexión 
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (PersistenciaException pe) {
                throw new FachadaException("No se puede agregar la Pelicula", pe);
            }
        }
    }

    /**
     *
     * @param pelicula
     * @throws FachadaException
     */
    @Override
    public void elimina(Pelicula pelicula) throws FachadaException {
        Conexion conexion = null;
        try {
            // Establece la conexion con la base de datos
            conexion = new Conexion(url, usuario, password);
            Connection conn = conexion.getConexion();
            catalogoPeliculas.setConexion(conn);
            // Elimina la canción de la tabla canciones
            catalogoPeliculas.elimina(pelicula);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede eliminar la Pelicula", pe);
        } finally {
            // Cierra la conexión
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (PersistenciaException pe) {
                throw new FachadaException("No se puede eliminar la Pelicula", pe);
            }
        }
    }

    /**
     *
     * @param clavePelicula
     * @param pelicula
     * @throws FachadaException
     */
    @Override
    public void actualiza(String clavePelicula, Pelicula pelicula) throws FachadaException {
        Conexion conexion = null;
        try {
            // Establece la conexion con la base de datos
            conexion = new Conexion(url, usuario, password);
            Connection conn = conexion.getConexion();
            catalogoPeliculas.setConexion(conn);
            // Actualiza la canción de la tabla canciones
            catalogoPeliculas.actualiza(clavePelicula, pelicula);
        } catch (Exception pe) {
            throw new FachadaException("No se puede actualizar la Pelicula", pe);
        } finally {
            // Cierra la conexión
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (PersistenciaException pe) {
                throw new FachadaException("No se puede actualizar la Pelicula", pe);
            }
        }
    }

    /**
     *
     * @return
     * @throws FachadaException
     */
    @Override
    public Vector consultaPeliculas() throws FachadaException {
        Conexion conexion = null;
        try {
            // Establece la conexion con la base de datos
            conexion = new Conexion(url, usuario, password);
            Connection conn = conexion.getConexion();
            catalogoPeliculas.setConexion(conn);
            // Regresa el vector con la lista de canciones
            return agregaGeneroPeliculas(catalogoPeliculas.lista());
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener la lista de Peliculas", pe);
        } finally {
            // Cierra la conexión
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (PersistenciaException pe) {
                throw new FachadaException("No se puede obtener la lista de Peliculas", pe);
            }
        }
    }

    private Vector agregaGeneroPeliculas(Vector listaPeliculas) throws FachadaException {
        Genero genero;
        Pelicula pelicula;
        Conexion conexion = null;
        try {
            // Establece la conexion con la base de datos
            conexion = new Conexion(url, usuario, password);
            Connection conn = conexion.getConexion();
            catalogoGeneros.setConexion(conn);
            // Para cada canción de la lista
            for (int i = 0; i < listaPeliculas.size(); i++) {
                // Obtén la canción de la lista
                pelicula = (Pelicula) listaPeliculas.elementAt(i);
                // Obten el género de la canción del catálogo de géneros
                genero = catalogoGeneros.obten(pelicula.getGenero());
                // Agrega el género a la canción
                pelicula.setGenero(genero);
                listaPeliculas.setElementAt(pelicula, i);
            }
            // Regresa el vector con la lista canciones
            return listaPeliculas;
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener la lista de Peliculas", pe);
        } finally {
            // Cierra la conexión
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (PersistenciaException pe) {
                throw new FachadaException("No se puede obtener la lista de Peliculas", pe);
            }
        }
    }
}
