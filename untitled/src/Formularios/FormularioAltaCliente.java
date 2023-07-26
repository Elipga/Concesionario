package Formularios;
import Excepciones.*;
import domain.Cliente;
import domain.Concesionario;
import java.util.Scanner;

public class FormularioAltaCliente {

    private Concesionario concesionario;

    public Cliente nuevoCliente() throws AlreadyExistsException, IsEmptyException, NotExistsException, InvalidException, NullException {
        Validaciones a = new Validaciones();
        boolean seguir = true;
        Scanner in = new Scanner((System.in));
        OpcionesCliente o = new OpcionesCliente(concesionario);

        do {
            try {
                System.out.println("Nuevo formulario de cliente: ");
                System.out.print("Nombre: ");
                String nombre = in.next();
                a.validateNombre(nombre);
                System.out.println("--------------");
                in.nextLine(); //limpia la entrada: si no cogería una cadena vacía porque se queda con el salto de linea
                System.out.print("Dirección: ");
                String direccion = in.nextLine(); //next line es para ingresar más de una palabra
                a.validateDireccion(direccion);
                System.out.println("--------------");
                System.out.print("DNI: ");
                String dni = in.next();
                a.validateDni(dni);
                System.out.println("--------------");
                System.out.print("Teléfono móvil: ");
                String telefono = in.next();
                a.validateTelefono(telefono);
                System.out.println("--------------");
                return new Cliente(nombre, direccion, dni, telefono);
            } catch (PreconditionException e) {
                System.out.println(e.getMessage());
                System.out.print("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir: ");
                String tecla = in.next();
                System.out.println("--------------");
                if (tecla.equals("0")) {
                    o.nuevoCliente();
                }
            }
        }while (seguir==true);
        return null;
    }
}
