import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) {
        Path source = Paths.get("C:/Users/Adrian/Desktop/book.txt");
        Scanner in = null;
        try {
            in = new Scanner(source);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> list = new ArrayList<String>();
        // Tree Set will automatically be sorted when inserting new values as well as having only distinct values
        TreeSet<String> set = new TreeSet<String>();
        while(in.hasNext()){
            String[] words = in.next()
                    .toLowerCase()
                    // Replaces all characters except the ones stated below.
                    .replaceAll("[^a-zA-Z0-9']+", " ")
                    // Replaces multiple white spaces with just one white space.
                    .replaceAll("\\s+", " ")
                    .trim().split(" ");
            for (String s :
                    words) {
                if(s.length() > 0) {
                    list.add(s);
                    set.add(s);
                }
            }
        }
        System.out.println(list.size());
        System.out.println(set.size());
    }
}
