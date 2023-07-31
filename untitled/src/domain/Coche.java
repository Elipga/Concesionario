package domain;

import Excepciones.InvalidException;
import Excepciones.IsEmptyException;
import Excepciones.NullException;

import java.util.*;

public abstract class Coche {
    private String marca;
    private String modelo;
    private String matricula;
    private Double precioCompra;
    private Double precioVenta;


    //Constructor y validaciones
    public Coche(String marca, String modelo, String matricula, Double precioCompra, Double precioVenta) throws NullException, IsEmptyException, InvalidException {
        validateMarca(marca);
        this.marca = marca;
        validateModelo(modelo);
        this.modelo = modelo;
        validateMatricula(matricula);
        this.matricula = matricula;
        validatePrecioCompra(precioCompra);
        this.precioCompra = precioCompra;
        validatePrecioVenta(precioVenta);
        this.precioVenta = precioVenta;
    }

    private static void validatePrecioVenta(Double precioVenta) throws InvalidException {
        if (precioVenta < 0) throw new InvalidException("El precio de venta debe ser superior a 0");
    }

    private static void validatePrecioCompra(Double precioCompra) throws InvalidException {
        if (precioCompra < 0) throw new InvalidException("El precio de compra debe ser superior a 0");
    }

    private static void validateMatricula(String matricula) throws NullException, IsEmptyException, InvalidException {
        if (matricula == null) throw new NullException("La matrícula no puede ser null");
        if (matricula == "") throw new IsEmptyException("La matrícula no puede estar vacía");
        if (matricula.length() != 7) throw new InvalidException("La matrícula debe tener 7 dígitos");
        if (!matricula.matches("^[0-9]{4}[A-Za-z]{3}$")) throw new InvalidException("La matrícula debe contener " +
                "4 números y 3 letras");
        // ^ incicio de cadena,
        //[0-9]{4}: 4 caracteres numéricos. [A-Za-z]{3}:3 caracteres alfabéticos. $:el final de la cadena.
    }

    private static void validateModelo(String modelo) throws NullException, IsEmptyException {
        if (modelo == null) throw new NullException("El modelo no puede ser null");
        if (modelo == "") throw new IsEmptyException("El modelo no puede estar vacío");
    }

    private void validateMarca(String marca) throws NullException, IsEmptyException, InvalidException {
        if (marca == null) throw new NullException("La marca no puede ser null");
        if (marca.isEmpty()) throw new IsEmptyException("La marca no puede estar vacía");
        if (!marca.equalsIgnoreCase("Dacia") && !marca.equalsIgnoreCase("Toyota") &&
                !marca.equalsIgnoreCase("Mercedes") && !marca.equalsIgnoreCase("Fiat")
                && !marca.equalsIgnoreCase("Renault")) throw new InvalidException("Debe introducir " +
                "una de las marcas propuestas");
    }

    public void setMarca(String marca) throws NullException, IsEmptyException, InvalidException {
        validateMarca(marca);
        this.marca = marca;
    }

    public void setModelo(String modelo) throws NullException, IsEmptyException {
        validateModelo(modelo);
        this.modelo = modelo;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public String toStringCoche() {

        return "Coche{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", precioCompra=" + precioCompra +
                ", precioVenta=" + precioVenta +
                '}';
    }

    public String getMatricula() {

        return matricula;
    }



}

