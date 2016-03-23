package edu.uniandes.lospropios.resources.exceptions;

/**
 * Representa las excepciones de la lógica de CityLogic
 */
public class PerfilLogicException extends Exception {

    /**
     * versión usada en la serialización de la clase
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor con un mensaje
     *
     * @param message mensaje de la excepción
     */
    public PerfilLogicException(String message) {
        super(message);
    }

    /**
     * Constructor con una causa
     *
     * @param cause causa de la excepción. Usada para generar la traza.
     */
    public PerfilLogicException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor con mensaje y causa.
     *
     * @param message mensaje de la excepción
     * @param cause causa de la excepción. Usada para generar la traza.
     */
    public PerfilLogicException(String message, Throwable cause) {
        super(message, cause);
    }

}
