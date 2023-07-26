import Excepciones.*;
import Formularios.ProgramaFinal;
import domain.Concesionario;

public class Main {
    public static void main(String[] args) throws IsEmptyException, NullException, InvalidException, AlreadyExistsException, NotExistsException {
        System.out.println("**************");
        System.out.println("Bienvenido/a:");
        System.out.println("**************");
        System.out.println("Siempre que se pida pulsar una tecla debe pulsar la tecla + Enter");
        System.out.println("--------------");
        ProgramaFinal p = new ProgramaFinal(new Concesionario());
        p. startPrograma();
    }
}