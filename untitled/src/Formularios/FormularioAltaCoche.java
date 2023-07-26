package Formularios;

import Excepciones.InvalidException;
import Excepciones.IsEmptyException;
import Excepciones.NullException;
import Excepciones.PreconditionException;
import domain.*;

import java.util.Scanner;

public class FormularioAltaCoche {
    private Concesionario concesionario;

    public FormularioAltaCoche(Concesionario concesionario) {
        this.concesionario = concesionario;
    }



    public String[] datos() throws IsEmptyException, InvalidException, NullException {
        Validaciones a = new Validaciones();
        boolean seguir = true;
        Scanner in = new Scanner((System.in));
        OpcionesCoche o = new OpcionesCoche(concesionario);
        String[] datosCoche = new String[5];
        String precioVenta = "0";
        String precioCompra = "0";
        double precioCompraDouble = 0;
        double precioVentaDouble = 0;

        do {
            try {
                System.out.println("Nuevo formulario de coche");
                System.out.println("Marca (Elija entre Dacia, Toyota, Mercedes, Fiat o Renault): ");
                String marca = in.next();
                a.validateMarca(marca);
                datosCoche[0] = marca; //Introduce la marca en la posición 0
                System.out.println("--------------");
                System.out.println("Modelo: ");
                String modelo = in.next();
                datosCoche[1] = modelo;
                System.out.println("--------------");
                System.out.println("Matricula. La matrícula debe tener 7 dígitos (4 números y 3 letras): ");
                String matricula = in.next();
                a.validateMatricula(matricula);
                datosCoche[2] = matricula;
                System.out.println("--------------");
                do {
                    try {
                        System.out.println("Precio de Compra: ");
                        precioCompra = in.next(); //ingresa String y comprueba que sea numerico con NumberFormatException
                        precioCompraDouble = Double.parseDouble(precioCompra);//lo pasa a double
                        a.validatePrecioCompra(precioCompraDouble);
                        datosCoche[3] = precioCompra;
                        System.out.println("--------------");
                        System.out.println("Precio de venta");
                        precioVenta = in.next();
                        precioVentaDouble = Double.parseDouble(precioVenta);
                        a.validatePrecioVenta(precioVentaDouble);
                        datosCoche[4] = precioVenta;
                        System.out.println("--------------");
                        seguir = false;
                    } catch (NumberFormatException e) {
                        System.out.println("El precio debe ser un valor numérico");
                        System.out.print("Pulse una tecla para volverlo a intentar o pulse 0 para salir: ");
                        String tecla = in.next();
                        System.out.println("--------------");
                        if (tecla.equals("0")) {
                            o.altaCoche();
                        }
                    }
                } while (seguir == true);

            } catch (PreconditionException e) {
                System.out.println(e.getMessage());
                System.out.print("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir: ");
                String tecla = in.next();
                System.out.println("--------------");
                if (tecla.equals("0")) {
                    o.altaCoche();
                }
            }
        } while (seguir == true);
        return datosCoche;
    }

    public CocheTodoterreno nuevoTodoterreno2() throws IsEmptyException, InvalidException, NullException {
        String[] datosCoche = datos();
        String precioCompra = datosCoche[3];
        String precioVenta = datosCoche[4];
        double precioCompraDouble = Double.parseDouble(precioCompra);
        double precioVentaDouble = Double.parseDouble(precioVenta);

        return new CocheTodoterreno(datosCoche[0], datosCoche[1], datosCoche[2], precioCompraDouble, precioVentaDouble);
    }
    public CocheIndustrial nuevoIndustrial2() throws IsEmptyException, InvalidException, NullException {
        String[] datosCoche = datos();
        String precioCompra = datosCoche[3];
        String precioVenta = datosCoche[4];
        double precioCompraDouble = Double.parseDouble(precioCompra);
        double precioVentaDouble = Double.parseDouble(precioVenta);

        return new CocheIndustrial(datosCoche[0], datosCoche[1], datosCoche[2], precioCompraDouble, precioVentaDouble);
    }
    public CocheTurismo nuevoTurismo2() throws IsEmptyException, InvalidException, NullException {
        String[] datosCoche = datos();
        String precioCompra = datosCoche[3];
        String precioVenta = datosCoche[4];
        double precioCompraDouble = Double.parseDouble(precioCompra);
        double precioVentaDouble = Double.parseDouble(precioVenta);

        return new CocheTurismo(datosCoche[0], datosCoche[1], datosCoche[2], precioCompraDouble, precioVentaDouble);
    }

    /*private static void validatePrecioVenta(Double precioVenta) throws InvalidException {
        if(precioVenta < 0) throw new InvalidException("El precio de venta debe ser superior a 0");
    }

    private static void validatePrecioCompra(Double precioCompra) throws InvalidException {
        if(precioCompra < 0) throw new InvalidException("El precio de compra debe ser superior a 0");
    }

    private static void validateMatricula(String matricula) throws NullException, IsEmptyException, InvalidException {
        if(matricula == null) throw new NullException("La matrícula no puede ser null");
        if(matricula == "") throw new IsEmptyException("La matrícula no puede estar vacía");
        if(matricula.length() != 7) throw new InvalidException("La matrícula debe tener 7 dígitos");
        if(!matricula.matches("^[0-9]{4}[A-Za-z]{3}$"))throw new InvalidException("La matrícula debe contener " +
                "4 números y 3 letras");
        // ^ incicio de cadena,
        //[0-9]{4}: 4 caracteres numéricos. [A-Za-z]{3}:3 caracteres alfabéticos. $:el final de la cadena.
    }

    private void validateMarca(String marca) throws NullException, IsEmptyException, InvalidException {
        if(marca == null) throw new NullException("La marca no puede ser null");
        if(marca.isEmpty()) throw new IsEmptyException("La marca no puede estar vacía");
        if(!marca.equalsIgnoreCase("Dacia") && !marca.equalsIgnoreCase("Toyota") &&
                !marca.equalsIgnoreCase("Mercedes") && !marca.equalsIgnoreCase("Fiat")
                && !marca.equalsIgnoreCase("Renault")) throw new InvalidException("Debe introducir " +
                "una de las marcas propuestas");
    }*/


