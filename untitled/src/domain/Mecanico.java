package domain;

import Excepciones.InvalidException;
import Excepciones.IsEmptyException;
import Excepciones.NotNullException;

public class Mecanico  extends Persona {
    public Mecanico(String nombre, String direccion, String dni, String telefono) throws IsEmptyException, NotNullException, InvalidException {
        super(nombre, direccion, dni, telefono);
    }
}
