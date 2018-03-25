


import org.junit.Test;

import cs3500.hw02.Value;

import static junit.framework.TestCase.assertEquals;

/**
 * A class to represents value.
 */
public class ValueTest {

  /**
   * test for the string of Value.ACE.
   */
  @Test
  public void TestToString1() {
    assertEquals("A", Value.ACE.toString());
  }

  /**
   * test for the string of Value.Four.
   */
  @Test
  public void TestToString2() {
    assertEquals("4", Value.FOUR.toString());
  }


}
