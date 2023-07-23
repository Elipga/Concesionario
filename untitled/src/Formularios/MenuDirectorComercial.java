package Formularios;
import Excepciones.*;
import domain.*;

import java.util.Scanner;

public class MenuDirectorComercial {

    private Concesionario concesionario;

    public MenuDirectorComercial(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public void startMenuDirector() throws AlreadyExistsException, IsEmptyException, NotExistsException, InvalidException, NotNullException {
        Scanner in = new Scanner((System.in));
        String opcion = "0";

        while (!opcion.equals("4")){
            menu();
            opcion = in.next();

            switch (opcion){
                case "1":
                    OpcionesVendedor a = new OpcionesVendedor(concesionario);
                    a.startOpcionesVendedores();
                    break;
                case "2":
                    OpcionesCoche b = new OpcionesCoche(concesionario);
                    b.startOpcionesCocheDirector();
                    break;
                case "3":
                    OpcionesCliente c = new OpcionesCliente(concesionario);
                    c.startOpcionesCliente();
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Debe introducir una de las opciones: del 1 al 4");
                    System.out.println("--------------");
                    break;

            }
        }
    }

    public void menu(){
        System.out.println("Elija una opción: ");
        System.out.println("1- Gestión de vendedores");
        System.out.println("2- Gestión de coches");
        System.out.println("3- Gestión de clientes");
        System.out.println("4- Salir");
        System.out.println("--------------");

    }

    /*public void startDirector() throws IsEmptyException, InvalidException, NotNullException, AlreadyExistsException, NotExistsException {

        Scanner in = new Scanner((System.in));
        String opcionDirector = "0";

        while (!opcionDirector.equals("12")) {
            menuDirector(); //sobre qué desea hacer la accion: vendedor, coche o cliente
            opcionDirector = in.next();

            switch (opcionDirector) {
                case "1":
                    System.out.println("Nuevo vendedor");
                    Vendedor a = nuevoVendedor();
                    concesionario.anyadirVendedor(a.getDni(), a); //añade el vendedor a la lista de vendedores
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
                    //System.out.println("Nuevo formulario de coche");
                    altaCoche();
                    break;
                case "6":
                    //System.out.println("Vender coche");
                    venderCoche();
                    break;
                case "7":
                    //System.out.println("Reservar coche");
                    reservarCoche();
                    break;
                case "8":
                    elegirListaCoche();
                    break;
                case "9":
                case "10":
                case "11":
                case "12":
                    break;
                default:
                    System.out.println("Debe introducir una de las opciones: del 1 al 4");
                    break;
            }
        }
    }


    public void menuDirector() {
        System.out.println("Menu del director comercial");

        System.out.println("1- Dar de alta un vendedor");
        System.out.println("2- Dar de baja un vendedor");
        System.out.println("3- Modificar un vendedor");
        System.out.println("4- Consultar listas vendedores"); //lista vendedores y lista de coches vendidos por 1 vendedor
        //consultar sueldo vendedor
        System.out.println("5- Dar de alta un coche");
        System.out.println("6- Vender Coche");
        System.out.println("7- Reservar Coche");
        System.out.println("8- Consultar listas de coches");
        System.out.println("9- Dar de alta un cliente");
        System.out.println("10- Dar de baja un cliente");
        System.out.println("11- Consultar lista clientes");
        System.out.println("12- Salir");
        //lista vendedores y clientes
    }

    public void borrarVendedor() throws NotExistsException {
        boolean seguir = true;
        Scanner in = new Scanner((System.in));
        //System.out.println("Eliminar vendedor");
        System.out.println("Introduzca el DNI del vendedor que desea eliminar:");
        String dni = in.next(); // pedir dni
        Vendedor a = concesionario.buscarVendedor(dni); //asignar vendedor del dni
        do {
            try {
                concesionario.buscarVendedor(dni);
                seguir = false;
            } catch (NotExistsException e) {
                System.out.println(e.getMessage());
                System.out.println("Ingrese de nuevo el dni o pulse 0 para salir");
                dni = in.next();
                if (dni.equals("0")) { seguir = false;} //si pulsa 0 te saca del bucle
            }
        } while (seguir=true);

        seguir = true;
        //if (dni.equals("0")) break;
        concesionario.borrarVendedor(dni,a); // borrar vendedor
        System.out.println("domain.Vendedor borrado con éxito");
        //break;
    }

    public void menuModificarVendedor(){
        System.out.println("Elija la opción del dato a modificar:");
        System.out.println("1- Modificar dirección");
        System.out.println("2- Modificar teléfono");
        System.out.println("3- Salir");
    }

    public void modificarVendedor() throws IsEmptyException, NotNullException, NotExistsException {

    Scanner in = new Scanner((System.in));
        boolean seguir = true;
        int modificar = 0;

        while (modificar != 3) {
            menuModificarVendedor();
            modificar = in.nextInt();

            switch (modificar) {
                case 1:
                    System.out.println("Introduzca el DNI del vendedor que desea modificar");
                    String dni = in.next(); //pedir dni

                    do {
                        try {
                            concesionario.buscarVendedor(dni);
                            System.out.println("Introduzca la nueva dirección");
                            String direccion =in.next();
                            concesionario.modificarDireccionVendedor(dni, direccion);
                            System.out.println("Vendedor modificado con éxito");
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
                case 2:

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

                        }
                        while (seguir == true) ;

                        seguir = true;
                        concesionario.modificarTelefonoVendedor(dni2, telefono);
                        System.out.println("Vendedor modificado con éxito");
                        break;
                    }while (seguir==true);

                default:
                    System.out.println("Debe introducir una de las opciones: del 1 al 4");
                    seguir=false;
                    break;
            }
            //menuDirector();
            //opcionDirector = in.nextInt();
        }

    }

    public void menuListasVendedor(){
        System.out.println("Elija una lista");
        System.out.println("1- Lista de vendedores");
        System.out.println("2- Lista de coches vendidor por un vendedor");
        System.out.println("3- Sueldo de un vendedor");
        System.out.println("4- Salir");
    }

    public void elegirListaVendedor() throws AlreadyExistsException, IsEmptyException, InvalidException, NotNullException, NotExistsException {
        Scanner in = new Scanner((System.in));
        int listaVendedor = 0;

        while(listaVendedor != 4) {
            menuListasVendedor();
            listaVendedor = in.nextInt();

            switch (listaVendedor) {

                case 1:
                    concesionario.imprimirVendedores();
                    break;
                case 2:
                    System.out.println("Introduzca el DNI del vendedor");
                    String dni = in.next();
                    Vendedor v = concesionario.buscarVendedor(dni);
                    v.imprimirCochesVendidos();
                case 3:
                case 4:
                    break;
                default:
                    System.out.println("Debe introducir una de las opciones: del 1 al 4");
                    break;
            }
        }
    }



    public Vendedor nuevoVendedor() throws IsEmptyException, InvalidException, NotNullException, AlreadyExistsException, NotExistsException {
        FormularioAltaVendedor alta = new FormularioAltaVendedor();
        Vendedor v = alta.nuevoVendedor();
        return v;
    }

    public void menuListaCoche(){
        System.out.println("Elija una lista");
        System.out.println("1- Lista Coches");
        System.out.println("2- Lista coches en venta");
        System.out.println("3- Lista coches reservados");
        System.out.println("4- Lista coches vendidos");
        System.out.println("5- Salir");
    }


    public void elegirListaCoche()  {
        Scanner in = new Scanner((System.in));
        String listaCoches = "0";

        while (!listaCoches.equals("5")) {
            menuListaCoche();
            listaCoches = in.next();

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
                    System.out.println("Debe introducir una de las opciones: del 1 al 5");
                    break;
            }
        }
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
        String tipoCoche = "0";

        /*while(tipoCoche != 4) {
            menuAltaCoche();
            tipoCoche = in.nextInt();

            switch (tipoCoche) {

                case 1:
                    do {
                        try {
                            CocheTodoterreno c = alta.nuevoTodoterreno();
                            concesionario.anyadirCoche(c.getMatricula(), c); //Se añade a la lista de coches
                            concesionario.anyadirCocheEnVenta(c.getMatricula(), c);
                            seguir = false;
                        } catch (IsEmptyException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Introduzca de nuevo el dato o pulse 0 para salir");
                            String dato = in.next();
                            if (dato.equals("0")) {
                                seguir = false;
                            } //si pulsa 0 te saca del bucle
                        } catch (NotNullException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Introduzca de nuevo el dato o pulse 0 para salir");
                            String dato = in.next();
                            if (dato.equals("0")) {
                                seguir = false;
                            } //si pulsa 0 te saca del bucle
                        } catch (InvalidException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Introduzca de nuevo el dato o pulse 0 para salir");
                            String dato = in.next();
                            if (dato.equals("0")) {
                                seguir = false;
                            } //si pulsa 0 te saca del bucle
                        } catch (AlreadyExistsException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Introduzca de nuevo el dato o pulse 0 para salir");
                            String dato = in.next();
                            if (dato.equals("0")) {
                                seguir = false;
                            } //si pulsa 0 te saca del bucle
                        }
                    } while (seguir == true);

                    seguir=true;
                    break;
                case 2:
                    do {
                        try {
                            CocheIndustrial c = alta.nuevoIndustrial();
                            concesionario.anyadirCoche(c.getMatricula(), c); //Se añade a la lista de coches
                            concesionario.anyadirCocheEnVenta(c.getMatricula(), c);
                            seguir = false;
                        } catch (IsEmptyException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Introduzca de nuevo el dato o pulse 0 para salir");
                            String dato = in.next();
                            if (dato.equals("0")) {
                                seguir = false;
                            } //si pulsa 0 te saca del bucle
                        } catch (NotNullException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Introduzca de nuevo el dato o pulse 0 para salir");
                            String dato = in.next();
                            if (dato.equals("0")) {
                                seguir = false;
                            } //si pulsa 0 te saca del bucle
                        } catch (InvalidException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Introduzca de nuevo el dato o pulse 0 para salir");
                            String dato = in.next();
                            if (dato.equals("0")) {
                                seguir = false;
                            } //si pulsa 0 te saca del bucle
                        } catch (AlreadyExistsException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Introduzca de nuevo el dato o pulse 0 para salir");
                            String dato = in.next();
                            if (dato.equals("0")) {
                                seguir = false;
                            } //si pulsa 0 te saca del bucle
                        }
                    } while (seguir = true);

                    seguir = true;
                    break;

                case 3:
                    do {
                        try {
                            CocheTurismo c = alta.nuevoTurismo();
                            concesionario.anyadirCoche(c.getMatricula(), c); //Se añade a la lista de coches
                            concesionario.anyadirCocheEnVenta(c.getMatricula(), c);
                            seguir = false;
                        } catch (IsEmptyException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Introduzca de nuevo el dato o pulse 0 para salir");
                            String dato = in.next();
                            if (dato.equals("0")) {
                                seguir = false;
                            } //si pulsa 0 te saca del bucle
                        } catch (NotNullException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Introduzca de nuevo el dato o pulse 0 para salir");
                            String dato = in.next();
                            if (dato.equals("0")) {
                                seguir = false;
                            } //si pulsa 0 te saca del bucle
                        } catch (InvalidException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Introduzca de nuevo el dato o pulse 0 para salir");
                            String dato = in.next();
                            if (dato.equals("0")) {
                                seguir = false;
                            } //si pulsa 0 te saca del bucle
                        } catch (AlreadyExistsException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Introduzca de nuevo el dato o pulse 0 para salir");
                            String dato = in.next();
                            if (dato.equals("0")) {
                                seguir = false;
                            } //si pulsa 0 te saca del bucle
                        }
                    } while (seguir = true);
                    break;

            }
        }*/

        /*while (!tipoCoche.equals("4")) {
            menuAltaCoche();
            tipoCoche = in.next();

            do {
                try {
                    switch (tipoCoche) {
                        case "1":
                            CocheTodoterreno a = alta.nuevoTodoterreno();
                            concesionario.anyadirCoche(a.getMatricula(), a);
                            concesionario.anyadirCocheEnVenta(a.getMatricula(), a);
                            seguir = false;
                            break;

                        case "2":
                            CocheIndustrial b = alta.nuevoIndustrial();
                            concesionario.anyadirCoche(b.getMatricula(), b);
                            concesionario.anyadirCocheEnVenta(b.getMatricula(), b);
                            seguir = false;
                            break;

                        case "3":
                            CocheTurismo c = alta.nuevoTurismo();
                            concesionario.anyadirCoche(c.getMatricula(), c);
                            concesionario.anyadirCocheEnVenta(c.getMatricula(), c);
                            seguir = false;
                            break;
                        case "4":
                            break;
                        default:
                            System.out.println("Debe introducir una de las opciones: del 1 al 4");
                            seguir=false;
                            break;
                    }
                } catch (AlreadyExistsException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Introduzca de nuevo el dato o pulse 0 para salir");
                    String dato = in.next();
                    if (dato.equals("0")) {
                        seguir = false;
                    }
                }
            }while (seguir==true);
        }
    }

    public void venderCoche() throws NotExistsException {
        boolean seguir = true;
        Scanner in = new Scanner((System.in));
        System.out.println("Introduzca la matrícula del coche que va a ser vendido: ");
        String matriculaVender = in.next();
        concesionario.buscarCocheVenta(matriculaVender);
        do {
            try {
                concesionario.venderCocheDirector(matriculaVender);
                seguir = false;
            } catch (NotExistsException e) {
                e.getMessage();
                System.out.println("Introduzca de nuevo el dato o pulse 0 para salir");
                String dato = in.next();
                if (dato.equals("0")) {
                    seguir = false;
                }

            } catch (AlreadyExistsException e) {
                e.getMessage();
                System.out.println("Introduzca de nuevo el dato o pulse 0 para salir");
                String dato = in.next();
                if (dato.equals("0")) {
                    seguir = false;
                }
            }
        }while (seguir == true);
    }

    public void reservarCoche() throws NotExistsException {
        boolean seguir = true;
        Scanner in = new Scanner((System.in));
        System.out.println("Introduzca la matrícula del coche que va a ser reservado: ");
        String matriculaReservar = in.next();
        concesionario.buscarCocheVenta(matriculaReservar);
        do {
            try {
                concesionario.reservarCocheDirector(matriculaReservar);
                seguir = false;
            } catch (NotExistsException e) {
                e.getMessage();
                System.out.println("Introduzca de nuevo el dato o pulse 0 para salir");
                String dato = in.next();
                if (dato.equals("0")) {
                    seguir = false;
                }
            }
        }while (seguir == true);
    }*/

}



