


import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cs3500.hw02.Card;
import cs3500.hw02.FreecellModel;
import cs3500.hw02.PileType;
import cs3500.hw02.Suit;
import cs3500.hw02.Value;

/**
 * A class is to test for Freecell model.
 */
public class FreecellModelTest {
  FreecellModel model = new FreecellModel();
  List<Card> deck = model.getDeck();

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
  Card d81 = new Card(Value.EIGHT, Suit.DIAMOND);

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

  FreecellModel modelNew = new FreecellModel();
  List<Card> deckNew = new ArrayList<Card>(Arrays.asList(c1, d1, h1, s1,
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

  /**
   * test for getdeck.
   */
  @Test
  public void testGetDeck() {
    assertEquals(true, deck.equals(deckNew));
  }

  /**
   * test for get deck.
   */
  @Test
  public void testGetDeck1() {
    assertEquals(true, deck.size() == 52);
  }

  /**
   * test for invalid startgame.
   */
  @Test
  public void testStartGame1() {
    deckNew.add(s1);
    try {
      model.startGame(deckNew, 5, 4, false);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid deck", e.getMessage());
    }
  }

  /**
   * test for invalid startgame and empty state.
   */
  @Test
  public void testEmptyState() {
    deckNew.add(s1);
    try {
      model.startGame(deckNew, 5, 4, false);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid deck", e.getMessage());
    }
    assertEquals("", model.getGameState());
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
            "C1: A♣, 2♦, 3♥, 4♠, 6♣, 7♦, 8♥, 9♠, J♣, Q♦, K♥\n" +
            "C2: A♦, 2♥, 3♠, 5♣, 6♦, 7♥, 8♠, 10♣, J♦, Q♥, K♠\n" +
            "C3: A♥, 2♠, 4♣, 5♦, 6♥, 7♠, 9♣, 10♦, J♥, Q♠\n" +
            "C4: A♠, 3♣, 4♦, 5♥, 6♠, 8♣, 9♦, 10♥, J♠, K♣\n" +
            "C5: 2♣, 3♦, 4♥, 5♠, 7♣, 8♦, 9♥, 10♠, Q♣, K♦";
    model.startGame(deckNew, 5, 4, false);
    model.startGame(deckNew, 5, 4, false);
    assertEquals(s, model.getGameState());
  }

  /**
   * test for InvalidStart game. less card and have duplicate card.
   */
  @Test
  public void testStartGame4() {
    deckNew.remove(0);
    deckNew.add(s2);
    try {
      model.startGame(deckNew, 5, 4, false);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid deck", e.getMessage());
    }
  }

  /**
   * test for Invalid numebr of Casecade Pile.
   */
  @Test
  public void testStartGame2() {
    try {
      model.startGame(deckNew, 0, 4, false);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid parameter", e.getMessage());
    }
  }

  /**
   * test for Invalid numbr of Open Pile.
   */
  @Test
  public void testStartGame3() {
    try {
      model.startGame(deckNew, 10, 0, false);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid parameter", e.getMessage());
    }
  }

  /**
   * test for shuffle, when it is different from not shuffled.
   */
  @Test
  public void testShuffled() {
    modelNew.startGame(deckNew, 4, 4, true);
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
    assertEquals(false, modelNew.getGameState().equals(shuffled));
  }

  /**
   * test for shuffle, when it is same as not shuffled.
   */
  @Test
  public void testNotShuffled() {
    modelNew.startGame(deckNew, 4, 4, false);
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
    assertEquals(true, modelNew.getGameState().equals(shufflNot));
  }

  /**
   * test for gameState.
   */
  @Test
  public void testGameState2() {
    modelNew.startGame(deckNew, 4, 4, false);
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
    assertEquals(false, modelNew.getGameState().equals(shufflNot));
  }

  /**
   * test for invalid movement form cascade to foundation.
   */
  @Test
  public void testMoveInvalidCTF1() {
    modelNew.startGame(deckNew, 52, 4, false);
    modelNew.move(PileType.CASCADE, 1, 0, PileType.FOUNDATION, 0);
    try {
      modelNew.move(PileType.CASCADE, 2, 0, PileType.FOUNDATION, 0);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid suit to move to Foundation Piles", e.getMessage());
    }
  }

  /**
   * test for invalid movement form cascade to foundation.
   */
  @Test
  public void testMoveInvalidCTF2() {
    modelNew.startGame(deckNew, 52, 4, false);
    modelNew.move(PileType.CASCADE, 1, 0, PileType.FOUNDATION, 0);
    try {
      modelNew.move(PileType.CASCADE, 9, 0, PileType.FOUNDATION, 0);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid value to move to Foundation Piles", e.getMessage());
    }
  }

  /**
   * test for invalid movement form cascade to foundation.
   */
  @Test
  public void testMoveInvalidCTF3() {
    modelNew.startGame(deckNew, 26, 10, false);
    try {
      modelNew.move(PileType.CASCADE, 2, 12, PileType.FOUNDATION, 1);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid cardIndex from Cascade Pile", e.getMessage());
    }
  }

  /**
   * test for movement form cascade to foundation.
   */
  @Test
  public void testMoveCTF1() {
    modelNew.startGame(deckNew, 52, 4, false);
    modelNew.move(PileType.CASCADE, 1, 0, PileType.FOUNDATION, 0);
    modelNew.move(PileType.CASCADE, 5, 0, PileType.FOUNDATION, 0);
    String s = "F1: A♦, 2♦\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣\n" +
            "C2:\n" +
            "C3: A♥\n" +
            "C4: A♠\n" +
            "C5: 2♣\n" +
            "C6:\n" +
            "C7: 2♥\n" +
            "C8: 2♠\n" +
            "C9: 3♣\n" +
            "C10: 3♦\n" +
            "C11: 3♥\n" +
            "C12: 3♠\n" +
            "C13: 4♣\n" +
            "C14: 4♦\n" +
            "C15: 4♥\n" +
            "C16: 4♠\n" +
            "C17: 5♣\n" +
            "C18: 5♦\n" +
            "C19: 5♥\n" +
            "C20: 5♠\n" +
            "C21: 6♣\n" +
            "C22: 6♦\n" +
            "C23: 6♥\n" +
            "C24: 6♠\n" +
            "C25: 7♣\n" +
            "C26: 7♦\n" +
            "C27: 7♥\n" +
            "C28: 7♠\n" +
            "C29: 8♣\n" +
            "C30: 8♦\n" +
            "C31: 8♥\n" +
            "C32: 8♠\n" +
            "C33: 9♣\n" +
            "C34: 9♦\n" +
            "C35: 9♥\n" +
            "C36: 9♠\n" +
            "C37: 10♣\n" +
            "C38: 10♦\n" +
            "C39: 10♥\n" +
            "C40: 10♠\n" +
            "C41: J♣\n" +
            "C42: J♦\n" +
            "C43: J♥\n" +
            "C44: J♠\n" +
            "C45: Q♣\n" +
            "C46: Q♦\n" +
            "C47: Q♥\n" +
            "C48: Q♠\n" +
            "C49: K♣\n" +
            "C50: K♦\n" +
            "C51: K♥\n" +
            "C52: K♠";
    assertEquals(true, modelNew.getGameState().equals(s));
  }

  /**
   * test for invalid movement form cascade to cascade.
   */
  @Test
  public void testMoveInvalidCTC1() {
    modelNew.startGame(deckNew, 4, 4, false);
    try {
      modelNew.move(PileType.CASCADE, 0, 12, PileType.CASCADE, 3);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid value between last card and added card", e.getMessage());
    }
  }

  /**
   * test for invalid movement form cascade to cascade.
   */
  @Test
  public void testMoveInvalidCTC2() {
    modelNew.startGame(deckNew, 4, 4, true);
    try {
      modelNew.move(PileType.CASCADE, 2, 12, PileType.CASCADE, 3);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid value between last card and added card", e.getMessage());
    }
  }

  /**
   * test for invalid movement form cascade to cascade.
   */
  @Test
  public void testMoveInvalidCTC3() {
    modelNew.startGame(deckNew, 4, 26, false);
    modelNew.move(PileType.CASCADE, 1, 12, PileType.OPEN, 0);
    try {
      modelNew.move(PileType.CASCADE, 1, 11, PileType.CASCADE, 2);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid suit between last card and added card", e.getMessage());
    }
  }

  /**
   * test for invalid movement form cascade to cascade.
   */
  @Test
  public void testMoveInvalidCTC4() {
    modelNew.startGame(deckNew, 4, 26, false);
    modelNew.move(PileType.CASCADE, 0, 12, PileType.OPEN, 0);
    try {
      modelNew.move(PileType.CASCADE, 0, 11, PileType.CASCADE, 3);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid suit between last card and added card", e.getMessage());
    }
  }

  /**
   * test for movement form cascade to cascade.
   */
  @Test
  public void testMoveCTC1() {
    modelNew.startGame(deckNew, 4, 26, false);
    modelNew.move(PileType.CASCADE, 0, 12, PileType.OPEN, 0);
    modelNew.move(PileType.CASCADE, 0, 11, PileType.CASCADE, 2);
    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: K♣\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "O5:\n" +
            "O6:\n" +
            "O7:\n" +
            "O8:\n" +
            "O9:\n" +
            "O10:\n" +
            "O11:\n" +
            "O12:\n" +
            "O13:\n" +
            "O14:\n" +
            "O15:\n" +
            "O16:\n" +
            "O17:\n" +
            "O18:\n" +
            "O19:\n" +
            "O20:\n" +
            "O21:\n" +
            "O22:\n" +
            "O23:\n" +
            "O24:\n" +
            "O25:\n" +
            "O26:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, Q♣\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠";
    assertEquals(true, modelNew.getGameState().equals(s));
  }

  /**
   * test for movement form cascade to cascade.
   */
  @Test
  public void testMoveCTC2() {
    modelNew.startGame(deckNew, 4, 26, false);
    modelNew.move(PileType.CASCADE, 1, 12, PileType.OPEN, 0);
    modelNew.move(PileType.CASCADE, 1, 11, PileType.CASCADE, 3);
    String s2 = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: K♦\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "O5:\n" +
            "O6:\n" +
            "O7:\n" +
            "O8:\n" +
            "O9:\n" +
            "O10:\n" +
            "O11:\n" +
            "O12:\n" +
            "O13:\n" +
            "O14:\n" +
            "O15:\n" +
            "O16:\n" +
            "O17:\n" +
            "O18:\n" +
            "O19:\n" +
            "O20:\n" +
            "O21:\n" +
            "O22:\n" +
            "O23:\n" +
            "O24:\n" +
            "O25:\n" +
            "O26:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠, Q♦";
    assertEquals(true, modelNew.getGameState().equals(s2));
  }

  /**
   * test for invalid movement form cascade to open.
   */
  @Test
  public void testMoveInvalidCTO1() {
    modelNew.startGame(deckNew, 4, 26, false);
    modelNew.move(PileType.CASCADE, 0, 12, PileType.OPEN, 0);
    try {
      modelNew.move(PileType.CASCADE, 0, 11, PileType.OPEN, 0);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid size of Open piles", e.getMessage());
    }
  }

  /**
   * test for movement form cascade to Open.
   */
  @Test
  public void testMoveCTO1() {
    modelNew.startGame(deckNew, 26, 26, false);
    modelNew.move(PileType.CASCADE, 0, 1, PileType.OPEN, 0);
    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: 7♥\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "O5:\n" +
            "O6:\n" +
            "O7:\n" +
            "O8:\n" +
            "O9:\n" +
            "O10:\n" +
            "O11:\n" +
            "O12:\n" +
            "O13:\n" +
            "O14:\n" +
            "O15:\n" +
            "O16:\n" +
            "O17:\n" +
            "O18:\n" +
            "O19:\n" +
            "O20:\n" +
            "O21:\n" +
            "O22:\n" +
            "O23:\n" +
            "O24:\n" +
            "O25:\n" +
            "O26:\n" +
            "C1: A♣\n" +
            "C2: A♦, 7♠\n" +
            "C3: A♥, 8♣\n" +
            "C4: A♠, 8♦\n" +
            "C5: 2♣, 8♥\n" +
            "C6: 2♦, 8♠\n" +
            "C7: 2♥, 9♣\n" +
            "C8: 2♠, 9♦\n" +
            "C9: 3♣, 9♥\n" +
            "C10: 3♦, 9♠\n" +
            "C11: 3♥, 10♣\n" +
            "C12: 3♠, 10♦\n" +
            "C13: 4♣, 10♥\n" +
            "C14: 4♦, 10♠\n" +
            "C15: 4♥, J♣\n" +
            "C16: 4♠, J♦\n" +
            "C17: 5♣, J♥\n" +
            "C18: 5♦, J♠\n" +
            "C19: 5♥, Q♣\n" +
            "C20: 5♠, Q♦\n" +
            "C21: 6♣, Q♥\n" +
            "C22: 6♦, Q♠\n" +
            "C23: 6♥, K♣\n" +
            "C24: 6♠, K♦\n" +
            "C25: 7♣, K♥\n" +
            "C26: 7♦, K♠";
    assertEquals(true, modelNew.getGameState().equals(s));
  }

  /**
   * test for movement form open to cascade.
   */
  @Test
  public void testMoveOTC1() {
    modelNew.startGame(deckNew, 52, 4, false);
    modelNew.move(PileType.CASCADE, 0, 0, PileType.OPEN, 0);
    modelNew.move(PileType.OPEN, 0, 0, PileType.CASCADE, 6);
    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1:\n" +
            "C2: A♦\n" +
            "C3: A♥\n" +
            "C4: A♠\n" +
            "C5: 2♣\n" +
            "C6: 2♦\n" +
            "C7: 2♥, A♣\n" +
            "C8: 2♠\n" +
            "C9: 3♣\n" +
            "C10: 3♦\n" +
            "C11: 3♥\n" +
            "C12: 3♠\n" +
            "C13: 4♣\n" +
            "C14: 4♦\n" +
            "C15: 4♥\n" +
            "C16: 4♠\n" +
            "C17: 5♣\n" +
            "C18: 5♦\n" +
            "C19: 5♥\n" +
            "C20: 5♠\n" +
            "C21: 6♣\n" +
            "C22: 6♦\n" +
            "C23: 6♥\n" +
            "C24: 6♠\n" +
            "C25: 7♣\n" +
            "C26: 7♦\n" +
            "C27: 7♥\n" +
            "C28: 7♠\n" +
            "C29: 8♣\n" +
            "C30: 8♦\n" +
            "C31: 8♥\n" +
            "C32: 8♠\n" +
            "C33: 9♣\n" +
            "C34: 9♦\n" +
            "C35: 9♥\n" +
            "C36: 9♠\n" +
            "C37: 10♣\n" +
            "C38: 10♦\n" +
            "C39: 10♥\n" +
            "C40: 10♠\n" +
            "C41: J♣\n" +
            "C42: J♦\n" +
            "C43: J♥\n" +
            "C44: J♠\n" +
            "C45: Q♣\n" +
            "C46: Q♦\n" +
            "C47: Q♥\n" +
            "C48: Q♠\n" +
            "C49: K♣\n" +
            "C50: K♦\n" +
            "C51: K♥\n" +
            "C52: K♠";
    assertEquals(true, modelNew.getGameState().equals(s));
  }

  /**
   * test for movement form foundaton to cascade.
   */
  @Test
  public void testMoveFTC1() {
    modelNew.startGame(deckNew, 52, 4, false);
    modelNew.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 0);
    modelNew.move(PileType.FOUNDATION, 0, 0, PileType.CASCADE, 5);
    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1:\n" +
            "C2: A♦\n" +
            "C3: A♥\n" +
            "C4: A♠\n" +
            "C5: 2♣\n" +
            "C6: 2♦, A♣\n" +
            "C7: 2♥\n" +
            "C8: 2♠\n" +
            "C9: 3♣\n" +
            "C10: 3♦\n" +
            "C11: 3♥\n" +
            "C12: 3♠\n" +
            "C13: 4♣\n" +
            "C14: 4♦\n" +
            "C15: 4♥\n" +
            "C16: 4♠\n" +
            "C17: 5♣\n" +
            "C18: 5♦\n" +
            "C19: 5♥\n" +
            "C20: 5♠\n" +
            "C21: 6♣\n" +
            "C22: 6♦\n" +
            "C23: 6♥\n" +
            "C24: 6♠\n" +
            "C25: 7♣\n" +
            "C26: 7♦\n" +
            "C27: 7♥\n" +
            "C28: 7♠\n" +
            "C29: 8♣\n" +
            "C30: 8♦\n" +
            "C31: 8♥\n" +
            "C32: 8♠\n" +
            "C33: 9♣\n" +
            "C34: 9♦\n" +
            "C35: 9♥\n" +
            "C36: 9♠\n" +
            "C37: 10♣\n" +
            "C38: 10♦\n" +
            "C39: 10♥\n" +
            "C40: 10♠\n" +
            "C41: J♣\n" +
            "C42: J♦\n" +
            "C43: J♥\n" +
            "C44: J♠\n" +
            "C45: Q♣\n" +
            "C46: Q♦\n" +
            "C47: Q♥\n" +
            "C48: Q♠\n" +
            "C49: K♣\n" +
            "C50: K♦\n" +
            "C51: K♥\n" +
            "C52: K♠";
    assertEquals(true, modelNew.getGameState().equals(s));
  }

  /**
   * test for invalid source of number pile.
   */
  @Test
  public void testMoveInvalidPileNum1() {
    modelNew.startGame(deckNew, 4, 26, false);
    try {
      modelNew.move(PileType.CASCADE, 5, 11, PileType.OPEN, 0);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid pile number", e.getMessage());
    }
  }

  /**
   * test for invalid movement of no card.
   */
  @Test
  public void testMoveInvalidmove1() {
    modelNew.startGame(deckNew, 54, 26, false);
    try {
      modelNew.move(PileType.CASCADE, 53, 0, PileType.OPEN, 0);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid movement from Cascade Pile.", e.getMessage());
    }
  }

  /**
   * test for invalid movement of wrong index.
   */
  @Test
  public void testMoveInvalidIndex1() {
    modelNew.startGame(deckNew, 52, 26, false);
    try {
      modelNew.move(PileType.CASCADE, 0, 01, PileType.OPEN, 0);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid cardIndex from Cascade Pile", e.getMessage());
    }
  }

  /**
   * test for invalid movement of wrong pile number.
   */
  @Test
  public void testMoveInvalidPileNum2() {
    modelNew.startGame(deckNew, 52, 26, false);
    try {
      modelNew.move(PileType.FOUNDATION, 5, 0, PileType.FOUNDATION, 5);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid pile number", e.getMessage());
    }
  }

  /**
   * test for invalid movement of no card.
   */
  @Test
  public void testMoveInvalidmove2() {
    modelNew.startGame(deckNew, 52, 26, false);
    modelNew.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 0);
    try {
      modelNew.move(PileType.FOUNDATION, 0, 1, PileType.OPEN, 0);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid cardIndex from Foundations Pile", e.getMessage());
    }
  }

