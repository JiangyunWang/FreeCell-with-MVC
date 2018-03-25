


import org.junit.Test;

import cs3500.hw02.Suit;

import static org.junit.Assert.assertEquals;

/**
 * A class to test suit.
 */
public class SuitTest {

  /**
   * test for the string of Suit.CLUB.
   */
  @Test
  public void texToString1() {
    assertEquals("♣", Suit.CLUB.toString());
  }

  /**
   * test for the string of Suit.DIAMOND.
   */
  @Test
  public void texToString2() {
    assertEquals("♦", Suit.DIAMOND.toString());
  }

  /**
   * test for the string of Suit.HEART.
   */
  @Test
  public void texToString3() {
    assertEquals("♥", Suit.HEART.toString());
  }

  /**
   * test for the string of Suit.SPADE.
   */
  @Test
  public void texToString4() {
    assertEquals("♠", Suit.SPADE.toString());
  }


}


