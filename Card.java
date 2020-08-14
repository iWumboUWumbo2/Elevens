public class Card {

    private String value;
    private String suite;

    public Card(String value, String suite) {
        this.value = value;
        this.suite = suite;
    }

    public String getSuite() {
        return suite;
    }

    public String getValue() {
        return value;
    }

    public int getNumericalValue() {
        switch (value.charAt(0)) {
            case 'J':
                return -1;
            case 'Q':
                return -2;
            case 'K':
                return -3;
            case 'A':
                return 1;
            default:
                return Integer.parseInt(value);
        }
    }

    @Override
    public String toString() {
        return value + suite;
    }

}
