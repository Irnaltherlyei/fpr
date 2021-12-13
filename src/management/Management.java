package management;

import staff.*;

import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Management {

    public HashMap<Integer, Staff> personalMap;

    public static void main(String[] args) {
        Management pa = new Management();

        pa.addEmployee(new Employee(2104,"Freddy", new Date(), 2000));
        pa.addEmployee(new Employee(2103,"José", new Date(), 1800));
        pa.addEmployee(new Employee(2102,"Jan", new Date(), 1900));
        pa.addEmployee(new Employee(2101,"Louis", new Date(), 1700));
        pa.addEmployee(new Manager(1101,"Adrian", new Date(), 2500,1000));
        pa.addEmployee(new Manager(1102,"X Æ A-XII", new Date(), 2000,800));

        //Collections.sort(pa.personalList);

        System.out.println("Highetst paid: " + pa.getHighestPaid());
        System.out.println("Lowest paid: " + pa.getLowestPaid());

        pa.getHighestPaid().raise(2f);

        pa.removeEmployee(pa.getLowestPaid());
        pa.removeEmployee(pa.getLowestPaid());

        pa.print();

        System.out.println(pa.getHighestLowestManager().toString());
    }

    public Management(){
        personalMap = new HashMap<Integer, Staff>();
    }

    public void addEmployee(Staff p){
        personalMap.put(p.getpID(), p);
    }

    public void removeEmployee(Staff p){
        if (personalMap.remove(p.getpID()) != null)
            System.out.println("Removed " + p.toString());
    }

    public void print() {
        personalMap.values().forEach(x -> System.out.println(x.toString()));
    }

    public Staff getLowestPaid(){
        return personalMap.entrySet().stream().sorted(HashMap.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList()).get(0).getValue();
    }

    public Staff getHighestPaid(){
        return personalMap.entrySet().stream().sorted(HashMap.Entry.comparingByValue()).collect(Collectors.toList()).get(0).getValue();
    }

    public Pair<Manager, Manager> getHighestLowestManager(){
        Manager lowest = null, highest = null;
        for (Staff s :
                personalMap.values().stream().sorted().collect(Collectors.toList())) {
            if (s.getClass().isAssignableFrom(Manager.class)) {
                if(highest == null){
                    highest = (Manager)s;
                }
                lowest = (Manager)s;
            }
        }
        return new Pair<>(highest, lowest);
    }
}