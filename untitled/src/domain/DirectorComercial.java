package domain;

import Excepciones.InvalidException;
import Excepciones.IsEmptyException;
import Excepciones.NotNullException;

public class DirectorComercial extends Persona{


    public DirectorComercial(String nombre, String direccion, String dni, String telefono) throws IsEmptyException, NotNullException, InvalidException {
        super(nombre, direccion, dni, telefono);
    }


}
