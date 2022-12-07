import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;
    int cardsLeft;

    //Constructs a new deck
    public Deck(String[] ranks, String[] suits, int[] points) {
        cards = new ArrayList <Card>();
        //here, i'm assuming that 10 is repeated once for every rank with 10. Maybe i will have to determine the rank/points in a different way that accomodates for more ranks than point options
        for (int i = 0; i < ranks.length; i++) {
            for (String suit : suits) {
                Card current = new Card(ranks[0], suit, points[0]);
                cards.add(current);
            }
        }
    }

    //Returns whether deck is empty (true or false)
    public boolean isEmpty(ArrayList <Card> deck){
        return getCardsLeft() > 0;
    }

    //Returns the number of cards left in the deck
    public int getCardsLeft() {
        cardsLeft = 0;
        for (Card card: cards){
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
        for (int i = cards.size(); i >= 0; i--){
            int r = (int) (Math.random() * i);
            Card temp = cards.get(i);
            //Should set index i to the value of cards at index r
            cards.set(i, cards.get(r));
            cards.set(r, temp);

        }
    }


}
