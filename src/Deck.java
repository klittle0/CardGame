import java.util.ArrayList;

public class Deck {
    ArrayList<Card> cards;
    int cardsLeft;

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
}
