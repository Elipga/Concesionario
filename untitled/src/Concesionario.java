import java.util.HashMap;

public class Concesionario {
    private HashMap<String,Coche> cochesConcesionario;

    public Concesionario() {
        this.cochesConcesionario = new HashMap<String,Coche>();
    }

    public HashMap<String, Coche> getCochesConcesionario() {
        return cochesConcesionario;
    }

    public String toStringCoches() {
        return "Concesionario{" +
                "cochesConcesionario=" + cochesConcesionario +
                '}';
    }

    public void anyadirCoche(String coche, Coche c){
        cochesConcesionario.put(coche,c);
    }

    public void historialCoches(){

        for (String clave:cochesConcesionario.keySet()) {
            Coche valor = cochesConcesionario.get(clave);
            System.out.println(clave + valor.toStringCoche());
        }

    }

}
