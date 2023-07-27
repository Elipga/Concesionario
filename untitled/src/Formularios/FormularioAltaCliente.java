package Formularios;
import Excepciones.*;
import domain.Cliente;
import domain.Concesionario;
import domain.Vendedor;

import java.util.Scanner;

public class FormularioAltaCliente {

    private Concesionario concesionario;

    public FormularioAltaCliente(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public void nuevoCliente() throws NotExistsException, NullException, IsEmptyException, InvalidException, AlreadyExistsException {
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
                String dni = in.nextLine();
                concesionario.comprobarCliente(dni);
                a.validateDni(dni);
                System.out.println("--------------");
                System.out.print("Teléfono móvil: ");
                String telefono = in.nextLine();
                a.validateTelefono(telefono);
                System.out.println("--------------");
                Cliente c =  new Cliente(nombre, direccion, dni, telefono);
                concesionario.anyadirCliente(dni, c);
                System.out.println("Cliente dado de alta con éxito");
                seguir = false;
            } catch (InvalidException e) {
                System.out.println(e.getMessage());
                System.out.print("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir: ");
                String tecla = in.next();
                in.nextLine();
                System.out.println("--------------");
                if (tecla.equals("0")) {
                    seguir= false;
                }
            } catch (PreconditionException e) {
                System.out.println(e.getMessage());
                System.out.print("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir: ");
                String tecla = in.next();
                in.nextLine();
                System.out.println("--------------");
                if (tecla.equals("0")) {
                    seguir = false;
                }
            } catch (AlreadyExistsException e) {
                System.out.println(e.getMessage());
                System.out.print("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir: ");
                String tecla = in.next();
                in.nextLine();
                System.out.println("--------------");
                if (tecla.equals("0")) {
                    seguir = false;
                }
            }
        }while (seguir==true);
    }
}
