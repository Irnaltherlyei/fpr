package vehicles;

public abstract class Fahrzeug implements Comparable<Fahrzeug> {
    private int ID;
    private String model;
    private int price;
    private int speed;

    public Fahrzeug(int ID, String model, int price, int speed) {
        this.ID = ID;
        this.model = model;
        this.price = price;
        this.speed = speed;
    }

    @Override
    public int compareTo(Fahrzeug o) {
        if(o.price > this.price)
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

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

