package domain;

import Excepciones.AlreadyExistsException;
import Excepciones.InvalidException;
import Excepciones.IsEmptyException;
import Excepciones.NotNullException;

import java.util.ArrayList;

public class Vendedor extends Persona{
    public ArrayList<Coche> cochesVendidos;

    private double sueldo;

    public Vendedor(String nombre, String direccion, String dni, String telefono) throws IsEmptyException, NotNullException, InvalidException {
        super(nombre, direccion, dni, telefono);
        this.cochesVendidos = new ArrayList<Coche>();
    }



    public double sueldoVendedor(){
        double sueldo = 1000;
        sueldo = sueldo + cochesVendidos.size() * 200;
        cuantosCochesVendidos();
        return sueldo;
    }

    public void cuantosCochesVendidos(){
        System.out.println("El vendedor ha vendido " + cochesVendidos.size() + "coches");
    }

    public void venderCoche(Coche c) throws AlreadyExistsException {
        for (Coche item:cochesVendidos){
            if (c.getMatricula() == item.getMatricula()) throw new AlreadyExistsException("El coche ya ha sido vendido");
        }
        cochesVendidos.add(c);
    }

    public void imprimirCochesVendidos() {

    }
}
