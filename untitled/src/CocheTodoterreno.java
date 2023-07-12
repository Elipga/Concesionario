public class CocheTodoterreno extends Coche{

    public CocheTodoterreno(String marca, String modelo, String matricula, double precioCompra, double precioVenta) throws NotNullException, IsEmptyException, InvalidException {
        super(marca, modelo, matricula, precioCompra, precioVenta);
    }

    public CocheTodoterreno(String marca, String modelo, String matricula, TipoCoche tipocoche, double precioCompra, double precioVenta) throws InvalidException, IsEmptyException, NotNullException {
        super(marca, modelo, matricula, tipocoche, precioCompra, precioVenta);
    }

    public CocheTodoterreno() throws InvalidException, IsEmptyException, NotNullException {
    }
}
