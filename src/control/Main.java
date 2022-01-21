package control;

public class Main {

    public static void main(String[] args) {
        Fuhrpark fp = new Fuhrpark();

        RentDay rd = new RentDay();
        rd.add(101);
        rd.add(102);
        rd.add(102);
        rd.add(103);
        rd.add(104);

        RentDay rd2 = new RentDay();
        rd2.remove(101);
        rd2.remove(102);
        rd2.remove(102);
        rd2.add(101);
        rd2.add(102);
        rd2.add(102);
        rd2.add(103);
        rd2.add(104);

        fp.addRentDay(1,rd);


        fp.addRentDay(2,rd2);
        System.out.println(fp);
        System.out.println("");
    }
}