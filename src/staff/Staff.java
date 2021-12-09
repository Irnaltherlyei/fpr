package staff;

import java.util.Date;

public abstract class Staff implements Comparable<Staff>, Person{
    protected int pID;
    protected String name;
    protected Date hired;
    protected int salary;
    public Staff(int pID, String name, Date hired, int salary){
        this.pID = pID;
        this.name = name;
        this.hired = hired;
        this.salary = salary;
    }

    public void raise(float factor){
        salary*= factor;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Staff s) {
        if(s.salary > this.salary){
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Staff{" +
                "pID=" + pID +
                ", name='" + name + '\'' +
                ", hired=" + hired +
                ", salary=" + salary +
                '}';
    }
}
