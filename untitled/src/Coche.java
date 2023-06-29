import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

abstract class Coche {
    private String marca;
    private String modelo;
    private String matricula;
    private double precioCompra;
    private double precioVenta;
    private EstadoCoche estado;
    ArrayList<Reparacion> reparaciones;

    public Coche(String marca, String modelo, String matricula, EstadoCoche estado) throws NullReparacion {
        this.marca = marca;
        if(marca == null) throw new CocheException("Debe introducir la marca");
        if(marca == )
        this.modelo = modelo;
        this.matricula = matricula;
        this.estado = estado;
        this.reparaciones = new ArrayList<>();
        //if (this.reparaciones == null) throw new NullReparacion("El array no puede ser null");
    }

    //metodo para añadir una reparacion al arraylist

    public void anyadirReparacion(Reparacion r){
        reparaciones.add(r);
    }

    //metodo para cambiar el estado de un coche a en reparacion

    public void cocheEnReparacion() {
        estado = EstadoCoche.enReparacion;
        System.out.println("El coche se encuentra en reparación");
    }

    //Consultar reparaciones de un coche

    /*public void historialReparaciones() {

        Collections.sort( reparaciones, new Comparator<Reparacion>() {
            @Override
            public int compare(reparaciones r1, reparaciones r2) {
                return new Integer(p1.getDate()).compareTo(new Integer(p2.getDate()));
            }
        });

        for(Reparacion item: reparaciones){
            System.out.println(item.toString());
            //System.out.println(item.getTipoReparacion());
            //System.out.println(item.isResuelta());
        }
    }*/

}
