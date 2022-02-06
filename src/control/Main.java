package control;

/**
 * Main class
 */
public class Main {

    /**
     * Creates a Carpark and starts the command line interface implemented in {@link CLI} class.
     * @param args not used yet.
     */
    public static void main(String[] args) {
        Carpark cp = new Carpark();

        new CLI(cp);
    }
}