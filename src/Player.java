import java.util.ArrayList;
public class Player {
    private String name;
    private ArrayList <Card> card;
    private ArrayList <Card> hand;
    private int points;

    public Player(String name) {
        this.name = name;
        points = 0;
        hand = new ArrayList <Card>();
    }

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

    //deals the player 7 cards
    public void giveHand(Deck deck){
        for (int i = 0; i < 7; i++){
            addCard(deck.deal());
        }
    }
    //returns player's points + cards in string data type
    public String String(){
        return getName() + " has " + getPoints() + "\n" + getName() +"'s cards:" + getHand();
    }
}
