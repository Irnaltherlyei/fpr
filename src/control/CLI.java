package control;

import java.util.Map;
import java.util.Scanner;

/**
 * This class is representing a command line interface. It controls the Fuhrpark class.
 */
public class CLI {

    private Fuhrpark fp;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public CLI(Fuhrpark fp){
        this.fp = fp;
        Scanner scanner = new Scanner(System.in);
        System.out.println(start());
        try{
            while(true){
                String command = scanner.nextLine().toLowerCase();
                String[] splitCommand = command.split("\\s+");
                switch (splitCommand[0]){
                    case "info":
                        System.out.println(info());
                        break;

                    case "deletealldays":
                        System.out.println("Deleted all days.");
                        fp.deleteAll();
                        break;

                    case "deleteday":
                        if(!args(splitCommand, 2, false)){
                            break;
                        }
                        String DAY_ID = splitCommand[1];
                        if(fp.deleteRentDay(dayExists(DAY_ID, true))) {
                            System.out.println("Deleted day " + DAY_ID);
                        }
                        break;

                    case "sumrentday":
                        if(!args(splitCommand, 2, false)){
                            break;
                        }
                        DAY_ID = splitCommand[1];
                        RentDay rd = dayExists(DAY_ID, true);
                        if(rd != null){
                            System.out.println("Rent collected for day " + DAY_ID + " is " + rd.sumRent());
                        }
                        break;

                    case "sort":
                        if(!args(splitCommand, 3, false)){
                            break;
                        }
                        DAY_ID = splitCommand[1];
                        rd = dayExists(DAY_ID, true);
                        if(rd != null){
                            if (splitCommand[2].equals("speed")) {
                                System.out.println("Sort by speed. Ascending.");
                                rd.setSortSpeed();
                            } else if (splitCommand[2].equals("normal")) {
                                System.out.println("Sort by price. Ascending.");
                                rd.setSortNormal();
                            } else {
                                System.out.println("No such option as " + splitCommand[2] + ".");
                            }
                        }
                        break;

                    case "addday":
                        if(!args(splitCommand, 2, true)){
                            break;
                        }
                        DAY_ID = splitCommand[1];
                        Integer day = isInt(DAY_ID);
                        if(day == null){
                            System.out.println("Invalid day ID. Command aborted.");
                            break;
                        }
                        rd = dayExists(DAY_ID, false);
                        if(rd == null){
                            rd = new RentDay();
                        } else {
                            System.out.println("Day already exists. Command aborted.");
                            break;
                        }
                        for (int i = 2; i < splitCommand.length; i++) {
                            Integer CAR_ID = isInt(splitCommand[i]);
                            if(CAR_ID == null){
                                // All valid cars will be added to the day.
                                // Non-valid cars will not be added.
                                System.out.println("Invalid car ID: " + splitCommand[i] + ".");
                            } else {
                                if(rd.add(CAR_ID)){
                                    System.out.println("Added car with ID " + CAR_ID + " to day " + DAY_ID + ".");
                                } else {
                                    System.out.println("Car with ID " + CAR_ID + " does not exist.");
                                }
                            }
                        }
                        fp.addRentDay(day, rd);
                        break;

                    case "removecarfromday":
                    case "addcartoday":
                        if(!args(splitCommand, 3, true)){
                            break;
                        }
                        DAY_ID = splitCommand[1];
                        rd = dayExists(DAY_ID, true);
                        if(rd != null){
                            for (int i = 2; i < splitCommand.length; i++) {
                                Integer CAR_ID = isInt(splitCommand[i]);
                                if(CAR_ID == null){
                                    // All valid cars will be added to the day.
                                    // Non-valid cars will not be added.
                                    System.out.println("Invalid car ID: " + splitCommand[i] + ".");
                                } else {
                                    if(splitCommand[0].equals("removecarfromday")){
                                        if(rd.remove(CAR_ID) != null){
                                            System.out.println("Removed car with ID " + CAR_ID + " from Day " + DAY_ID + ".");
                                        } else {
                                            System.out.println("Car with ID " + CAR_ID + " does not exist.");
                                        }
                                    } else if(splitCommand[0].equals("addcartoday")){
                                        if(rd.add(CAR_ID)){
                                            System.out.println("Added car with ID " + CAR_ID + " to day " + DAY_ID + ".");
                                        } else {
                                            System.out.println("Car with ID " + CAR_ID + " does not exist.");
                                        }
                                    }
                                }
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


                    case "show":
                        System.out.println(fp);
                        break;

                    case "examplefill":
                        exampleFill(fp);
                        System.out.println("Filled the park with sample data.");
                        break;

                    case "exit":
                        System.exit(0);
                        break;

                    case "":
                        // Do nothing
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
     * CLI starting info.
     *
     * @return CLI starting info as string
     */
    private String start(){
        return new StringBuilder()
                .append("\nUse any commands.")
                .append("\nType 'info' for a list of commands.")
                .toString();
    }

    /**
     * Prints all the CLI info.
     *
     * @return CLI info as string
     */
    private String info(){
        return new StringBuilder()
                .append("\nArguments inside 'arg' can only occur one time.")
                .append("\nArguments inside [arg] can occur multiple times.")
                .append("\nCommands with 'arg1;arg2' have predefined options. Use one of the listed to options execute the command.")
                .append("\n")
                .append("\n 1. deleteAllDays                      - delete everything from the Fuhrpark.")
                .append("\n 2. deleteDay 'DAY_ID'                 - delete a specific day with the given ID from the Fuhrpark.")
                .append("\n 3. addDay 'DAY_ID' [CAR_ID]           - creates a new empty day in the Fuhrpark.")
                .append("\n 4. sort 'DAY_ID' 'Normal;Speed'       - sorts the specific ID ascending with the specified field.")
                .append("\n 5. show                               - Shows a list of the Fuhrpark and all included days.")
                .append("\n 6. addCarToDay 'DAY_ID' [CAR_ID]      - Adds a car to a day in the Fuhrpark.")
                .append("\n 7. removeCarFromDay 'CAR_ID' 'DAY_ID' - Removes from a day in the Fuhrpark.")
                .append("\n 8. sumRentDay 'DAY_ID'                - Sums up all rent collected in a day.")
                .append("\n 9. sumRent                            - Sums up all rent collected.")
                .append("\n10. exampleFill                        - Fills the Fuhrpark with some days and cars.")
                .append("\n11. exit                               - Terminates the process.")
                .toString();
    }

    /**
     * Checks if the correct numbers of arguments are given for a specific command.
     *
     * @param s as all command parameters
     * @param countArgs as number of arguments needed for that command
     * @param optional as flag for commands with optional repeating parameters
     * @return true when correct number of arguments are given and false otherwise
     */
    private boolean args(String[] s, Integer countArgs, boolean optional){
        if(!optional && s.length != countArgs || optional && s.length < countArgs){
            System.out.println("Wrong number of arguments.");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Checks if a day exits in the Fuhrpark.
     *
     * @param s as a String representing a DAY_ID
     * @return a RentDay if existing or null
     */
    private RentDay dayExists(String s, boolean log){
        RentDay rd = fp.getRentDay(isInt(s));
        if(rd != null){
            return rd;
        } else {
            if (log){
                System.out.println("Day does not exist.");
            }
            return null;
        }

    }

    /**
     * Checks if a string is numeric.
     *
     * @param s as string to check
     * @return Integer if s is numeric or null if not
     */
    private Integer isInt(String s){
        try {
            return Integer.parseInt(s);
        } catch(NumberFormatException e){
            return null;
        }
    }

    /**
     * Fills the Fuhrpark with some cars and tests some functions.
     *
     * @param fp as a Fuhrpark
     */
    public static void exampleFill(Fuhrpark fp){
        RentDay rd = new RentDay();
        rd.add(101);
        rd.add(102);
        rd.add(103);
        rd.add(104);
        fp.addRentDay(1,rd);

        RentDay rd2 = new RentDay();
        rd2.add(201);
        rd2.add(202);
        rd2.add(203);
        fp.addRentDay(2, rd2);
    }
}
