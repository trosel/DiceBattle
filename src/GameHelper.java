import java.util.*;

/**
 * Created by Cale on 1/31/15.
 */
public class GameHelper {
    public static String getUserInput(String question) {
        String userIn;
        Scanner s = new Scanner(System.in);

        System.out.println(question);
        userIn = s.next();
        return userIn;
    }

}
