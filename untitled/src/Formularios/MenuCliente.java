package Formularios;

import Excepciones.NotExistsException;
import domain.Concesionario;

import java.util.Scanner;

public class MenuCliente {

    private Concesionario concesionario;

    public MenuCliente(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public void startMenuCliente(){
        Scanner in = new Scanner((System.in));
        String menuCliente = "0";
        String dni = identificarseCliente();

        while (!menuCliente.equals("2")){
            menu();
            menuCliente = in.next();
            System.out.println("--------------");

            switch (menuCliente){
                case "1":
                    concesionario.imprimirEnVenta();
                    break;
                case "2":
                    break;
                default:
                    System.out.println("Debe introducir una de las opciones: del 1 al 2");
                    System.out.println("--------------");
                    break;
            }
        }
    }

    private String identificarseCliente() {
        Scanner in = new Scanner((System.in));
        boolean seguir = true;

        do {
            try {
                System.out.print("Introduzca su DNI: ");
                String dni = in.next();
                System.out.println("--------------");
                concesionario.buscarCliente(dni);
                System.out.println("Cliente identificado con éxito");
                return dni;
            } catch (NotExistsException e) {
                System.out.println(e.getMessage());
                System.out.print("Pulse una tecla para volver a intentarlo o pulse 0 para salir: ");
                String tecla = in.next();
                System.out.println("--------------");
                if (tecla.equals("0")) {
                    return identificarseCliente();
                }
            }
        }while (seguir == true);
        return null;
    }


    public void menu(){
        System.out.println("Qué desea hacer?");
        System.out.println("1- Consultar lista de coches en venta");
        System.out.println("2- Salir");
        System.out.print("Introduzca un número: ");
    }
}
