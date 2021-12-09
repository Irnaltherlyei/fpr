package staff;

import java.util.Date;
import java.util.Objects;

public class Manager extends Staff {
    int bonus;
    public Manager(int pID, String name, Date einstellungsdatum, int gehalt, int bonus){
        super(pID, name, einstellungsdatum, gehalt);
        this.bonus = bonus;
    }

    public void receiveBonus(int bonus){
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "bonus=" + bonus +
                ", pID=" + pID +
                ", name='" + name + '\'' +
                ", einstellungsdatum=" + hired +
                ", gehalt=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager)) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return bonus == manager.bonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bonus);
    }
}
