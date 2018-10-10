package exceptions;

/**
 * The class helps user understand that data in this file is incorrect.
 */
public class WrongInputDataException extends Exception {

    /**
     * This is constructor wrong input data exception.
     *
     * @param message is message for user
     */
    public WrongInputDataException(final String message) {
        super(message);
    }
}
