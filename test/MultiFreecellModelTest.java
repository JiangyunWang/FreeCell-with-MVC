
import org.junit.Test;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import cs3500.hw02.Card;
import cs3500.hw02.FreecellOperations;
import cs3500.hw02.Suit;
import cs3500.hw02.Value;
import cs3500.hw02.PileType;
import cs3500.hw03.FreecellController;
import cs3500.hw04.FreecellModelCreator;

import static org.junit.Assert.assertEquals;

/**
 * A class is to test MultiFreecellModel.
 */
public class MultiFreecellModelTest {

  Card d1 = new Card(Value.ACE, Suit.DIAMOND);
  Card d2 = new Card(Value.TWO, Suit.DIAMOND);
  Card d3 = new Card(Value.THREE, Suit.DIAMOND);
  Card d4 = new Card(Value.FOUR, Suit.DIAMOND);
  Card d5 = new Card(Value.FIVE, Suit.DIAMOND);
  Card d6 = new Card(Value.SIX, Suit.DIAMOND);
  Card d7 = new Card(Value.SEVEN, Suit.DIAMOND);
  Card d8 = new Card(Value.EIGHT, Suit.DIAMOND);
  Card d9 = new Card(Value.NINE, Suit.DIAMOND);
  Card d10 = new Card(Value.TEN, Suit.DIAMOND);
  Card d11 = new Card(Value.JACK, Suit.DIAMOND);
  Card d12 = new Card(Value.QUEEN, Suit.DIAMOND);
  Card d13 = new Card(Value.KING, Suit.DIAMOND);


  Card h1 = new Card(Value.ACE, Suit.HEART);
  Card h2 = new Card(Value.TWO, Suit.HEART);
  Card h3 = new Card(Value.THREE, Suit.HEART);
  Card h4 = new Card(Value.FOUR, Suit.HEART);
  Card h5 = new Card(Value.FIVE, Suit.HEART);
  Card h6 = new Card(Value.SIX, Suit.HEART);
  Card h7 = new Card(Value.SEVEN, Suit.HEART);
  Card h8 = new Card(Value.EIGHT, Suit.HEART);
  Card h9 = new Card(Value.NINE, Suit.HEART);
  Card h10 = new Card(Value.TEN, Suit.HEART);
  Card h11 = new Card(Value.JACK, Suit.HEART);
  Card h12 = new Card(Value.QUEEN, Suit.HEART);
  Card h13 = new Card(Value.KING, Suit.HEART);

  Card s1 = new Card(Value.ACE, Suit.SPADE);
  Card s2 = new Card(Value.TWO, Suit.SPADE);
  Card s3 = new Card(Value.THREE, Suit.SPADE);
  Card s4 = new Card(Value.FOUR, Suit.SPADE);
  Card s5 = new Card(Value.FIVE, Suit.SPADE);
  Card s6 = new Card(Value.SIX, Suit.SPADE);
  Card s7 = new Card(Value.SEVEN, Suit.SPADE);
  Card s8 = new Card(Value.EIGHT, Suit.SPADE);
  Card s9 = new Card(Value.NINE, Suit.SPADE);
  Card s10 = new Card(Value.TEN, Suit.SPADE);
  Card s11 = new Card(Value.JACK, Suit.SPADE);
  Card s12 = new Card(Value.QUEEN, Suit.SPADE);
  Card s13 = new Card(Value.KING, Suit.SPADE);

  Card c1 = new Card(Value.ACE, Suit.CLUB);
  Card c2 = new Card(Value.TWO, Suit.CLUB);
  Card c3 = new Card(Value.THREE, Suit.CLUB);
  Card c4 = new Card(Value.FOUR, Suit.CLUB);
  Card c5 = new Card(Value.FIVE, Suit.CLUB);
  Card c6 = new Card(Value.SIX, Suit.CLUB);
  Card c7 = new Card(Value.SEVEN, Suit.CLUB);
  Card c8 = new Card(Value.EIGHT, Suit.CLUB);
  Card c9 = new Card(Value.NINE, Suit.CLUB);
  Card c10 = new Card(Value.TEN, Suit.CLUB);
  Card c11 = new Card(Value.JACK, Suit.CLUB);
  Card c12 = new Card(Value.QUEEN, Suit.CLUB);
  Card c13 = new Card(Value.KING, Suit.CLUB);


  FreecellModelCreator creator = new FreecellModelCreator();
  FreecellOperations multi = creator.create(FreecellModelCreator.GameType.MULTIMOVE);
  FreecellOperations single = creator.create(FreecellModelCreator.GameType.SINGLEMOVE);
  List<Card> deckGet = single.getDeck();
  private List<Card> deck = new ArrayList<Card>(Arrays.asList(c1, d1, h1, s1,
          c2, d2, h2, s2,
          c3, d3, h3, s3,
          c4, d4, h4, s4,
          c5, d5, h5, s5,
          c6, d6, h6, s6,
          c7, d7, h7, s7,
          c8, d8, h8, s8,
          c9, d9, h9, s9,
          c10, d10, h10, s10,
          c11, d11, h11, s11,
          c12, d12, h12, s12,
          c13, d13, h13, s13));

  // ------------------ Freecell More ---------------------

  /**
   * test to get deck to check the element in deck.
   */
  @Test
  public void testGetDeck() {
    assertEquals(true, deck.equals(deckGet));
  }

  /**
   * test for get deck using the size.
   */
  @Test
  public void testGetDeck1() {
    assertEquals(true, deckGet.size() == 52);
  }

  /**
   * test for invalid startgame when the deck is invalid.
   */
  @Test
  public void testStartGame1() {
    deckGet.add(s1);
    try {
      single.startGame(deckGet, 4, 4, true);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid deck", e.getMessage());
    }
  }

  /**
   * test for invalid start game and empty state with deck is invalid.
   */
  @Test
  public void testEmptyState() {
    deckGet.add(c1);
    try {
      single.startGame(deckGet, 5, 4, false);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid deck", e.getMessage());
    }
    assertEquals("", single.getGameState());
  }

  /**
   * test for Start game twice.
   */
  @Test
  public void testStart2Time() {
    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠";
    single.startGame(deckGet, 4, 4, false);
    single.startGame(deckGet, 4, 4, false);
    assertEquals(s, single.getGameState());
  }


  /**
   * test for Invalid Start game. less card and have duplicate card.
   */
  @Test
  public void testStartGameInvalid() {
    deck.remove(0);
    deck.add(s2);
    try {
      single.startGame(deck, 4, 4, false);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid deck", e.getMessage());
    }
  }

  /**
   * test for Invalid number of Cascade Pile.
   */
  @Test
  public void testStartGameInvalidAboutNum() {
    try {
      single.startGame(deck, 1, 4, false);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid parameter", e.getMessage());
    }
  }

  /**
   * test for Invalid number of Open Pile.
   */
  @Test
  public void testStartGame3() {
    try {
      single.startGame(deck, 4, 0, false);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid parameter", e.getMessage());
    }
  }

  /**
   * test for shuffle, when it is different from not shuffled.
   */
  @Test
  public void testShuffled() {
    single.startGame(deck, 4, 4, true);
    String shuffled = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠";
    assertEquals(false, single.getGameState().equals(shuffled));
  }

  /**
   * test for shuffle, when it is same as not shuffled.
   */
  @Test
  public void testNotShuffled() {
    single.startGame(deck, 4, 4, false);
    String shufflNot = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠";
    assertEquals(true, single.getGameState().equals(shufflNot));
  }


  /**
   * test for gameState.
   */
  @Test
  public void testGameState2() {
    single.startGame(deck, 4, 4, false);
    String shufflNot = "F1: A♣\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠";
    assertEquals(false, single.getGameState().equals(shufflNot));
  }

  /**
   * test for invalid movement form cascade to foundation.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveInvalidCTF1() {
    single.startGame(deck, 26, 4, false);
    single.move(PileType.CASCADE, 2, 0, PileType.FOUNDATION, 0);
    single.move(PileType.CASCADE, 1, 0, PileType.FOUNDATION, 0);
  }

  /**
   * test for not game over.
   */
  @Test
  public void testGameOverNot() {
    single.startGame(deck, 5, 2, true);
    assertEquals(false, single.isGameOver());
  }

  /**
   * test for is game over.
   */
  @Test
  public void isGameOver() {
    Collections.reverse(deck);
    single.startGame(deck, 4, 4, false);

    for (int i = 0; i < 4; i++) {
      for (int j = 12; j > -1; j--) {
        single.move(PileType.CASCADE, i, j, PileType.FOUNDATION, i);
      }
    }
    assertEquals(true, single.isGameOver());
  }


  //----------------------- Cascade to Open ----------------------

  /**
   * Test for invalid moving two cards in from cascade to opens.
   */
  @Test
  public void testTwoInvalidMoveOpen() {
    List<Card> deck1 = new ArrayList<Card>(Arrays.asList(c1, d1, h1, s1,
            c2, d2, h2, s2,
            c3, d3, h3, s3,
            c4, d4, h4, s4,
            c5, d5, h5, s5,
            c6, d6, h6, s6,
            c7, d7, h7, s7,
            c8, d8, h8, s13,
            s12, c9, h9, s9,
            h11, d10, h10, s10,
            c10, c11, d11, s11,
            d9, c12, d12, h12,
            s8, c13, h13, d13));
    Readable re = new StringReader("C1 12 O1");
    Appendable ap = new StringBuffer("");
    FreecellController controller = new FreecellController(re, ap);
    controller.playGame(deck1, multi, 4, 4, false);
    assertEquals("F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, Q♠, J♥, 10♣, 9♦, 8♠\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♣, 10♦, J♣, Q♣, K♣\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♦, Q♦, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, K♠, 9♠, 10♠, J♠, Q♥, K♦\n" +
            "Invalid move. Try again.Invalid cardIndex from Cascade Pile", ap.toString());
  }

