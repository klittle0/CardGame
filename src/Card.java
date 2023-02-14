import java.awt.*;

// Program by Kate Little, 12/14/22
// Last edited by Kate Little 2/13/23
public class Card {
    private String rank;
    private String suit;
    private int point;
    private int deckPosition;
    private final int TOP_PILE_SPOT_X = 517;
    private final int TOP_PILE_SPOT_Y = 280;

    // Constructs a new card
    public Card(String rank, String suit, int point) {
        this.rank = rank;
        this.suit = suit;
        this.point = point;
        // This formula determines which of the card images in my array of 52 represents this card.
        // deckPosition = index
        deckPosition = (point - 1) * 4;
        if (suit.equals("Clubs")){
            deckPosition++;
        }
        else if (suit.equals("Spades")){
            deckPosition += 2;
        }
        else if (suit.equals("Diamonds")){
            deckPosition += 3;
        }
    }

    // Draws the last card placed on top of the pile
    public void draw(Graphics g, GameView v){
        Image[] cards = v.getCards();
        int increment = v.getINCREMENT();
        int cardWidth = cards[0].getWidth(v) / 3;
        int cardHeight = cards[0].getHeight(v) / 3;
        g.drawImage(cards[deckPosition],TOP_PILE_SPOT_X, TOP_PILE_SPOT_Y, cardWidth, cardHeight, v);
    }

    // Overloads draw constructor. Takes the x-y coordinates of the card, signaling that it's in a user's hand
    public void draw(Graphics g, GameView v, int x, int y){
        Image[] cards = v.getCards();
        int cardWidth = cards[0].getWidth(v) / 4;
        int cardHeight = cards[0].getHeight(v) / 4;
        g.drawImage(cards[deckPosition],x, y, cardWidth, cardHeight, v);
    }

    public String getRank() {
        return rank;
    }
    public String getSuit() {
        return suit;
    }
    public int getPoint() {
        return point;
    }
    public int getDeckPosition() { return deckPosition; }

    // Prints card in style [rank] of [suit]
    public String toString(){
        return "[" + rank + "] of [" + suit + "]";
    }
}
