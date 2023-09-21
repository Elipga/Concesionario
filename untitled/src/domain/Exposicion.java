package domain;

import Excepciones.*;

import java.util.HashMap;

public class Exposicion {
    private String numExpo;
    private String direccion;
    private String telefono;

    public HashMap<String, Coche> cochesEnExpo;

    public Exposicion(String numExpo, String direccion, String telefono) throws IsEmptyException, NullException, InvalidException {
        validateNumExpo(numExpo);
        this.numExpo = numExpo;
        validateDireccion(direccion);
        this.direccion = direccion;
        validateTelefono(telefono);
        this.telefono = telefono;
        this.cochesEnExpo = new HashMap<>();

    }

    @Override
    public String toString() {
        return "Exposicion{" +
                "numExpo='" + numExpo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    public String getNumExpo() {
        return numExpo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public HashMap<String, Coche> getCochesEnExpo() {
        return cochesEnExpo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    private void validateNumExpo(String numExpo) throws InvalidException {
        if (!numExpo.matches("^[0-9]+$")) throw new InvalidException("Debe introducir numeros");
    }

    private static void validateDireccion(String direccion) throws NullException, IsEmptyException {
        if (direccion == null) throw new NullException("Dirección no puede ser null");
        if (direccion.isEmpty()) throw new IsEmptyException("Dirección no puede quedar vacío");
    }

    private static void validateTelefono(String telefono) throws NullException, IsEmptyException, InvalidException {
        if (telefono == null) throw new NullException("Teléfono no puede ser null");
        if (telefono == "") throw new IsEmptyException("Teléfono no puede estar vacío");
        if ((telefono.length() != 9)) throw new InvalidException("Teléfono debe tener 9 dígitos");
        if (!telefono.matches("^[0-9]+$")) throw new InvalidException("Debe introducir numeros");
        if (telefono.charAt(0) != '6') throw new InvalidException("El primer número debe ser un 6");
    }


    public void anyadirCoche(String matricula, Coche c) throws AlreadyExistsException {
        if (cochesEnExpo.containsKey(numExpo)) throw new AlreadyExistsException("El coche ya está en la exposición");
        cochesEnExpo.put(matricula,c);
    }

    public void borrarCoche(String matricula, Coche c) throws NotExistsException {
        if (cochesEnExpo.containsKey(matricula)) cochesEnExpo.remove(matricula, c);
        else throw new NotExistsException("El coche no se encuentra en la exposición");
    }

    public void imprimirCochesEnExpo() {
        System.out.println("Listado de coches de la exposición");
        if (cochesEnExpo.isEmpty()) System.out.println("No hay coches en la lista");
        System.out.println("--------------");
        for (Coche valor : cochesEnExpo.values()) { //se obtienen los valores de cada coche
            System.out.println(valor.toStringCoche());
        }
    }

    public Coche buscarCoche(String matricula) throws NotExistsException {
        if (cochesEnExpo.containsKey(matricula))
            return cochesEnExpo.get(matricula);
        else {
            throw new NotExistsException("El coche no se ha encontrado");
        }
    }
}