  /**
   * Test for invalid moving cards in from empty cascade to opens.
   */
  @Test
  public void testInvalidMoveFromEmp() {
    List<Card> deck1 = new ArrayList<Card>(Arrays.asList(c1, d1, h1, s1,
            c2, d2, h2, s2,
            c3, d3, h3, s3,
            c4, d4, h4, s4,
            c5, d5, h5, s5,
            c6, d6, h6, s6,
            c7, d7, h7, s7,
            c8, d8, h8, s13,
            s12, c9, h9, s9,
            h11, d10, h10, s10,
            c10, c11, d11, s11,
            d9, c12, d12, h12,
            s8, c13, h13, d13));
    Readable re = new StringReader("C12 4 O4 C12 3 O1 C12 2 O2 C12 1 O3 C12 1 O5");
    Appendable ap = new StringBuffer("");
    FreecellController controller = new FreecellController(re, ap);
    controller.playGame(deck1, multi, 12, 5, false);
    assertEquals("F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "O5:\n" +
            "C1: A♣, 4♣, 7♣, J♥, 8♠\n" +
            "C2: A♦, 4♦, 7♦, 10♦, K♣\n" +
            "C3: A♥, 4♥, 7♥, 10♥, K♥\n" +
            "C4: A♠, 4♠, 7♠, 10♠, K♦\n" +
            "C5: 2♣, 5♣, 8♣, 10♣\n" +
            "C6: 2♦, 5♦, 8♦, J♣\n" +
            "C7: 2♥, 5♥, 8♥, J♦\n" +
            "C8: 2♠, 5♠, K♠, J♠\n" +
            "C9: 3♣, 6♣, Q♠, 9♦\n" +
            "C10: 3♦, 6♦, 9♣, Q♣\n" +
            "C11: 3♥, 6♥, 9♥, Q♦\n" +
            "C12: 3♠, 6♠, 9♠, Q♥\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4: Q♥\n" +
            "O5:\n" +
            "C1: A♣, 4♣, 7♣, J♥, 8♠\n" +
            "C2: A♦, 4♦, 7♦, 10♦, K♣\n" +
            "C3: A♥, 4♥, 7♥, 10♥, K♥\n" +
            "C4: A♠, 4♠, 7♠, 10♠, K♦\n" +
            "C5: 2♣, 5♣, 8♣, 10♣\n" +
            "C6: 2♦, 5♦, 8♦, J♣\n" +
            "C7: 2♥, 5♥, 8♥, J♦\n" +
            "C8: 2♠, 5♠, K♠, J♠\n" +
            "C9: 3♣, 6♣, Q♠, 9♦\n" +
            "C10: 3♦, 6♦, 9♣, Q♣\n" +
            "C11: 3♥, 6♥, 9♥, Q♦\n" +
            "C12: 3♠, 6♠, 9♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: 9♠\n" +
            "O2:\n" +
            "O3:\n" +
            "O4: Q♥\n" +
            "O5:\n" +
            "C1: A♣, 4♣, 7♣, J♥, 8♠\n" +
            "C2: A♦, 4♦, 7♦, 10♦, K♣\n" +
            "C3: A♥, 4♥, 7♥, 10♥, K♥\n" +
            "C4: A♠, 4♠, 7♠, 10♠, K♦\n" +
            "C5: 2♣, 5♣, 8♣, 10♣\n" +
            "C6: 2♦, 5♦, 8♦, J♣\n" +
            "C7: 2♥, 5♥, 8♥, J♦\n" +
            "C8: 2♠, 5♠, K♠, J♠\n" +
            "C9: 3♣, 6♣, Q♠, 9♦\n" +
            "C10: 3♦, 6♦, 9♣, Q♣\n" +
            "C11: 3♥, 6♥, 9♥, Q♦\n" +
            "C12: 3♠, 6♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: 9♠\n" +
            "O2: 6♠\n" +
            "O3:\n" +
            "O4: Q♥\n" +
            "O5:\n" +
            "C1: A♣, 4♣, 7♣, J♥, 8♠\n" +
            "C2: A♦, 4♦, 7♦, 10♦, K♣\n" +
            "C3: A♥, 4♥, 7♥, 10♥, K♥\n" +
            "C4: A♠, 4♠, 7♠, 10♠, K♦\n" +
            "C5: 2♣, 5♣, 8♣, 10♣\n" +
            "C6: 2♦, 5♦, 8♦, J♣\n" +
            "C7: 2♥, 5♥, 8♥, J♦\n" +
            "C8: 2♠, 5♠, K♠, J♠\n" +
            "C9: 3♣, 6♣, Q♠, 9♦\n" +
            "C10: 3♦, 6♦, 9♣, Q♣\n" +
            "C11: 3♥, 6♥, 9♥, Q♦\n" +
            "C12: 3♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: 9♠\n" +
            "O2: 6♠\n" +
            "O3: 3♠\n" +
            "O4: Q♥\n" +
            "O5:\n" +
            "C1: A♣, 4♣, 7♣, J♥, 8♠\n" +
            "C2: A♦, 4♦, 7♦, 10♦, K♣\n" +
            "C3: A♥, 4♥, 7♥, 10♥, K♥\n" +
            "C4: A♠, 4♠, 7♠, 10♠, K♦\n" +
            "C5: 2♣, 5♣, 8♣, 10♣\n" +
            "C6: 2♦, 5♦, 8♦, J♣\n" +
            "C7: 2♥, 5♥, 8♥, J♦\n" +
            "C8: 2♠, 5♠, K♠, J♠\n" +
            "C9: 3♣, 6♣, Q♠, 9♦\n" +
            "C10: 3♦, 6♦, 9♣, Q♣\n" +
            "C11: 3♥, 6♥, 9♥, Q♦\n" +
            "C12:\n" +
            "Invalid move. Try again.Invalid movement from Cascade Pile.", ap.toString());
  }

  /**
   * Test for moving one card to open.
   */
  @Test
  public void testOneMoveOpen() {
    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n" +
            "C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n" +
            "C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n" +
            "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: A♠\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠\n" +
            "C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n" +
            "C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n" +
            "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣";
    Readable re = new StringReader("C1 13 O1");
    Appendable ap = new StringBuffer("");
    FreecellController controller = new FreecellController(re, ap);
    Collections.reverse(deck);
    controller.playGame(deck, multi, 4, 4, false);
    assertEquals(s, ap.toString());
  }

  //----------------------- Casecade to Foundation ----------------------

  /**
   * Test for invalid moving cards in from empty cascade to FOUNDATION.
   */
  @Test
  public void testInvalidMoveFromEmp2() {
    List<Card> deck1 = new ArrayList<Card>(Arrays.asList(c1, d1, h1, s1,
            c2, d2, h2, s2,
            c3, d3, h3, s3,
            c4, d4, h4, s4,
            c5, d5, h5, s5,
            c6, d6, h6, s6,
            c7, d7, h7, s7,
            c8, d8, h8, s13,
            s12, c9, h9, s9,
            h11, d10, h10, s10,
            c10, c11, d11, s11,
            d9, c12, d12, h12,
            s8, c13, h13, d13));
    Readable re = new StringReader("C12 4 O4 C12 3 O1 C12 2 O2 C12 1 O3 C12 1 F1");
    Appendable ap = new StringBuffer("");
    FreecellController controller = new FreecellController(re, ap);
    controller.playGame(deck1, multi, 12, 5, false);
    assertEquals("F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "O5:\n" +
            "C1: A♣, 4♣, 7♣, J♥, 8♠\n" +
            "C2: A♦, 4♦, 7♦, 10♦, K♣\n" +
            "C3: A♥, 4♥, 7♥, 10♥, K♥\n" +
            "C4: A♠, 4♠, 7♠, 10♠, K♦\n" +
            "C5: 2♣, 5♣, 8♣, 10♣\n" +
            "C6: 2♦, 5♦, 8♦, J♣\n" +
            "C7: 2♥, 5♥, 8♥, J♦\n" +
            "C8: 2♠, 5♠, K♠, J♠\n" +
            "C9: 3♣, 6♣, Q♠, 9♦\n" +
            "C10: 3♦, 6♦, 9♣, Q♣\n" +
            "C11: 3♥, 6♥, 9♥, Q♦\n" +
            "C12: 3♠, 6♠, 9♠, Q♥\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4: Q♥\n" +
            "O5:\n" +
            "C1: A♣, 4♣, 7♣, J♥, 8♠\n" +
            "C2: A♦, 4♦, 7♦, 10♦, K♣\n" +
            "C3: A♥, 4♥, 7♥, 10♥, K♥\n" +
            "C4: A♠, 4♠, 7♠, 10♠, K♦\n" +
            "C5: 2♣, 5♣, 8♣, 10♣\n" +
            "C6: 2♦, 5♦, 8♦, J♣\n" +
            "C7: 2♥, 5♥, 8♥, J♦\n" +
            "C8: 2♠, 5♠, K♠, J♠\n" +
            "C9: 3♣, 6♣, Q♠, 9♦\n" +
            "C10: 3♦, 6♦, 9♣, Q♣\n" +
            "C11: 3♥, 6♥, 9♥, Q♦\n" +
            "C12: 3♠, 6♠, 9♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: 9♠\n" +
            "O2:\n" +
            "O3:\n" +
            "O4: Q♥\n" +
            "O5:\n" +
            "C1: A♣, 4♣, 7♣, J♥, 8♠\n" +
            "C2: A♦, 4♦, 7♦, 10♦, K♣\n" +
            "C3: A♥, 4♥, 7♥, 10♥, K♥\n" +
            "C4: A♠, 4♠, 7♠, 10♠, K♦\n" +
            "C5: 2♣, 5♣, 8♣, 10♣\n" +
            "C6: 2♦, 5♦, 8♦, J♣\n" +
            "C7: 2♥, 5♥, 8♥, J♦\n" +
            "C8: 2♠, 5♠, K♠, J♠\n" +
            "C9: 3♣, 6♣, Q♠, 9♦\n" +
            "C10: 3♦, 6♦, 9♣, Q♣\n" +
            "C11: 3♥, 6♥, 9♥, Q♦\n" +
            "C12: 3♠, 6♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: 9♠\n" +
            "O2: 6♠\n" +
            "O3:\n" +
            "O4: Q♥\n" +
            "O5:\n" +
            "C1: A♣, 4♣, 7♣, J♥, 8♠\n" +
            "C2: A♦, 4♦, 7♦, 10♦, K♣\n" +
            "C3: A♥, 4♥, 7♥, 10♥, K♥\n" +
            "C4: A♠, 4♠, 7♠, 10♠, K♦\n" +
            "C5: 2♣, 5♣, 8♣, 10♣\n" +
            "C6: 2♦, 5♦, 8♦, J♣\n" +
            "C7: 2♥, 5♥, 8♥, J♦\n" +
            "C8: 2♠, 5♠, K♠, J♠\n" +
            "C9: 3♣, 6♣, Q♠, 9♦\n" +
            "C10: 3♦, 6♦, 9♣, Q♣\n" +
            "C11: 3♥, 6♥, 9♥, Q♦\n" +
            "C12: 3♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: 9♠\n" +
            "O2: 6♠\n" +
            "O3: 3♠\n" +
            "O4: Q♥\n" +
            "O5:\n" +
            "C1: A♣, 4♣, 7♣, J♥, 8♠\n" +
            "C2: A♦, 4♦, 7♦, 10♦, K♣\n" +
            "C3: A♥, 4♥, 7♥, 10♥, K♥\n" +
            "C4: A♠, 4♠, 7♠, 10♠, K♦\n" +
            "C5: 2♣, 5♣, 8♣, 10♣\n" +
            "C6: 2♦, 5♦, 8♦, J♣\n" +
            "C7: 2♥, 5♥, 8♥, J♦\n" +
            "C8: 2♠, 5♠, K♠, J♠\n" +
            "C9: 3♣, 6♣, Q♠, 9♦\n" +
            "C10: 3♦, 6♦, 9♣, Q♣\n" +
            "C11: 3♥, 6♥, 9♥, Q♦\n" +
            "C12:\n" +
            "Invalid move. Try again.Invalid movement from Cascade Pile.", ap.toString());
  }

