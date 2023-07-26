package Formularios;

import Excepciones.*;
import domain.Concesionario;
import domain.Vendedor;

import java.util.Scanner;

public class OpcionesVendedor {

    private Concesionario concesionario;

    public OpcionesVendedor(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public void startOpcionesVendedores() throws NotExistsException, AlreadyExistsException, IsEmptyException, InvalidException, NullException {

        Scanner in = new Scanner((System.in));
        String opcionVendedores = "0";

        while (!opcionVendedores.equals("5")){
            menu();
            opcionVendedores = in.next();
            System.out.println("--------------");

            switch (opcionVendedores){
                case "1":
                    FormularioAltaVendedor alta = new FormularioAltaVendedor(concesionario);
                    alta.nuevoVendedor();
                    break;
                case "2":
                    borrarVendedor();
                    break;
                case "3":
                    modificarVendedor();
                    break;
                case "4":
                    elegirListaVendedor();
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Debe introducir una de las opciones: del 1 al 5");
                    System.out.println("--------------");
                    break;
            }
        }
    }


    public void menu() {
        System.out.println("1- Dar de alta un vendedor");
        System.out.println("2- Dar de baja un vendedor");
        System.out.println("3- Modificar un vendedor");
        System.out.println("4- Consultar listas vendedores"); //lista vendedores y lista de coches vendidos por 1 vendedor
        System.out.println("5- Salir");
        System.out.print("Introduzca un número: ");
    }


    /*public void nuevoVendedor() throws IsEmptyException, InvalidException, NullException {
        boolean seguir = true;
        Scanner in = new Scanner((System.in));

        do {
            try {
                FormularioAltaVendedor alta = new FormularioAltaVendedor(concesionario);
                Vendedor v = alta.nuevoVendedor();
                concesionario.anyadirVendedor(v.getDni(), v);
                System.out.println("Vendedor dado de alta con éxito");
                System.out.println("--------------");

                seguir = false;
            } catch (AlreadyExistsException e) {
                System.out.println(e.getMessage());
                System.out.print("Pulse una tecla para volverlo a intentar o pulse 0 para salir: ");
                String tecla = in.next();
                System.out.println("--------------");

                if (tecla.equals("0")) { seguir = false;} //si pulsa 0 te saca del bucle
            } catch (NotExistsException e) {
                System.out.println(e.getMessage());
                System.out.print("Pulse una tecla para volverlo a intentar o pulse 0 para salir: ");
                String tecla = in.next();
                System.out.println("--------------");

                if (tecla.equals("0")) { seguir = false;} //si pulsa 0 te saca del bucle
            }
        }while (seguir == true);
    }*/

    public void borrarVendedor() {
        boolean seguir = true;
        Scanner in = new Scanner((System.in));
        do {
            try {
                System.out.print("Introduzca el DNI del vendedor que desea eliminar: ");
                String dni = in.next(); // pedir dni
                concesionario.buscarVendedor(dni);
                concesionario.borrarVendedor(dni); // borrar vendedor
                System.out.println("Vendedor borrado con éxito");
                System.out.println("--------------");

                seguir = false;
            } catch (NotExistsException e) {
                System.out.println(e.getMessage());
                System.out.print("Pulse una tecla para volverlo a intentar o pulse 0 para salir: ");
                String tecla = in.next();
                System.out.println("--------------");

                if (tecla.equals("0")) { seguir = false;} //si pulsa 0 te saca del bucle
            }
        } while (seguir==true);
    }

    public void menuModificarVendedor(){
        System.out.println("Elija la opción del dato a modificar:");
        System.out.println("1- Modificar dirección");
        System.out.println("2- Modificar teléfono");
        System.out.println("3- Salir");
        System.out.print("Introduzca un número: ");
    }

    public void modificarVendedor() throws IsEmptyException, NullException, NotExistsException, AlreadyExistsException {
        Scanner in = new Scanner((System.in));
        boolean seguir = true;
        String  modificar = "0";

        while (!modificar.equals("3")) {
            menuModificarVendedor();
            modificar = in.next();
            System.out.println("--------------");


            switch (modificar) {
                case "1":
                    System.out.print("Introduzca el DNI del vendedor que desea modificar: ");
                    String dni = in.next(); //pedir dni
                    System.out.println("--------------");

                    do {
                        try {
                            concesionario.buscarVendedor(dni);
                            System.out.print("Introduzca la nueva dirección: ");
                            in.nextLine();
                            String direccion =in.nextLine();
                            System.out.println("--------------");
                            concesionario.modificarDireccionVendedor(dni, direccion);
                            System.out.println("Vendedor modificado con éxito");
                            System.out.println("--------------");
                            seguir = false;
                        } catch (NotExistsException e) {
                            System.out.println(e.getMessage());
                            System.out.print("Ingrese de nuevo el dni o pulse 0 para salir: ");
                            dni = in.next();
                            System.out.println("--------------");
                            if (dni.equals("0")) { seguir = false;} //si pulsa 0 te saca del bucle
                        } catch (AlreadyExistsException e) {
                            System.out.println(e.getMessage());
                            System.out.print("Ingrese de nuevo el dni o pulse 0 para salir: ");
                            dni = in.next();
                            System.out.println("--------------");
                            if (dni.equals("0")) { seguir = false;} //si pulsa 0 te saca del bucle
                        }
                    } while (seguir==true);

                    seguir = true;
                case "2":

                    System.out.print("Introduzca el DNI del vendedor que desea modificar: ");
                    String dni2 = in.next(); //pedir dni
                    System.out.println("--------------");
                    System.out.print("Introduzca el nuevo teléfono");
                    String telefono = in.next();
                    System.out.println("--------------");
                    do {
                        try {
                            concesionario.buscarVendedor(dni2);
                            System.out.print("Introduzca el nuevo teléfono: ");
                            telefono = in.next();
                            System.out.println("--------------");
                            concesionario.modificarTelefonoVendedor(dni2, telefono);
                            System.out.println("Vendedor modificado con éxito");
                            System.out.println("--------------");
                            seguir = false;
                        } catch (NotExistsException e) {
                            System.out.println(e.getMessage());
                            System.out.print("Ingrese de nuevo el dni o pulse 0 para salir: ");
                            dni2 = in.next();
                            System.out.println("--------------");
                            if (dni2.equals("0")) { seguir = false;} //si pulsa 0 te saca del bucle
                        } catch (AlreadyExistsException e) {
                            System.out.println(e.getMessage());
                            System.out.print("Ingrese de nuevo el dni o pulse 0 para salir: ");
                            dni2 = in.next();
                            System.out.println("--------------");
                            if (dni2.equals("0")) { seguir = false;} //si pulsa 0 te saca del bucle
                        }
                        while (seguir == true) ;

                        seguir = true;
                        concesionario.modificarTelefonoVendedor(dni2, telefono);
                        System.out.println("Vendedor modificado con éxito");
                        System.out.println("--------------");
                        break;
                    }while (seguir==true);
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Debe introducir una de las opciones: del 1 al 4");
                    System.out.println("--------------");
                    seguir=false;
                    break;
            }
        }
    }

    public void menuListasVendedor(){
        System.out.println("Elija una lista");
        System.out.println("1- Lista de vendedores");
        System.out.println("2- Lista de coches vendidos por un vendedor");
        System.out.println("3- Sueldo de un vendedor");
        System.out.println("4- Lista de vendedores según ventas");
        System.out.println("5- Salir");
        System.out.print("Introduzca un número: ");
    }

    public void elegirListaVendedor()  {
        Scanner in = new Scanner((System.in));
        String  listaVendedor = "0";
        boolean seguir = true;

        while(!listaVendedor.equals("4")) {
            menuListasVendedor();
            listaVendedor = in.next();
            System.out.println("--------------");

            switch (listaVendedor) {

                case "1":
                    concesionario.imprimirVendedores();
                    break;
                case "2":
                    do {
                        String dni;
                        try {
                            System.out.print("Introduzca el DNI del vendedor: ");
                            dni = in.next();
                            System.out.println("--------------");
                            Vendedor v = concesionario.buscarVendedor(dni);
                            v.imprimirCochesVendidos();
                            seguir = false;
                        } catch (NotExistsException e) {
                            System.out.println(e.getMessage());
                            System.out.print("Ingrese de nuevo el dni o pulse 0 para salir: ");
                            dni = in.next();
                            System.out.println("--------------");
                            if (dni.equals("0")) {
                                seguir = false;
                            }
                        }
                    }while (seguir== true);
                    seguir = false;
                    break;
                case "3":
                    do {
                        String dni;
                        try {
                            System.out.print("Introduzca el DNI del vendedor: ");
                            dni = in.next();
                            concesionario.consultarSueldoVendedor(dni);
                            System.out.println("--------------");
                        } catch (NotExistsException e) {
                            System.out.println(e.getMessage());
                            System.out.print("Ingrese de nuevo el dni o pulse 0 para salir: ");
                            dni = in.next();
                            System.out.println("--------------");
                            if (dni.equals("0")) {
                                seguir = false;
                            }
                        }
                    } while (seguir == true);
                    seguir = true;
                    break;
                case "4":
                    concesionario.imprimirVendedoresVentas();
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Debe introducir una de las opciones: del 1 al 4");
                    break;
            }
        }
    }
}