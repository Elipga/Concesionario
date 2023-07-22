import Excepciones.*;
import Formularios.MenuDirectorComercial;
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
                    MenuDirectorComercial m = new MenuDirectorComercial(concesionario);
                    m.startMenuDirector();
                    break;
                case 2:
                case 3:
                case 4:
                    break;
                default:
                    System.out.println("Debe introducir una de las opciones: del 1 al 4");
                    break;
            }
        }
    }

    public void menu(){
        System.out.println("Programa del concesionario");
        System.out.println("Identifíquese");
        System.out.println("1- Director Comercial");
        System.out.println("2- Vendedor");
        System.out.println("3- Cliente");
        System.out.println("4- Cerrar programa");
    }
}