  /**
   * test for invalid movement of wrong index.
   */
  @Test
  public void testMoveInvalidIndex2() {
    modelNew.startGame(deckNew, 52, 26, false);
    try {
      modelNew.move(PileType.FOUNDATION, 0, 1, PileType.OPEN, 0);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid movement from Foundation Pile.", e.getMessage());
    }
  }

  /**
   * test for invalid movement of wrong pile number.
   */
  @Test
  public void testMoveInvalidPileNum3() {
    modelNew.startGame(deckNew, 52, 2, false);
    try {
      modelNew.move(PileType.OPEN, 5, 0, PileType.FOUNDATION, 2);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid pile number", e.getMessage());
    }
  }

  /**
   * test for invalid movement of no card.
   */
  @Test
  public void testMoveInvalidmove3() {
    modelNew.startGame(deckNew, 52, 26, false);
    modelNew.move(PileType.CASCADE, 0, 0, PileType.OPEN, 0);
    try {
      modelNew.move(PileType.OPEN, 0, 1, PileType.OPEN, 2);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid cardIndex from Open Pile", e.getMessage());
    }
  }

  /**
   * test for invalid movement of no card.
   */
  @Test
  public void testMoveInvalidIndex3() {
    modelNew.startGame(deckNew, 52, 26, false);
    try {
      modelNew.move(PileType.OPEN, 0, 1, PileType.OPEN, 2);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid movement from Open Pile.", e.getMessage());
    }
  }

