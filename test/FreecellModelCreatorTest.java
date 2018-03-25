

import org.junit.Test;


import cs3500.hw02.FreecellModel;
import cs3500.hw04.FreecellModelCreator;
import cs3500.hw04.MultiFreecellModel;

import static org.junit.Assert.assertEquals;

/**
 * A Class is to test FreecellModelCreator.
 */
public class FreecellModelCreatorTest {

  FreecellModelCreator creator = new FreecellModelCreator();

  /**
   * test for the create to multimove Model.
   */
  @Test
  public void testCreatorToMulti() {
    assertEquals(true, creator.create(FreecellModelCreator.GameType.MULTIMOVE)
            instanceof MultiFreecellModel);
    assertEquals(true, creator.create(FreecellModelCreator.GameType.MULTIMOVE)
            instanceof FreecellModel);
  }

  /**
   * test for the create to singleMove Model.
   */
  @Test
  public void testCreatorToSingle() {
    assertEquals(false, creator.create(FreecellModelCreator.GameType.SINGLEMOVE)
            instanceof MultiFreecellModel);
    assertEquals(true, creator.create(FreecellModelCreator.GameType.SINGLEMOVE)
            instanceof FreecellModel);
  }

  /**
   * test for the create , if the paramter is null.
   */
  @Test(expected = NullPointerException.class)
  public void testCreatorIfNull() {
    try {
      assertEquals(false, creator.create(null) instanceof MultiFreecellModel);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid GameType.", e.getMessage());
    }

    try {
      assertEquals(false, creator.create(null) instanceof FreecellModel);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid GameType.", e.getMessage());
    }
  }
}
