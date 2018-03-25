

import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import cs3500.hw02.Card;
import cs3500.hw02.FreecellModel;
import cs3500.hw02.Suit;
import cs3500.hw02.Value;
import cs3500.hw03.FreecellController;

import static org.junit.Assert.assertEquals;

/**
 * I added some new tests for quit.
 */

/**
 * A class to test for the Freecell.
 */
public class FreecellControllerTest {
  FreecellModel model = new FreecellModel();
  private List deck = model.getDeck();
  String notShuffled = "F1:\n"
          + "F2:\n"
          + "F3:\n"
          + "F4:\n"
          + "O1:\n"
          + "O2:\n"
          + "O3:\n"
          + "O4:\n"
          + "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
          + "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
          + "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
          + "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠";

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

  private List<Card> deckNew = new ArrayList<Card>(Arrays.asList(c1, d1, h1, s1,
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
   * test for out of boundary of destination pile number.
   */
  @Test
  public void testOutBoundDPI() {
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
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "Invalid move. Try again.Out of Boundary.";
    Reader in = new StringReader("C1 13 O5");
    StringBuffer out = new StringBuffer();
    FreecellController controller = new FreecellController(in, out);
    controller.playGame(deckNew, model, 4, 4, false);
    assertEquals(s, out.toString());
  }


  /**
   * test for start game twice.
   */
  @Test
  public void testStartGameTwice() {
    FreecellModel m1 = new FreecellModel();
    List deckm1 = m1.getDeck();
    m1.startGame(deckm1, 4, 4, false);
    m1.startGame(deckm1, 4, 4, false);
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
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "Invalid move. Try again.Out of Boundary.";
    Reader in = new StringReader("C1 13 O5");
    StringBuffer out = new StringBuffer();
    FreecellController controller = new FreecellController(in, out);
    controller.playGame(deckm1, m1, 4, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * A test for Invalid suit to move to Foundation Piles.
   */
  @Test
  public void testInvalidToF4() {
    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣\n" +
            "C2: A♦\n" +
            "C3: A♥\n" +
            "C4: A♠\n" +
            "C5: 2♣\n" +
            "C6: 2♦\n" +
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
            "C52: K♠\n" +
            "F1: A♣\n" +
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
            "C52: K♠\n" +
            "Invalid move. Try again.Invalid suit to move to Foundation Piles\n" +
            "F1: A♣\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1:\n" +
            "C2:\n" +
            "C3: A♥\n" +
            "C4: A♠\n" +
            "C5: 2♣\n" +
            "C6: 2♦\n" +
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
    Reader in = new StringReader("C1 1 F1 C2 1 F1");
    StringBuffer out = new StringBuffer();
    FreecellController controller = new FreecellController(in, out);
    controller.playGame(deckNew, model, 52, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * A test for Invalid size of Open piles.
   */
  @Test
  public void testInvalidSizeOfOpen() {
    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: K♣\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "Invalid move. Try again.Invalid size of Open piles\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: K♣\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠";
    Reader in = new StringReader("C1 13 O1 C1 12 O1");
    StringBuffer out = new StringBuffer();
    FreecellController controller = new FreecellController(in, out);
    controller.playGame(deckNew, model, 4, 1, false);
    assertEquals(s, out.toString());
  }


  /**
   * A test for Invalid suit between last card and added card.
   */
  @Test
  public void testInvalidToaddedCard() {
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
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: K♣\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "Invalid move. Try again.Invalid suit between last card and added card\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: K♣\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠";
    Reader in = new StringReader("C1 13 O1 C1 12 C4");
    StringBuffer out = new StringBuffer();
    FreecellController controller = new FreecellController(in, out);
    controller.playGame(deckNew, model, 4, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * A test for Invalid Destination that the pile number is out of boundary.
   */
  @Test
  public void testInvalidDes() {
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
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "Invalid move. Try again.Out of Boundary.";
    Reader in = new StringReader("C1 13 O0");
    StringBuffer out = new StringBuffer();
    FreecellController controller = new FreecellController(in, out);
    controller.playGame(deckNew, model, 4, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * test for an invalid deck when it lose one card.
   */
  @Test
  public void testInvalidDeck1() {
    deckNew.remove(s13);
    Reader in = new StringReader("");
    StringBuffer out = new StringBuffer();
    FreecellController controller = new FreecellController(in, out);
    controller.playGame(deckNew, model, 4, 4, true);
    assertEquals("Could not start game.", out.toString());
  }

  /**
   * test for play game twice with no shuffle.
   */
  @Test
  public void testPlay2Time() {
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
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠F1:\n" +
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
    Reader in = new StringReader("");
    StringBuffer out = new StringBuffer();
    FreecellController controller = new FreecellController(in, out);
    controller.playGame(deckNew, model, 4, 4, false);
    controller.playGame(deckNew, model, 4, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * test for play game twice with shuffle.
   */
  @Test
  public void testPlay2TimeS() {
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
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠F1:\n" +
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
    Reader in = new StringReader("");
    StringBuffer out = new StringBuffer();
    FreecellController controller = new FreecellController(in, out);
    controller.playGame(deckNew, model, 4, 4, false);
    controller.playGame(deckNew, model, 4, 4, true);
    assertEquals(false, out.toString().equals(s));
  }

  /**
   * test for an invalid deck when it has extra card.
   */
  @Test
  public void testInvalidDeck2() {
    deckNew.add(c2);
    Reader in = new StringReader("");
    StringBuffer out = new StringBuffer();
    FreecellController controller = new FreecellController(in, out);
    controller.playGame(deckNew, model, 4, 4, true);
    assertEquals("Could not start game.", out.toString());
  }

  /**
   * test for an invalid pile number.
   */
  @Test
  public void testInvalidPileNum() {
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
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "Invalid move. Try again.Invalid pile number.\n" +
            "Invalid move. Try again.Invalid Pile type.";
    Reader in = new StringReader("Cw 12 O1");
    StringBuffer out = new StringBuffer();
    FreecellController controller = new FreecellController(in, out);
    controller.playGame(deckNew, model, 4, 4, false);
    assertEquals(s, out.toString());
  }


  /**
   * test for an invalid Cascade pile number.
   */
  @Test
  public void testInvalidPileNum1() {
    Reader in = new StringReader("");
    StringBuffer out = new StringBuffer();
    FreecellController controller = new FreecellController(in, out);
    controller.playGame(deck, model, 1, 4, true);
    assertEquals("Could not start game.", out.toString());
  }

  /**
   * test for an invalid card Index.
   */
  @Test
  public void testInvalidCardInx() {
    Reader in = new StringReader("C1 s2 F1");
    StringBuffer out = new StringBuffer();
    FreecellController controller = new FreecellController(in, out);
    controller.playGame(deck, model, 1, 4, true);
    assertEquals("Could not start game.", out.toString());
  }

  /**
   * test for an Open pile number.
   */
  @Test
  public void testInvalidPileNum2() {
    Reader in = new StringReader("");
    StringBuffer out = new StringBuffer();
    FreecellController controller = new FreecellController(in, out);
    controller.playGame(deck, model, 4, -4, true);
    assertEquals("Could not start game.", out.toString());
  }

  /**
   * test for the playGame when it is shuffled.
   */
  @Test
  public void testShuffleFormController1() {
    Reader in = new StringReader("");
    StringBuffer out = new StringBuffer();
    FreecellController controller = new FreecellController(in, out);
    controller.playGame(deck, model, 4, 4, true);
    assertEquals(false, out.toString().equals(notShuffled
            + "Invalid move. Try again. Invalid Input"));

  }

  /**
   * test for playGame when it is not shuffled.
   */
  @Test
  public void testNotShuffleFormController2() {
    Reader in = new StringReader("");
    StringBuffer out = new StringBuffer();
    FreecellController controller = new FreecellController(in, out);
    controller.playGame(deck, model, 4, 4, false);
    assertEquals(true, out.toString().equals(notShuffled));
  }

  /**
   * test for an IllgalStateException when the readable is null.
   */
  @Test(expected = IllegalStateException.class)
  public void testInvalidInput() {
    StringBuffer out = new StringBuffer();
    FreecellController controller1 = new FreecellController(null, out);
  }

  /**
   * test for an IllgalStateException when the appendable is null.
   */
  @Test(expected = IllegalStateException.class)
  public void testInvalidOutput() {
    Reader in = new StringReader("");
    FreecellController controller2 = new FreecellController(in, null);
  }

  /**
   * test for an IllgalStateException when the deck is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidDeck() {
    Reader in = new StringReader("");
    StringBuffer out = new StringBuffer();
    FreecellController controller = new FreecellController(in, out);
    controller.playGame(null, model, 4, 4, false);
  }

  /**
   * test for an IllgalStateException when the model is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidModel() {
    Reader in = new StringReader("");
    StringBuffer out = new StringBuffer();
    FreecellController controller = new FreecellController(in, out);
    controller.playGame(deck, null, 4, 4, false);
  }

  /**
   * test for quit "Q" after the move.
   */
  @Test
  public void testQuitQ() {
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
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2: K♣\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "Game quit prematurely.";
    Reader in = new StringReader("C1 13 O2 Q");
    StringBuffer out = new StringBuffer();
    FreecellController controller3 = new FreecellController(in, out);
    controller3.playGame(deck, model, 4, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * test for triple "Q".
   */
  @Test
  public void testTripleQuitQ() {
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
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "Invalid move. Try again.Invalid Pile type.";
    Reader in = new StringReader("QQQ");
    StringBuffer out = new StringBuffer();
    FreecellController controller3 = new FreecellController(in, out);
    controller3.playGame(deck, model, 4, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * test for quit "q" before move.
   */
  @Test
  public void testQuitq() {
    Reader in = new StringReader("q C1 13 O2");
    StringBuffer out = new StringBuffer();
    FreecellController controller4 = new FreecellController(in, out);
    controller4.playGame(deck, model, 4, 4, false);
    assertEquals(notShuffled + "\nGame quit prematurely.", out.toString());
  }

  /**
   * test for quit "q" in the move.
   */
  @Test
  public void testQuitqM() {
    Reader in = new StringReader(" C1 13 q O2");
    StringBuffer out = new StringBuffer();
    FreecellController controller4 = new FreecellController(in, out);
    controller4.playGame(deck, model, 4, 4, false);
    assertEquals(notShuffled + "\nGame quit prematurely.", out.toString());
  }

  /**
   * test for quit triple "q".
   */
  @Test
  public void testTripleq() {
    Reader in = new StringReader(" q q q O2");
    StringBuffer out = new StringBuffer();
    FreecellController controller4 = new FreecellController(in, out);
    controller4.playGame(deck, model, 4, 4, false);
    assertEquals(notShuffled + "\nGame quit prematurely.", out.toString());
  }

  /**
   * test for "Q" at fourth location.
   */
  @Test
  public void test1QuitAt4() {
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
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2: K♣\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "Game quit prematurely.";
    Reader in = new StringReader("C1 13 O2 q");
    StringBuffer out = new StringBuffer();
    FreecellController controller4 = new FreecellController(in, out);
    controller4.playGame(deck, model, 4, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * test for "q" at fourth location.
   */
  @Test
  public void test2QuitAt4() {
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
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "Invalid move. Try again.Invalid Pile type.\n" +
            "Game quit prematurely.";
    Reader in = new StringReader("dsaf Q");
    StringBuffer out = new StringBuffer();
    FreecellController controller4 = new FreecellController(in, out);
    controller4.playGame(deck, model, 4, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * test Invalid cascade number.
   */
  @Test
  public void testInvalidCasNum() {
    Reader in = new StringReader("c1 1 c3");
    StringBuffer out = new StringBuffer();
    FreecellController controller4 = new FreecellController(in, out);
    controller4.playGame(deck, model, 0, 4, false);
    assertEquals("Could not start game.", out.toString());
  }

  /**
   * test readable is "   ".
   */
  @Test
  public void testInvalidEmpty() {
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
    Reader in = new StringReader("   ");
    StringBuffer out = new StringBuffer();
    FreecellController controller4 = new FreecellController(in, out);
    controller4.playGame(deck, model, 4, 4, false);
    assertEquals(s, out.toString());

  }

  /**
   * test for repeated mistake.
   */
  @Test
  public void testRepeated() {
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
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "Invalid move. Try again.Invalid Pile type.\n" +
            "Invalid move. Try again.Invalid Pile type.\n" +
            "Invalid move. Try again.Invalid Pile type.";
    Reader in = new StringReader("v1 v1 v1");
    StringBuffer out = new StringBuffer();
    FreecellController controller4 = new FreecellController(in, out);
    controller4.playGame(deck, model, 4, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * test for invalid readable.
   */
  @Test
  public void testInvalidRe() {
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
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "Invalid move. Try again.Invalid Pile type.";
    Reader in = new StringReader("asdfasdfsd");
    StringBuffer out = new StringBuffer();
    FreecellController controller4 = new FreecellController(in, out);
    controller4.playGame(deck, model, 4, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * test for out of boundary card Index.
   */
  @Test
  public void testWaitCIndex1() {
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
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "Invalid move. Try again.Invalid Source\n" +
            "F1:\n" +
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
    Reader in = new StringReader("C1 23123123 O2");
    StringBuffer out = new StringBuffer();
    FreecellController controller4 = new FreecellController(in, out);
    controller4.playGame(deck, model, 4, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * test for Invalid cascade pile number. index equals to size.
   */
  @Test
  public void testInvalidCasNum2() {
    Reader in = new StringReader("c1 1 c3");
    StringBuffer out = new StringBuffer();
    FreecellController controller4 = new FreecellController(in, out);
    controller4.playGame(deck, model, 3, 4, false);
    assertEquals("Could not start game.", out.toString());

  }

  /**
   * test for Invalid open pile number. index equals to size.
   */
  @Test
  public void testInvalidOpenNum() {
    Reader in = new StringReader("c1 1 c3");
    StringBuffer out = new StringBuffer();
    FreecellController controller4 = new FreecellController(in, out);
    controller4.playGame(deck, model, 5, 0, false);
    assertEquals("Could not start game.", out.toString());

  }

  /**
   * test for Invalid open pile number. index equals to size.
   */
  @Test
  public void testInvalidOpenNum2() {
    Reader in = new StringReader("c1 1 c3");
    StringBuffer out = new StringBuffer();
    FreecellController controller4 = new FreecellController(in, out);
    controller4.playGame(deck, model, 5, -2, false);
    assertEquals("Could not start game.", out.toString());
  }

  /**
   * test for Invalid source piletype.
   */
  @Test
  public void testInvalidSource() {
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
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "Invalid move. Try again.Invalid Pile type.\n" +
            "Invalid move. Try again.Invalid Pile type.";
    Reader in = new StringReader("a2 13 O1");
    StringBuffer out = new StringBuffer();
    FreecellController controller4 = new FreecellController(in, out);
    controller4.playGame(deck, model, 4, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * test for Invalid source index.
   */
  @Test
  public void testInvalidSourceIndex() {
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
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "Invalid move. Try again.Out of Boundary.\n" +
            "Invalid move. Try again.Invalid Pile type.";
    Reader in = new StringReader("C5 10 C1");
    StringBuffer out = new StringBuffer();
    FreecellController controller4 = new FreecellController(in, out);
    controller4.playGame(deck, model, 4, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * test for Invalid card Index.
   */
  @Test
  public void testInvalidCardIndex1() {
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
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "Invalid move. Try again.Invalid Source\n" +
            "F1:\n" +
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
    Reader in = new StringReader("C2 20 C1");
    StringBuffer out = new StringBuffer();
    FreecellController controller4 = new FreecellController(in, out);
    controller4.playGame(deck, model, 4, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * test for Invalid cardIndex.
   */
  @Test
  public void testInvalidCardIndex2() {
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
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "Invalid move. Try again.Invalid Source\n" +
            "F1:\n" +
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
    Reader in = new StringReader("C2 202 C1");
    StringBuffer out = new StringBuffer();
    FreecellController controller4 = new FreecellController(in, out);
    controller4.playGame(deck, model, 4, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * test for Invalid move to foundation.
   */
  @Test
  public void testInvalidToF() {
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
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "Invalid move. Try again.Invalid top value to Foundation Pile\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠";
    Reader in = new StringReader("C2 13 F1");
    StringBuffer out = new StringBuffer();
    FreecellController controller4 = new FreecellController(in, out);
    controller4.playGame(deck, model, 4, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * test for invalid value to move to foundation piles.
   */
  @Test
  public void testInvalidToF12() {
    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣\n" +
            "C2: A♦\n" +
            "C3: A♥\n" +
            "C4: A♠\n" +
            "C5: 2♣\n" +
            "C6: 2♦\n" +
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
            "C52: K♠\n" +
            "F1: A♣\n" +
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
            "C52: K♠\n" +
            "Invalid move. Try again.Invalid value to move to Foundation Piles\n" +
            "F1: A♣\n" +
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
            "C7: 2♥\n" +
            "C8: 2♠\n" +
            "C9:\n" +
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
    Reader in = new StringReader("C1 1 F1 C9 1 F1");
    StringBuffer out = new StringBuffer();
    FreecellController controller4 = new FreecellController(in, out);
    controller4.playGame(deck, model, 52, 4, false);
    assertEquals(s, out.toString());
  }

  @Test
  public void testInvalidToO() {
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
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: K♦\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "Invalid move. Try again.Invalid size of Open piles\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: K♦\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠";
    Reader in = new StringReader("C2 13 O1 C4 13 O1");
    StringBuffer out = new StringBuffer();
    FreecellController controller4 = new FreecellController(in, out);
    controller4.playGame(deck, model, 4, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * test for Invalid move to cascade.
   */
  @Test
  public void testInvalidToC() {
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
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "Invalid move. Try again.Invalid value between last card and added card\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠";
    Reader in = new StringReader("C2 13 C3");
    StringBuffer out = new StringBuffer();
    FreecellController controller4 = new FreecellController(in, out);
    controller4.playGame(deck, model, 4, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * test for extra elements.
   */
  @Test
  public void testRedundent1() {
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
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "Invalid move. Try again.Invalid Pile type.\n" +
            "Invalid move. Try again.Invalid Source\n" +
            "F1:\n" +
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
    Reader in = new StringReader("2132 C2 12 C1");
    StringBuffer out = new StringBuffer();
    FreecellController controller4 = new FreecellController(in, out);
    controller4.playGame(deck, model, 4, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * test for extra two elements.
   */
  @Test
  public void testRedundent2() {
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
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "Invalid move. Try again.Invalid Pile type.\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: K♦\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "Invalid move. Try again.Invalid Pile type.";
    Reader in = new StringReader("2132 C2 13 O1 ee");
    StringBuffer out = new StringBuffer();
    FreecellController controller4 = new FreecellController(in, out);
    controller4.playGame(deck, model, 4, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * test for Invalid move from Opens.
   */
  @Test
  public void testExInMove1() {
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
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "Invalid move. Try again.Invalid Source\n" +
            "F1:\n" +
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
    Reader in = new StringReader("O1 13 C1");
    StringBuffer out = new StringBuffer();
    FreecellController controller4 = new FreecellController(in, out);
    controller4.playGame(deck, model, 4, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * test for Invalid destination type.
   */
  @Test
  public void testInvalidDestination() {
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
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "Invalid move. Try again.Invalid Pile type.";
    Reader in = new StringReader("C2 10 o1");
    StringBuffer out = new StringBuffer();
    FreecellController controller4 = new FreecellController(in, out);
    controller4.playGame(deck, model, 4, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * test for four elements.
   */
  @Test
  public void testfourNext() {
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
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: K♦\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "Invalid move. Try again.Invalid Pile type.";
    Reader in = new StringReader("C2 13 O1 de");
    StringBuffer out = new StringBuffer();
    FreecellController controller4 = new FreecellController(in, out);
    controller4.playGame(deck, model, 4, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * test for Invalid index.
   */
  @Test
  public void testInvaliDesIndex() {
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
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "Invalid move. Try again.Out of Boundary.";
    Reader in = new StringReader("C4 10 F6");
    StringBuffer out = new StringBuffer();
    FreecellController controller4 = new FreecellController(in, out);
    controller4.playGame(deck, model, 4, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * test for movement from cascade to cascade.
   */
  @Test
  public void testCToC() {
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
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4: K♠\n" +
            "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
            "C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
            "C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n" +
            "C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠";
    Reader in = new StringReader("C4 13 O4");
    StringBuffer out = new StringBuffer();
    FreecellController controller4 = new FreecellController(in, out);
    controller4.playGame(deck, model, 4, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * test for movement to foundation twice.
   */
  @Test
  public void test2Fondation() {
    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣\n" +
            "C2: A♦\n" +
            "C3: A♥\n" +
            "C4: A♠\n" +
            "C5: 2♣\n" +
            "C6: 2♦\n" +
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
            "C52: K♠\n" +
            "F1:\n" +
            "F2: A♣\n" +
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
            "C52: K♠\n" +
            "F1:\n" +
            "F2: A♣, 2♣\n" +
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
            "C5:\n" +
            "C6: 2♦\n" +
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
    Reader in = new StringReader("C1 1 F2 C5 1 F2");
    StringBuffer out = new StringBuffer();
    FreecellController controller5 = new FreecellController(in, out);
    controller5.playGame(deck, model, 52, 4, false);
    assertEquals(s, out.toString());

  }

  /**
   * test for movement from cascade to opens.
   */
  @Test
  public void testCToO() {
    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣\n" +
            "C2: A♦\n" +
            "C3: A♥\n" +
            "C4: A♠\n" +
            "C5: 2♣\n" +
            "C6: 2♦\n" +
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
            "C52: K♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2: A♣\n" +
            "O3:\n" +
            "O4:\n" +
            "C1:\n" +
            "C2: A♦\n" +
            "C3: A♥\n" +
            "C4: A♠\n" +
            "C5: 2♣\n" +
            "C6: 2♦\n" +
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
    Reader in = new StringReader("C1 1 O2");
    StringBuffer out = new StringBuffer();
    FreecellController controller5 = new FreecellController(in, out);
    controller5.playGame(deck, model, 52, 4, false);
    assertEquals(s, out.toString());

  }

  /**
   * test for movement from cascade to foundation.
   */
  @Test
  public void testCToF() {
    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣\n" +
            "C2: A♦\n" +
            "C3: A♥\n" +
            "C4: A♠\n" +
            "C5: 2♣\n" +
            "C6: 2♦\n" +
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
            "C52: K♠\n" +
            "F1:\n" +
            "F2: A♣\n" +
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
    Reader in = new StringReader("C1 1 F2");
    StringBuffer out = new StringBuffer();
    FreecellController controller5 = new FreecellController(in, out);
    controller5.playGame(deck, model, 52, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * test for movement from opens to foundation.
   */
  @Test
  public void testOToF() {
    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣\n" +
            "C2: A♦\n" +
            "C3: A♥\n" +
            "C4: A♠\n" +
            "C5: 2♣\n" +
            "C6: 2♦\n" +
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
            "C52: K♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2: A♣\n" +
            "O3:\n" +
            "O4:\n" +
            "C1:\n" +
            "C2: A♦\n" +
            "C3: A♥\n" +
            "C4: A♠\n" +
            "C5: 2♣\n" +
            "C6: 2♦\n" +
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
            "C52: K♠\n" +
            "F1: A♣\n" +
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
    Reader in = new StringReader("C1 1 O2 O2 1 F1");
    StringBuffer out = new StringBuffer();
    FreecellController controller5 = new FreecellController(in, out);
    controller5.playGame(deck, model, 52, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * test for movement from open to open.
   */
  @Test
  public void testOToO() {
    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣\n" +
            "C2: A♦\n" +
            "C3: A♥\n" +
            "C4: A♠\n" +
            "C5: 2♣\n" +
            "C6: 2♦\n" +
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
            "C52: K♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2: A♣\n" +
            "O3:\n" +
            "O4:\n" +
            "C1:\n" +
            "C2: A♦\n" +
            "C3: A♥\n" +
            "C4: A♠\n" +
            "C5: 2♣\n" +
            "C6: 2♦\n" +
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
            "C52: K♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: A♣\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1:\n" +
            "C2: A♦\n" +
            "C3: A♥\n" +
            "C4: A♠\n" +
            "C5: 2♣\n" +
            "C6: 2♦\n" +
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
    Reader inO = new StringReader("C1 1 O2 O2 1 O1");
    StringBuffer outO = new StringBuffer();
    FreecellController controller5 = new FreecellController(inO, outO);
    controller5.playGame(deck, model, 52, 4, false);
    assertEquals(s, outO.toString());
  }

  /**
   * test for movement from foundation to cascade.
   */
  @Test
  public void testFToC() {
    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣\n" +
            "C2: A♦\n" +
            "C3: A♥\n" +
            "C4: A♠\n" +
            "C5: 2♣\n" +
            "C6: 2♦\n" +
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
            "C52: K♠\n" +
            "F1: A♣\n" +
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
            "C52: K♠\n" +
            "F1:\n" +
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
    Reader in = new StringReader("C1 1 F1 F1 1 C6");
    StringBuffer out = new StringBuffer();
    FreecellController controller5 = new FreecellController(in, out);
    controller5.playGame(deck, model, 52, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * test for movement from open to cascade.
   */
  @Test
  public void testOToC() {
    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣\n" +
            "C2: A♦\n" +
            "C3: A♥\n" +
            "C4: A♠\n" +
            "C5: 2♣\n" +
            "C6: 2♦\n" +
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
            "C52: K♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: 3♣\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣\n" +
            "C2: A♦\n" +
            "C3: A♥\n" +
            "C4: A♠\n" +
            "C5: 2♣\n" +
            "C6: 2♦\n" +
            "C7: 2♥\n" +
            "C8: 2♠\n" +
            "C9:\n" +
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
            "C52: K♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2: 3♣\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣\n" +
            "C2: A♦\n" +
            "C3: A♥\n" +
            "C4: A♠\n" +
            "C5: 2♣\n" +
            "C6: 2♦\n" +
            "C7: 2♥\n" +
            "C8: 2♠\n" +
            "C9:\n" +
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
    Reader in = new StringReader("C9 1 O1 O1 1 O2");
    StringBuffer out = new StringBuffer();
    FreecellController controller5 = new FreecellController(in, out);
    controller5.playGame(deck, model, 52, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * test for movement from foundation to opens.
   */
  @Test
  public void testFToO() {
    String s = "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣\n" +
            "C2: A♦\n" +
            "C3: A♥\n" +
            "C4: A♠\n" +
            "C5: 2♣\n" +
            "C6: 2♦\n" +
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
            "C52: K♠\n" +
            "F1: A♣\n" +
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
            "C52: K♠\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2: A♣\n" +
            "O3:\n" +
            "O4:\n" +
            "C1:\n" +
            "C2: A♦\n" +
            "C3: A♥\n" +
            "C4: A♠\n" +
            "C5: 2♣\n" +
            "C6: 2♦\n" +
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
            "C52: K♠\n" +
            "F1:\n" +
            "F2: A♣\n" +
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
    Reader in = new StringReader("C1 1 F1 F1 1 O2 O2 1 F2");
    StringBuffer out = new StringBuffer();
    FreecellController controller5 = new FreecellController(in, out);
    controller5.playGame(deck, model, 52, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * test for is Game Over.
   */
  @Test
  public void testGameOver0() {
    model.startGame(model.getDeck(), 8, 4, false);
    List deck = model.getDeck();
    Collections.reverse(deck);

    StringBuffer out = new StringBuffer();
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
            "Game quit prematurely.";

    String inputString = "";
    for (int i = 1; i < 5; i++) {
      for (int j = 13; j > 0; j--) {
        inputString = inputString + "C" + i + " " + j + " " + "F" + i + "\n";
      }
    }

    Reader in = new StringReader("q " + inputString);
    FreecellModel fm = new FreecellModel();
    FreecellController fc = new FreecellController(in, out);
    fc.playGame(deck, fm, 4, 4, false);
    assertEquals(s, out.toString());
  }

  /**
   * test for is Game Over with "Q" after it.
   */
  @Test
  public void testGameOverwithQ() {
    model.startGame(model.getDeck(), 8, 4, false);
    List deck = model.getDeck();
    Collections.reverse(deck);

    StringBuffer out = new StringBuffer();
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
            "Game quit prematurely.";

    String inputString = "";
    for (int i = 1; i < 5; i++) {
      for (int j = 13; j > 0; j--) {
        inputString = inputString + "C" + i + " " + j + " " + "F" + i + "\n";
      }
    }

    Reader in = new StringReader(inputString + "Q");
    FreecellModel fm = new FreecellModel();
    FreecellController fc = new FreecellController(in, out);
    fc.playGame(deck, fm, 4, 4, false);
    assertEquals(true, fm.isGameOver());
    assertEquals(true, (out.toString()).contains("Game over."));
  }

  /**
   * test for is Game Over with "q" before it.
   */
  @Test
  public void testGameOver1() {
    model.startGame(model.getDeck(), 8, 4, false);
    List deck = model.getDeck();
    Collections.reverse(deck);

    StringBuffer out = new StringBuffer();
    String inputString = "";
    for (int i = 1; i < 5; i++) {
      for (int j = 13; j > 0; j--) {
        inputString = inputString + "C" + i + " " + j + " " + "F" + i + "\n";
      }
    }
    Reader in = new StringReader(inputString.concat("dafd"));
    FreecellModel fm = new FreecellModel();
    FreecellController fc = new FreecellController(in, out);
    fc.playGame(deck, fm, 4, 4, false);
    assertEquals(true, fm.isGameOver());
    assertEquals(true, (out.toString()).contains("Game over."));
  }

  /**
   * test for is not Game Over.
   */
  @Test
  public void testGameOver2() {
    model.startGame(model.getDeck(), 8, 4, false);
    List deck = model.getDeck();
    Collections.reverse(deck);

    StringBuffer out = new StringBuffer();
    String inputString = "";
    for (int i = 1; i < 5; i++) {
      for (int j = 13; j > 0; j--) {
        inputString = inputString + "C" + i + " " + j + " " + "F" + i + "\n";
      }
    }
    Reader in = new StringReader("C1 13 O1");
    FreecellModel fm = new FreecellModel();
    FreecellController fc = new FreecellController(in, out);
    fc.playGame(deck, fm, 4, 4, false);
    assertEquals(false, fm.isGameOver());
    assertEquals(false, (out.toString()).contains("Game over."));
  }

  /**
   * test for is Game Over.
   */
  @Test
  public void testGameOver3() {
    model.startGame(model.getDeck(), 8, 4, false);
    List deck = model.getDeck();
    Collections.reverse(deck);

    StringBuffer out = new StringBuffer();
    String inputString = "";
    for (int i = 1; i < 5; i++) {
      for (int j = 13; j > 0; j--) {
        inputString = inputString + "C" + i + " " + j + " " + "F" + i + "\n";
      }
    }
    Reader in = new StringReader(inputString);
    FreecellModel fm = new FreecellModel();
    FreecellController fc = new FreecellController(in, out);
    fc.playGame(deck, fm, 4, 4, false);
    assertEquals(true, fm.isGameOver());
    assertEquals(true, (out.toString()).contains("Game over."));
  }

  /**
   * test for Q in the cardIndex.
   */
  @Test
  public void testQuit() {
    Reader in = new StringReader("C1 q O2 O2 1 F1");
    StringBuffer out = new StringBuffer();
    FreecellController controller5 = new FreecellController(in, out);
    controller5.playGame(deck, model, 52, 4, false);
    assertEquals("F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣\n" +
            "C2: A♦\n" +
            "C3: A♥\n" +
            "C4: A♠\n" +
            "C5: 2♣\n" +
            "C6: 2♦\n" +
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
            "C52: K♠\n" +
            "Game quit prematurely.", out.toString());
  }

  /**
   * test for Q in the cardIndex.
   */
  @Test
  public void testQuitinDes() {
    Reader in = new StringReader("C1 12 q O2 1 F1");
    StringBuffer out = new StringBuffer();
    FreecellController controller5 = new FreecellController(in, out);
    controller5.playGame(deck, model, 52, 4, false);
    assertEquals("F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣\n" +
            "C2: A♦\n" +
            "C3: A♥\n" +
            "C4: A♠\n" +
            "C5: 2♣\n" +
            "C6: 2♦\n" +
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
            "C52: K♠\n" +
            "Game quit prematurely.", out.toString());
  }
}