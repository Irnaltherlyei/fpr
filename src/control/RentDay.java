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
    private Comparator<Fahrzeug> comparator = Comparator.naturalOrder();

    /**
     * Fix car pool with defined cars.
     */
    public ArrayList<Fahrzeug> carPool = new ArrayList<Fahrzeug>() {{
        add(new PKW(101, "X1", 555, 200, 5));
        add(new PKW(102, "X2", 444, 300, 5));
        add(new PKW(103, "X3", 333, 400, 6));
        add(new PKW(104, "X4", 222, 250, 6));

        add(new EPKW(201, "Y1", 333, 260, 5, 600));
        add(new EPKW(202, "Y2", 222, 270, 5, 800));
        add(new EPKW(203, "Y3", 111, 280, 5, 1000));

        add(new LKW(301, "Z1", 600, 150, 10000));
        add(new LKW(302, "Z2", 580, 140, 12000));
        add(new LKW(303, "Z3", 560, 130, 14000));
        add(new LKW(304, "Z4", 540, 180, 16000));
        add(new LKW(305, "Z5", 520, 170, 18000));
        add(new LKW(306, "Z6", 500, 160, 20000));
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
    public void setSortPrice(){
        comparator = Comparator.naturalOrder();
    }

    /**
     * Building a string representing a day with rented out cars.
     *
     * @return string
     */
    @Override
    public String toString() {
        return rentedOut.stream().sorted(comparator).map(Object::toString).collect(Collectors.joining("\n"));
    }

    public String poolToString(){
        String s = "";
        for (Fahrzeug f :
                carPool) {
            s += f + "\n";
        }
        return s;
    }
}
