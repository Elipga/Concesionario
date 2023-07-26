package Formularios;
import Excepciones.*;
import domain.Cliente;
import domain.Concesionario;
import java.util.Scanner;

public class FormularioAltaCliente {

    private Concesionario concesionario;

    public FormularioAltaCliente(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public Cliente nuevoCliente() throws NotExistsException, NullException, IsEmptyException, InvalidException {
        Validaciones a = new Validaciones();
        boolean seguir = true;
        Scanner in = new Scanner((System.in));
        OpcionesCliente o = new OpcionesCliente(concesionario);

        do {
            try {
                System.out.println("Nuevo formulario de cliente: ");
                System.out.print("Nombre: ");
                String nombre = in.nextLine();
                a.validateNombre(nombre);
                System.out.println("--------------");
                System.out.print("Dirección: ");
                String direccion = in.nextLine(); //next line es para ingresar más de una palabra
                a.validateDireccion(direccion);
                System.out.println("--------------");
                System.out.print("DNI: ");
                String dni = in.next();
                concesionario.comprobarCliente(dni);
                a.validateDni(dni);
                System.out.println("--------------");
                System.out.print("Teléfono móvil: ");
                String telefono = in.next();
                a.validateTelefono(telefono);
                System.out.println("--------------");
                return new Cliente(nombre, direccion, dni, telefono);
            } catch (InvalidException e) {
                System.out.println(e.getMessage());
                System.out.print("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir: ");
                String tecla = in.next();
                in.nextLine();
                System.out.println("--------------");
                if (tecla.equals("0")) {
                    o.nuevoCliente();
                }
            } catch (PreconditionException e) {
                System.out.println(e.getMessage());
                System.out.print("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir: ");
                String tecla = in.next();
                in.nextLine();
                System.out.println("--------------");
                if (tecla.equals("0")) {
                    o.nuevoCliente();
                }
            } catch (AlreadyExistsException e) {
                System.out.println(e.getMessage());
                System.out.print("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir: ");
                String tecla = in.next();
                in.nextLine();
                System.out.println("--------------");
                if (tecla.equals("0")) {
                    o.nuevoCliente();
                }
            }
        }while (seguir==true);
        return null;
    }
}
