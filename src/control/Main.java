package control;

import java.util.Map;
import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in);
        System.out.println("Use any commands.");
        System.out.println("Type 'info' for a list of commands.");
        try{
            while(true){
                String command = scanner.nextLine().toLowerCase();
                String[] splitCommand = command.split("\\s+");
                switch (splitCommand[0]){
                    case "info":
                        // System.out.println("Arguments inside 'arg' can only occur one time.");
                        // System.out.println("Arguments inside [arg] can occur multiple times.");
                        // System.out.println("Commands with 'arg1;arg2' have predefined options. Use one of the listed to options execute the command.");
                        // System.out.println();
                        // System.out.println(" 1. deleteAllDays                      - delete everything from the Fuhrpark.");
                        // System.out.println(" 2. deleteDay 'DAY_ID'                 - delete a specific day with the given ID from the Fuhrpark.");
                        // System.out.println(" 3. addDay 'DAY_ID' [CAR_ID]           - creates a new empty day in the Fuhrpark.");
                        // System.out.println(" 4. sort 'DAY_ID' 'Normal;Speed'       - sorts the specific ID ascending with the specified field.");
                        // System.out.println(" 5. show                               - Shows a list of the Fuhrpark and all included days.");
                        // System.out.println(" 6. addCarToDay 'DAY_ID' [CAR_ID]      - Adds a car to a day in the Fuhrpark.");
                        // System.out.println(" 7. removeCarFromDay 'CAR_ID' 'DAY_ID' - Removes from a day in the Fuhrpark.");
                        // System.out.println(" 8. sumRentDay 'DAY_ID'                - Sums up all rent collected in a day.");
                        // System.out.println(" 9. sumRent                            - Sums up all rent collected.");
                        // System.out.println("10. exampleFill                        - Fills the Fuhrpark with some days and cars.");
                        // System.out.println("11. exit                               - Terminates the process.");
                        System.out.println(CLI.info());
                        break;

                    case "deletealldays":
                        System.out.println("Deleting all days.");
                        fp.deleteAll();
                        break;

                    case "deleteday":
                        if(splitCommand.length != 2){
                            System.out.println("Wrong number of arguments provided.");
                        } else {
                            int DAY_ID = isInt(splitCommand[1]);
                            if(fp.deleteRentDay(DAY_ID) != null){
                                System.out.println("Deleted Day " + DAY_ID);
                            } else {
                                System.out.println("Day does not exist.");
                            }
                        }
                        break;

                    case "addday":
                        if(splitCommand.length < 3){
                            System.out.println("Wrong number of arguments provided.");
                        } else {
                            int DAY_ID = isInt(splitCommand[1]);
                            RentDay rd = new RentDay();
                            for (int i = 2; i < splitCommand.length; i++) {
                                if(!rd.add(isInt(splitCommand[i]))){
                                    System.out.println("No car with ID " + splitCommand[i] + " exists. Command canceled.");
                                } else {
                                    System.out.println("Added day " + DAY_ID);
                                    fp.addRentDay(DAY_ID, rd);
                                }
                            }
                        }
                        break;

                    case "addcartoday":
                        if(splitCommand.length < 3){
                            System.out.println("Wrong number of arguments provided.");
                        } else {
                            int DAY_ID = isInt(splitCommand[1]);
                            RentDay rd = fp.getRentDay(DAY_ID);
                            if(rd == null){
                                System.out.println("Day does not exist yet. Add a day with 'addDay 'DAY_ID' [CAR_ID]'.");
                            } else {
                                for (int i = 2; i < splitCommand.length; i++) {
                                    if(!rd.add(isInt(splitCommand[i]))){
                                        System.out.println("No car with ID " + splitCommand[i] + " exists. Command canceled.");
                                    } else {
                                        System.out.println("Added car " + splitCommand[i] + " to day " + DAY_ID);
                                    }
                                }
                            }
                        }
                        break;

                    case "removecarfromday":
                        if(splitCommand.length < 3){
                            System.out.println("Wrong number of arguments provided.");
                        } else {
                            int DAY_ID = isInt(splitCommand[1]);
                            RentDay rd = fp.getRentDay(DAY_ID);
                            if(rd == null){
                                System.out.println("Day does not exist.");
                            } else {
                                for (int i = 2; i < splitCommand.length; i++) {
                                    if(rd.remove(isInt(splitCommand[i])) == null){
                                        System.out.println("No car with ID " + splitCommand[i] + " exists. Command canceled.");
                                    } else {
                                        fp.check(DAY_ID);
                                        System.out.println("Removed car " + splitCommand[i] + " to day " + DAY_ID);
                                    }
                                }
                            }
                        }
                        break;

                    case "sumrentday":
                        if(splitCommand.length != 2){
                            System.out.println("Wrong number of arguments provided.");
                        } else {
                            int DAY_ID = isInt(splitCommand[1]);
                            RentDay rd = fp.getRentDay(DAY_ID);
                            if(rd == null){
                                System.out.println("Day does not exist.");
                            } else {
                                System.out.println("Rent collected for day " + DAY_ID + " is " + rd.sumRent());
                            }
                        }
                        break;

                    case "sumrent":
                        Integer sum = 0;
                        for (Map.Entry<Integer,RentDay> i :
                                fp.getMap().entrySet()) {
                            sum += i.getValue().sumRent();
                        }
                        System.out.println("Rent collected is " + sum);
                        break;

                    case "sort":
                        if(splitCommand.length != 3){
                            System.out.println("Wrong number of arguments provided.");
                        } else {
                            int DAY_ID = isInt(splitCommand[1]);
                            RentDay rd = fp.getRentDay(DAY_ID);
                            if (rd == null) {
                                System.out.println("Day does not exist.");
                            } else {
                                if (splitCommand[2].equals("speed")) {
                                    System.out.println("Sort by speed. Ascending.");
                                    rd.setSortSpeed();
                                } else if (splitCommand[2].toLowerCase().equals("normal")) {
                                    System.out.println("Sort by price. Ascending.");
                                    rd.setSortNormal();
                                } else {
                                    System.out.println("No such option as " + splitCommand[2] + ".");
                                }
                            }
                        }
                        break;

                    case "show":
                        System.out.println(fp);
                        break;

                    case "examplefill":
                        exampleFill(fp);
                        break;

                    case "exit":
                        System.exit(0);
                        break;

                    default:
                        System.out.println(command + " is not a valid command.");
                        break;
                }
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Exiting...");
        }
    }

    /**
     * Fills the Fuhrpark with some cars and tests some functions.
     */
    public static void exampleFill(Fuhrpark fp){
        RentDay rd = new RentDay();
        rd.add(101);
        rd.add(102);
        rd.add(201);
        rd.add(301);
        rd.add(302);
        rd.add(303);
        rd.setSortSpeed();
        fp.addRentDay(1,rd);

        RentDay rd2 = new RentDay();
        rd2.add(103);
        rd2.add(104);
        rd2.add(202);
        rd2.add(203);
        fp.addRentDay(2, rd2);
    }

    /**
     * Checks if a string is numeric
     * @param s as string to check
     * @return true or false
     */
    public static int isInt(String s){
        try {
            int i = Integer.parseInt(s);
            return i;
        } catch(NumberFormatException e){
            return Integer.MIN_VALUE;
        }
    }
}