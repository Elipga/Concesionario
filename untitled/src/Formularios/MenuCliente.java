package Formularios;

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

        while (!menuCliente.equals("2")){
            menu();
            menuCliente = in.next();

            switch (menuCliente){
                case "1":
                    concesionario.imprimirEnVenta();
                    break;
                case "2":
                    break;
                default:
                    System.out.println("Debe introducir una de las opciones: del 1 al 2");
                    break;
            }
        }
    }

    public void menu(){
        System.out.println("Qué desea hacer?");
        System.out.println("1- Consultar lista de coches en venta");
        System.out.println("2- Salir");
    }
}
