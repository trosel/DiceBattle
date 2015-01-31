import java.lang.reflect.Array;
import java.util.*;
/**
 * Created by Cale on 12/25/14.
 */
public class Game {

    ArrayList<Player> players = new ArrayList<Player>();

    public void startGame() {
        // introduction
        System.out.println("Welcome to Dice Battle!" +
                "\nEach player gets one action per turn. Either add or remove a die." +
                "\n(viewing your dice pool does not count as an action)" +
                "\nThe player with the highest dice total at the end of the game WINS!");


        // set up players
        int numPlayers = Integer.parseInt(GameHelper.getUserInput("How many players? >>> "));
        for (int i = 1; i <= numPlayers; i++) {
            Player p = new Player();
            players.add(p);
            p.setName(GameHelper.getUserInput("What is player " + i + "'s name?"));
        }
    }
    public void playGame() {
        boolean keepPlaying = true, turnContinues = true;
        String menuChoice, confirmation;


        while(keepPlaying) {

            for(Player p:players) {
                System.out.println("\n-----------------------------------");
                System.out.println("It's " + p.getName() + "'s turn.");
                System.out.println("-----------------------------------");
                turnContinues = true;

                while(turnContinues) {
                    System.out.println("\n(1) Add to your dice pool\n(2) Remove a roll from your dice pool"
                            + "\n(3) View your dice pool\n(4) Quit Game");
                    menuChoice = GameHelper.getUserInput("Type 1, 2, 3, or 4 >>> ");
                    if (menuChoice.equals("1")) {
                        p.addToPlayerRolls();
                        turnContinues = false;

                    } else if (menuChoice.equals("2")) {
                        p.removeFromPlayerRolls();
                        turnContinues = false;

                    } else if (menuChoice.equals("3")) {
                        System.out.println(p.getName() + "'s dice pool: " + p.getPlayerRolls());
                    } else if (menuChoice.equals("4")) {
                        confirmation = GameHelper.getUserInput("Are you sure you want to stop the game? y/n");
                        if (confirmation.equals("y") || confirmation.equals("Y")) {
                            keepPlaying = false;
                            break;
                        } else {
                            // do nothing, start while loop again
                        }
                    } else {
                        System.out.println("Sorry, what was that?");
                    }
                }
                if (keepPlaying == false) {
                    break;
                }
            }
        }


    }
    public void finishGame() {
        ArrayList<Integer> playerTotals = new ArrayList<Integer>();
        Integer highestTotal = 0;
        Player theWinner = new Player();

        // print player's dice pools
        for (Player p:players) {
            System.out.println(p.getName() + "'s dice pool: " + p.getPlayerRolls());
            playerTotals.add(p.getRollTotal());
        }

        // Find the winner
        for (Integer total:playerTotals) {
            if(total > highestTotal) {
                highestTotal = total;
            }
        }
        for (Player p:players) {
            if (p.getRollTotal() == highestTotal) {
                theWinner = p;
            }
        }


        System.out.println("The winner is... " + theWinner.getName() + "! With a total of " + theWinner.getRollTotal());
        System.out.println("Thanks for playing!");
    }


}
