import java.util.HashMap;

public class Concesionario {
    private HashMap<String,Coche> cochesConcesionario;
    private HashMap<String,Coche> cochesEnVenta;
    private HashMap<String,Coche> cochesEnReparacion;
    private HashMap<String,Coche> cochesReservados;
    private HashMap<String,Coche> cochesVendidos;
    private HashMap<String,Exposicion> exposiciones;

    public Concesionario() {
        this.cochesConcesionario = new HashMap<>();
        this.cochesEnVenta = new HashMap<>();
        this.cochesEnReparacion = new HashMap<>();
        this.cochesReservados = new HashMap<>();
        this.cochesVendidos = new HashMap<>();
        this.exposiciones = new HashMap<>();
    }

    public HashMap<String, Coche> getCochesEnVenta() {
        return cochesEnVenta;
    }

    public HashMap<String, Coche> getCochesEnReparacion() {
        return cochesEnReparacion;
    }

    public HashMap<String, Coche> getCochesReservados() {
        return cochesReservados;
    }

    public HashMap<String, Coche> getCochesVendidos() {
        return cochesVendidos;
    }

    public String toStringCoches() {
        return "Concesionario{" +
                "cochesConcesionario=" + cochesConcesionario +
                '}';
    }

    public HashMap<String, Coche> getCochesConcesionario() {
        return cochesConcesionario;
    }

    public void anyadirCoche(String coche, Coche c) throws AlreadyExistsException {
        if (cochesConcesionario.containsKey(coche)) throw new AlreadyExistsException("El coche ya está en el concesionario");
        cochesConcesionario.put(coche,c);
    }

    public void anyadirCocheEnVenta(String coche, Coche c) throws AlreadyExistsException {
        if (cochesEnVenta.containsKey(coche)) throw new AlreadyExistsException("El coche ya está en venta");
        cochesEnVenta.put(coche, c);
    }

    public void anyadirCocheEnReparacion(String coche, Coche c) throws AlreadyExistsException {
        if (cochesEnVenta.containsKey(coche)) throw new AlreadyExistsException("El coche ya está en reparación");
        cochesEnReparacion.put(coche, c);
    }

    public void anyadirCocheReservado(String coche, Coche c) throws AlreadyExistsException {
        if (cochesEnVenta.containsKey(coche)) throw new AlreadyExistsException("El coche ya está reservado");
        cochesReservados.put(coche, c);
    }

    public void anyadirCocheVendido(String coche, Coche c) throws AlreadyExistsException {
        if (cochesEnVenta.containsKey(coche)) throw new AlreadyExistsException("El coche ya está vendido");
        cochesVendidos.put(coche, c);
    }

    public void cocheVendido(String coche, Coche c) {
        //comprobar que el coche esté en venta
        cochesEnVenta.remove(coche, c);
        cochesVendidos.put(coche, c);
    }

    public void imprimirCoches() {
        System.out.println("Listado coches");
        for (Coche valor:cochesConcesionario.values()) { //se obtienen los valores de cada coche
            System.out.println(valor.toStringCoche());
        }
    }

    public void imprimirEnVenta() {
        System.out.println("Listado coches en venta");
        for (Coche valor:cochesEnVenta.values()) { //se obtienen los valores de cada coche
            System.out.println(valor.toStringCoche());
        }
    }

    public void imprimirEnReparacion() {
        System.out.println("Listado coches en reparación");
        for (Coche valor:cochesEnReparacion.values()) { //se obtienen los valores de cada coche
            System.out.println(valor.toStringCoche());
        }
    }

    public void imprimirReservados() {
        System.out.println("Listado coches reservados");
        for (Coche valor:cochesReservados.values()) { //se obtienen los valores de cada coche
            System.out.println(valor.toStringCoche());
        }
    }

    public void imprimirVendidos() {
        System.out.println("Listado coches vendidos");
        for (Coche valor:cochesVendidos.values()) { //se obtienen los valores de cada coche
            System.out.println(valor.toStringCoche());
        }
    }

    public Coche buscarCoche(String matricula){
        if (cochesConcesionario.containsKey(matricula))
            return cochesConcesionario.get(matricula);
        else return null;
    }

    public Coche buscarCocheVenta(String matricula){
        if (cochesEnVenta.containsKey(matricula))
            return cochesEnVenta.get(matricula); //devuelve el valor asociado a la clave de la matricula
        else return null;
    }

    public Exposicion buscarExposicion(String numExposicion){
        if(exposiciones.containsKey(numExposicion))
            return exposiciones.get(numExposicion);
        else return null;
    }

    public void anyadirCocheAExposicion(String matricula, String numExposicion) {
        Coche c = buscarCocheVenta(matricula);
        Exposicion e = buscarExposicion(numExposicion);
        e.anyadirCocheAExposicion(c);
    }

    public void borrarCocheExposicion(Coche c, String numExposicion) {
        Exposicion e = buscarExposicion(numExposicion);
        c = e.bucarCocheExposicion(c);
        e.borrarCocheExposicion(c);
    }

    /*public void cambiarCocheExposicion(Coche c, String numExposicion) {
        Exposicion e = buscarExposicion(numExposicion);
        c = e.bucarCocheExposicion(c);


    }*/

    public void anyadirExposicion(String exposicion, Exposicion e){
        exposiciones.put(exposicion, e);
    }

    public void borrarExposicion(String exposicion, Exposicion e){
        exposiciones.remove(exposicion, e);
    }



    /*public void historialCoches(){
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
        HashMap<String, Coche> cochesEnVenta = new HashMap<>();
        for (Coche valor:cochesConcesionario.values()) { //se obtienen los valores de cada coche
            if (valor.getEstado() == EstadoCoche.enVenta){ // si el estado es enVenta se añade al HashMap y se imprime
                cochesEnVenta.put(valor);
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
