package Formularios;

import Excepciones.*;
import domain.Coche;
import domain.Concesionario;
import domain.Exposicion;
import domain.Vendedor;

import java.util.Scanner;

public class OpcionesExposicion {

    private Concesionario concesionario;

    public OpcionesExposicion(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public void startOpcionesExposicion() throws NotExistsException, IsEmptyException, InvalidException, NullException {
        Scanner in = new Scanner((System.in));
        String opcionExposicion = "0";

        while (!opcionExposicion.equals("8")) {
            menu();
            opcionExposicion = in.next();
            System.out.println("--------------");

            switch (opcionExposicion) {
                case "1":
                    FormularioAltaExposicion alta = new FormularioAltaExposicion(concesionario);
                    alta.nuevaExposicion();
                    break;
                case "2":
                    bajaExposicion();
                    break;
                case "3":
                    modificarExposicion();
                    break;
                case "4":
                    anyadirCocheAExpo();
                    break;
                case "5":
                    borrarCocheDeExpo();
                    break;
                case "6":
                    cambiarCocheDeExposicion();
                    break;
                case "7":
                    eligirListaExposicion();
                    break;
                case "8":
                    break;
                default:
                    System.out.println("Debe introducir una de las opciones: del 1 al 6");
                    System.out.println("--------------");
                    break;
            }
        }
    }

    public void borrarCocheDeExpo() {
        Scanner in = new Scanner(System.in);
        boolean seguir = true;

        do {
            try {
                System.out.println("Introduzca la matrícula del coche: ");
                String matricula = in.next();
                System.out.println("--------------");
                Coche c = concesionario.buscarCoche(matricula);
                System.out.print("Introduzca el número de exposición: ");
                String numExpo = in.next();
                System.out.println("--------------");
                Exposicion a = concesionario.buscarExposicion(numExpo);
                a.borrarCoche(matricula, c);
                System.out.println("Coche borrado con éxito");

            } catch (NotExistsException e) {
                System.out.println(e.getMessage());
                System.out.print("Pulse una tecla para volverlo a intentar o pulse 0 para salir: ");
                String tecla = in.next();
                System.out.println("--------------");
                if (tecla.equals("0")) {
                    seguir = false;
                }
            }
        }while (seguir == true) ;
    }

    public void anyadirCocheAExpo() {
        Scanner in = new Scanner(System.in);
        boolean seguir = true;

        do {
            try {
                System.out.println("Introduzca la matrícula del coche: ");
                String matricula = in.next();
                System.out.println("--------------");
                Coche c = concesionario.buscarCoche(matricula);
                System.out.print("Introduzca el número de exposición: ");
                String numExpo = in.next();
                System.out.println("--------------");
                Exposicion a = concesionario.buscarExposicion(numExpo);
                a.anyadirCoche(matricula, c);
                System.out.println("Coche añadido con éxito");

            } catch (AlreadyExistsException e) {
                System.out.println(e.getMessage());
                System.out.print("Pulse una tecla para volverlo a intentar o pulse 0 para salir: ");
                String tecla = in.next();
                System.out.println("--------------");
                if (tecla.equals("0")) {
                    seguir = false;
                }


            } catch (NotExistsException e) {
                System.out.println(e.getMessage());
                System.out.print("Pulse una tecla para volverlo a intentar o pulse 0 para salir: ");
                String tecla = in.next();
                System.out.println("--------------");
                if (tecla.equals("0")) {
                    seguir = false;
                }
            }
        }while (seguir == true) ;
    }


    public void cambiarCocheDeExposicion() {
        Scanner in = new Scanner((System.in));
        boolean seguir = true;

        do {
            try {
                System.out.print("Introduzca la matrícula del coche que quiere cambiar de exposición: ");
                String matricula = in.next();
                System.out.println("--------------");
                Coche c = concesionario.buscarCoche(matricula);
                System.out.print("Introduzca el número de exposición de la que quiere mover el coche: ");
                String expoAnterior = in.next();
                System.out.println("--------------");
                Exposicion a = concesionario.buscarExposicion(expoAnterior);
                System.out.println("Introduzca el número de exposición a la que quiere mover el coche: ");
                String expoNueva = in.next();
                System.out.println("--------------");
                Exposicion n = concesionario.buscarExposicion(expoNueva);
                concesionario.cambiarCoche(a, n, matricula, c);
                System.out.println("El coche ha sido cambiado de exposición con éxito");
                seguir = false;

            } catch (NotExistsException e) {
                System.out.println(e.getMessage());
                System.out.print("Pulse una tecla para volverlo a intentar o pulse 0 para salir: ");
                String tecla = in.next();
                System.out.println("--------------");
                if (tecla.equals("0")) {
                    seguir = false;
                }
            } catch (AlreadyExistsException e) {
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

    public void menu() {
        System.out.println("1- Dar de alta una exposición");
        System.out.println("2- Dar de baja una exposición");
        System.out.println("3- Modificar una exposición");
        System.out.println("4- Añadir coche a exposición");
        System.out.println("5- Borrar coche de exposición");
        System.out.println("6- Cambiar coche de exposición");
        System.out.println("7- Consultar listas exposiciones");
        System.out.println("8- Salir");
        System.out.print("Introduzca un número: ");
    }

    public void menuModificarExposicion() {
        System.out.println("Elija la opción del dato a modificar:");
        System.out.println("1- Modificar dirección");
        System.out.println("2- Modificar teléfono");
        System.out.println("3- Salir");
        System.out.print("Introduzca un número: ");
    }

    public void modificarExposicion() {
        Scanner in = new Scanner((System.in));
        boolean seguir = true;
        String modificar = "0";
        String numExpo;

        while (!modificar.equals("3")) {
            menuModificarExposicion();
            modificar = in.next();
            System.out.println("--------------");

            switch (modificar) {
                case "1":
                    System.out.print("Introduzca el número de exposición que desea modificar: ");
                    numExpo = in.next();
                    System.out.println("--------------");

                    do {
                        try {
                            concesionario.buscarExposicion(numExpo);
                            System.out.print("Introduzca la nueva dirección: ");
                            in.nextLine();
                            String direccion = in.nextLine();
                            System.out.println("--------------");
                            concesionario.modificarDireccionExposicion(numExpo, direccion);
                            System.out.println("Eposición modificada con éxito");
                            System.out.println("--------------");
                            seguir = false;
                        } catch (NotExistsException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Ingrese de nuevo el número de exposición o pulse 0 para salir: ");
                            numExpo = in.next();
                            System.out.println("--------------");
                            if (numExpo.equals("0")) {
                                seguir = false;
                            } //si pulsa 0 te saca del bucle
                        } catch (AlreadyExistsException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Ingrese de nuevo el número de exposición o pulse 0 para salir: ");
                            numExpo = in.next();
                            System.out.println("--------------");
                            if (numExpo.equals("0")) {
                                seguir = false;
                            } //si pulsa 0 te saca del bucle
                        }
                    } while (seguir == true);
                    seguir = true;
                    break;

                case "2":
                    System.out.println("Introduzca el número de exposición que desea modificar: ");
                    numExpo = in.next(); //pedir dni
                    System.out.println("--------------");
                    do {
                        try {
                            concesionario.buscarExposicion(numExpo);
                            System.out.print("Introduzca el nuevo teléfono: ");
                            String telefono = in.next();
                            System.out.println("--------------");
                            concesionario.modificarTelefonoExposición(numExpo, telefono);
                            System.out.println("Exposición modificada con éxito");
                            System.out.println("--------------");
                            seguir = false;
                        } catch (NotExistsException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Ingrese de nuevo el número de exposición o pulse 0 para salir: ");
                            numExpo = in.next();
                            System.out.println("--------------");
                            if (numExpo.equals("0")) {
                                seguir = false;
                            } //si pulsa 0 te saca del bucle
                        } catch (AlreadyExistsException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Ingrese de nuevo el número de exposición o pulse 0 para salir: ");
                            numExpo = in.next();
                            System.out.println("--------------");
                            if (numExpo.equals("0")) {
                                seguir = false;
                            } //si pulsa 0 te saca del bucle
                        }
                    } while (seguir == true);
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Debe introducir una de las opciones: del 1 al 3");
                    System.out.println("--------------");
                    seguir = false;
                    break;
            }
        }
    }

    public void bajaExposicion() {
        boolean seguir = true;
        Scanner in = new Scanner((System.in));

        do {
            try {
                System.out.print("Introduzca el número de exposición que desea eliminar:");
                String numExpo = in.next(); // pedir numExpo
                System.out.println("--------------");
                concesionario.buscarExposicion(numExpo);
                concesionario.borrarExposicion(numExpo);
                System.out.println("Exposición borrada con éxito");
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
            }
        } while (seguir == true);
    }

    public void menuListasExposicion() {
        System.out.println("Elija una lista");
        System.out.println("1- Lista de exposiciones");
        System.out.println("2- Lista de coches de una exposición");
        System.out.println("3- Salir");
        System.out.print("Introduzca un número: ");
    }

    public void eligirListaExposicion() {
        Scanner in = new Scanner((System.in));
        String listaExposicion = "0";
        boolean seguir = true;


        while (!listaExposicion.equals("3")) {
            menuListasExposicion();
            listaExposicion = in.next();
            System.out.println("--------------");

            switch (listaExposicion) {
                case "1":
                    concesionario.imprimirExposiciones();
                    break;
                case "2":
                    do {
                        String numExpo;
                        try {
                            System.out.print("Introduzca el número de exposición: ");
                            numExpo = in.next();
                            System.out.println("--------------");
                            Exposicion e = concesionario.buscarExposicion(numExpo);
                            e.imprimirCochesEnExpo();
                            seguir = false;
                        } catch (NotExistsException e) {
                            System.out.println(e.getMessage());
                            System.out.print("Ingrese de nuevo el número de exposición o pulse 0 para salir: ");
                            numExpo = in.next();
                            System.out.println("--------------");
                            if (numExpo.equals("0")) {
                                seguir = false;
                            }
                        }
                    } while (seguir == true);
                    seguir = false;
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Debe introducir una de las opciones: del 1 al 4");
                    break;
            }
        }
    }
}
