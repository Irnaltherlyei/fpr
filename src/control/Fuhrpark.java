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
     * @param rentDay as day with rented out cars.
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

    /**
     * Remove all days cars got rented out.
     */
    public void deleteAll(){
        rentMap.clear();
    }

    /**
     * Deletes a rent day if it has no cars rented out.
     */
    public void check(Integer ID){
        if(rentMap.get(ID).isEmpty()){
            rentMap.remove(ID);
        }
    }

    public RentDay getRentDay(Integer ID){
        return rentMap.get(ID);
    }

    public HashMap<Integer,RentDay> getMap(){
        return rentMap;
    }

    @Override
    public String toString() {
        String s = "";
        s += "Fuhrpark{";
        for (Map.Entry<Integer,RentDay> i :
                rentMap.entrySet()) {
            i.getValue().setSortNormal();
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