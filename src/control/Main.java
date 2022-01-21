package control;

/**
 * Main class
 */
public class Main {

    /**
     * Creates a Fuhrpark and adds some cars.
     * @param args not used yet.
     */
    public static void main(String[] args) {
        Fuhrpark fp = new Fuhrpark();

        RentDay rd = new RentDay();
        rd.add(101);
        rd.add(103);
        rd.add(202);
        rd.add(304);
        rd.add(306);
        rd.setSortSpeed();
        fp.addRentDay(1,rd);

        RentDay rd2 = new RentDay();
        rd2.add(102);
        rd2.add(104);
        rd2.add(201);
        rd2.add(203);
        fp.addRentDay(2, rd2);

        System.out.println(fp);
    }
}