   /* public CocheIndustrial nuevoIndustrial() {

        boolean seguir = true;
        Scanner in = new Scanner((System.in));
        OpcionesCoche o = new OpcionesCoche(concesionario);

        do {
            try {
                System.out.println("Nuevo formulario de coche");
                System.out.println("Marca: Dacia, Toyota, Mercedes, Fiat o Renault");
                System.out.println("--------------");
                String marca = in.next();
                System.out.println("Modelo");
                System.out.println("--------------");
                String modelo = in.next();
                System.out.println("Matricula: la matrícula debe tener 7 dígitos (4 números y 3 letras)");
                System.out.println("--------------");
                String matricula = in.next();
                System.out.println("Precio de Compra");
                System.out.println("--------------");
                double precioCompra = in.nextDouble();
                System.out.println("Precio de venta");
                System.out.println("--------------");
                double precioVenta = in.nextDouble();
                return new CocheIndustrial(marca, modelo, matricula, precioCompra, precioVenta);
            } catch (NullException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                System.out.println("--------------");
                String tecla = in.next();
                if (tecla.equals("0")) {
                    o.altaCoche();
                }
                ;
            } catch (IsEmptyException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                System.out.println("--------------");
                String tecla = in.next();
                if (tecla.equals("0")) {
                    o.altaCoche();
                }
                ;
            } catch (InvalidException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                System.out.println("--------------");
                String tecla = in.next();
                if (tecla.equals("0")) {
                    o.altaCoche();
                }
                ;
            }
        } while (seguir == true);

        return null;
    }

    public CocheTurismo nuevoTurismo() {

        boolean seguir = true;
        Scanner in = new Scanner((System.in));
        OpcionesCoche o = new OpcionesCoche(concesionario);

        do {
            try {
                System.out.println("Nuevo formulario de coche");
                System.out.println("Marca: Dacia, Toyota, Mercedes, Fiat o Renault");
                System.out.println("--------------");
                String marca = in.next();
                System.out.println("Modelo");
                System.out.println("--------------");
                String modelo = in.next();
                System.out.println("Matricula: la matrícula se compone de 4 números y 3 letras");
                System.out.println("--------------");
                String matricula = in.next();
                System.out.println("Precio de Compra");
                System.out.println("--------------");
                double precioCompra = in.nextDouble();
                System.out.println("Precio de venta");
                System.out.println("--------------");
                double precioVenta = in.nextDouble();
                return new CocheTurismo(marca, modelo, matricula, precioCompra, precioVenta);
            } catch (NullException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                System.out.println("--------------");
                String tecla = in.next();
                if (tecla.equals("0")) {
                    o.altaCoche();
                }
                ;
            } catch (IsEmptyException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                System.out.println("--------------");
                String tecla = in.next();
                if (tecla.equals("0")) {
                    o.altaCoche();
                }
                ;
            } catch (InvalidException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                System.out.println("--------------");
                String tecla = in.next();
                if (tecla.equals("0")) {
                    o.altaCoche();
                }
                ;
            }
        } while (seguir == true);

        return null;
    }

    public CocheTodoterreno nuevoTodoterreno() {

        boolean seguir = true;
        Scanner in = new Scanner((System.in));
        OpcionesCoche o = new OpcionesCoche(concesionario);
        String precioVenta = "0";
        String precioCompra = "0";
        double precioCompraDouble = 0;
        double precioVentaDouble = 0;

        do {
            try {
                System.out.println("Nuevo formulario de coche");
                System.out.println("Marca: Dacia, Toyota, Mercedes, Fiat o Renault");
                System.out.println("--------------");
                String marca = in.next();
                validateMarca(marca);
                System.out.println("Modelo");
                System.out.println("--------------");
                String modelo = in.next();
                System.out.println("Matricula: la matrícula debe tener 7 dígitos (4 números y 3 letras)");
                System.out.println("--------------");
                String matricula = in.next();
                validateMatricula(matricula);

                do {
                    try {
                        System.out.println("Precio de Compra");
                        System.out.println("--------------");
                        precioCompra = in.next(); //ingresa String y comprueba que sea numerico con NumberFormatException
                        System.out.println("Precio de venta");
                        System.out.println("--------------");
                        precioVenta = in.next();
                        precioCompraDouble = Double.parseDouble(precioCompra);//lo pasa a double
                        validatePrecioCompra(precioCompraDouble); //valida que sea mayor que 0
                        precioVentaDouble = Double.parseDouble(precioVenta);
                        validatePrecioVenta(precioVentaDouble);
                        seguir = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Debe ser un valor numérico");
                        System.out.println("Pulse una tecla para volverlo a intentar o pulse 0 para salir");
                        System.out.println("--------------");
                        String tecla = in.next();
                        if (tecla.equals("0")) {
                            o.altaCoche();
                        }
                    }
                } while (seguir == true);
                return new CocheTodoterreno(marca, modelo, matricula, precioCompraDouble, precioVentaDouble);

            } catch (PreconditionException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                System.out.println("--------------");
                String tecla = in.next();
                if (tecla.equals("0")) {
                    o.altaCoche();
                }
            }
        } while (seguir == true);

        return null;
    }*/




}


