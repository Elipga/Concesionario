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

    //Getters y to String para imprimir el historial de reparaciones
    public TipoReparacion getTipoReparacion() {

        return tipo;
    }

    public Date getFechaReparacion() {
        return fechaReparacion;
    }

    public boolean isResuelta() {

        return resuelta;
    }

    @Override
    public String toString() {
        return "Reparacion{" +
                "tipo=" + tipo +
                ", resuelta=" + resuelta +
                ", fechaReparacion=" + fechaReparacion +
                '}';
    }

    //Metodo cuando un coche está reparado

    public boolean cocheReparado() {
        //cambiar tambien el estado a reparado

        return resuelta = true;

    }

}
