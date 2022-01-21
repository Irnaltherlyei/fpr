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

    @Override
    public String toString() {
        return " PKW{" +
                "countSeats=" + countSeats +
                super.toString() + "}";
    }

    public int getCountSeats() {
        return countSeats;
    }
}
