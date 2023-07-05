
public class Persona {
    private String nombre;
    private String direccion;
    private String dni;
    private int telefono;

    public Persona(String nombre, String direccion, String dni, int telefono) throws Exception {
        this.nombre = nombre;
        validateName(nombre);
        this.direccion = direccion;
        validateDireccion(direccion);
        this.dni = dni;
        validateDNI(dni);
        this.telefono = telefono;
        validateTelefono(telefono);
    }
    private void validateName(String nombre) throws Exception{
        if (nombre == null) throw new Exception("Nombre no puede ser null");
        if (nombre.isEmpty())throw new Exception("Nombre no puede estar vacío");
    }
    private void validateDireccion (String direccion) throws Exception{
        if(direccion == null) throw new Exception("Dirección no puede ser null");
        if(direccion.isEmpty()) throw new Exception("Dirección no puede quedar vacío");
    }
    private void validateDNI (String dni) throws Exception{
        if(dni == null) throw new Exception("DNI no puede ser null");
        if(dni.isEmpty()) throw new Exception("DNI no puede quedar vacío");
        //introducir re.match para comprobar y validar el dni con 8dígitos y una letra
        boolean dniValido = dni.matches("\"\\\\d{9}\"");
    }
    private void validateTelefono (int telefono) throws Exception{
        //no entiendo muy bien por qué pide usar el Integer.parseInt pero era la forma de usar la validación
        if(telefono == Integer.parseInt(null)) throw new Exception("Teléfono on puede ser null");
        //he visto una forma de validar el número de teléfono parecida a la de dni y otra similar, te mandaré por WhatsApp y me dices cuál te gusta más
        // ESTO NO SIRVE PORQUE NO ES STRING HAY QUE CAMBIARLO boolean telValido = telefono.matches("\\d{9}");
    }
}