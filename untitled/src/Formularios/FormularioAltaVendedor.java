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
                String nombre = in.next();
                in.nextLine(); //limpia la entrada: si no cogería una cadena vacía porque se queda con el salto de linea
                System.out.println("Dirección");
                String direccion = in.nextLine(); //next line es para ingresar más de una palabra
                System.out.println("DNI");
                String dni = in.next();
                System.out.println("Teléfono");
                String telefono = in.next();
                return new Vendedor(nombre, direccion, dni, telefono);
            } catch (NotNullException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla + enter si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                String tecla = in.next();
                if (tecla.equals("0")) { o.nuevoVendedor();

                }
                ;
            } catch (IsEmptyException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla + enter si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                String tecla = in.next();
                if (tecla.equals("0")) { o.nuevoVendedor();

                }
            } catch (InvalidException e) {
                System.out.println(e.getMessage());
                System.out.println("Pulse una tecla + enter si quiere comenzar de nuevo el formulario o pulse 0 para salir");
                String tecla = in.next();
                if (tecla.equals("0")) { o.nuevoVendedor();

                }
                ;
            }
        }while (seguir==true);

        return null;
    }


    public Vendedor altaVendedor() throws IsEmptyException, NotNullException, InvalidException {
            Vendedor v = new Vendedor();
            datos(v);
            return v;
        }



        public void datos(Vendedor v) {
            Scanner in = new Scanner((System.in));
            boolean seguir = true;
            System.out.println("Nuevo formulario de vendedor");
            System.out.println("Nombre");
            String nombre = in.next();

           do {
                try {
                    v.setNombre(nombre);
                    seguir = false;
                } catch (NotNullException e) {
                    e.getMessage();
                    System.out.println("Ingrese de nuevo el nombre");
                    nombre = in.next();
                } catch (IsEmptyException e) {
                    e.getMessage();
                    System.out.println("Ingrese de nuevo el nombre");
                    nombre = in.next();
                }
            } while(seguir == true);

           seguir = true;

            System.out.println("Dirección");
            String direccion = in.next();

            do {
                try {
                    v.setDireccion(direccion);
                    seguir = false;
                } catch (NotNullException e) {
                    e.getMessage();
                    System.out.println("Ingrese de nuevo la dirección");
                    direccion = in.next();
                } catch (IsEmptyException e) {
                    e.getMessage();
                    System.out.println("Ingrese de nuevo la dirección");
                    direccion = in.next();
                }
            } while(seguir == true);

            seguir = true;

            System.out.println("DNI");
            String dni = in.next();
            do {
                try {
                    v.setDni(dni);
                    seguir = false;
                } catch (NotNullException e) {
                    throw new RuntimeException(e);
                } catch (IsEmptyException e) {
                    throw new RuntimeException(e);
                }
            }while (seguir == true);

            seguir = true;

            System.out.println("Teléfono");
            String telefono = in.next();
            do {
                try {
                    v.setTelefono(telefono);
                    seguir = false;
                } catch (NotNullException e) {
                    e.getMessage();
                    System.out.println("Ingrese de nuevo el teléfono");
                    telefono = in.next();
                } catch (IsEmptyException e) {
                    e.getMessage();
                    System.out.println("Ingrese de nuevo el teléfono");
                    telefono = in.next();
                } catch (InvalidException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Ingrese de nuevo el teléfono");
                    telefono = in.next();
                }
            } while (seguir==true);

            seguir = true;

            System.out.println("Vendedor dado de alta con éxito");
        }
}
