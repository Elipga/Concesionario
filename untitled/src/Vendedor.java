import java.util.ArrayList;

public class Vendedor extends Persona{
    public ArrayList<Vendedor>vendedores;

    public Vendedor(String nombre, String direccion, String dni, int telefono, ArrayList<Vendedor> vendedores) throws Exception {
        super(nombre, direccion, dni, telefono);
        this.vendedores = vendedores;
    }
}
