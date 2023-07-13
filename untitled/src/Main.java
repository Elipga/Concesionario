public class Main {
    public static void main(String[] args) throws IsEmptyException, NotNullException, InvalidException, AlreadyExistsException {

        Programa p = new Programa(new Concesionario());
        p.start();

    }
}