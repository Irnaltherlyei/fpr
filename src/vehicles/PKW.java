package vehicles;

public class PKW extends Fahrzeug {
    int countSeats;

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

    public void setCountSeats(int countSeats) {
        this.countSeats = countSeats;
    }
}
