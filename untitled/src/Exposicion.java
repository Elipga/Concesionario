import java.util.HashSet;
import java.util.LinkedList;

public class Exposicion {
    private String numeroExposcion;
    private String direccion;
    private String telefono;



    public Exposicion(String numeroExposcion, String direccion, String telefono) throws NotNullException, IsEmptyException, InvalidException {
        this.numeroExposcion = numeroExposcion;
        if(numeroExposcion == null) throw new NotNullException("Número de exposición no puede ser null");
        if(numeroExposcion == "") throw new IsEmptyException("Número de exposición no puede estar vacío");
        this.direccion = direccion;
        if(direccion == null) throw new NotNullException("Dirección no puede ser null");
        if(direccion == "") throw new IsEmptyException("Dirección no puede estar vacía");
        this.telefono = telefono;
        if(telefono == null) throw new NotNullException("Dirección no puede ser null");
        if(telefono == "") throw new IsEmptyException("Dirección no puede estar vacía");
        if((telefono.length() != 9)) throw new InvalidException("Teléfono debe tener 9 dígitos");
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

    /*public void anyadirCocheAExposicion(Coche c) {
        cochesEnExposicion.add(c);
    }*/

    /*public void borrarCocheExposicion(Coche c){
        cochesEnExposicion.remove(c);
    }*/

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
