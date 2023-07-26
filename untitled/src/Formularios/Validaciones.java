package Formularios;

import Excepciones.InvalidException;
import Excepciones.IsEmptyException;
import Excepciones.NullException;

public class Validaciones {

    //COCHE

    public static void validatePrecioVenta(Double precioVenta) throws InvalidException {
        if(precioVenta < 0) throw new InvalidException("El precio de venta debe ser superior a 0");
    }

    public static void validatePrecioCompra(Double precioCompra) throws InvalidException {
        if(precioCompra < 0) throw new InvalidException("El precio de compra debe ser superior a 0");
    }

    public static void validateMatricula(String matricula) throws NullException, IsEmptyException, InvalidException {
        if(matricula == null) throw new NullException("La matrícula no puede ser null");
        if(matricula == "") throw new IsEmptyException("La matrícula no puede estar vacía");
        if(matricula.length() != 7) throw new InvalidException("La matrícula debe tener 7 dígitos");
        if(!matricula.matches("^[0-9]{4}[A-Za-z]{3}$"))throw new InvalidException("La matrícula debe contener " +
                "4 números y 3 letras");
        // ^ incicio de cadena,
        //[0-9]{4}: 4 caracteres numéricos. [A-Za-z]{3}:3 caracteres alfabéticos. $:el final de la cadena.
    }

    public static void validateModelo(String modelo) throws NullException, IsEmptyException {
        if(modelo == null) throw new NullException("El modelo no puede ser null");
        if(modelo == "") throw new IsEmptyException("El modelo no puede estar vacío");
    }

    public void validateMarca(String marca) throws NullException, IsEmptyException, InvalidException {
        if(marca == null) throw new NullException("La marca no puede ser null");
        if(marca.isEmpty()) throw new IsEmptyException("La marca no puede estar vacía");
        if(!marca.equalsIgnoreCase("Dacia") && !marca.equalsIgnoreCase("Toyota") &&
                !marca.equalsIgnoreCase("Mercedes") && !marca.equalsIgnoreCase("Fiat")
                && !marca.equalsIgnoreCase("Renault")) throw new InvalidException("Debe introducir " +
                "una de las marcas propuestas");
    }

    //PERSONA
    public static void validateTelefono(String telefono) throws NullException, IsEmptyException, InvalidException {
        if(telefono == null) throw new NullException("Teléfono no puede ser null");
        if(telefono == "") throw new IsEmptyException("Teléfono no puede estar vacío");
        if((telefono.length() != 9)) throw new InvalidException("Teléfono debe tener 9 dígitos");
        if (!telefono.matches("^[0-9]+$")) throw new InvalidException("Debe introducir numeros");
        if(telefono.charAt(0) != '6' ) throw new InvalidException("El primer número debe ser un 6");
    }

    public static void validateDni(String dni) throws NullException, IsEmptyException, InvalidException {
        if(dni == null) throw new NullException("DNI no puede ser null");
        if(dni.isEmpty()) throw new IsEmptyException("DNI no puede quedar vacío");
        if((dni.length() != 9)) throw new InvalidException("DNI se compone de 9 caracteres");
        if(!dni.matches("[0-9]{8}[A-Za-z]"))throw new InvalidException("El DNI debe contener " +
                "8 números y 1 letra al final");
    }

    public static void validateDireccion(String direccion) throws NullException, IsEmptyException {
        if(direccion == null) throw new NullException("Dirección no puede ser null");
        if(direccion.isEmpty()) throw new IsEmptyException("Dirección no puede quedar vacío");
    }

    public static void validateNombre(String nombre) throws NullException, IsEmptyException {
        if(nombre == null) throw new NullException("Nombre no puede ser null");
        if(nombre.isEmpty()) throw new IsEmptyException("Nombre no puede quedar vacío");
    }
}
