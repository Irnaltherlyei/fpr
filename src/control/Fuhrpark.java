package control;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a carpool renting out different cars.
 */
public class Fuhrpark {
    private HashMap<Integer, RentDay> rentMap;

    /**
     * Class constructor creates a hashmap with day number as key and a {@link RentDay} as value.
     */
    public Fuhrpark() {
        rentMap = new HashMap<Integer, RentDay>();
    }

    /**
     * Add a day with rented out cars to the Fuhrpark.
     *
     * @param ID as day ID
     * @param rentDay
     */
    public void addRentDay(Integer ID, RentDay rentDay){
        rentMap.putIfAbsent(ID, rentDay);
    }

    /**
     * Deletes a day with rented out cars from the Fuhrpark.
     *
     * @param ID as day ID
     * @return removed day with rented out cars
     */
    public RentDay deleteRentDay(Integer ID){
        return rentMap.remove(ID);
    }

    @Override
    public String toString() {
        String s = "";
        s += "Fuhrpark{\n";
        for (Map.Entry<Integer,RentDay> i :
                rentMap.entrySet()) {
            s += "Day " + i.getKey();
            s += "{";
            s += '\n';
            s += i.getValue();
            s += '\n';
            s += "}\n";
        }
        return s;
    }
}