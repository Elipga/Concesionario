public class CocheIndustrial extends Coche {

    public CocheIndustrial(String marca, String modelo, String matricula, EstadoCoche estado, double precioCompra, double precioVenta) throws NotNullException, IsEmptyException, InvalidException {
        super(marca, modelo, matricula, estado, precioCompra, precioVenta);
    }
}

