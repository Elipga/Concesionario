public class Main {
    public static void main(String[] args) throws NullReparacion, CocheException {

        CocheTodoterreno l = new CocheTodoterreno("Dacia", "Y56", "gh6556", EstadoCoche.enVenta);
        CocheTodoterreno k = new CocheTodoterreno("Dacia", "Y56", "ksdjffs", EstadoCoche.enVenta);
        CocheTodoterreno u = new CocheTodoterreno("Dacia", "Y56", "okdnn", EstadoCoche.enVenta);



        Reparacion r = new Reparacion(TipoReparacion.electrica, false);
        l.anyadirReparacion(r);
        r.cocheReparado();


        Reparacion t = new Reparacion(TipoReparacion.deChapa, false);
        l.anyadirReparacion(t);

        Reparacion j = new Reparacion(TipoReparacion.revision, false);

        l.anyadirReparacion(j);

        Reparacion s = new Reparacion(TipoReparacion.electrica, true);
        l.anyadirReparacion(s);

        Reparacion w = new Reparacion(TipoReparacion.deChapa, false);
        l.anyadirReparacion(w);


        l.historialReparaciones();

        System.out.println("-------------");

        w.cocheReparado();

        l.historialReparaciones();

        l.estadoCoche();

        Exposicion e = new Exposicion(1,"hjk", "67895678");

        e.anyadirCocheAExposicion(l);
        e.anyadirCocheAExposicion(k);
        e.anyadirCocheAExposicion(u);


        e.borrarCocheExposicion(l);

        e.visualizarExposicion();
        e.visualizarCochesExposicion();

        e.ubicacionExposicion(k);




    }


}