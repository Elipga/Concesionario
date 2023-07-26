package Formularios;

import Excepciones.*;
import domain.Concesionario;

import java.util.Scanner;

public class MenuVendedor {

    private Concesionario concesionario;

    public MenuVendedor(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public void startMenuVendedor() throws AlreadyExistsException, IsEmptyException, NotExistsException, InvalidException, NullException {
        Scanner in = new Scanner((System.in));
        String opcionVendedor = "0";
        String dni = identificarseVendedor();


        while (!opcionVendedor.equals("3")){
            menu();
            opcionVendedor = in.next();
            System.out.println("--------------");


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

    private String identificarseVendedor() throws AlreadyExistsException, IsEmptyException, NotExistsException, InvalidException, NullException {
        Scanner in = new Scanner((System.in));
        ProgramaFinal p = new ProgramaFinal(concesionario);
        boolean seguir = true;

        do {
            try {
                System.out.print("Introduzca su DNI: ");
                String dni = in.next();
                System.out.println("--------------");
                concesionario.buscarVendedor(dni);
                System.out.println("Vendedor identificado con éxito");
                return dni;
            } catch (NotExistsException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla para volver a intentarlo o pulse 0 para salir: ");
                String tecla = in.next();
                System.out.println("--------------");
                if (tecla.equals("0")) {
                    p.startPrograma();
                    seguir = false;
                }
            }
        }while (seguir == true);
        return "-1";
    }

    public void menu(){
        System.out.println("Elija una opción: ");
        System.out.println("1- Gestión de coches");
        System.out.println("2- Gestión de clientes");
        System.out.println("3- Salir");
        System.out.print("Introduzca un número: ");
    }
}
