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

        c.anyadirCoche("Coche 1", l);
        c.anyadirCoche("Coche 2", k);

        c.anyadirExposicion("Exposicion 1", a);
        c.historialCochesEnVenta();

        a.anyadirCocheAExposicion(l);

        a.visualizarCochesExposicion();
        a.visualizarExposicion();


    }
}