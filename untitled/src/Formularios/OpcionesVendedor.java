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

            switch (opcionVendedores){
                case "1":
                    nuevoVendedor();
                    break;
                case "2":
                    //System.out.println("Eliminar vendedor");
                    borrarVendedor();
                    break;
                case "3":
                    //System.out.println("Modificar vendedor");
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
        System.out.println("--------------");

    }

    /*public Vendedor nuevoVendedor() throws IsEmptyException, InvalidException, NotNullException, AlreadyExistsException, NotExistsException {
        FormularioAltaVendedor alta = new FormularioAltaVendedor();
        Vendedor v = alta.nuevoVendedor();
        return v;
    }*/

    public void nuevoVendedor() throws IsEmptyException, InvalidException, NullException {
        boolean seguir = true;
        Scanner in = new Scanner((System.in));

        do {
            try {
                FormularioAltaVendedor alta = new FormularioAltaVendedor();
                Vendedor v = alta.nuevoVendedor();
                concesionario.anyadirVendedor(v.getDni(), v);
                System.out.println("Vendedor dado de alta con éxito");
                seguir = false;
            } catch (AlreadyExistsException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla para volverlo a intentar o pulse 0 para salir");
                String tecla = in.next();
                if (tecla.equals("0")) { seguir = false;} //si pulsa 0 te saca del bucle
            } catch (NotExistsException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla para volverlo a intentar o pulse 0 para salir");
                String tecla = in.next();
                if (tecla.equals("0")) { seguir = false;} //si pulsa 0 te saca del bucle
            }
        }while (seguir == true);
    }

    public void borrarVendedor() {
        boolean seguir = true;
        Scanner in = new Scanner((System.in));
        //System.out.println("Eliminar vendedor");


        do {
            try {
                System.out.println("Introduzca el DNI del vendedor que desea eliminar:");
                String dni = in.next(); // pedir dni
                concesionario.buscarVendedor(dni);
                concesionario.borrarVendedor(dni); // borrar vendedor
                System.out.println("Vendedor borrado con éxito");
                seguir = false;
            } catch (NotExistsException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla para volverlo a intentar o pulse 0 para salir");
                String tecla = in.next();
                if (tecla.equals("0")) { seguir = false;} //si pulsa 0 te saca del bucle
            }
        } while (seguir==true);
    }

    public void menuModificarVendedor(){
        System.out.println("Elija la opción del dato a modificar:");
        System.out.println("1- Modificar dirección");
        System.out.println("2- Modificar teléfono");
        System.out.println("3- Salir");
    }

    public void modificarVendedor() throws IsEmptyException, NullException, NotExistsException, AlreadyExistsException {

        Scanner in = new Scanner((System.in));
        boolean seguir = true;
        String  modificar = "0";

        while (!modificar.equals("3")) {
            menuModificarVendedor();
            modificar = in.next();

            switch (modificar) {
                case "1":
                    System.out.println("Introduzca el DNI del vendedor que desea modificar");
                    String dni = in.next(); //pedir dni
                    do {
                        try {
                            concesionario.buscarVendedor(dni);
                            System.out.println("Introduzca la nueva dirección");
                            in.nextLine();
                            String direccion =in.nextLine();
                            concesionario.modificarDireccionVendedor(dni, direccion);
                            System.out.println("Vendedor modificado con éxito");
                            seguir = false;
                        } catch (NotExistsException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Ingrese de nuevo el dni o pulse 0 para salir");
                            dni = in.next();
                            if (dni.equals("0")) { seguir = false;} //si pulsa 0 te saca del bucle
                        } catch (AlreadyExistsException e) {
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

                    System.out.println("Introduzca el DNI del vendedor que desea modificar");
                    String dni2 = in.next(); //pedir dni


                    System.out.println("Introduzca el nuevo teléfono");
                    String telefono = in.next();
                    do {
                        try {
                            concesionario.buscarVendedor(dni2);
                            System.out.println("Introduzca el nuevo teléfono");
                            telefono = in.next();
                            concesionario.modificarTelefonoVendedor(dni2, telefono);
                            System.out.println("Vendedor modificado con éxito");
                            seguir = false;
                        } catch (NotExistsException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Ingrese de nuevo el dni o pulse 0 para salir");
                            dni2 = in.next();
                            if (dni2.equals("0")) { seguir = false;} //si pulsa 0 te saca del bucle
                        } catch (AlreadyExistsException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Ingrese de nuevo el dni o pulse 0 para salir");
                            dni2 = in.next();
                            if (dni2.equals("0")) { seguir = false;} //si pulsa 0 te saca del bucle
                        }
                        while (seguir == true) ;

                        seguir = true;
                        concesionario.modificarTelefonoVendedor(dni2, telefono);
                        System.out.println("Vendedor modificado con éxito");
                        break;
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

    public void menuListasVendedor(){
        System.out.println("Elija una lista");
        System.out.println("1- Lista de vendedores");
        System.out.println("2- Lista de coches vendidos por un vendedor");
        System.out.println("3- Sueldo de un vendedor");
        System.out.println("4- Salir");
    }

    public void elegirListaVendedor()  {
        Scanner in = new Scanner((System.in));
        String  listaVendedor = "0";
        boolean seguir = true;

        while(!listaVendedor.equals("4")) {
            menuListasVendedor();
            listaVendedor = in.next();

            switch (listaVendedor) {

                case "1":
                    concesionario.imprimirVendedores();
                    break;
                case "2":
                    do {
                        String dni;
                        try {
                            System.out.println("Introduzca el DNI del vendedor");
                            dni = in.next();
                            Vendedor v = concesionario.buscarVendedor(dni);
                            v.imprimirCochesVendidos();
                            seguir = false;
                        } catch (NotExistsException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Ingrese de nuevo el dni o pulse 0 para salir");
                            dni = in.next();
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
                            System.out.println("Introduzca el DNI del vendedor");
                            dni = in.next();
                            concesionario.consultarSueldoVendedor(dni);
                        } catch (NotExistsException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Ingrese de nuevo el dni o pulse 0 para salir");
                            dni = in.next();
                            if (dni.equals("0")) {
                                seguir = false;
                            }
                        }
                    } while (seguir == true);

                    seguir = true;
                case "4":
                    break;
                default:
                    System.out.println("Debe introducir una de las opciones: del 1 al 4");
                    break;
            }
        }
    }
}