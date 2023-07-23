import Excepciones.*;
import Formularios.*;
import domain.Concesionario;

import java.util.Scanner;

public class ProgramaFinal {

    private Concesionario concesionario;

    public ProgramaFinal(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public void startPrograma() throws AlreadyExistsException, IsEmptyException, NotExistsException, InvalidException, NotNullException {
        Scanner in = new Scanner((System.in));
        int identificacion = 0;

        while (identificacion != 4) {
            menu();
            identificacion = in.nextInt();

            switch (identificacion) {
                case 1:
                    MenuDirectorComercial a = new MenuDirectorComercial(concesionario);
                    a.startMenuDirector();
                    break;
                case 2:
                    empezarVendedor();
                    MenuVendedor b = new MenuVendedor(concesionario);
                    b.startMenuVendedor();
                case 3:
                    empezarCliente();
                    MenuCliente c = new MenuCliente(concesionario);
                    c.startMenuCliente();
                case 4:
                    break;
                default:
                    System.out.println("Debe introducir una de las opciones: del 1 al 4");
                    System.out.println("--------------");
                    break;
            }
        }
    }

    public void empezarVendedor() throws AlreadyExistsException, IsEmptyException, NotExistsException, InvalidException, NotNullException {
        Scanner in = new Scanner((System.in));

        if (concesionario.getVendedores().isEmpty()) {
            System.out.println("Todavía no hay vendedores dados de alta");
            System.out.println("Para identificarse como vendedor primero hay que dar de alta un primer vendedor");
            System.out.println("Para ello, identifíquese como Director comercial");
            System.out.println("--------------");
            startPrograma();
        }
    }

    public void empezarCliente() throws AlreadyExistsException, IsEmptyException, NotExistsException, InvalidException, NotNullException {
        Scanner in = new Scanner((System.in));
        String salir = "1";

        if(concesionario.getClientes().isEmpty()) {
            System.out.println("Todavía no hay clientes dados de alta");
            System.out.println("Para identificarse como cliente primero hay que dar de alta un primer cliente");;
            System.out.println("Para ello, identifíquese como Director comercial");
            System.out.println("--------------");
            startPrograma();
        }
    }

    public void menu(){
        System.out.println("Identifíquese");
        System.out.println("1- Director Comercial");
        System.out.println("2- Vendedor");
        System.out.println("3- Cliente");
        System.out.println("4- Cerrar programa");
        System.out.println("--------------");
    }


}
