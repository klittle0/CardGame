public class Card {
    private String rank;
    private String suit;
    private int point;

    private boolean isFaceUp;

    public Card(String rank, String suit, int point) {
        this.rank = rank;
        this.suit = suit;
        this.point = point;
        isFaceUp = false;
    }


    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public String toString(){
        return "[" + rank + "] of [" + suit + "]";
    }


}
