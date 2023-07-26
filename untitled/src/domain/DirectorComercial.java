package domain;

import Excepciones.InvalidException;
import Excepciones.IsEmptyException;
import Excepciones.NullException;

public class DirectorComercial extends Persona{


    public DirectorComercial(String nombre, String direccion, String dni, String telefono) throws IsEmptyException, NullException, InvalidException {
        super(nombre, direccion, dni, telefono);
    }


}
