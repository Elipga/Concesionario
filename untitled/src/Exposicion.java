import java.util.HashSet;
import java.util.LinkedList;

public class Exposicion {
    private int numeroExposcion;
    private String direccion;
    private String telefono;

    private HashSet<Coche> cochesEnExposicion;


    public Exposicion(int numeroExposcion, String direccion, String telefono) {
        this.numeroExposcion = numeroExposcion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cochesEnExposicion = new HashSet<Coche>();
    }


    public String toStringExposicion() {
        return "Exposicion{" +
                "numeroExposcion=" + numeroExposcion +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    public HashSet<Coche> getCochesEnExposicion() {
        return cochesEnExposicion;
    }

    public void anyadirCocheAExposicion(Coche c) {
        cochesEnExposicion.add(c);
    }

    public void borrarCocheExposicion(Coche c){
        cochesEnExposicion.remove(c);
    }

    public void visualizarExposicion(){
        System.out.println(toStringExposicion());

    }
    public void visualizarCochesExposicion(){
        for(Coche item: cochesEnExposicion){
            System.out.println(item.toStringCoche());
        }
    }

    public void ubicacionExposicion(Coche e){
        for(Coche item: cochesEnExposicion){
            if (e.getMatricula() == item.getMatricula()){
                System.out.println("El coche se encuentra en la exposicion: " + numeroExposcion);
                break;

            }

            else System.out.println("El coche no está en la exposición");

        }


    }



}
