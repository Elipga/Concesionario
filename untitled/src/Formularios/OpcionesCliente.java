package Formularios;

import Excepciones.*;
import domain.Cliente;
import domain.Concesionario;
import domain.Vendedor;

import java.util.Scanner;

public class OpcionesCliente {

    private Concesionario concesionario;

    public OpcionesCliente(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public void startOpcionesCliente() throws AlreadyExistsException, IsEmptyException, NotExistsException, InvalidException, NullException {
        Scanner in = new Scanner((System.in));
        String opcionClientes = "0";

        while (!opcionClientes.equals("5")) {
            menu();
            opcionClientes = in.next();
            System.out.println("--------------");

            switch (opcionClientes) {
                case "1":
                    FormularioAltaCliente alta = new FormularioAltaCliente(concesionario);
                    alta.nuevoCliente();
                    break;
                case "2":
                    borrarCliente();
                    break;
                case "3":
                    modificarCliente();
                    break;
                case "4":
                    elegirListaCliente();
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

    public void menu() {
        System.out.println("1- Dar de alta un cliente");
        System.out.println("2- Dar de baja un cliente");
        System.out.println("3- Modificar un cliente");
        System.out.println("4- Consultar lista clientes");
        System.out.println("5- Salir");
        System.out.println("Introduzca un número: ");
    }


    public void borrarCliente() throws NotExistsException {
        boolean seguir = true;
        Scanner in = new Scanner((System.in));

        do {
            try {
                System.out.print("Introduzca el DNI del cliente que desea eliminar:");
                String dni = in.next(); // pedir dni
                System.out.println("--------------");
                concesionario.buscarCliente(dni);
                concesionario.borrarCliente(dni);
                System.out.println("Cliente borrado con éxito");
                System.out.println("--------------");
                seguir = false;
            } catch (NotExistsException e) {
                System.out.println(e.getMessage());
                System.out.print("Pulse una tecla para volverlo a intentar o pulse 0 para salir: ");
                String tecla = in.next();
                System.out.println("--------------");
                if (tecla.equals("0")) {
                    seguir = false;
                } //si pulsa 0 te saca del bucle
            } catch (InvalidException e) {
                System.out.println(e.getMessage());
                System.out.print("Pulse una tecla para volverlo a intentar o pulse 0 para salir: ");
                String tecla = in.next();
                System.out.println("--------------");
                if (tecla.equals("0")) {
                    seguir = false;
                }
            }
        } while (seguir == true);
    }

    public void menuModificarCliente() {
        System.out.println("Elija la opción del dato a modificar:");
        System.out.println("1- Modificar dirección");
        System.out.println("2- Modificar teléfono");
        System.out.println("3- Salir");
        System.out.print("Introduzca un número: ");
    }

    public void modificarCliente() throws IsEmptyException, NullException, NotExistsException {
        Scanner in = new Scanner((System.in));
        boolean seguir = true;
        String modificar = "0";
        String dni;

        while (!modificar.equals("3")) {
            menuModificarCliente();
            modificar = in.next();
            System.out.println("--------------");

            switch (modificar) {
                case "1":
                    System.out.print("Introduzca el DNI del cliente que desea modificar: ");
                    dni = in.next(); //pedir dni
                    System.out.println("--------------");

                    do {
                        try {
                            concesionario.buscarCliente(dni);
                            System.out.print("Introduzca la nueva dirección: ");
                            in.nextLine();
                            String direccion = in.nextLine();
                            System.out.println("--------------");
                            concesionario.modificarDireccionCliente(dni, direccion);
                            System.out.println("Cliente modificado con éxito");
                            System.out.println("--------------");
                            seguir = false;
                        } catch (NotExistsException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Ingrese de nuevo el dni o pulse 0 para salir: ");
                            dni = in.next();
                            System.out.println("--------------");
                            if (dni.equals("0")) {
                                seguir = false;
                            } //si pulsa 0 te saca del bucle
                        } catch (AlreadyExistsException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Ingrese de nuevo el dni o pulse 0 para salir: ");
                            dni = in.next();
                            System.out.println("--------------");
                            if (dni.equals("0")) {
                                seguir = false;
                            } //si pulsa 0 te saca del bucle
                        }
                    } while (seguir == true);
                    seguir = true;
                    break;
                case "2":

                    System.out.println("Introduzca el DNI del cliente que desea modificar: ");
                    dni = in.next(); //pedir dni
                    System.out.println("--------------");
                    do {
                        try {
                            concesionario.buscarCliente(dni);
                            System.out.print("Introduzca el nuevo teléfono: ");
                            String telefono = in.next();
                            System.out.println("--------------");
                            concesionario.modificarTelefonoCliente(dni, telefono);
                            System.out.println("Cliente modificado con éxito");
                            System.out.println("--------------");
                            seguir = false;
                        } catch (NotExistsException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Ingrese de nuevo el dni o pulse 0 para salir: ");
                            dni = in.next();
                            System.out.println("--------------");
                            if (dni.equals("0")) {
                                seguir = false;
                            } //si pulsa 0 te saca del bucle
                        } catch (AlreadyExistsException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Ingrese de nuevo el dni o pulse 0 para salir: ");
                            dni = in.next();
                            System.out.println("--------------");
                            if (dni.equals("0")) {
                                seguir = false;
                            } //si pulsa 0 te saca del bucle
                        } catch (InvalidException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Ingrese de nuevo el dni o pulse 0 para salir: ");
                            dni = in.next();
                            System.out.println("--------------");
                        }

                    } while (seguir == true);
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Debe introducir una de las opciones: del 1 al 4");
                    System.out.println("--------------");
                    seguir = false;
                    break;
            }
        }
    }


    public void menuListasClientes() {
        System.out.println("Elija una lista");
        System.out.println("1- Lista de clientes");
        System.out.println("2- Lista de coches comprados por un cliente");
        System.out.println("3- Lista de coches reservados por un cliente");
        System.out.println("4- Salir");
        System.out.print("Introduzca un número: ");
    }

    public void elegirListaCliente() {
        Scanner in = new Scanner((System.in));
        String listaCliente = "0";
        boolean seguir = true;

        while (!listaCliente.equals("4")) {
            menuListasClientes();
            listaCliente = in.next();
            System.out.println("--------------");

            switch (listaCliente) {
                case "1":
                    concesionario.imprimirClientes();
                    break;

                case "2":
                    do {
                        try {
                            System.out.print("Introduzca el DNI del cliente: ");
                            String dniCliente = in.next();
                            System.out.println("--------------");
                            Cliente a = concesionario.buscarCliente(dniCliente);
                            a.imprimirCochesComprados();
                            seguir = false;
                        } catch (NotExistsException e) {
                            System.out.println(e.getMessage());
                            System.out.print("Pulse una tecla si quiere intentarlo de nuevo o pulse 0 para salir: ");
                            String tecla = in.next();
                            System.out.println("--------------");
                            if (tecla.equals("0")) {
                                seguir = false;
                            }
                        }
                    } while (seguir == true);
                    break;
                case "3":
                    do {

                        try {
                            System.out.print("Introduzca el DNI del cliente: ");
                            String dniCliente = in.next();
                            System.out.println("--------------");
                            Cliente a = concesionario.buscarCliente(dniCliente);
                            a.imprimirCochesRservados();
                            seguir = false;
                        } catch (NotExistsException e) {
                            System.out.println(e.getMessage());
                            System.out.print("Pulse una tecla si quiere intentarlo de nuevo o pulse 0 para salir: ");
                            String tecla = in.next();
                            System.out.println("--------------");
                            if (tecla.equals("0")) {
                                seguir = false;
                            }
                        }
                    }while (seguir == true);

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

}
