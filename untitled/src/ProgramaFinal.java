import Excepciones.*;
import Formularios.*;
import domain.Concesionario;

import java.util.Scanner;

public class ProgramaFinal {

    private Concesionario concesionario;

    public ProgramaFinal(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public void startPrograma() throws AlreadyExistsException, IsEmptyException, NotExistsException, InvalidException, NullException {
        Scanner in = new Scanner((System.in));
        String identificacion = "0";

        while (!identificacion.equals("4")) {
            menu();
            identificacion = in.next();
            System.out.println("--------------");

            switch (identificacion) {
                case "1":
                    MenuDirectorComercial a = new MenuDirectorComercial(concesionario);
                    a.startMenuDirector();
                    break;
                case "2":
                    if (concesionario.getVendedores().isEmpty()) { //Si no hay vendedores dados de alta
                        empezarVendedor();
                        break;
                    }
                    MenuVendedor b = new MenuVendedor(concesionario);
                    b.startMenuVendedor();
                    break;
                case "3":
                    if(concesionario.getClientes().isEmpty()){ //Si no hay clientes dados de alta
                        empezarCliente();
                        break;
                    }
                    MenuCliente c = new MenuCliente(concesionario);
                    c.startMenuCliente();
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

    public void empezarVendedor() throws AlreadyExistsException, IsEmptyException, NotExistsException, InvalidException, NullException {
        Scanner in = new Scanner((System.in));

        if (concesionario.getVendedores().isEmpty()) {
            System.out.println("Todavía no hay vendedores dados de alta");
            System.out.println("Para ello, identifíquese como Director comercial");
            System.out.println("--------------");
        }
    }

    public void empezarCliente() throws AlreadyExistsException, IsEmptyException, NotExistsException, InvalidException, NullException {
        Scanner in = new Scanner((System.in));
        String salir = "1";

        if(concesionario.getClientes().isEmpty()) {
            System.out.println("Todavía no hay clientes dados de alta");
            System.out.println("Para ello, identifíquese como Director comercial o como vendedor");
            System.out.println("--------------");
        }
    }

    public void menu(){
        System.out.println("Identifíquese");
        System.out.println("1- Director Comercial");
        System.out.println("2- Vendedor");
        System.out.println("3- Cliente");
        System.out.println("4- Cerrar programa");
        System.out.print("Introduzca un número: ");
    }
}
