import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Concesionario {
    private HashMap<String,Coche> cochesConcesionario;
    private HashMap<String,Exposicion> exposiciones;

    public Concesionario() {
        this.cochesConcesionario = new HashMap<String,Coche>();
        this.exposiciones = new HashMap<String, Exposicion>();

    }


    public HashMap<String, Coche> getCochesConcesionario() {
        return cochesConcesionario;
    }

    public String toStringCoches() {
        return "Concesionario{" +
                "cochesConcesionario=" + cochesConcesionario +
                '}';
    }

    public void anyadirCoche(String coche, Coche c){
        //for (Coche valor:cochesConcesionario.values())
          //  if (valor.getMatricula() == c.getMatricula()) {
            //    throw new AlreadyExistsException("El coche ya está introducido");
              //  break;
            //}
        cochesConcesionario.put(coche,c);
    }

    public void historialCoches(){
        for (String clave:cochesConcesionario.keySet()) { //se obtienen las claves
            Coche valor = cochesConcesionario.get(clave);
            System.out.println(clave + valor.toStringCoche());
        }
    }

    public void historialCochesEnVenta() {
        System.out.println("Listado coches en venta");
        for (Coche valor:cochesConcesionario.values()) { //se obtienen los valores de cada coche
            if (valor.getEstado() == EstadoCoche.enVenta){ //si el estado es enVenta se añade al HashSet y se imprime
                System.out.println(valor.toStringCoche());
            }
        }
    }

    public HashSet<Coche> listaCochesEnVenta() {
        HashSet<Coche> cochesEnVenta = new HashSet<>();
        for (Coche valor:cochesConcesionario.values()) { //se obtienen los valores de cada coche
            if (valor.getEstado() == EstadoCoche.enVenta){ // si el estado es enVenta se añade al HashSet y se imprime
                cochesEnVenta.add(valor);
                valor.toStringCoche();
            }
        }
        return cochesEnVenta;
    }

    public void historialCochesReservados() {
        System.out.println("Listado coches Reservados");
        for (Coche valor:cochesConcesionario.values()) { //se obtienen los valores de cada coche
            if (valor.getEstado() == EstadoCoche.reservado){ //si el estado es enVenta se añade al HashSet y se imprime
                System.out.println(valor.toStringCoche());
            }
        }
    }

    public HashSet<Coche> listaCochesReservados() {
        HashSet<Coche> cochesReservados = new HashSet<>();
        for (Coche valor:cochesConcesionario.values()) {
            if (valor.getEstado() == EstadoCoche.reservado){
                cochesReservados.add(valor);
                valor.toStringCoche();
            }
        }
        return cochesReservados;
    }

    public void historialCochesEnReparacion() {
        System.out.println("Listado coches en reparación");
        for (Coche valor:cochesConcesionario.values()) {
            if (valor.getEstado() == EstadoCoche.enReparacion){
                System.out.println(valor.toStringCoche());
            }
        }
    }

    public HashSet<Coche> listaCochesEnReparacion() {
        HashSet<Coche> cochesEnReparacion = new HashSet<>();
        for (Coche valor:cochesConcesionario.values()) {
            if (valor.getEstado() == EstadoCoche.enReparacion){
                cochesEnReparacion.add(valor);
                valor.toStringCoche();
            }
        }
        return cochesEnReparacion;
    }

    public void historialCochesVendidos() {
        System.out.println("Listado coches vendidos");
        for (Coche valor:cochesConcesionario.values()) {
            if (valor.getEstado() == EstadoCoche.vendido){
                System.out.println(valor.toStringCoche());
            }
        }
    }

    public HashSet<Coche> listaCochesVendidos() {
        HashSet<Coche> cochesVendidos= new HashSet<>();
        for (Coche valor:cochesConcesionario.values()) {
            if (valor.getEstado() == EstadoCoche.vendido){
                cochesVendidos.add(valor);
                valor.toStringCoche();
            }
        }
        return cochesVendidos;
    }

    public void anyadirExposicion(String exposicion, Exposicion e){
        exposiciones.put(exposicion, e);
    }

    public void borrarExposicion(String exposicion, Exposicion e){
        exposiciones.remove(exposicion, e);
    }

    /*public void anyadirCocheAExposicion(Coche c){
        HashSet<Coche> cochesEnExposicion= new HashSet<>();
        for (Coche item:listaCochesEnVenta()){
            if (c.getMatricula() == item.getMatricula()){
                cochesEnExposicion.add(c);
            }
        }
        //buscar coche en hashmap lista coches en venta
        //añadir coche a lista coches de X exposicion
    }*/
}
