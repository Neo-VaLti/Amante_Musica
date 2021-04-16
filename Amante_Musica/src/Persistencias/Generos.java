package Persistencias;

import Tablas.Genero;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import Excepciones.PersistenciaException;
import Excepciones.Tabla;

/**
 *
 * @author javier
 */
public class Generos extends Tabla {

    /**
     * Constructor del método. Establece el nombre de la tabla en la que se
     * almacenan los datos
     *
     * @param nomTabla Nombre de la tabla en la que se almacenan los datos
     */
    public Generos(String nomTabla) {
        super(nomTabla);
    }

    /**
     * Este método permite insertar un renglón de la tabla con los atributos de
     * los objetos de la clase Genero.
     *
     * @param genero Genero a insertar en la tabla generoess
     * @throws PersistenciaException Si no puede acceder a la base de datos
     */
    public void agrega(Genero genero) throws PersistenciaException {
        String sql = "";

        // Crea la sentencia para insertar.
        // La sentencia debe terminar en un ;
        sql += "INSERT " + nomTabla;
        sql += " SET cveGenero = '" + genero.getCveGenero() + "'";
        sql += ", nombre = '" + genero.getNombre() + "'";
        sql += ", tipoMedio = '" + genero.getTipoMedio() + "';";
        // Ejecuta la sentencia
        actualiza(sql);
    }

    /**
     * Este método obtiene un género cuya clave es igual a la clave del género
     * dada por el parámetro.
     *
     * @param genero Objeto de tipo Genero con la clave de la género a buscar
     * @return El género si lo encuentra. null en caso contrario.
     * @throws PersistenciaException Si no puede acceder a la base de datos
     */
    public Genero obten(Genero genero) throws PersistenciaException {
        //String del query.
        String query = "SELECT * FROM " + nomTabla + " "
                + "WHERE cveGenero = '" + genero.getCveGenero() + "';";
        //Ejecutamos el query.
        consulta(query);

        ResultSet renglon;

        //Checamos si hay resultados del query.
        if ((renglon = obtenRenglon()) != null) {
            try {
                Genero target = new Genero();
                target.setCveGenero(renglon.getString("cveGenero"));
                target.setNombre(renglon.getString("nombre"));
                target.setTipoMedio(renglon.getString("tipoMedio").charAt(0));
                return target;
            } catch (SQLException sqle) {
                throw new PersistenciaException("Error al acceder a la base de datos", sqle);
            }
        }

        return null;
    }

    /**
     * Este método permite modificar un renglón de la tabla con los atributos de
     * los objetos de la clase Genero.
     *
     * @param claveGenero La clave del genero antiguo a actualizarse.
     * @param genero El usuario a modificar
     * @throws PersistenciaException Si no puede acceder a la base de datos
     */
    public void actualiza(String claveGenero, Genero genero) throws PersistenciaException {
        String sql = "";
        // Crea la sentencia con la actualización.
        // La sentencia debe terminar en un ;
        sql += "UPDATE " + nomTabla;
        sql += " SET cveGenero = '" + genero.getCveGenero() + "'";
        sql += ", nombre = '" + genero.getNombre() + "'";
        sql += ", tipoMedio = '" + genero.getTipoMedio() + "'";
        sql += " WHERE cveGenero = '" + claveGenero + "';";

        // Ejecuta la sentencia
        actualiza(sql);
    }

    /**
     * Este método permite borrar un renglón de la tabla con los atributos de
     * los objetos de la clase Genero.
     *
     * @param genero Genero a borrar
     * @throws PersistenciaException Si no puede acceder a la base de datos
     */
    public void elimina(Genero genero) throws PersistenciaException {
        String sql = "";
        // Crea la sentencia para borrar.
        // La sentencia debe terminar en un ;
        sql += "DELETE FROM " + nomTabla;
        sql += " WHERE cveGenero = '" + genero.getCveGenero() + "';";
        // Ejecuta la sentencia
        actualiza(sql);
    }

    /**
     * Este método permite consultar la tabla con los atributos de los objetos
     * de la clase Genero usando el comando de consulta dado por el parámetro.
     *
     * @param sql Comando de consulta dado por el parámetro.
     * @return Un vector con la lista de los objetos del tipo Genero de la tabla
     * @throws PersistenciaException Si no puede acceder a la base de datos
     */
    public Vector lista(String sql) throws PersistenciaException {
        ResultSet renglon;
        Vector lista = new Vector();

        //Ejecuta la consulta
        consulta(sql);

        //Mientras haya generos en la tabla
        while ((renglon = obtenRenglon()) != null) {
            try {
                Genero genero = new Genero();
                genero.setCveGenero(renglon.getString("cveGenero"));
                genero.setNombre(renglon.getString("nombre"));
                genero.setTipoMedio(renglon.getString("tipoMedio").charAt(0));

                lista.add(genero);
            } catch (SQLException sqle) {
                throw new PersistenciaException("Error al acceder a la BD.", sqle);
            }
        }

        return lista;
    }

    /**
     * Este método permite consultar la tabla con los atributos de los objetos
     * de la clase Genero.
     *
     * @return Un vector con la lista de los objetos del tipo Genero de la tabla
     * @throws PersistenciaException Si no puede acceder a la base de datos
     */
    public Vector lista() throws PersistenciaException {
        String sql = "SELECT * FROM " + nomTabla + ";";
        return lista(sql);
    }
}
