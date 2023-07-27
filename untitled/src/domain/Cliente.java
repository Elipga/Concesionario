package domain;

import Excepciones.InvalidException;
import Excepciones.IsEmptyException;
import Excepciones.NotExistsException;
import Excepciones.NullException;

import java.util.ArrayList;

public class Cliente extends Persona {

    public ArrayList<Coche> cochesComprados;
    public ArrayList<Coche> cochesReservados;

    public Cliente(String nombre, String direccion, String dni, String telefono) throws IsEmptyException, NullException, InvalidException {
        super(nombre, direccion, dni, telefono);
        this.cochesComprados = new ArrayList<>();
        this.cochesReservados = new ArrayList<>();
    }

    public void anyadirCocheComprado(Coche c){
        cochesComprados.add(c);
    }

    public void anyadirCocheReservado(Coche c){
        cochesReservados.add(c);
    }

    public void imprimirCochesRservados() {
        for(Coche item: cochesReservados){
            System.out.println(item.toStringCoche());
        }
        if (cochesReservados.isEmpty()) System.out.println("El vendedor todavía no ha reservado ningún coche");
    }

    public void imprimirCochesComprados() {
        for(Coche item: cochesComprados){
            System.out.println(item.toStringCoche());
        }
        if (cochesComprados.isEmpty()) System.out.println("El vendedor todavía no ha comprado ningún coche");
    }

    public void borrarCocheReservado(Coche c) {
        cochesReservados.remove(c);
    }

    /*public Coche buscarCocheReservado(String matricula){
        for (Coche coche : cochesReservados) {
            if (coche.getMatricula().equals(coche.getMatricula())) {
                return coche;
            }
        }
        return new NotExistsException("El coche no se encuentra reservado");
    }*/

}
