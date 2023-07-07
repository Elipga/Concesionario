import java.util.ArrayList;
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
        for (String clave:cochesConcesionario.keySet()) {
            Coche valor = cochesConcesionario.get(clave);
            System.out.println(clave + valor.toStringCoche());
        }
    }

    public void historialCochesEnVenta() {
        System.out.println("Listado coches en venta");
        HashSet<Coche> cochesEnVenta = new HashSet<>();
        for (Coche valor:cochesConcesionario.values()) {
            if (valor.getEstado() == EstadoCoche.enVenta){
                cochesEnVenta.add(valor);
                System.out.println(valor + valor.toStringCoche());
            }
        }
    }

    public void historialCochesReservados() {
        System.out.println("Listado coches Reservados");
        for (Coche valor:cochesConcesionario.values()) {
            if (valor.getEstado() == EstadoCoche.reservado)
                System.out.println(valor + valor.toStringCoche());
        }
    }

    public void historialCochesEnReparacion() {
        System.out.println("Listado coches en reparación");
        for (Coche valor:cochesConcesionario.values()) {
            if (valor.getEstado() == EstadoCoche.enReparacion)
                System.out.println(valor + valor.toStringCoche());
        }
    }

    public void historialCochesVendidos() {
        System.out.println("Listado coches vendidos");
        for (Coche valor:cochesConcesionario.values()) {
            if (valor.getEstado() == EstadoCoche.vendido)
                System.out.println(valor + valor.toStringCoche());
        }
    }

}
