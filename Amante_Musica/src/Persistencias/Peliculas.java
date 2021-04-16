/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencias;

import Tablas.Pelicula;
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
public class Peliculas extends Tabla {

    /**
     *
     * @param nomTabla
     */
    public Peliculas(String nomTabla) {
        super(nomTabla);
    }

    /**
     *
     * @param pelicula
     * @return
     * @throws PersistenciaException
     */
    public Pelicula obten(Pelicula pelicula) throws PersistenciaException {
        //El query que vamos a mandar a la base de datos.
        String query = "SELECT * FROM " + nomTabla
                + " WHERE clave = '" + pelicula.getClave() + "';";

        //Ejecutamos la consulta.
        consulta(query);

        //Checamos si hay renglones en la tabla resultante.
        if (!tablaVacia()) {
            ResultSet renglon = obtenRenglon();

            try {
                Pelicula target = new Pelicula(
                        renglon.getString("clave"),
                        renglon.getString("titulo"),
                        new Genero(renglon.getString("cveGenero")),
                        renglon.getString("actor1"),
                        renglon.getString("actor2"),
                        renglon.getString("director"),
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
     * los objetos de la clase Pelicula.
     *
     * @param pelicula Pelicula a insertar en la tabla peliculaess
     * @throws PersistenciaException Si no puede acceder a la base de datos
     */
    public void agrega(Pelicula pelicula) throws PersistenciaException, Exception {
        String sql = "";
        //Como el objeto fecha toma un formato de fecha DD/MM/YYYY, 
        //sql no lo aceptara ya que este toma formato YYYY/MM/DD. Asi
        //que lo invertimos.
        String fecha = new Fecha(pelicula.getFecha().toString().replaceAll(" ", "")).toDateString();

        // Crea la sentencia para insertar.
        // La sentencia debe terminar en un ;
        sql += "INSERT " + nomTabla;
        sql += " SET clave = '" + pelicula.getClave() + "'";
        sql += ", titulo = '" + pelicula.getTitulo() + "'";
        sql += ", cveGenero = '" + pelicula.getGenero().getCveGenero() + "'";
        sql += ", actor1 = '" + pelicula.getAutor1() + "'";
        sql += ", actor2 = '" + pelicula.getAutor2() + "'";
        sql += ", director = '" + pelicula.getDirector() + "'";
        sql += ", duracion = '" + pelicula.getDuracion() + "'";
        sql += ", fecha = \"" + fecha + "\";";
        // Ejecuta la sentencia
        actualiza(sql);
    }

    /**
     * Este método permite modificar un renglón de la tabla con los atributos de
     * los objetos de la clase Pelicula.
     *
     * @param clavePelicula La clave antigua de la pelicula que se quiere
     * actualizar.
     * @param pelicula El usuario a modificar
     * @throws PersistenciaException Si no puede acceder a la base de datos
     */
    public void actualiza(String clavePelicula, Pelicula pelicula) throws PersistenciaException, Exception {
        String sql = "";

        //Como el objeto fecha toma un formato de fecha DD/MM/YYYY, 
        //sql no lo aceptara ya que este toma formato YYYY/MM/DD. Asi
        //que lo invertimos.
        String fecha = new Fecha(pelicula.getFecha().toString().replaceAll(" ", "")).toDateString();

        // Crea la sentencia con la actualización.
        // La sentencia debe terminar en un ;
        sql += "UPDATE " + nomTabla;
        sql += " SET clave = '" + pelicula.getClave() + "'";
        sql += ", titulo = '" + pelicula.getTitulo() + "'";
        sql += ", cveGenero = '" + pelicula.getGenero().getCveGenero() + "'";
        sql += ", actor1 = '" + pelicula.getAutor1() + "'";
        sql += ", actor2 = '" + pelicula.getAutor2() + "'";
        sql += ", director = '" + pelicula.getDirector() + "'";
        sql += ", duracion = '" + pelicula.getDuracion() + "'";
        sql += ", fecha = \"" + fecha + "\"";
        sql += " WHERE clave = '" + clavePelicula + "';";
        // Ejecuta la sentencia
        actualiza(sql);
    }

    /**
     * Este método permite borrar un renglón de la tabla con los atributos de
     * los objetos de la clase Pelicula.
     *
     * @param pelicula Pelicula a borrar
     * @throws PersistenciaException Si no puede acceder a la base de datos
     */
    public void elimina(Pelicula pelicula) throws PersistenciaException {
        String sql = "";
        // Crea la sentencia para borrar.
        // La sentencia debe terminar en un ;
        sql += "DELETE FROM " + nomTabla;
        sql += " WHERE clave = '" + pelicula.getClave() + "';"; // Ejecuta la sentencia
        actualiza(sql);
    }

    /**
     * Este método permite consultar la tabla con los atributos de los objetos
     * de la clase Pelicula usando el comando de consulta dado por el parámetro.
     *
     * @param sql Comando de consulta dado por el parámetro.
     * @return Un vector con la lista de los objetos del tipo Pelicula de la
     * tabla
     * @throws PersistenciaException Si no puede acceder a la base de datos
     */
    public Vector lista(String sql) throws PersistenciaException {
        ResultSet renglon;
        Vector lista = new Vector();
        // Ejecuta la consulta
        consulta(sql);
        // Mientras haya peliculaes en la tabla
        while ((renglon = obtenRenglon()) != null) {
            try {
                // Crea un objeto del tipo Pelicula con los campos del renglon de la
                // tabla.
                Pelicula pelicula = new Pelicula(renglon.getString("clave"),
                        renglon.getString("titulo"),
                        new Genero(renglon.getString("cveGenero")),
                        renglon.getString("actor1"),
                        renglon.getString("actor2"),
                        renglon.getString("director"),
                        renglon.getInt("duracion"),
                        new Fecha(renglon.getDate("fecha")));
                // Agrega la película al vector de película
                lista.add(pelicula);
            } catch (SQLException sqle) {
                throw new PersistenciaException("Error al acceder a la base de datos", sqle);
            }
        }
        return lista;
    }

    /**
     * Este método permite consultar la tabla con los atributos de los objetos
     * de la clase Pelicula.
     *
     * @return Un vector con la lista de los objetos del tipo Pelicula de la
     * tabla
     * @throws PersistenciaException Si no puede acceder a la base de datos
     */
    public Vector lista() throws PersistenciaException {
        String sql = "SELECT * FROM " + nomTabla + ";";
        return lista(sql);
    }

}
