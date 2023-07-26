package domain;

import Excepciones.InvalidException;
import Excepciones.IsEmptyException;
import Excepciones.NullException;

public class CocheTodoterreno extends Coche {

    public CocheTodoterreno(String marca, String modelo, String matricula, double precioCompra, double precioVenta) throws NullException, IsEmptyException, InvalidException {
        super(marca, modelo, matricula, precioCompra, precioVenta);
    }
}
