


import org.junit.Test;

import cs3500.hw02.Card;
import cs3500.hw02.Suit;
import cs3500.hw02.Value;

import static org.junit.Assert.assertEquals;

/**
 * A class to represents card Test.
 */
public class CardTest {


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

  /**
   * test for are the cards equal.
   */
  @Test
  public void testequals1() {
    assertEquals(true, d8.equals(d81));
  }

  /**
   * test for are the cards equal to different one.
   */
  @Test
  public void testequals2() {
    assertEquals(false, d9.equals(d1));
  }

  /**
   * test for are the cards equal to different one.
   */
  @Test
  public void testequals3() {
    assertEquals(false, d9.equals(h12));
  }

  /**
   * test for equallity of the two cards hashcode.
   */
  @Test
  public void testHashCode1() {
    assertEquals(true, d9.hashCode() == d8.hashCode());
  }

  /**
   * test for equallity of the two cards hashcode.
   */
  @Test
  public void testHashCode2() {
    assertEquals(false, d9.hashCode() == d1.hashCode());
  }

  /**
   * test for equallity of the two cards hashcode.
   */
  @Test
  public void testHashCode3() {
    assertEquals(false, d9.hashCode() == h12.hashCode());
  }

}
