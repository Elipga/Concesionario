package Formularios;

import Excepciones.*;
import domain.Concesionario;

import java.util.Scanner;

public class MenuVendedor {

    private Concesionario concesionario;

    public MenuVendedor(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public void startMenuVendedor() throws AlreadyExistsException, IsEmptyException, NotExistsException, InvalidException, NotNullException {
        Scanner in = new Scanner((System.in));
        String opcionVendedor = "0";

        while (!opcionVendedor.equals("4")){
            menu();
            opcionVendedor = in.next();

            switch (opcionVendedor) {
                case "1":
                    OpcionesVendedor a = new OpcionesVendedor(concesionario);
                    a.startOpcionesVendedores();
                    break;
                case "2":
                    OpcionesCliente b = new OpcionesCliente(concesionario);
                    b.startOpcionesCliente();
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Debe introducir una de las opciones: del 1 al 3");
                    break;
            }
        }
    }

    public void menu(){
        System.out.println("Elija una opción: ");
        System.out.println("1- Gestión de coches");
        System.out.println("2- Gestión de clientes");
        System.out.println("3- Salir");
    }

}
