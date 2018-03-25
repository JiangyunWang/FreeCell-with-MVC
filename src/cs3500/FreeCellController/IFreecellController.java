package cs3500.hw03;

import java.util.List;

import cs3500.hw02.FreecellOperations;

/**
 * This is the interface of the Freecell Controller. It is parameterized over the card type.
 * @param <K> represents a generic type of IFreecellController.
 */
public interface IFreecellController<K> {

  /**
   * This method should start a new game of Freecell using the provided model, number of cascade and
   * open piles and the provided deck. If "shuffle" is set to false, the deck must be used as-is,
   * else the deck should be shuffled. It should throw an IllegalStateException only if the
   * controller has not been initialized properly to receive input and transmit output.
   *
   * @param deck        A deck of Freecell that contains all the cards.
   * @param model       A model that FreecellController need to use.
   * @param numCascades The number of Cascades.
   * @param numOpens    The number of Opens.
   * @param shuffle     A boolean that is it shuffle or not.
   * @throws IllegalArgumentException if any argument is negative.
   * @throws  IllegalStateException if statement is null.
   */
  void playGame(List<K> deck, FreecellOperations<K> model, int numCascades,
                int numOpens, boolean shuffle) ;
}
