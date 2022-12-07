import java.util.ArrayList;
public class Player {
    private String name;
    private ArrayList <Card> card;
    private ArrayList <Card> hand;
    private int points;

    public Player(String name) {
        this.name = name;
        points = 0;
    }

    public Player(String name, ArrayList <Card> hand) {
        this.name = name;
        points = 0;
    }

    public String getName() {
        return name;
    }
    public ArrayList<Card> getCard() {
        return card;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getPoints() {
        return points;
    }

    //Adds a new card to the player's hand
    public void addCard(Card other){
        hand.add(other);

    }
    //returns player's points + cards in string data type
    public String String(){
        return getName() + " has " + getPoints() + "\n" + getName() +"'s cards:" + getHand();
    }
}
