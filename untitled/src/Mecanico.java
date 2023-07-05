import java.util.ArrayList;
public class Mecanico  extends Persona {
    public Mecanico(String nombre, String direccion, String dni, int telefono) throws IsEmptyException, NotNullException {
        super(nombre, direccion, dni, telefono);
    }
}
