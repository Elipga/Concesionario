package domain;

import Excepciones.InvalidException;
import Excepciones.IsEmptyException;
import Excepciones.NullException;

import java.util.Date;

public class Reparacion {
    private TipoReparacion tipoReparacion;
    private boolean resuelta;

    private Date fechaReparacion;


    public Reparacion(TipoReparacion tipoReparacion, boolean resuelta) throws NullException, IsEmptyException, InvalidException {
        this.tipoReparacion = tipoReparacion;
        if(tipoReparacion == null) throw new NullException("Tipo de reparación no puede ser null");
        if(tipoReparacion.equals("")) throw new IsEmptyException("Tipo de reparación no puede estar vacío");
        this.resuelta = resuelta;
        if((resuelta != true) && (resuelta != false)) throw new InvalidException("Resuelta debe ser true o false");
        this.fechaReparacion = new Date();
    }

    //setter para el metodo reparacionReparada de la clase coche

    public void setResuelta(boolean resuelta) {
        this.resuelta = resuelta;
    }



    //Getters y to String para imprimir el historial de reparaciones
    public TipoReparacion getTipoReparacion() {

        return tipoReparacion;
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
                "tipo=" + tipoReparacion +
                ", resuelta=" + resuelta +
                ", fechaReparacion=" + fechaReparacion +
                '}';
    }

    //Metodo cuando un coche está reparado



}
