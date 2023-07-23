package Formularios;

import Excepciones.*;
import domain.CocheTurismo;
import domain.Concesionario;
import domain.Vendedor;

import java.util.Scanner;

public class FormularioAltaVendedor {

        private Concesionario concesionario;
        private MenuDirectorComercial menuDirectorComercial;

    public Vendedor nuevoVendedor() throws IsEmptyException, NotExistsException, InvalidException, NotNullException, AlreadyExistsException {
        boolean seguir = true;
        Scanner in = new Scanner((System.in));
        OpcionesVendedor o = new OpcionesVendedor(concesionario);

        do {
            try {
                System.out.println("Nuevo formulario de vendedor");
                System.out.println("Nombre");
                System.out.println("--------------");
                String nombre = in.next();
                in.nextLine(); //limpia la entrada: si no cogería una cadena vacía porque se queda con el salto de linea
                System.out.println("Dirección");
                System.out.println("--------------");
                String direccion = in.nextLine(); //next line es para ingresar más de una palabra
                System.out.println("DNI");
                System.out.println("--------------");
                String dni = in.next();
                System.out.println("Teléfono móvil");
                System.out.println("--------------");
                String telefono = in.next();
                return new Vendedor(nombre, direccion, dni, telefono);
            } catch (NotNullException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                System.out.println("--------------");
                String tecla = in.next();
                if (tecla.equals("0")) { o.nuevoVendedor();
                }
                ;
            } catch (IsEmptyException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                System.out.println("--------------");
                String tecla = in.next();
                if (tecla.equals("0")) { o.nuevoVendedor();
                }
            } catch (InvalidException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                System.out.println("--------------");
                String tecla = in.next();
                if (tecla.equals("0")) { o.nuevoVendedor();
                }
                ;
            }
        }while (seguir==true);

        return null;
    }
}
