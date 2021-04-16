package Fachadas;

/**
 *
 * @author 133739 - 116462
 */
public class FachadaException extends Exception {

    /**
     *
     * @param message
     * @param e
     */
    public FachadaException(String message, Exception e) {
        super(message, e);
    }

    /**
     *
     * @param message
     */
    public FachadaException(String message) {
        super(message);
    }
}
