import com.teamtreehouse.Game;
import com.teamtreehouse.Jar;
import com.teamtreehouse.LeaderBoard;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println();
        Scanner scan = new Scanner(System.in);
        boolean keepPlaying = true;
        LeaderBoard lb = new LeaderBoard();
        while (keepPlaying) {
            if(!lb.getHighScores().isEmpty()) lb.display();
            System.out.println("Admin setup");
            System.out.println("------------");

            System.out.print("Enter item name: ");
            String itemName = scan.next();
            System.out.print("Enter number of items: ");
            int maxItemsNum = scan.nextInt();

            Jar jar = new Jar(itemName, maxItemsNum);

            System.out.printf("%n%nPlayer%n---------%n");
            System.out.printf("Guess how many %s in the jar. " +
                            "Your guess should be between %d and %d.%n",
                    jar.getItemName(), 1, jar.getMaxQuantity());
            Game game = new Game(jar);
            game.playGame();
            lb.addResult(game.getPlayerName(),game.getAttempts());
            System.out.println("Play again? Yes or no:");
            String answer = scan.next();
            keepPlaying = answer.toLowerCase().startsWith("y");
        }

    }
}
