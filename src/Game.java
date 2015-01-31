import java.util.*;
/**
 * Created by Cale on 12/25/14.
 */
public class Game {
    Player p1 = new Player();

    public static void main(String[] args) {
        Game daGame = new Game();
        daGame.playGame();
        daGame.finishGame();
    }

    public void startGame() {
        System.out.print("How many players? >>> ");
        Scanner sc = new Scanner(System.in);
        String numPlayers = sc.next();
    }
    public void playGame() {
        boolean keepPlaying=true;
        String menuChoice;
        Scanner s = new Scanner(System.in);

        while(keepPlaying) {
            System.out.println("\n(1) Add to your dice pool\n(2) Remove a roll from your dice pool"
                    + "\n(3) View your dice pool\n(4) Quit game");
            System.out.print("Type 1, 2, 3, or 4 >>> ");
            menuChoice = s.next();
            if (menuChoice.equals("1")) {
                p1.addToPlayerRolls();
            } else if (menuChoice.equals("2")) {
                p1.removeFromPlayerRolls();
            } else if (menuChoice.equals("3")) {
                p1.getPlayerRolls();
            } else { keepPlaying = false; }
        }
    }
    public void finishGame() {
        p1.getPlayerRolls();
        System.out.println("Your total was: " + p1.getRollTotal());
        System.out.println("Thanks for playing!");
    }


}