  /**
   * test for Start game twice.
   */
  @Test
  public void testStartTwice() {
    modelNew.startGame(deckNew, 4, 4, true);
    assertEquals(false, modelNew.isGameOver());
  }

  /**
   * test for not game over.
   */
  @Test
  public void testGameOverNot() {
    modelNew.startGame(deckNew, 4, 4, true);
    assertEquals(false, modelNew.isGameOver());
  }

  /**
   * test for is game over.
   */
  @Test
  public void isGameOver() {
    modelNew.startGame(deckNew, 52, 52, false);

    modelNew.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 0);
    modelNew.move(PileType.CASCADE, 1, 0, PileType.FOUNDATION, 1);
    modelNew.move(PileType.CASCADE, 2, 0, PileType.FOUNDATION, 2);
    modelNew.move(PileType.CASCADE, 3, 0, PileType.FOUNDATION, 3);
    modelNew.move(PileType.CASCADE, 4, 0, PileType.FOUNDATION, 0);
    modelNew.move(PileType.CASCADE, 5, 0, PileType.FOUNDATION, 1);
    modelNew.move(PileType.CASCADE, 6, 0, PileType.FOUNDATION, 2);
    modelNew.move(PileType.CASCADE, 7, 0, PileType.FOUNDATION, 3);
    modelNew.move(PileType.CASCADE, 8, 0, PileType.FOUNDATION, 0);
    modelNew.move(PileType.CASCADE, 9, 0, PileType.FOUNDATION, 1);
    modelNew.move(PileType.CASCADE, 10, 0, PileType.FOUNDATION, 2);
    modelNew.move(PileType.CASCADE, 11, 0, PileType.FOUNDATION, 3);
    modelNew.move(PileType.CASCADE, 12, 0, PileType.FOUNDATION, 0);
    modelNew.move(PileType.CASCADE, 13, 0, PileType.FOUNDATION, 1);
    modelNew.move(PileType.CASCADE, 14, 0, PileType.FOUNDATION, 2);
    modelNew.move(PileType.CASCADE, 15, 0, PileType.FOUNDATION, 3);
    modelNew.move(PileType.CASCADE, 16, 0, PileType.FOUNDATION, 0);
    modelNew.move(PileType.CASCADE, 17, 0, PileType.FOUNDATION, 1);
    modelNew.move(PileType.CASCADE, 18, 0, PileType.FOUNDATION, 2);
    modelNew.move(PileType.CASCADE, 19, 0, PileType.FOUNDATION, 3);
    modelNew.move(PileType.CASCADE, 20, 0, PileType.FOUNDATION, 0);
    modelNew.move(PileType.CASCADE, 21, 0, PileType.FOUNDATION, 1);
    modelNew.move(PileType.CASCADE, 22, 0, PileType.FOUNDATION, 2);
    modelNew.move(PileType.CASCADE, 23, 0, PileType.FOUNDATION, 3);
    modelNew.move(PileType.CASCADE, 24, 0, PileType.FOUNDATION, 0);
    modelNew.move(PileType.CASCADE, 25, 0, PileType.FOUNDATION, 1);
    modelNew.move(PileType.CASCADE, 26, 0, PileType.FOUNDATION, 2);
    modelNew.move(PileType.CASCADE, 27, 0, PileType.FOUNDATION, 3);
    modelNew.move(PileType.CASCADE, 28, 0, PileType.FOUNDATION, 0);
    modelNew.move(PileType.CASCADE, 29, 0, PileType.FOUNDATION, 1);
    modelNew.move(PileType.CASCADE, 30, 0, PileType.FOUNDATION, 2);
    modelNew.move(PileType.CASCADE, 31, 0, PileType.FOUNDATION, 3);
    modelNew.move(PileType.CASCADE, 32, 0, PileType.FOUNDATION, 0);
    modelNew.move(PileType.CASCADE, 33, 0, PileType.FOUNDATION, 1);
    modelNew.move(PileType.CASCADE, 34, 0, PileType.FOUNDATION, 2);
    modelNew.move(PileType.CASCADE, 35, 0, PileType.FOUNDATION, 3);
    modelNew.move(PileType.CASCADE, 36, 0, PileType.FOUNDATION, 0);
    modelNew.move(PileType.CASCADE, 37, 0, PileType.FOUNDATION, 1);
    modelNew.move(PileType.CASCADE, 38, 0, PileType.FOUNDATION, 2);
    modelNew.move(PileType.CASCADE, 39, 0, PileType.FOUNDATION, 3);
    modelNew.move(PileType.CASCADE, 40, 0, PileType.FOUNDATION, 0);
    modelNew.move(PileType.CASCADE, 41, 0, PileType.FOUNDATION, 1);
    modelNew.move(PileType.CASCADE, 42, 0, PileType.FOUNDATION, 2);
    modelNew.move(PileType.CASCADE, 43, 0, PileType.FOUNDATION, 3);
    modelNew.move(PileType.CASCADE, 44, 0, PileType.FOUNDATION, 0);
    modelNew.move(PileType.CASCADE, 45, 0, PileType.FOUNDATION, 1);
    modelNew.move(PileType.CASCADE, 46, 0, PileType.FOUNDATION, 2);
    modelNew.move(PileType.CASCADE, 47, 0, PileType.FOUNDATION, 3);
    modelNew.move(PileType.CASCADE, 48, 0, PileType.FOUNDATION, 0);
    modelNew.move(PileType.CASCADE, 49, 0, PileType.FOUNDATION, 1);
    modelNew.move(PileType.CASCADE, 50, 0, PileType.FOUNDATION, 2);
    modelNew.move(PileType.CASCADE, 51, 0, PileType.FOUNDATION, 3);

    assertEquals(true, modelNew.isGameOver());
  }


}


