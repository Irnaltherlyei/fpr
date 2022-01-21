package vehicles;

public class LKW extends Fahrzeug {
    int cargo;

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

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }
}
