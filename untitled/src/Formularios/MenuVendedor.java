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
        String dni = identificarseVendedor();

        while (!opcionVendedor.equals("4")){
            menu();
            opcionVendedor = in.next();

            switch (opcionVendedor) {
                case "1":
                    OpcionesCoche a = new OpcionesCoche(concesionario);
                    a.startOpcionesCocheVendedor(dni);
                    break;
                case "2":
                    OpcionesCliente b = new OpcionesCliente(concesionario);
                    b.startOpcionesCliente();
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Debe introducir una de las opciones: del 1 al 3");
                    System.out.println("--------------");
                    break;
            }
        }
    }

    private String identificarseVendedor() {
        Scanner in = new Scanner((System.in));
        boolean seguir = true;

        do {
            try {
                System.out.println("Introduzca su DNI:");
                System.out.println("--------------");
                String dni = in.next();
                concesionario.buscarVendedor(dni);
                System.out.println("Vendedor identificado con éxito");
                return dni;
            } catch (NotExistsException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla para volver a intentarlo o pulse 0 para salir");
                System.out.println("--------------");
                String tecla = in.next();
                if (tecla.equals("0")) {
                    return identificarseVendedor();
                }
            }
        }while (seguir == true);
        return null;
    }

    public void menu(){
        System.out.println("Elija una opción: ");
        System.out.println("1- Gestión de coches");
        System.out.println("2- Gestión de clientes");
        System.out.println("3- Salir");
        System.out.println("--------------");
    }


}
