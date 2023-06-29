public class Main {
    public static void main(String[] args) throws NullReparacion, CocheException {

        CocheTodoterreno l = new CocheTodoterreno("Dacia", "Y56", "gh6556", EstadoCoche.enVenta);

        l.cocheEnReparacion();

        Reparacion r = new Reparacion(TipoReparacion.electrica, false);
        l.anyadirReparacion(r);
        r.reparacionInfo();
        r.cocheReparado();
        r.reparacionInfo();


        Reparacion t = new Reparacion(TipoReparacion.deChapa, false);
        l.anyadirReparacion(t);

        Reparacion j = new Reparacion(TipoReparacion.revision, false);












    }
}