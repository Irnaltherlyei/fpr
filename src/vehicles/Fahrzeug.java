package vehicles;

/**
 * Provides a foundation for cars.
 */
public abstract class Fahrzeug implements Comparable<Fahrzeug> {
    private int ID;
    private String model;
    private int price;
    private int speed;

    /**
     * Class constructor.
     * @param ID as unique car ID
     * @param model as model name
     * @param price as daily rent price
     * @param speed as max speed
     */
    public Fahrzeug(int ID, String model, int price, int speed) {
        this.ID = ID;
        this.model = model;
        this.price = price;
        this.speed = speed;
    }

    /**
     * Implements the compareTo method from the comparable interface.
     * Allows to sort a list of {@link Fahrzeug}
     * @param o as a {@link Fahrzeug}
     * @return
     */
    @Override
    public int compareTo(Fahrzeug o) {
        if(o.price < this.price)
            return 1;
        else
            return -1;
    }

    /**
     * Building a string representing a Fahrzeug.
     *
     * @return string
     */
    @Override
    public String toString() {
        return " ID=" + ID +
                " model='" + model + '\'' +
                " price=" + price +
                " speed=" + speed;
    }

    /**
     * Get the unique ID from a Fahrzeug.
     *
     * @return int
     */
    public int getID() {
        return ID;
    }

    /**
     * Get the model name from a Fahrzeug.
     *
     * @return string
     */
    public String getModel() {
        return model;
    }

    /**
     * Get the rent price a Fahrzeug costs for one day.
     *
     * @return int
     */
    public int getPrice() {
        return price;
    }

    /**
     * Get the maximum speed a Fahrzeug can reach.
     *
     * @return int
     */
    public int getSpeed() {
        return speed;
    }
}