  /**
   * Test for moving one card in Multi-FreeCell Model to Foundation.
   */
  @Test
  public void testOneMoveFoundation() {
    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n" +
            "C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n" +
            "C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n" +
            "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n" +
            "F1: A♠\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠\n" +
            "C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n" +
            "C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n" +
            "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣";
    Readable re = new StringReader("C1 13 F1");
    Appendable ap = new StringBuffer("");
    FreecellController controller = new FreecellController(re, ap);
    Collections.reverse(deck);
    controller.playGame(deck, multi, 4, 4, false);
    assertEquals(s, ap.toString());
  }

  /**
   * Test for Invalid moving because of invalid value to foundation.
   */
  @Test
  public void testOneInvalidMoveFoundation() {
    List<Card> deck1 = new ArrayList<Card>(Arrays.asList(c1, d1, h1, s1,
            c2, d2, h2, s2,
            c3, d3, h3, s3,
            c4, d4, h4, s4,
            c5, d5, h5, s5,
            c6, d6, h6, s6,
            c7, d7, h7, s7,
            c8, d8, h8, d13,
            s12, c9, h9, s9,
            h11, d10, h10, s10,
            c10, c11, d11, s11,
            d9, c12, d12, h12,
            s8, c13, h13, s13));

    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, Q♠, J♥, 10♣, 9♦, 8♠\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♣, 10♦, J♣, Q♣, K♣\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♦, Q♦, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, K♦, 9♠, 10♠, J♠, Q♥, K♠\n" +
            "Invalid move. Try again.Invalid top value to Foundation Pile";
    Readable re = new StringReader("C1 13 F3");
    Appendable ap = new StringBuffer("");
    FreecellController controller = new FreecellController(re, ap);
    controller.playGame(deck1, multi, 4, 1, false);
    assertEquals(s, ap.toString());
  }

  /**
   * Test for invalid moving one cards in from cascade to foundation.
   */
  @Test
  public void testTwoInvalidMoveFoundation() {
    List<Card> deck1 = new ArrayList<Card>(Arrays.asList(c1, d1, h1, s1,
            c2, d2, h2, s2,
            c3, d3, h3, s3,
            c4, d4, h4, s4,
            c5, d5, h5, s5,
            c6, d6, h6, s6,
            c7, d7, h7, s7,
            c8, d8, h8, s13,
            s12, c9, h9, s9,
            h11, d10, h10, s10,
            c10, c11, d11, s11,
            d9, c12, d12, h12,
            s8, c13, h13, d13));
    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, Q♠, J♥, 10♣, 9♦, 8♠\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♣, 10♦, J♣, Q♣, K♣\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♦, Q♦, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, K♠, 9♠, 10♠, J♠, Q♥, K♦\n" +
            "Invalid move. Try again.Invalid cardIndex from Cascade Pile";
    Readable re = new StringReader("C1 12 F1");
    Appendable ap = new StringBuffer("");
    FreecellController controller = new FreecellController(re, ap);
    controller.playGame(deck1, multi, 4, 4, false);
    assertEquals(s, ap.toString());
  }

  //----------------------- Cascade to Cascade ----------------------

  /**
   * Test for invalid moving cards in from empty cascade to Cascade.
   */
  @Test
  public void testInvalidMoveFromEmp3() {
    List<Card> deck1 = new ArrayList<Card>(Arrays.asList(c1, d1, h1, s1,
            c2, d2, h2, s2,
            c3, d3, h3, s3,
            c4, d4, h4, s4,
            c5, d5, h5, s5,
            c6, d6, h6, s6,
            c7, d7, h7, s7,
            c8, d8, h8, s13,
            s12, c9, h9, s9,
            h11, d10, h10, s10,
            c10, c11, d11, s11,
            d9, c12, d12, h12,
            s8, c13, h13, d13));
    Readable re = new StringReader("C12 4 O4 C12 3 O1 C12 2 O2 C12 1 O3 C12 1 C1");
    Appendable ap = new StringBuffer("");
    FreecellController controller = new FreecellController(re, ap);
    controller.playGame(deck1, multi, 12, 5, false);
    assertEquals("F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "O5:\n" +
            "C1: A♣, 4♣, 7♣, J♥, 8♠\n" +
            "C2: A♦, 4♦, 7♦, 10♦, K♣\n" +
            "C3: A♥, 4♥, 7♥, 10♥, K♥\n" +
            "C4: A♠, 4♠, 7♠, 10♠, K♦\n" +
            "C5: 2♣, 5♣, 8♣, 10♣\n" +
            "C6: 2♦, 5♦, 8♦, J♣\n" +
            "C7: 2♥, 5♥, 8♥, J♦\n" +
            "C8: 2♠, 5♠, K♠, J♠\n" +
            "C9: 3♣, 6♣, Q♠, 9♦\n" +
            "C10: 3♦, 6♦, 9♣, Q♣\n" +
            "C11: 3♥, 6♥, 9♥, Q♦\n" +
            "C12: 3♠, 6♠, 9♠, Q♥\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4: Q♥\n" +
            "O5:\n" +
            "C1: A♣, 4♣, 7♣, J♥, 8♠\n" +
            "C2: A♦, 4♦, 7♦, 10♦, K♣\n" +
            "C3: A♥, 4♥, 7♥, 10♥, K♥\n" +
            "C4: A♠, 4♠, 7♠, 10♠, K♦\n" +
            "C5: 2♣, 5♣, 8♣, 10♣\n" +
            "C6: 2♦, 5♦, 8♦, J♣\n" +
            "C7: 2♥, 5♥, 8♥, J♦\n" +
            "C8: 2♠, 5♠, K♠, J♠\n" +
            "C9: 3♣, 6♣, Q♠, 9♦\n" +
            "C10: 3♦, 6♦, 9♣, Q♣\n" +
            "C11: 3♥, 6♥, 9♥, Q♦\n" +
            "C12: 3♠, 6♠, 9♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: 9♠\n" +
            "O2:\n" +
            "O3:\n" +
            "O4: Q♥\n" +
            "O5:\n" +
            "C1: A♣, 4♣, 7♣, J♥, 8♠\n" +
            "C2: A♦, 4♦, 7♦, 10♦, K♣\n" +
            "C3: A♥, 4♥, 7♥, 10♥, K♥\n" +
            "C4: A♠, 4♠, 7♠, 10♠, K♦\n" +
            "C5: 2♣, 5♣, 8♣, 10♣\n" +
            "C6: 2♦, 5♦, 8♦, J♣\n" +
            "C7: 2♥, 5♥, 8♥, J♦\n" +
            "C8: 2♠, 5♠, K♠, J♠\n" +
            "C9: 3♣, 6♣, Q♠, 9♦\n" +
            "C10: 3♦, 6♦, 9♣, Q♣\n" +
            "C11: 3♥, 6♥, 9♥, Q♦\n" +
            "C12: 3♠, 6♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: 9♠\n" +
            "O2: 6♠\n" +
            "O3:\n" +
            "O4: Q♥\n" +
            "O5:\n" +
            "C1: A♣, 4♣, 7♣, J♥, 8♠\n" +
            "C2: A♦, 4♦, 7♦, 10♦, K♣\n" +
            "C3: A♥, 4♥, 7♥, 10♥, K♥\n" +
            "C4: A♠, 4♠, 7♠, 10♠, K♦\n" +
            "C5: 2♣, 5♣, 8♣, 10♣\n" +
            "C6: 2♦, 5♦, 8♦, J♣\n" +
            "C7: 2♥, 5♥, 8♥, J♦\n" +
            "C8: 2♠, 5♠, K♠, J♠\n" +
            "C9: 3♣, 6♣, Q♠, 9♦\n" +
            "C10: 3♦, 6♦, 9♣, Q♣\n" +
            "C11: 3♥, 6♥, 9♥, Q♦\n" +
            "C12: 3♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: 9♠\n" +
            "O2: 6♠\n" +
            "O3: 3♠\n" +
            "O4: Q♥\n" +
            "O5:\n" +
            "C1: A♣, 4♣, 7♣, J♥, 8♠\n" +
            "C2: A♦, 4♦, 7♦, 10♦, K♣\n" +
            "C3: A♥, 4♥, 7♥, 10♥, K♥\n" +
            "C4: A♠, 4♠, 7♠, 10♠, K♦\n" +
            "C5: 2♣, 5♣, 8♣, 10♣\n" +
            "C6: 2♦, 5♦, 8♦, J♣\n" +
            "C7: 2♥, 5♥, 8♥, J♦\n" +
            "C8: 2♠, 5♠, K♠, J♠\n" +
            "C9: 3♣, 6♣, Q♠, 9♦\n" +
            "C10: 3♦, 6♦, 9♣, Q♣\n" +
            "C11: 3♥, 6♥, 9♥, Q♦\n" +
            "C12:\n" +
            "Invalid move. Try again.Invalid Input.", ap.toString());
  }

