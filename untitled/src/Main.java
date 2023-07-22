import Excepciones.*;
import domain.Concesionario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IsEmptyException, NotNullException, InvalidException, AlreadyExistsException, NotExistsException {
        ProgramaFinal p = new ProgramaFinal(new Concesionario());
        p. startPrograma();
    }

}