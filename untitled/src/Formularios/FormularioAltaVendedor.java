package Formularios;

import Excepciones.*;
import domain.Concesionario;
import domain.Vendedor;

import java.util.Scanner;

public class FormularioAltaVendedor {

        private Concesionario concesionario;
        private MenuDirectorComercial menuDirectorComercial;

    public FormularioAltaVendedor(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public Vendedor nuevoVendedor() throws IsEmptyException, NotExistsException, InvalidException, NullException {
        Validaciones a = new Validaciones();
        boolean seguir = true;
        Scanner in = new Scanner((System.in));
        OpcionesVendedor o = new OpcionesVendedor(concesionario);

        do {
            try {
                System.out.println("Nuevo formulario de vendedor");
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
                concesionario.comprobarVendedor(dni);
                a.validateDni(dni);
                System.out.println("--------------");
                System.out.print("Teléfono móvil: ");
                String telefono = in.next();
                a.validateTelefono(telefono);
                System.out.println("--------------");
                return new Vendedor(nombre, direccion, dni, telefono);
            }    catch (InvalidException e) {
                    System.out.println(e.getMessage());
                    System.out.print("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir: ");
                    String tecla = in.next();
                    in.nextLine();
                    System.out.println("--------------");
                    if (tecla.equals("0")) {
                        o.nuevoVendedor();
                    }
            } catch (PreconditionException e) {
                System.out.println(e.getMessage());
                System.out.print("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir: ");
                String tecla = in.next();
                in.nextLine();
                System.out.println("--------------");
                if (tecla.equals("0")) {
                    o.nuevoVendedor();
                }
                ;
            } catch (AlreadyExistsException e) {
                System.out.println(e.getMessage());
                System.out.print("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir: ");
                String tecla = in.next();
                in.nextLine();
                System.out.println("--------------");
                if (tecla.equals("0")) {
                    o.nuevoVendedor();
                }
            }
        }while (seguir==true);

        return null;
    }
}
