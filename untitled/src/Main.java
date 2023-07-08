public class Main {
    public static void main(String[] args) throws IsEmptyException, NotNullException, InvalidException {

        CocheTodoterreno l = new CocheTodoterreno("Dacia", "Y56", "gh6556", EstadoCoche.enVenta, 23,43);
        CocheTodoterreno k = new CocheTodoterreno("Dacia", "Y56", "ksdjffs", EstadoCoche.enVenta,23,45);
        CocheTodoterreno u = new CocheTodoterreno("Dacia", "Y56", "okdnn", EstadoCoche.enVenta,23,65);
        CocheIndustrial o = new CocheIndustrial("Dacia", "Y56", "okdnn", EstadoCoche.enVenta,76,56);
        CocheTurismo p = new CocheTurismo("Dacia", "Y56", "okdnn", EstadoCoche.reservado,65,78);


        Reparacion r = new Reparacion(TipoReparacion.electrica, false);
        Reparacion e = new Reparacion(TipoReparacion.deChapa, false);

        Exposicion a = new Exposicion("1", "francisco Aguirre", "678947362");

        Concesionario c = new Concesionario();

        c.anyadirExposicion("Exposicion 1", a);

        l.anyadirAExposicion(a);


    }
}