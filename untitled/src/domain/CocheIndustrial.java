package domain;

import Excepciones.InvalidException;
import Excepciones.IsEmptyException;
import Excepciones.NotNullException;

public class CocheIndustrial extends Coche {

    public CocheIndustrial(String marca, String modelo, String matricula, double precioCompra, double precioVenta) throws NotNullException, IsEmptyException, InvalidException {
        super(marca, modelo, matricula, precioCompra, precioVenta);
    }




}

