package Formularios;

import Excepciones.*;

import domain.Concesionario;

import java.util.Scanner;

public class OpcionesCoche {

    private Concesionario concesionario;

    public OpcionesCoche(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public void startOpcionesCocheDirector() throws NotExistsException, IsEmptyException, InvalidException, NullException {
        Scanner in = new Scanner((System.in));
        String opcionCoches = "0";

        while (!opcionCoches.equals("6")){
            menu();
            opcionCoches = in.next();
            System.out.println("--------------");


            switch (opcionCoches){
                case "1":
                    altaCoche();
                    break;
                case "2":
                    venderCocheDirector();
                    break;
                case "3":
                    reservarCoche();
                    break;
                case "4":
                    cancelarReserva();
                    break;
                case "5":
                    elegirListaCoche();
                    break;
                case "6":
                    break;
                default:
                    System.out.println("Debe introducir una de las opciones: del 1 al 5");
                    System.out.println("--------------");
                    break;
            }
        }
    }

    public void startOpcionesCocheVendedor(String dniVendedor) throws NotExistsException, IsEmptyException, InvalidException, NullException {
        Scanner in = new Scanner((System.in));
        String opcionCoches = "0";

        while (!opcionCoches.equals("6")){
            menu();
            opcionCoches = in.next();
            System.out.println("--------------");

            switch (opcionCoches){
                case "1":
                    altaCoche();
                    break;
                case "2":
                    venderCocheVendedor(dniVendedor);
                    break;
                case "3":
                    reservarCoche();
                    break;
                case "4":
                    cancelarReserva();
                    break;
                case "5":
                    elegirListaCoche();
                    break;
                case "6":
                    break;
                default:
                    System.out.println("Debe introducir una de las opciones: del 1 al 5");
                    System.out.println("--------------");
                    break;
            }
        }
    }

    public void menu(){
        System.out.println("1- Dar de alta un coche");
        System.out.println("2- Vender Coche");
        System.out.println("3- Reservar Coche");
        System.out.println("4- Cancelar una reserva");
        System.out.println("5- Consultar listas de coches");
        System.out.println("6- Salir");
        System.out.print("Introduzca un número");
    }

    public void menuAltaCoche(){
        System.out.println("Qué tipo de coche?");
        System.out.println("1- Todoterreno");
        System.out.println("2- Industrial");
        System.out.println("3- Turismo");
        System.out.println("4- Salir");
        System.out.print("Introduzca un número");
    }



    public void altaCoche() throws IsEmptyException, InvalidException, NullException {
        boolean seguir = true;
        FormularioAltaCoche alta = new FormularioAltaCoche(concesionario);
        Scanner in = new Scanner((System.in));
        String tipoCoche = "0";


        while (!tipoCoche.equals("4")) {
            menuAltaCoche();
            tipoCoche = in.next();
            System.out.println("--------------");


            switch (tipoCoche) {
                case "1":
                    alta.nuevoTodoterreno();
                    break;
                case "2":
                    alta.nuevoIndustrial();
                    break;
                case "3":
                    alta.nuevoTurismo();
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Debe introducir una de las opciones: del 1 al 4");
                    System.out.println("--------------");
                    seguir = false;
                    break;

            }

        }
    }


    public void venderCocheVendedor(String dniVendedor)  {
        boolean seguir = true;
        Scanner in = new Scanner((System.in));

            do {
                try {
                    System.out.print("Introduzca la matrícula del coche que va a ser vendido: ");
                    String matriculaVender = in.next();
                    System.out.println("--------------");
                    concesionario.buscarCocheVenta(matriculaVender);
                    concesionario.buscarVendedor(dniVendedor);
                    System.out.print("Introduzca el DNI del cliente que va a comprar el coche: ");
                    String dniCliente = in.next();
                    concesionario.buscarCliente(dniCliente);
                    System.out.println("--------------");
                    concesionario.venderCocheVendedor(matriculaVender, dniVendedor, dniCliente);
                    System.out.println("El coche ha sido vendido con éxito");
                    System.out.println("--------------");
                    seguir = false;
                } catch (NotExistsException e) {
                    System.out.println(e.getMessage());
                    System.out.print("Pulse una tecla si quiere intentarlo de nuevo o pulse 0 para salir: ");
                    String tecla = in.next();
                    System.out.println("--------------");
                    if (tecla.equals("0")) {
                        seguir = false;
                    }
                } catch (AlreadyExistsException e) {
                    System.out.println(e.getMessage());
                    System.out.print("Pulse una tecla si quiere intentarlo de nuevo o pulse 0 para salir");
                    String tecla = in.next();
                    System.out.println("--------------");
                    if (tecla.equals("0")) {
                        seguir = false;
                    }
                }
            } while (seguir == true);
    }


    public void venderCocheDirector(){
        Scanner in = new Scanner((System.in));
        boolean seguir = true;

        do {
            try {
                System.out.print("Introduzca la matrícula del coche que va a ser vendido: ");
                String matriculaVender = in.next();
                System.out.println("--------------");
                concesionario.buscarCocheVenta(matriculaVender);
                System.out.print("Introduzca el DNI del cliente que va a comprar el coche: ");
                String dniCliente = in.next();
                concesionario.buscarCliente(dniCliente);
                System.out.println("--------------");
                concesionario.venderCocheDirector(matriculaVender,dniCliente);
                System.out.println("El coche ha sido vendido con éxito");
                System.out.println("--------------");
                seguir = false;
            } catch (NotExistsException e) {
                System.out.println(e.getMessage());
                System.out.print("Pulse una tecla si quiere intentarlo de nuevo o pulse 0 para salir: ");
                String tecla = in.next();
                System.out.println("--------------");
                if (tecla.equals("0")) {
                    seguir = false;
                }
            } catch (AlreadyExistsException e) {
                System.out.println(e.getMessage());
                System.out.print("Pulse una tecla si quiere intentarlo de nuevo o pulse 0 para salir: ");
                String tecla = in.next();
                System.out.println("--------------");
                if (tecla.equals("0")) {
                    seguir = false;
                }
            }
        } while (seguir == true);
    }

    public void reservarCoche() throws NotExistsException {
        boolean seguir = true;
        Scanner in = new Scanner((System.in));

        do {
            try {
                System.out.print("Introduzca la matrícula del coche que va a ser reservado: ");
                String matriculaReservar = in.next();
                System.out.println("--------------");
                concesionario.buscarCocheVenta(matriculaReservar);
                System.out.print("Introduzca el DNI del cliente que va a reservar el coche: ");
                String dniCliente = in.next();
                concesionario.buscarCliente(dniCliente);
                System.out.println("--------------");
                concesionario.reservarCoche(matriculaReservar, dniCliente);
                System.out.println("El coche ha sido reservado");
                System.out.println("--------------");
                seguir = false;
            } catch (NotExistsException e) {
                e.getMessage();
                System.out.print("Pulse una tecla si quiere intentarlo de nuevo o pulse 0 para salir: ");
                String tecla = in.next();
                System.out.println("--------------");
                if (tecla.equals("0")) { seguir = false;

                }
            }
        }while (seguir == true);
    }

    public void cancelarReserva() throws NotExistsException {
        boolean seguir = true;
        Scanner in = new Scanner((System.in));

        do {
            try {
                System.out.print("Introduzca la matrícula del coche que va a ser eliminado de reservas: ");
                String matriculaNoReservar = in.next();
                System.out.println("--------------");
                concesionario.buscarCocheReservado(matriculaNoReservar);
                System.out.print("Introduzca el DNI del cliente que había hecho la reserva: ");
                String dniCliente = in.next();
                concesionario.buscarCliente(dniCliente);
                System.out.println("--------------");
                concesionario.cancelarReserva(matriculaNoReservar, dniCliente);
                System.out.println("La reserva ha sido cancelada");
                System.out.println("--------------");
                seguir = false;
            } catch (NotExistsException e) {
                e.getMessage();
                System.out.print("Pulse una tecla si quiere intentarlo de nuevo o pulse 0 para salir: ");
                String tecla = in.next();
                System.out.println("--------------");
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
        System.out.print("Introduzca un número: ");
    }


    public void elegirListaCoche()  {
        Scanner in = new Scanner((System.in));
        String listaCoches = "0";

        while (!listaCoches.equals("5")) {
            menuListaCoche();
            listaCoches = in.next();
            System.out.println("--------------");


            switch (listaCoches) {

                case "1":
                    concesionario.imprimirCoches();
                    break;
                case "2":
                    concesionario.imprimirEnVenta();
                    break;
                case "3":
                    concesionario.imprimirReservados();
                    break;
                case "4":
                    concesionario.imprimirVendidos();
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Debe introducir una de las opciones: del 1 al 4");
                    System.out.println("--------------");
                    break;
            }
        }
    }
}

