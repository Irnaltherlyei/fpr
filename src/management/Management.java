package management;

import staff.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class Management {

    public ArrayList<Staff> personalList;

    public static void main(String[] args) {
        Management pa = new Management();

        pa.addEmployee(new Employee(105,"Freddy", new Date(), 2000));
        pa.addEmployee(new Employee(103,"José", new Date(), 1800));
        pa.addEmployee(new Employee(102,"Jan", new Date(), 1900));
        pa.addEmployee(new Employee(104,"Louis", new Date(), 1700));
        pa.addEmployee(new Manager(101,"Adrian", new Date(), 2500,1000));

        pa.print();

        Collections.sort(pa.personalList);

        pa.print();

        System.out.println("Highetst paid: " + pa.getLowestPaid().toString());
        System.out.println("Lowest paid: " + pa.getHighestPaid().toString());

        pa.getHighestPaid().raise(2f);
        pa.removeEmployee(pa.getLowestPaid());
        pa.removeEmployee(pa.getLowestPaid());

        pa.print();
    }

    public Management(){
        personalList = new ArrayList<Staff>();
    }

    public void addEmployee(Staff p){
        if(!exists(p))
            personalList.add(p);
    }

    public void removeEmployee(Staff p){
        if(exists(p))
            System.out.println("Removed " + p.toString());
        personalList.remove(p);
    }

    public void print() {
        personalList.forEach(x -> System.out.println(x.toString()));
    }

    public boolean exists(Staff p){
        for (Staff person: personalList) {
            if (person.equals(p)) {
                return true;
            }
        }
        return false;
    }

    public Staff getLowestPaid(){
        personalList.sort((x, y) -> x.compareTo(y));
        return personalList.get(0);
    }

    public Staff getHighestPaid(){
        personalList.sort((x, y) -> y.compareTo(x));
        return personalList.get(0);
    }
}