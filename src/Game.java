// Program by Kate Little, 12/14/22
// Last edited by Kate Little 2/13/23
import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private Player current;
    private Deck deck;
    private Card top;
    private int answer;
    private boolean isGameStarted;
    private boolean isGameOver;
    private boolean isWinner;
    private Player winner;
    private GameView window;

    private Card topCopy;

    // Creates new game object
    public Game() {
        Scanner s = new Scanner(System.in);
        isGameStarted = false;
        isGameOver = false;
        isWinner = false;
        winner = null;
        // Initializes viewer
        window = new GameView(this);
        String[] rank = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] suits = new String[]{"Hearts", "Clubs", "Spades", "Diamonds"};
        int[] points = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        printInstructions();
        //Gets user's name
        System.out.println("What is the first player's name? ");
        String nameOne = s.nextLine();
        player1 = new Player(nameOne);
        System.out.println("What is the second player's name?");
        String nameTwo  = s.nextLine();
        player2 = new Player(nameTwo);

        // Creates a new game deck
        deck = new Deck(rank, suits, points);
    }

    public boolean getGameStarted() { return isGameStarted; }

    public boolean getGameOver() {
        return this.isGameOver;
    }

    public Player getWinner() {
        return winner;
    }

    public boolean getIsWinner() { return isWinner; }

    public Card getTop() { return top; }

    public Player getCurrent() { return current; }

    public Deck getDeck() { return deck; }


    // Prints instructions
    public static void printInstructions()
    {
        System.out.println("Welcome to ZERO, aka knock off UNO!");
        System.out.println("Instructions: ");
        System.out.println("Each player will receive seven cards. When it is your turn, your hand will " +
                        "appear on the screen, each card corresponding to a key number. The goal is to play a card " +
                        "with the same suit2 and/or rank as the card at the top of the game pile. " +
                        "To play a certain card, enter the key number. If the card is invalid, you will receive " +
                        "an error message, prompting you to play a different card or draw from the deck. " +
                        "To draw, enter -2. When you have no cards remaining, type 0. The first player to do so wins.");
        System.out.println("Good luck!");
    }

    // Checks if the card the user wants to play is valid
    public boolean isValid(int userInput, Player player){
        if (userInput <= 0 || (userInput - 1) >= player.getHand().size()){
            return false;
        }
        Card userCard = player.getHand().get(userInput - 1);
        // If the suit of the card the user inputted is the suit/rank of the top card or = -1 (input to draw)
        return (userCard.getSuit().equals(top.getSuit())) || (userCard.getRank().equals(top.getRank()));
    }

    // Conducts a round for 1 player. Terminates once the player has placed a card on the game deck
    public void userRound(Player current){
        Scanner s = new Scanner(System.in);
        answer = 1;
        this.current = current;
        window.repaint();
        // Continues with player's turn until they have successfully placed a card on top of the deck
        while (topCopy.equals(top)) {
            System.out.println("pile: " + top);
            // Displays user's hand
            System.out.println(current.getHand());
            current.printKeys();
            System.out.println("Enter which card you wish to play, -2 to draw, or 0 iff you have won: ");
            answer = s.nextInt();
            // If card is valid, put on top of game deck
            if (isValid(answer, current)) {
                top = current.getHand().remove(answer - 1);
                break;
            }
            // If the user is trying to draw a new card
            else if (answer == -2) {
                // Player gets a card from the deck iff there are cards remaining. Else, the game is ended
                if (deck.getCardsLeftVariable() > 0){
                    current.addCard(deck.deal());
                    window.repaint();
                }
                else{
                    System.out.println("There are no cards left in the deck. Please restart the game to play again.");
                    break;
                }
            }
            // If user claims they have won
            else if (answer == 0){
                break;
            }
            else {
                System.out.println("Your input is invalid. Either play a new card or draw from the deck until you can " +
                        "play again.");
            }
        }
    }

    // Conducts turn after turn until a player claims they have won or the deck has no cards left
    public void playGame() {
        isGameStarted = true;
        // Shuffles deck
        deck.shuffle();
        // Each player is given a hand. At the beginning of each turn, the hand is displayed on the screen.
        // Each card is assigned a number beneath it (print a row of nums)
        player1.giveHand(deck);
        player2.giveHand(deck);

        // Should display a dealt card/the top of the game deck
        top = deck.deal();
        topCopy = top;
        answer = 1;
        // Player 1 & 2 will keep taking turns until one of them enters a 0 or deck runs out of cards
        while (answer != 0 && deck.getCardsLeftVariable() > 0) {
            // Player1's turn:
            System.out.println(player1.getName() + "'s turn: ");
            userRound(player1);
            topCopy = top;
            // Player2's turn:
            if (answer != 0){
                System.out.println(player2.getName() + "'s turn: ");
                userRound(player2);
                topCopy = top;
            }
        }
        isGameOver = true;
        // Checks if player1 has won
        if (hasWon(player1)) {
            System.out.println(player1.getName() + " has won!");
            isWinner = true;
            winner = player1;
        }
        // Checks if player2 has won
        else if (hasWon(player2)){
            System.out.println(player2.getName() + " has won!");
            isWinner = true;
            winner = player2;
        }
        else{
            System.out.println("A player has entered 0 without a winning hand. As a result, there is no winner.");
        }
        window.repaint();

    }

    // Checks if a player has won the game
    public boolean hasWon(Player player){
        return player.getHand().size() == 0;
    }

    // Creates & plays new game object
    public static void main(String[] args) {
        Game newGame = new Game();
        newGame.playGame();
    }
}
