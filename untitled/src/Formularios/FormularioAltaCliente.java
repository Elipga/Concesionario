package Formularios;

import Excepciones.*;
import domain.Cliente;
import domain.Concesionario;
import domain.Vendedor;

import java.util.Scanner;

public class FormularioAltaCliente {

    private Concesionario concesionario;

    public Cliente nuevoCliente() throws AlreadyExistsException, IsEmptyException, NotExistsException, InvalidException, NotNullException {
        boolean seguir = true;
        Scanner in = new Scanner((System.in));
        OpcionesCliente o = new OpcionesCliente(concesionario);

        do {
            try {
                System.out.println("Nuevo formulario de cliente");
                System.out.println("Nombre");
                String nombre = in.next();
                in.nextLine(); //limpia la entrada: si no cogería una cadena vacía porque se queda con el salto de linea
                System.out.println("Dirección");
                String direccion = in.nextLine(); //next line es para ingresar más de una palabra
                System.out.println("DNI");
                String dni = in.next();
                System.out.println("Teléfono");
                String telefono = in.next();

                return new Cliente(nombre, direccion, dni, telefono);
            } catch (NotNullException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla + enter si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                String tecla = in.next();
                if (tecla.equals("0")) { o.nuevoCliente();

                }
                ;
            } catch (IsEmptyException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla + enter si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                String tecla = in.next();
                if (tecla.equals("0")) { o.nuevoCliente();

                }
            } catch (InvalidException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla + enter si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                String tecla = in.next();
                if (tecla.equals("0")) { o.nuevoCliente();

                }
                ;
            }
        }while (seguir==true);

        return null;
    }

}
