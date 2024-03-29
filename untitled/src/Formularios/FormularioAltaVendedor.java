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

    public void nuevoVendedor() throws IsEmptyException, NotExistsException, InvalidException, NullException, AlreadyExistsException {
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
                String dni = in.nextLine();
                concesionario.comprobarVendedor(dni);
                a.validateDni(dni);
                System.out.println("--------------");
                System.out.print("Teléfono móvil: ");
                String telefono = in.nextLine();
                a.validateTelefono(telefono);
                System.out.println("--------------");
                Vendedor v =  new Vendedor(nombre, direccion, dni, telefono);
                concesionario.anyadirVendedor(dni, v);
                System.out.println("Vendedor dado de alta con éxito");
                seguir = false;
            }    catch (InvalidException e) {
                    System.out.println(e.getMessage());
                    System.out.print("Pulse una tecla si quiere comenzar de nuevo el formulario o pulse 0 para salir: ");
                    String tecla = in.next();
                    in.nextLine();
                    System.out.println("--------------");
                    if (tecla.equals("0")) {
                        seguir = false;
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
                ;
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
