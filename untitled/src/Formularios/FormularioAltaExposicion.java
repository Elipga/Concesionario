package Formularios;

import Excepciones.AlreadyExistsException;
import Excepciones.InvalidException;
import Excepciones.PreconditionException;
import domain.Concesionario;
import domain.Exposicion;
import domain.Vendedor;

import java.util.Scanner;

public class FormularioAltaExposicion {
    private Concesionario concesionario;

    public FormularioAltaExposicion(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public void nuevaExposicion(){
        Validaciones a = new Validaciones();
        boolean seguir = true;
        Scanner in = new Scanner((System.in));
        OpcionesExposicion o = new OpcionesExposicion(concesionario);

        do {
            try {
                System.out.println("Nuevo formulario de exposición");
                System.out.print("NumExpo: ");
                String numExpo = in.nextLine();
                a.validateNumExpo(numExpo);
                System.out.println("--------------");
                System.out.print("Dirección: ");
                String direccion = in.nextLine(); //next line es para ingresar más de una palabra
                a.validateDireccion(direccion);
                System.out.println("--------------");
                System.out.print("Teléfono móvil: ");
                String telefono = in.nextLine();
                a.validateTelefono(telefono);
                System.out.println("--------------");
                Exposicion e =  new Exposicion(numExpo, direccion, telefono);
                concesionario.anyadirExposicion(numExpo, e);
                System.out.println("Exposición dada de alta con éxito");
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
