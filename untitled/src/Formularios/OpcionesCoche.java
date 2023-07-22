package Formularios;

import Excepciones.AlreadyExistsException;
import Excepciones.NotExistsException;
import domain.CocheIndustrial;
import domain.CocheTodoterreno;
import domain.CocheTurismo;
import domain.Concesionario;

import java.util.Scanner;

public class OpcionesCoche {

    private Concesionario concesionario;

    public OpcionesCoche(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public void startOpcionesCoche() throws NotExistsException {
        Scanner in = new Scanner((System.in));
        int opcionCoches = 0;

        while (opcionCoches != 5){
            menu();
            opcionCoches = in.nextInt();

            switch (opcionCoches){
                case 1:
                    //System.out.println("Nuevo formulario de coche");
                    altaCoche();
                    break;
                case 2:
                    //System.out.println("Vender coche");
                    venderCoche();
                    break;
                case 3:
                    //System.out.println("Reservar coche");
                    reservarCoche();
                    break;
                case 4:
                    elegirListaCoche();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Debe introducir una de las opciones: del 1 al 5");
                    break;
            }
        }
    }

    public void menu(){
        System.out.println("1- Dar de alta un coche");
        System.out.println("2- Vender Coche");
        System.out.println("3- Reservar Coche");
        System.out.println("4- Consultar listas de coches");
        System.out.println("5- Salir");
    }

    public void menuAltaCoche(){
        System.out.println("Qué tipo de coche?");
        System.out.println("1- Todoterreno");
        System.out.println("2- Industrial");
        System.out.println("3- Turismo");
        System.out.println("4- Salir");
    }

    public void altaCoche()  {
        boolean seguir = true;
        FormularioAltaCoche alta = new FormularioAltaCoche();
        Scanner in = new Scanner((System.in));
        int tipoCoche = 0;


        while (tipoCoche != 4) {
            menuAltaCoche();
            tipoCoche = in.nextInt();

            do {
                try {
                    switch (tipoCoche) {
                        case 1:
                            CocheTodoterreno a = alta.nuevoTodoterreno();
                            concesionario.anyadirCoche(a.getMatricula(), a);
                            concesionario.anyadirCocheEnVenta(a.getMatricula(), a);
                            System.out.println("Coche Todoterreno dado de alta con éxito");
                            seguir = false;
                            break;

                        case 2:
                            CocheIndustrial b = alta.nuevoIndustrial();
                            concesionario.anyadirCoche(b.getMatricula(), b);
                            concesionario.anyadirCocheEnVenta(b.getMatricula(), b);
                            System.out.println("Coche Industrial dado de alta con éxito");
                            seguir = false;
                            break;

                        case 3:
                            CocheTurismo c = alta.nuevoTurismo();
                            concesionario.anyadirCoche(c.getMatricula(), c);
                            concesionario.anyadirCocheEnVenta(c.getMatricula(), c);
                            System.out.println("Coche Turismo dado de alta con éxito");
                            seguir = false;
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Debe introducir una de las opciones: del 1 al 4");
                            seguir=false;
                            break;
                    }
                } catch (AlreadyExistsException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Pulse una tecla + enter si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                    String tecla = in.next();
                    if (tecla.equals("0")) { seguir = false;

                    }

                }
            }while (seguir==true);
        }
    }

    public void venderCocheDirector()  {
        boolean seguir = true;
        Scanner in = new Scanner((System.in));

        do {
            try {
                System.out.println("Introduzca la matrícula del coche que va a ser vendido: ");
                String matriculaVender = in.next();
                concesionario.buscarCocheVenta(matriculaVender);
                concesionario.venderCocheDirector(matriculaVender);
                System.out.println("El coche ha sido vendido con éxito por el director comercial");
                seguir = false;
            } catch (NotExistsException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla + enter si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                String tecla = in.next();
                if (tecla.equals("0")) { seguir = false;

                }

            } catch (AlreadyExistsException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla + enter si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                String tecla = in.next();
                if (tecla.equals("0")) { seguir = false;

                }
            }
        }while (seguir == true);
    }


    public void venderCoche()  {
        boolean seguir = true;
        Scanner in = new Scanner((System.in));
        System.out.println("Pulse 0 si es el director comercial o cualquier otra tecla si es un vendedor");
        String director = "1";
        director = in.next();

        if (director == "0"){
            venderCocheDirector();
        }

        else {

            do {
                try {
                    System.out.println("Introduzca la matrícula del coche que va a ser vendido: ");
                    String matriculaVender = in.next();
                    concesionario.buscarCocheVenta(matriculaVender);
                    System.out.println("Introduzca el DNI del vendedor que va a vender el coche");
                    String dniVender = in.next();
                    concesionario.buscarVendedor(dniVender);
                    concesionario.venderCocheVendedor(matriculaVender, dniVender);
                    System.out.println("El coche ha sido vendido con éxito");
                    seguir = false;
                } catch (NotExistsException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Pulse una tecla + enter si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                    String tecla = in.next();
                    if (tecla.equals("0")) {
                        seguir = false;
                    }
                } catch (AlreadyExistsException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Pulse una tecla + enter si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                    String tecla = in.next();
                    if (tecla.equals("0")) {
                        seguir = false;
                    }
                }
            } while (seguir == true);
        }
    }

    public void reservarCoche() throws NotExistsException {
        boolean seguir = true;
        Scanner in = new Scanner((System.in));

        do {
            try {
                System.out.println("Introduzca la matrícula del coche que va a ser reservado: ");
                String matriculaReservar = in.next();
                concesionario.buscarCocheVenta(matriculaReservar);
                concesionario.reservarCocheDirector(matriculaReservar);
                System.out.println("El coche ha sido reservado con éxito por el director comercial");
                seguir = false;
            } catch (NotExistsException e) {
                e.getMessage();
                System.out.println("Pulse una tecla + enter si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                String tecla = in.next();
                if (tecla.equals("0")) { seguir = false;

                }
            }
        }while (seguir == true);
    }

    public void menuListaCoche(){
        System.out.println("Elija una lista");
        System.out.println("1- Lista todos los coches del concesionario");
        System.out.println("2- Lista coches en venta");
        System.out.println("3- Lista coches reservados");
        System.out.println("4- Lista coches vendidos");
        System.out.println("5- Salir");
    }


    public void elegirListaCoche()  {
        Scanner in = new Scanner((System.in));
        int listaCoches = 0;

        while (listaCoches != 5) {
            menuListaCoche();
            listaCoches = in.nextInt();

            switch (listaCoches) {

                case 1:
                    concesionario.imprimirCoches();
                    break;
                case 2:
                    concesionario.imprimirEnVenta();
                    break;
                case 3:
                    concesionario.imprimirReservados();
                    break;
                case 4:
                    concesionario.imprimirVendidos();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Debe introducir una de las opciones: del 1 al 4");
                    break;
            }
        }
    }
}

