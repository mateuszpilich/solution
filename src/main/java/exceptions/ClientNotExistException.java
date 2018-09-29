package exceptions;

public class ClientNotExistException extends Exception {

    public ClientNotExistException() {
        super("Client with the given id is not exist!");
    }
}
