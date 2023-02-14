import javax.swing.*;
import java.awt.*;

// Program by Kate Little, 12/14/22
// Last edited by Kate Little 2/13/23

// GameView is a class to create the Zero game window.
// I know it should be titled GameViewer, but I mistyped and I can't figure out how to rename

public class GameView extends JFrame {

    private final int WINDOW_WIDTH = 1200;
    private final int WINDOW_HEIGHT = 800;
    //I use multiples of INCREMENT to consistently space graphics in the window without using a ton of magic numbers
    private final int INCREMENT = 200;
    private Image[] cards;
    private Game game;
    private Image logoImage;
    private Image cardBackImage;

    public GameView(Game game){
        this.game = game;
        cards = new Image[52];

        // Initializes every card image here
        logoImage = new ImageIcon("Resources/Zero logo final.png").getImage();
        cardBackImage = new ImageIcon("Resources/card_back.png").getImage();
        cards[0] = new ImageIcon("Resources/ace_of_hearts.png").getImage();
        cards[1] = new ImageIcon("Resources/ace_of_clubs.png").getImage();
        cards[2] = new ImageIcon("Resources/ace_of_spades.png").getImage();
        cards[3] = new ImageIcon("Resources/ace_of_diamonds.png").getImage();

        cards[4] = new ImageIcon("Resources/2_of_hearts.png").getImage();
        cards[5] = new ImageIcon("Resources/2_of_clubs.png").getImage();
        cards[6] = new ImageIcon("Resources/2_of_spades.png").getImage();
        cards[7] = new ImageIcon("Resources/2_of_diamonds.png").getImage();

        cards[8] = new ImageIcon("Resources/3_of_hearts.png").getImage();
        cards[9] = new ImageIcon("Resources/3_of_clubs.png").getImage();
        cards[10] = new ImageIcon("Resources/3_of_spades.png").getImage();
        cards[11] = new ImageIcon("Resources/3_of_diamonds.png").getImage();

        cards[12] = new ImageIcon("Resources/4_of_hearts.png").getImage();
        cards[13] = new ImageIcon("Resources/4_of_clubs.png").getImage();
        cards[14] = new ImageIcon("Resources/4_of_spades.png").getImage();
        cards[15] = new ImageIcon("Resources/4_of_diamonds.png").getImage();

        cards[16] = new ImageIcon("Resources/5_of_hearts.png").getImage();
        cards[17] = new ImageIcon("Resources/5_of_clubs.png").getImage();
        cards[18] = new ImageIcon("Resources/5_of_spades.png").getImage();
        cards[19] = new ImageIcon("Resources/5_of_diamonds.png").getImage();

        cards[20] = new ImageIcon("Resources/6_of_hearts.png").getImage();
        cards[21] = new ImageIcon("Resources/6_of_clubs.png").getImage();
        cards[22] = new ImageIcon("Resources/6_of_spades.png").getImage();
        cards[23] = new ImageIcon("Resources/6_of_diamonds.png").getImage();

        cards[24] = new ImageIcon("Resources/7_of_hearts.png").getImage();
        cards[25] = new ImageIcon("Resources/7_of_clubs.png").getImage();
        cards[26] = new ImageIcon("Resources/7_of_spades.png").getImage();
        cards[27] = new ImageIcon("Resources/7_of_diamonds.png").getImage();

        cards[28] = new ImageIcon("Resources/8_of_hearts.png").getImage();
        cards[29] = new ImageIcon("Resources/8_of_clubs.png").getImage();
        cards[30] = new ImageIcon("Resources/8_of_spades.png").getImage();
        cards[31] = new ImageIcon("Resources/8_of_diamonds.png").getImage();

        cards[32] = new ImageIcon("Resources/9_of_hearts.png").getImage();
        cards[33] = new ImageIcon("Resources/9_of_clubs.png").getImage();
        cards[34] = new ImageIcon("Resources/9_of_spades.png").getImage();
        cards[35] = new ImageIcon("Resources/9_of_diamonds.png").getImage();

        cards[36] = new ImageIcon("Resources/10_of_hearts.png").getImage();
        cards[37] = new ImageIcon("Resources/10_of_clubs.png").getImage();
        cards[38] = new ImageIcon("Resources/10_of_spades.png").getImage();
        cards[39] = new ImageIcon("Resources/10_of_diamonds.png").getImage();

        cards[40] = new ImageIcon("Resources/jack_of_hearts.png").getImage();
        cards[41] = new ImageIcon("Resources/jack_of_clubs.png").getImage();
        cards[42] = new ImageIcon("Resources/jack_of_spades.png").getImage();
        cards[43] = new ImageIcon("Resources/jack_of_diamonds.png").getImage();

        cards[44] = new ImageIcon("Resources/queen_of_hearts.png").getImage();
        cards[45] = new ImageIcon("Resources/queen_of_clubs.png").getImage();
        cards[46] = new ImageIcon("Resources/queen_of_spades.png").getImage();
        cards[47] = new ImageIcon("Resources/queen_of_diamonds.png").getImage();

        cards[48] = new ImageIcon("Resources/king_of_hearts.png").getImage();
        cards[49] = new ImageIcon("Resources/king_of_clubs.png").getImage();
        cards[50] = new ImageIcon("Resources/king_of_spades.png").getImage();
        cards[51] = new ImageIcon("Resources/king_of_diamonds.png").getImage();

        // Sets up the window
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("ZeroCardGame");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public Image[] getCards() { return cards; }
    public int getINCREMENT() { return INCREMENT; }

    // Paints a different window layout depending on the state of gameplay
    public void paint(Graphics g){
        // Sets font details
        g.setFont(new Font("SansSerif", Font.BOLD, 20));
        g.setColor(new Color(0, 60, 42));
        // Draws green rectangle for background
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        g.setColor(Color.white);
        // If the game isn't over:
        if (!game.getGameOver())
        {
            // If the game has not yet started, print logo + instructions
            if (!game.getGameStarted()){
                g.drawImage(logoImage, INCREMENT * 2, INCREMENT * 3/2, this);
                g.drawString("Welcome to Zero! You will receive 7 cards. Try to get rid of them by matching ", INCREMENT, INCREMENT * 3);
                g.drawString("the rank or suit of the top of the discard pile. The first player to do so wins!", INCREMENT, INCREMENT * 31/10);

            }
            // If the game is active:
            else {
                // Prints top card of the deck
                game.getTop().draw(g, this);
                // Prints player's hand
                Player current = game.getCurrent();
                int handSize = current.getHandSize();
                int cardWidth = cards[0].getWidth(this) / 4;
                // Determines the space between cards when drawn displayed on screen
                int space = (WINDOW_WIDTH - cardWidth * handSize) / (handSize + 1);
                // Prints each card of the player's hand
                for (int i = 0; i < handSize; i++){
                    if (space > 0){
                        current.getHand().get(i).draw(g, this, space * (i + 1) + cardWidth * i, INCREMENT * 3);
                    }
                    // If there's no space between the cards, print so that they overlap
                    else{
                        current.getHand().get(i).draw(g, this, (WINDOW_WIDTH / handSize) * i, INCREMENT * 3);
                    }
                }
                // If there are cards remaining in the deck, prints the back of a card to represent
                // The deck in top left corner
                 if (game.getDeck().getCardsLeftVariable() > 0){
                    g.drawImage(cardBackImage, INCREMENT * 1/4 , INCREMENT * 1/3, this);
                }
            }
        }
        // If the game has finished, print logo + winner (if there is one)
        else {
            g.drawImage(logoImage, INCREMENT * 2, INCREMENT * 3/2, this);
            if (game.getIsWinner()){
                g.drawString(game.getWinner() + " Wins!", INCREMENT * 5/2, INCREMENT * 3);
            }
            else{
                g.drawString("There is no winner:(", INCREMENT * 5/2, INCREMENT * 3);
            }
        }
    }
}
