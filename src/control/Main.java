package control;

/**
 * Main class
 */
public class Main {

    /**
     * Creates a Fuhrpark and starts the command line interface implemented in {@link CLI} class.
     * @param args not used yet.
     */
    public static void main(String[] args) {
        Fuhrpark fp = new Fuhrpark();

        new CLI(fp);
    }
}