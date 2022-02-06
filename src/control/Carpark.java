package control;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a carpool renting out different cars.
 */
public class Carpark {
    private HashMap<Integer, RentDay> rentMap;

    /**
     * Class constructor creates a hashmap with day number as key and a {@link RentDay} as value.
     */
    public Carpark() {
        rentMap = new HashMap<Integer, RentDay>();
    }

    /**
     * Add a day with rented out cars to the Carpark.
     *
     * @param ID as day ID
     * @param rentDay as day with rented out cars
     */
    public RentDay addRentDay(Integer ID, RentDay rentDay){
        return rentMap.putIfAbsent(ID, rentDay);
    }

    /**
     * Deletes a day with rented out cars from the Carpark.
     *
     * @param rd as a day
     * @return true if day was removed, false otherwise
     */
    public boolean deleteRentDay(RentDay rd){
        return rentMap.values().remove(rd);
    }

    /**
     * Remove all days cars got rented out.
     */
    public void deleteAll(){
        rentMap.clear();
    }

    /**
     * Returns a day with rented cars with the given ID.
     *
     * @param ID as day ID
     * @return a day with rented cars
     */
    public RentDay getRentDay(Integer ID){
        return rentMap.get(ID);
    }

    /**
     * Returns a map represeting all days within the Carpark with rented out cars.
     *
     * @return Map with a day ID as key and a day with rented cars as value
     */
    public HashMap<Integer,RentDay> getMap(){
        return rentMap;
    }

    /**
     * Building a string representing the Carpark.
     *
     * @return string
     */
    @Override
    public String toString() {
        String s = "";
        s += "Carpark{";
        for (Map.Entry<Integer,RentDay> i :
                rentMap.entrySet()) {
            s += "\nDay " + i.getKey();
            s += "{";
            s += '\n';
            s += i.getValue();
            s += '\n';
            s += "}";
        }
        s += "\n}";
        return s;
    }
}