  /**
   * Test for invalid moving five cards in from cascade to Cascade.
   */
  @Test
  public void testTFiveInvalidSequenceMoveCas() {
    List<Card> deck1 = new ArrayList<Card>(Arrays.asList(c1, d1, h1, s1,
            c2, d2, h2, s2,
            c3, d3, h3, s3,
            c4, d4, h4, s4,
            c5, d5, h5, s5,
            c6, d6, h6, s6,
            c7, d7, h7, s7,
            c8, d8, h8, s13,
            s12, c9, h9, s9,
            h11, d10, h10, s10,
            c10, c11, d11, s11,
            d9, c12, d12, h12,
            c13, h13, d13, s8));
    Readable re = new StringReader("C1 9 C2");
    Appendable ap = new StringBuffer("");
    FreecellController controller = new FreecellController(re, ap);
    controller.playGame(deck1, multi, 4, 4, false);
    assertEquals("F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, Q♠, J♥, 10♣, 9♦, K♣\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♣, 10♦, J♣, Q♣, K♥\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♦, Q♦, K♦\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, K♠, 9♠, 10♠, J♠, Q♥, 8♠\n" +
            "Invalid move. Try again.Invalid Sequence.", ap.toString());
  }

  /**
   * Test for invalid CardIndex moving five cards in from cascade to Cascade.
   */
  @Test
  public void testInvalidFiveInvalidSequenceMoveCas() {
    List<Card> deck1 = new ArrayList<Card>(Arrays.asList(c1, d1, h1, s1,
            c2, d2, h2, s2,
            c3, d3, h3, s3,
            c4, d4, h4, s4,
            c5, d5, h5, s5,
            c6, d6, h6, s6,
            c7, d7, h7, s7,
            c8, d8, h8, s13,
            s12, c9, h9, s9,
            h11, d10, h10, s10,
            c10, c11, d11, s11,
            d9, c12, d12, h12,
            c13, h13, d13, s8));
    Readable re = new StringReader("C1 0 C2");
    Appendable ap = new StringBuffer("");
    FreecellController controller = new FreecellController(re, ap);
    controller.playGame(deck1, multi, 4, 4, false);
    assertEquals("F1:\n" +
                    "F2:\n" +
                    "F3:\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, Q♠, J♥, 10♣, 9♦, K♣\n" +
                    "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♣, 10♦, J♣, Q♣, K♥\n" +
                    "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♦, Q♦, K♦\n" +
                    "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, K♠, 9♠, 10♠, J♠, Q♥, 8♠"
            , ap.toString());
  }

  /**
   * Test for moving one card to cascade.
   */
  @Test
  public void testOneMoveCas() {
    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, K♦, Q♠, Q♥\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♣, Q♣, K♣\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♦, Q♦, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, J♥, K♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, K♦, Q♠\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♣, Q♣, K♣\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♦, Q♦, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, J♥, K♠, Q♥";

    List<Card> deck1 = new ArrayList<Card>(Arrays.asList(c1, d1, h1, s1,
            c2, d2, h2, s2,
            c3, d3, h3, s3,
            c4, d4, h4, s4,
            c5, d5, h5, s5,
            c6, d6, h6, s6,
            c7, d7, h7, s7,
            c8, d8, h8, s8,
            c9, d9, h9, s9,
            c10, d10, h10, s10,
            d13, c11, d11, s11,
            s12, c12, d12, h11,
            h12, c13, h13, s13));
    Readable re = new StringReader("C1 13 C4");
    Appendable ap = new StringBuffer("");
    FreecellController controller = new FreecellController(re, ap);
    controller.playGame(deck1, multi, 4, 4, false);
    assertEquals(s, ap.toString());
  }


  /**
   * Test for moving one card in the middle no sequence.
   */
  @Test
  public void testOneMoveCasNoSequence() {
    List<Card> deck1 = new ArrayList<Card>(Arrays.asList(c1, d1, h1, s1,
            c2, d2, h2, s2,
            c3, d3, h3, s3,
            c4, d4, h4, s4,
            c5, d5, h5, s5,
            c6, d6, h6, s6,
            c7, d7, h7, s7,
            c8, d8, h8, s8,
            c9, d9, h9, s9,
            c10, d10, h10, s10,
            d13, c11, d11, s11,
            s12, c12, d12, h11,
            h12, c13, h13, s13));
    Readable re = new StringReader("C1 12 C4");
    Appendable ap = new StringBuffer("");
    FreecellController controller = new FreecellController(re, ap);
    controller.playGame(deck1, multi, 4, 4, false);
    assertEquals("F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, K♦, Q♠, Q♥\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♣, Q♣, K♣\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♦, Q♦, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, J♥, K♠\n" +
            "Invalid move. Try again.Invalid move.", ap.toString());
  }


  /**
   * Test for moving two cards in Multi-FreeCell Model.
   */
  @Test
  public void testTwoMoveMultimove() {
    List<Card> deck1 = new ArrayList<Card>(Arrays.asList(c1, d1, h1, s1,
            c2, d2, h2, s2,
            c3, d3, h3, s3,
            c4, d4, h4, s4,
            c5, d5, h5, s5,
            c6, d6, h6, s6,
            c7, d7, h7, s7,
            c8, d8, h8, s8,
            c9, d9, h9, s9,
            c10, d10, h10, s10,
            d13, c11, d11, s11,
            s12, c12, d12, h12,
            h11, c13, h13, s13));

    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, K♦, Q♠, J♥\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♣, Q♣, K♣\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♦, Q♦, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♥, K♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, K♦\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♣, Q♣, K♣\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♦, Q♦, K♥, Q♠, J♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♥, K♠";
    Readable re = new StringReader("C1 12 C3");
    Appendable ap = new StringBuffer("");
    FreecellController controller = new FreecellController(re, ap);
    controller.playGame(deck1, multi, 4, 4, false);
    assertEquals(s, ap.toString());
  }


  /**
   * Test for moving Four cards in Multi-FreeCell Model.
   */
  @Test
  public void testFourMoveMultimove() {
    List<Card> deck1 = new ArrayList<Card>(Arrays.asList(c1, d1, h1, s1,
            c2, d2, h2, s2,
            c3, d3, h3, s3,
            c4, d4, h4, s4,
            c5, d5, h5, s5,
            c6, d6, h6, s6,
            c7, d7, h7, s7,
            c8, d8, h8, d13,
            s12, c9, h9, s9,
            h11, d10, h10, s10,
            c10, c11, d11, s11,
            d9, c12, d12, h12,
            s8, c13, h13, s13));

    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, Q♠, J♥, 10♣, 9♦, 8♠\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♣, 10♦, J♣, Q♣, K♣\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♦, Q♦, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, K♦, 9♠, 10♠, J♠, Q♥, K♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♣, 10♦, J♣, Q♣, K♣\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♦, Q♦, K♥, Q♠, J♥, 10♣, 9♦, 8♠\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, K♦, 9♠, 10♠, J♠, Q♥, K♠";
    Readable re = new StringReader("C1 9 C3");
    Appendable ap = new StringBuffer("");
    FreecellController controller = new FreecellController(re, ap);
    controller.playGame(deck1, multi, 4, 4, false);
    assertEquals(s, ap.toString());
  }

  /**
   * Test for moving Four cards in Multi-FreeCell Model twice.
   */
  @Test
  public void testFourMoveMoveTwice() {
    List<Card> deck1 = new ArrayList<Card>(Arrays.asList(c1, d1, h1, s1,
            c2, d2, h2, s2,
            c3, d3, h3, s3,
            c4, d4, h4, s4,
            c5, d5, h5, s5,
            c6, d6, h6, s6,
            c7, d7, h7, s7,
            c8, d8, h8, s13,
            s12, c9, h9, s9,
            h11, d10, h10, s10,
            c10, c11, d11, s11,
            d9, c12, d12, h12,
            s8, c13, h13, d13));

    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, Q♠, J♥, 10♣, 9♦, 8♠\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♣, 10♦, J♣, Q♣, K♣\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♦, Q♦, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, K♠, 9♠, 10♠, J♠, Q♥, K♦\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♣, 10♦, J♣, Q♣, K♣\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♦, Q♦, K♥, Q♠, J♥, 10♣, 9♦, 8♠\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, K♠, 9♠, 10♠, J♠, Q♥, K♦\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♣, 10♦, J♣, Q♣, K♣\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♦, Q♦, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, K♠, 9♠, 10♠, J♠, Q♥, K♦, Q♠, J♥, 10♣, 9♦, 8♠";
    Readable re = new StringReader("C1 9 C3 C3 14 C4");
    Appendable ap = new StringBuffer("");
    FreecellController controller = new FreecellController(re, ap);
    controller.playGame(deck1, multi, 4, 4, false);
    assertEquals(s, ap.toString());
  }


