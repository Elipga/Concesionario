package domain;

import Excepciones.InvalidException;
import Excepciones.IsEmptyException;
import Excepciones.NullException;

public class Persona {
    private String nombre;
    private String direccion;
    private String dni;
    private String telefono;

    public Persona(String nombre, String direccion, String dni, String  telefono) throws IsEmptyException, NullException, InvalidException {
        validateNombre(nombre);
        this.nombre = nombre;
        validateDireccion(direccion);
        this.direccion = direccion;
        validateDni(dni);
        this.dni = dni;
        validateTelefono(telefono);
        this.telefono = telefono;
    }

    private static void validateTelefono(String telefono) throws NullException, IsEmptyException, InvalidException {
        if(telefono == null) throw new NullException("Teléfono no puede ser null");
        if(telefono == "") throw new IsEmptyException("Teléfono no puede estar vacío");
        if((telefono.length() != 9)) throw new InvalidException("Teléfono debe tener 9 dígitos");
        if (!telefono.matches("^[0-9]+$")) throw new InvalidException("Debe introducir numeros");
        if(telefono.charAt(0) != '6' ) throw new InvalidException("El primer número debe ser un 6");
    }

    private static void validateDni(String dni) throws NullException, IsEmptyException, InvalidException {
        if(dni == null) throw new NullException("DNI no puede ser null");
        if(dni.isEmpty()) throw new IsEmptyException("DNI no puede quedar vacío");
        if((dni.length() != 9)) throw new InvalidException("DNI se compone de 9 caracteres");
        if(!dni.matches("[0-9]{8}[A-Za-z]"))throw new InvalidException("El DNI debe contener " +
                "8 números y 1 letra al final");
    }

    private static void validateDireccion(String direccion) throws NullException, IsEmptyException {
        if(direccion == null) throw new NullException("Dirección no puede ser null");
        if(direccion.isEmpty()) throw new IsEmptyException("Dirección no puede quedar vacío");
    }

    private static void validateNombre(String nombre) throws NullException, IsEmptyException {
        if(nombre == null) throw new NullException("Nombre no puede ser null");
        if(nombre.isEmpty()) throw new IsEmptyException("Nombre no puede quedar vacío");
    }


    public String toStringPersona() {
        return  "{ nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", dni='" + dni + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    public void setDireccion(String direccion) throws NullException, IsEmptyException {
        validateDireccion(direccion);
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) throws NullException, IsEmptyException, InvalidException {
        validateTelefono(telefono);
        this.telefono = telefono;
    }

    public void setDni(String dni) throws NullException, IsEmptyException, InvalidException {
        validateDni(dni);
        this.dni = dni;
    }

    public void setNombre(String nombre) throws NullException, IsEmptyException {
        if (nombre == null) throw new NullException("Nombre no puede ser null");
        if (nombre.isEmpty())throw new IsEmptyException("Nombre no puede estar vacío");
        this.nombre = nombre;
    }

    public String getNombre() {

        return nombre;
    }

    public String getDireccion() {

        return direccion;
    }

    public String getDni() {

        return dni;
    }

    public String getTelefono() {

        return telefono;
    }
}