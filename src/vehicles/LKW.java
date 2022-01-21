package vehicles;

/**
 * This class represents a truck
 */
public class LKW extends Fahrzeug {
    int cargo;

    /**
     * Class constructor for a truck.
     * See {@link Fahrzeug} for other member descriptions.
     *
     * @param cargo as max cargo load
     */
    public LKW(int ID, String model, int price, int speed, int cargo) {
        super(ID, model, price, speed);
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return " LKW{" +
                "cargo=" + cargo +
                super.toString() + "}";
    }

    public int getCargo() {
        return cargo;
    }
}