  /**
   * Test for Invalid suit about moving Five cards because of invalid card with destination.
   */
  @Test
  public void testInvalidFourMove() {
    List<Card> deck1 = new ArrayList<Card>(Arrays.asList(c1, d1, h1, s1,
            c2, d2, h2, s2,
            c3, d3, h3, s3,
            c4, d4, h4, s4,
            c5, d5, h5, s5,
            c6, d6, h6, s6,
            c7, d7, h7, s7,
            c8, d8, h8, d13,
            s12, c9, h9, s9,
            h11, d10, h10, s10,
            c10, c11, d11, s11,
            d9, c12, d12, h12,
            s8, c13, h13, s13));

    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, Q♠, J♥, 10♣, 9♦, 8♠\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♣, 10♦, J♣, Q♣, K♣\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♦, Q♦, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, K♦, 9♠, 10♠, J♠, Q♥, K♠\n" +
            "Invalid move. Try again.Invalid move.";
    Readable re = new StringReader("C1 9 C4");
    Appendable ap = new StringBuffer("");
    FreecellController controller = new FreecellController(re, ap);
    controller.playGame(deck1, multi, 4, 4, false);
    assertEquals(s, ap.toString());
  }

  /**
   * Test for invalid move because of invalid destination.
   */
  @Test
  public void testInvalidValueMove() {
    List<Card> deck1 = new ArrayList<Card>(Arrays.asList(c1, d1, h1, s1,
            c2, d2, h2, s2,
            c3, d3, h3, s3,
            c4, d4, h4, s4,
            c5, d5, h5, s5,
            c6, d6, h6, s6,
            c7, d7, h7, s7,
            c8, d8, h8, d13,
            s12, c9, h9, s9,
            h11, d10, h10, s10,
            c10, c11, d11, s11,
            d9, c12, d12, h12,
            s8, c13, h13, s13));

    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, Q♠, J♥, 10♣, 9♦, 8♠\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♣, 10♦, J♣, Q♣, K♣\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♦, Q♦, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, K♦, 9♠, 10♠, J♠, Q♥, K♠\n" +
            "Invalid move. Try again.Invalid Sequence.";
    Readable re = new StringReader("C4 12 C4");
    Appendable ap = new StringBuffer("");
    FreecellController controller = new FreecellController(re, ap);
    controller.playGame(deck1, multi, 4, 4, false);
    assertEquals(s, ap.toString());
  }

  // ---------------- Opens to Cascade ----------------

  /**
   * Test for moving one card from Opens to Cascade.
   */
  @Test
  public void testOneMoveOTCas() {
    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, K♦, Q♠, Q♥\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♣, Q♣, K♣\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♦, Q♦, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, J♥, K♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4: Q♥\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, K♦, Q♠\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♣, Q♣, K♣\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♦, Q♦, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, J♥, K♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, K♦, Q♠\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♣, Q♣, K♣\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♦, Q♦, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, J♥, K♠, Q♥";

    List<Card> deck1 = new ArrayList<Card>(Arrays.asList(c1, d1, h1, s1,
            c2, d2, h2, s2,
            c3, d3, h3, s3,
            c4, d4, h4, s4,
            c5, d5, h5, s5,
            c6, d6, h6, s6,
            c7, d7, h7, s7,
            c8, d8, h8, s8,
            c9, d9, h9, s9,
            c10, d10, h10, s10,
            d13, c11, d11, s11,
            s12, c12, d12, h11,
            h12, c13, h13, s13));
    Readable re = new StringReader("C1 13 O4 O4 1 C4");
    Appendable ap = new StringBuffer("");
    FreecellController controller = new FreecellController(re, ap);
    controller.playGame(deck1, multi, 4, 4, false);
    assertEquals(s, ap.toString());
  }

  /**
   * Test for invalid moving one card from Opens to Cascade.
   */
  @Test
  public void testInvalidOneMoveOTCas() {
    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, K♦, Q♠, Q♥\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♣, Q♣, K♣\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♦, Q♦, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, J♥, K♠\n" +
            "Invalid move. Try again.Invalid movement from Open Pile.";

    List<Card> deck1 = new ArrayList<Card>(Arrays.asList(c1, d1, h1, s1,
            c2, d2, h2, s2,
            c3, d3, h3, s3,
            c4, d4, h4, s4,
            c5, d5, h5, s5,
            c6, d6, h6, s6,
            c7, d7, h7, s7,
            c8, d8, h8, s8,
            c9, d9, h9, s9,
            c10, d10, h10, s10,
            d13, c11, d11, s11,
            s12, c12, d12, h11,
            h12, c13, h13, s13));
    Readable re = new StringReader("O4 1 C4");
    Appendable ap = new StringBuffer("");
    FreecellController controller = new FreecellController(re, ap);
    controller.playGame(deck1, multi, 4, 4, false);
    assertEquals(s, ap.toString());
  }

  /**
   * Test for invalid moving one card from Opens to Cascade.
   */
  @Test
  public void testInvalidOneMoveOTCas2() {
    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, K♦, Q♠, Q♥\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♣, Q♣, K♣\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♦, Q♦, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, J♥, K♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4: Q♥\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, K♦, Q♠\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♣, Q♣, K♣\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♦, Q♦, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, J♥, K♠\n" +
            "Invalid move. Try again.Invalid suit between last card and added card";

    List<Card> deck1 = new ArrayList<Card>(Arrays.asList(c1, d1, h1, s1,
            c2, d2, h2, s2,
            c3, d3, h3, s3,
            c4, d4, h4, s4,
            c5, d5, h5, s5,
            c6, d6, h6, s6,
            c7, d7, h7, s7,
            c8, d8, h8, s8,
            c9, d9, h9, s9,
            c10, d10, h10, s10,
            d13, c11, d11, s11,
            s12, c12, d12, h11,
            h12, c13, h13, s13));
    Readable re = new StringReader("C1 13 O4 O4 1 C3");
    Appendable ap = new StringBuffer("");
    FreecellController controller = new FreecellController(re, ap);
    controller.playGame(deck1, multi, 4, 4, false);
    assertEquals(s, ap.toString());
  }

  //-------------- Foundation to Cascade -----------------

  /**
   * Test for moving one card from Foundation to Cascade.
   */
  @Test
  public void testOneMoveFTCas() {
    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n" +
            "C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n" +
            "C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n" +
            "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n" +
            "F1: A♠\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠\n" +
            "C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n" +
            "C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n" +
            "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n" +
            "F1: A♠\n" +
            "F2: A♦\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠\n" +
            "C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n" +
            "C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦\n" +
            "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n" +
            "F1: A♠\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♦\n" +
            "C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n" +
            "C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦\n" +
            "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣";

    Readable re = new StringReader("C1 13 F1 C3 13 F2 F2 1 C1");
    Appendable ap = new StringBuffer("");
    Collections.reverse(deck);
    FreecellController controller = new FreecellController(re, ap);
    controller.playGame(deck, multi, 4, 4, false);
    assertEquals(s, ap.toString());
  }

  /**
   * Test for moving one card from Foundation to Cascade.
   */
  @Test
  public void testMultiMoveFTCas() {
    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n" +
            "C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n" +
            "C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n" +
            "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n" +
            "F1: A♠\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠\n" +
            "C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n" +
            "C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n" +
            "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n" +
            "F1: A♠, 2♠\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠\n" +
            "C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n" +
            "C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n" +
            "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n" +
            "F1: A♠, 2♠\n" +
            "F2: A♥\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠\n" +
            "C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥\n" +
            "C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n" +
            "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n" +
            "Invalid move. Try again.Invalid cardIndex from Foundations Pile";

    Readable re = new StringReader("C1 13 F1 C1 12 F1 C2 13 F2 F1 1 C2");
    Appendable ap = new StringBuffer("");
    Collections.reverse(deck);
    FreecellController controller = new FreecellController(re, ap);
    controller.playGame(deck, multi, 4, 4, false);
    assertEquals(s, ap.toString());
  }


  /**
   * Test for invalid moving one card from Foundation to Cascade.
   */
  @Test
  public void testInvalidOneMoveFTCas() {
    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, K♦, Q♠, Q♥\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♣, Q♣, K♣\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♦, Q♦, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, J♥, K♠\n" +
            "Invalid move. Try again.Invalid movement from Foundation Pile.";

    List<Card> deck1 = new ArrayList<Card>(Arrays.asList(c1, d1, h1, s1,
            c2, d2, h2, s2,
            c3, d3, h3, s3,
            c4, d4, h4, s4,
            c5, d5, h5, s5,
            c6, d6, h6, s6,
            c7, d7, h7, s7,
            c8, d8, h8, s8,
            c9, d9, h9, s9,
            c10, d10, h10, s10,
            d13, c11, d11, s11,
            s12, c12, d12, h11,
            h12, c13, h13, s13));
    Readable re = new StringReader("F1 13 C1");
    Appendable ap = new StringBuffer("");
    FreecellController controller = new FreecellController(re, ap);
    controller.playGame(deck1, multi, 4, 4, false);
    assertEquals(s, ap.toString());
  }


  //------------------- intermediate ---------------------

