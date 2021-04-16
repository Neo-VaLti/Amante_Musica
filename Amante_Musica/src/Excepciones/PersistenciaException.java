package Excepciones;

/**
 *
 * @author 133739 - 116462  
 */
public class PersistenciaException extends Exception {

    /**
     *
     * @param message
     * @param e
     */
    public PersistenciaException(String message, Exception e) {
        super(message, e);
    }
}
