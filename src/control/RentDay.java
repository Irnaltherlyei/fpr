package control;

import vehicles.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Class representing a day in the Fuhrpark cars being rented out.
 */
public class RentDay {
    private ArrayList<Fahrzeug> rentedOut;
    private Comparator<Fahrzeug> comparator = Comparator.reverseOrder();

    /**
     * Fix car pool with defined cars.
     */
    private ArrayList<Fahrzeug> carPool = new ArrayList<Fahrzeug>() {{
        add(new PKW(101, "X1", 100, 420, 5));
        add(new PKW(102, "X2", 110, 330, 5));
        add(new PKW(103, "X3", 120, 240, 6));
        add(new PKW(104, "X4", 130, 150, 6));

        add(new EPKW(201, "Y1", 200, 260, 5, 600));
        add(new EPKW(202, "Y2", 225, 270, 5, 800));
        add(new EPKW(203, "Y3", 250, 280, 5, 1000));

        add(new LKW(301, "Z1", 500, 150, 10000));
        add(new LKW(302, "Z2", 520, 150, 12000));
        add(new LKW(303, "Z3", 540, 150, 14000));
        add(new LKW(304, "Z4", 560, 150, 16000));
        add(new LKW(305, "Z5", 580, 150, 18000));
        add(new LKW(306, "Z6", 600, 150, 20000));
    }};

    /**
     * Class constructor creates a list with all cars being rented out.
     */
    public RentDay() {
        rentedOut = new ArrayList<Fahrzeug>();
    }

    /**
     * Adds the specific car with the given ID to the list
     * and removes the car from the car pool.
     *
     * @param ID as unique car ID
     * @return true if car could be added
     */
    public boolean add(Integer ID){
        Fahrzeug f = IDtoObject(ID, carPool);

        if(carPool.remove(f)) {
            rentedOut.add(f);
            return true;
        }
        return false;
    }

    /**
     * Removes the specific car with the given ID from the list
     * and adds the car to the car pool.
     *
     * @param ID as unique car ID
     * @return the car which got removed
     */
    public Fahrzeug remove(Integer ID){
        Fahrzeug f = IDtoObject(ID, rentedOut);

        if(f == null) return null;

        if(rentedOut.remove(f)) {
            carPool.add(f);
            return f;
        }
        return null;
    }

    /**
     * Sums up the rent of all cars rented out.
     *
     * @return the sum of rent collected
     */
    public Integer sumRent(){
        Integer sum = 0;
        for (Fahrzeug f :
                rentedOut) {
            sum += f.getPrice();
        }
        return sum;
    }

    /**
     * Looks for the specific car with the given ID in the given list.
     *
     * @param ID as unique car ID
     * @param list as a list of cars
     * @return the found car if existing
     */
    public Fahrzeug IDtoObject(Integer ID, ArrayList<Fahrzeug> list){
        for (Fahrzeug f : list) {
            if(f.getID() == ID){
                return f;
            }
        }
        return null;
    }

    /**
     * Checks if list of rented out cars is empty.
     * @return true if empty
     */
    public boolean isEmpty(){
        if(rentedOut.isEmpty()){
            return true;
        }
        return false;
    }

    /**
     * Sets the comparator in {@link RentDay#toString()} to sort by speed. Ascending.
     */
    public void setSortSpeed(){
        comparator = Comparator.comparing(Fahrzeug::getSpeed);
    }

    /**
     * Sets the comparator in {@link RentDay#toString()} to sort by price. Ascending.
     */
    public void setSortNormal(){
        comparator = Comparator.reverseOrder();
    }

    @Override
    public String toString() {
        return rentedOut.stream().sorted(comparator).map(Object::toString).collect(Collectors.joining("\n"));
    }
}
