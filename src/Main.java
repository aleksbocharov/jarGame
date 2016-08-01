import com.teamtreehouse.Game;
import com.teamtreehouse.Jar;
import com.teamtreehouse.LeaderBoard;

import java.util.Scanner;

public class Main {
    private static void displayAdminBanner(){
        System.out.println("Admin setup");
        System.out.println("------------");
    }

    private static Jar newJar(Scanner scan){
        System.out.print("Enter item name: ");
        String itemName = scan.next();
        System.out.print("Enter number of items: ");
        int maxItemsNum = scan.nextInt();
        return new Jar(itemName, maxItemsNum).generateQuantity();
    }

    public static void main(String[] args) {
        System.out.println();
        Scanner scan = new Scanner(System.in);
        boolean keepPlaying = true;
        LeaderBoard lb = new LeaderBoard();
        while (keepPlaying) {
            if(!lb.getHighScores().isEmpty()) lb.display();
            displayAdminBanner();
            Jar jar = newJar(scan);
            Game game = new Game(jar);
            game.playGame();
            lb.addResult(game.getPlayerName(),game.getAttempts());
            System.out.println("Play again? Yes or no:");
            String answer = scan.next();
            keepPlaying = answer.toLowerCase().startsWith("y");
        }
        scan.close();
    }
}
