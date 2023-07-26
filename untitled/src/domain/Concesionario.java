package domain;

import Excepciones.*;

import java.util.HashMap;

public class Concesionario {
    private HashMap<String,Coche> cochesConcesionario;
    private HashMap<String,Coche> cochesEnVenta;
    private HashMap<String,Coche> cochesEnReparacion;
    private HashMap<String,Coche> cochesReservados;
    private HashMap<String,Coche> cochesVendidos;
    private HashMap<String,Exposicion> exposiciones;
    private HashMap<String,Cliente> clientes;
    private HashMap<String,Vendedor> vendedores;

    public Concesionario() {
        this.cochesConcesionario = new HashMap<>();
        this.cochesEnVenta = new HashMap<>();
        this.cochesEnReparacion = new HashMap<>();
        this.cochesReservados = new HashMap<>();
        this.cochesVendidos = new HashMap<>();
        this.clientes = new HashMap<>();
        this.vendedores = new HashMap<>();
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

    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }

    public HashMap<String, Vendedor> getVendedores() {
        return vendedores;
    }

    public String toStringCoches() {
        return "domain.Concesionario{" +
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
        if (cochesReservados.containsKey(coche)) throw new AlreadyExistsException("El coche ya está reservado");
        cochesReservados.put(coche, c);
    }

    public void anyadirCocheVendido(String coche, Coche c) throws AlreadyExistsException {
        if (cochesVendidos.containsKey(coche)) throw new AlreadyExistsException("El coche ya está vendido");
        cochesVendidos.put(coche, c);
    }

    public void cocheVendido(String coche, Coche c) {
        //comprobar que el coche esté en venta
        cochesEnVenta.remove(coche, c); //quita el coche de la lista en venta
        cochesVendidos.put(coche, c); //añade el coche a la lista de vendidos
    }

    public void imprimirCoches() {
        System.out.println("Listado coches");
        if(cochesConcesionario.isEmpty()) System.out.println("Todavía no hay coches en esta lista");
        for (Coche valor:cochesConcesionario.values()) { //se obtienen los valores de cada coche
            System.out.println(valor.toStringCoche());
        }
    }

    public void imprimirEnVenta() {
        System.out.println("Listado coches en venta");
        if(cochesEnVenta.isEmpty()) System.out.println("Todavía no hay coches en esta lista");
        for (Coche valor:cochesEnVenta.values()) { //se obtienen los valores de cada coche
            System.out.println(valor.toStringCoche());
        }
    }

    public void imprimirEnReparacion() {
        System.out.println("Listado coches en reparación");
        if(cochesEnReparacion.isEmpty()) System.out.println("Todavía no hay coches en esta lista");
        for (Coche valor:cochesEnReparacion.values()) { //se obtienen los valores de cada coche
            System.out.println(valor.toStringCoche());
        }
    }

    public void imprimirReservados() {
        System.out.println("Listado coches reservados");
        if(cochesReservados.isEmpty()) System.out.println("Todavía no hay coches en esta lista");
        for (Coche valor:cochesReservados.values()) { //se obtienen los valores de cada coche
            System.out.println(valor.toStringCoche());
        }
    }

    public void imprimirVendidos() {
        System.out.println("Listado coches vendidos");
        if(cochesVendidos.isEmpty()) System.out.println("Todavía no hay coches en esta lista");
        for (Coche valor:cochesVendidos.values()) { //se obtienen los valores de cada coche
            System.out.println(valor.toStringCoche());
        }
    }

    public Coche buscarCoche(String matricula) throws NotExistsException {
        if (cochesConcesionario.containsKey(matricula))
            return cochesConcesionario.get(matricula);
        else {throw new NotExistsException("El coche no existe");}

    }

    public Coche buscarCocheVenta(String matricula) throws NotExistsException {
        if (cochesEnVenta.containsKey(matricula))
            return cochesEnVenta.get(matricula); //devuelve el valor asociado a la clave de la matricula
        else {throw new NotExistsException("El coche no existe");}
    }

    public Coche buscarCocheReservado(String matricula) throws NotExistsException {
        if (cochesReservados.containsKey(matricula))
            return cochesReservados.get(matricula); //devuelve el valor asociado a la clave de la matricula
        else {throw new NotExistsException("El coche no existe");}
    }

    public void anyadirVendedor(String dni, Vendedor v) throws AlreadyExistsException {
        if (vendedores.containsKey(dni)) throw new AlreadyExistsException("El vendedor ya está dado de alta");
        vendedores.put(dni, v);
    }

    public void borrarVendedor(String dni) throws NotExistsException {
        if (vendedores.containsKey(dni)) vendedores.remove(dni);
        else throw new NotExistsException("El vendedor no se encuentra en la lista");
    }

    public Vendedor buscarVendedor(String dni) throws NotExistsException {
        if (vendedores.containsKey(dni))
            return vendedores.get(dni); //devuelve el valor asociado a la clave del dni
        else {throw new NotExistsException("El vendedor no existe");}
    }

    public void comprobarVendedor(String dni) throws AlreadyExistsException {
        if (vendedores.containsKey(dni))
            throw new AlreadyExistsException("El vendedor ya está dado de alta");
    }

    public void consultarSueldoVendedor(String dni) throws NotExistsException {
        Vendedor v = buscarVendedor(dni);
        v.sueldoVendedor();
    }

    public void modificarDireccionVendedor(String dni, String nuevaDireccion) throws NotExistsException, IsEmptyException, NullException, AlreadyExistsException {
        Vendedor v = buscarVendedor(dni);
        if(v.getDireccion().equals(nuevaDireccion)) throw new AlreadyExistsException("La dirección es la misma que la anterior");
        v.setDireccion(nuevaDireccion);
    }

