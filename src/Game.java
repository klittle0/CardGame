import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Player player1;
    private ArrayList <Card> deck;

    public Game() {
        //Gets user's name
        Scanner s = new Scanner(System.in);
        System.out.println("What is your name? ");
        String name = s.nextLine();
        player1 = new Player(name);

        //I have to create variables for ranks, suits, and points
        deck = new Deck(ranks, suits, points)
    }

    public static void printInstructions()
    {
        System.out.println("Welcome to solitaire!");
        System.out.println("Instructions: ");
        System.out.println("")
    }
    public void playGame(){
        //insert actual game play & how it works
        //creates board
        String[][] board = new String[][];

    }
    public static void main(String[] args) {
        Game newGame = new Game();
    }

}