  /**
   * Test for Invalid moving because of less empty opens piles with no empty cascade.
   */
  @Test
  public void testInvalidMoveNoCasLessOpens() {
    List<Card> deck1 = new ArrayList<Card>(Arrays.asList(c1, d1, h1, s1,
            c2, d2, h2, s2,
            c3, d3, h3, s3,
            c4, d4, h4, s4,
            c5, d5, h5, s5,
            c6, d6, h6, s6,
            c7, d7, h7, s7,
            c8, d8, h8, d13,
            s12, c9, h9, s9,
            h11, d10, h10, s10,
            c10, c11, d11, s11,
            d9, c12, d12, h12,
            s8, c13, h13, s13));

    String s =
            "F1:\n" +
                    "F2:\n" +
                    "F3:\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, Q♠, J♥, 10♣, 9♦, 8♠\n" +
                    "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♣, 10♦, J♣, Q♣, K♣\n" +
                    "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♦, Q♦, K♥\n" +
                    "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, K♦, 9♠, 10♠, J♠, Q♥, K♠\n" +
                    "Invalid move. Try again.Lack of space.";
    Readable re = new StringReader("C1 9 C3");
    Appendable ap = new StringBuffer("");
    FreecellController controller = new FreecellController(re, ap);
    controller.playGame(deck1, multi, 4, 1, false);
    assertEquals(s, ap.toString());
  }

  /**
   * Test for Invalid moving because of no empty opens piles or no empty cascade.
   */
  @Test
  public void testInvalidMoveNoCasNoOpens() {
    List<Card> deck1 = new ArrayList<Card>(Arrays.asList(c1, d1, h1, s1,
            c2, d2, h2, s2,
            c3, d3, h3, s3,
            c4, d4, h4, s4,
            c5, d5, h5, s5,
            c6, d6, h6, s6,
            c7, d7, h7, s7,
            c8, d8, h8, d13,
            s12, c9, h9, s9,
            h11, d10, h10, s10,
            c10, c11, d11, s11,
            d9, c12, d12, h12,
            s8, c13, h13, s13));

    Readable re = new StringReader("C4 13 O1 C1 9 C3");
    Appendable ap = new StringBuffer("");
    FreecellController controller = new FreecellController(re, ap);
    controller.playGame(deck1, multi, 4, 1, false);
    assertEquals("F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, Q♠, J♥, 10♣, 9♦, 8♠\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♣, 10♦, J♣, Q♣, K♣\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♦, Q♦, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, K♦, 9♠, 10♠, J♠, Q♥, K♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: K♠\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, Q♠, J♥, 10♣, 9♦, 8♠\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♣, 10♦, J♣, Q♣, K♣\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♦, Q♦, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, K♦, 9♠, 10♠, J♠, Q♥\n" +
            "Invalid move. Try again.Lack of space.", ap.toString());
  }

  /**
   * Test for Invalid moving because of no empty opens piles with some empty cascade.
   */
  @Test
  public void testInvalidMoveNoOpenSomeCasecade() {
    List<Card> deck1 = new ArrayList<Card>(Arrays.asList(c1, d1, h1, s1,
            c2, d2, h2, s2,
            c3, d3, h3, s3,
            c4, d4, h4, s4,
            c5, d5, h5, s5,
            c6, d6, h6, s6,
            c7, d7, h7, s7,
            c8, d8, h8, d13,
            s12, c9, h9, s9,
            h11, d10, h10, s10,
            c10, c11, d11, s11,
            d9, c12, d12, h12,
            s8, c13, h13, s13));

    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "C1: A♣, 6♣, 10♣\n" +
            "C2: A♦, 6♦, J♣\n" +
            "C3: A♥, 6♥, J♦\n" +
            "C4: A♠, 6♠, J♠\n" +
            "C5: 2♣, 7♣, 9♦\n" +
            "C6: 2♦, 7♦, Q♣\n" +
            "C7: 2♥, 7♥, Q♦\n" +
            "C8: 2♠, 7♠, Q♥\n" +
            "C9: 3♣, 8♣, 8♠\n" +
            "C10: 3♦, 8♦, K♣\n" +
            "C11: 3♥, 8♥, K♥\n" +
            "C12: 3♠, K♦, K♠\n" +
            "C13: 4♣, Q♠\n" +
            "C14: 4♦, 9♣\n" +
            "C15: 4♥, 9♥\n" +
            "C16: 4♠, 9♠\n" +
            "C17: 5♣, J♥\n" +
            "C18: 5♦, 10♦\n" +
            "C19: 5♥, 10♥\n" +
            "C20: 5♠, 10♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "C1: A♣, 6♣\n" +
            "C2: A♦, 6♦, J♣\n" +
            "C3: A♥, 6♥, J♦, 10♣\n" +
            "C4: A♠, 6♠, J♠\n" +
            "C5: 2♣, 7♣, 9♦\n" +
            "C6: 2♦, 7♦, Q♣\n" +
            "C7: 2♥, 7♥, Q♦\n" +
            "C8: 2♠, 7♠, Q♥\n" +
            "C9: 3♣, 8♣, 8♠\n" +
            "C10: 3♦, 8♦, K♣\n" +
            "C11: 3♥, 8♥, K♥\n" +
            "C12: 3♠, K♦, K♠\n" +
            "C13: 4♣, Q♠\n" +
            "C14: 4♦, 9♣\n" +
            "C15: 4♥, 9♥\n" +
            "C16: 4♠, 9♠\n" +
            "C17: 5♣, J♥\n" +
            "C18: 5♦, 10♦\n" +
            "C19: 5♥, 10♥\n" +
            "C20: 5♠, 10♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: 6♣\n" +
            "O2:\n" +
            "C1: A♣\n" +
            "C2: A♦, 6♦, J♣\n" +
            "C3: A♥, 6♥, J♦, 10♣\n" +
            "C4: A♠, 6♠, J♠\n" +
            "C5: 2♣, 7♣, 9♦\n" +
            "C6: 2♦, 7♦, Q♣\n" +
            "C7: 2♥, 7♥, Q♦\n" +
            "C8: 2♠, 7♠, Q♥\n" +
            "C9: 3♣, 8♣, 8♠\n" +
            "C10: 3♦, 8♦, K♣\n" +
            "C11: 3♥, 8♥, K♥\n" +
            "C12: 3♠, K♦, K♠\n" +
            "C13: 4♣, Q♠\n" +
            "C14: 4♦, 9♣\n" +
            "C15: 4♥, 9♥\n" +
            "C16: 4♠, 9♠\n" +
            "C17: 5♣, J♥\n" +
            "C18: 5♦, 10♦\n" +
            "C19: 5♥, 10♥\n" +
            "C20: 5♠, 10♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: 6♣\n" +
            "O2: A♣\n" +
            "C1:\n" +
            "C2: A♦, 6♦, J♣\n" +
            "C3: A♥, 6♥, J♦, 10♣\n" +
            "C4: A♠, 6♠, J♠\n" +
            "C5: 2♣, 7♣, 9♦\n" +
            "C6: 2♦, 7♦, Q♣\n" +
            "C7: 2♥, 7♥, Q♦\n" +
            "C8: 2♠, 7♠, Q♥\n" +
            "C9: 3♣, 8♣, 8♠\n" +
            "C10: 3♦, 8♦, K♣\n" +
            "C11: 3♥, 8♥, K♥\n" +
            "C12: 3♠, K♦, K♠\n" +
            "C13: 4♣, Q♠\n" +
            "C14: 4♦, 9♣\n" +
            "C15: 4♥, 9♥\n" +
            "C16: 4♠, 9♠\n" +
            "C17: 5♣, J♥\n" +
            "C18: 5♦, 10♦\n" +
            "C19: 5♥, 10♥\n" +
            "C20: 5♠, 10♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: 6♣\n" +
            "O2: A♣\n" +
            "C1:\n" +
            "C2: A♦, 6♦, J♣\n" +
            "C3: A♥, 6♥\n" +
            "C4: A♠, 6♠, J♠\n" +
            "C5: 2♣, 7♣, 9♦\n" +
            "C6: 2♦, 7♦, Q♣, J♦, 10♣\n" +
            "C7: 2♥, 7♥, Q♦\n" +
            "C8: 2♠, 7♠, Q♥\n" +
            "C9: 3♣, 8♣, 8♠\n" +
            "C10: 3♦, 8♦, K♣\n" +
            "C11: 3♥, 8♥, K♥\n" +
            "C12: 3♠, K♦, K♠\n" +
            "C13: 4♣, Q♠\n" +
            "C14: 4♦, 9♣\n" +
            "C15: 4♥, 9♥\n" +
            "C16: 4♠, 9♠\n" +
            "C17: 5♣, J♥\n" +
            "C18: 5♦, 10♦\n" +
            "C19: 5♥, 10♥\n" +
            "C20: 5♠, 10♠\n" +
            "Invalid move. Try again.Lack of space.";
    Readable re = new StringReader("C1 3 C3 C1 2 O1 C1 1 O2 C3 3 C6 C6 3 C11");
    Appendable ap = new StringBuffer("");
    FreecellController controller = new FreecellController(re, ap);
    controller.playGame(deck1, multi, 20, 2, false);
    assertEquals(s, ap.toString());
  }


