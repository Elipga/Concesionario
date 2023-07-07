public class Main {
    public static void main(String[] args) throws IsEmptyException, NotNullException, InvalidException {

        CocheTodoterreno l = new CocheTodoterreno("Dacia", "Y56", "gh6556", EstadoCoche.enVenta, 23,43);
        CocheTodoterreno k = new CocheTodoterreno("Dacia", "Y56", "ksdjffs", EstadoCoche.enVenta,23,45);
        CocheTodoterreno u = new CocheTodoterreno("Dacia", "Y56", "okdnn", EstadoCoche.enVenta,23,65);
        CocheIndustrial o = new CocheIndustrial("Dacia", "Y56", "okdnn", EstadoCoche.enVenta,76,56);
        CocheTurismo p = new CocheTurismo("Dacia", "Y56", "okdnn", EstadoCoche.enVenta,65,78);


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
        c.anyadirCoche("Coche 3", u);
        c.anyadirCoche("Coche 4", o);
        c.anyadirCoche("Coche 5", p);

        //c.historialCoches();
        c.historialCochesEnVenta();

    }


}