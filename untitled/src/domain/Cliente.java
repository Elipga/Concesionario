package domain;

import Excepciones.InvalidException;
import Excepciones.IsEmptyException;
import Excepciones.NullException;

import java.util.ArrayList;

public class Cliente extends Persona {

    public ArrayList<Coche> cochesComprados;
    public ArrayList<Coche> cochesReservados;

    public Cliente(String nombre, String direccion, String dni, String telefono) throws IsEmptyException, NullException, InvalidException {
        super(nombre, direccion, dni, telefono);
        this.cochesComprados = cochesComprados;
    }
}
