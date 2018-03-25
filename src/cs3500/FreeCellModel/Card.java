package cs3500.hw02;

/**
 * Represents one card.
 */
public class Card {
  private final Value value;
  private final Suit suit;

  /**
   * Constructs a Card object.
   *
   * @param value the value(int) of the Card
   * @param suit  the suit(color) of the Webpage
   */
  public Card(Value value, Suit suit) {
    this.value = value;
    this.suit = suit;
  }

  /**
   * Give the value the card.
   *
   * @return value of the card
   */
  public Value getValue() {
    return value;
  }

  /**
   * Give the suit the card.
   *
   * @return suit of the card.
   */
  public Suit getSuit() {
    return suit;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Card)) {
      return false;
    }

    Card card = (Card) o;
    return card.suit.equals(suit)
            && card.value == value;
  }

  @Override
  public int hashCode() {
    int result = 15;
    result = 21 * result + suit.hashCode();
    result = 21 * result + value.hashCode();
    return result;
  }


  @Override
  public String toString() {
    return this.value.toString() + this.suit.toString();
  }

  /**
   * compare cards with the card below to it.
   *
   * @param c a card below the compared card.
   * @return boolean that the are valid sequence or not.
   */
  public boolean compareCard(Card c) {
    if (this.value.getInt() == (c.value.getInt() + 1)) {
      if (this.suit.equals(Suit.CLUB) || this.suit.equals(Suit.SPADE)) {
        return (c.getSuit().equals(Suit.DIAMOND) || c.getSuit().equals(Suit.HEART));

      } else if (this.suit.equals(Suit.DIAMOND) || this.suit.equals(Suit.HEART)) {
        return (c.getSuit().equals(Suit.CLUB) || c.getSuit().equals(Suit.SPADE));
      }
    }
    return false;
  }
}