    public void modificarTelefonoVendedor(String dni, String nuevoTelefono) throws NotExistsException, IsEmptyException, NullException, AlreadyExistsException {
        Vendedor v = buscarVendedor(dni);
        if(v.getTelefono().equals(nuevoTelefono)) throw new AlreadyExistsException("El teléfono es el mismo que el anterior");
        v.setDireccion(nuevoTelefono);
    }

    public void imprimirVendedores() {
        System.out.println("Listado de vendedores");
        if(vendedores.isEmpty()) System.out.println("No hay vendedores en la lista");
        for (Vendedor valor:vendedores.values()) { //se obtienen los valores de cada persona
            System.out.println(valor.toStringPersona());
        }
    }

    public void venderCocheVendedor(String matricula, String dni) throws NotExistsException, AlreadyExistsException {
        Coche c = buscarCocheVenta(matricula);
        Vendedor v = buscarVendedor(dni);
        v.venderCoche(c);
        cochesEnVenta.remove(matricula,c);
        cochesVendidos.put(matricula, c);
    }

    public void venderCocheDirector(String matricula) throws NotExistsException, AlreadyExistsException {
        Coche c = buscarCocheVenta(matricula);
        cochesEnVenta.remove(matricula,c);
        cochesVendidos.put(matricula, c);
    }

    public void reservarCoche(String matricula, String dni) throws NotExistsException, AlreadyExistsException {
        Coche c = buscarCocheVenta(matricula);
        Vendedor v = buscarVendedor(dni);
        v.venderCoche(c);
        cochesEnVenta.remove(matricula,c);
        cochesReservados.put(matricula, c);
    }

    public void reservarCocheDirector(String matricula) throws NotExistsException {
        Coche c = buscarCocheVenta(matricula);
        cochesEnVenta.remove(matricula,c);
        cochesReservados.put(matricula, c);
    }

    public void anyadirCliente(String dni, Cliente c) throws AlreadyExistsException {
        if (clientes.containsKey(dni)) throw new AlreadyExistsException("El cliente ya está dado de alta");
        clientes.put(dni, c);
    }

    public void borrarCliente (String dni) throws NotExistsException {
        if (clientes.containsKey(dni)) clientes.remove(dni);
        else throw new NotExistsException("El cliente no se encuentra en la lista");
    }

    public Cliente buscarCliente(String dni) throws NotExistsException {
        if (clientes.containsKey(dni))
            return clientes.get(dni); //devuelve el valor asociado a la clave del dni
        else {throw new NotExistsException("El cliente no existe");}
    }

    public void comprobarCliente(String dni) throws AlreadyExistsException {
        if (clientes.containsKey(dni))
            throw new AlreadyExistsException("El cliente ya está dado de alta");
    }



    public void modificarDireccionCliente(String dni, String nuevaDireccion) throws NotExistsException, IsEmptyException, NullException, AlreadyExistsException {
        Cliente c = buscarCliente(dni);
        if(c.getDireccion().equals(nuevaDireccion)) throw new AlreadyExistsException("La dirección es la misma que la anterior");
        c.setDireccion(nuevaDireccion);
    }

    public void modificarTelefonoCliente(String dni, String nuevoTelefono) throws NotExistsException, IsEmptyException, NullException, AlreadyExistsException, InvalidException {
        Cliente c = buscarCliente(dni);
        if(c.getTelefono().equals(nuevoTelefono)) throw new AlreadyExistsException("El teléfono es el mismo que el anterior");
        c.setTelefono(nuevoTelefono);
    }

    public void imprimirClientes() {
        System.out.println("Listado de clientes");
        if(clientes.isEmpty()) System.out.println("No hay clientes en la lista");
        for (Cliente valor:clientes.values()) { //se obtienen los valores de cada persona
            System.out.println(valor.toStringPersona());
        }
    }













    public Exposicion buscarExposicion(String numExposicion){
        if(exposiciones.containsKey(numExposicion))
            return exposiciones.get(numExposicion);
        else return null;
    }

    public void anyadirCocheAExposicion(String matricula, String numExposicion) throws AlreadyExistsException, NotExistsException {
        Coche c = buscarCocheVenta(matricula);
        Exposicion e = buscarExposicion(numExposicion);
        e.anyadirCocheAExposicion(c);
    }

    public void borrarCocheExposicion(Coche c, String numExposicion) throws AlreadyExistsException {
        Exposicion e = buscarExposicion(numExposicion);
        c = e.bucarCocheExposicion(c);
        e.borrarCocheExposicion(c);
    }

    /*public void cambiarCocheExposicion(domain.Coche c, String numExposicion) {
        domain.Exposicion e = buscarExposicion(numExposicion);
        c = e.bucarCocheExposicion(c);


    }*/

    public void anyadirExposicion(String exposicion, Exposicion e){
        exposiciones.put(exposicion, e);
    }

    public void borrarExposicion(String exposicion, Exposicion e){
        exposiciones.remove(exposicion, e);
    }

    /*public void anyadirCocheAExposicion(domain.Coche c){
        HashSet<domain.Coche> cochesEnExposicion= new HashSet<>();
        for (domain.Coche item:listaCochesEnVenta()){
            if (c.getMatricula() == item.getMatricula()){
                cochesEnExposicion.add(c);
            }
        }
        //buscar coche en hashmap lista coches en venta
        //añadir coche a lista coches de X exposicion
    }*/
}
