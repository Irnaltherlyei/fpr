package control;

public class CLI {

    public static String start(){
        return new StringBuilder()
                .append("\nUse any commands.")
                .append("\nType 'info' for a list of commands.")
                .toString();
    }

    public static String info(){
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
}
