package Formularios;

import Excepciones.*;
import domain.*;

import java.util.Scanner;

public class FormularioAltaCoche {
    private Concesionario concesionario;

    public FormularioAltaCoche(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public void nuevoIndustrial() {
        Validaciones a = new Validaciones();

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
                System.out.print("Marca (Elija entre Dacia, Toyota, Mercedes, Fiat o Renault): ");
                String marca = in.nextLine();
                a.validateMarca(marca);
                System.out.println("--------------");
                System.out.print("Modelo: ");
                String modelo = in.nextLine();
                System.out.println("--------------");
                System.out.print("Matricula. La matrícula debe tener 7 dígitos (4 números y 3 letras): ");
                String matricula = in.nextLine();
                a.validateMatricula(matricula);
                System.out.println("--------------");
                System.out.print("Precio de Compra: ");
                precioCompra = in.nextLine(); //ingresa String y comprueba que sea numerico con NumberFormatException
                precioCompraDouble = Double.parseDouble(precioCompra);//lo pasa a double
                a.validatePrecioCompra(precioCompraDouble);
                System.out.println("--------------");
                System.out.print("Precio de venta: ");
                precioVenta = in.nextLine();
                precioVentaDouble = Double.parseDouble(precioVenta);
                a.validatePrecioVenta(precioVentaDouble);
                System.out.println("--------------");
                CocheIndustrial c = new CocheIndustrial(marca, modelo, matricula, precioCompraDouble, precioVentaDouble);
                concesionario.anyadirCoche(c.getMatricula(), c);
                concesionario.anyadirCocheEnVenta(c.getMatricula(), c);
                System.out.println("Coche Industrial dado de alta con éxito");
                System.out.println("--------------");
                seguir = false;


            } catch (PreconditionException e) {
                System.out.println(e.getMessage());
                System.out.print("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir: ");
                String tecla = in.next();
                in.nextLine();
                System.out.println("--------------");
                if (tecla.equals("0")) {
                    seguir = false;
                }
            } catch (AlreadyExistsException e) {
                System.out.println(e.getMessage());
                System.out.print("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir: ");
                String tecla = in.next();
                in.nextLine();
                System.out.println("--------------");
                if (tecla.equals("0")) {
                    seguir = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("El precio debe ser un valor numérico");
                System.out.print("Pulse una tecla para volverlo a intentar o pulse 0 para salir: ");
                String tecla = in.next();
                in.nextLine();
                System.out.println("--------------");
                if (tecla.equals("0")) {
                    seguir = false;
                }
            }

        } while (seguir == true);
    }


    public void nuevoTurismo() {
        Validaciones a = new Validaciones();

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
                System.out.print("Marca (Elija entre Dacia, Toyota, Mercedes, Fiat o Renault): ");
                String marca = in.nextLine();
                a.validateMarca(marca);
                System.out.println("--------------");
                System.out.print("Modelo: ");
                String modelo = in.nextLine();
                System.out.println("--------------");
                System.out.print("Matricula. La matrícula debe tener 7 dígitos (4 números y 3 letras): ");
                String matricula = in.nextLine();
                a.validateMatricula(matricula);
                System.out.println("--------------");
                System.out.print("Precio de Compra: ");
                precioCompra = in.nextLine(); //ingresa String y comprueba que sea numerico con NumberFormatException
                precioCompraDouble = Double.parseDouble(precioCompra);//lo pasa a double
                a.validatePrecioCompra(precioCompraDouble);
                System.out.println("--------------");
                System.out.print("Precio de venta: ");
                precioVenta = in.nextLine();
                precioVentaDouble = Double.parseDouble(precioVenta);
                a.validatePrecioVenta(precioVentaDouble);
                System.out.println("--------------");
                CocheTurismo c = new CocheTurismo(marca, modelo, matricula, precioCompraDouble, precioVentaDouble);
                concesionario.anyadirCoche(c.getMatricula(), c);
                concesionario.anyadirCocheEnVenta(c.getMatricula(), c);
                System.out.println("Coche Turismo dado de alta con éxito");
                System.out.println("--------------");
                seguir = false;


            } catch (PreconditionException e) {
                System.out.println(e.getMessage());
                System.out.print("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir: ");
                String tecla = in.next();
                in.nextLine();
                System.out.println("--------------");
                if (tecla.equals("0")) {
                    seguir = false;
                }
            } catch (AlreadyExistsException e) {
                System.out.println(e.getMessage());
                System.out.print("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir: ");
                String tecla = in.next();
                in.nextLine();
                System.out.println("--------------");
                if (tecla.equals("0")) {
                    seguir = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("El precio debe ser un valor numérico");
                System.out.print("Pulse una tecla para volverlo a intentar o pulse 0 para salir: ");
                String tecla = in.next();
                in.nextLine();
                System.out.println("--------------");
                if (tecla.equals("0")) {
                    seguir = false;
                }
            }

        } while (seguir == true);
    }



    public void nuevoTodoterreno() {
        Validaciones a = new Validaciones();

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
                System.out.print("Marca (Elija entre Dacia, Toyota, Mercedes, Fiat o Renault): ");
                String marca = in.nextLine();
                a.validateMarca(marca);
                System.out.println("--------------");
                System.out.print("Modelo: ");
                String modelo = in.nextLine();
                System.out.println("--------------");
                System.out.print("Matricula. La matrícula debe tener 7 dígitos (4 números y 3 letras): ");
                String matricula = in.nextLine();
                a.validateMatricula(matricula);
                System.out.println("--------------");
                System.out.print("Precio de Compra: ");
                precioCompra = in.nextLine(); //ingresa String y comprueba que sea numerico con NumberFormatException
                precioCompraDouble = Double.parseDouble(precioCompra);//lo pasa a double
                a.validatePrecioCompra(precioCompraDouble);
                System.out.println("--------------");
                System.out.print("Precio de venta: ");
                precioVenta = in.nextLine();
                precioVentaDouble = Double.parseDouble(precioVenta);
                a.validatePrecioVenta(precioVentaDouble);
                System.out.println("--------------");
                CocheTodoterreno c = new CocheTodoterreno(marca, modelo, matricula, precioCompraDouble, precioVentaDouble);
                concesionario.anyadirCoche(c.getMatricula(), c);
                concesionario.anyadirCocheEnVenta(c.getMatricula(), c);
                System.out.println("Coche Todoterreno dado de alta con éxito");
                System.out.println("--------------");
                seguir = false;


            } catch (PreconditionException e) {
                System.out.println(e.getMessage());
                System.out.print("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir: ");
                String tecla = in.next();
                in.nextLine();
                System.out.println("--------------");
                if (tecla.equals("0")) {
                    seguir = false;
                }
            } catch (AlreadyExistsException e) {
                System.out.println(e.getMessage());
                System.out.print("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir: ");
                String tecla = in.next();
                in.nextLine();
                System.out.println("--------------");
                if (tecla.equals("0")) {
                    seguir = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("El precio debe ser un valor numérico");
                System.out.print("Pulse una tecla para volverlo a intentar o pulse 0 para salir: ");
                String tecla = in.next();
                in.nextLine();
                System.out.println("--------------");
                if (tecla.equals("0")) {
                    seguir = false;
                }
            }

        } while (seguir == true);
    }
}









