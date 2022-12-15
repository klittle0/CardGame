//Program by Kate Little, 12/14/22
import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;

    private int cardsLeft;

    //Constructs a new deck
    public Deck(String[] ranks, String[] suits, int[] points) {
        cards = new ArrayList<>();
        //Fills arraylist with a deck
        //Demonstrates that I can traverse and modify ArrayLists
        for (int i = 0; i < ranks.length; i++) {
            for (String suit : suits) {
                cards.add(new Card(ranks[i], suit, points[i]));
            }
        }
        //sets initial value of cardsLeft
        getCardsLeft();
    }

    //Returns whether deck is empty (true or false)
    public boolean isEmpty(){
        return cardsLeft <= 0;
    }

    //Returns the number of cards left in the deck. DOES NOT RE-CALCULATE THIS NUMBER
    public int getCardsLeftVariable(){
        return cardsLeft;
    }
    //Calculates & returns the number of cards left in the deck
    public int getCardsLeft() {
        cardsLeft = 0;
        for (Card each: cards){
            cardsLeft++;
        }
        return cardsLeft;
    }

    //Deals a card from deck to the user. If the deck is empty, returns null
    public Card deal(){
        if (isEmpty()){
            return null;
        }
        cardsLeft--;
        return cards.get(cardsLeft);
    }

    //Reorders all cards in the deck/arraylist
    public void shuffle(){
        for (int i = cards.size() - 1; i >= 0; i--){
            //Gets random index of another card in arraylist
            int r = (int) (Math.random() * i);
            Card temp = cards.get(i);
            //Switches cards @ index i and r
            cards.set(i, cards.get(r));
            cards.set(r, temp);
        }
    }
}
