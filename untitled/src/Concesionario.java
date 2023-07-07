import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Concesionario {
    private HashMap<String,Coche> cochesConcesionario;

    public Concesionario() {
        this.cochesConcesionario = new HashMap<String,Coche>();
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
            //    throw new AlreadyExists("El coche ya está introducido");
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
        HashSet<Coche> cochesEnVenta = new HashSet<>();
        for (Coche valor:cochesConcesionario.values()) { //se obtienen los valores de cada coche
            if (valor.getEstado() == EstadoCoche.enVenta){ // si el estado es enVenta se añade al HashSet y se imprime
                cochesEnVenta.add(valor);
                System.out.println(valor.toStringCoche());
            }
        }
    }

    public void historialCochesReservados() {
        System.out.println("Listado coches Reservados");
        HashSet<Coche> cochesReservados = new HashSet<>();
        for (Coche valor:cochesConcesionario.values()) {
            if (valor.getEstado() == EstadoCoche.reservado) {
                cochesReservados.add(valor);
                System.out.println(valor.toStringCoche());
            }
        }
    }

    public void historialCochesEnReparacion() {
        System.out.println("Listado coches en reparación");
        HashSet<Coche> cochesEnReparacion = new HashSet<>();
        for (Coche valor:cochesConcesionario.values()) {
            if (valor.getEstado() == EstadoCoche.enReparacion){
                cochesEnReparacion.add(valor);
                System.out.println(valor.toStringCoche());
            }
        }
    }

    public void historialCochesVendidos() {
        System.out.println("Listado coches vendidos");
        HashSet<Coche> cochesVendidos = new HashSet<>();
        for (Coche valor:cochesConcesionario.values()) {
            if (valor.getEstado() == EstadoCoche.vendido){
                cochesVendidos.add(valor);
                System.out.println(valor.toStringCoche());
            }
        }
    }

}
