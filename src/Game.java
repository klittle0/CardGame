import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private Deck deck;
    private Card top;

    private Card topCopy;
    private int[] points;


    public Game() {
        Scanner s = new Scanner(System.in);
        String[] rank = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] suits = new String[]{"Hearts", "Clubs", "Spades", "Diamonds"};
        points = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        printInstructions();
        //Gets user's name
        System.out.println("What is the first player's name? ");
        String nameOne = s.nextLine();
        player1 = new Player(nameOne);
        System.out.println("What is the second player's name?");
        String nameTwo  = s.nextLine();
        player2 = new Player(nameTwo);

        //creates a new game deck
        deck = new Deck(rank, suits, points);
    }

    public static void printInstructions()
    {
        System.out.println("Welcome to ZERO, aka knock off UNO!");
        System.out.println("Instructions: ");
        System.out.println("Each player will receive seven cards. When it is your turn, your hand will " +
                        "appear on the screen, each card corresponding to a key number. The goal is to play a card " +
                        "with the same suite and/or rank as the card at the top of the game pile. " +
                        "To play a certain card, enter the key number. If the card is invalid, you will receive " +
                        "an error message, prompting you to play a different card or draw from the deck. " +
                        "To draw, enter -1. When you have no cards remaining, type 0. The first player to do so wins.");
        System.out.println("Good luck!");
    }

    //Checks if the card the user wants to play is valid
    public boolean isValid(int userInput, Player player){
        if (userInput == 0 || userInput == -2 || (userInput - 1) >= player.getHand().size()){
            return false;
        }
        Card userCard = player.getHand().get(userInput - 1);
        //if the suit of the card the user inputted is the suit/rank of the top card or = -1 (input to draw)
        if ((userCard.getSuit().equals(top.getSuit())) || (userCard.getRank().equals(top.getRank()))){
            return true;
        }
        else{
            return false;
        }
    }
    public void playGame() {
        Scanner s = new Scanner(System.in);
        //deck is shuffled
        deck.shuffle();
        //each player is given a hand. At the beginning of each turn, the hand is displayed on the screen. Each card is assigned a number beneath it (print a row of nums)
        player1.giveHand(deck);
        player2.giveHand(deck);
        int answer = 1;

        //should display a dealt card
        top = deck.deal();
        topCopy = top;

        //player 1 & 2 will keep taking turns until one of them enters a 0
        while (answer != 0) {
            System.out.println("pile: " + top);
            System.out.println(player1.getName() + "'s turn: ");
            //this isn't correct. I need to make a copy to test if the user has delt a card. While user hasn't dealt a card...
            while (topCopy.equals(top)) {
                //displays user's hand
                System.out.println(player1.getHand());
                player1.printKeys();
                System.out.println("Enter which card you wish to play, -2 to draw, or 0 iff you have won: ");
                answer = s.nextInt();
                if (isValid(answer, player1)) {
                    top = player1.getHand().remove(answer - 1);
                    break;
                }
                //if the user is trying to draw
                else if (answer == -2) {
                    //player gets a card from the deck
                    player1.addCard(deck.deal());
                }
                else if (answer == 0){
                    break;
                }
                else {
                    System.out.println("Your input is invalid. Either play a new card or draw from the deck until you can " +
                            "play again.");
                }
            }
            topCopy = top;
            //player1 has completed a turn
            System.out.println("pile: " + top);
            System.out.println(player2.getName() + "'s turn: ");

            //runs until player 2 has completes their turn
            while (topCopy.equals(top)) {
                //displays user's hand
                System.out.println(player2.getHand());
                player2.printKeys();
                System.out.println("Enter which card you wish to play, -2 to draw, or 0 iff you have won: ");
                answer = s.nextInt();
                if (isValid(answer, player2)) {
                    top = player2.getHand().remove(answer - 1);
                    break;
                }
                //if the user is trying to draw
                else if (answer == -2) {
                    //player gets a card from the deck
                    player2.addCard(deck.deal());
                }
                else if (answer == 0){
                    break;
                }
                else {
                    System.out.println("Your input is invalid. Either play a new card or draw from the deck until you can " +
                            "play again.");
                }
            }
            topCopy = top;
        }
        //if player1 has reached zero cards, they were the one who declared 0 above.
        if (player1.getHand().size() == 0) {
            System.out.println(player1 + " has won!");
        }
        //otherwise, player2 is the winner.
        else {
            System.out.println(player2 + " has won!");
        }

    }
        //the user will type that number to play that card.
        //if they don't have a good card, they can type: "draw" to get another card from the deck.
        //if the card that corresponds to that number is a valid move, it will be placed on top of the playing deck
        //it will be removed from the player's deck
        //if the card is invalid, a message will appear, re-prompting the user to play or draw

        //valid card = same suite, same points

    public static void main(String[] args) {
        Game newGame = new Game();
        newGame.playGame();
    }

}
