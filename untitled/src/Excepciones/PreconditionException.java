package Excepciones;

public class PreconditionException extends Exception { //Incluye Invalid, Null e IsEmpty
    public PreconditionException(String message) {
        super(message);
    }
}
