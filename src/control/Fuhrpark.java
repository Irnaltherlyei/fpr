package control;

import java.util.HashMap;
import java.util.Map;

public class Fuhrpark {
    private HashMap<Integer, RentDay> rentMap;

    public Fuhrpark() {
        rentMap = new HashMap<Integer, RentDay>();
    }

    public void addRentDay(Integer ID, RentDay rentDay){
        rentMap.putIfAbsent(ID, rentDay);
    }

    public RentDay deleteRentDay(Integer ID){
        return rentMap.remove(ID);
    }

    @Override
    public String toString() {
        String s = "";
        s += "Fuhrpark{\n";
        for (Map.Entry<Integer,RentDay> i :
                rentMap.entrySet()) {
            s += i.getKey();
            s += '{';
            s += '\n';
            s += i.getValue();
            s += '\n';
            s += "}\n";
        }
        return s;
    }
}