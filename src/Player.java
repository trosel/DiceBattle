import java.util.*;
/**
 * Created by Cale on 12/25/14.
 */
public class Player {

    // the player's dice pool
    private ArrayList<Dice> playerRolls;
    Scanner s = new Scanner(System.in);

    // add a die to the dice pool
    public void addToPlayerRolls() {
        System.out.print("\nEnter the number of sides on the die >>> ");
        int userSides = Integer.parseInt(s.next());
        Dice d = new Dice(userSides);
        d.setRollResult();
        playerRolls.add(d);
    }
    // remove a die from the dice pool
    public void removeFromPlayerRolls() {
        System.out.print("\nEnter the roll result you want to remove >>> ");
        int aRollResult = Integer.parseInt(s.next());

        for (Dice die : playerRolls) {
            int num = die.getRollResult();
            if (num == aRollResult) {
                playerRolls.remove(die);
                break;
            }
        }
    }
    // print the player's dice pool thus far
    public void getPlayerRolls() {
        System.out.print("\nPlayer rolled: ");
        for (Dice die : playerRolls) {
            System.out.print(die.getRollResult() + " ");
        }
    }
    public int getRollTotal() {
        int total=0;
        for (Dice die : playerRolls) {
            total += die.getRollResult();
        }
        return total;
    }
    public Player() {
        playerRolls = new ArrayList<Dice>();
    }

}