package cs3500.hw04;

import cs3500.hw02.Card;
import cs3500.hw02.FreecellModel;
import cs3500.hw02.FreecellOperations;

/**
 * A class represents FreecellModelCreator,
 * it should be SINGLEMOVE OR MULTIMOVE.
 */
public class FreecellModelCreator {
  /**
   *  Enum should be SINGLEMOVE OR MULTIMOVE.
   */
  public enum GameType {
    SINGLEMOVE, MULTIMOVE;
  }


  /**
   * To distinguish the game Type and return to different FreecellOperations.
   *
   * @param type to represents multi move or single move.
   * @return FreecellModel according to different input.
   */
  public static FreecellOperations<Card> create(GameType type) {
    switch (type) {
      case MULTIMOVE:
        return new MultiFreecellModel();
      case SINGLEMOVE:
        return new FreecellModel();
      default:
        throw new IllegalArgumentException("Invalid GameType.");
    }
  }
}
