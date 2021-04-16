package Persistencias;

import java.sql.Connection;
import java.sql.DriverManager;
import Excepciones.PersistenciaException;
/**
 *
 * @author 133739 - 116462
 */
public class Conexion {

    //Conector a la base de datos.
    private Connection conexion;

    /**
     * Establece una conexión con la base de datos.
     *
     * @param url URL de la base de datos
     * @param usuario Cuenta de usuario
     * @param password Contraseña del usuario
     * @throws Excepciones.PersistenciaException
     */
    public Conexion(String url, String usuario, String password) throws PersistenciaException {
        try {
            // Se crea una instancia de la clase manejadora de mySQL
            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
            // Se conecta con la base de datos
            conexion = DriverManager.getConnection(url, usuario, password);
        } catch (Exception e) {
            throw new PersistenciaException("Error al conectarse a la base de datos", e);
        }
    }

    /**
     * Cierra la conexion hacia la base de datos.
     *
     * @throws PersistenciaException
     */
    public void close() throws PersistenciaException {
        try {
            conexion.close();
        } catch (Exception e) {
            throw new PersistenciaException("Error al cerrar la conexión con la base de datos", e);
        }
    }

    /**
     * Obtiene la conexión con la base de datos.
     *
     * @return La conexión con la base de datos
     */
    public Connection getConexion() {
        return conexion;
    }
}
