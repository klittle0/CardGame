//Program by Kate Little, 12/14/22
import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList <Card> card;
    private ArrayList <Card> hand;
    private int points;

    //Constructs a new player
    public Player(String name) {
        this.name = name;
        points = 0;
        hand = new ArrayList <Card>();
    }

    //Alternate constructor for when player already has a hand
    public Player(String name, ArrayList <Card> hand) {
        this.name = name;
        points = 0;
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getCard() { return card; }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getPoints() {
        return points;
    }

    //Prints a numeric label for each card
    public void printKeys(){
        for (int i = 0; i < hand.size(); i++){
            System.out.print("         " + (i + 1) + "       ");
        }
        System.out.println(" ");
    }

    //Adds a new card to the player's hand
    public void addCard(Card other){
        hand.add(other);
    }

    //Deals the player 7 cards
    public void giveHand(Deck deck){
        for (int i = 0; i < 7; i++){
            addCard(deck.deal());
        }
    }
    //Returns player's points + cards as a string
    public String String(){
        return getName() + " has " + getPoints() + "\n" + getName() +"'s cards:" + getHand();
    }
}
