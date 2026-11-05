import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();
        String playAgain = "y";

        while (playAgain.equalsIgnoreCase("y")) {
            // First roll
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.println("Roll: Die 1 = " + die1 + ", Die 2 = " + die2 + ", Sum = " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Crapped out! You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win.");
            } else {
                // Point phase
                int point = sum;
                System.out.println("The point is now " + point);

                boolean gameOver = false;
                while (!gameOver) {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;

                    System.out.println("Roll: Die 1 = " + die1 + ", Die 2 = " + die2 + ", Sum = " + sum);

                    if (sum == point) {
                        System.out.println("Status: Made point and won.");
                        gameOver = true;
                    } else if (sum == 7) {
                        System.out.println("Status: Got a seven and lost.");
                        gameOver = true;
                    } else {
                        System.out.println("Status: Trying for point");
                    }
                }
            }

            System.out.print("Do you want to play again? (y/n): ");
            playAgain = in.nextLine();
        }

        in.close();
    }
}
