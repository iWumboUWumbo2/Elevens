import javax.swing.*;
import java.awt.*;

public class CardButton extends JToggleButton {
    private Card c;
    private Dimension d;

    public CardButton(Card c, Dimension d) {
        this.c = c;
        this.d = d;

        ImageIcon icon = new ImageIcon("CardImages/" + c + ".png");
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(d.width, d.height, Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(newImg));
        setBackground(new Color(39, 100, 20));
        setBorder(BorderFactory.createEmptyBorder());
    }

    public void changeCard(Card c) {
        this.c = c;
        ImageIcon icon = new ImageIcon("CardImages/" + c + ".png");
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(d.width, d.height, Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(newImg));
    }

    public Card getCard(){
        return c;
    }

}

// 115, 176