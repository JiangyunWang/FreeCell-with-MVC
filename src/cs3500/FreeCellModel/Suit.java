package cs3500.hw02;

/*
 * Represent a suit of one Card, it should be club, diamond, heart, spade.
 */
public enum Suit {
  CLUB,
  DIAMOND,
  HEART,
  SPADE;

  @Override
  public String toString() {
    switch (this) {
      case CLUB:
        return "♣";
      case DIAMOND:
        return "♦";
      case HEART:
        return "♥";
      case SPADE:
        return "♠";
      default:
        throw new AssertionError("Unknown operations " + this);
    }
  }

}