  /**
   * Test for invalid moving because of no empty opens piles or empty cascade.
   */
  @Test
  public void testInvalidMoveNoOpenNoCasecade() {
    List<Card> deck1 = new ArrayList<Card>(Arrays.asList(c1, d1, h1, s1,
            c2, d2, h2, s2,
            c3, d3, h3, s3,
            c4, d4, h4, s4,
            c5, d5, h5, s5,
            c6, d6, h6, s6,
            c7, d7, h7, s7,
            c8, d8, h8, d13,
            s12, c9, h9, s9,
            h11, d10, h10, s10,
            c10, c11, d11, s11,
            d9, c12, d12, h12,
            s8, c13, h13, s13));

    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "C1: A♣, 3♥, 6♣, 8♥, 10♣, K♥\n" +
            "C2: A♦, 3♠, 6♦, K♦, J♣, K♠\n" +
            "C3: A♥, 4♣, 6♥, Q♠, J♦\n" +
            "C4: A♠, 4♦, 6♠, 9♣, J♠\n" +
            "C5: 2♣, 4♥, 7♣, 9♥, 9♦\n" +
            "C6: 2♦, 4♠, 7♦, 9♠, Q♣\n" +
            "C7: 2♥, 5♣, 7♥, J♥, Q♦\n" +
            "C8: 2♠, 5♦, 7♠, 10♦, Q♥\n" +
            "C9: 3♣, 5♥, 8♣, 10♥, 8♠\n" +
            "C10: 3♦, 5♠, 8♦, 10♠, K♣\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: 8♠\n" +
            "C1: A♣, 3♥, 6♣, 8♥, 10♣, K♥\n" +
            "C2: A♦, 3♠, 6♦, K♦, J♣, K♠\n" +
            "C3: A♥, 4♣, 6♥, Q♠, J♦\n" +
            "C4: A♠, 4♦, 6♠, 9♣, J♠\n" +
            "C5: 2♣, 4♥, 7♣, 9♥, 9♦\n" +
            "C6: 2♦, 4♠, 7♦, 9♠, Q♣\n" +
            "C7: 2♥, 5♣, 7♥, J♥, Q♦\n" +
            "C8: 2♠, 5♦, 7♠, 10♦, Q♥\n" +
            "C9: 3♣, 5♥, 8♣, 10♥\n" +
            "C10: 3♦, 5♠, 8♦, 10♠, K♣\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: 8♠\n" +
            "C1: A♣, 3♥, 6♣, 8♥, 10♣, K♥\n" +
            "C2: A♦, 3♠, 6♦, K♦, J♣, K♠\n" +
            "C3: A♥, 4♣, 6♥, Q♠\n" +
            "C4: A♠, 4♦, 6♠, 9♣, J♠\n" +
            "C5: 2♣, 4♥, 7♣, 9♥, 9♦\n" +
            "C6: 2♦, 4♠, 7♦, 9♠, Q♣, J♦\n" +
            "C7: 2♥, 5♣, 7♥, J♥, Q♦\n" +
            "C8: 2♠, 5♦, 7♠, 10♦, Q♥\n" +
            "C9: 3♣, 5♥, 8♣, 10♥\n" +
            "C10: 3♦, 5♠, 8♦, 10♠, K♣\n" +
            "Invalid move. Try again.Lack of space.";
    Readable re = new StringReader("C9 5 O1 C3 5 C6 C6 5 C1");
    Appendable ap = new StringBuffer("");
    FreecellController controller = new FreecellController(re, ap);
    controller.playGame(deck1, multi, 10, 1, false);
    assertEquals(s, ap.toString());
  }

  /**
   * Test for invalid moving with some empty opens piles with some empty cascade.
   */
  @Test
  public void testInvalidMoveWithOpenAndCasecade() {
    List<Card> deck1 = new ArrayList<Card>(Arrays.asList(c1, d1, h1, s1,
            c2, d2, h2, s2,
            c3, d3, h3, s3,
            c4, d4, h4, s4,
            c5, d5, h5, s5,
            c6, d6, h6, s6,
            c7, d7, h7, s7,
            c8, d8, h8, d13,
            s12, c9, h9, s9,
            h11, d10, h10, s10,
            c10, c11, d11, s11,
            d9, c12, d12, h12,
            s8, c13, h13, s13));

    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "C1: A♣, 6♣, 10♣\n" +
            "C2: A♦, 6♦, J♣\n" +
            "C3: A♥, 6♥, J♦\n" +
            "C4: A♠, 6♠, J♠\n" +
            "C5: 2♣, 7♣, 9♦\n" +
            "C6: 2♦, 7♦, Q♣\n" +
            "C7: 2♥, 7♥, Q♦\n" +
            "C8: 2♠, 7♠, Q♥\n" +
            "C9: 3♣, 8♣, 8♠\n" +
            "C10: 3♦, 8♦, K♣\n" +
            "C11: 3♥, 8♥, K♥\n" +
            "C12: 3♠, K♦, K♠\n" +
            "C13: 4♣, Q♠\n" +
            "C14: 4♦, 9♣\n" +
            "C15: 4♥, 9♥\n" +
            "C16: 4♠, 9♠\n" +
            "C17: 5♣, J♥\n" +
            "C18: 5♦, 10♦\n" +
            "C19: 5♥, 10♥\n" +
            "C20: 5♠, 10♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "C1: A♣, 6♣\n" +
            "C2: A♦, 6♦, J♣\n" +
            "C3: A♥, 6♥, J♦, 10♣\n" +
            "C4: A♠, 6♠, J♠\n" +
            "C5: 2♣, 7♣, 9♦\n" +
            "C6: 2♦, 7♦, Q♣\n" +
            "C7: 2♥, 7♥, Q♦\n" +
            "C8: 2♠, 7♠, Q♥\n" +
            "C9: 3♣, 8♣, 8♠\n" +
            "C10: 3♦, 8♦, K♣\n" +
            "C11: 3♥, 8♥, K♥\n" +
            "C12: 3♠, K♦, K♠\n" +
            "C13: 4♣, Q♠\n" +
            "C14: 4♦, 9♣\n" +
            "C15: 4♥, 9♥\n" +
            "C16: 4♠, 9♠\n" +
            "C17: 5♣, J♥\n" +
            "C18: 5♦, 10♦\n" +
            "C19: 5♥, 10♥\n" +
            "C20: 5♠, 10♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2: 6♣\n" +
            "O3:\n" +
            "C1: A♣\n" +
            "C2: A♦, 6♦, J♣\n" +
            "C3: A♥, 6♥, J♦, 10♣\n" +
            "C4: A♠, 6♠, J♠\n" +
            "C5: 2♣, 7♣, 9♦\n" +
            "C6: 2♦, 7♦, Q♣\n" +
            "C7: 2♥, 7♥, Q♦\n" +
            "C8: 2♠, 7♠, Q♥\n" +
            "C9: 3♣, 8♣, 8♠\n" +
            "C10: 3♦, 8♦, K♣\n" +
            "C11: 3♥, 8♥, K♥\n" +
            "C12: 3♠, K♦, K♠\n" +
            "C13: 4♣, Q♠\n" +
            "C14: 4♦, 9♣\n" +
            "C15: 4♥, 9♥\n" +
            "C16: 4♠, 9♠\n" +
            "C17: 5♣, J♥\n" +
            "C18: 5♦, 10♦\n" +
            "C19: 5♥, 10♥\n" +
            "C20: 5♠, 10♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2: 6♣\n" +
            "O3: A♣\n" +
            "C1:\n" +
            "C2: A♦, 6♦, J♣\n" +
            "C3: A♥, 6♥, J♦, 10♣\n" +
            "C4: A♠, 6♠, J♠\n" +
            "C5: 2♣, 7♣, 9♦\n" +
            "C6: 2♦, 7♦, Q♣\n" +
            "C7: 2♥, 7♥, Q♦\n" +
            "C8: 2♠, 7♠, Q♥\n" +
            "C9: 3♣, 8♣, 8♠\n" +
            "C10: 3♦, 8♦, K♣\n" +
            "C11: 3♥, 8♥, K♥\n" +
            "C12: 3♠, K♦, K♠\n" +
            "C13: 4♣, Q♠\n" +
            "C14: 4♦, 9♣\n" +
            "C15: 4♥, 9♥\n" +
            "C16: 4♠, 9♠\n" +
            "C17: 5♣, J♥\n" +
            "C18: 5♦, 10♦\n" +
            "C19: 5♥, 10♥\n" +
            "C20: 5♠, 10♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2: 6♣\n" +
            "O3: A♣\n" +
            "C1:\n" +
            "C2: A♦, 6♦, J♣\n" +
            "C3: A♥, 6♥\n" +
            "C4: A♠, 6♠, J♠\n" +
            "C5: 2♣, 7♣, 9♦\n" +
            "C6: 2♦, 7♦, Q♣, J♦, 10♣\n" +
            "C7: 2♥, 7♥, Q♦\n" +
            "C8: 2♠, 7♠, Q♥\n" +
            "C9: 3♣, 8♣, 8♠\n" +
            "C10: 3♦, 8♦, K♣\n" +
            "C11: 3♥, 8♥, K♥\n" +
            "C12: 3♠, K♦, K♠\n" +
            "C13: 4♣, Q♠\n" +
            "C14: 4♦, 9♣\n" +
            "C15: 4♥, 9♥\n" +
            "C16: 4♠, 9♠\n" +
            "C17: 5♣, J♥\n" +
            "C18: 5♦, 10♦\n" +
            "C19: 5♥, 10♥\n" +
            "C20: 5♠, 10♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2: 6♣\n" +
            "O3: A♣\n" +
            "C1:\n" +
            "C2: A♦, 6♦, J♣\n" +
            "C3: A♥, 6♥\n" +
            "C4: A♠, 6♠, J♠\n" +
            "C5: 2♣, 7♣, 9♦\n" +
            "C6: 2♦, 7♦, Q♣, J♦, 10♣, 9♥\n" +
            "C7: 2♥, 7♥, Q♦\n" +
            "C8: 2♠, 7♠, Q♥\n" +
            "C9: 3♣, 8♣, 8♠\n" +
            "C10: 3♦, 8♦, K♣\n" +
            "C11: 3♥, 8♥, K♥\n" +
            "C12: 3♠, K♦, K♠\n" +
            "C13: 4♣, Q♠\n" +
            "C14: 4♦, 9♣\n" +
            "C15: 4♥\n" +
            "C16: 4♠, 9♠\n" +
            "C17: 5♣, J♥\n" +
            "C18: 5♦, 10♦\n" +
            "C19: 5♥, 10♥\n" +
            "C20: 5♠, 10♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2: 6♣\n" +
            "O3: A♣\n" +
            "C1:\n" +
            "C2: A♦, 6♦, J♣\n" +
            "C3: A♥, 6♥\n" +
            "C4: A♠, 6♠, J♠\n" +
            "C5: 2♣, 7♣, 9♦\n" +
            "C6: 2♦, 7♦, Q♣, J♦, 10♣, 9♥, 8♠\n" +
            "C7: 2♥, 7♥, Q♦\n" +
            "C8: 2♠, 7♠, Q♥\n" +
            "C9: 3♣, 8♣\n" +
            "C10: 3♦, 8♦, K♣\n" +
            "C11: 3♥, 8♥, K♥\n" +
            "C12: 3♠, K♦, K♠\n" +
            "C13: 4♣, Q♠\n" +
            "C14: 4♦, 9♣\n" +
            "C15: 4♥\n" +
            "C16: 4♠, 9♠\n" +
            "C17: 5♣, J♥\n" +
            "C18: 5♦, 10♦\n" +
            "C19: 5♥, 10♥\n" +
            "C20: 5♠, 10♠\n" +
            "Invalid move. Try again.Lack of space.";
    Readable re = new StringReader("C1 3 C3 C1 2 O2 C1 1 O3 C3 3 C6 C15 2 C6 C9 3 C6 C6 3 C11");
    Appendable ap = new StringBuffer("");
    FreecellController controller = new FreecellController(re, ap);
    controller.playGame(deck1, multi, 20, 3, false);
    assertEquals(s, ap.toString());
  }


