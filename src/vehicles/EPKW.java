package vehicles;

/**
 * This class represents an electrical car.
 */
public class EPKW extends PKW{
    int maxReach;

    /**
     * Class constructor for an electrical car.
     * See {@link PKW} for other member descriptions.
     *
     * @param maxReach as max distance driving
     */
    public EPKW(int ID, String model, int price, int speed, int countSeats, int maxReach) {
        super(ID, model, price, speed, countSeats);
        this.maxReach = maxReach;
    }

    /**
     * Building a string representing an EPKW.
     *
     * @return string
     */
    @Override
    public String toString() {
        return " EPKW{" +
                super.toString() +
                " maxReach=" + maxReach + " }";
    }

    /**
     * Get max reach from this EPKW
     *
     * @return int
     */
    public int getMaxReach() {
        return maxReach;
    }
}
