import java.util.Scanner;

public class FormularioAltaCoche {

    private Concesionario concesionario;

    public Coche altaCoche() throws IsEmptyException, InvalidException, NotNullException {
        Scanner in = new Scanner((System.in));
        int opcion = in.nextInt();

        switch (opcion){
            case 1:
                CocheTodoterreno c = new CocheTodoterreno();
                datos(c);
                return c;
            case 2:
                CocheIndustrial a = new CocheIndustrial();
                datos(a);
                return a;
            case 3:
                CocheTurismo b = new CocheTurismo();
                datos(b);
                return b;
        }
        return null;
    }

    public void datos(Coche c) throws IsEmptyException, NotNullException, InvalidException {
        Scanner in = new Scanner((System.in));
        System.out.println("Nuevo formulario de coche");
        System.out.println("Marca");
        String marca = in.next();
        c.setMarca(marca);
        System.out.println("Modelo");
        String modelo = in.next();
        c.setModelo(modelo);
        System.out.println("Matricula");
        String matricula = in.next();
        c.setMatricula(matricula);
        System.out.println("Precio de Compra");
        double precioCompra = in.nextDouble();
        c.setPrecioCompra(precioCompra);
        System.out.println("Precio de venta");
        double precioVenta = in.nextDouble();
        c.setPrecioVenta(precioVenta);
    }



}


