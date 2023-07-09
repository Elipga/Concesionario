import java.util.*;

abstract class Coche {
    private String marca;
    private String modelo;
    private String matricula;
    private double precioCompra;
    private double precioVenta;
    private EstadoCoche estado;
    private LinkedList<Reparacion> reparaciones;


    //Constructor y validaciones
    public Coche(String marca, String modelo, String matricula, EstadoCoche estado, double precioCompra, double precioVenta) throws NotNullException, IsEmptyException, InvalidException {
        this.marca = marca;
        if(marca == null) throw new NotNullException("La marca no puede ser null");
        if(marca == "") throw new IsEmptyException("La marca no puede estar vacía");
        this.modelo = modelo;
        if(modelo == null) throw new NotNullException("El modelo no puede ser null");
        if(modelo == "") throw new IsEmptyException("El modelo no puede estar vacío");
        this.matricula = matricula;
        if(matricula == null) throw new NotNullException("La matrícula no puede ser null");
        if(matricula == "") throw new IsEmptyException("La matrícula no puede estar vacía");
        this.estado = estado;
        if(estado == null) throw new NotNullException("El estado no puede ser null");
        this.precioCompra = precioCompra;
        if(precioCompra < 0) throw new InvalidException("El precio de compra debe ser superior a 0");
        this.precioVenta = precioVenta;
        if(precioVenta < 0) throw new InvalidException("El precio de venta debe ser superior a 0");
        this.reparaciones = new LinkedList<>();
        if (this.reparaciones == null) throw new NotNullException("El array no puede ser null");
    }

    //ToString para imprimir los atributos de los coches

    public String toStringCoche() {
        return "Coche{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", precioCompra=" + precioCompra +
                ", precioVenta=" + precioVenta +
                ", estado=" + estado +
                '}';
    }

    public String getMatricula() {

        return matricula;
    }

    public EstadoCoche getEstado() {
        return estado;
    }
    //metodo para añadir una reparacion al arraylist

    public void anyadirReparacion(Reparacion r){
        reparaciones.add(r);
        estado= EstadoCoche.enReparacion;
    }

    //metodo para saber el estado de un coche

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

    //Método para obtener el historial de reparaciones ordenados por fecha

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

    public void reparacionReparada(Reparacion r) {
        //cambiar tambien el estado a reparado
        r.setResuelta(true);

        int contador = 0;
        for (Reparacion item: reparaciones){
            if(item.isResuelta()==true){
                contador = contador + 1;
            };
            if (contador == reparaciones.size()){
                estado= EstadoCoche.reparado;
            }
        }
    }
}
