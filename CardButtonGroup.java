import java.util.ArrayList;
import java.util.Arrays;

public class CardButtonGroup {
    private ArrayList<CardButton> cardButtons;
    private int sum = 0;

    public CardButtonGroup() {
        cardButtons = new ArrayList<>();
    }

    public void add(CardButton cb) {
        cardButtons.add(cb);
    }

    public ArrayList<CardButton> getCardButtons() {
        return cardButtons;
    }

    public CardButton get(int index) {
        return cardButtons.get(index);
    }

    public int count() {
        return cardButtons.size();
    }

    public int selectedCount() {
        int count = 0;

        for (CardButton cb : cardButtons)
            if (cb.isSelected())
                count++;

        return count;
    }

    public void deselectAll() {
        for (CardButton cb : cardButtons) {
            cb.setSelected(false);
        }
    }

    public int getSum() {
        int sum = 0;

        for (CardButton cb : cardButtons)
            if (cb.isSelected())
                sum += cb.getCard().getNumericalValue();

        return sum;
    }

    public ArrayList<CardButton> selectedButtons() {
        ArrayList<CardButton> selected = new ArrayList<CardButton>();

        for (CardButton cb : cardButtons)
            if (cb.isSelected())
                selected.add(cb);

        return selected;
    }

    private ArrayList<Integer> negs;
    public int[][][] getRegalTripleSums() {
        negs = new ArrayList<>();
        for (int i = 0; i < cardButtons.size(); i++)
            if (cardButtons.get(i).getCard().getNumericalValue() < 0)
                negs.add(i);

        if (negs.size() < 3) return null;

        int[][][] sums = new int[negs.size()][negs.size()][negs.size()];

        for (int i = 0; i < sums.length; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < j; k++) {
                    sums[i][j][k] = cardButtons.get(negs.get(i)).getCard().getNumericalValue()
                            + cardButtons.get(negs.get(j)).getCard().getNumericalValue()
                            + cardButtons.get(negs.get(k)).getCard().getNumericalValue();
                }
            }
        }
        return sums;
    }

    public void highlightHint() {
        for (int i = 0; i < cardButtons.size(); i++)
            for (int j = 0; j < i; j++) {
                if (cardButtons.get(i).getCard().getNumericalValue() + cardButtons.get(j).getCard().getNumericalValue() == 11) {
                    cardButtons.get(i).setSelected(true);
                    cardButtons.get(j).setSelected(true);
                    return;
                }
            }

        int[][][] tSum = getRegalTripleSums();
        if (tSum != null) {
            for (int i = 0; i < tSum.length; i++) {
                for (int j = 0; j < i; j++)
                    for (int k = 0; k < j; k++)
                        if (tSum[i][j][k] == -6) {
                            cardButtons.get(negs.get(i)).setSelected(true);
                            cardButtons.get(negs.get(j)).setSelected(true);
                            cardButtons.get(negs.get(k)).setSelected(true);
                            return;
                        }
            }
        }
    }

    public boolean isGameOver() {
        for (int i = 0; i < cardButtons.size(); i++)
            for (int j = 0; j < i; j++) {
                if (cardButtons.get(i).getCard().getNumericalValue() + cardButtons.get(j).getCard().getNumericalValue() == 11) {
                    return false;
                }
            }

        int[][][] tSum = getRegalTripleSums();
        if (tSum != null) {
            for (int i = 0; i < tSum.length; i++) {
                for (int j = 0; j < i; j++)
                    for (int k = 0; k < j; k++)
                        if (tSum[i][j][k] == -6) {
                            return false;
                        }
            }
        }
        return true;
    }

    public boolean isEleven() {
        int count = selectedCount();
        int sum = getSum();

        if (count == 2 && sum == 11)
            return true;
        if (count == 3 && sum == -6)
            return true;
        return false;
    }
}
