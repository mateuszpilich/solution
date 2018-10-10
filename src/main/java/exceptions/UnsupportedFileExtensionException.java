package exceptions;

/**
 * The class helps user understand that extension of this file is unsupported.
 */
public class UnsupportedFileExtensionException extends Exception {

    /**
     * This is constructor unsupported file extension exception.
     * @param message is message for user
     */
    public UnsupportedFileExtensionException(final String message) {
        super(message);
    }
}
