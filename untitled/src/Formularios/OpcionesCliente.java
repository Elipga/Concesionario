package Formularios;

import Excepciones.*;
import domain.Cliente;
import domain.Concesionario;

import java.util.Scanner;

public class OpcionesCliente {

    private Concesionario concesionario;

    public OpcionesCliente(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public void startOpcionesCliente() throws AlreadyExistsException, IsEmptyException, NotExistsException, InvalidException, NotNullException {
        Scanner in = new Scanner((System.in));
        String opcionClientes = "0";

        while (!opcionClientes.equals("5")){
            menu();
            opcionClientes = in.next();

            switch (opcionClientes){
                case "1":
                    nuevoCliente();
                    break;
                case "2":
                    borrarCliente();
                    break;
                case "3":
                    modificarCliente();
                    break;
                case "4":
                    listaClientes();
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Debe introducir una de las opciones: del 1 al 4");
                    break;
            }
        }

    }
    public void menu(){
        System.out.println("1- Dar de alta un cliente");
        System.out.println("2- Dar de baja un cliente");
        System.out.println("3- Modificar un cliente");
        System.out.println("4- Consultar lista clientes");
        System.out.println("5- Salir");
    }

    public void nuevoCliente() throws AlreadyExistsException, IsEmptyException, NotExistsException, InvalidException, NotNullException {
        FormularioAltaCliente alta = new FormularioAltaCliente();
        Cliente v = alta.nuevoCliente();
        concesionario.anyadirCliente(v.getDni(), v);
    }

    public void borrarCliente() throws NotExistsException {
        boolean seguir = true;
        Scanner in = new Scanner((System.in));
        //System.out.println("Eliminar cliente");
        System.out.println("Introduzca el DNI del cliente que desea eliminar:");
        String dni = in.next(); // pedir dni

        do {
            try {
                concesionario.buscarCliente(dni);
                concesionario.borrarCliente(dni);
                System.out.println("Cliente borrado con éxito");
                seguir = false;
            } catch (NotExistsException e) {
                System.out.println(e.getMessage());
                System.out.println("Ingrese de nuevo el dni o pulse 0 para salir");
                dni = in.next();
                if (dni.equals("0")) { seguir = false;} //si pulsa 0 te saca del bucle
            }
        } while (seguir==true);

    }

    public void menuModificarCliente(){
        System.out.println("Elija la opción del dato a modificar:");
        System.out.println("1- Modificar dirección");
        System.out.println("2- Modificar teléfono");
        System.out.println("3- Salir");
    }

    public void modificarCliente() throws IsEmptyException, NotNullException, NotExistsException {

        Scanner in = new Scanner((System.in));
        boolean seguir = true;
        String  modificar = "0";

        while (!modificar.equals("3")) {
            menuModificarCliente();
            modificar = in.next();

            switch (modificar) {
                case "1":
                    System.out.println("Introduzca el DNI del cliente que desea modificar");
                    String dni = in.next(); //pedir dni

                    do {
                        try {
                            concesionario.buscarCliente(dni);
                            System.out.println("Introduzca la nueva dirección");
                            in.nextLine();
                            String direccion =in.nextLine();
                            concesionario.modificarDireccionCliente(dni, direccion);
                            System.out.println("Cliente modificado con éxito");
                            seguir = false;
                        } catch (NotExistsException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Ingrese de nuevo el dni o pulse 0 para salir");
                            dni = in.next();
                            if (dni.equals("0")) { seguir = false;} //si pulsa 0 te saca del bucle
                        }
                    } while (seguir==true);

                    seguir = true;
                    //if (dni.equals("0")) break; //si pulsa 0 te saca del case 1
                    //System.out.println("Introduzca la nueva dirección");
                    //String direccion =in.next();
                    //concesionario.modificarDireccionVendedor(dni, direccion);
                    //System.out.println("domain.Vendedor modificado con éxito");
                    break;
                case "2":

                    System.out.println("Introduzca el DNI del cliente que desea modificar");
                    String dni2 = in.next(); //pedir dni


                    System.out.println("Introduzca el nuevo teléfono");
                    String telefono = in.next();
                    do {
                        try {
                            concesionario.buscarCliente(dni2);
                            System.out.println("Introduzca el nuevo teléfono");
                            telefono = in.next();
                            concesionario.modificarTelefonoVendedor(dni2, telefono);
                            System.out.println("Cliente modificado con éxito");
                            seguir = false;
                        } catch (NotExistsException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Ingrese de nuevo el dni o pulse 0 para salir");
                            dni2 = in.next();
                            if (dni2.equals("0")) { seguir = false;} //si pulsa 0 te saca del bucle

                        }
                        while (seguir == true) ;

                        //seguir = true;
                        //concesionario.modificarTelefonoVendedor(dni2, telefono);
                        //System.out.println("Vendedor modificado con éxito");
                        //break;
                    }while (seguir==true);
                case "3":
                    break;
                default:
                    System.out.println("Debe introducir una de las opciones: del 1 al 4");
                    seguir=false;
                    break;
            }
        }
    }

    public void listaClientes(){
        concesionario.imprimirClientes();
    }
}
