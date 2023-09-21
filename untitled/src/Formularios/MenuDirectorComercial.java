package Formularios;
import Excepciones.*;
import domain.*;

import java.util.Scanner;

public class MenuDirectorComercial {

    private Concesionario concesionario;

    public MenuDirectorComercial(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public void startMenuDirector() throws AlreadyExistsException, IsEmptyException, NotExistsException, InvalidException, NullException {
        Scanner in = new Scanner((System.in));
        String opcion = "0";

        while (!opcion.equals("5")){
            menu();
            opcion = in.next();
            System.out.println("--------------");

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
                    OpcionesExposicion d = new OpcionesExposicion(concesionario);
                    d.startOpcionesExposicion();
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

    public void menu(){
        System.out.println("Elija una opción: ");
        System.out.println("1- Gestión de vendedores");
        System.out.println("2- Gestión de coches");
        System.out.println("3- Gestión de clientes");
        System.out.println("4- Gestión de exposciones");
        System.out.println("5- Salir");
        System.out.print("Introduzca un número: ");
    }
}



