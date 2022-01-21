package vehicles;

public class EPKW extends PKW{
    int maxReach;

    public EPKW(int ID, String model, int price, int speed, int countSeats, int maxReach) {
        super(ID, model, price, speed, countSeats);
        this.maxReach = maxReach;
    }

    @Override
    public String toString() {
        return " EPKW{" +
                "maxReach=" + maxReach +
                super.toString() + "}";
    }

    public int getMaxReach() {
        return maxReach;
    }
}
