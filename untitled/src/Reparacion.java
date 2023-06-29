import java.util.Date;

public class Reparacion {
    private TipoReparacion tipo;
    private boolean resuelta;

    private Date fechaReparacion;


    public Reparacion(TipoReparacion tipo, boolean resuelta) {
        this.tipo = tipo;
        this.resuelta = resuelta;
        this.fechaReparacion = new Date();
    }


    //Getters para imprimir el historial de reparaciones
    public TipoReparacion getTipoReparacion() {

        return tipo;
    }

    public boolean isResuelta() {

        return resuelta;
    }

    //Metodo cuando un coche está reparado

    public boolean cocheReparado() {
        //cambiar tambien el estado a reparado
        return resuelta = true;
    }

    //Metodo para conocer la informacion de una reparacion (LO HE PUESTO PARA COMPROBAR: NO LO PIDE EL ENUNCIADO)

    public void reparacionInfo() {
        System.out.println(tipo);
        System.out.println(resuelta);
    }

}
