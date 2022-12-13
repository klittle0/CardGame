import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;
    private int cardsLeft;

    //Constructs a new deck
    public Deck(String[] ranks, String[] suits, int[] points) {
        cards = new ArrayList <Card>();
        //Fills arraylist with a deck
        for (int i = 0; i < ranks.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                cards.add(new Card(ranks[i], suits[j], points[i]));
            }
        }
    }

    //Returns whether deck is empty (true or false)
    public boolean isEmpty(ArrayList <Card> deck){
        return getCardsLeft() <= 0;
    }

    //Returns the number of cards left in the deck
    public int getCardsLeft() {
        cardsLeft = 0;
        for (Card each: cards){
            cardsLeft++;
        }
        return cardsLeft;
    }
    //Deals a card from deck to the user. If the deck is empty, returns null
    public Card deal(){
        if (isEmpty(cards)){
            return null;
        }
        cardsLeft--;
        return cards.get(cardsLeft);
    }

    //Reorders all cards in the deck/arraylist
    public void shuffle(){
        //Switches every card with another in the arraylist
        for (int i = cards.size() - 1; i >= 0; i--){
            //Gets random index of a card in arraylist
            int r = (int) (Math.random() * i);
            Card temp = cards.get(i);
            //Switches cards @ index i and r
            cards.set(i, cards.get(r));
            cards.set(r, temp);
        }
    }


}
