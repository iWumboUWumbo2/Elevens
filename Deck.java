import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private String[] cardValues = new String[] {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    private String[] suitNames = new String[] {"C","D","H","S"};

    private ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<>();

        for (int i = 0; i < cardValues.length; i++)
            for (int j = 0; j < suitNames.length; j++)
                deck.add(new Card(cardValues[i], suitNames[j]));
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public Card get(int index) {
        return deck.get(index);
    }

    public void remove(int index) {
        deck.remove(index);
    }

    public int size() {
        return deck.size();
    }

    public ArrayList<Card> getCardList() {
        return deck;
    }
}
