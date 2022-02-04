package vehicles;

/**
 * This class represents a car.
 */
public class PKW extends Fahrzeug {
    int countSeats;

    /**
     * Class constructor for a normal car.
     * See {@link Fahrzeug} for other member descriptions.
     *
     * @param countSeats as count of seats aviable
     */
    public PKW(int ID, String model, int price, int speed, int countSeats) {
        super(ID, model, price, speed);
        this.countSeats = countSeats;
    }

    /**
     * Building a string representing a PKW.
     *
     * @return string
     */
    @Override
    public String toString() {
        return " PKW{" +
                super.toString() +
                " countSeats=" + countSeats + " }";
    }

    /**
     * Get the number of seats available in the PKW.
     *
     * @return int
     */
    public int getCountSeats() {
        return countSeats;
    }
}
