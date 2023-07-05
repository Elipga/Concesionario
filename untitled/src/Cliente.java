import java.util.ArrayList;

public class Cliente extends Persona {
    public ArrayList<Cliente> clientes;

    public Cliente(String nombre, String direccion, String dni, int telefono, ArrayList<Cliente> clientes) throws Exception {
        super(nombre, direccion, dni, telefono);
        this.clientes = clientes;
    }
}
