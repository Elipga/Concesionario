public class CocheTurismo extends Coche{

    public CocheTurismo(String marca, String modelo, String matricula, EstadoCoche estado, double precioCompra, double precioVenta) throws NotNullException, IsEmptyException, InvalidException {
        super(marca, modelo, matricula, estado, precioCompra, precioVenta);
    }
}

