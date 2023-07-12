public class CocheTurismo extends Coche{

    public CocheTurismo(String marca, String modelo, String matricula, double precioCompra, double precioVenta) throws NotNullException, IsEmptyException, InvalidException {
        super(marca, modelo, matricula, precioCompra, precioVenta);
    }

    public CocheTurismo(String marca, String modelo, String matricula, TipoCoche tipocoche, double precioCompra, double precioVenta) throws InvalidException, IsEmptyException, NotNullException {
        super(marca, modelo, matricula, tipocoche, precioCompra, precioVenta);
    }


    public CocheTurismo() throws IsEmptyException, InvalidException, NotNullException {
    }
}

