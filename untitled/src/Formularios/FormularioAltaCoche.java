package Formularios;

import Excepciones.InvalidException;
import Excepciones.IsEmptyException;
import Excepciones.NotNullException;
import domain.*;

import java.lang.reflect.Array;
import java.util.Scanner;

public class FormularioAltaCoche {
    private Concesionario concesionario;

    public CocheTodoterreno nuevoTodoterreno() {

        boolean seguir = true;
        Scanner in = new Scanner((System.in));
        OpcionesCoche o = new OpcionesCoche(concesionario);

        do {
            try {
                System.out.println("Nuevo formulario de coche");
                System.out.println("Marca: Dacia, Toyota, Mercedes, Fiat o Renault");
                String marca = in.next();
                System.out.println("Modelo");
                String modelo = in.next();
                System.out.println("Matricula: la matrícula debe tener 7 dígitos (4 números y 3 letras)");
                String matricula = in.next();
                System.out.println("Precio de Compra");
                double precioCompra = in.nextDouble();
                System.out.println("Precio de venta");
                double precioVenta = in.nextDouble();
                return new CocheTodoterreno(marca, modelo, matricula, precioCompra, precioVenta);
            } catch (NotNullException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla + enter si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                String tecla = in.next();
                if (tecla.equals("0")) {
                    o.altaCoche();
                }
                ;
            } catch (IsEmptyException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla + enter si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                String tecla = in.next();
                if (tecla.equals("0")) {
                    o.altaCoche();
                }
                ;
            } catch (InvalidException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla + enter si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                String tecla = in.next();
                if (tecla.equals("0")) {
                    o.altaCoche();
                }
                ;
            }
        }while (seguir==true);

        return null;
    }

    public CocheIndustrial nuevoIndustrial() {

        boolean seguir = true;
        Scanner in = new Scanner((System.in));
        OpcionesCoche o = new OpcionesCoche(concesionario);

        do {
            try {
                System.out.println("Nuevo formulario de coche");
                System.out.println("Marca: Dacia, Toyota, Mercedes, Fiat o Renault");
                String marca = in.next();
                System.out.println("Modelo");
                String modelo = in.next();
                System.out.println("Matricula: la matrícula debe tener 7 dígitos (4 números y 3 letras)");
                String matricula = in.next();
                System.out.println("Precio de Compra");
                double precioCompra = in.nextDouble();
                System.out.println("Precio de venta");
                double precioVenta = in.nextDouble();
                return new CocheIndustrial(marca, modelo, matricula, precioCompra, precioVenta);
            } catch (NotNullException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla + enter si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                String tecla = in.next();
                if (tecla.equals("0")) {
                    o.altaCoche();

                }
                ;
            } catch (IsEmptyException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla + enter si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                String tecla = in.next();
                if (tecla.equals("0")) {
                    o.altaCoche();
                }
                ;
            } catch (InvalidException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla + enter si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                String tecla = in.next();
                if (tecla.equals("0")) {
                    o.altaCoche();
                }
                ;
            }
        }while (seguir==true);

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
                String marca = in.next();
                System.out.println("Modelo");
                String modelo = in.next();
                System.out.println("Matricula: la matrícula se compone de 4 números y 3 letras");
                String matricula = in.next();
                System.out.println("Precio de Compra");
                double precioCompra = in.nextDouble();
                System.out.println("Precio de venta");
                double precioVenta = in.nextDouble();
                return new CocheTurismo(marca, modelo, matricula, precioCompra, precioVenta);
            } catch (NotNullException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla + enter si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                String tecla = in.next();
                if (tecla.equals("0")) {
                    o.altaCoche();
                }
                ;
            } catch (IsEmptyException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla + enter si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                String tecla = in.next();
                if (tecla.equals("0")) {
                    o.altaCoche();
                }
                ;
            } catch (InvalidException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla + enter si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                String tecla = in.next();
                if (tecla.equals("0")) {
                    o.altaCoche();
                }
                ;
            }
        }while (seguir==true);

        return null;
    }

}


