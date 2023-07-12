import java.util.Scanner;

public class Programa {

    private Concesionario concesionario;

    public Programa(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public void start() throws IsEmptyException, InvalidException, NotNullException, AlreadyExistsException {
        System.out.println("Menu del vendedor");
        System.out.println("1- Dar de alta un coche");
        System.out.println("2- Lista Coches");
        Scanner in = new Scanner((System.in));
        int opcion = in.nextInt();

        switch (opcion){
            case 1:
                System.out.println("Nuevo formulario de coche");
                System.out.println("Qué tipo de coche?");
                System.out.println("1- Todoterreno");
                System.out.println("2- Industrial");
                System.out.println("3- Turismo");
                Coche c = nuevoCoche();
                concesionario.anyadirCoche(c.getMatricula(), c);
                concesionario.anyadirCocheEnVenta(c.getMatricula(),c);

            case 2: System.out.println("Elija una lista");
                System.out.println("1- Coches del Concesionario");
                System.out.println("2- Coches en venta");
                System.out.println("3- Coches en reparación");
                System.out.println("4- Coches reservados");
                System.out.println("5- Coches vendidos");
                int opcion2 = in.nextInt();
                switch (opcion2){
                    case 1: concesionario.imprimirCoches();
                    case 2: concesionario.imprimirEnVenta();
                    case 3: concesionario.imprimirEnReparacion();
                    case 4: concesionario.imprimirReservados();
                    case 5: concesionario.imprimirVendidos();
                }


        }
    }

    public Coche nuevoCoche() throws IsEmptyException, InvalidException, NotNullException {
        FormularioAltaCoche alta = new FormularioAltaCoche();
        Coche c = alta.altaCoche();
        return c;
    }

    public void elegirLista(){

    }




}
