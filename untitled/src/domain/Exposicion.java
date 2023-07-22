package domain;

import Excepciones.AlreadyExistsException;
import Excepciones.InvalidException;
import Excepciones.IsEmptyException;
import Excepciones.NotNullException;

import java.util.HashSet;

public class Exposicion {
    private String numeroExposcion;
    private String direccion;
    private String telefono;
    private HashSet<Coche> cochesEnExposicion;
    private Concesionario conce;


    public Exposicion(String numeroExposcion, String direccion, String telefono) throws NotNullException, IsEmptyException, InvalidException {
        this.numeroExposcion = numeroExposcion;
        if(numeroExposcion == null) throw new NotNullException("Número de exposición no puede ser null");
        if(numeroExposcion == "") throw new IsEmptyException("Número de exposición no puede estar vacío");
        this.direccion = direccion;
        if(direccion == null) throw new NotNullException("Dirección no puede ser null");
        if(direccion == "") throw new IsEmptyException("Dirección no puede estar vacía");
        this.telefono = telefono;
        if(telefono == null) throw new NotNullException("Teléfono no puede ser null");
        if(telefono == "") throw new IsEmptyException("Teléfono no puede estar vacío");
        if((telefono.length() != 9)) throw new InvalidException("Teléfono debe tener 9 dígitos");
        this.cochesEnExposicion = new HashSet<Coche>();
        this.conce = new Concesionario(); //?? poner el concesionario por defecto al principio del programa
    }


    public String toStringExposicion() {
        return "domain.Exposicion{" +
                "numeroExposcion=" + numeroExposcion +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    public String getNumeroExposcion() {
        return numeroExposcion;
    }

    public void anyadirCocheAExposicion (Coche c) throws AlreadyExistsException {
        if(bucarCocheExposicion(c) == c) throw new AlreadyExistsException("El coche ya está en la exposicion");
        cochesEnExposicion.add(c);
    }

    public void borrarCocheExposicion(Coche c) throws AlreadyExistsException {
        if (bucarCocheExposicion(c) == null) throw new AlreadyExistsException("El coche no se encuentra en la exposición");
        cochesEnExposicion.remove(c);
    }

    public void visualizarExposicion(){
        System.out.println(toStringExposicion());
    }

    public void visualizarCochesExposicion(){
        for(Coche item: cochesEnExposicion){
            System.out.println(item.toStringCoche());
        }
    }


    public void ubicacionCocheExposicion(Coche c){
        for(Coche item: cochesEnExposicion){
            if (c.getMatricula() == item.getMatricula()){
                System.out.println("El coche se encuentra en la exposicion: " + numeroExposcion);
                break;
            }
            else System.out.println("El coche no está en la exposición");
        }
    }

    public Coche bucarCocheExposicion(Coche c){
        for(Coche item: cochesEnExposicion){
            if (c.getMatricula() == item.getMatricula())
                return c;
        }
        return null;
    }
}
