package Persistencias;

import Tablas.Cancion;
import Tablas.Genero;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import objetosServicio.Fecha;
import Excepciones.PersistenciaException;
import Excepciones.Tabla;

/**
 *
 * @author 133739 - 116462
 */
public class Canciones extends Tabla {

    /**
     * Constructor del método. Establece el nombre de la tabla en la que se
     * almacenan los datos
     *
     * @param nomTabla Nombre de la tabla en la que se almacenan los datos
     */
    public Canciones(String nomTabla) {
        super(nomTabla);
    }

    /**
     *
     * @param cancion
     * @return
     * @throws PersistenciaException
     */
    public Cancion obten(Cancion cancion) throws PersistenciaException {
        //El query que vamos a mandar a la base de datos.
        String query = "SELECT * FROM " + nomTabla
                + " WHERE clave = '" + cancion.getClave() + "';";

        //Ejecutamos la consulta.
        consulta(query);

        //Checamos si hay renglones en la tabla resultante.
        if (!tablaVacia()) {
            ResultSet renglon = obtenRenglon();

            try {
                Cancion target = new Cancion(
                        renglon.getString("clave"),
                        renglon.getString("titulo"),
                        new Genero(renglon.getString("cveGenero")),
                        renglon.getString("interprete"),
                        renglon.getString("autor"),
                        renglon.getString("album"),
                        renglon.getInt("duracion"),
                        new Fecha(renglon.getDate("fecha"))
                );

                return target;
            } catch (SQLException sqle) {
                throw new PersistenciaException("Error al acceder a la base de datos", sqle);
            }
        }

        return null;
    }

    /**
     * Este método permite insertar un renglón de la tabla con los atributos de
     * los objetos de la clase Cancion.
     *
     * @param cancion Cancion a insertar en la tabla cancioness
     * @throws PersistenciaException Si no puede acceder a la base de datos
     */
    public void agrega(Cancion cancion) throws PersistenciaException, Exception {
        String sql = "";
        //Como el objeto fecha toma un formato de fecha DD/MM/YYYY, 
        //sql no lo aceptara ya que este toma formato YYYY/MM/DD. Asi
        //que lo invertimos.
        String fecha = new Fecha(cancion.getFecha().toString().replaceAll(" ", "")).toDateString();

        // Crea la sentencia para insertar.
        // La sentencia debe terminar en un ;
        sql += "INSERT " + nomTabla;
        sql += " SET clave = '" + cancion.getClave() + "'";
        sql += ", titulo = '" + cancion.getTitulo() + "'";
        sql += ", cveGenero = '" + cancion.getGenero().getCveGenero() + "'";
        sql += ", interprete = '" + cancion.getInterprete() + "'";
        sql += ", autor = '" + cancion.getAutor() + "'";
        sql += ", album = '" + cancion.getAlbum() + "'";
        sql += ", duracion = '" + cancion.getDuracion() + "'";
        sql += ", fecha = \"" + fecha + "\";";
        // Ejecuta la sentencia
        actualiza(sql);
    }

    /**
     * Este método permite modificar un renglón de la tabla con los atributos de
     * los objetos de la clase Cancion.
     *
     * @param claveCancion La clave antigua de la cancion que se quiere
     * actualizar.
     * @param cancion El usuario a modificar
     * @throws PersistenciaException Si no puede acceder a la base de datos
     */
    public void actualiza(String claveCancion, Cancion cancion) throws PersistenciaException, Exception {
        String sql = "";

        //Como el objeto fecha toma un formato de fecha DD/MM/YYYY, 
        //sql no lo aceptara ya que este toma formato YYYY/MM/DD. Asi
        //que lo invertimos.
        String fecha = new Fecha(cancion.getFecha().toString().replaceAll(" ", "")).toDateString();

        // Crea la sentencia con la actualización.
        // La sentencia debe terminar en un ;
        sql += "UPDATE " + nomTabla;
        sql += " SET clave = '" + cancion.getClave() + "'";
        sql += ", titulo = '" + cancion.getTitulo() + "'";
        sql += ", cveGenero = '" + cancion.getGenero().getCveGenero() + "'";
        sql += ", interprete = '" + cancion.getInterprete() + "'";
        sql += ", autor = '" + cancion.getAutor() + "'";
        sql += ", album = '" + cancion.getAlbum() + "'";
        sql += ", duracion = '" + cancion.getDuracion() + "'";
        sql += ", fecha = \"" + fecha + "\"";
        sql += " WHERE clave = '" + claveCancion + "';";
        // Ejecuta la sentencia
        actualiza(sql);
    }

    /**
     * Este método permite borrar un renglón de la tabla con los atributos de
     * los objetos de la clase Cancion.
     *
     * @param cancion Cancion a borrar
     * @throws PersistenciaException Si no puede acceder a la base de datos
     */
    public void elimina(Cancion cancion) throws PersistenciaException {
        String sql = "";
        // Crea la sentencia para borrar.
        // La sentencia debe terminar en un ;
        sql += "DELETE FROM " + nomTabla;
        sql += " WHERE clave = '" + cancion.getClave() + "';"; // Ejecuta la sentencia
        actualiza(sql);
    }

    /**
     * Este método permite consultar la tabla con los atributos de los objetos
     * de la clase Cancion usando el comando de consulta dado por el parámetro.
     *
     * @param sql Comando de consulta dado por el parámetro.
     * @return Un vector con la lista de los objetos del tipo Cancion de la
     * tabla
     * @throws PersistenciaException Si no puede acceder a la base de datos
     */
    public Vector lista(String sql) throws PersistenciaException {
        ResultSet renglon;
        Vector lista = new Vector();
        // Ejecuta la consulta
        consulta(sql);
        // Mientras haya canciones en la tabla
        while ((renglon = obtenRenglon()) != null) {
            try {
                // Crea un objeto del tipo Cancion con los campos del renglon de la
                // tabla.
                Cancion cancion = new Cancion(renglon.getString("clave"),
                        renglon.getString("titulo"),
                        new Genero(renglon.getString("cveGenero")),
                        renglon.getString("interprete"),
                        renglon.getString("autor"),
                        renglon.getString("album"),
                        renglon.getInt("duracion"),
                        new Fecha(renglon.getDate("fecha")));
                // Agrega la película al vector de película
                lista.add(cancion);
            } catch (SQLException sqle) {
                throw new PersistenciaException("Error al acceder a la base de datos", sqle);
            }
        }
        return lista;
    }

    /**
     * Este método permite consultar la tabla con los atributos de los objetos
     * de la clase Cancion.
     *
     * @return Un vector con la lista de los objetos del tipo Cancion de la
     * tabla
     * @throws PersistenciaException Si no puede acceder a la base de datos
     */
    public Vector lista() throws PersistenciaException {
        String sql = "SELECT * FROM " + nomTabla + ";";
        return lista(sql);
    }

}
