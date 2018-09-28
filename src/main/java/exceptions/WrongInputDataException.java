package exceptions;

public class WrongInputDataException extends Exception {

    public WrongInputDataException() {
        super("Incorrect values in the data being read!");
    }
}