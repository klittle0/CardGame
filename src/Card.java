//Program by Kate Little, 12/14/22
public class Card {
    private String rank;
    private String suit;
    private int point;

    //constructs a new card
    public Card(String rank, String suit, int point) {
        this.rank = rank;
        this.suit = suit;
        this.point = point;
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

    //Prints card in style [rank] of [suit]
    public String toString(){
        return "[" + rank + "] of [" + suit + "]";
    }


}
