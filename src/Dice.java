/**
 * Created by Cale on 12/25/14.
 */
public class Dice {

    private int numberOfSides;
    private int rollResult;

    // roll the die
    public void setRollResult() {
        rollResult = (int) ((Math.random() * (numberOfSides) +1));
    }
    public int getRollResult() {
        return rollResult;
    }
    public int getNumberOfSides() {
        return numberOfSides;
    }
    public Dice(int numSides) {
        numberOfSides = numSides;
    }

}