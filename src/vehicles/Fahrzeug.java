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

    @Override
    public String toString() {
        return " ID=" + ID +
                " model='" + model + '\'' +
                " price=" + price +
                " speed=" + speed;
    }

    public int getID() {
        return ID;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public int getSpeed() {
        return speed;
    }
}

