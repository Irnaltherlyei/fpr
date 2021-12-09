package staff;

import java.util.Date;

public class Employee extends Staff{
    public Employee(int pID, String name, Date einstellungsdatum, int gehalt){
        super(pID, name, einstellungsdatum, gehalt);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "pID=" + pID +
                ", name='" + name + '\'' +
                ", einstellungsdatum=" + hired +
                ", gehalt=" + salary +
                '}';
    }
}
