import java.util.*;
/**
 * Created by Cale on 12/25/14.
 */
public class Player {

    private String name;
    // the player's dice pool
    private ArrayList<Dice> dicePool;

    // add a die to the dice pool
    public void addToPlayerRolls() {
        int userSides = Integer.parseInt(GameHelper.getUserInput("\nEnter the number of sides on the die >>> "));
        Dice d = new Dice(userSides);
        d.setRollResult();
        dicePool.add(d);
    }
    // remove a die from the dice pool
    public void removeFromPlayerRolls() {
        int aRollResult = Integer.parseInt(GameHelper.getUserInput("\nEnter the roll result you want to remove >>> "));
        for (Dice die : dicePool) {
            int num = die.getRollResult();
            if (num == aRollResult) {
                dicePool.remove(die);
                break;
            }
        }
    }
    // print the player's dice pool thus far
    public String getPlayerRolls() {
        String rolls = "";
        for (Dice die : dicePool) {
            rolls += die.getRollResult() + " ";
        }
        return rolls;
    }
    public int getRollTotal() {
        int total=0;
        for (Dice die : dicePool) {
            total += die.getRollResult();
        }
        return total;
    }
    public Player() {
        dicePool = new ArrayList<Dice>();
    }

    public void setName(String n) {
        name = n;
    }
    public String getName() {
        return name;
    }

}