public class Main {
    public static void main(String[] args) throws IsEmptyException, NotNullException, InvalidException {

        CocheTodoterreno l = new CocheTodoterreno("Dacia", "Y56", "gh6556", EstadoCoche.enVenta);
        CocheTodoterreno k = new CocheTodoterreno("Dacia", "Y56", "ksdjffs", EstadoCoche.enVenta);
        CocheTodoterreno u = new CocheTodoterreno("Dacia", "Y56", "okdnn", EstadoCoche.enVenta);


        Reparacion r = new Reparacion(TipoReparacion.electrica, false);
        Reparacion e = new Reparacion(TipoReparacion.deChapa, false);

        l.anyadirReparacion(r);
        l.anyadirReparacion(e);

        l.reparacionReparada(r);
        l.reparacionReparada(e);

        l.historialReparaciones();

        Concesionario c = new Concesionario();

        c.anyadirCoche("coche 1", l);
        c.anyadirCoche("coche 2", k);

        c.historialCoches();

    }


}