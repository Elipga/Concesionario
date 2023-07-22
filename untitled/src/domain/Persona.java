package domain;

import Excepciones.InvalidException;
import Excepciones.IsEmptyException;
import Excepciones.NotNullException;

public class Persona {
    private String nombre;
    private String direccion;
    private String dni;
    private String telefono;

    public Persona(String nombre, String direccion, String dni, String  telefono) throws IsEmptyException, NotNullException, InvalidException {
        if(direccion == null) throw new NotNullException("Dirección no puede ser null");
        if(direccion.isEmpty()) throw new IsEmptyException("Dirección no puede quedar vacío");
        this.nombre = nombre;
        if(direccion == null) throw new NotNullException("Dirección no puede ser null");
        if(direccion.isEmpty()) throw new IsEmptyException("Dirección no puede quedar vacío");
        this.direccion = direccion;

        this.dni = dni;
        if(telefono == null) throw new NotNullException("Teléfono no puede ser null");
        if(telefono == "") throw new IsEmptyException("Teléfono no puede estar vacío");
        if((telefono.length() != 9)) throw new InvalidException("Teléfono debe tener 9 dígitos");
        if (!telefono.matches("^[0-9]+$")) throw new InvalidException("Debe introducir numeros"); //valida que sean numeros del 0 al 9
        this.telefono = telefono;
    }

    public Persona() {
        super();
        this.nombre = "Nombre";
        this.dni = "dni";
        this.telefono = ("000000000");
    }

    public String toStringPersona() {
        return  "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", dni='" + dni + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
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

    public void setDireccion(String direccion) throws NotNullException, IsEmptyException {
        if(direccion == null) throw new NotNullException("Dirección no puede ser null");
        if(direccion.isEmpty()) throw new IsEmptyException("Dirección no puede quedar vacío");
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) throws NotNullException, IsEmptyException, InvalidException {
        if(telefono == null) throw new NotNullException("Teléfono no puede ser null");
        if(telefono == "") throw new IsEmptyException("Teléfono no puede estar vacío");
        if((telefono.length() != 9)) throw new InvalidException("Teléfono debe tener 9 dígitos");
        if (!telefono.matches("^[0-9]+$")) throw new InvalidException("Debe introducir numeros");
        this.telefono = telefono;
    }

    public void setDni(String dni) throws NotNullException, IsEmptyException {
        if(dni == null) throw new NotNullException("DNI no puede ser null");
        if(dni.isEmpty()) throw new IsEmptyException("DNI no puede estar vacío");
        //introducir re.match para comprobar y validar el dni con 8 dígitos y una letra
        boolean dniValido = dni.matches("[0-9]{8}[A-Za-z]");
        this.dni = dni;
    }

    public void setNombre(String nombre) throws NotNullException, IsEmptyException {
        if (nombre == null) throw new NotNullException("Nombre no puede ser null");
        if (nombre.isEmpty())throw new IsEmptyException("Nombre no puede estar vacío");
        this.nombre = nombre;
    }




}