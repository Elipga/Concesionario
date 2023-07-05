import java.util.*;

abstract class Coche {
    private String marca;
    private String modelo;
    private String matricula;
    private double precioCompra;
    private double precioVenta;
    private EstadoCoche estado;
    private LinkedList<Reparacion> reparaciones;



    public Coche(String marca, String modelo, String matricula, EstadoCoche estado) throws NullReparacion, CocheException {
        this.marca = marca;
        if(marca == null) throw new CocheException("La marca no puede ser null");
        if(marca == "") throw new CocheException("La marca no puede estar vacía");
        this.modelo = modelo;
        if(modelo == null) throw new CocheException("El modelo no puede ser null");
        if(modelo == "") throw new CocheException("El modelo no puede estar vacío");
        this.matricula = matricula;
        if(matricula == null) throw new CocheException("La matrícula no puede ser null");
        if(matricula == "") throw new CocheException("La matrícula no puede estar vacía");
        this.estado = estado;
        if(estado == null) throw new CocheException("El estado no puede ser null");
        this.reparaciones = new LinkedList<>();
        if (this.reparaciones == null) throw new NullReparacion("El array no puede ser null");
    }


    public String toStringCoche() {
        return "Coche{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", estado=" + estado +
                '}';
    }

    public String getMatricula() {
        return matricula;
    }

    //metodo para añadir una reparacion al arraylist

    public void anyadirReparacion(Reparacion r){

        reparaciones.add(r);
        estado= EstadoCoche.enReparacion;
    }

    //metodo para cambiar el estado de un coche a en reparacion


    public void estadoCoche() {
        if (estado == EstadoCoche.enVenta) {
            System.out.println("El coche se encuentra en venta");
        }
        if(estado == EstadoCoche.enReparacion){
            System.out.println("El coche se encuentra en reparación");
        }
        if(estado == EstadoCoche.vendido){
            System.out.println("El coche se encuentra vendido");
        }

        if(estado == EstadoCoche.reservado){
            System.out.println("El coche se encuentra reservado");
        }
    }

    public void historialReparaciones() {

            Comparator<Reparacion> comparador = new Comparator<Reparacion>() {
                public int compare(Reparacion reparacion1, Reparacion reparacion2) {
                    return reparacion1.getFechaReparacion().compareTo(reparacion2.getFechaReparacion());
                }
            };

            Collections.sort(reparaciones, comparador);

            for(Reparacion item: reparaciones){
                System.out.println(item.toString());

            }
    }


}
