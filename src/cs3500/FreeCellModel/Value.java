package cs3500.hw02;

/**
 * Represents the value of Card, from Ace(1) to King(13).
 */
public enum Value {
  ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9),
  TEN(10), JACK(11), QUEEN(12), KING(13);

  private final int value;

  /**
   * Constructs value enum.
   *
   * @param value the int value of Value
   */
  Value(int value) {

    this.value = value;
  }

  /**
   * Show the int of each value.
   *
   * @return value of the Value.
   */
  public int getInt() {
    return this.value;
  }

  @Override
  public String toString() {
    switch (this) {
      case ACE:
        return "A";
      case TWO:
        return "2";
      case THREE:
        return "3";
      case FOUR:
        return "4";
      case FIVE:
        return "5";
      case SIX:
        return "6";
      case SEVEN:
        return "7";
      case EIGHT:
        return "8";
      case NINE:
        return "9";
      case TEN:
        return "10";
      case JACK:
        return "J";
      case QUEEN:
        return "Q";
      case KING:
        return "K";

      default:
        throw new AssertionError("Unknown Value " + this);
    }
  }

}
