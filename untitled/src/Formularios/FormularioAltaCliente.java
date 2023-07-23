package Formularios;
import Excepciones.*;
import domain.Cliente;
import domain.Concesionario;
import java.util.Scanner;

public class FormularioAltaCliente {

    private Concesionario concesionario;

    public Cliente nuevoCliente() throws AlreadyExistsException, IsEmptyException, NotExistsException, InvalidException, NotNullException {
        boolean seguir = true;
        Scanner in = new Scanner((System.in));
        OpcionesCliente o = new OpcionesCliente(concesionario);

        do {
            try {
                System.out.println("Nuevo formulario de cliente: ");
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
                return new Cliente(nombre, direccion, dni, telefono);
            } catch (NotNullException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                System.out.println("--------------");
                String tecla = in.next();
                if (tecla.equals("0")) { o.nuevoCliente();
                }
                ;
            } catch (IsEmptyException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                System.out.println("--------------");
                String tecla = in.next();
                if (tecla.equals("0")) { o.nuevoCliente();
                }
            } catch (InvalidException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                System.out.println("--------------");
                String tecla = in.next();
                if (tecla.equals("0")) { o.nuevoCliente();
                }
                ;
            }
        }while (seguir==true);
        return null;
    }
}