  /**
   * Test for moving wirh opens piles and empty cascade.
   */
  @Test
  public void testMoveWithOpenAndCasecade() {
    List<Card> deck1 = new ArrayList<Card>(Arrays.asList(c1, d1, h1, s1,
            c2, d2, h2, s2,
            c3, d3, h3, s3,
            c4, d4, h4, s4,
            c5, d5, h5, s5,
            c6, d6, h6, s6,
            c7, d7, h7, s7,
            c8, d8, h8, d13,
            s12, c9, h9, s9,
            h11, d10, h10, s10,
            c10, c11, d11, s11,
            d9, c12, d12, h12,
            s8, c13, h13, s13));

    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 6♣, 10♣\n" +
            "C2: A♦, 6♦, J♣\n" +
            "C3: A♥, 6♥, J♦\n" +
            "C4: A♠, 6♠, J♠\n" +
            "C5: 2♣, 7♣, 9♦\n" +
            "C6: 2♦, 7♦, Q♣\n" +
            "C7: 2♥, 7♥, Q♦\n" +
            "C8: 2♠, 7♠, Q♥\n" +
            "C9: 3♣, 8♣, 8♠\n" +
            "C10: 3♦, 8♦, K♣\n" +
            "C11: 3♥, 8♥, K♥\n" +
            "C12: 3♠, K♦, K♠\n" +
            "C13: 4♣, Q♠\n" +
            "C14: 4♦, 9♣\n" +
            "C15: 4♥, 9♥\n" +
            "C16: 4♠, 9♠\n" +
            "C17: 5♣, J♥\n" +
            "C18: 5♦, 10♦\n" +
            "C19: 5♥, 10♥\n" +
            "C20: 5♠, 10♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 6♣\n" +
            "C2: A♦, 6♦, J♣\n" +
            "C3: A♥, 6♥, J♦, 10♣\n" +
            "C4: A♠, 6♠, J♠\n" +
            "C5: 2♣, 7♣, 9♦\n" +
            "C6: 2♦, 7♦, Q♣\n" +
            "C7: 2♥, 7♥, Q♦\n" +
            "C8: 2♠, 7♠, Q♥\n" +
            "C9: 3♣, 8♣, 8♠\n" +
            "C10: 3♦, 8♦, K♣\n" +
            "C11: 3♥, 8♥, K♥\n" +
            "C12: 3♠, K♦, K♠\n" +
            "C13: 4♣, Q♠\n" +
            "C14: 4♦, 9♣\n" +
            "C15: 4♥, 9♥\n" +
            "C16: 4♠, 9♠\n" +
            "C17: 5♣, J♥\n" +
            "C18: 5♦, 10♦\n" +
            "C19: 5♥, 10♥\n" +
            "C20: 5♠, 10♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2: 6♣\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣\n" +
            "C2: A♦, 6♦, J♣\n" +
            "C3: A♥, 6♥, J♦, 10♣\n" +
            "C4: A♠, 6♠, J♠\n" +
            "C5: 2♣, 7♣, 9♦\n" +
            "C6: 2♦, 7♦, Q♣\n" +
            "C7: 2♥, 7♥, Q♦\n" +
            "C8: 2♠, 7♠, Q♥\n" +
            "C9: 3♣, 8♣, 8♠\n" +
            "C10: 3♦, 8♦, K♣\n" +
            "C11: 3♥, 8♥, K♥\n" +
            "C12: 3♠, K♦, K♠\n" +
            "C13: 4♣, Q♠\n" +
            "C14: 4♦, 9♣\n" +
            "C15: 4♥, 9♥\n" +
            "C16: 4♠, 9♠\n" +
            "C17: 5♣, J♥\n" +
            "C18: 5♦, 10♦\n" +
            "C19: 5♥, 10♥\n" +
            "C20: 5♠, 10♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2: 6♣\n" +
            "O3: A♣\n" +
            "O4:\n" +
            "C1:\n" +
            "C2: A♦, 6♦, J♣\n" +
            "C3: A♥, 6♥, J♦, 10♣\n" +
            "C4: A♠, 6♠, J♠\n" +
            "C5: 2♣, 7♣, 9♦\n" +
            "C6: 2♦, 7♦, Q♣\n" +
            "C7: 2♥, 7♥, Q♦\n" +
            "C8: 2♠, 7♠, Q♥\n" +
            "C9: 3♣, 8♣, 8♠\n" +
            "C10: 3♦, 8♦, K♣\n" +
            "C11: 3♥, 8♥, K♥\n" +
            "C12: 3♠, K♦, K♠\n" +
            "C13: 4♣, Q♠\n" +
            "C14: 4♦, 9♣\n" +
            "C15: 4♥, 9♥\n" +
            "C16: 4♠, 9♠\n" +
            "C17: 5♣, J♥\n" +
            "C18: 5♦, 10♦\n" +
            "C19: 5♥, 10♥\n" +
            "C20: 5♠, 10♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2: 6♣\n" +
            "O3: A♣\n" +
            "O4:\n" +
            "C1:\n" +
            "C2: A♦, 6♦, J♣\n" +
            "C3: A♥, 6♥\n" +
            "C4: A♠, 6♠, J♠\n" +
            "C5: 2♣, 7♣, 9♦\n" +
            "C6: 2♦, 7♦, Q♣, J♦, 10♣\n" +
            "C7: 2♥, 7♥, Q♦\n" +
            "C8: 2♠, 7♠, Q♥\n" +
            "C9: 3♣, 8♣, 8♠\n" +
            "C10: 3♦, 8♦, K♣\n" +
            "C11: 3♥, 8♥, K♥\n" +
            "C12: 3♠, K♦, K♠\n" +
            "C13: 4♣, Q♠\n" +
            "C14: 4♦, 9♣\n" +
            "C15: 4♥, 9♥\n" +
            "C16: 4♠, 9♠\n" +
            "C17: 5♣, J♥\n" +
            "C18: 5♦, 10♦\n" +
            "C19: 5♥, 10♥\n" +
            "C20: 5♠, 10♠";
    Readable re = new StringReader("C1 3 C3 C1 2 O2 C1 1 O3 C3 3 C6");
    Appendable ap = new StringBuffer("");
    FreecellController controller = new FreecellController(re, ap);
    controller.playGame(deck1, multi, 20, 4, false);
    assertEquals(s, ap.toString());
  }

  /**
   * Test for Invalid moving because of out of boundary source pile number.
   */
  @Test
  public void testInvalidMovePilenum() {
    List<Card> deck1 = new ArrayList<Card>(Arrays.asList(c1, d1, h1, s1,
            c2, d2, h2, s2,
            c3, d3, h3, s3,
            c4, d4, h4, s4,
            c5, d5, h5, s5,
            c6, d6, h6, s6,
            c7, d7, h7, s7,
            c8, d8, h8, d13,
            s12, c9, h9, s9,
            h11, d10, h10, s10,
            c10, c11, d11, s11,
            d9, c12, d12, h12,
            s8, c13, h13, s13));

    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, Q♠, J♥, 10♣, 9♦, 8♠\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♣, 10♦, J♣, Q♣, K♣\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♦, Q♦, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, K♦, 9♠, 10♠, J♠, Q♥, K♠\n" +
            "Invalid move. Try again.Out of Boundary.\n" +
            "Invalid move. Try again.Invalid Pile type.";
    Readable re = new StringReader("C5 9 C3");
    Appendable ap = new StringBuffer("");
    FreecellController controller = new FreecellController(re, ap);
    controller.playGame(deck1, multi, 4, 1, false);
    assertEquals(s, ap.toString());
  }


  /**
   * test for is Game Over.
   */
  @Test
  public void testGameOver3() {
    Collections.reverse(deck);
    StringBuffer out = new StringBuffer();
    String inputString = "";
    for (int i = 1; i < 5; i++) {
      for (int j = 13; j > 0; j--) {
        inputString = inputString + "C" + i + " " + j + " " + "F" + i + "\n";
      }
    }
    Readable in = new StringReader(inputString);
    FreecellController fc = new FreecellController(in, out);
    fc.playGame(deck, multi, 4, 4, false);
    assertEquals(true, (out.toString()).contains("Game over."));
  }
}